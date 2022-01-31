package com.tencent.mm.plugin.voip.video.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.ttpic.PTFilter;
import com.tencent.ttpic.PTFilter.PTCopyFilter;
import com.tencent.ttpic.PTSmoothSkin;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.view.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class b
{
  public static final float[] fvS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] fvU = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] qcd = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public volatile boolean dNv = false;
  private int fvY;
  private int fvZ;
  private ByteBuffer fwa;
  private ByteBuffer fwb;
  public int fwc;
  public int fwd;
  public int fwh;
  public int fwi;
  public FloatBuffer fwk;
  public FloatBuffer fwl;
  private float[] fwm = new float[16];
  public float[] fwo = fvS;
  public int jrQ;
  public int jrR;
  public int jrS;
  public int jrT;
  public int jrV;
  public int jrW;
  public int jrX;
  public int jrY;
  public int jrZ;
  public FloatBuffer jse;
  public FloatBuffer jsf;
  private ByteBuffer jsh;
  public float[] jsj = fvS;
  public float[] jsk;
  public int jsl;
  public int jsm;
  public int jsn;
  public int jsp;
  private int jsq;
  private int jsr;
  public byte[] jss;
  public byte[] pWI;
  public int qce;
  private int qcf;
  private int qcg;
  public volatile a qch = new a();
  private boolean qci;
  private boolean qcj = false;
  private int rotate;
  
  public static int YW()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    return arrayOfInt[0];
  }
  
  public static int aKY()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      y.e("MicroMsg.FilterRenderer", "gen frame buffer error");
      return 0;
    }
    return arrayOfInt[0];
  }
  
  public static int aW(String paramString1, String paramString2)
  {
    int[] arrayOfInt = new int[1];
    int i = ae(paramString1, 35633);
    if (i == 0)
    {
      y.e("MicroMsg.FilterRenderer", "load vertex shader failed");
      return 0;
    }
    int j = ae(paramString2, 35632);
    if (j == 0)
    {
      y.e("MicroMsg.FilterRenderer", "load fragment shader failed");
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      y.e("MicroMsg.FilterRenderer", "link program failed");
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
  
  private static int ae(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      y.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(paramInt));
      return 0;
    }
    return paramInt;
  }
  
  public final byte[] bSF()
  {
    if ((this.qch != null) && (this.qch.jkc != null))
    {
      if ((this.pWI == null) || (this.pWI.length != this.qch.jkc.length)) {
        this.pWI = new byte[this.qch.jkc.length];
      }
      System.arraycopy(this.qch.jkc, 0, this.pWI, 0, this.qch.jkc.length);
      return this.pWI;
    }
    return null;
  }
  
  public final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    label53:
    boolean bool;
    int i;
    try
    {
      if (this.fvY != paramInt1) {
        break label2981;
      }
      if (this.fvZ == paramInt2) {
        break label2975;
      }
    }
    finally {}
    this.fvY = paramInt1;
    this.fvZ = paramInt2;
    paramInt1 = paramInt3 >> 2 & 0x3;
    if (paramInt1 == 3)
    {
      this.rotate = 270;
      break label2987;
      this.qci = bool;
      if (OpenGlRender.qbn == 1) {
        break label1881;
      }
      bool = true;
      label69:
      this.qcj = bool;
      if ((this.qch == null) && (paramInt4 != 0))
      {
        this.qch = new a();
        this.qch.er(this.jsn, this.jsp);
      }
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      if (!this.qcj) {
        break label1901;
      }
      if ((this.jrQ != 0) && (this.fwc != -1) && (this.fwd != -1) && (this.fvY > 0) && (this.fvZ > 0) && (paramArrayOfByte != null))
      {
        if ((this.fwa == null) || (this.fwb == null) || (this.fwa.capacity() != this.fvZ * this.fvY) || (this.fwb.capacity() != this.fvY * this.fvZ / 2))
        {
          this.fwa = ByteBuffer.allocateDirect(this.fvZ * this.fvY);
          this.fwb = ByteBuffer.allocateDirect(this.fvY * this.fvZ / 2);
          this.fwa.order(ByteOrder.nativeOrder());
          this.fwb.order(ByteOrder.nativeOrder());
        }
        this.fwa.put(paramArrayOfByte, 0, this.fvY * this.fvZ);
        this.fwa.position(0);
        this.fwb.put(paramArrayOfByte, this.fvY * this.fvZ, this.fvY * this.fvZ / 2);
        this.fwb.position(0);
        GLES20.glBindFramebuffer(36160, this.jsl);
        GLES20.glBindTexture(3553, this.jsn);
        this.qcf = this.fvY;
        this.qcg = this.fvZ;
        GLES20.glTexImage2D(3553, 0, 6408, this.qcf, this.qcg, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jsn, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glViewport(0, 0, this.qcf, this.qcg);
        GLES20.glUseProgram(this.jrQ);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.fwc);
        GLES20.glTexImage2D(3553, 0, 6409, this.fvY, this.fvZ, 0, 6409, 5121, this.fwa);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glUniform1i(this.fwh, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.fwd);
        GLES20.glTexImage2D(3553, 0, 6410, this.fvY / 2, this.fvZ / 2, 0, 6410, 5121, this.fwb);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glUniform1i(this.fwi, 1);
        Matrix.setIdentityM(this.fwm, 0);
        if (!this.qci) {
          break label1887;
        }
        Matrix.scaleM(this.fwm, 0, -1.0F, 1.0F, 1.0F);
        label687:
        GLES20.glUniformMatrix4fv(this.jrT, 1, false, this.fwm, 0);
        this.fwk.position(0);
        GLES20.glVertexAttribPointer(this.jrS, 2, 5126, false, 0, this.fwk);
        GLES20.glEnableVertexAttribArray(this.jrS);
        this.fwl.position(0);
        GLES20.glVertexAttribPointer(this.jrR, 2, 5126, false, 0, this.fwl);
        GLES20.glEnableVertexAttribArray(this.jrR);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.jrS);
        GLES20.glDisableVertexAttribArray(this.jrR);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        GLES20.glFinish();
      }
      label807:
      if ((paramInt4 != 0) && ((this.jss == null) || (i != 0)))
      {
        y.i("MicroMsg.FilterRenderer", "%s frameSizeChange %s %s %s %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.qcf), Integer.valueOf(this.qcg), Integer.valueOf(this.jsq), Integer.valueOf(this.jsr) });
        this.jss = new byte[this.qcf * this.qcg * 4];
        this.qch.jkc = this.jss;
      }
      if (paramInt4 == 0) {
        break label2460;
      }
      paramArrayOfByte = this.qch;
      paramInt1 = this.qcf;
      paramInt2 = this.qcg;
      paramArrayOfByte.jkd = paramInt1;
      paramArrayOfByte.jke = paramInt2;
      paramArrayOfByte = this.qch;
      i = paramArrayOfByte.jjV;
      if ((paramInt4 & 0x1) == 0) {
        break label3016;
      }
      paramInt2 = 1;
      break label3003;
    }
    for (;;)
    {
      paramInt1 = i;
      if (paramInt2 != 0)
      {
        paramInt1 = i;
        if (paramArrayOfByte.jjR != null)
        {
          paramInt1 = i;
          if (paramArrayOfByte.jjR.getBeautyLevel() > 0)
          {
            BenchUtil.benchStart("PTSmoothSkin");
            paramArrayOfByte.jjR.processTexture(i, paramArrayOfByte.jkd, paramArrayOfByte.jke, paramArrayOfByte.jjX);
            paramInt1 = paramArrayOfByte.jjX;
            BenchUtil.benchEnd("PTSmoothSkin");
            y.d(a.TAG, "%s mSmoothOutTex: %s", new Object[] { Integer.valueOf(paramArrayOfByte.hashCode()), Integer.valueOf(paramArrayOfByte.jjX) });
          }
        }
      }
      paramInt2 = paramInt1;
      if (paramInt3 != 0)
      {
        paramInt2 = paramInt1;
        if (paramArrayOfByte.qcb != null)
        {
          BenchUtil.benchStart("PTFilter");
          paramArrayOfByte.qcb.processTexture(paramInt1, paramArrayOfByte.jkd, paramArrayOfByte.jke, paramArrayOfByte.jjY);
          paramInt2 = paramArrayOfByte.jjY;
          BenchUtil.benchEnd("PTFilter");
          y.d(a.TAG, "%s mFilterOutTex: %s", new Object[] { Integer.valueOf(paramArrayOfByte.hashCode()), Integer.valueOf(paramArrayOfByte.jjX) });
        }
      }
      label1223:
      label1490:
      label1512:
      float f1;
      label1542:
      float f2;
      float f3;
      float f4;
      if (paramArrayOfByte.jjU != null)
      {
        if ((paramArrayOfByte.jjW != 0) && (paramArrayOfByte.qcc != 0))
        {
          paramArrayOfByte.jjU.processTexture(paramInt2, paramArrayOfByte.jkd, paramArrayOfByte.jke, paramArrayOfByte.jjW);
          f.a(paramArrayOfByte.jjW, paramArrayOfByte.jkd, paramArrayOfByte.jke, paramArrayOfByte.jkc, paramArrayOfByte.qcc);
        }
      }
      else
      {
        paramArrayOfByte = this.qch.jkc;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
        if ((this.qce != 0) && (this.qcf > 0) && (this.qcg > 0) && (paramArrayOfByte != null))
        {
          if ((this.jsh == null) || (this.jsh.capacity() != this.qcf * this.qcg * 4))
          {
            this.jsh = ByteBuffer.allocateDirect(this.qcf * this.qcg * 4);
            this.jsh.order(ByteOrder.nativeOrder());
          }
          this.jsh.put(paramArrayOfByte, 0, paramArrayOfByte.length);
          this.jsh.position(0);
          GLES20.glViewport(0, 0, this.jsq, this.jsr);
          GLES20.glUseProgram(this.qce);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, this.jrV);
          GLES20.glTexImage2D(3553, 0, 6408, this.qcf, this.qcg, 0, 6408, 5121, this.jsh);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.jrY, 0);
          if ((this.rotate != 0) && (this.rotate != 180)) {
            break label2431;
          }
          paramInt1 = this.qcf;
          if ((this.rotate != 0) && (this.rotate != 180)) {
            break label2439;
          }
          paramInt2 = this.qcg;
          if (paramInt1 / paramInt2 >= this.jsq / this.jsr) {
            break label2447;
          }
          f1 = this.jsq / paramInt1;
          paramInt3 = (int)(this.jsq / f1);
          paramInt4 = (int)(this.jsr / f1);
          Matrix.setIdentityM(this.fwm, 0);
          if (this.rotate > 0) {
            Matrix.setRotateM(this.fwm, 0, Math.abs(this.rotate - 180), 0.0F, 0.0F, -1.0F);
          }
          GLES20.glUniformMatrix4fv(this.jrZ, 1, false, this.fwm, 0);
          this.jsf.put(this.jsj);
          this.jsf.position(0);
          GLES20.glVertexAttribPointer(this.jrX, 2, 5126, false, 0, this.jsf);
          GLES20.glEnableVertexAttribArray(this.jrX);
          f1 = (paramInt1 - paramInt3) / 2.0F / paramInt1;
          f2 = 1.0F - f1;
          f3 = (paramInt2 - paramInt4) / 2.0F / paramInt2;
          f4 = 1.0F - f3;
          this.jsk[0] = f3;
          this.jsk[1] = f1;
          this.jsk[2] = f4;
          this.jsk[3] = f1;
          this.jsk[4] = f3;
          this.jsk[5] = f2;
          this.jsk[6] = f4;
          this.jsk[7] = f2;
          this.jse.put(this.jsk);
          this.jse.position(0);
          GLES20.glVertexAttribPointer(this.jrW, 2, 5126, false, 0, this.jse);
          GLES20.glEnableVertexAttribArray(this.jrW);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.jrX);
          GLES20.glDisableVertexAttribArray(this.jrW);
          GLES20.glBindTexture(3553, 0);
          GLES20.glUseProgram(0);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        return;
        if (paramInt1 != 1) {
          break label2987;
        }
        this.rotate = 90;
      }
      label1881:
      label1887:
      label1901:
      label2431:
      while ((paramInt3 >> 4 & 0x1) != 1)
      {
        bool = false;
        break label53;
        bool = false;
        break label69;
        Matrix.scaleM(this.fwm, 0, 1.0F, 1.0F, 1.0F);
        break label687;
        if ((this.qce == 0) || (this.jsn == -1) || (this.fvY <= 0) || (this.fvZ <= 0) || (paramArrayOfByte == null)) {
          break label807;
        }
        if ((this.jsh == null) || (this.jsh.capacity() != this.fvZ * this.fvY * 4))
        {
          this.jsh = ByteBuffer.allocateDirect(this.fvZ * this.fvY * 4);
          this.jsh.order(ByteOrder.nativeOrder());
        }
        this.jsh.put(paramArrayOfByte, 0, this.fvY * this.fvZ * 4);
        this.jsh.position(0);
        GLES20.glBindFramebuffer(36160, this.jsl);
        GLES20.glBindTexture(3553, this.jsn);
        if ((this.rotate == 180) || (this.rotate == 0))
        {
          paramInt1 = this.fvY;
          this.qcf = paramInt1;
          if ((this.rotate != 180) && (this.rotate != 0)) {
            break label2371;
          }
        }
        for (paramInt1 = this.fvZ;; paramInt1 = this.fvY)
        {
          this.qcg = paramInt1;
          GLES20.glTexImage2D(3553, 0, 6408, this.qcf, this.qcg, 0, 6408, 5121, null);
          GLES20.glBindTexture(3553, 0);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jsn, 0);
          GLES20.glUseProgram(this.qce);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, this.jrV);
          GLES20.glTexImage2D(3553, 0, 6408, this.qcf, this.qcg, 0, 6408, 5121, this.jsh);
          GLES20.glUniform1i(this.jrY, 0);
          Matrix.setIdentityM(this.fwm, 0);
          Matrix.setRotateM(this.fwm, 0, this.rotate, 0.0F, 0.0F, -1.0F);
          if (this.qci) {
            Matrix.scaleM(this.fwm, 0, 1.0F, -1.0F, 1.0F);
          }
          GLES20.glUniformMatrix4fv(this.jrZ, 1, false, this.fwm, 0);
          this.fwk.position(0);
          GLES20.glVertexAttribPointer(this.jrX, 2, 5126, false, 0, this.fwk);
          GLES20.glEnableVertexAttribArray(this.jrX);
          this.fwl.position(0);
          GLES20.glVertexAttribPointer(this.jrW, 2, 5126, false, 0, this.fwl);
          GLES20.glEnableVertexAttribArray(this.jrW);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.jrX);
          GLES20.glDisableVertexAttribArray(this.jrW);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindFramebuffer(36160, 0);
          break;
          paramInt1 = this.fvZ;
          break label2062;
        }
        if (paramArrayOfByte.jkc != null)
        {
          paramArrayOfByte.jjU.processTexture(paramInt2, paramArrayOfByte.jkd, paramArrayOfByte.jke, paramArrayOfByte.jkc);
          break label1223;
        }
        paramArrayOfByte.jjU.processTexture(paramInt2, paramArrayOfByte.jkd, paramArrayOfByte.jke, 0);
        break label1223;
        paramInt1 = this.qcg;
        break label1490;
        paramInt2 = this.qcf;
        break label1512;
        f1 = this.jsr / paramInt2;
        break label1542;
        paramInt1 = this.jsn;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
        GLES20.glViewport(0, 0, this.jsq, this.jsr);
        GLES20.glUseProgram(this.qce);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, paramInt1);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glUniform1i(this.jrY, 0);
        if ((this.rotate == 0) || (this.rotate == 180))
        {
          paramInt1 = this.qcf;
          if ((this.rotate != 0) && (this.rotate != 180)) {
            break label2950;
          }
          paramInt2 = this.qcg;
          if (paramInt1 / paramInt2 >= this.jsq / this.jsr) {
            break label2958;
          }
        }
        for (f1 = this.jsq / paramInt1;; f1 = paramInt3 / paramInt2)
        {
          paramInt3 = (int)(this.jsq / f1);
          paramInt4 = (int)(this.jsr / f1);
          Matrix.setIdentityM(this.fwm, 0);
          if (this.rotate > 0) {
            Matrix.setRotateM(this.fwm, 0, Math.abs(this.rotate - 180), 0.0F, 0.0F, -1.0F);
          }
          GLES20.glUniformMatrix4fv(this.jrZ, 1, false, this.fwm, 0);
          this.jsf.put(this.jsj);
          this.jsf.position(0);
          GLES20.glVertexAttribPointer(this.jrX, 2, 5126, false, 0, this.jsf);
          GLES20.glEnableVertexAttribArray(this.jrX);
          f1 = (paramInt1 - paramInt3) / 2.0F / paramInt1;
          f2 = 1.0F - f1;
          f3 = (paramInt2 - paramInt4) / 2.0F / paramInt2;
          f4 = 1.0F - f3;
          this.jsk[0] = f3;
          this.jsk[1] = f1;
          this.jsk[2] = f4;
          this.jsk[3] = f1;
          this.jsk[4] = f3;
          this.jsk[5] = f2;
          this.jsk[6] = f4;
          this.jsk[7] = f2;
          this.jse.put(this.jsk);
          this.jse.position(0);
          GLES20.glVertexAttribPointer(this.jrW, 2, 5126, false, 0, this.jse);
          GLES20.glEnableVertexAttribArray(this.jrW);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.jrX);
          GLES20.glDisableVertexAttribArray(this.jrW);
          GLES20.glBindTexture(3553, 0);
          GLES20.glUseProgram(0);
          break;
          paramInt1 = this.qcg;
          break label2589;
          paramInt2 = this.qcf;
          break label2611;
          paramInt3 = this.jsr;
        }
        i = 0;
        break;
        i = 1;
        break;
      }
      label2062:
      label2371:
      bool = true;
      label2439:
      label2447:
      label2460:
      label2589:
      label2611:
      break label53;
      for (;;)
      {
        label2950:
        label2958:
        label2975:
        label2981:
        label2987:
        label3003:
        if ((paramInt4 & 0x4) == 0) {
          break label3021;
        }
        paramInt3 = 1;
        break;
        label3016:
        paramInt2 = 0;
      }
      label3021:
      paramInt3 = 0;
    }
  }
  
  public final void cJ(int paramInt1, int paramInt2)
  {
    this.jsq = paramInt1;
    this.jsr = paramInt2;
  }
  
  /* Error */
  public final void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/tencent/mm/plugin/voip/video/a/b:dNv	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 107
    //   16: ldc_w 473
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: invokevirtual 341	java/lang/Object:hashCode	()I
    //   29: invokestatic 347	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 355	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: getfield 80	com/tencent/mm/plugin/voip/video/a/b:qch	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   40: ifnull +15 -> 55
    //   43: aload_0
    //   44: getfield 80	com/tencent/mm/plugin/voip/video/a/b:qch	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   47: invokevirtual 476	com/tencent/mm/plugin/voip/video/a/a:clear	()V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 80	com/tencent/mm/plugin/voip/video/a/b:qch	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   55: iconst_5
    //   56: iconst_5
    //   57: newarray int
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: getfield 214	com/tencent/mm/plugin/voip/video/a/b:fwc	I
    //   65: iastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_0
    //   69: getfield 216	com/tencent/mm/plugin/voip/video/a/b:fwd	I
    //   72: iastore
    //   73: dup
    //   74: iconst_2
    //   75: aload_0
    //   76: getfield 440	com/tencent/mm/plugin/voip/video/a/b:jrV	I
    //   79: iastore
    //   80: dup
    //   81: iconst_3
    //   82: aload_0
    //   83: getfield 198	com/tencent/mm/plugin/voip/video/a/b:jsn	I
    //   86: iastore
    //   87: dup
    //   88: iconst_4
    //   89: aload_0
    //   90: getfield 200	com/tencent/mm/plugin/voip/video/a/b:jsp	I
    //   93: iastore
    //   94: iconst_0
    //   95: invokestatic 479	android/opengl/GLES20:glDeleteTextures	(I[II)V
    //   98: iconst_2
    //   99: iconst_2
    //   100: newarray int
    //   102: dup
    //   103: iconst_0
    //   104: aload_0
    //   105: getfield 250	com/tencent/mm/plugin/voip/video/a/b:jsl	I
    //   108: iastore
    //   109: dup
    //   110: iconst_1
    //   111: aload_0
    //   112: getfield 481	com/tencent/mm/plugin/voip/video/a/b:jsm	I
    //   115: iastore
    //   116: iconst_0
    //   117: invokestatic 484	android/opengl/GLES20:glDeleteFramebuffers	(I[II)V
    //   120: aload_0
    //   121: getfield 212	com/tencent/mm/plugin/voip/video/a/b:jrQ	I
    //   124: invokestatic 487	android/opengl/GLES20:glDeleteProgram	(I)V
    //   127: aload_0
    //   128: getfield 436	com/tencent/mm/plugin/voip/video/a/b:qce	I
    //   131: invokestatic 487	android/opengl/GLES20:glDeleteProgram	(I)V
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 336	com/tencent/mm/plugin/voip/video/a/b:jss	[B
    //   139: sipush 3553
    //   142: iconst_0
    //   143: invokestatic 96	android/opengl/GLES20:glBindTexture	(II)V
    //   146: ldc 248
    //   148: iconst_0
    //   149: invokestatic 253	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   152: fconst_0
    //   153: fconst_0
    //   154: fconst_0
    //   155: fconst_0
    //   156: invokestatic 207	android/opengl/GLES20:glClearColor	(FFFF)V
    //   159: sipush 16640
    //   162: invokestatic 210	android/opengl/GLES20:glClear	(I)V
    //   165: invokestatic 334	android/opengl/GLES20:glFinish	()V
    //   168: aload_0
    //   169: getfield 218	com/tencent/mm/plugin/voip/video/a/b:fwa	Ljava/nio/ByteBuffer;
    //   172: ifnull +11 -> 183
    //   175: aload_0
    //   176: getfield 218	com/tencent/mm/plugin/voip/video/a/b:fwa	Ljava/nio/ByteBuffer;
    //   179: invokevirtual 490	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   182: pop
    //   183: aload_0
    //   184: getfield 220	com/tencent/mm/plugin/voip/video/a/b:fwb	Ljava/nio/ByteBuffer;
    //   187: ifnull +11 -> 198
    //   190: aload_0
    //   191: getfield 220	com/tencent/mm/plugin/voip/video/a/b:fwb	Ljava/nio/ByteBuffer;
    //   194: invokevirtual 490	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   197: pop
    //   198: aload_0
    //   199: aconst_null
    //   200: putfield 218	com/tencent/mm/plugin/voip/video/a/b:fwa	Ljava/nio/ByteBuffer;
    //   203: aload_0
    //   204: aconst_null
    //   205: putfield 220	com/tencent/mm/plugin/voip/video/a/b:fwb	Ljava/nio/ByteBuffer;
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 84	com/tencent/mm/plugin/voip/video/a/b:dNv	Z
    //   213: goto -202 -> 11
    //   216: astore_2
    //   217: aload_0
    //   218: monitorexit
    //   219: aload_2
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	b
    //   6	2	1	bool	boolean
    //   216	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	216	finally
    //   14	55	216	finally
    //   55	183	216	finally
    //   183	198	216	finally
    //   198	213	216	finally
  }
  
  public final void reset()
  {
    try
    {
      y.d("MicroMsg.FilterRenderer", "%s reset", new Object[] { Integer.valueOf(hashCode()) });
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
      if (this.qch != null)
      {
        this.qch.clear();
        this.qch = null;
      }
      this.jss = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.b
 * JD-Core Version:    0.7.0.1
 */