package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class b
{
  private int CHa;
  private int CHb;
  private int CHc;
  private int CHd;
  private int CHe;
  private int CHf;
  int CHg;
  int CHh;
  int CHi;
  a CHj;
  d CHk;
  FloatBuffer CHl;
  FloatBuffer CHm;
  FloatBuffer CHn;
  private int CHo;
  private int CHp;
  ByteBuffer CHq;
  int CHr;
  int CHs;
  float[] CHt;
  float[] CHu;
  private int CHv;
  FloatBuffer CHw;
  byte[] CHx;
  public int outputHeight;
  public int outputWidth;
  public int surfaceHeight;
  public int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(115717);
    this.CHg = 0;
    this.CHh = 0;
    this.CHi = 0;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.CHj = null;
    this.CHk = null;
    this.CHt = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.CHu = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.CHv = 0;
    AppMethodBeat.o(115717);
  }
  
  static void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  final void a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, boolean paramBoolean)
  {
    AppMethodBeat.i(115719);
    GLES20.glUseProgram(paramInt1);
    this.CHo = GLES20.glGetAttribLocation(paramInt1, "vPosition");
    GLES20.glEnableVertexAttribArray(this.CHo);
    GLES20.glVertexAttribPointer(this.CHo, 2, 5126, false, 8, paramFloatBuffer1);
    this.CHp = GLES20.glGetAttribLocation(paramInt1, "vTexCoord");
    GLES20.glEnableVertexAttribArray(this.CHp);
    GLES20.glVertexAttribPointer(this.CHp, 2, 5126, false, 8, paramFloatBuffer2);
    if (paramBoolean)
    {
      this.CHa = GLES20.glGetUniformLocation(paramInt1, "smoothDegree");
      GLES20.glUniform1f(this.CHa, 0.5F);
      this.CHb = GLES20.glGetUniformLocation(paramInt1, "showCounter");
      GLES20.glUniform1i(this.CHb, 0);
      this.CHc = GLES20.glGetUniformLocation(paramInt1, "showMode");
      GLES20.glUniform1i(this.CHc, 2);
      this.CHd = GLES20.glGetUniformLocation(paramInt1, "brightness");
      GLES20.glUniform1f(this.CHd, 0.8F);
      this.CHe = GLES20.glGetUniformLocation(paramInt1, "texelWidth");
      GLES20.glUniform1f(this.CHe, this.CHr);
      this.CHf = GLES20.glGetUniformLocation(paramInt1, "texelHeight");
      GLES20.glUniform1f(this.CHf, this.CHs);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(GLES20.glGetAttribLocation(paramInt1, "inputImageTexture"), 0);
    AppMethodBeat.o(115719);
  }
  
  public final void eEy()
  {
    AppMethodBeat.i(115723);
    ae.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.CHj != null) {
      this.CHj.close();
    }
    if (this.CHk != null) {
      this.CHk.close();
    }
    GLES20.glDeleteProgram(this.CHg);
    GLES20.glDeleteProgram(this.CHh);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFinish();
    if (this.CHm != null) {
      this.CHm.clear();
    }
    if (this.CHl != null) {
      this.CHl.clear();
    }
    if (this.CHw != null) {
      this.CHw.clear();
    }
    this.CHw = null;
    this.CHl = null;
    this.CHm = null;
    this.CHg = 0;
    this.CHh = 0;
    this.CHj = null;
    this.CHk = null;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.CHs = 0;
    this.CHr = 0;
    this.outputHeight = 0;
    this.outputWidth = 0;
    AppMethodBeat.o(115723);
  }
  
  public final void iF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115718);
    ae.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.CHk, this.CHj });
    if (this.CHj != null) {
      this.CHj.close();
    }
    if (this.CHk != null) {
      this.CHk.close();
    }
    this.CHr = paramInt1;
    this.CHs = paramInt2;
    this.CHk = f.eEu();
    this.CHj = f.eEv();
    GLES20.glBindTexture(3553, this.CHk.hnc);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLES20.glTexImage2D(3553, 0, 6408, this.CHr, this.CHs, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(115718);
  }
  
  final void tQ(boolean paramBoolean)
  {
    AppMethodBeat.i(115721);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (paramBoolean)
    {
      GLES20.glViewport(0, 0, this.outputWidth, this.outputHeight);
      GLES20.glDrawArrays(5, 0, 4);
      if ((this.CHq == null) || (this.CHq.capacity() < this.outputHeight * this.outputWidth * 4)) {
        this.CHq = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
      }
      this.CHq.position(0);
      GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, 6408, 5121, this.CHq);
      this.CHq.position(0);
      this.CHx = this.CHq.array();
      N(0, 0, 0, 0);
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES20.glDisableVertexAttribArray(this.CHo);
      GLES20.glDisableVertexAttribArray(this.CHp);
      AppMethodBeat.o(115721);
      return;
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glDrawArrays(5, 0, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.b
 * JD-Core Version:    0.7.0.1
 */