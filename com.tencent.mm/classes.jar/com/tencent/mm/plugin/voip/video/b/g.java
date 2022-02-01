package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class g
  implements GLSurfaceView.Renderer
{
  private final String TAG;
  private volatile boolean guA;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public int xYz;
  public ByteBuffer y;
  public volatile d zyc;
  public volatile c zyd;
  private int zye;
  private int zyf;
  public int zyg;
  public boolean zyh;
  public int zyi;
  public ByteBuffer zyj;
  public ByteBuffer zyk;
  public ByteBuffer zyl;
  public ByteBuffer zym;
  public boolean zyn;
  public int zyo;
  public boolean zyp;
  public volatile boolean zyq;
  public int zyr;
  public int zys;
  
  public g()
  {
    AppMethodBeat.i(115744);
    this.TAG = "MicroMsg.VoipRenderer";
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.zye = 0;
    this.zyf = 0;
    this.zyg = 0;
    this.zyh = false;
    this.zyi = 3;
    this.zyj = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.zyk = ByteBuffer.allocate(0);
    this.zyl = ByteBuffer.allocate(0);
    this.zym = ByteBuffer.allocate(0);
    this.zyo = 0;
    this.zyp = false;
    this.zyq = false;
    this.guA = false;
    this.zyr = 0;
    this.zys = 0;
    AppMethodBeat.o(115744);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(115751);
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f1 = 0.0F;
    float f4;
    int j;
    if (paramBoolean)
    {
      f4 = 0.005F + 64.0F / paramInt1 / 2.0F;
      f3 = 64.0F / paramInt2 / 2.0F + 0.005F;
      int i = paramInt1 - 64;
      j = paramInt2 - 64;
      if (this.mScreenWidth * i < this.mScreenHeight * j)
      {
        f1 = 0.5F - i * 1.0F * this.mScreenWidth / (2.0F * paramInt2 * this.mScreenHeight) + 0.005F;
        label101:
        if (f2 <= f4) {
          break label205;
        }
        label109:
        if (f1 <= f3) {
          break label212;
        }
      }
    }
    for (;;)
    {
      switch (this.xYz)
      {
      case 2: 
      default: 
        if (this.zyc != null) {
          this.zyc.c(paramArrayOfFloat2, paramArrayOfFloat1);
        }
        AppMethodBeat.o(115751);
        return;
        f2 = 0.5F - 1.0F * j * this.mScreenHeight / (2.0F * paramInt1 * this.mScreenWidth) + 0.005F;
        break label101;
        label205:
        f2 = f4;
        break label109;
        label212:
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
        }
        break;
      }
    }
    paramArrayOfFloat1[0] = f2;
    if (this.zyn)
    {
      f3 = 1.0F - f1;
      label318:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.zyn) {
        break label453;
      }
      f3 = 1.0F - f1;
      label345:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.zyn) {
        break label460;
      }
      f3 = f1;
      label368:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.zyn) {
        break label469;
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
      break label318;
      label453:
      f3 = f1;
      break label345;
      label460:
      f3 = 1.0F - f1;
      break label368;
      label469:
      f1 = 1.0F - f1;
    }
    paramArrayOfFloat1[0] = f2;
    if (this.zyn)
    {
      f3 = 1.0F - f1;
      label497:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.zyn) {
        break label632;
      }
      f3 = 1.0F - f1;
      label524:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.zyn) {
        break label639;
      }
      f3 = f1;
      label547:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.zyn) {
        break label648;
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
      break label497;
      label632:
      f3 = f1;
      break label524;
      label639:
      f3 = 1.0F - f1;
      break label547;
      label648:
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
      if (this.zyd != null) {
        this.zyd.c(paramArrayOfFloat1, paramArrayOfFloat2);
      }
      AppMethodBeat.o(115752);
      return;
      f2 = 0.5F - paramInt1 * 1.0F * this.mScreenHeight / (paramInt2 * 2.0F * this.mScreenWidth);
      f1 = 0.0F;
    }
  }
  
  public final void QT(int paramInt)
  {
    AppMethodBeat.i(115747);
    if (this.zyg != paramInt)
    {
      ad.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
      this.zyg = paramInt;
      if ((paramInt != 1) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
        ib(this.mVideoWidth, this.mVideoHeight);
      }
    }
    AppMethodBeat.o(115747);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd)
  {
    AppMethodBeat.i(115755);
    if (this.zyd != null) {
      this.zyd.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115755);
  }
  
  public final a dXB()
  {
    AppMethodBeat.i(115756);
    if (this.zyc != null)
    {
      a locala = this.zyc.dXB();
      AppMethodBeat.o(115756);
      return locala;
    }
    AppMethodBeat.o(115756);
    return null;
  }
  
  public final boolean dXE()
  {
    AppMethodBeat.i(115753);
    ad.m("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", new Object[] { Boolean.valueOf(this.zyh), this.zyd });
    if ((!this.zyh) && (this.zyd != null)) {}
    try
    {
      Object localObject = t.zlN;
      t.dUg();
      localObject = this.zyd;
      c.dXy();
      this.zyh = true;
      ad.i("MicroMsg.VoipRenderer", "attachGLContext done!");
      boolean bool = this.zyh;
      AppMethodBeat.o(115753);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.zyh = false;
        ad.printErrStackTrace("MicroMsg.VoipRenderer", localException, "attachGLContext error!", new Object[0]);
        t localt = t.zlN;
        t.dUh();
      }
    }
  }
  
  public final boolean dXF()
  {
    AppMethodBeat.i(115754);
    ad.m("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", new Object[] { Boolean.valueOf(this.zyh) });
    if ((this.zyh) && (this.zyd != null)) {}
    try
    {
      Object localObject = t.zlN;
      t.dUi();
      localObject = this.zyd;
      c.dXz();
      this.zyh = false;
      ad.i("MicroMsg.VoipRenderer", "detachGLContext done!");
      boolean bool = this.zyh;
      AppMethodBeat.o(115754);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.zyh = true;
        ad.printErrStackTrace("MicroMsg.VoipRenderer", localException, "detachGLContext error!", new Object[0]);
        t localt = t.zlN;
        t.dUj();
      }
    }
  }
  
  public final void ia(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115748);
    ad.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.zye = paramInt1;
    this.zyf = paramInt2;
    a(this.zye, this.zyf, c.gwe, c.zxL);
    AppMethodBeat.o(115748);
  }
  
  public final void ib(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115750);
    if ((this.zyg != 1) && (this.zyc != null))
    {
      if ((this.zyi == 0) || (this.zyi == 1))
      {
        a(paramInt1, paramInt2, true, this.zyc.zxU, this.zyc.zxT);
        AppMethodBeat.o(115750);
        return;
      }
      a(paramInt1, paramInt2, false, this.zyc.zxU, this.zyc.zxT);
    }
    AppMethodBeat.o(115750);
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(115749);
    for (;;)
    {
      int i;
      Object localObject1;
      Object localObject2;
      int j;
      try
      {
        GLES20.glViewport(0, 0, this.mScreenWidth, this.mScreenHeight);
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        if (this.guA)
        {
          ad.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(this.zyg) });
          this.guA = false;
          if ((this.zyg == 1) && (this.zyd != null)) {
            this.zyd.updateTexImage();
          }
          return;
        }
        if (this.zyg != 0) {
          break label995;
        }
        if ((!this.zyq) || (this.zyc == null)) {
          break label984;
        }
        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth)
        {
          this.y.position(0);
          i = this.mVideoHeight * this.mVideoWidth / 4;
          if (this.zyi == 3) {
            if (this.zym.capacity() == i * 2)
            {
              this.zym.position(0);
              paramGL10 = this.zyc;
              localObject1 = this.y;
              localObject2 = this.zym;
              j = this.mVideoWidth;
              i = this.mVideoHeight;
              paramGL10.a((ByteBuffer)localObject1, j, i, 0);
              j /= 2;
              i /= 2;
              paramGL10.zxM[1].a(j, i, 6410, (Buffer)localObject2, 9729, 33071);
            }
          }
        }
      }
      finally
      {
        AppMethodBeat.o(115749);
      }
      try
      {
        paramGL10 = this.zyc;
        i = this.zyi;
        j = this.zyo;
        if (i == 0) {
          break label1261;
        }
        if (i != 1) {
          break label950;
        }
      }
      catch (Exception paramGL10)
      {
        ad.w("MicroMsg.VoipRenderer", paramGL10.getMessage());
        continue;
      }
      paramGL10.zxS = bool;
      if (paramGL10.zxS)
      {
        paramGL10.zxQ.a(paramGL10.zxR, paramGL10.gtF, paramGL10.gtG);
        paramGL10.c(paramGL10.zxV, paramGL10.zxW);
        GLES20.glViewport(0, 0, paramGL10.gtF, paramGL10.gtG);
        paramGL10.QS(i);
        d.akz();
        localObject1 = paramGL10.zxP;
        localObject2 = paramGL10.zxT;
        Object localObject3 = paramGL10.zxU;
        if ((localObject3 != null) && (localObject2 != null))
        {
          localObject3 = Arrays.copyOf((float[])localObject3, localObject3.length);
          b.q((float[])localObject3);
          if ((((b)localObject1).zxy == null) || (((b)localObject1).zxy.capacity() < localObject3.length)) {
            ((b)localObject1).zxy = ByteBuffer.allocateDirect(localObject3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((b)localObject1).zxy.put((float[])localObject3);
          ((b)localObject1).zxy.position(0);
          localObject2 = Arrays.copyOf((float[])localObject2, localObject2.length);
          if ((((b)localObject1).zxz == null) || (((b)localObject1).zxz.capacity() < localObject2.length)) {
            ((b)localObject1).zxz = ByteBuffer.allocateDirect(localObject2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((b)localObject1).zxz.put((float[])localObject2);
          ((b)localObject1).zxz.position(0);
        }
        paramGL10 = paramGL10.zxP;
        if ((paramGL10.zxv == null) || (paramGL10.zxD <= 0) || (paramGL10.zxE <= 0)) {
          paramGL10.hZ(paramGL10.gtF, paramGL10.gtG);
        }
        b.L(paramGL10.zxv.grh, paramGL10.zxw.gro, paramGL10.zxD, paramGL10.zxE);
        paramGL10.a(paramGL10.zxs, paramGL10.zxu, paramGL10.zxx, paramGL10.zxI, true);
        paramGL10.rY(true);
        b.L(0, 0, 0, 0);
        paramGL10.a(paramGL10.zxt, paramGL10.zxw.gro, paramGL10.zxz, paramGL10.zxy, false);
        paramGL10.rY(false);
        d.akz();
        d.akz();
        this.zyq = false;
        AppMethodBeat.o(115749);
        return;
        ad.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.zym.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        if ((this.zyk.capacity() == i) && (this.zyl.capacity() == i))
        {
          this.zyk.position(0);
          this.zyl.position(0);
          paramGL10 = this.zyc;
          localObject1 = this.y;
          localObject2 = this.zyk;
          localObject3 = this.zyl;
          i = this.mVideoWidth;
          j = this.mVideoHeight;
          paramGL10.a((ByteBuffer)localObject1, i, j, 0);
          paramGL10.a((ByteBuffer)localObject2, i / 2, j / 2, 1);
          paramGL10.a((ByteBuffer)localObject3, i / 2, j / 2, 2);
          continue;
        }
        ad.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.zyk.capacity()), Integer.valueOf(this.zyl.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        ad.e("MicroMsg.VoipRenderer", "draw error, y buffer size not match, y.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.y.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        label950:
        if ((j & 0x8) != 0)
        {
          bool = true;
          continue;
        }
      }
      else
      {
        paramGL10.QS(i);
        continue;
        label984:
        ad.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
        continue;
        label995:
        if (this.zyd == null) {
          continue;
        }
        this.zys += 1;
        if (this.zys % 100 == 0) {
          ad.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", new Object[] { Integer.valueOf(this.zye), Integer.valueOf(this.zyf), Integer.valueOf(this.zys) });
        }
        a(this.zye, this.zyf, c.gwe, c.zxL);
        paramGL10 = this.zyd;
        localObject1 = paramGL10.surfaceTexture;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          paramGL10.updateTexImage();
          GLES20.glUseProgram(paramGL10.zxJ);
          i = GLES20.glGetAttribLocation(paramGL10.zxJ, "vPosition");
          j = GLES20.glGetAttribLocation(paramGL10.zxJ, "vTexCoord");
          int k = GLES20.glGetUniformLocation(paramGL10.zxJ, "sTexture");
          GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, paramGL10.mVertexBuffer);
          GLES20.glEnableVertexAttribArray(i);
          GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, paramGL10.zxK);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramGL10.zpx.gro);
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
          ad.printErrStackTrace("MicroMsg.VoipGLHProgram", paramGL10, "renderThis error", new Object[0]);
        }
        continue;
      }
      label1261:
      boolean bool = false;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115746);
    ad.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", new Object[] { Integer.valueOf(this.zyg), Integer.valueOf(this.zyi) });
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.zyc == null) {
      this.zyc = new d();
    }
    if (this.zyd == null) {
      this.zyd = new c();
    }
    this.mScreenHeight = paramInt2;
    this.mScreenWidth = paramInt1;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
      ib(this.mVideoWidth, this.mVideoHeight);
    }
    if (this.zyc != null)
    {
      paramGL10 = this.zyc;
      ad.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramGL10.surfaceWidth), Integer.valueOf(paramGL10.surfaceHeight) });
      if ((paramInt1 != paramGL10.surfaceWidth) || (paramGL10.surfaceHeight != paramInt2))
      {
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
        paramGL10 = paramGL10.zxP;
        ad.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
      }
    }
    this.zyp = true;
    ad.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
    AppMethodBeat.o(115746);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115745);
    ad.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", new Object[] { Integer.valueOf(this.zyg) });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.zyc == null) {
      this.zyc = new d();
    }
    if (this.zyd == null) {
      this.zyd = new c();
    }
    this.zyr = 0;
    this.zys = 0;
    AppMethodBeat.o(115745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.g
 * JD-Core Version:    0.7.0.1
 */