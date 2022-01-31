package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.util.i;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ParticleSystemEx
{
  private static final String TAG;
  private AdvanceRes[] mAdvanceRes;
  private List<ParticleTemplate> mClouds;
  final Context mContext;
  private long mNativeCtx;
  private FloatBuffer mParticleCenterBuffer;
  private FloatBuffer mParticleColorBuffer;
  private FloatBuffer mParticleSizeBuffer;
  private FloatBuffer mParticleTexCoord;
  private float[] mPositionIndex;
  private Map<Sprite, ParticleTemplate> mSpriteMap;
  
  static
  {
    AppMethodBeat.i(81553);
    try
    {
      System.loadLibrary("ParticleSystem");
      TAG = ParticleSystemEx.class.getSimpleName();
      AppMethodBeat.o(81553);
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
  
  public ParticleSystemEx(Context paramContext)
  {
    AppMethodBeat.i(81542);
    this.mClouds = new ArrayList();
    this.mSpriteMap = new HashMap();
    this.mContext = paramContext;
    this.mNativeCtx = nativeInit();
    AppMethodBeat.o(81542);
  }
  
  private void createCache(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(81548);
    this.mPositionIndex = new float[paramInt2 * 6];
    paramInt2 = 0;
    while (paramInt2 < this.mPositionIndex.length)
    {
      this.mPositionIndex[paramInt2] = (paramInt2 % 6 + 0.5F);
      paramInt2 += 1;
    }
    this.mParticleCenterBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 3 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleSizeBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 2 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleTexCoord = ByteBuffer.allocateDirect(paramInt1 * 6 * 2 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleColorBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 4 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    AppMethodBeat.o(81548);
  }
  
  private void loadFinish()
  {
    AppMethodBeat.i(81546);
    this.mAdvanceRes = new AdvanceRes[this.mClouds.size()];
    int i = 0;
    int j = 0;
    int m;
    for (int k = 0; i < this.mClouds.size(); k = m)
    {
      ParticleTemplate localParticleTemplate = (ParticleTemplate)this.mClouds.get(i);
      m = k + localParticleTemplate.mMaxCount;
      k = j;
      if (localParticleTemplate.mMaxCount > j) {
        k = localParticleTemplate.mMaxCount;
      }
      this.mAdvanceRes[i] = new AdvanceRes();
      i += 1;
      j = k;
    }
    nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
    createCache(k, j);
    AppMethodBeat.o(81546);
  }
  
  private void loadParticle(String paramString)
  {
    AppMethodBeat.i(81545);
    Object localObject1;
    Object localObject3;
    try
    {
      if (paramString.startsWith("/"))
      {
        localObject1 = new BufferedReader(new InputStreamReader(new FileInputStream(paramString)), 1024);
        localObject3 = new StringBuilder();
        for (;;)
        {
          String str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break;
          }
          ((StringBuilder)localObject3).append(str);
        }
        localObject1 = ((StringBuilder)localObject3).toString();
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(81545);
      return;
    }
    try
    {
      for (;;)
      {
        localObject1 = new JSONObject((String)localObject1);
        paramString = ParticleTemplate.fromJson(this, (JSONObject)localObject1, paramString.substring(0, paramString.lastIndexOf('/')));
        if (paramString != null)
        {
          this.mClouds.add(paramString);
          this.mSpriteMap.put(paramString.mSprite, paramString);
        }
        AppMethodBeat.o(81545);
        return;
        localObject1 = this.mContext.getAssets().open(paramString);
        localObject3 = new byte[((InputStream)localObject1).available()];
        ((InputStream)localObject1).read((byte[])localObject3);
        localObject1 = new String((byte[])localObject3);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        i.n(TAG, localJSONException.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  public static native void nativeAdvance(long paramLong, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, FloatBuffer paramFloatBuffer3, FloatBuffer paramFloatBuffer4, AdvanceRes[] paramArrayOfAdvanceRes);
  
  public static native void nativeEmitAt(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public static native long nativeInit();
  
  public static native void nativeRegisterTemplate(long paramLong, Object[] paramArrayOfObject);
  
  public static native void nativeRelease(long paramLong);
  
  public List<FrameParticleData> advance()
  {
    AppMethodBeat.i(81547);
    if (this.mClouds.isEmpty())
    {
      AppMethodBeat.o(81547);
      return null;
    }
    nativeAdvance(this.mNativeCtx, this.mParticleCenterBuffer, this.mParticleSizeBuffer, this.mParticleTexCoord, this.mParticleColorBuffer, this.mAdvanceRes);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mAdvanceRes.length)
    {
      FrameParticleData localFrameParticleData = new FrameParticleData();
      localArrayList.add(localFrameParticleData);
      AdvanceRes localAdvanceRes = this.mAdvanceRes[i];
      localFrameParticleData.particleCount = localAdvanceRes.particleCount;
      localFrameParticleData.positionIndex = Arrays.copyOf(this.mPositionIndex, localAdvanceRes.particleCount * 6);
      localFrameParticleData.particleCenter = new float[localAdvanceRes.particleCenterLen];
      this.mParticleCenterBuffer.position(localAdvanceRes.particleCenterOffset);
      this.mParticleCenterBuffer.get(localFrameParticleData.particleCenter);
      localFrameParticleData.particleSize = new float[localAdvanceRes.particleSizeLen];
      this.mParticleSizeBuffer.position(localAdvanceRes.particleSizeOffset);
      this.mParticleSizeBuffer.get(localFrameParticleData.particleSize);
      localFrameParticleData.texCoords = new float[localAdvanceRes.texCoordsLen];
      this.mParticleTexCoord.position(localAdvanceRes.texCoordsOffset);
      this.mParticleTexCoord.get(localFrameParticleData.texCoords);
      localFrameParticleData.particleColor = new float[localAdvanceRes.particleColorLen];
      this.mParticleColorBuffer.position(localAdvanceRes.particleColorOffset);
      this.mParticleColorBuffer.get(localFrameParticleData.particleColor);
      localFrameParticleData.audioPath = ((ParticleTemplate)this.mClouds.get(i)).mSprite.audioPath;
      localFrameParticleData.playAudio = localAdvanceRes.playAudio;
      localFrameParticleData.blendMode = ((ParticleTemplate)this.mClouds.get(i)).mSprite.blendMode;
      i += 1;
    }
    AppMethodBeat.o(81547);
    return localArrayList;
  }
  
  public void emitImmediately(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(81552);
    nativeEmitAt(this.mNativeCtx, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(81552);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(81551);
    release();
    AppMethodBeat.o(81551);
  }
  
  public List<Sprite> getSprites()
  {
    AppMethodBeat.i(81549);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ParticleTemplate)localIterator.next()).mSprite);
    }
    AppMethodBeat.o(81549);
    return localArrayList;
  }
  
  public void loadParticleData(List<String> paramList)
  {
    AppMethodBeat.i(81544);
    if (paramList == null)
    {
      AppMethodBeat.o(81544);
      return;
    }
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        loadParticle((String)paramList.next());
      }
      return;
    }
    catch (Exception paramList)
    {
      loadFinish();
      AppMethodBeat.o(81544);
    }
  }
  
  public void loadTestData()
  {
    AppMethodBeat.i(81543);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("assets://flower1.json");
    loadParticleData(localArrayList);
    AppMethodBeat.o(81543);
  }
  
  public void release()
  {
    AppMethodBeat.i(81550);
    if (this.mNativeCtx != -1L)
    {
      nativeRelease(this.mNativeCtx);
      this.mNativeCtx = -1L;
    }
    AppMethodBeat.o(81550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleSystemEx
 * JD-Core Version:    0.7.0.1
 */