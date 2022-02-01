package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.video.b.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class c
{
  private d[] CHB;
  private int[] CHC;
  private FloatBuffer CHD;
  public float[] CHI;
  public float[] CHJ;
  private float[] CHK;
  private float[] CHL;
  private int mPositionHandle;
  private int mProgram;
  private FloatBuffer mVertexBuffer;
  private int outputHeight;
  private int outputWidth;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public c()
  {
    AppMethodBeat.i(210261);
    this.mProgram = 0;
    this.CHB = new d[3];
    this.CHC = new int[3];
    this.mPositionHandle = -1;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.CHI = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.CHJ = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.CHK = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.CHL = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    eEy();
    eEB();
    AppMethodBeat.o(210261);
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(210264);
    this.CHB[paramInt3].a(paramInt1, paramInt2, 6409, paramByteBuffer, 9729, 33071);
    AppMethodBeat.o(210264);
  }
  
  private void eEB()
  {
    AppMethodBeat.i(210266);
    this.mProgram = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision highp float;uniform sampler2D samplerY;uniform sampler2D samplerU;uniform sampler2D samplerV;uniform sampler2D samplerUV;uniform int yuvType;varying vec2 tc;void main() {  vec4 c = vec4((texture2D(samplerY, tc).r - 16./255.) * 1.164);  vec4 U; vec4 V; if (yuvType == 0 || yuvType == 1){      U = vec4(texture2D(samplerU, tc).r - 128./255.);      V = vec4(texture2D(samplerV, tc).r - 128./255.);  } else {      U = vec4(texture2D(samplerUV, tc).a - 128./255.);      V = vec4(texture2D(samplerUV, tc).r - 128./255.);  }   c += V * vec4(1.596, -0.813, 0, 0);  c += U * vec4(0, -0.392, 2.017, 0);  c.a = 1.0;  gl_FragColor = c;}");
    int i = 0;
    while (i < this.CHB.length)
    {
      this.CHB[i] = com.tencent.mm.media.g.c.a(true, 14L);
      i += 1;
    }
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
    AppMethodBeat.o(210266);
  }
  
  public final void a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210263);
    a(paramByteBuffer1, paramInt1, paramInt2, 0);
    a(paramByteBuffer2, paramInt1 / 2, paramInt2 / 2, 1);
    a(paramByteBuffer3, paramInt1 / 2, paramInt2 / 2, 2);
    AppMethodBeat.o(210263);
  }
  
  public final void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(210265);
    if ((this.mVertexBuffer == null) || (this.mVertexBuffer.capacity() != paramArrayOfFloat1.length)) {
      this.mVertexBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.mVertexBuffer.put(paramArrayOfFloat1);
    this.mVertexBuffer.position(0);
    if ((this.CHD == null) || (this.CHD.capacity() != paramArrayOfFloat2.length)) {
      this.CHD = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.CHD.put(paramArrayOfFloat2);
    this.CHD.position(0);
    AppMethodBeat.o(210265);
  }
  
  public final void eEH()
  {
    AppMethodBeat.i(210262);
    GLES20.glUseProgram(this.mProgram);
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
    GLES20.glEnableVertexAttribArray(this.mPositionHandle);
    GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, this.mVertexBuffer);
    int i = GLES20.glGetAttribLocation(this.mProgram, "vTexCoord");
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, this.CHD);
    this.CHC[0] = GLES20.glGetUniformLocation(this.mProgram, "samplerY");
    this.CHC[1] = GLES20.glGetUniformLocation(this.mProgram, "samplerU");
    this.CHC[2] = GLES20.glGetUniformLocation(this.mProgram, "samplerV");
    i = 0;
    while (i < 3)
    {
      GLES20.glActiveTexture(33984 + i);
      GLES20.glBindTexture(3553, this.CHB[i].hnc);
      GLES20.glUniform1i(this.CHC[i], i);
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
    AppMethodBeat.o(210262);
  }
  
  public final void eEy()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210267);
        ae.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
        d[] arrayOfd = this.CHB;
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
          if (this.CHD != null) {
            this.CHD.clear();
          }
          if (this.mVertexBuffer != null) {
            this.mVertexBuffer.clear();
          }
          this.mVertexBuffer = null;
          this.CHD = null;
          this.mProgram = 0;
          AppMethodBeat.o(210267);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.c
 * JD-Core Version:    0.7.0.1
 */