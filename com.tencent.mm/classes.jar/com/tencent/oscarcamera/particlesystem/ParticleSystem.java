package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Pair;
import com.tencent.util.g;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class ParticleSystem
{
  private static final String TAG = ParticleSystem.class.getSimpleName();
  private long mAdvanceIndex = 0L;
  private List<ParticleCloud> mClouds = new ArrayList();
  private final Context mContext;
  private ArrayList<Particle> mCopiedParticles = new ArrayList();
  double[] mParamsPool;
  final Particle mPool = new Particle();
  private Random mRandom = new Random();
  private Map<Sprite, ParticleCloud> mSpriteMap = new HashMap();
  
  static
  {
    System.loadLibrary("ParticleSystem");
  }
  
  public ParticleSystem(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void createCache(int paramInt)
  {
    this.mParamsPool = new double[paramInt * 11];
    int i = 0;
    while (i < paramInt)
    {
      localObject = new Particle();
      ((Particle)localObject).param_offset = (i * 11);
      ((Particle)localObject).next = this.mPool.next;
      this.mPool.next = ((Particle)localObject);
      localObject = this.mPool;
      ((Particle)localObject).total += 1;
      i += 1;
    }
    Object localObject = this.mClouds.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ParticleCloud)((Iterator)localObject).next()).createCache();
    }
  }
  
  private void loadFinish()
  {
    Iterator localIterator = this.mClouds.iterator();
    ParticleCloud localParticleCloud;
    double d;
    for (int i = 0; localIterator.hasNext(); i = (int)(((Attribute)localParticleCloud.mAttrs.get("particleCountMax")).value() + d))
    {
      localParticleCloud = (ParticleCloud)localIterator.next();
      d = i;
    }
    createCache(i);
  }
  
  private void loadParticle(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      this.mClouds.add(null);
      paramString = this.mSpriteMap;
      throw new NullPointerException();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        g.i(TAG, paramString.getMessage());
      }
    }
  }
  
  private Particle obtainUnlocked()
  {
    if (this.mPool.next == null)
    {
      int i = 100;
      while (i > 0)
      {
        localParticle1 = new Particle();
        localParticle1.next = this.mPool.next;
        this.mPool.next = localParticle1;
        localParticle1 = this.mPool;
        localParticle1.total += 1;
        i -= 1;
      }
    }
    Particle localParticle1 = this.mPool.next;
    this.mPool.next = localParticle1.next;
    localParticle1.next = null;
    Particle localParticle2 = this.mPool;
    localParticle2.total -= 1;
    return localParticle1;
  }
  
  public static void releaseExpression(long[] paramArrayOfLong) {}
  
  public ArrayList<Particle> advance()
  {
    ArrayList localArrayList = new ArrayList();
    double d = System.currentTimeMillis() / 1000.0D;
    Iterator localIterator = this.mClouds.iterator();
    ParticleCloud localParticleCloud;
    if (localIterator.hasNext()) {
      localParticleCloud = (ParticleCloud)localIterator.next();
    }
    for (;;)
    {
      int i;
      synchronized (this.mPool)
      {
        Pair localPair = localParticleCloud.getAdvanceExpression(d);
        localParticleCloud.mResultBuffer.rewind();
        localParticleCloud.mResultBuffer.get(localParticleCloud.mResultArray);
        int k = localParticleCloud.mVarAttributes.length;
        i = 0;
        if (i < k)
        {
          Attribute localAttribute = localParticleCloud.mVarAttributes[i];
          int m = ((Particle)localPair.first).total;
          Particle localParticle1 = ((Particle)localPair.first).next;
          int j = 0;
          if (localParticle1 == null) {
            break label218;
          }
          localParticle1.a[localAttribute.mVarIndex] = localParticleCloud.mResultArray[(i * m + j)];
          localParticle1 = localParticle1.next;
          j += 1;
          continue;
        }
        localArrayList.add(localPair.first);
      }
      return localArrayList;
      label218:
      i += 1;
    }
  }
  
  public ArrayList<Particle> advanceAsync()
  {
    this.mCopiedParticles.clear();
    synchronized (this.mPool)
    {
      Iterator localIterator = this.mClouds.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (ParticleCloud)localIterator.next();
        this.mCopiedParticles.add(((ParticleCloud)localObject1).mCopiedParticles);
        Particle localParticle1 = ((ParticleCloud)localObject1).mCopiedParticles;
        localObject1 = ((ParticleCloud)localObject1).mParticles;
        localParticle1.total = ((Particle)localObject1).total;
        while (((Particle)localObject1).next != null)
        {
          localParticle1.next.copy(((Particle)localObject1).next);
          localParticle1 = localParticle1.next;
          localObject1 = ((Particle)localObject1).next;
        }
      }
      return this.mCopiedParticles;
    }
  }
  
  Particle advanceObtainUnlocked()
  {
    Particle localParticle = obtainUnlocked();
    int i = 0;
    while (i < 11)
    {
      this.mParamsPool[(localParticle.param_offset + i)] = Math.abs(this.mRandom.nextInt());
      i += 1;
    }
    return localParticle;
  }
  
  public void emitImmediately(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    Iterator localIterator = this.mClouds.iterator();
    for (;;)
    {
      ParticleCloud localParticleCloud;
      if (localIterator.hasNext())
      {
        localParticleCloud = (ParticleCloud)localIterator.next();
        if (localParticleCloud.mEmitRate != 0L) {
          continue;
        }
        if (localParticleCloud.mParticles.total >= localParticleCloud.mMaxCount) {
          String.format("max: %d, now %d, can't emit any more", new Object[] { Long.valueOf(localParticleCloud.mMaxCount), Integer.valueOf(localParticleCloud.mParticles.total) });
        }
      }
      else
      {
        return;
      }
      localParticleCloud.emitImmediately(paramDouble1, paramDouble2, paramDouble3);
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext()) {
      ((ParticleCloud)localIterator.next()).release();
    }
  }
  
  public List<Sprite> getSprites()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ParticleCloud)localIterator.next()).mSprite);
    }
    return localArrayList;
  }
  
  public void loadParticleData(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject1 = (String)paramList.next();
          if (!((String)localObject1).startsWith("/")) {
            break label137;
          }
          localObject1 = new BufferedReader(new InputStreamReader(new FileInputStream((String)localObject1)), 1024);
          localObject2 = new StringBuilder();
          String str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break label122;
          }
          ((StringBuilder)localObject2).append(str);
          continue;
        }
        if (localArrayList.isEmpty()) {
          break;
        }
      }
      catch (Exception paramList) {}
      loadParticles(localArrayList);
      return;
      label122:
      localArrayList.add(((StringBuilder)localObject2).toString());
      continue;
      label137:
      Object localObject1 = this.mContext.getAssets().open((String)localObject1);
      Object localObject2 = new byte[((InputStream)localObject1).available()];
      ((InputStream)localObject1).read((byte[])localObject2);
      localArrayList.add(new String((byte[])localObject2));
    }
  }
  
  public void loadParticles(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      loadParticle((String)paramList.next());
    }
    loadFinish();
  }
  
  void putUnlocked(Particle paramParticle)
  {
    paramParticle.next = this.mPool.next;
    this.mPool.next = paramParticle;
    paramParticle = this.mPool;
    paramParticle.total += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleSystem
 * JD-Core Version:    0.7.0.1
 */