package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class c
{
  public static float[] CHA = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] hrw = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  int CHy;
  FloatBuffer CHz;
  d CyO;
  FloatBuffer mVertexBuffer;
  SurfaceTexture surfaceTexture;
  
  public c()
  {
    AppMethodBeat.i(115724);
    this.CHy = 0;
    this.CHy = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "#extension GL_OES_EGL_image_external : require\nprecision highp float;varying vec2 tc;uniform samplerExternalOES sTexture;void main() {   gl_FragColor = texture2D(sTexture, tc);}");
    AppMethodBeat.o(115724);
  }
  
  public static void eEA()
  {
    AppMethodBeat.i(115729);
    ae.i("MicroMsg.VoipGLHProgram", "detachGLContext");
    long l = bu.HQ();
    e.eED().eEA();
    ae.i("MicroMsg.VoipGLHProgram", "detachGLContext done, used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(115729);
  }
  
  public static void eEz()
  {
    AppMethodBeat.i(115728);
    ae.i("MicroMsg.VoipGLHProgram", "attachGLContext");
    long l = bu.HQ();
    e.eED().eEF();
    ae.i("MicroMsg.VoipGLHProgram", "attachGLContext done, used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(115728);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.CyO = paramd;
  }
  
  public final void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(115725);
    this.mVertexBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertexBuffer.put(paramArrayOfFloat1);
    this.mVertexBuffer.position(0);
    this.CHz = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.CHz.put(paramArrayOfFloat2);
    this.CHz.position(0);
    AppMethodBeat.o(115725);
  }
  
  public final void eEy()
  {
    try
    {
      AppMethodBeat.i(115727);
      ae.i("MicroMsg.VoipGLHProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
      GLES20.glDeleteProgram(this.CHy);
      this.CHy = -1;
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
      ae.printErrStackTrace("MicroMsg.VoipGLHProgram", localException, "updateTexImage error", new Object[0]);
      AppMethodBeat.o(115726);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.c
 * JD-Core Version:    0.7.0.1
 */