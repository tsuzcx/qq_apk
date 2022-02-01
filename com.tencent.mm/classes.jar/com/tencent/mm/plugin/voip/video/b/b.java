package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public final class b
{
  FloatBuffer HlA;
  byte[] HlB;
  private int Hle;
  private int Hlf;
  private int Hlg;
  private int Hlh;
  private int Hli;
  private int Hlj;
  int Hlk;
  int Hll;
  int Hlm;
  private a Hln;
  private d Hlo;
  FloatBuffer Hlp;
  private FloatBuffer Hlq;
  private FloatBuffer Hlr;
  private int Hls;
  private int Hlt;
  ByteBuffer Hlu;
  private int Hlv;
  private int Hlw;
  float[] Hlx;
  float[] Hly;
  private int Hlz;
  public int outputHeight;
  public int outputWidth;
  public int surfaceHeight;
  public int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(115717);
    this.Hlk = 0;
    this.Hll = 0;
    this.Hlm = 0;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.Hln = null;
    this.Hlo = null;
    this.Hlx = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.Hly = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.Hlz = 0;
    AppMethodBeat.o(115717);
  }
  
  private static void O(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(115722);
    GLES20.glBindFramebuffer(36160, paramInt1);
    if (paramInt1 > 0)
    {
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt2, 0);
      GLES20.glBindTexture(3553, 0);
    }
    AppMethodBeat.o(115722);
  }
  
  private void a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, boolean paramBoolean)
  {
    AppMethodBeat.i(115719);
    GLES20.glUseProgram(paramInt1);
    this.Hls = GLES20.glGetAttribLocation(paramInt1, "vPosition");
    GLES20.glEnableVertexAttribArray(this.Hls);
    GLES20.glVertexAttribPointer(this.Hls, 2, 5126, false, 8, paramFloatBuffer1);
    this.Hlt = GLES20.glGetAttribLocation(paramInt1, "vTexCoord");
    GLES20.glEnableVertexAttribArray(this.Hlt);
    GLES20.glVertexAttribPointer(this.Hlt, 2, 5126, false, 8, paramFloatBuffer2);
    if (paramBoolean)
    {
      this.Hle = GLES20.glGetUniformLocation(paramInt1, "smoothDegree");
      GLES20.glUniform1f(this.Hle, 0.5F);
      this.Hlf = GLES20.glGetUniformLocation(paramInt1, "showCounter");
      GLES20.glUniform1i(this.Hlf, 0);
      this.Hlg = GLES20.glGetUniformLocation(paramInt1, "showMode");
      GLES20.glUniform1i(this.Hlg, 2);
      this.Hlh = GLES20.glGetUniformLocation(paramInt1, "brightness");
      GLES20.glUniform1f(this.Hlh, 0.8F);
      this.Hli = GLES20.glGetUniformLocation(paramInt1, "texelWidth");
      GLES20.glUniform1f(this.Hli, this.Hlv);
      this.Hlj = GLES20.glGetUniformLocation(paramInt1, "texelHeight");
      GLES20.glUniform1f(this.Hlj, this.Hlw);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(GLES20.glGetAttribLocation(paramInt1, "inputImageTexture"), 0);
    AppMethodBeat.o(115719);
  }
  
  private void fLE()
  {
    AppMethodBeat.i(235897);
    if ((this.Hlu == null) || (this.Hlu.capacity() < this.outputHeight * this.outputWidth * 4)) {
      this.Hlu = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
    }
    this.Hlu.position(0);
    GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, 6408, 5121, this.Hlu);
    this.Hlu.position(0);
    this.HlB = this.Hlu.array();
    O(0, 0, 0, 0);
    AppMethodBeat.o(235897);
  }
  
  static void q(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(115720);
    swap(paramArrayOfFloat, 0, 6);
    swap(paramArrayOfFloat, 1, 7);
    swap(paramArrayOfFloat, 2, 4);
    swap(paramArrayOfFloat, 3, 5);
    AppMethodBeat.o(115720);
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  private void xy(boolean paramBoolean)
  {
    AppMethodBeat.i(115721);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (paramBoolean)
    {
      GLES20.glViewport(0, 0, this.outputWidth, this.outputHeight);
      GLES20.glDrawArrays(5, 0, 4);
      fLE();
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES20.glDisableVertexAttribArray(this.Hls);
      GLES20.glDisableVertexAttribArray(this.Hlt);
      AppMethodBeat.o(115721);
      return;
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glDrawArrays(5, 0, 4);
    }
  }
  
  public final void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(235896);
    if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat1 != null))
    {
      paramArrayOfFloat2 = Arrays.copyOf(paramArrayOfFloat2, paramArrayOfFloat2.length);
      q(paramArrayOfFloat2);
      if ((this.Hlq == null) || (this.Hlq.capacity() < paramArrayOfFloat2.length)) {
        this.Hlq = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      }
      this.Hlq.put(paramArrayOfFloat2);
      this.Hlq.position(0);
      paramArrayOfFloat1 = Arrays.copyOf(paramArrayOfFloat1, paramArrayOfFloat1.length);
      if ((this.Hlr == null) || (this.Hlr.capacity() < paramArrayOfFloat1.length)) {
        this.Hlr = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      }
      this.Hlr.put(paramArrayOfFloat1);
      this.Hlr.position(0);
    }
    AppMethodBeat.o(235896);
  }
  
  public final void fLD()
  {
    AppMethodBeat.i(235895);
    if ((this.Hln == null) || (this.Hlv <= 0) || (this.Hlw <= 0)) {
      jJ(this.outputWidth, this.outputHeight);
    }
    O(this.Hln.igo, this.Hlo.igv, this.Hlv, this.Hlw);
    a(this.Hlk, this.Hlm, this.Hlp, this.HlA, true);
    xy(true);
    O(0, 0, 0, 0);
    a(this.Hll, this.Hlo.igv, this.Hlr, this.Hlq, false);
    xy(false);
    AppMethodBeat.o(235895);
  }
  
  public final void fLF()
  {
    AppMethodBeat.i(115723);
    Log.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.Hln != null) {
      this.Hln.close();
    }
    if (this.Hlo != null) {
      this.Hlo.close();
    }
    GLES20.glDeleteProgram(this.Hlk);
    GLES20.glDeleteProgram(this.Hll);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFinish();
    if (this.Hlq != null) {
      this.Hlq.clear();
    }
    if (this.Hlp != null) {
      this.Hlp.clear();
    }
    if (this.HlA != null) {
      this.HlA.clear();
    }
    this.HlA = null;
    this.Hlp = null;
    this.Hlq = null;
    this.Hlk = 0;
    this.Hll = 0;
    this.Hln = null;
    this.Hlo = null;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.Hlw = 0;
    this.Hlv = 0;
    this.outputHeight = 0;
    this.outputWidth = 0;
    AppMethodBeat.o(115723);
  }
  
  public final void jJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115718);
    Log.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.Hlo, this.Hln });
    if (this.Hln != null) {
      this.Hln.close();
    }
    if (this.Hlo != null) {
      this.Hlo.close();
    }
    this.Hlv = paramInt1;
    this.Hlw = paramInt2;
    this.Hlo = f.fLz();
    this.Hln = f.fLA();
    GLES20.glBindTexture(3553, this.Hlo.igv);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLES20.glTexImage2D(3553, 0, 6408, this.Hlv, this.Hlw, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(115718);
  }
  
  public final void rl(int paramInt)
  {
    AppMethodBeat.i(235894);
    Log.i("MicroMsg.VoipGLSProgram", "set input texture:%s", new Object[] { Integer.valueOf(paramInt) });
    this.Hlm = paramInt;
    AppMethodBeat.o(235894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.b
 * JD-Core Version:    0.7.0.1
 */