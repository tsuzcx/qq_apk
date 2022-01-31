package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.util.i;
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
  private static final String TAG;
  private long mAdvanceIndex;
  private List<ParticleCloud> mClouds;
  private final Context mContext;
  private ArrayList<Particle> mCopiedParticles;
  double[] mParamsPool;
  final Particle mPool;
  private Random mRandom;
  private Map<Sprite, ParticleCloud> mSpriteMap;
  
  static
  {
    AppMethodBeat.i(81540);
    try
    {
      System.loadLibrary("ParticleSystem");
      TAG = ParticleSystem.class.getSimpleName();
      AppMethodBeat.o(81540);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        LogUtils.e(localUnsatisfiedLinkError);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        LogUtils.e(localRuntimeException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtils.e(localException);
      }
    }
  }
  
  public ParticleSystem(Context paramContext)
  {
    AppMethodBeat.i(81525);
    this.mRandom = new Random();
    this.mClouds = new ArrayList();
    this.mSpriteMap = new HashMap();
    this.mPool = new Particle();
    this.mAdvanceIndex = 0L;
    this.mCopiedParticles = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(81525);
  }
  
  public static long compile(String paramString)
  {
    AppMethodBeat.i(81538);
    long l = nativeCompile(paramString);
    AppMethodBeat.o(81538);
    return l;
  }
  
  private void createCache(int paramInt)
  {
    AppMethodBeat.i(81533);
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
    AppMethodBeat.o(81533);
  }
  
  private void loadFinish()
  {
    AppMethodBeat.i(81532);
    Iterator localIterator = this.mClouds.iterator();
    ParticleCloud localParticleCloud;
    double d;
    for (int i = 0; localIterator.hasNext(); i = (int)(((Attribute)localParticleCloud.mAttrs.get("particleCountMax")).value() + d))
    {
      localParticleCloud = (ParticleCloud)localIterator.next();
      d = i;
    }
    createCache(i);
    AppMethodBeat.o(81532);
  }
  
  private void loadParticle(String paramString)
  {
    AppMethodBeat.i(81531);
    try
    {
      paramString = new JSONObject(paramString);
      paramString = ParticleCloud.fromJson(this, paramString);
      this.mClouds.add(paramString);
      this.mSpriteMap.put(paramString.mSprite, paramString);
      AppMethodBeat.o(81531);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        i.n(TAG, paramString.getMessage());
        paramString = null;
      }
    }
  }
  
  public static native double[] nativeAdvance(long[] paramArrayOfLong, double[] paramArrayOfDouble, int[] paramArrayOfInt, int paramInt);
  
  public static native void nativeAdvanceEx(long[] paramArrayOfLong, double[] paramArrayOfDouble, int[] paramArrayOfInt, int paramInt, DoubleBuffer paramDoubleBuffer);
  
  public static native long nativeCompile(String paramString);
  
  public static native void nativeReleaseExpression(long[] paramArrayOfLong);
  
  private Particle obtainUnlocked()
  {
    AppMethodBeat.i(81527);
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
    AppMethodBeat.o(81527);
    return localParticle1;
  }
  
  public static void releaseExpression(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(81539);
    nativeReleaseExpression(paramArrayOfLong);
    AppMethodBeat.o(81539);
  }
  
  public ArrayList<Particle> advance()
  {
    AppMethodBeat.i(81535);
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
        nativeAdvanceEx(((ParticleExpressionBundle)localPair.second).expressions, this.mParamsPool, ((ParticleExpressionBundle)localPair.second).param_offsets, ((ParticleExpressionBundle)localPair.second).param_line, localParticleCloud.mResultBuffer);
        localParticleCloud.mResultBuffer.rewind();
        localParticleCloud.mResultBuffer.get(localParticleCloud.mResultArray);
        int k = localParticleCloud.mVarAttributes.length;
        i = 0;
        if (i < k)
        {
          Attribute localAttribute = localParticleCloud.mVarAttributes[i];
          int m = ((Particle)localPair.first).total;
          int j = 0;
          Particle localParticle1 = ((Particle)localPair.first).next;
          if (localParticle1 == null) {
            break label278;
          }
          localParticle1.a[localAttribute.mVarIndex] = localParticleCloud.mResultArray[(i * m + j)];
          localParticle1 = localParticle1.next;
          j += 1;
          continue;
        }
        localArrayList.add(localPair.first);
      }
      AppMethodBeat.o(81535);
      return localArrayList;
      label278:
      i += 1;
    }
  }
  
  public ArrayList<Particle> advanceAsync()
  {
    AppMethodBeat.i(81536);
    this.mCopiedParticles.clear();
    synchronized (this.mPool)
    {
      Iterator localIterator = this.mClouds.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ParticleCloud)localIterator.next();
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
      Object localObject1 = this.mCopiedParticles;
      AppMethodBeat.o(81536);
      return localObject1;
    }
  }
  
  Particle advanceObtainUnlocked()
  {
    AppMethodBeat.i(81526);
    Particle localParticle = obtainUnlocked();
    int i = 0;
    while (i < 11)
    {
      this.mParamsPool[(localParticle.param_offset + i)] = Math.abs(this.mRandom.nextInt());
      i += 1;
    }
    AppMethodBeat.o(81526);
    return localParticle;
  }
  
  public void emitImmediately(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(81530);
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext())
    {
      ParticleCloud localParticleCloud = (ParticleCloud)localIterator.next();
      if (localParticleCloud.mEmitRate == 0L)
      {
        if (localParticleCloud.mParticles.total >= localParticleCloud.mMaxCount)
        {
          String.format("max: %d, now %d, can't emit any more", new Object[] { Long.valueOf(localParticleCloud.mMaxCount), Integer.valueOf(localParticleCloud.mParticles.total) });
          AppMethodBeat.o(81530);
          return;
        }
        localParticleCloud.emitImmediately(paramDouble1, paramDouble2, paramDouble3);
      }
    }
    AppMethodBeat.o(81530);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(81537);
    super.finalize();
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext()) {
      ((ParticleCloud)localIterator.next()).release();
    }
    AppMethodBeat.o(81537);
  }
  
  public List<Sprite> getSprites()
  {
    AppMethodBeat.i(81534);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ParticleCloud)localIterator.next()).mSprite);
    }
    AppMethodBeat.o(81534);
    return localArrayList;
  }
  
  public void loadParticleData(List<String> paramList)
  {
    AppMethodBeat.i(81528);
    if (paramList == null)
    {
      AppMethodBeat.o(81528);
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
            break label155;
          }
          localObject1 = new BufferedReader(new InputStreamReader(new FileInputStream((String)localObject1)), 1024);
          localObject2 = new StringBuilder();
          String str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break label140;
          }
          ((StringBuilder)localObject2).append(str);
          continue;
        }
        localArrayList.add(((StringBuilder)localObject2).toString());
      }
      catch (Exception paramList)
      {
        if (!localArrayList.isEmpty()) {
          loadParticles(localArrayList);
        }
        AppMethodBeat.o(81528);
        return;
      }
      label140:
      continue;
      label155:
      Object localObject1 = this.mContext.getAssets().open((String)localObject1);
      Object localObject2 = new byte[((InputStream)localObject1).available()];
      ((InputStream)localObject1).read((byte[])localObject2);
      localArrayList.add(new String((byte[])localObject2));
    }
  }
  
  public void loadParticles(List<String> paramList)
  {
    AppMethodBeat.i(81529);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      loadParticle((String)paramList.next());
    }
    loadFinish();
    AppMethodBeat.o(81529);
  }
  
  void putUnlocked(Particle paramParticle)
  {
    paramParticle.next = this.mPool.next;
    this.mPool.next = paramParticle;
    paramParticle = this.mPool;
    paramParticle.total += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleSystem
 * JD-Core Version:    0.7.0.1
 */