package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.ac;
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
  public volatile d AQV;
  public volatile c AQW;
  private int AQX;
  private int AQY;
  public boolean AQZ;
  public int ARa;
  public ByteBuffer ARb;
  public ByteBuffer ARc;
  public ByteBuffer ARd;
  public ByteBuffer ARe;
  public boolean ARf;
  public int ARg;
  public boolean ARh;
  public volatile boolean ARi;
  public int ARj;
  public int ARk;
  private final String TAG;
  private volatile boolean gVf;
  public int grS;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public ByteBuffer y;
  public int zlw;
  
  public g()
  {
    AppMethodBeat.i(115744);
    this.TAG = "MicroMsg.VoipRenderer";
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.AQX = 0;
    this.AQY = 0;
    this.grS = 0;
    this.AQZ = false;
    this.ARa = 3;
    this.ARb = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.ARc = ByteBuffer.allocate(0);
    this.ARd = ByteBuffer.allocate(0);
    this.ARe = ByteBuffer.allocate(0);
    this.ARg = 0;
    this.ARh = false;
    this.ARi = false;
    this.gVf = false;
    this.ARj = 0;
    this.ARk = 0;
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
      switch (this.zlw)
      {
      case 2: 
      default: 
        if (this.AQV != null) {
          this.AQV.c(paramArrayOfFloat2, paramArrayOfFloat1);
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
    if (this.ARf)
    {
      f3 = 1.0F - f1;
      label318:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.ARf) {
        break label453;
      }
      f3 = 1.0F - f1;
      label345:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.ARf) {
        break label460;
      }
      f3 = f1;
      label368:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.ARf) {
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
    if (this.ARf)
    {
      f3 = 1.0F - f1;
      label497:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.ARf) {
        break label632;
      }
      f3 = 1.0F - f1;
      label524:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.ARf) {
        break label639;
      }
      f3 = f1;
      label547:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.ARf) {
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
      if (this.AQW != null) {
        this.AQW.c(paramArrayOfFloat1, paramArrayOfFloat2);
      }
      AppMethodBeat.o(115752);
      return;
      f2 = 0.5F - paramInt1 * 1.0F * this.mScreenHeight / (paramInt2 * 2.0F * this.mScreenWidth);
      f1 = 0.0F;
    }
  }
  
  public final void Tc(int paramInt)
  {
    AppMethodBeat.i(115747);
    if (this.grS != paramInt)
    {
      ac.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
      this.grS = paramInt;
      if ((paramInt != 1) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
        iq(this.mVideoWidth, this.mVideoHeight);
      }
    }
    AppMethodBeat.o(115747);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd)
  {
    AppMethodBeat.i(115755);
    if (this.AQW != null) {
      this.AQW.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115755);
  }
  
  public final a emW()
  {
    AppMethodBeat.i(115756);
    if (this.AQV != null)
    {
      a locala = this.AQV.emW();
      AppMethodBeat.o(115756);
      return locala;
    }
    AppMethodBeat.o(115756);
    return null;
  }
  
  public final boolean emZ()
  {
    AppMethodBeat.i(115753);
    ac.m("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", new Object[] { Boolean.valueOf(this.AQZ), this.AQW });
    if ((!this.AQZ) && (this.AQW != null)) {}
    try
    {
      Object localObject = t.AEB;
      t.ejs();
      localObject = this.AQW;
      c.emT();
      this.AQZ = true;
      ac.i("MicroMsg.VoipRenderer", "attachGLContext done!");
      boolean bool = this.AQZ;
      AppMethodBeat.o(115753);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.AQZ = false;
        ac.printErrStackTrace("MicroMsg.VoipRenderer", localException, "attachGLContext error!", new Object[0]);
        t localt = t.AEB;
        t.ejt();
      }
    }
  }
  
  public final boolean ena()
  {
    AppMethodBeat.i(115754);
    ac.m("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", new Object[] { Boolean.valueOf(this.AQZ) });
    if ((this.AQZ) && (this.AQW != null)) {}
    try
    {
      Object localObject = t.AEB;
      t.eju();
      localObject = this.AQW;
      c.emU();
      this.AQZ = false;
      ac.i("MicroMsg.VoipRenderer", "detachGLContext done!");
      boolean bool = this.AQZ;
      AppMethodBeat.o(115754);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.AQZ = true;
        ac.printErrStackTrace("MicroMsg.VoipRenderer", localException, "detachGLContext error!", new Object[0]);
        t localt = t.AEB;
        t.ejv();
      }
    }
  }
  
  public final void ip(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115748);
    ac.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.AQX = paramInt1;
    this.AQY = paramInt2;
    a(this.AQX, this.AQY, c.gWC, c.AQE);
    AppMethodBeat.o(115748);
  }
  
  public final void iq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115750);
    if ((this.grS != 1) && (this.AQV != null))
    {
      if ((this.ARa == 0) || (this.ARa == 1))
      {
        a(paramInt1, paramInt2, true, this.AQV.AQN, this.AQV.AQM);
        AppMethodBeat.o(115750);
        return;
      }
      a(paramInt1, paramInt2, false, this.AQV.AQN, this.AQV.AQM);
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
        if (this.gVf)
        {
          ac.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(this.grS) });
          this.gVf = false;
          if ((this.grS == 1) && (this.AQW != null)) {
            this.AQW.updateTexImage();
          }
          return;
        }
        if (this.grS != 0) {
          break label995;
        }
        if ((!this.ARi) || (this.AQV == null)) {
          break label984;
        }
        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth)
        {
          this.y.position(0);
          i = this.mVideoHeight * this.mVideoWidth / 4;
          if (this.ARa == 3) {
            if (this.ARe.capacity() == i * 2)
            {
              this.ARe.position(0);
              paramGL10 = this.AQV;
              localObject1 = this.y;
              localObject2 = this.ARe;
              j = this.mVideoWidth;
              i = this.mVideoHeight;
              paramGL10.b((ByteBuffer)localObject1, j, i, 0);
              j /= 2;
              i /= 2;
              paramGL10.AQF[1].a(j, i, 6410, (Buffer)localObject2, 9729, 33071);
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
        paramGL10 = this.AQV;
        i = this.ARa;
        j = this.ARg;
        if (i == 0) {
          break label1261;
        }
        if (i != 1) {
          break label950;
        }
      }
      catch (Exception paramGL10)
      {
        ac.w("MicroMsg.VoipRenderer", paramGL10.getMessage());
        continue;
      }
      paramGL10.AQL = bool;
      if (paramGL10.AQL)
      {
        paramGL10.AQJ.a(paramGL10.AQK, paramGL10.grA, paramGL10.grB);
        paramGL10.c(paramGL10.AQO, paramGL10.AQP);
        GLES20.glViewport(0, 0, paramGL10.grA, paramGL10.grB);
        paramGL10.Tb(i);
        d.art();
        localObject1 = paramGL10.AQI;
        localObject2 = paramGL10.AQM;
        Object localObject3 = paramGL10.AQN;
        if ((localObject3 != null) && (localObject2 != null))
        {
          localObject3 = Arrays.copyOf((float[])localObject3, localObject3.length);
          b.q((float[])localObject3);
          if ((((b)localObject1).AQq == null) || (((b)localObject1).AQq.capacity() < localObject3.length)) {
            ((b)localObject1).AQq = ByteBuffer.allocateDirect(localObject3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((b)localObject1).AQq.put((float[])localObject3);
          ((b)localObject1).AQq.position(0);
          localObject2 = Arrays.copyOf((float[])localObject2, localObject2.length);
          if ((((b)localObject1).AQr == null) || (((b)localObject1).AQr.capacity() < localObject2.length)) {
            ((b)localObject1).AQr = ByteBuffer.allocateDirect(localObject2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((b)localObject1).AQr.put((float[])localObject2);
          ((b)localObject1).AQr.position(0);
        }
        paramGL10 = paramGL10.AQI;
        if ((paramGL10.AQn == null) || (paramGL10.AQv <= 0) || (paramGL10.AQw <= 0)) {
          paramGL10.io(paramGL10.grA, paramGL10.grB);
        }
        b.N(paramGL10.AQn.gRP, paramGL10.AQo.gRW, paramGL10.AQv, paramGL10.AQw);
        paramGL10.a(paramGL10.AQk, paramGL10.AQm, paramGL10.AQp, paramGL10.AQA, true);
        paramGL10.sZ(true);
        b.N(0, 0, 0, 0);
        paramGL10.a(paramGL10.AQl, paramGL10.AQo.gRW, paramGL10.AQr, paramGL10.AQq, false);
        paramGL10.sZ(false);
        d.art();
        d.art();
        this.ARi = false;
        AppMethodBeat.o(115749);
        return;
        ac.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.ARe.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        if ((this.ARc.capacity() == i) && (this.ARd.capacity() == i))
        {
          this.ARc.position(0);
          this.ARd.position(0);
          paramGL10 = this.AQV;
          localObject1 = this.y;
          localObject2 = this.ARc;
          localObject3 = this.ARd;
          i = this.mVideoWidth;
          j = this.mVideoHeight;
          paramGL10.b((ByteBuffer)localObject1, i, j, 0);
          paramGL10.b((ByteBuffer)localObject2, i / 2, j / 2, 1);
          paramGL10.b((ByteBuffer)localObject3, i / 2, j / 2, 2);
          continue;
        }
        ac.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.ARc.capacity()), Integer.valueOf(this.ARd.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        ac.e("MicroMsg.VoipRenderer", "draw error, y buffer size not match, y.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.y.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
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
        paramGL10.Tb(i);
        continue;
        label984:
        ac.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
        continue;
        label995:
        if (this.AQW == null) {
          continue;
        }
        this.ARk += 1;
        if (this.ARk % 100 == 0) {
          ac.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", new Object[] { Integer.valueOf(this.AQX), Integer.valueOf(this.AQY), Integer.valueOf(this.ARk) });
        }
        a(this.AQX, this.AQY, c.gWC, c.AQE);
        paramGL10 = this.AQW;
        localObject1 = paramGL10.surfaceTexture;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          paramGL10.updateTexImage();
          GLES20.glUseProgram(paramGL10.AQC);
          i = GLES20.glGetAttribLocation(paramGL10.AQC, "vPosition");
          j = GLES20.glGetAttribLocation(paramGL10.AQC, "vTexCoord");
          int k = GLES20.glGetUniformLocation(paramGL10.AQC, "sTexture");
          GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, paramGL10.mVertexBuffer);
          GLES20.glEnableVertexAttribArray(i);
          GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, paramGL10.AQD);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramGL10.AIm.gRW);
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
          ac.printErrStackTrace("MicroMsg.VoipGLHProgram", paramGL10, "renderThis error", new Object[0]);
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
    ac.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", new Object[] { Integer.valueOf(this.grS), Integer.valueOf(this.ARa) });
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.AQV == null) {
      this.AQV = new d();
    }
    if (this.AQW == null) {
      this.AQW = new c();
    }
    this.mScreenHeight = paramInt2;
    this.mScreenWidth = paramInt1;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
      iq(this.mVideoWidth, this.mVideoHeight);
    }
    if (this.AQV != null)
    {
      paramGL10 = this.AQV;
      ac.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramGL10.surfaceWidth), Integer.valueOf(paramGL10.surfaceHeight) });
      if ((paramInt1 != paramGL10.surfaceWidth) || (paramGL10.surfaceHeight != paramInt2))
      {
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
        paramGL10 = paramGL10.AQI;
        ac.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
      }
    }
    this.ARh = true;
    ac.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
    AppMethodBeat.o(115746);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115745);
    ac.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", new Object[] { Integer.valueOf(this.grS) });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.AQV == null) {
      this.AQV = new d();
    }
    if (this.AQW == null) {
      this.AQW = new c();
    }
    this.ARj = 0;
    this.ARk = 0;
    AppMethodBeat.o(115745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.g
 * JD-Core Version:    0.7.0.1
 */