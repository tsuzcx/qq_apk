package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class a
{
  public int eXo;
  public int eXp;
  public int fbH;
  public int fbI;
  private int tHV;
  private int tHW;
  private int tHX;
  private int tHY;
  private int tHZ;
  private int tIa;
  int tIb;
  int tIc;
  int tId;
  int tIe;
  int tIf;
  FloatBuffer tIg;
  FloatBuffer tIh;
  FloatBuffer tIi;
  private int tIj;
  private int tIk;
  private ByteBuffer tIl;
  int tIm;
  int tIn;
  float[] tIo;
  float[] tIp;
  private int tIq;
  FloatBuffer tIr;
  byte[] tIs;
  
  public a()
  {
    AppMethodBeat.i(140213);
    this.tIb = 0;
    this.tIc = 0;
    this.tId = 0;
    this.eXo = 0;
    this.eXp = 0;
    this.tIe = -1;
    this.tIf = -1;
    this.tIo = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.tIp = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.tIq = 0;
    AppMethodBeat.o(140213);
  }
  
  private static void a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  static void k(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(140216);
    a(paramArrayOfFloat, 0, 6);
    a(paramArrayOfFloat, 1, 7);
    a(paramArrayOfFloat, 2, 4);
    a(paramArrayOfFloat, 3, 5);
    AppMethodBeat.o(140216);
  }
  
  static void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140218);
    GLES20.glBindFramebuffer(36160, paramInt1);
    if (paramInt1 > 0)
    {
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt2, 0);
      GLES20.glBindTexture(3553, 0);
    }
    AppMethodBeat.o(140218);
  }
  
  final void a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, boolean paramBoolean)
  {
    AppMethodBeat.i(140215);
    GLES20.glUseProgram(paramInt1);
    this.tIj = GLES20.glGetAttribLocation(paramInt1, "vPosition");
    GLES20.glEnableVertexAttribArray(this.tIj);
    GLES20.glVertexAttribPointer(this.tIj, 2, 5126, false, 8, paramFloatBuffer1);
    this.tIk = GLES20.glGetAttribLocation(paramInt1, "vTexCoord");
    GLES20.glEnableVertexAttribArray(this.tIk);
    GLES20.glVertexAttribPointer(this.tIk, 2, 5126, false, 8, paramFloatBuffer2);
    if (paramBoolean)
    {
      this.tHV = GLES20.glGetUniformLocation(paramInt1, "smoothDegree");
      GLES20.glUniform1f(this.tHV, 0.7F);
      this.tHW = GLES20.glGetUniformLocation(paramInt1, "showCounter");
      GLES20.glUniform1i(this.tHW, 0);
      this.tHX = GLES20.glGetUniformLocation(paramInt1, "showMode");
      GLES20.glUniform1i(this.tHX, 2);
      this.tHY = GLES20.glGetUniformLocation(paramInt1, "brightness");
      GLES20.glUniform1f(this.tHY, 0.8F);
      this.tHZ = GLES20.glGetUniformLocation(paramInt1, "texelWidth");
      GLES20.glUniform1f(this.tHZ, this.tIm);
      this.tIa = GLES20.glGetUniformLocation(paramInt1, "texelHeight");
      GLES20.glUniform1f(this.tIa, this.tIn);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(GLES20.glGetAttribLocation(paramInt1, "inputImageTexture"), 0);
    AppMethodBeat.o(140215);
  }
  
  public final void cPT()
  {
    AppMethodBeat.i(140219);
    ab.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
    GLES20.glDeleteFramebuffers(1, new int[] { this.tIe }, 0);
    GLES20.glDeleteTextures(1, new int[] { this.tIf }, 0);
    GLES20.glDeleteProgram(this.tIb);
    GLES20.glDeleteProgram(this.tIc);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFinish();
    if (this.tIh != null) {
      this.tIh.clear();
    }
    if (this.tIg != null) {
      this.tIg.clear();
    }
    if (this.tIr != null) {
      this.tIr.clear();
    }
    this.tIr = null;
    this.tIg = null;
    this.tIh = null;
    this.tIb = 0;
    this.tIc = 0;
    this.tIe = 0;
    this.tIf = 0;
    this.fbH = 0;
    this.fbI = 0;
    this.tIn = 0;
    this.tIm = 0;
    this.eXp = 0;
    this.eXo = 0;
    AppMethodBeat.o(140219);
  }
  
  public final void gq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140214);
    ab.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.tIf), Integer.valueOf(this.tIe) });
    if (this.tIe > 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { this.tIe }, 0);
    }
    if (this.tIf > 0) {
      GLES20.glDeleteTextures(1, new int[] { this.tIf }, 0);
    }
    this.tIm = paramInt1;
    this.tIn = paramInt2;
    this.tIf = e.Vm();
    this.tIe = e.Vn();
    GLES20.glBindTexture(3553, this.tIf);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLES20.glTexImage2D(3553, 0, 6408, this.tIm, this.tIn, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(140214);
  }
  
  final void ng(boolean paramBoolean)
  {
    AppMethodBeat.i(140217);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (paramBoolean)
    {
      GLES20.glViewport(0, 0, this.eXo, this.eXp);
      GLES20.glDrawArrays(5, 0, 4);
      if ((this.tIl == null) || (this.tIl.capacity() < this.eXp * this.eXo * 4)) {
        this.tIl = ByteBuffer.allocateDirect(this.eXp * this.eXo * 4).order(ByteOrder.nativeOrder());
      }
      this.tIl.position(0);
      GLES20.glReadPixels(0, 0, this.eXo, this.eXp, 6408, 5121, this.tIl);
      this.tIl.position(0);
      this.tIs = this.tIl.array();
      r(0, 0, 0, 0);
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES20.glDisableVertexAttribArray(this.tIj);
      GLES20.glDisableVertexAttribArray(this.tIk);
      AppMethodBeat.o(140217);
      return;
      GLES20.glViewport(0, 0, this.fbH, this.fbI);
      GLES20.glDrawArrays(5, 0, 4);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(a.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.a
 * JD-Core Version:    0.7.0.1
 */