package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.a;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ac;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class b
{
  FloatBuffer AQA;
  byte[] AQB;
  private int AQe;
  private int AQf;
  private int AQg;
  private int AQh;
  private int AQi;
  private int AQj;
  int AQk;
  int AQl;
  int AQm;
  a AQn;
  d AQo;
  FloatBuffer AQp;
  FloatBuffer AQq;
  FloatBuffer AQr;
  private int AQs;
  private int AQt;
  ByteBuffer AQu;
  int AQv;
  int AQw;
  float[] AQx;
  float[] AQy;
  private int AQz;
  public int grA;
  public int grB;
  public int surfaceHeight;
  public int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(115717);
    this.AQk = 0;
    this.AQl = 0;
    this.AQm = 0;
    this.grA = 0;
    this.grB = 0;
    this.AQn = null;
    this.AQo = null;
    this.AQx = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.AQy = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.AQz = 0;
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
    this.AQs = GLES20.glGetAttribLocation(paramInt1, "vPosition");
    GLES20.glEnableVertexAttribArray(this.AQs);
    GLES20.glVertexAttribPointer(this.AQs, 2, 5126, false, 8, paramFloatBuffer1);
    this.AQt = GLES20.glGetAttribLocation(paramInt1, "vTexCoord");
    GLES20.glEnableVertexAttribArray(this.AQt);
    GLES20.glVertexAttribPointer(this.AQt, 2, 5126, false, 8, paramFloatBuffer2);
    if (paramBoolean)
    {
      this.AQe = GLES20.glGetUniformLocation(paramInt1, "smoothDegree");
      GLES20.glUniform1f(this.AQe, 0.5F);
      this.AQf = GLES20.glGetUniformLocation(paramInt1, "showCounter");
      GLES20.glUniform1i(this.AQf, 0);
      this.AQg = GLES20.glGetUniformLocation(paramInt1, "showMode");
      GLES20.glUniform1i(this.AQg, 2);
      this.AQh = GLES20.glGetUniformLocation(paramInt1, "brightness");
      GLES20.glUniform1f(this.AQh, 0.8F);
      this.AQi = GLES20.glGetUniformLocation(paramInt1, "texelWidth");
      GLES20.glUniform1f(this.AQi, this.AQv);
      this.AQj = GLES20.glGetUniformLocation(paramInt1, "texelHeight");
      GLES20.glUniform1f(this.AQj, this.AQw);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(GLES20.glGetAttribLocation(paramInt1, "inputImageTexture"), 0);
    AppMethodBeat.o(115719);
  }
  
  public final void emS()
  {
    AppMethodBeat.i(115723);
    ac.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.AQn != null) {
      this.AQn.close();
    }
    if (this.AQo != null) {
      this.AQo.close();
    }
    GLES20.glDeleteProgram(this.AQk);
    GLES20.glDeleteProgram(this.AQl);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFinish();
    if (this.AQq != null) {
      this.AQq.clear();
    }
    if (this.AQp != null) {
      this.AQp.clear();
    }
    if (this.AQA != null) {
      this.AQA.clear();
    }
    this.AQA = null;
    this.AQp = null;
    this.AQq = null;
    this.AQk = 0;
    this.AQl = 0;
    this.AQn = null;
    this.AQo = null;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.AQw = 0;
    this.AQv = 0;
    this.grB = 0;
    this.grA = 0;
    AppMethodBeat.o(115723);
  }
  
  public final void io(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115718);
    ac.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.AQo, this.AQn });
    if (this.AQn != null) {
      this.AQn.close();
    }
    if (this.AQo != null) {
      this.AQo.close();
    }
    this.AQv = paramInt1;
    this.AQw = paramInt2;
    this.AQo = f.emO();
    this.AQn = f.emP();
    GLES20.glBindTexture(3553, this.AQo.gRW);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLES20.glTexImage2D(3553, 0, 6408, this.AQv, this.AQw, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(115718);
  }
  
  final void sZ(boolean paramBoolean)
  {
    AppMethodBeat.i(115721);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (paramBoolean)
    {
      GLES20.glViewport(0, 0, this.grA, this.grB);
      GLES20.glDrawArrays(5, 0, 4);
      if ((this.AQu == null) || (this.AQu.capacity() < this.grB * this.grA * 4)) {
        this.AQu = ByteBuffer.allocateDirect(this.grB * this.grA * 4).order(ByteOrder.nativeOrder());
      }
      this.AQu.position(0);
      GLES20.glReadPixels(0, 0, this.grA, this.grB, 6408, 5121, this.AQu);
      this.AQu.position(0);
      this.AQB = this.AQu.array();
      N(0, 0, 0, 0);
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES20.glDisableVertexAttribArray(this.AQs);
      GLES20.glDisableVertexAttribArray(this.AQt);
      AppMethodBeat.o(115721);
      return;
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glDrawArrays(5, 0, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.b
 * JD-Core Version:    0.7.0.1
 */