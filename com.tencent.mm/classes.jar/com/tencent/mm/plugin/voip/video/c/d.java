package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.plugin.voip.video.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class d
{
  public float[] OcG;
  public float[] OcH;
  private float[] OcI;
  private float[] OcJ;
  private com.tencent.mm.media.g.d[] Ocu;
  private int[] Ocv;
  private FloatBuffer Ocw;
  private int mPositionHandle;
  private int mProgram;
  private FloatBuffer mVertexBuffer;
  private int outputHeight;
  private int outputWidth;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public d()
  {
    AppMethodBeat.i(242949);
    this.mProgram = 0;
    this.Ocu = new com.tencent.mm.media.g.d[3];
    this.Ocv = new int[3];
    this.mPositionHandle = -1;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.OcG = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.OcH = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.OcI = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.OcJ = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    gEf();
    gEi();
    AppMethodBeat.o(242949);
  }
  
  private void b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(242954);
    this.Ocu[paramInt3].a(paramInt1, paramInt2, 6409, paramByteBuffer, 9729, 33071);
    AppMethodBeat.o(242954);
  }
  
  private void gEi()
  {
    AppMethodBeat.i(242956);
    this.mProgram = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision highp float;uniform sampler2D samplerY;uniform sampler2D samplerU;uniform sampler2D samplerV;uniform sampler2D samplerUV;uniform int yuvType;varying vec2 tc;void main() {  vec4 c = vec4((texture2D(samplerY, tc).r - 16./255.) * 1.164);  vec4 U; vec4 V; if (yuvType == 0 || yuvType == 1){      U = vec4(texture2D(samplerU, tc).r - 128./255.);      V = vec4(texture2D(samplerV, tc).r - 128./255.);  } else {      U = vec4(texture2D(samplerUV, tc).a - 128./255.);      V = vec4(texture2D(samplerUV, tc).r - 128./255.);  }   c += V * vec4(1.596, -0.813, 0, 0);  c += U * vec4(0, -0.392, 2.017, 0);  c.a = 1.0;  gl_FragColor = c;}");
    int i = 0;
    while (i < this.Ocu.length)
    {
      this.Ocu[i] = c.a(true, 14L);
      i += 1;
    }
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
    AppMethodBeat.o(242956);
  }
  
  public final void a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242952);
    b(paramByteBuffer1, paramInt1, paramInt2, 0);
    b(paramByteBuffer2, paramInt1 / 2, paramInt2 / 2, 1);
    b(paramByteBuffer3, paramInt1 / 2, paramInt2 / 2, 2);
    AppMethodBeat.o(242952);
  }
  
  public final void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(242955);
    if ((this.mVertexBuffer == null) || (this.mVertexBuffer.capacity() != paramArrayOfFloat1.length)) {
      this.mVertexBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.mVertexBuffer.put(paramArrayOfFloat1);
    this.mVertexBuffer.position(0);
    if ((this.Ocw == null) || (this.Ocw.capacity() != paramArrayOfFloat2.length)) {
      this.Ocw = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.Ocw.put(paramArrayOfFloat2);
    this.Ocw.position(0);
    AppMethodBeat.o(242955);
  }
  
  public final void gEf()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(242957);
        Log.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
        com.tencent.mm.media.g.d[] arrayOfd = this.Ocu;
        int j = arrayOfd.length;
        if (i < j)
        {
          com.tencent.mm.media.g.d locald = arrayOfd[i];
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
          if (this.Ocw != null) {
            this.Ocw.clear();
          }
          if (this.mVertexBuffer != null) {
            this.mVertexBuffer.clear();
          }
          this.mVertexBuffer = null;
          this.Ocw = null;
          this.mProgram = 0;
          AppMethodBeat.o(242957);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public final void gEp()
  {
    AppMethodBeat.i(242951);
    GLES20.glUseProgram(this.mProgram);
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
    GLES20.glEnableVertexAttribArray(this.mPositionHandle);
    GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, this.mVertexBuffer);
    int i = GLES20.glGetAttribLocation(this.mProgram, "vTexCoord");
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, this.Ocw);
    this.Ocv[0] = GLES20.glGetUniformLocation(this.mProgram, "samplerY");
    this.Ocv[1] = GLES20.glGetUniformLocation(this.mProgram, "samplerU");
    this.Ocv[2] = GLES20.glGetUniformLocation(this.mProgram, "samplerV");
    i = 0;
    while (i < 3)
    {
      GLES20.glActiveTexture(33984 + i);
      GLES20.glBindTexture(3553, this.Ocu[i].kVj);
      GLES20.glUniform1i(this.Ocv[i], i);
      i += 1;
    }
    i = GLES20.glGetUniformLocation(this.mProgram, "yuvType");
    if (i >= 0) {
      GLES20.glUniform1i(i, 0);
    }
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glFinish();
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glUseProgram(0);
    AppMethodBeat.o(242951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.d
 * JD-Core Version:    0.7.0.1
 */