package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class c
{
  public static float[] CpW = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] hoI = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  d Chn;
  int CpU;
  FloatBuffer CpV;
  FloatBuffer mVertexBuffer;
  SurfaceTexture surfaceTexture;
  
  public c()
  {
    AppMethodBeat.i(115724);
    this.CpU = 0;
    this.CpU = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "#extension GL_OES_EGL_image_external : require\nprecision highp float;varying vec2 tc;uniform samplerExternalOES sTexture;void main() {   gl_FragColor = texture2D(sTexture, tc);}");
    AppMethodBeat.o(115724);
  }
  
  public static void eAR()
  {
    AppMethodBeat.i(115728);
    ad.i("MicroMsg.VoipGLHProgram", "attachGLContext");
    long l = bt.HI();
    e.eAV().eAX();
    ad.i("MicroMsg.VoipGLHProgram", "attachGLContext done, used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(115728);
  }
  
  public static void eAS()
  {
    AppMethodBeat.i(115729);
    ad.i("MicroMsg.VoipGLHProgram", "detachGLContext");
    long l = bt.HI();
    e.eAV().eAS();
    ad.i("MicroMsg.VoipGLHProgram", "detachGLContext done, used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(115729);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.Chn = paramd;
  }
  
  public final void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(115725);
    this.mVertexBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertexBuffer.put(paramArrayOfFloat1);
    this.mVertexBuffer.position(0);
    this.CpV = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.CpV.put(paramArrayOfFloat2);
    this.CpV.position(0);
    AppMethodBeat.o(115725);
  }
  
  public final void eAQ()
  {
    try
    {
      AppMethodBeat.i(115727);
      ad.i("MicroMsg.VoipGLHProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
      GLES20.glDeleteProgram(this.CpU);
      this.CpU = -1;
      AppMethodBeat.o(115727);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void updateTexImage()
  {
    AppMethodBeat.i(115726);
    try
    {
      this.surfaceTexture.updateTexImage();
      AppMethodBeat.o(115726);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.VoipGLHProgram", localException, "updateTexImage error", new Object[0]);
      AppMethodBeat.o(115726);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.c
 * JD-Core Version:    0.7.0.1
 */