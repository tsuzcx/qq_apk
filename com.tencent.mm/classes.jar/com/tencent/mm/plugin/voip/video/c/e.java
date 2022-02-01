package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.video.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public final class e
{
  public float[] UQG;
  public float[] UQH;
  private float[] UQI;
  private float[] UQJ;
  d[] UQu;
  int[] UQv;
  FloatBuffer UQw;
  int mPositionHandle;
  int mProgram;
  FloatBuffer mVertexBuffer;
  private int outputHeight;
  private int outputWidth;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public e()
  {
    AppMethodBeat.i(293221);
    this.mProgram = 0;
    this.UQu = new d[3];
    this.UQv = new int[3];
    this.mPositionHandle = -1;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.UQG = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.UQH = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.UQI = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.UQJ = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    icX();
    ida();
    AppMethodBeat.o(293221);
  }
  
  private void ida()
  {
    AppMethodBeat.i(293233);
    this.mProgram = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision highp float;uniform sampler2D samplerY;uniform sampler2D samplerU;uniform sampler2D samplerV;uniform sampler2D samplerUV;uniform int yuvType;varying vec2 tc;void main() {  vec4 c = vec4((texture2D(samplerY, tc).r - 16./255.) * 1.164);  vec4 U; vec4 V; if (yuvType == 0 || yuvType == 1){      U = vec4(texture2D(samplerU, tc).r - 128./255.);      V = vec4(texture2D(samplerV, tc).r - 128./255.);  } else {      U = vec4(texture2D(samplerUV, tc).a - 128./255.);      V = vec4(texture2D(samplerUV, tc).r - 128./255.);  }   c += V * vec4(1.596, -0.813, 0, 0);  c += U * vec4(0, -0.392, 2.017, 0);  c.a = 1.0;  gl_FragColor = c;}");
    int i = 0;
    while (i < this.UQu.length)
    {
      this.UQu[i] = c.d(true, 14L);
      i += 1;
    }
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
    AppMethodBeat.o(293233);
  }
  
  final void c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(293240);
    this.UQu[paramInt3].a(paramInt1, paramInt2, 6409, paramByteBuffer, 9729, 33071);
    AppMethodBeat.o(293240);
  }
  
  public final void icX()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(293245);
        Log.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
        d[] arrayOfd = this.UQu;
        int j = arrayOfd.length;
        if (i < j)
        {
          d locald = arrayOfd[i];
          if (locald != null) {
            locald.close();
          }
        }
        else
        {
          GLES20.glDeleteProgram(this.mProgram);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16640);
          GLES20.glFinish();
          if (this.UQw != null) {
            this.UQw.clear();
          }
          if (this.mVertexBuffer != null) {
            this.mVertexBuffer.clear();
          }
          this.mVertexBuffer = null;
          this.UQw = null;
          this.mProgram = 0;
          AppMethodBeat.o(293245);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.e
 * JD-Core Version:    0.7.0.1
 */