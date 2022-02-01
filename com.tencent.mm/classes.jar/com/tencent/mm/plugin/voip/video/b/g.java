package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.f;
import com.tencent.mm.cm.a.k;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class g
  implements GLSurfaceView.Renderer
{
  public int FfM;
  public boolean HiC;
  public k HkU;
  public int HkV;
  public float HkW;
  public volatile d Hma;
  public volatile c Hmb;
  private int Hmc;
  private int Hmd;
  public boolean Hme;
  public int Hmf;
  public ByteBuffer Hmg;
  public ByteBuffer Hmh;
  public ByteBuffer Hmi;
  public ByteBuffer Hmj;
  public boolean Hmk;
  public int Hml;
  public int Hmm;
  public boolean Hmn;
  public volatile boolean Hmo;
  public int Hmp;
  public int Hmq;
  public int Hmr;
  private final String TAG;
  public int hEm;
  private volatile boolean ijr;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public ByteBuffer y;
  
  public g()
  {
    AppMethodBeat.i(115744);
    this.TAG = "MicroMsg.VoipRenderer";
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.Hmc = 0;
    this.Hmd = 0;
    this.hEm = 0;
    this.Hme = false;
    this.Hmf = 3;
    this.Hmg = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.Hmh = ByteBuffer.allocate(0);
    this.Hmi = ByteBuffer.allocate(0);
    this.Hmj = ByteBuffer.allocate(0);
    this.Hml = 0;
    this.Hmm = 0;
    this.Hmn = false;
    this.HiC = false;
    this.Hmo = false;
    this.ijr = false;
    this.HkV = 5;
    this.HkW = 0.0F;
    this.Hmp = 0;
    this.Hmq = 0;
    this.Hmr = 0;
    AppMethodBeat.o(115744);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt3)
  {
    AppMethodBeat.i(235904);
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
      switch (this.FfM)
      {
      case 2: 
      default: 
        com.tencent.mm.media.k.c.e(paramInt3, paramArrayOfFloat1);
        if (this.Hma != null) {
          this.Hma.d(paramArrayOfFloat2, paramArrayOfFloat1);
        }
        AppMethodBeat.o(235904);
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
    if (this.Hmk)
    {
      f3 = 1.0F - f1;
      label586:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.Hmk) {
        break label721;
      }
      f3 = 1.0F - f1;
      label613:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.Hmk) {
        break label728;
      }
      f3 = f1;
      label636:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.Hmk) {
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
    if (this.Hmk)
    {
      f3 = 1.0F - f1;
      label765:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.Hmk) {
        break label900;
      }
      f3 = 1.0F - f1;
      label792:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.Hmk) {
        break label907;
      }
      f3 = f1;
      label815:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.Hmk) {
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
      if (this.Hmb != null) {
        this.Hmb.d(paramArrayOfFloat1, paramArrayOfFloat2);
      }
      AppMethodBeat.o(115752);
      return;
      f2 = 0.5F - paramInt1 * 1.0F * this.mScreenHeight / (paramInt2 * 2.0F * this.mScreenWidth);
      f1 = 0.0F;
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115755);
    if (this.Hmb != null) {
      this.Hmb.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115755);
  }
  
  public final void aE(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235903);
    if ((this.hEm != 1) && (this.Hma != null))
    {
      if ((this.Hmf == 0) || (this.Hmf == 1))
      {
        a(paramInt1, paramInt2, true, this.Hma.HlS, this.Hma.HlR, 0);
        AppMethodBeat.o(235903);
        return;
      }
      a(paramInt1, paramInt2, false, this.Hma.HlS, this.Hma.HlR, paramInt3);
    }
    AppMethodBeat.o(235903);
  }
  
  public final void adY(int paramInt)
  {
    AppMethodBeat.i(115747);
    if (this.hEm != paramInt)
    {
      Log.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
      this.hEm = paramInt;
      if ((paramInt != 1) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
        aE(this.mVideoWidth, this.mVideoHeight, this.Hmr);
      }
    }
    AppMethodBeat.o(115747);
  }
  
  public final com.tencent.mm.plugin.voip.video.d.b fJk()
  {
    AppMethodBeat.i(235905);
    if (this.Hma != null)
    {
      com.tencent.mm.plugin.voip.video.d.b localb = this.Hma.fJk();
      AppMethodBeat.o(235905);
      return localb;
    }
    AppMethodBeat.o(235905);
    return null;
  }
  
  public final a fLJ()
  {
    AppMethodBeat.i(115756);
    if (this.Hma != null)
    {
      a locala = this.Hma.fLJ();
      AppMethodBeat.o(115756);
      return locala;
    }
    AppMethodBeat.o(115756);
    return null;
  }
  
  public final boolean fLM()
  {
    AppMethodBeat.i(115753);
    Log.printInfoStack("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", new Object[] { Boolean.valueOf(this.Hme), this.Hmb });
    if ((!this.Hme) && (this.Hmb != null)) {}
    try
    {
      Object localObject = t.GYO;
      t.fHB();
      localObject = this.Hmb;
      c.fLG();
      this.Hme = true;
      Log.i("MicroMsg.VoipRenderer", "attachGLContext done!");
      boolean bool = this.Hme;
      AppMethodBeat.o(115753);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Hme = false;
        Log.printErrStackTrace("MicroMsg.VoipRenderer", localException, "attachGLContext error!", new Object[0]);
        t localt = t.GYO;
        t.fHC();
      }
    }
  }
  
  public final boolean fLN()
  {
    AppMethodBeat.i(115754);
    Log.printInfoStack("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", new Object[] { Boolean.valueOf(this.Hme) });
    if ((this.Hme) && (this.Hmb != null)) {}
    try
    {
      Object localObject = t.GYO;
      t.fHD();
      localObject = this.Hmb;
      c.fLH();
      this.Hme = false;
      Log.i("MicroMsg.VoipRenderer", "detachGLContext done!");
      boolean bool = this.Hme;
      AppMethodBeat.o(115754);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Hme = true;
        Log.printErrStackTrace("MicroMsg.VoipRenderer", localException, "detachGLContext error!", new Object[0]);
        t localt = t.GYO;
        t.fHE();
      }
    }
  }
  
  public final void jK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115748);
    Log.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.Hmc = paramInt1;
    this.Hmd = paramInt2;
    a(this.Hmc, this.Hmd, c.ilm, c.HlE);
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
        if (this.ijr)
        {
          Log.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(this.hEm) });
          this.ijr = false;
          if ((this.hEm == 1) && (this.Hmb != null)) {
            this.Hmb.updateTexImage();
          }
          return;
        }
        if (this.hEm != 0) {
          break label1234;
        }
        if ((!this.Hmo) || (this.Hma == null)) {
          break label1223;
        }
        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth)
        {
          this.y.position(0);
          i = this.mVideoHeight * this.mVideoWidth / 4;
          if (this.Hmf == 3) {
            if (this.Hmj.capacity() == i * 2)
            {
              this.Hmj.position(0);
              paramGL10 = this.Hma;
              localObject = this.y;
              localByteBuffer1 = this.Hmj;
              j = this.mVideoWidth;
              i = this.mVideoHeight;
              paramGL10.a((ByteBuffer)localObject, j, i, 0);
              j /= 2;
              i /= 2;
              paramGL10.HlF[1].a(j, i, 6410, localByteBuffer1, 9729, 33071);
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
        if (this.Hmm == 1)
        {
          paramGL10 = this.Hma;
          i = this.HkV;
          float f = this.HkW;
          if (paramGL10.HlO)
          {
            paramGL10.HkZ.apH(i);
            paramGL10.HkZ.cH(f);
          }
        }
        paramGL10 = this.Hma;
        i = this.Hmf;
        j = this.Hml;
        bool2 = this.HiC;
        if ((i != 0) && (i != 1)) {
          break;
        }
        paramGL10.HlM = false;
      }
      catch (Exception paramGL10)
      {
        ByteBuffer localByteBuffer2;
        Log.w("MicroMsg.VoipRenderer", paramGL10.getMessage());
        continue;
        if ((paramGL10.HlO) || (!paramGL10.HlM)) {
          continue;
        }
        paramGL10.HlI.rl(paramGL10.HlJ.igv);
        continue;
        if ((!paramGL10.HlO) || (paramGL10.HlM)) {
          break label1121;
        }
        paramGL10.HlJ.a(paramGL10.HlL, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.d(paramGL10.HlT, paramGL10.HlU);
        GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.adX(i);
        d.aMY();
        i = paramGL10.HlJ.igv;
        paramGL10.b(paramGL10.HlR, paramGL10.HlS, paramGL10.HlQ);
        paramGL10.HkZ.a(paramGL10.HlJ.igv, i, i, paramGL10.HkX, paramGL10.HkY);
        d.aMY();
        continue;
        if ((paramGL10.HlO) || (!paramGL10.HlM)) {
          break label1215;
        }
        paramGL10.HlJ.a(paramGL10.HlL, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.d(paramGL10.HlT, paramGL10.HlU);
        GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.adX(i);
        d.aMY();
        paramGL10.HlI.c(paramGL10.HlR, paramGL10.HlS);
        paramGL10.HlI.fLD();
        d.aMY();
        continue;
        paramGL10.adX(i);
        continue;
      }
      paramGL10.HlO = bool1;
      if ((bool2) && ((paramGL10.HlM != paramGL10.HlN) || (paramGL10.HlO != paramGL10.HlP)))
      {
        paramGL10.HlN = paramGL10.HlM;
        paramGL10.HlP = paramGL10.HlO;
        if ((!paramGL10.HlO) || (!paramGL10.HlM)) {
          break label932;
        }
        paramGL10.HlI.rl(paramGL10.HlK.igv);
        paramGL10.HkZ.apK(paramGL10.HlK.igv);
        paramGL10.HkZ.DA(false);
      }
      label445:
      if ((!paramGL10.HlO) || (!paramGL10.HlM)) {
        break label1001;
      }
      paramGL10.HlJ.a(paramGL10.HlL, paramGL10.outputWidth, paramGL10.outputHeight);
      paramGL10.d(paramGL10.HlT, paramGL10.HlU);
      GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
      paramGL10.adX(i);
      d.aMY();
      paramGL10.HkZ.apK(paramGL10.HlK.igv);
      i = paramGL10.HlJ.igv;
      paramGL10.b(paramGL10.HlR, paramGL10.HlS, paramGL10.HlQ);
      paramGL10.HkZ.a(paramGL10.HlJ.igv, i, i, paramGL10.HkX, paramGL10.HkY);
      d.aMY();
      paramGL10.HlI.c(paramGL10.HlR, paramGL10.HlS);
      paramGL10.HlI.fLD();
      d.aMY();
      d.aMY();
      label604:
      this.Hmo = false;
      label609:
      AppMethodBeat.o(115749);
      return;
      Log.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.Hmj.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
      continue;
      if ((this.Hmh.capacity() == i) && (this.Hmi.capacity() == i))
      {
        this.Hmh.position(0);
        this.Hmi.position(0);
        paramGL10 = this.Hma;
        localObject = this.y;
        localByteBuffer1 = this.Hmh;
        localByteBuffer2 = this.Hmi;
        i = this.mVideoWidth;
        j = this.mVideoHeight;
        paramGL10.a((ByteBuffer)localObject, i, j, 0);
        paramGL10.a(localByteBuffer1, i / 2, j / 2, 1);
        paramGL10.a(localByteBuffer2, i / 2, j / 2, 2);
      }
      else
      {
        Log.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.Hmh.capacity()), Integer.valueOf(this.Hmi.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        Log.e("MicroMsg.VoipRenderer", "draw error, y buffer size not match, y.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.y.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
      }
    }
    if ((j & 0x8) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      for (;;)
      {
        paramGL10.HlM = bool1;
        if ((j & 0x20) == 0) {
          break label1501;
        }
        bool1 = true;
        break;
        label932:
        if ((paramGL10.HlO) && (!paramGL10.HlM))
        {
          paramGL10.HkZ.DA(true);
          break label445;
        }
        label1001:
        Log.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
        label1121:
        break label604;
        label1215:
        label1223:
        label1234:
        if (this.Hmb == null) {
          break label609;
        }
        this.Hmq += 1;
        if (this.Hmq % 100 == 0) {
          Log.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", new Object[] { Integer.valueOf(this.Hmc), Integer.valueOf(this.Hmd), Integer.valueOf(this.Hmq) });
        }
        a(this.Hmc, this.Hmd, c.ilm, c.HlE);
        paramGL10 = this.Hmb;
        localObject = paramGL10.surfaceTexture;
        if (localObject == null) {
          break label609;
        }
        try
        {
          paramGL10.updateTexImage();
          GLES20.glUseProgram(paramGL10.HlC);
          i = GLES20.glGetAttribLocation(paramGL10.HlC, "vPosition");
          j = GLES20.glGetAttribLocation(paramGL10.HlC, "vTexCoord");
          int k = GLES20.glGetUniformLocation(paramGL10.HlC, "sTexture");
          GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, paramGL10.mVertexBuffer);
          GLES20.glEnableVertexAttribArray(i);
          GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, paramGL10.HlD);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramGL10.HcD.igv);
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
      break label609;
      label1501:
      bool1 = false;
      break;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115746);
    Log.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", new Object[] { Integer.valueOf(this.hEm), Integer.valueOf(this.Hmf) });
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.Hma == null) {
      this.Hma = new d();
    }
    if (this.Hmb == null) {
      this.Hmb = new c();
    }
    this.mScreenHeight = paramInt2;
    this.mScreenWidth = paramInt1;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
      aE(this.mVideoWidth, this.mVideoHeight, this.Hmr);
    }
    if (this.Hma != null)
    {
      paramGL10 = this.Hma;
      Log.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramGL10.surfaceWidth), Integer.valueOf(paramGL10.surfaceHeight) });
      if ((paramInt1 != paramGL10.surfaceWidth) || (paramGL10.surfaceHeight != paramInt2))
      {
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
        b localb = paramGL10.HlI;
        Log.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localb.surfaceWidth = paramInt1;
        localb.surfaceHeight = paramInt2;
        paramGL10 = paramGL10.HkZ;
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
      }
    }
    this.Hmn = true;
    Log.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
    AppMethodBeat.o(115746);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115745);
    Log.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", new Object[] { Integer.valueOf(this.hEm) });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.Hma == null) {
      this.Hma = new d();
    }
    if (this.Hmb == null) {
      this.Hmb = new c();
    }
    this.HkU = new k();
    this.Hmp = 0;
    this.Hmq = 0;
    AppMethodBeat.o(115745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.g
 * JD-Core Version:    0.7.0.1
 */