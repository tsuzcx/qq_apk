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
  public int ADH;
  public volatile boolean CqA;
  public int CqB;
  public int CqC;
  public volatile d Cqn;
  public volatile c Cqo;
  private int Cqp;
  private int Cqq;
  public boolean Cqr;
  public int Cqs;
  public ByteBuffer Cqt;
  public ByteBuffer Cqu;
  public ByteBuffer Cqv;
  public ByteBuffer Cqw;
  public boolean Cqx;
  public int Cqy;
  public boolean Cqz;
  private final String TAG;
  public int gLA;
  private volatile boolean hni;
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
    this.Cqp = 0;
    this.Cqq = 0;
    this.gLA = 0;
    this.Cqr = false;
    this.Cqs = 3;
    this.Cqt = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.Cqu = ByteBuffer.allocate(0);
    this.Cqv = ByteBuffer.allocate(0);
    this.Cqw = ByteBuffer.allocate(0);
    this.Cqy = 0;
    this.Cqz = false;
    this.CqA = false;
    this.hni = false;
    this.CqB = 0;
    this.CqC = 0;
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
      switch (this.ADH)
      {
      case 2: 
      default: 
        if (this.Cqn != null) {
          this.Cqn.c(paramArrayOfFloat2, paramArrayOfFloat1);
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
    if (this.Cqx)
    {
      f3 = 1.0F - f1;
      label318:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.Cqx) {
        break label453;
      }
      f3 = 1.0F - f1;
      label345:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.Cqx) {
        break label460;
      }
      f3 = f1;
      label368:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.Cqx) {
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
    if (this.Cqx)
    {
      f3 = 1.0F - f1;
      label497:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.Cqx) {
        break label632;
      }
      f3 = 1.0F - f1;
      label524:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.Cqx) {
        break label639;
      }
      f3 = f1;
      label547:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.Cqx) {
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
      if (this.Cqo != null) {
        this.Cqo.c(paramArrayOfFloat1, paramArrayOfFloat2);
      }
      AppMethodBeat.o(115752);
      return;
      f2 = 0.5F - paramInt1 * 1.0F * this.mScreenHeight / (paramInt2 * 2.0F * this.mScreenWidth);
      f1 = 0.0F;
    }
  }
  
  public final void UV(int paramInt)
  {
    AppMethodBeat.i(115747);
    if (this.gLA != paramInt)
    {
      ad.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
      this.gLA = paramInt;
      if ((paramInt != 1) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
        iD(this.mVideoWidth, this.mVideoHeight);
      }
    }
    AppMethodBeat.o(115747);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115755);
    if (this.Cqo != null) {
      this.Cqo.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115755);
  }
  
  public final a eAU()
  {
    AppMethodBeat.i(115756);
    if (this.Cqn != null)
    {
      a locala = this.Cqn.eAU();
      AppMethodBeat.o(115756);
      return locala;
    }
    AppMethodBeat.o(115756);
    return null;
  }
  
  public final boolean eAX()
  {
    AppMethodBeat.i(115753);
    ad.m("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", new Object[] { Boolean.valueOf(this.Cqr), this.Cqo });
    if ((!this.Cqr) && (this.Cqo != null)) {}
    try
    {
      Object localObject = t.CdB;
      t.exd();
      localObject = this.Cqo;
      c.eAR();
      this.Cqr = true;
      ad.i("MicroMsg.VoipRenderer", "attachGLContext done!");
      boolean bool = this.Cqr;
      AppMethodBeat.o(115753);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Cqr = false;
        ad.printErrStackTrace("MicroMsg.VoipRenderer", localException, "attachGLContext error!", new Object[0]);
        t localt = t.CdB;
        t.exe();
      }
    }
  }
  
  public final boolean eAY()
  {
    AppMethodBeat.i(115754);
    ad.m("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", new Object[] { Boolean.valueOf(this.Cqr) });
    if ((this.Cqr) && (this.Cqo != null)) {}
    try
    {
      Object localObject = t.CdB;
      t.exf();
      localObject = this.Cqo;
      c.eAS();
      this.Cqr = false;
      ad.i("MicroMsg.VoipRenderer", "detachGLContext done!");
      boolean bool = this.Cqr;
      AppMethodBeat.o(115754);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Cqr = true;
        ad.printErrStackTrace("MicroMsg.VoipRenderer", localException, "detachGLContext error!", new Object[0]);
        t localt = t.CdB;
        t.exg();
      }
    }
  }
  
  public final void iC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115748);
    ad.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.Cqp = paramInt1;
    this.Cqq = paramInt2;
    a(this.Cqp, this.Cqq, c.hoI, c.CpW);
    AppMethodBeat.o(115748);
  }
  
  public final void iD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115750);
    if ((this.gLA != 1) && (this.Cqn != null))
    {
      if ((this.Cqs == 0) || (this.Cqs == 1))
      {
        a(paramInt1, paramInt2, true, this.Cqn.Cqf, this.Cqn.Cqe);
        AppMethodBeat.o(115750);
        return;
      }
      a(paramInt1, paramInt2, false, this.Cqn.Cqf, this.Cqn.Cqe);
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
        if (this.hni)
        {
          ad.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(this.gLA) });
          this.hni = false;
          if ((this.gLA == 1) && (this.Cqo != null)) {
            this.Cqo.updateTexImage();
          }
          return;
        }
        if (this.gLA != 0) {
          break label995;
        }
        if ((!this.CqA) || (this.Cqn == null)) {
          break label984;
        }
        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth)
        {
          this.y.position(0);
          i = this.mVideoHeight * this.mVideoWidth / 4;
          if (this.Cqs == 3) {
            if (this.Cqw.capacity() == i * 2)
            {
              this.Cqw.position(0);
              paramGL10 = this.Cqn;
              localObject1 = this.y;
              localObject2 = this.Cqw;
              j = this.mVideoWidth;
              i = this.mVideoHeight;
              paramGL10.a((ByteBuffer)localObject1, j, i, 0);
              j /= 2;
              i /= 2;
              paramGL10.CpX[1].a(j, i, 6410, (Buffer)localObject2, 9729, 33071);
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
        paramGL10 = this.Cqn;
        i = this.Cqs;
        j = this.Cqy;
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
      paramGL10.Cqd = bool;
      if (paramGL10.Cqd)
      {
        paramGL10.Cqb.a(paramGL10.Cqc, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.c(paramGL10.Cqg, paramGL10.Cqh);
        GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.UU(i);
        d.aug();
        localObject1 = paramGL10.Cqa;
        localObject2 = paramGL10.Cqe;
        Object localObject3 = paramGL10.Cqf;
        if ((localObject3 != null) && (localObject2 != null))
        {
          localObject3 = Arrays.copyOf((float[])localObject3, localObject3.length);
          b.q((float[])localObject3);
          if ((((b)localObject1).CpI == null) || (((b)localObject1).CpI.capacity() < localObject3.length)) {
            ((b)localObject1).CpI = ByteBuffer.allocateDirect(localObject3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((b)localObject1).CpI.put((float[])localObject3);
          ((b)localObject1).CpI.position(0);
          localObject2 = Arrays.copyOf((float[])localObject2, localObject2.length);
          if ((((b)localObject1).CpJ == null) || (((b)localObject1).CpJ.capacity() < localObject2.length)) {
            ((b)localObject1).CpJ = ByteBuffer.allocateDirect(localObject2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((b)localObject1).CpJ.put((float[])localObject2);
          ((b)localObject1).CpJ.position(0);
        }
        paramGL10 = paramGL10.Cqa;
        if ((paramGL10.CpF == null) || (paramGL10.CpN <= 0) || (paramGL10.CpO <= 0)) {
          paramGL10.iB(paramGL10.outputWidth, paramGL10.outputHeight);
        }
        b.N(paramGL10.CpF.hkh, paramGL10.CpG.hko, paramGL10.CpN, paramGL10.CpO);
        paramGL10.a(paramGL10.CpC, paramGL10.CpE, paramGL10.CpH, paramGL10.CpS, true);
        paramGL10.tJ(true);
        b.N(0, 0, 0, 0);
        paramGL10.a(paramGL10.CpD, paramGL10.CpG.hko, paramGL10.CpJ, paramGL10.CpI, false);
        paramGL10.tJ(false);
        d.aug();
        d.aug();
        this.CqA = false;
        AppMethodBeat.o(115749);
        return;
        ad.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.Cqw.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        if ((this.Cqu.capacity() == i) && (this.Cqv.capacity() == i))
        {
          this.Cqu.position(0);
          this.Cqv.position(0);
          paramGL10 = this.Cqn;
          localObject1 = this.y;
          localObject2 = this.Cqu;
          localObject3 = this.Cqv;
          i = this.mVideoWidth;
          j = this.mVideoHeight;
          paramGL10.a((ByteBuffer)localObject1, i, j, 0);
          paramGL10.a((ByteBuffer)localObject2, i / 2, j / 2, 1);
          paramGL10.a((ByteBuffer)localObject3, i / 2, j / 2, 2);
          continue;
        }
        ad.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.Cqu.capacity()), Integer.valueOf(this.Cqv.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
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
        paramGL10.UU(i);
        continue;
        label984:
        ad.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
        continue;
        label995:
        if (this.Cqo == null) {
          continue;
        }
        this.CqC += 1;
        if (this.CqC % 100 == 0) {
          ad.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", new Object[] { Integer.valueOf(this.Cqp), Integer.valueOf(this.Cqq), Integer.valueOf(this.CqC) });
        }
        a(this.Cqp, this.Cqq, c.hoI, c.CpW);
        paramGL10 = this.Cqo;
        localObject1 = paramGL10.surfaceTexture;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          paramGL10.updateTexImage();
          GLES20.glUseProgram(paramGL10.CpU);
          i = GLES20.glGetAttribLocation(paramGL10.CpU, "vPosition");
          j = GLES20.glGetAttribLocation(paramGL10.CpU, "vTexCoord");
          int k = GLES20.glGetUniformLocation(paramGL10.CpU, "sTexture");
          GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, paramGL10.mVertexBuffer);
          GLES20.glEnableVertexAttribArray(i);
          GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, paramGL10.CpV);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramGL10.Chn.hko);
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
    ad.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", new Object[] { Integer.valueOf(this.gLA), Integer.valueOf(this.Cqs) });
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.Cqn == null) {
      this.Cqn = new d();
    }
    if (this.Cqo == null) {
      this.Cqo = new c();
    }
    this.mScreenHeight = paramInt2;
    this.mScreenWidth = paramInt1;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
      iD(this.mVideoWidth, this.mVideoHeight);
    }
    if (this.Cqn != null)
    {
      paramGL10 = this.Cqn;
      ad.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramGL10.surfaceWidth), Integer.valueOf(paramGL10.surfaceHeight) });
      if ((paramInt1 != paramGL10.surfaceWidth) || (paramGL10.surfaceHeight != paramInt2))
      {
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
        paramGL10 = paramGL10.Cqa;
        ad.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
      }
    }
    this.Cqz = true;
    ad.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
    AppMethodBeat.o(115746);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115745);
    ad.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", new Object[] { Integer.valueOf(this.gLA) });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.Cqn == null) {
      this.Cqn = new d();
    }
    if (this.Cqo == null) {
      this.Cqo = new c();
    }
    this.CqB = 0;
    this.CqC = 0;
    AppMethodBeat.o(115745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.g
 * JD-Core Version:    0.7.0.1
 */