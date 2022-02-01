package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.ae;
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
  public int AVh;
  public volatile d CHR;
  public volatile c CHS;
  private int CHT;
  private int CHU;
  public boolean CHV;
  public int CHW;
  public ByteBuffer CHX;
  public ByteBuffer CHY;
  public ByteBuffer CHZ;
  public ByteBuffer CIa;
  public boolean CIb;
  public int CIc;
  public boolean CId;
  public volatile boolean CIe;
  public int CIf;
  public int CIg;
  private final String TAG;
  public int gOj;
  private volatile boolean hpW;
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
    this.CHT = 0;
    this.CHU = 0;
    this.gOj = 0;
    this.CHV = false;
    this.CHW = 3;
    this.CHX = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.CHY = ByteBuffer.allocate(0);
    this.CHZ = ByteBuffer.allocate(0);
    this.CIa = ByteBuffer.allocate(0);
    this.CIc = 0;
    this.CId = false;
    this.CIe = false;
    this.hpW = false;
    this.CIf = 0;
    this.CIg = 0;
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
      switch (this.AVh)
      {
      case 2: 
      default: 
        if (this.CHR != null) {
          this.CHR.c(paramArrayOfFloat2, paramArrayOfFloat1);
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
    if (this.CIb)
    {
      f3 = 1.0F - f1;
      label318:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.CIb) {
        break label453;
      }
      f3 = 1.0F - f1;
      label345:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.CIb) {
        break label460;
      }
      f3 = f1;
      label368:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.CIb) {
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
    if (this.CIb)
    {
      f3 = 1.0F - f1;
      label497:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.CIb) {
        break label632;
      }
      f3 = 1.0F - f1;
      label524:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.CIb) {
        break label639;
      }
      f3 = f1;
      label547:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.CIb) {
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
      if (this.CHS != null) {
        this.CHS.c(paramArrayOfFloat1, paramArrayOfFloat2);
      }
      AppMethodBeat.o(115752);
      return;
      f2 = 0.5F - paramInt1 * 1.0F * this.mScreenHeight / (paramInt2 * 2.0F * this.mScreenWidth);
      f1 = 0.0F;
    }
  }
  
  public final void VC(int paramInt)
  {
    AppMethodBeat.i(115747);
    if (this.gOj != paramInt)
    {
      ae.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
      this.gOj = paramInt;
      if ((paramInt != 1) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
        iH(this.mVideoWidth, this.mVideoHeight);
      }
    }
    AppMethodBeat.o(115747);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115755);
    if (this.CHS != null) {
      this.CHS.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115755);
  }
  
  public final a eEC()
  {
    AppMethodBeat.i(115756);
    if (this.CHR != null)
    {
      a locala = this.CHR.eEC();
      AppMethodBeat.o(115756);
      return locala;
    }
    AppMethodBeat.o(115756);
    return null;
  }
  
  public final boolean eEF()
  {
    AppMethodBeat.i(115753);
    ae.m("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", new Object[] { Boolean.valueOf(this.CHV), this.CHS });
    if ((!this.CHV) && (this.CHS != null)) {}
    try
    {
      Object localObject = t.Cvc;
      t.eAK();
      localObject = this.CHS;
      c.eEz();
      this.CHV = true;
      ae.i("MicroMsg.VoipRenderer", "attachGLContext done!");
      boolean bool = this.CHV;
      AppMethodBeat.o(115753);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.CHV = false;
        ae.printErrStackTrace("MicroMsg.VoipRenderer", localException, "attachGLContext error!", new Object[0]);
        t localt = t.Cvc;
        t.eAL();
      }
    }
  }
  
  public final boolean eEG()
  {
    AppMethodBeat.i(115754);
    ae.m("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", new Object[] { Boolean.valueOf(this.CHV) });
    if ((this.CHV) && (this.CHS != null)) {}
    try
    {
      Object localObject = t.Cvc;
      t.eAM();
      localObject = this.CHS;
      c.eEA();
      this.CHV = false;
      ae.i("MicroMsg.VoipRenderer", "detachGLContext done!");
      boolean bool = this.CHV;
      AppMethodBeat.o(115754);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.CHV = true;
        ae.printErrStackTrace("MicroMsg.VoipRenderer", localException, "detachGLContext error!", new Object[0]);
        t localt = t.Cvc;
        t.eAN();
      }
    }
  }
  
  public final void iG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115748);
    ae.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.CHT = paramInt1;
    this.CHU = paramInt2;
    a(this.CHT, this.CHU, c.hrw, c.CHA);
    AppMethodBeat.o(115748);
  }
  
  public final void iH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115750);
    if ((this.gOj != 1) && (this.CHR != null))
    {
      if ((this.CHW == 0) || (this.CHW == 1))
      {
        a(paramInt1, paramInt2, true, this.CHR.CHJ, this.CHR.CHI);
        AppMethodBeat.o(115750);
        return;
      }
      a(paramInt1, paramInt2, false, this.CHR.CHJ, this.CHR.CHI);
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
        if (this.hpW)
        {
          ae.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(this.gOj) });
          this.hpW = false;
          if ((this.gOj == 1) && (this.CHS != null)) {
            this.CHS.updateTexImage();
          }
          return;
        }
        if (this.gOj != 0) {
          break label995;
        }
        if ((!this.CIe) || (this.CHR == null)) {
          break label984;
        }
        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth)
        {
          this.y.position(0);
          i = this.mVideoHeight * this.mVideoWidth / 4;
          if (this.CHW == 3) {
            if (this.CIa.capacity() == i * 2)
            {
              this.CIa.position(0);
              paramGL10 = this.CHR;
              localObject1 = this.y;
              localObject2 = this.CIa;
              j = this.mVideoWidth;
              i = this.mVideoHeight;
              paramGL10.a((ByteBuffer)localObject1, j, i, 0);
              j /= 2;
              i /= 2;
              paramGL10.CHB[1].a(j, i, 6410, (Buffer)localObject2, 9729, 33071);
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
        paramGL10 = this.CHR;
        i = this.CHW;
        j = this.CIc;
        if (i == 0) {
          break label1261;
        }
        if (i != 1) {
          break label950;
        }
      }
      catch (Exception paramGL10)
      {
        ae.w("MicroMsg.VoipRenderer", paramGL10.getMessage());
        continue;
      }
      paramGL10.CHH = bool;
      if (paramGL10.CHH)
      {
        paramGL10.CHF.a(paramGL10.CHG, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.c(paramGL10.CHK, paramGL10.CHL);
        GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.VB(i);
        d.auv();
        localObject1 = paramGL10.CHE;
        localObject2 = paramGL10.CHI;
        Object localObject3 = paramGL10.CHJ;
        if ((localObject3 != null) && (localObject2 != null))
        {
          localObject3 = Arrays.copyOf((float[])localObject3, localObject3.length);
          b.q((float[])localObject3);
          if ((((b)localObject1).CHm == null) || (((b)localObject1).CHm.capacity() < localObject3.length)) {
            ((b)localObject1).CHm = ByteBuffer.allocateDirect(localObject3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((b)localObject1).CHm.put((float[])localObject3);
          ((b)localObject1).CHm.position(0);
          localObject2 = Arrays.copyOf((float[])localObject2, localObject2.length);
          if ((((b)localObject1).CHn == null) || (((b)localObject1).CHn.capacity() < localObject2.length)) {
            ((b)localObject1).CHn = ByteBuffer.allocateDirect(localObject2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((b)localObject1).CHn.put((float[])localObject2);
          ((b)localObject1).CHn.position(0);
        }
        paramGL10 = paramGL10.CHE;
        if ((paramGL10.CHj == null) || (paramGL10.CHr <= 0) || (paramGL10.CHs <= 0)) {
          paramGL10.iF(paramGL10.outputWidth, paramGL10.outputHeight);
        }
        b.N(paramGL10.CHj.hmV, paramGL10.CHk.hnc, paramGL10.CHr, paramGL10.CHs);
        paramGL10.a(paramGL10.CHg, paramGL10.CHi, paramGL10.CHl, paramGL10.CHw, true);
        paramGL10.tQ(true);
        b.N(0, 0, 0, 0);
        paramGL10.a(paramGL10.CHh, paramGL10.CHk.hnc, paramGL10.CHn, paramGL10.CHm, false);
        paramGL10.tQ(false);
        d.auv();
        d.auv();
        this.CIe = false;
        AppMethodBeat.o(115749);
        return;
        ae.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.CIa.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        if ((this.CHY.capacity() == i) && (this.CHZ.capacity() == i))
        {
          this.CHY.position(0);
          this.CHZ.position(0);
          paramGL10 = this.CHR;
          localObject1 = this.y;
          localObject2 = this.CHY;
          localObject3 = this.CHZ;
          i = this.mVideoWidth;
          j = this.mVideoHeight;
          paramGL10.a((ByteBuffer)localObject1, i, j, 0);
          paramGL10.a((ByteBuffer)localObject2, i / 2, j / 2, 1);
          paramGL10.a((ByteBuffer)localObject3, i / 2, j / 2, 2);
          continue;
        }
        ae.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.CHY.capacity()), Integer.valueOf(this.CHZ.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        ae.e("MicroMsg.VoipRenderer", "draw error, y buffer size not match, y.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.y.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
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
        paramGL10.VB(i);
        continue;
        label984:
        ae.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
        continue;
        label995:
        if (this.CHS == null) {
          continue;
        }
        this.CIg += 1;
        if (this.CIg % 100 == 0) {
          ae.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", new Object[] { Integer.valueOf(this.CHT), Integer.valueOf(this.CHU), Integer.valueOf(this.CIg) });
        }
        a(this.CHT, this.CHU, c.hrw, c.CHA);
        paramGL10 = this.CHS;
        localObject1 = paramGL10.surfaceTexture;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          paramGL10.updateTexImage();
          GLES20.glUseProgram(paramGL10.CHy);
          i = GLES20.glGetAttribLocation(paramGL10.CHy, "vPosition");
          j = GLES20.glGetAttribLocation(paramGL10.CHy, "vTexCoord");
          int k = GLES20.glGetUniformLocation(paramGL10.CHy, "sTexture");
          GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, paramGL10.mVertexBuffer);
          GLES20.glEnableVertexAttribArray(i);
          GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, paramGL10.CHz);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramGL10.CyO.hnc);
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
          ae.printErrStackTrace("MicroMsg.VoipGLHProgram", paramGL10, "renderThis error", new Object[0]);
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
    ae.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", new Object[] { Integer.valueOf(this.gOj), Integer.valueOf(this.CHW) });
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.CHR == null) {
      this.CHR = new d();
    }
    if (this.CHS == null) {
      this.CHS = new c();
    }
    this.mScreenHeight = paramInt2;
    this.mScreenWidth = paramInt1;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
      iH(this.mVideoWidth, this.mVideoHeight);
    }
    if (this.CHR != null)
    {
      paramGL10 = this.CHR;
      ae.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramGL10.surfaceWidth), Integer.valueOf(paramGL10.surfaceHeight) });
      if ((paramInt1 != paramGL10.surfaceWidth) || (paramGL10.surfaceHeight != paramInt2))
      {
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
        paramGL10 = paramGL10.CHE;
        ae.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
      }
    }
    this.CId = true;
    ae.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
    AppMethodBeat.o(115746);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115745);
    ae.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", new Object[] { Integer.valueOf(this.gOj) });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.CHR == null) {
      this.CHR = new d();
    }
    if (this.CHS == null) {
      this.CHS = new c();
    }
    this.CIf = 0;
    this.CIg = 0;
    AppMethodBeat.o(115745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.g
 * JD-Core Version:    0.7.0.1
 */