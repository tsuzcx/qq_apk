package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class b
{
  public static final float[] eZq = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static float[] tIw = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  SurfaceTexture bbI;
  FloatBuffer mVertexBuffer;
  int tIu;
  FloatBuffer tIv;
  int textureId;
  
  public b()
  {
    AppMethodBeat.i(140220);
    this.tIu = 0;
    this.tIu = e.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "#extension GL_OES_EGL_image_external : require\nprecision highp float;varying vec2 tc;uniform samplerExternalOES sTexture;void main() {   gl_FragColor = texture2D(sTexture, tc);}");
    AppMethodBeat.o(140220);
  }
  
  public static void cPU()
  {
    AppMethodBeat.i(140224);
    ab.i("MicroMsg.VoipGLHProgram", "attachGLContext");
    long l = bo.yB();
    d locald = d.cPX();
    ab.i("MicroMsg.VoipHardDecodeUtil", "attachGLContext");
    if (locald.textureId == -1)
    {
      locald.textureId = e.cPY();
      com.tencent.mm.plugin.voip.model.v2protocal.textureId = locald.textureId;
      ab.i("MicroMsg.VoipHardDecodeUtil", "attachGLContext, textureId:%s", new Object[] { Integer.valueOf(locald.textureId) });
    }
    locald.mSurfaceTexture.attachToGLContext(locald.textureId);
    locald.tII.tW();
    ab.i("MicroMsg.VoipGLHProgram", "attachGLContext done, used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(140224);
  }
  
  public static void cPV()
  {
    AppMethodBeat.i(140225);
    ab.i("MicroMsg.VoipGLHProgram", "detachGLContext");
    long l = bo.yB();
    d locald = d.cPX();
    ab.i("MicroMsg.VoipHardDecodeUtil", "detachGLContext");
    locald.mSurfaceTexture.detachFromGLContext();
    GLES20.glDeleteTextures(1, new int[] { locald.textureId }, 0);
    locald.textureId = -1;
    ab.i("MicroMsg.VoipGLHProgram", "detachGLContext done, used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(140225);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    this.bbI = paramSurfaceTexture;
    this.textureId = paramInt;
  }
  
  public final void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(140221);
    this.mVertexBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertexBuffer.put(paramArrayOfFloat1);
    this.mVertexBuffer.position(0);
    this.tIv = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.tIv.put(paramArrayOfFloat2);
    this.tIv.position(0);
    AppMethodBeat.o(140221);
  }
  
  public final void cPT()
  {
    try
    {
      AppMethodBeat.i(140223);
      ab.i("MicroMsg.VoipGLHProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
      GLES20.glDeleteProgram(this.tIu);
      this.tIu = -1;
      AppMethodBeat.o(140223);
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
    AppMethodBeat.i(140222);
    try
    {
      this.bbI.updateTexImage();
      AppMethodBeat.o(140222);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VoipGLHProgram", localException, "updateTexImage error", new Object[0]);
      AppMethodBeat.o(140222);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.b
 * JD-Core Version:    0.7.0.1
 */