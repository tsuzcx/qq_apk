package com.tencent.ttpic.particlesystemx;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.Transition;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class ParticleSystemX
{
  private static final String TAG;
  private static ParticleSystemX mInstance;
  private List<ParticleTemplateX> mClouds;
  private Context mContext;
  private long mNativeCtx;
  
  static
  {
    AppMethodBeat.i(83675);
    TAG = ParticleSystemX.class.getSimpleName();
    System.loadLibrary("ParticleSystem");
    AppMethodBeat.o(83675);
  }
  
  private ParticleSystemX()
  {
    AppMethodBeat.i(83663);
    this.mContext = null;
    this.mClouds = new ArrayList();
    AppMethodBeat.o(83663);
  }
  
  public static ParticleSystemX getInstance()
  {
    try
    {
      AppMethodBeat.i(83662);
      if (mInstance == null) {
        mInstance = new ParticleSystemX();
      }
      ParticleSystemX localParticleSystemX = mInstance;
      AppMethodBeat.o(83662);
      return localParticleSystemX;
    }
    finally {}
  }
  
  private void loadFinish()
  {
    AppMethodBeat.i(83665);
    int i = 0;
    while (i < this.mClouds.size())
    {
      this.mClouds.get(i);
      i += 1;
    }
    nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
    AppMethodBeat.o(83665);
  }
  
  public static native int nativeAdvance(long paramLong, int paramInt, float paramFloat1, float paramFloat2, FloatBuffer paramFloatBuffer, float paramFloat3, boolean paramBoolean);
  
  public static native int nativeClearParticles(long paramLong, int paramInt);
  
  public static native long nativeEmitAt(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public static native long nativeInit();
  
  public static native void nativeRegisterTemplate(long paramLong, Object[] paramArrayOfObject);
  
  public static native void nativeRelease(long paramLong);
  
  public static native int nativeReset(long paramLong);
  
  public void addParticle(Transition paramTransition)
  {
    AppMethodBeat.i(83667);
    paramTransition = new ParticleTemplateX(paramTransition.particleCountMax, paramTransition.emissionRate, paramTransition.life, paramTransition.positionX, paramTransition.positionY, paramTransition.scale, paramTransition.rotate, paramTransition.p0, paramTransition.p1, paramTransition.p2);
    this.mClouds.add(paramTransition);
    AppMethodBeat.o(83667);
  }
  
  public int advance(float paramFloat1, float paramFloat2, FloatBuffer paramFloatBuffer, float paramFloat3)
  {
    AppMethodBeat.i(83669);
    int i = advanceByTemplate(-1, paramFloat1, paramFloat2, paramFloatBuffer, paramFloat3, true);
    AppMethodBeat.o(83669);
    return i;
  }
  
  public int advanceByTemplate(int paramInt, float paramFloat1, float paramFloat2, FloatBuffer paramFloatBuffer, float paramFloat3, boolean paramBoolean)
  {
    AppMethodBeat.i(83670);
    paramInt = nativeAdvance(this.mNativeCtx, paramInt, paramFloat1, paramFloat2, paramFloatBuffer, paramFloat3, paramBoolean);
    AppMethodBeat.o(83670);
    return paramInt;
  }
  
  public int clearParticles(int paramInt)
  {
    AppMethodBeat.i(83671);
    paramInt = nativeClearParticles(this.mNativeCtx, paramInt);
    AppMethodBeat.o(83671);
    return paramInt;
  }
  
  public void createParticles(Transition paramTransition)
  {
    AppMethodBeat.i(83666);
    paramTransition = new ParticleTemplateX(300, paramTransition.emissionRate, paramTransition.life, paramTransition.positionX, paramTransition.positionY, paramTransition.scale, paramTransition.rotate, paramTransition.p0, paramTransition.p1, paramTransition.p2);
    this.mClouds.add(paramTransition);
    loadFinish();
    AppMethodBeat.o(83666);
  }
  
  public long emitImmediately(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(83674);
    long l = nativeEmitAt(this.mNativeCtx, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(83674);
    return l;
  }
  
  public void init(Context paramContext)
  {
    AppMethodBeat.i(83664);
    if ((this.mContext == null) || (this.mNativeCtx == 0L))
    {
      this.mContext = paramContext;
      this.mNativeCtx = nativeInit();
    }
    AppMethodBeat.o(83664);
  }
  
  public void registerTemplate()
  {
    AppMethodBeat.i(83668);
    nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
    AppMethodBeat.o(83668);
  }
  
  public void release()
  {
    AppMethodBeat.i(83673);
    if (this.mNativeCtx != 0L)
    {
      nativeRelease(this.mNativeCtx);
      this.mNativeCtx = 0L;
      this.mContext = null;
    }
    AppMethodBeat.o(83673);
  }
  
  public int reset()
  {
    AppMethodBeat.i(83672);
    int i = nativeReset(this.mNativeCtx);
    AppMethodBeat.o(83672);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.particlesystemx.ParticleSystemX
 * JD-Core Version:    0.7.0.1
 */