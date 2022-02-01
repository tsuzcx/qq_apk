package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class c
{
  public static float[] HlE = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] ilm = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  d HcD;
  int HlC;
  FloatBuffer HlD;
  FloatBuffer mVertexBuffer;
  SurfaceTexture surfaceTexture;
  
  public c()
  {
    AppMethodBeat.i(115724);
    this.HlC = 0;
    this.HlC = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "#extension GL_OES_EGL_image_external : require\nprecision highp float;varying vec2 tc;uniform samplerExternalOES sTexture;void main() {   gl_FragColor = texture2D(sTexture, tc);}");
    AppMethodBeat.o(115724);
  }
  
  public static void fLG()
  {
    AppMethodBeat.i(115728);
    Log.i("MicroMsg.VoipGLHProgram", "attachGLContext");
    long l = Util.currentTicks();
    e.fLK().fLM();
    Log.i("MicroMsg.VoipGLHProgram", "attachGLContext done, used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(115728);
  }
  
  public static void fLH()
  {
    AppMethodBeat.i(115729);
    Log.i("MicroMsg.VoipGLHProgram", "detachGLContext");
    long l = Util.currentTicks();
    e.fLK().fLH();
    Log.i("MicroMsg.VoipGLHProgram", "detachGLContext done, used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(115729);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.HcD = paramd;
  }
  
  public final void d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(115725);
    this.mVertexBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertexBuffer.put(paramArrayOfFloat1);
    this.mVertexBuffer.position(0);
    this.HlD = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.HlD.put(paramArrayOfFloat2);
    this.HlD.position(0);
    AppMethodBeat.o(115725);
  }
  
  public final void fLF()
  {
    try
    {
      AppMethodBeat.i(115727);
      Log.i("MicroMsg.VoipGLHProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
      GLES20.glDeleteProgram(this.HlC);
      this.HlC = -1;
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
      Log.printErrStackTrace("MicroMsg.VoipGLHProgram", localException, "updateTexImage error", new Object[0]);
      AppMethodBeat.o(115726);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.c
 * JD-Core Version:    0.7.0.1
 */