package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class v2render
{
  public final int FLAG_Angle270 = 12;
  public final int FLAG_Angle90 = 4;
  public final int FLAG_Mirror = 16;
  public final int FLAG_NV12 = 2;
  public final int FLAG_NV21 = 3;
  public final int FLAG_RGBA = 0;
  public final int FLAG_RGBAClip = 1;
  public final int FLAG_YV12 = 0;
  public final int FLAG_YV12Edge = 1;
  public final int MSG_FLUSH = 1;
  public final int MSG_RENDER = 0;
  public final int MSG_RESET = 2;
  public final int RenderLocal = 0;
  public final int RenderRemote = 1;
  private byte _hellAccFlag_;
  public float mBrightness = 1.2F;
  public float mContrast = 1.93F;
  public float mSaturation = 1.05F;
  
  static
  {
    AppMethodBeat.i(40800);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("voipGLRender");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxmm/v2render", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxmm/v2render", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(40800);
  }
  
  public static int getGLVersion()
  {
    return 2;
  }
  
  public native void Init(int paramInt1, Object paramObject, int paramInt2);
  
  public native void Uninit(int paramInt);
  
  public native void render32(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void render8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void setMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void setParam(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wxmm.v2render
 * JD-Core Version:    0.7.0.1
 */