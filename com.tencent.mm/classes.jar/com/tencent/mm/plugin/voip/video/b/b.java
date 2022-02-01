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
  private int UPT;
  private int UPU;
  private int UPV;
  private int UPW;
  private int UPX;
  private int UPY;
  int UPZ;
  int UQa;
  int UQb;
  private a UQc;
  private d UQd;
  FloatBuffer UQe;
  private FloatBuffer UQf;
  private FloatBuffer UQg;
  private int UQh;
  private int UQi;
  ByteBuffer UQj;
  private int UQk;
  private int UQl;
  float[] UQm;
  float[] UQn;
  private int UQo;
  FloatBuffer UQp;
  byte[] UQq;
  public int outputHeight;
  public int outputWidth;
  public int surfaceHeight;
  public int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(115717);
    this.UPZ = 0;
    this.UQa = 0;
    this.UQb = 0;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.UQc = null;
    this.UQd = null;
    this.UQm = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.UQn = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.UQo = 0;
    AppMethodBeat.o(115717);
  }
  
  static void B(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(115720);
    swap(paramArrayOfFloat, 0, 6);
    swap(paramArrayOfFloat, 1, 7);
    swap(paramArrayOfFloat, 2, 4);
    swap(paramArrayOfFloat, 3, 5);
    AppMethodBeat.o(115720);
  }
  
  private void GU(boolean paramBoolean)
  {
    AppMethodBeat.i(115721);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (paramBoolean)
    {
      GLES20.glViewport(0, 0, this.outputWidth, this.outputHeight);
      GLES20.glDrawArrays(5, 0, 4);
      icW();
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES20.glDisableVertexAttribArray(this.UQh);
      GLES20.glDisableVertexAttribArray(this.UQi);
      AppMethodBeat.o(115721);
      return;
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glDrawArrays(5, 0, 4);
    }
  }
  
  private void a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, boolean paramBoolean)
  {
    AppMethodBeat.i(115719);
    GLES20.glUseProgram(paramInt1);
    this.UQh = GLES20.glGetAttribLocation(paramInt1, "vPosition");
    GLES20.glEnableVertexAttribArray(this.UQh);
    GLES20.glVertexAttribPointer(this.UQh, 2, 5126, false, 8, paramFloatBuffer1);
    this.UQi = GLES20.glGetAttribLocation(paramInt1, "vTexCoord");
    GLES20.glEnableVertexAttribArray(this.UQi);
    GLES20.glVertexAttribPointer(this.UQi, 2, 5126, false, 8, paramFloatBuffer2);
    if (paramBoolean)
    {
      this.UPT = GLES20.glGetUniformLocation(paramInt1, "smoothDegree");
      GLES20.glUniform1f(this.UPT, 0.5F);
      this.UPU = GLES20.glGetUniformLocation(paramInt1, "showCounter");
      GLES20.glUniform1i(this.UPU, 0);
      this.UPV = GLES20.glGetUniformLocation(paramInt1, "showMode");
      GLES20.glUniform1i(this.UPV, 2);
      this.UPW = GLES20.glGetUniformLocation(paramInt1, "brightness");
      GLES20.glUniform1f(this.UPW, 0.8F);
      this.UPX = GLES20.glGetUniformLocation(paramInt1, "texelWidth");
      GLES20.glUniform1f(this.UPX, this.UQk);
      this.UPY = GLES20.glGetUniformLocation(paramInt1, "texelHeight");
      GLES20.glUniform1f(this.UPY, this.UQl);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(GLES20.glGetAttribLocation(paramInt1, "inputImageTexture"), 0);
    AppMethodBeat.o(115719);
  }
  
  private static void ad(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  private void icW()
  {
    AppMethodBeat.i(292883);
    if ((this.UQj == null) || (this.UQj.capacity() < this.outputHeight * this.outputWidth * 4)) {
      this.UQj = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
    }
    this.UQj.position(0);
    GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, 6408, 5121, this.UQj);
    this.UQj.position(0);
    this.UQq = this.UQj.array();
    ad(0, 0, 0, 0);
    AppMethodBeat.o(292883);
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public final void g(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(292896);
    if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat1 != null))
    {
      paramArrayOfFloat2 = Arrays.copyOf(paramArrayOfFloat2, paramArrayOfFloat2.length);
      B(paramArrayOfFloat2);
      if ((this.UQf == null) || (this.UQf.capacity() < paramArrayOfFloat2.length)) {
        this.UQf = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      }
      this.UQf.put(paramArrayOfFloat2);
      this.UQf.position(0);
      paramArrayOfFloat1 = Arrays.copyOf(paramArrayOfFloat1, paramArrayOfFloat1.length);
      if ((this.UQg == null) || (this.UQg.capacity() < paramArrayOfFloat1.length)) {
        this.UQg = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      }
      this.UQg.put(paramArrayOfFloat1);
      this.UQg.position(0);
    }
    AppMethodBeat.o(292896);
  }
  
  public final void icV()
  {
    AppMethodBeat.i(292893);
    if ((this.UQc == null) || (this.UQk <= 0) || (this.UQl <= 0)) {
      mL(this.outputWidth, this.outputHeight);
    }
    ad(this.UQc.nAy, this.UQd.nAF, this.UQk, this.UQl);
    a(this.UPZ, this.UQb, this.UQe, this.UQp, true);
    GU(true);
    ad(0, 0, 0, 0);
    a(this.UQa, this.UQd.nAF, this.UQg, this.UQf, false);
    GU(false);
    AppMethodBeat.o(292893);
  }
  
  public final void icX()
  {
    AppMethodBeat.i(115723);
    Log.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.UQc != null) {
      this.UQc.close();
    }
    if (this.UQd != null) {
      this.UQd.close();
    }
    GLES20.glDeleteProgram(this.UPZ);
    GLES20.glDeleteProgram(this.UQa);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFinish();
    if (this.UQf != null) {
      this.UQf.clear();
    }
    if (this.UQe != null) {
      this.UQe.clear();
    }
    if (this.UQp != null) {
      this.UQp.clear();
    }
    this.UQp = null;
    this.UQe = null;
    this.UQf = null;
    this.UPZ = 0;
    this.UQa = 0;
    this.UQc = null;
    this.UQd = null;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.UQl = 0;
    this.UQk = 0;
    this.outputHeight = 0;
    this.outputWidth = 0;
    AppMethodBeat.o(115723);
  }
  
  public final void mL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115718);
    Log.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.UQd, this.UQc });
    if (this.UQc != null) {
      this.UQc.close();
    }
    if (this.UQd != null) {
      this.UQd.close();
    }
    this.UQk = paramInt1;
    this.UQl = paramInt2;
    this.UQd = f.icO();
    this.UQc = f.icP();
    GLES20.glBindTexture(3553, this.UQd.nAF);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLES20.glTexImage2D(3553, 0, 6408, this.UQk, this.UQl, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(115718);
  }
  
  public final void uc(int paramInt)
  {
    AppMethodBeat.i(292888);
    Log.i("MicroMsg.VoipGLSProgram", "set input texture:%s", new Object[] { Integer.valueOf(paramInt) });
    this.UQb = paramInt;
    AppMethodBeat.o(292888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.b
 * JD-Core Version:    0.7.0.1
 */