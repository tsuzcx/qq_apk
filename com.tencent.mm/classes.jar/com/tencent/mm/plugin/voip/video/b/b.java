package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class b
{
  private int CpA;
  private int CpB;
  int CpC;
  int CpD;
  int CpE;
  a CpF;
  d CpG;
  FloatBuffer CpH;
  FloatBuffer CpI;
  FloatBuffer CpJ;
  private int CpK;
  private int CpL;
  ByteBuffer CpM;
  int CpN;
  int CpO;
  float[] CpP;
  float[] CpQ;
  private int CpR;
  FloatBuffer CpS;
  byte[] CpT;
  private int Cpw;
  private int Cpx;
  private int Cpy;
  private int Cpz;
  public int outputHeight;
  public int outputWidth;
  public int surfaceHeight;
  public int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(115717);
    this.CpC = 0;
    this.CpD = 0;
    this.CpE = 0;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.CpF = null;
    this.CpG = null;
    this.CpP = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.CpQ = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.CpR = 0;
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
    this.CpK = GLES20.glGetAttribLocation(paramInt1, "vPosition");
    GLES20.glEnableVertexAttribArray(this.CpK);
    GLES20.glVertexAttribPointer(this.CpK, 2, 5126, false, 8, paramFloatBuffer1);
    this.CpL = GLES20.glGetAttribLocation(paramInt1, "vTexCoord");
    GLES20.glEnableVertexAttribArray(this.CpL);
    GLES20.glVertexAttribPointer(this.CpL, 2, 5126, false, 8, paramFloatBuffer2);
    if (paramBoolean)
    {
      this.Cpw = GLES20.glGetUniformLocation(paramInt1, "smoothDegree");
      GLES20.glUniform1f(this.Cpw, 0.5F);
      this.Cpx = GLES20.glGetUniformLocation(paramInt1, "showCounter");
      GLES20.glUniform1i(this.Cpx, 0);
      this.Cpy = GLES20.glGetUniformLocation(paramInt1, "showMode");
      GLES20.glUniform1i(this.Cpy, 2);
      this.Cpz = GLES20.glGetUniformLocation(paramInt1, "brightness");
      GLES20.glUniform1f(this.Cpz, 0.8F);
      this.CpA = GLES20.glGetUniformLocation(paramInt1, "texelWidth");
      GLES20.glUniform1f(this.CpA, this.CpN);
      this.CpB = GLES20.glGetUniformLocation(paramInt1, "texelHeight");
      GLES20.glUniform1f(this.CpB, this.CpO);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(GLES20.glGetAttribLocation(paramInt1, "inputImageTexture"), 0);
    AppMethodBeat.o(115719);
  }
  
  public final void eAQ()
  {
    AppMethodBeat.i(115723);
    ad.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.CpF != null) {
      this.CpF.close();
    }
    if (this.CpG != null) {
      this.CpG.close();
    }
    GLES20.glDeleteProgram(this.CpC);
    GLES20.glDeleteProgram(this.CpD);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFinish();
    if (this.CpI != null) {
      this.CpI.clear();
    }
    if (this.CpH != null) {
      this.CpH.clear();
    }
    if (this.CpS != null) {
      this.CpS.clear();
    }
    this.CpS = null;
    this.CpH = null;
    this.CpI = null;
    this.CpC = 0;
    this.CpD = 0;
    this.CpF = null;
    this.CpG = null;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.CpO = 0;
    this.CpN = 0;
    this.outputHeight = 0;
    this.outputWidth = 0;
    AppMethodBeat.o(115723);
  }
  
  public final void iB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115718);
    ad.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.CpG, this.CpF });
    if (this.CpF != null) {
      this.CpF.close();
    }
    if (this.CpG != null) {
      this.CpG.close();
    }
    this.CpN = paramInt1;
    this.CpO = paramInt2;
    this.CpG = f.eAM();
    this.CpF = f.eAN();
    GLES20.glBindTexture(3553, this.CpG.hko);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLES20.glTexImage2D(3553, 0, 6408, this.CpN, this.CpO, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(115718);
  }
  
  final void tJ(boolean paramBoolean)
  {
    AppMethodBeat.i(115721);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (paramBoolean)
    {
      GLES20.glViewport(0, 0, this.outputWidth, this.outputHeight);
      GLES20.glDrawArrays(5, 0, 4);
      if ((this.CpM == null) || (this.CpM.capacity() < this.outputHeight * this.outputWidth * 4)) {
        this.CpM = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
      }
      this.CpM.position(0);
      GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, 6408, 5121, this.CpM);
      this.CpM.position(0);
      this.CpT = this.CpM.array();
      N(0, 0, 0, 0);
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES20.glDisableVertexAttribArray(this.CpK);
      GLES20.glDisableVertexAttribArray(this.CpL);
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