package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ct.a.e;
import com.tencent.mm.ct.a.j;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class g
  implements GLSurfaceView.Renderer
{
  public int Lur;
  public boolean NZr;
  public j ObJ;
  public int ObK;
  public float ObL;
  public volatile d OcP;
  public volatile c OcQ;
  private int OcR;
  private int OcS;
  public boolean OcT;
  public int OcU;
  public ByteBuffer OcV;
  public ByteBuffer OcW;
  public ByteBuffer OcX;
  public ByteBuffer OcY;
  public boolean OcZ;
  public int Oda;
  public int Odb;
  public boolean Odc;
  public volatile boolean Odd;
  public int Ode;
  public int Odf;
  public int Odg;
  private final String TAG;
  private volatile boolean kYe;
  public int ksr;
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
    this.OcR = 0;
    this.OcS = 0;
    this.ksr = 0;
    this.OcT = false;
    this.OcU = 3;
    this.OcV = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.OcW = ByteBuffer.allocate(0);
    this.OcX = ByteBuffer.allocate(0);
    this.OcY = ByteBuffer.allocate(0);
    this.Oda = 0;
    this.Odb = 0;
    this.Odc = false;
    this.NZr = false;
    this.Odd = false;
    this.kYe = false;
    this.ObK = 5;
    this.ObL = 0.0F;
    this.Ode = 0;
    this.Odf = 0;
    this.Odg = 0;
    AppMethodBeat.o(115744);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt3)
  {
    AppMethodBeat.i(245699);
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
      switch (this.Lur)
      {
      case 2: 
      default: 
        com.tencent.mm.media.k.c.e(paramInt3, paramArrayOfFloat1);
        if (this.OcP != null) {
          this.OcP.c(paramArrayOfFloat2, paramArrayOfFloat1);
        }
        AppMethodBeat.o(245699);
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
    if (this.OcZ)
    {
      f3 = 1.0F - f1;
      label586:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.OcZ) {
        break label721;
      }
      f3 = 1.0F - f1;
      label613:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.OcZ) {
        break label728;
      }
      f3 = f1;
      label636:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.OcZ) {
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
    if (this.OcZ)
    {
      f3 = 1.0F - f1;
      label765:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.OcZ) {
        break label900;
      }
      f3 = 1.0F - f1;
      label792:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.OcZ) {
        break label907;
      }
      f3 = f1;
      label815:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.OcZ) {
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
      if (this.OcQ != null) {
        this.OcQ.c(paramArrayOfFloat1, paramArrayOfFloat2);
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
    if (this.OcQ != null) {
      this.OcQ.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115755);
  }
  
  public final void aI(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(245696);
    if ((this.ksr != 1) && (this.OcP != null))
    {
      if ((this.OcU == 0) || (this.OcU == 1))
      {
        a(paramInt1, paramInt2, true, this.OcP.OcH, this.OcP.OcG, 0);
        AppMethodBeat.o(245696);
        return;
      }
      a(paramInt1, paramInt2, false, this.OcP.OcH, this.OcP.OcG, paramInt3);
    }
    AppMethodBeat.o(245696);
  }
  
  public final void alL(int paramInt)
  {
    AppMethodBeat.i(115747);
    if (this.ksr != paramInt)
    {
      Log.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
      this.ksr = paramInt;
      if ((paramInt != 1) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
        aI(this.mVideoWidth, this.mVideoHeight, this.Odg);
      }
    }
    AppMethodBeat.o(115747);
  }
  
  public final com.tencent.mm.plugin.voip.video.d.b gBH()
  {
    AppMethodBeat.i(245701);
    if (this.OcP != null)
    {
      com.tencent.mm.plugin.voip.video.d.b localb = this.OcP.gBH();
      AppMethodBeat.o(245701);
      return localb;
    }
    AppMethodBeat.o(245701);
    return null;
  }
  
  public final a gEj()
  {
    AppMethodBeat.i(115756);
    if (this.OcP != null)
    {
      a locala = this.OcP.gEj();
      AppMethodBeat.o(115756);
      return locala;
    }
    AppMethodBeat.o(115756);
    return null;
  }
  
  public final boolean gEm()
  {
    AppMethodBeat.i(115753);
    Log.printInfoStack("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", new Object[] { Boolean.valueOf(this.OcT), this.OcQ });
    if ((!this.OcT) && (this.OcQ != null)) {}
    try
    {
      Object localObject = t.NPb;
      t.gzP();
      localObject = this.OcQ;
      c.gEg();
      this.OcT = true;
      Log.i("MicroMsg.VoipRenderer", "attachGLContext done!");
      boolean bool = this.OcT;
      AppMethodBeat.o(115753);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.OcT = false;
        Log.printErrStackTrace("MicroMsg.VoipRenderer", localException, "attachGLContext error!", new Object[0]);
        t localt = t.NPb;
        t.gzQ();
      }
    }
  }
  
  public final boolean gEn()
  {
    AppMethodBeat.i(115754);
    Log.printInfoStack("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", new Object[] { Boolean.valueOf(this.OcT) });
    if ((this.OcT) && (this.OcQ != null)) {}
    try
    {
      Object localObject = t.NPb;
      t.gzR();
      localObject = this.OcQ;
      c.gEh();
      this.OcT = false;
      Log.i("MicroMsg.VoipRenderer", "detachGLContext done!");
      boolean bool = this.OcT;
      AppMethodBeat.o(115754);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.OcT = true;
        Log.printErrStackTrace("MicroMsg.VoipRenderer", localException, "detachGLContext error!", new Object[0]);
        t localt = t.NPb;
        t.gzS();
      }
    }
  }
  
  public final void la(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115748);
    Log.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.OcR = paramInt1;
    this.OcS = paramInt2;
    a(this.OcR, this.OcS, c.laj, c.Oct);
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
        if (this.kYe)
        {
          Log.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(this.ksr) });
          this.kYe = false;
          if ((this.ksr == 1) && (this.OcQ != null)) {
            this.OcQ.updateTexImage();
          }
          return;
        }
        if (this.ksr != 0) {
          break label1234;
        }
        if ((!this.Odd) || (this.OcP == null)) {
          break label1223;
        }
        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth)
        {
          this.y.position(0);
          i = this.mVideoHeight * this.mVideoWidth / 4;
          if (this.OcU == 3) {
            if (this.OcY.capacity() == i * 2)
            {
              this.OcY.position(0);
              paramGL10 = this.OcP;
              localObject = this.y;
              localByteBuffer1 = this.OcY;
              j = this.mVideoWidth;
              i = this.mVideoHeight;
              paramGL10.b((ByteBuffer)localObject, j, i, 0);
              j /= 2;
              i /= 2;
              paramGL10.Ocu[1].a(j, i, 6410, localByteBuffer1, 9729, 33071);
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
        if (this.Odb == 1)
        {
          paramGL10 = this.OcP;
          i = this.ObK;
          float f = this.ObL;
          if (paramGL10.OcD)
          {
            paramGL10.ObO.azg(i);
            paramGL10.ObO.dc(f);
          }
        }
        paramGL10 = this.OcP;
        i = this.OcU;
        j = this.Oda;
        bool2 = this.NZr;
        if ((i != 0) && (i != 1)) {
          break;
        }
        paramGL10.OcB = false;
      }
      catch (Exception paramGL10)
      {
        ByteBuffer localByteBuffer2;
        Log.w("MicroMsg.VoipRenderer", paramGL10.getMessage());
        continue;
        if ((paramGL10.OcD) || (!paramGL10.OcB)) {
          continue;
        }
        paramGL10.Ocx.ua(paramGL10.Ocy.kVj);
        continue;
        if ((!paramGL10.OcD) || (paramGL10.OcB)) {
          break label1121;
        }
        paramGL10.Ocy.a(paramGL10.OcA, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.c(paramGL10.OcI, paramGL10.OcJ);
        GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.alK(i);
        d.aVB();
        i = paramGL10.Ocy.kVj;
        paramGL10.a(paramGL10.OcG, paramGL10.OcH, paramGL10.OcF);
        paramGL10.ObO.a(paramGL10.Ocy.kVj, i, i, paramGL10.ObM, paramGL10.ObN);
        d.aVB();
        continue;
        if ((paramGL10.OcD) || (!paramGL10.OcB)) {
          break label1215;
        }
        paramGL10.Ocy.a(paramGL10.OcA, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.c(paramGL10.OcI, paramGL10.OcJ);
        GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
        paramGL10.alK(i);
        d.aVB();
        paramGL10.Ocx.b(paramGL10.OcG, paramGL10.OcH);
        paramGL10.Ocx.gEd();
        d.aVB();
        continue;
        paramGL10.alK(i);
        continue;
      }
      paramGL10.OcD = bool1;
      if ((bool2) && ((paramGL10.OcB != paramGL10.OcC) || (paramGL10.OcD != paramGL10.OcE)))
      {
        paramGL10.OcC = paramGL10.OcB;
        paramGL10.OcE = paramGL10.OcD;
        if ((!paramGL10.OcD) || (!paramGL10.OcB)) {
          break label932;
        }
        paramGL10.Ocx.ua(paramGL10.Ocz.kVj);
        paramGL10.ObO.azj(paramGL10.Ocz.kVj);
        paramGL10.ObO.Ia(false);
      }
      label445:
      if ((!paramGL10.OcD) || (!paramGL10.OcB)) {
        break label1001;
      }
      paramGL10.Ocy.a(paramGL10.OcA, paramGL10.outputWidth, paramGL10.outputHeight);
      paramGL10.c(paramGL10.OcI, paramGL10.OcJ);
      GLES20.glViewport(0, 0, paramGL10.outputWidth, paramGL10.outputHeight);
      paramGL10.alK(i);
      d.aVB();
      paramGL10.ObO.azj(paramGL10.Ocz.kVj);
      i = paramGL10.Ocy.kVj;
      paramGL10.a(paramGL10.OcG, paramGL10.OcH, paramGL10.OcF);
      paramGL10.ObO.a(paramGL10.Ocy.kVj, i, i, paramGL10.ObM, paramGL10.ObN);
      d.aVB();
      paramGL10.Ocx.b(paramGL10.OcG, paramGL10.OcH);
      paramGL10.Ocx.gEd();
      d.aVB();
      d.aVB();
      label604:
      this.Odd = false;
      label609:
      AppMethodBeat.o(115749);
      return;
      Log.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.OcY.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
      continue;
      if ((this.OcW.capacity() == i) && (this.OcX.capacity() == i))
      {
        this.OcW.position(0);
        this.OcX.position(0);
        paramGL10 = this.OcP;
        localObject = this.y;
        localByteBuffer1 = this.OcW;
        localByteBuffer2 = this.OcX;
        i = this.mVideoWidth;
        j = this.mVideoHeight;
        paramGL10.b((ByteBuffer)localObject, i, j, 0);
        paramGL10.b(localByteBuffer1, i / 2, j / 2, 1);
        paramGL10.b(localByteBuffer2, i / 2, j / 2, 2);
      }
      else
      {
        Log.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.OcW.capacity()), Integer.valueOf(this.OcX.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        Log.e("MicroMsg.VoipRenderer", "draw error, y buffer size not match, y.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.y.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
      }
    }
    if ((j & 0x8) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      for (;;)
      {
        paramGL10.OcB = bool1;
        if ((j & 0x20) == 0) {
          break label1501;
        }
        bool1 = true;
        break;
        label932:
        if ((paramGL10.OcD) && (!paramGL10.OcB))
        {
          paramGL10.ObO.Ia(true);
          break label445;
        }
        label1001:
        Log.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
        label1121:
        break label604;
        label1215:
        label1223:
        label1234:
        if (this.OcQ == null) {
          break label609;
        }
        this.Odf += 1;
        if (this.Odf % 100 == 0) {
          Log.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", new Object[] { Integer.valueOf(this.OcR), Integer.valueOf(this.OcS), Integer.valueOf(this.Odf) });
        }
        a(this.OcR, this.OcS, c.laj, c.Oct);
        paramGL10 = this.OcQ;
        localObject = paramGL10.surfaceTexture;
        if (localObject == null) {
          break label609;
        }
        try
        {
          paramGL10.updateTexImage();
          GLES20.glUseProgram(paramGL10.Ocr);
          i = GLES20.glGetAttribLocation(paramGL10.Ocr, "vPosition");
          j = GLES20.glGetAttribLocation(paramGL10.Ocr, "vTexCoord");
          int k = GLES20.glGetUniformLocation(paramGL10.Ocr, "sTexture");
          GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, paramGL10.mVertexBuffer);
          GLES20.glEnableVertexAttribArray(i);
          GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, paramGL10.Ocs);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramGL10.NSP.kVj);
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
    Log.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", new Object[] { Integer.valueOf(this.ksr), Integer.valueOf(this.OcU) });
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.OcP == null) {
      this.OcP = new d();
    }
    if (this.OcQ == null) {
      this.OcQ = new c();
    }
    this.mScreenHeight = paramInt2;
    this.mScreenWidth = paramInt1;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
      aI(this.mVideoWidth, this.mVideoHeight, this.Odg);
    }
    if (this.OcP != null)
    {
      paramGL10 = this.OcP;
      Log.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramGL10.surfaceWidth), Integer.valueOf(paramGL10.surfaceHeight) });
      if ((paramInt1 != paramGL10.surfaceWidth) || (paramGL10.surfaceHeight != paramInt2))
      {
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
        b localb = paramGL10.Ocx;
        Log.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localb.surfaceWidth = paramInt1;
        localb.surfaceHeight = paramInt2;
        paramGL10 = paramGL10.ObO;
        paramGL10.surfaceWidth = paramInt1;
        paramGL10.surfaceHeight = paramInt2;
      }
    }
    this.Odc = true;
    Log.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
    AppMethodBeat.o(115746);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115745);
    Log.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", new Object[] { Integer.valueOf(this.ksr) });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.OcP == null) {
      this.OcP = new d();
    }
    if (this.OcQ == null) {
      this.OcQ = new c();
    }
    this.ObJ = new j();
    this.Ode = 0;
    this.Odf = 0;
    AppMethodBeat.o(115745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.g
 * JD-Core Version:    0.7.0.1
 */