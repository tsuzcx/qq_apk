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
  private int ObT;
  private int ObU;
  private int ObV;
  private int ObW;
  private int ObX;
  private int ObY;
  int ObZ;
  int Oca;
  int Ocb;
  private a Occ;
  private d Ocd;
  FloatBuffer Oce;
  private FloatBuffer Ocf;
  private FloatBuffer Ocg;
  private int Och;
  private int Oci;
  ByteBuffer Ocj;
  private int Ock;
  private int Ocl;
  float[] Ocm;
  float[] Ocn;
  private int Oco;
  FloatBuffer Ocp;
  byte[] Ocq;
  public int outputHeight;
  public int outputWidth;
  public int surfaceHeight;
  public int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(115717);
    this.ObZ = 0;
    this.Oca = 0;
    this.Ocb = 0;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.Occ = null;
    this.Ocd = null;
    this.Ocm = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.Ocn = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.Oco = 0;
    AppMethodBeat.o(115717);
  }
  
  private void Br(boolean paramBoolean)
  {
    AppMethodBeat.i(115721);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (paramBoolean)
    {
      GLES20.glViewport(0, 0, this.outputWidth, this.outputHeight);
      GLES20.glDrawArrays(5, 0, 4);
      gEe();
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES20.glDisableVertexAttribArray(this.Och);
      GLES20.glDisableVertexAttribArray(this.Oci);
      AppMethodBeat.o(115721);
      return;
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glDrawArrays(5, 0, 4);
    }
  }
  
  private static void T(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    this.Och = GLES20.glGetAttribLocation(paramInt1, "vPosition");
    GLES20.glEnableVertexAttribArray(this.Och);
    GLES20.glVertexAttribPointer(this.Och, 2, 5126, false, 8, paramFloatBuffer1);
    this.Oci = GLES20.glGetAttribLocation(paramInt1, "vTexCoord");
    GLES20.glEnableVertexAttribArray(this.Oci);
    GLES20.glVertexAttribPointer(this.Oci, 2, 5126, false, 8, paramFloatBuffer2);
    if (paramBoolean)
    {
      this.ObT = GLES20.glGetUniformLocation(paramInt1, "smoothDegree");
      GLES20.glUniform1f(this.ObT, 0.5F);
      this.ObU = GLES20.glGetUniformLocation(paramInt1, "showCounter");
      GLES20.glUniform1i(this.ObU, 0);
      this.ObV = GLES20.glGetUniformLocation(paramInt1, "showMode");
      GLES20.glUniform1i(this.ObV, 2);
      this.ObW = GLES20.glGetUniformLocation(paramInt1, "brightness");
      GLES20.glUniform1f(this.ObW, 0.8F);
      this.ObX = GLES20.glGetUniformLocation(paramInt1, "texelWidth");
      GLES20.glUniform1f(this.ObX, this.Ock);
      this.ObY = GLES20.glGetUniformLocation(paramInt1, "texelHeight");
      GLES20.glUniform1f(this.ObY, this.Ocl);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(GLES20.glGetAttribLocation(paramInt1, "inputImageTexture"), 0);
    AppMethodBeat.o(115719);
  }
  
  private void gEe()
  {
    AppMethodBeat.i(234950);
    if ((this.Ocj == null) || (this.Ocj.capacity() < this.outputHeight * this.outputWidth * 4)) {
      this.Ocj = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
    }
    this.Ocj.position(0);
    GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, 6408, 5121, this.Ocj);
    this.Ocj.position(0);
    this.Ocq = this.Ocj.array();
    T(0, 0, 0, 0);
    AppMethodBeat.o(234950);
  }
  
  static void r(float[] paramArrayOfFloat)
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
  
  public final void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(234942);
    if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat1 != null))
    {
      paramArrayOfFloat2 = Arrays.copyOf(paramArrayOfFloat2, paramArrayOfFloat2.length);
      r(paramArrayOfFloat2);
      if ((this.Ocf == null) || (this.Ocf.capacity() < paramArrayOfFloat2.length)) {
        this.Ocf = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      }
      this.Ocf.put(paramArrayOfFloat2);
      this.Ocf.position(0);
      paramArrayOfFloat1 = Arrays.copyOf(paramArrayOfFloat1, paramArrayOfFloat1.length);
      if ((this.Ocg == null) || (this.Ocg.capacity() < paramArrayOfFloat1.length)) {
        this.Ocg = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      }
      this.Ocg.put(paramArrayOfFloat1);
      this.Ocg.position(0);
    }
    AppMethodBeat.o(234942);
  }
  
  public final void gEd()
  {
    AppMethodBeat.i(234937);
    if ((this.Occ == null) || (this.Ock <= 0) || (this.Ocl <= 0)) {
      kZ(this.outputWidth, this.outputHeight);
    }
    T(this.Occ.kVc, this.Ocd.kVj, this.Ock, this.Ocl);
    a(this.ObZ, this.Ocb, this.Oce, this.Ocp, true);
    Br(true);
    T(0, 0, 0, 0);
    a(this.Oca, this.Ocd.kVj, this.Ocg, this.Ocf, false);
    Br(false);
    AppMethodBeat.o(234937);
  }
  
  public final void gEf()
  {
    AppMethodBeat.i(115723);
    Log.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.Occ != null) {
      this.Occ.close();
    }
    if (this.Ocd != null) {
      this.Ocd.close();
    }
    GLES20.glDeleteProgram(this.ObZ);
    GLES20.glDeleteProgram(this.Oca);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFinish();
    if (this.Ocf != null) {
      this.Ocf.clear();
    }
    if (this.Oce != null) {
      this.Oce.clear();
    }
    if (this.Ocp != null) {
      this.Ocp.clear();
    }
    this.Ocp = null;
    this.Oce = null;
    this.Ocf = null;
    this.ObZ = 0;
    this.Oca = 0;
    this.Occ = null;
    this.Ocd = null;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.Ocl = 0;
    this.Ock = 0;
    this.outputHeight = 0;
    this.outputWidth = 0;
    AppMethodBeat.o(115723);
  }
  
  public final void kZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115718);
    Log.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.Ocd, this.Occ });
    if (this.Occ != null) {
      this.Occ.close();
    }
    if (this.Ocd != null) {
      this.Ocd.close();
    }
    this.Ock = paramInt1;
    this.Ocl = paramInt2;
    this.Ocd = f.gDZ();
    this.Occ = f.gEa();
    GLES20.glBindTexture(3553, this.Ocd.kVj);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLES20.glTexImage2D(3553, 0, 6408, this.Ock, this.Ocl, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(115718);
  }
  
  public final void ua(int paramInt)
  {
    AppMethodBeat.i(234923);
    Log.i("MicroMsg.VoipGLSProgram", "set input texture:%s", new Object[] { Integer.valueOf(paramInt) });
    this.Ocb = paramInt;
    AppMethodBeat.o(234923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.b
 * JD-Core Version:    0.7.0.1
 */