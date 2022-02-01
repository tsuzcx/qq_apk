package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.e;
import com.tencent.mm.cm.a.j;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class g
  implements GLSurfaceView.Renderer
{
  public int RXR;
  private final String TAG;
  public boolean UNo;
  public j UPF;
  public int UPG;
  public float UPH;
  public volatile d UQP;
  public volatile c UQQ;
  private int UQR;
  private int UQS;
  public boolean UQT;
  public int UQU;
  public ByteBuffer UQV;
  public ByteBuffer UQW;
  public ByteBuffer UQX;
  public ByteBuffer UQY;
  public boolean UQZ;
  public int URa;
  public int URb;
  public boolean URc;
  public volatile boolean URd;
  public int URe;
  public int URf;
  public int URg;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public int mWk;
  private volatile boolean nDp;
  public ByteBuffer y;
  
  public g()
  {
    AppMethodBeat.i(115744);
    this.TAG = "MicroMsg.VoipRenderer";
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.UQR = 0;
    this.UQS = 0;
    this.mWk = 0;
    this.UQT = false;
    this.UQU = 3;
    this.UQV = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.UQW = ByteBuffer.allocate(0);
    this.UQX = ByteBuffer.allocate(0);
    this.UQY = ByteBuffer.allocate(0);
    this.URa = 0;
    this.URb = 0;
    this.URc = false;
    this.UNo = false;
    this.URd = false;
    this.nDp = false;
    this.UPG = 5;
    this.UPH = 0.0F;
    this.URe = 0;
    this.URf = 0;
    this.URg = 0;
    AppMethodBeat.o(115744);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt3)
  {
    AppMethodBeat.i(292880);
    float f5 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f6 = 0.0F;
    float f1 = 0.0F;
    float f4;
    int i;
    int j;
    if ((paramInt3 != 90) && (paramInt3 != 270)) {
      if (paramBoolean)
      {
        f4 = 0.005F + 64.0F / paramInt1 / 2.0F;
        f3 = 64.0F / paramInt2 / 2.0F + 0.005F;
        i = paramInt1 - 64;
        j = paramInt2 - 64;
        if (this.mScreenWidth * i < this.mScreenHeight * j)
        {
          f1 = 0.5F - i * 1.0F * this.mScreenWidth / (2.0F * paramInt2 * this.mScreenHeight) + 0.005F;
          label122:
          if (f2 <= f4) {
            break label232;
          }
          label130:
          if (f1 <= f3) {
            break label239;
          }
        }
      }
    }
    for (;;)
    {
      switch (this.RXR)
      {
      case 2: 
      default: 
        com.tencent.mm.media.util.c.e(paramInt3, paramArrayOfFloat1);
        if (this.UQP != null) {
          this.UQP.h(paramArrayOfFloat2, paramArrayOfFloat1);
        }
        AppMethodBeat.o(292880);
        return;
        f2 = 0.5F - 1.0F * j * this.mScreenHeight / (2.0F * paramInt1 * this.mScreenWidth) + 0.005F;
        break label122;
        label232:
        f2 = f4;
        break label130;
        label239:
        f1 = f3;
        continue;
        if (this.mScreenWidth * paramInt1 < this.mScreenHeight * paramInt2)
        {
          f1 = 0.5F - 1.0F * paramInt1 * this.mScreenWidth / (2.0F * paramInt2 * this.mScreenHeight);
          f2 = 0.0F;
        }
        else
        {
          f2 = 0.5F - 1.0F * paramInt2 * this.mScreenHeight / (2.0F * paramInt1 * this.mScreenWidth);
          f1 = f3;
          continue;
          if (paramBoolean)
          {
            f4 = 0.005F + 64.0F / paramInt1 / 2.0F;
            f3 = 64.0F / paramInt2 / 2.0F + 0.005F;
            i = paramInt1 - 64;
            j = paramInt2 - 64;
            if (this.mScreenHeight * i < this.mScreenWidth * j)
            {
              f1 = 0.5F - i * 1.0F * this.mScreenHeight / (2.0F * paramInt2 * this.mScreenWidth) + 0.005F;
              f2 = f5;
              label417:
              if (f2 <= f4) {
                break label473;
              }
              label425:
              if (f1 <= f3) {
                break label480;
              }
            }
            for (;;)
            {
              break;
              f2 = 0.5F - 1.0F * j * this.mScreenWidth / (2.0F * paramInt1 * this.mScreenHeight) + 0.005F;
              f1 = f6;
              break label417;
              label473:
              f2 = f4;
              break label425;
              label480:
              f1 = f3;
            }
          }
          if (this.mScreenHeight * paramInt1 < this.mScreenWidth * paramInt2)
          {
            f1 = 0.5F - 1.0F * paramInt1 * this.mScreenHeight / (2.0F * paramInt2 * this.mScreenWidth);
            f2 = 0.0F;
          }
          else
          {
            f2 = 0.5F - 1.0F * paramInt2 * this.mScreenWidth / (2.0F * paramInt1 * this.mScreenHeight);
            f1 = f3;
          }
        }
        break;
      }
    }
    paramArrayOfFloat1[0] = f2;
    if (this.UQZ)
    {
      f3 = 1.0F - f1;
      label586:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.UQZ) {
        break label721;
      }
      f3 = 1.0F - f1;
      label613:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.UQZ) {
        break label728;
      }
      f3 = f1;
      label636:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.UQZ) {
        break label737;
      }
    }
    for (;;)
    {
      paramArrayOfFloat1[7] = f1;
      paramArrayOfFloat2[0] = -1.0F;
      paramArrayOfFloat2[1] = -1.0F;
      paramArrayOfFloat2[2] = -1.0F;
      paramArrayOfFloat2[3] = 1.0F;
      paramArrayOfFloat2[4] = 1.0F;
      paramArrayOfFloat2[5] = -1.0F;
      paramArrayOfFloat2[6] = 1.0F;
      paramArrayOfFloat2[7] = 1.0F;
      break;
      f3 = f1;
      break label586;
      label721:
      f3 = f1;
      break label613;
      label728:
      f3 = 1.0F - f1;
      break label636;
      label737:
      f1 = 1.0F - f1;
    }
    paramArrayOfFloat1[0] = f2;
    if (this.UQZ)
    {
      f3 = 1.0F - f1;
      label765:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.UQZ) {
        break label900;
      }
      f3 = 1.0F - f1;
      label792:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.UQZ) {
        break label907;
      }
      f3 = f1;
      label815:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.UQZ) {
        break label916;
      }
    }
    for (;;)
    {
      paramArrayOfFloat1[7] = f1;
      paramArrayOfFloat2[0] = 1.0F;
      paramArrayOfFloat2[1] = 1.0F;
      paramArrayOfFloat2[2] = 1.0F;
      paramArrayOfFloat2[3] = -1.0F;
      paramArrayOfFloat2[4] = -1.0F;
      paramArrayOfFloat2[5] = 1.0F;
      paramArrayOfFloat2[6] = -1.0F;
      paramArrayOfFloat2[7] = -1.0F;
      break;
      f3 = f1;
      break label765;
      label900:
      f3 = f1;
      break label792;
      label907:
      f3 = 1.0F - f1;
      break label815;
      label916:
      f1 = 1.0F - f1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(115752);
    float f1;
    float f2;
    if (this.mScreenWidth * paramInt2 < this.mScreenHeight * paramInt1)
    {
      f1 = 0.5F - paramInt2 * 1.0F * this.mScreenWidth / (paramInt1 * 2.0F * this.mScreenHeight);
      f2 = 0.0F;
    }
    for (;;)
    {
      paramArrayOfFloat2[0] = f2;
      paramArrayOfFloat2[1] = (1.0F - f1);
      paramArrayOfFloat2[2] = (1.0F - f2);
      paramArrayOfFloat2[3] = (1.0F - f1);
      paramArrayOfFloat2[4] = f2;
      paramArrayOfFloat2[5] = f1;
      paramArrayOfFloat2[6] = (1.0F - f2);
      paramArrayOfFloat2[7] = f1;
      paramArrayOfFloat1[0] = -1.0F;
      paramArrayOfFloat1[1] = 1.0F;
      paramArrayOfFloat1[2] = -1.0F;
      paramArrayOfFloat1[3] = -1.0F;
      paramArrayOfFloat1[4] = 1.0F;
      paramArrayOfFloat1[5] = 1.0F;
      paramArrayOfFloat1[6] = 1.0F;
      paramArrayOfFloat1[7] = -1.0F;
      if (this.UQQ != null) {
        this.UQQ.h(paramArrayOfFloat1, paramArrayOfFloat2);
      }
      AppMethodBeat.o(115752);
      return;
      f2 = 0.5F - paramInt1 * 1.0F * this.mScreenHeight / (paramInt2 * 2.0F * this.mScreenWidth);
      f1 = 0.0F;
    }
  }
  
  public final void art(int paramInt)
  {
    AppMethodBeat.i(115747);
    if (this.mWk != paramInt)
    {
      Log.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
      this.mWk = paramInt;
      if ((paramInt != 1) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
        bk(this.mVideoWidth, this.mVideoHeight, this.URg);
      }
    }
    AppMethodBeat.o(115747);
  }
  
  public final void bk(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(292900);
    if ((this.mWk != 1) && (this.UQP != null))
    {
      if ((this.UQU == 0) || (this.UQU == 1))
      {
        a(paramInt1, paramInt2, true, this.UQP.UQH, this.UQP.UQG, 0);
        AppMethodBeat.o(292900);
        return;
      }
      a(paramInt1, paramInt2, false, this.UQP.UQH, this.UQP.UQG, paramInt3);
    }
    AppMethodBeat.o(292900);
  }
  
  public final boolean idd()
  {
    AppMethodBeat.i(115753);
    Log.printInfoStack("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", new Object[] { Boolean.valueOf(this.UQT), this.UQQ });
    if ((!this.UQT) && (this.UQQ != null)) {}
    try
    {
      Object localObject = t.UBA;
      t.hXW();
      localObject = this.UQQ;
      c.icY();
      this.UQT = true;
      Log.i("MicroMsg.VoipRenderer", "attachGLContext done!");
      boolean bool = this.UQT;
      AppMethodBeat.o(115753);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.UQT = false;
        Log.printErrStackTrace("MicroMsg.VoipRenderer", localException, "attachGLContext error!", new Object[0]);
        t localt = t.UBA;
        t.hXX();
      }
    }
  }
  
  public final boolean ide()
  {
    AppMethodBeat.i(115754);
    Log.printInfoStack("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", new Object[] { Boolean.valueOf(this.UQT) });
    if ((this.UQT) && (this.UQQ != null)) {}
    try
    {
      Object localObject = t.UBA;
      t.hXY();
      localObject = this.UQQ;
      c.icZ();
      this.UQT = false;
      Log.i("MicroMsg.VoipRenderer", "detachGLContext done!");
      boolean bool = this.UQT;
      AppMethodBeat.o(115754);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.UQT = true;
        Log.printErrStackTrace("MicroMsg.VoipRenderer", localException, "detachGLContext error!", new Object[0]);
        t localt = t.UBA;
        t.hXZ();
      }
    }
  }
  
  public final void mM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115748);
    Log.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.UQR = paramInt1;
    this.UQS = paramInt2;
    a(this.UQR, this.UQS, c.nFt, c.UQt);
    AppMethodBeat.o(115748);
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(115749);
    int i;
    Object localObject;
    int j;
    for (;;)
    {
      ByteBuffer localByteBuffer1;
      try
      {
        GLES20.glViewport(0, 0, this.mScreenWidth, this.mScreenHeight);
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        if (this.nDp)
        {
          Log.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(this.mWk) });
          this.nDp = false;
          if ((this.mWk == 1) && (this.UQQ != null)) {
            this.UQQ.updateTexImage();
          }
          return;
        }
        if (this.mWk != 0) {
          break label1230;
        }
        if ((!this.URd) || (this.UQP == null)) {
          break label1219;
        }
        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth)
        {
          this.y.position(0);
          i = this.mVideoHeight * this.mVideoWidth / 4;
          if (this.UQU == 3) {
            if (this.UQY.capacity() == i * 2)
            {
              this.UQY.position(0);
              paramGL10 = this.UQP;
              localObject = this.y;
              localByteBuffer1 = this.UQY;
              j = this.mVideoWidth;
              i = this.mVideoHeight;
              paramGL10.c((ByteBuffer)localObject, j, i, 0);
              j /= 2;
              i /= 2;
              paramGL10.UQu[1].a(j, i, 6410, localByteBuffer1, 9729, 33071);
            }
          }
        }
      }
      finally
      {
        boolean bool2;
        AppMethodBeat.o(115749);
      }
      try
      {
        if (this.URb == 1)
        {
          paramGL10 = this.UQP;
          i = this.UPG;
          float f = this.UPH;
          if (paramGL10.UQD)
          {
            paramGL10.UPK.aFK(i);
            paramGL10.UPK.er(f);
          }
        }
        paramGL10 = this.UQP;
        i = this.UQU;
        j = this.URa;
        bool2 = this.UNo;
        if ((i != 0) && (i != 1)) {
          break;
        }
        paramGL10.UQB = false;
      }
      catch (Exception paramGL10)
      {
        ByteBuffer localByteBuffer2;
        Log.w("MicroMsg.VoipRenderer", paramGL10.getMessage());
        continue;
        if ((paramGL10.UQD) || (!paramGL10.UQB)) {
          continue;
        }
        paramGL10.UQx.uc(paramGL10.UQy.nAF);
        continue;
        if ((!paramGL10.UQD) || (paramGL10.UQB)) {
          break label1117;
        }
        paramGL10.UQy.a(paramGL10.UQA, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.h(paramGL10.UQI, paramGL10.UQJ);
        GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.ars(i);
        d.bqi();
        i = paramGL10.UQy.nAF;
        paramGL10.b(paramGL10.UQG, paramGL10.UQH, paramGL10.UQF);
        paramGL10.UPK.a(paramGL10.UQy.nAF, i, i, paramGL10.UPI, paramGL10.UPJ);
        d.bqi();
        continue;
        if ((paramGL10.UQD) || (!paramGL10.UQB)) {
          break label1211;
        }
        paramGL10.UQy.a(paramGL10.UQA, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.h(paramGL10.UQI, paramGL10.UQJ);
        GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.ars(i);
        d.bqi();
        paramGL10.UQx.g(paramGL10.UQG, paramGL10.UQH);
        paramGL10.UQx.icV();
        d.bqi();
        continue;
        paramGL10.ars(i);
        continue;
      }
      paramGL10.UQD = bool1;
      if ((bool2) && ((paramGL10.UQB != paramGL10.UQC) || (paramGL10.UQD != paramGL10.UQE)))
      {
        paramGL10.UQC = paramGL10.UQB;
        paramGL10.UQE = paramGL10.UQD;
        if ((!paramGL10.UQD) || (!paramGL10.UQB)) {
          break label928;
        }
        paramGL10.UQx.uc(paramGL10.UQz.nAF);
        paramGL10.UPK.aFN(paramGL10.UQz.nAF);
        paramGL10.UPK.NV(false);
      }
      label443:
      if ((!paramGL10.UQD) || (!paramGL10.UQB)) {
        break label997;
      }
      paramGL10.UQy.a(paramGL10.UQA, paramGL10.outputWidth, paramGL10.outputHeight);
      paramGL10.h(paramGL10.UQI, paramGL10.UQJ);
      GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
      paramGL10.ars(i);
      d.bqi();
      paramGL10.UPK.aFN(paramGL10.UQz.nAF);
      i = paramGL10.UQy.nAF;
      paramGL10.b(paramGL10.UQG, paramGL10.UQH, paramGL10.UQF);
      paramGL10.UPK.a(paramGL10.UQy.nAF, i, i, paramGL10.UPI, paramGL10.UPJ);
      d.bqi();
      paramGL10.UQx.g(paramGL10.UQG, paramGL10.UQH);
      paramGL10.UQx.icV();
      d.bqi();
      d.bqi();
      label602:
      this.URd = false;
      label607:
      AppMethodBeat.o(115749);
      return;
      Log.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.UQY.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
      continue;
      if ((this.UQW.capacity() == i) && (this.UQX.capacity() == i))
      {
        this.UQW.position(0);
        this.UQX.position(0);
        paramGL10 = this.UQP;
        localObject = this.y;
        localByteBuffer1 = this.UQW;
        localByteBuffer2 = this.UQX;
        i = this.mVideoWidth;
        j = this.mVideoHeight;
        paramGL10.c((ByteBuffer)localObject, i, j, 0);
        paramGL10.c(localByteBuffer1, i / 2, j / 2, 1);
        paramGL10.c(localByteBuffer2, i / 2, j / 2, 2);
      }
      else
      {
        Log.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.UQW.capacity()), Integer.valueOf(this.UQX.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        Log.e("MicroMsg.VoipRenderer", "draw error, y buffer size not match, y.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.y.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
      }
    }
    if ((j & 0x8) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      for (;;)
      {
        paramGL10.UQB = bool1;
        if ((j & 0x20) == 0) {
          break label1497;
        }
        bool1 = true;
        break;
        label928:
        if ((paramGL10.UQD) && (!paramGL10.UQB))
        {
          paramGL10.UPK.NV(true);
          break label443;
        }
        label997:
        Log.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
        label1117:
        break label602;
        label1211:
        label1219:
        label1230:
        if (this.UQQ == null) {
          break label607;
        }
        this.URf += 1;
        if (this.URf % 100 == 0) {
          Log.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", new Object[] { Integer.valueOf(this.UQR), Integer.valueOf(this.UQS), Integer.valueOf(this.URf) });
        }
        a(this.UQR, this.UQS, c.nFt, c.UQt);
        paramGL10 = this.UQQ;
        localObject = paramGL10.surfaceTexture;
        if (localObject == null) {
          break label607;
        }
        try
        {
          paramGL10.updateTexImage();
          GLES20.glUseProgram(paramGL10.UQr);
          i = GLES20.glGetAttribLocation(paramGL10.UQr, "vPosition");
          j = GLES20.glGetAttribLocation(paramGL10.UQr, "vTexCoord");
          int k = GLES20.glGetUniformLocation(paramGL10.UQr, "sTexture");
          GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, paramGL10.mVertexBuffer);
          GLES20.glEnableVertexAttribArray(i);
          GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, paramGL10.UQs);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramGL10.UFV.nAF);
          GLES20.glUniform1i(k, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glFinish();
          GLES20.glDisableVertexAttribArray(i);
          GLES20.glDisableVertexAttribArray(j);
          GLES20.glBindTexture(36197, 0);
        }
        catch (Exception paramGL10)
        {
          Log.printErrStackTrace("MicroMsg.VoipGLHProgram", paramGL10, "renderThis error", new Object[0]);
        }
      }
      break label607;
      label1497:
      bool1 = false;
      break;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115746);
    Log.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", new Object[] { Integer.valueOf(this.mWk), Integer.valueOf(this.UQU) });
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.UQP == null) {
      this.UQP = new d();
    }
    if (this.UQQ == null) {
      this.UQQ = new c();
    }
    this.mScreenHeight = paramInt2;
    this.mScreenWidth = paramInt1;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
      bk(this.mVideoWidth, this.mVideoHeight, this.URg);
    }
    if (this.UQP != null)
    {
      paramGL10 = this.UQP;
      Log.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramGL10.surfaceWidth), Integer.valueOf(paramGL10.surfaceHeight) });
      if ((paramInt1 != paramGL10.surfaceWidth) || (paramGL10.surfaceHeight != paramInt2))
      {
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
        b localb = paramGL10.UQx;
        Log.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localb.surfaceWidth = paramInt1;
        localb.surfaceHeight = paramInt2;
        paramGL10 = paramGL10.UPK;
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
      }
    }
    this.URc = true;
    Log.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
    AppMethodBeat.o(115746);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115745);
    Log.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", new Object[] { Integer.valueOf(this.mWk) });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.UQP == null) {
      this.UQP = new d();
    }
    if (this.UQQ == null) {
      this.UQQ = new c();
    }
    this.UPF = new j();
    this.URe = 0;
    this.URf = 0;
    AppMethodBeat.o(115745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.g
 * JD-Core Version:    0.7.0.1
 */