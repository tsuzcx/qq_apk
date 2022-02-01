package com.tencent.mm.plugin.voip.video.c;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/programv2/IVoIPRenderSurfaceProgram;", "", "()V", "drawFrame", "", "pBuff", "", "w", "", "h", "flag", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderMode", "transformMatrix", "", "setMirror", "isMirror", "", "setRGBDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setRotate", "encodeRotate", "updateDrawViewSize", "width", "height", "updateEncodeResType", "encodeWidth", "encodeHeight", "encoderType", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  public abstract void a(FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt1, int paramInt2, float[] paramArrayOfFloat);
  
  public void bl(int paramInt1, int paramInt2, int paramInt3) {}
  
  public abstract void ek(int paramInt1, int paramInt2);
  
  public void i(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, ah> paramr)
  {
    s.u(paramr, "callback");
  }
  
  public void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    s.u(paramArrayOfByte, "pBuff");
  }
  
  public abstract void release();
  
  public void setMirror(boolean paramBoolean) {}
  
  public void th(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.b
 * JD-Core Version:    0.7.0.1
 */