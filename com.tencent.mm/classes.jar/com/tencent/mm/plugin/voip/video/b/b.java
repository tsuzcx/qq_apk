package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.a;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class b
{
  public int gtF;
  public int gtG;
  public int surfaceHeight;
  public int surfaceWidth;
  private int zxA;
  private int zxB;
  private ByteBuffer zxC;
  int zxD;
  int zxE;
  float[] zxF;
  float[] zxG;
  private int zxH;
  FloatBuffer zxI;
  byte[] zxj;
  private int zxm;
  private int zxn;
  private int zxo;
  private int zxp;
  private int zxq;
  private int zxr;
  int zxs;
  int zxt;
  int zxu;
  a zxv;
  d zxw;
  FloatBuffer zxx;
  FloatBuffer zxy;
  FloatBuffer zxz;
  
  public b()
  {
    AppMethodBeat.i(115717);
    this.zxs = 0;
    this.zxt = 0;
    this.zxu = 0;
    this.gtF = 0;
    this.gtG = 0;
    this.zxv = null;
    this.zxw = null;
    this.zxF = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.zxG = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.zxH = 0;
    AppMethodBeat.o(115717);
  }
  
  static void L(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    this.zxA = GLES20.glGetAttribLocation(paramInt1, "vPosition");
    GLES20.glEnableVertexAttribArray(this.zxA);
    GLES20.glVertexAttribPointer(this.zxA, 2, 5126, false, 8, paramFloatBuffer1);
    this.zxB = GLES20.glGetAttribLocation(paramInt1, "vTexCoord");
    GLES20.glEnableVertexAttribArray(this.zxB);
    GLES20.glVertexAttribPointer(this.zxB, 2, 5126, false, 8, paramFloatBuffer2);
    if (paramBoolean)
    {
      this.zxm = GLES20.glGetUniformLocation(paramInt1, "smoothDegree");
      GLES20.glUniform1f(this.zxm, 0.5F);
      this.zxn = GLES20.glGetUniformLocation(paramInt1, "showCounter");
      GLES20.glUniform1i(this.zxn, 0);
      this.zxo = GLES20.glGetUniformLocation(paramInt1, "showMode");
      GLES20.glUniform1i(this.zxo, 2);
      this.zxp = GLES20.glGetUniformLocation(paramInt1, "brightness");
      GLES20.glUniform1f(this.zxp, 0.8F);
      this.zxq = GLES20.glGetUniformLocation(paramInt1, "texelWidth");
      GLES20.glUniform1f(this.zxq, this.zxD);
      this.zxr = GLES20.glGetUniformLocation(paramInt1, "texelHeight");
      GLES20.glUniform1f(this.zxr, this.zxE);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(GLES20.glGetAttribLocation(paramInt1, "inputImageTexture"), 0);
    AppMethodBeat.o(115719);
  }
  
  public final void dXx()
  {
    AppMethodBeat.i(115723);
    ad.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.zxv != null) {
      this.zxv.close();
    }
    if (this.zxw != null) {
      this.zxw.close();
    }
    GLES20.glDeleteProgram(this.zxs);
    GLES20.glDeleteProgram(this.zxt);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFinish();
    if (this.zxy != null) {
      this.zxy.clear();
    }
    if (this.zxx != null) {
      this.zxx.clear();
    }
    if (this.zxI != null) {
      this.zxI.clear();
    }
    this.zxI = null;
    this.zxx = null;
    this.zxy = null;
    this.zxs = 0;
    this.zxt = 0;
    this.zxv = null;
    this.zxw = null;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.zxE = 0;
    this.zxD = 0;
    this.gtG = 0;
    this.gtF = 0;
    AppMethodBeat.o(115723);
  }
  
  public final void hZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115718);
    ad.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.zxw, this.zxv });
    if (this.zxv != null) {
      this.zxv.close();
    }
    if (this.zxw != null) {
      this.zxw.close();
    }
    this.zxD = paramInt1;
    this.zxE = paramInt2;
    this.zxw = f.dXt();
    this.zxv = f.dXu();
    GLES20.glBindTexture(3553, this.zxw.gro);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLES20.glTexImage2D(3553, 0, 6408, this.zxD, this.zxE, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(115718);
  }
  
  final void rY(boolean paramBoolean)
  {
    AppMethodBeat.i(115721);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (paramBoolean)
    {
      GLES20.glViewport(0, 0, this.gtF, this.gtG);
      GLES20.glDrawArrays(5, 0, 4);
      if ((this.zxC == null) || (this.zxC.capacity() < this.gtG * this.gtF * 4)) {
        this.zxC = ByteBuffer.allocateDirect(this.gtG * this.gtF * 4).order(ByteOrder.nativeOrder());
      }
      this.zxC.position(0);
      GLES20.glReadPixels(0, 0, this.gtF, this.gtG, 6408, 5121, this.zxC);
      this.zxC.position(0);
      this.zxj = this.zxC.array();
      L(0, 0, 0, 0);
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES20.glDisableVertexAttribArray(this.zxA);
      GLES20.glDisableVertexAttribArray(this.zxB);
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