package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class f
  implements GLSurfaceView.Renderer
{
  private final String TAG;
  public boolean bHo;
  private volatile boolean eYb;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public boolean tIH;
  public c tIK;
  public b tIL;
  private int tIM;
  private int tIN;
  public int tIO;
  public int tIP;
  public ByteBuffer tIQ;
  public ByteBuffer tIR;
  public ByteBuffer tIS;
  public ByteBuffer tIT;
  public int tIU;
  public int tIV;
  public boolean tIW;
  public volatile boolean tIX;
  public int tIY;
  public int tIZ;
  public ByteBuffer y;
  
  public f()
  {
    AppMethodBeat.i(140239);
    this.TAG = "MicroMsg.VoipRenderer";
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.tIM = 0;
    this.tIN = 0;
    this.tIO = 0;
    this.tIH = false;
    this.tIP = 3;
    this.tIQ = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.tIR = ByteBuffer.allocate(0);
    this.tIS = ByteBuffer.allocate(0);
    this.tIT = ByteBuffer.allocate(0);
    this.tIV = 0;
    this.tIW = false;
    this.tIX = false;
    this.eYb = false;
    this.tIY = 0;
    this.tIZ = 0;
    AppMethodBeat.o(140239);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(140246);
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
      switch (this.tIU)
      {
      case 2: 
      default: 
        if (this.tIK != null) {
          this.tIK.c(paramArrayOfFloat2, paramArrayOfFloat1);
        }
        AppMethodBeat.o(140246);
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
    if (this.bHo)
    {
      f3 = 1.0F - f1;
      label318:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.bHo) {
        break label453;
      }
      f3 = 1.0F - f1;
      label345:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.bHo) {
        break label460;
      }
      f3 = f1;
      label368:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.bHo) {
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
    if (this.bHo)
    {
      f3 = 1.0F - f1;
      label497:
      paramArrayOfFloat1[1] = f3;
      paramArrayOfFloat1[2] = (1.0F - f2);
      if (!this.bHo) {
        break label632;
      }
      f3 = 1.0F - f1;
      label524:
      paramArrayOfFloat1[3] = f3;
      paramArrayOfFloat1[4] = f2;
      if (!this.bHo) {
        break label639;
      }
      f3 = f1;
      label547:
      paramArrayOfFloat1[5] = f3;
      paramArrayOfFloat1[6] = (1.0F - f2);
      if (!this.bHo) {
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
    AppMethodBeat.i(140247);
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
      if (this.tIL != null) {
        this.tIL.c(paramArrayOfFloat1, paramArrayOfFloat2);
      }
      AppMethodBeat.o(140247);
      return;
      f2 = 0.5F - paramInt1 * 1.0F * this.mScreenHeight / (paramInt2 * 2.0F * this.mScreenWidth);
      f1 = 0.0F;
    }
  }
  
  public final void HY(int paramInt)
  {
    AppMethodBeat.i(140242);
    if (this.tIO != paramInt)
    {
      ab.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
      this.tIO = paramInt;
      if ((paramInt != 1) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
        gs(this.mVideoWidth, this.mVideoHeight);
      }
    }
    AppMethodBeat.o(140242);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    AppMethodBeat.i(140250);
    if (this.tIL != null) {
      this.tIL.a(paramSurfaceTexture, paramInt);
    }
    AppMethodBeat.o(140250);
  }
  
  public final a.a cPW()
  {
    AppMethodBeat.i(140251);
    if (this.tIK != null)
    {
      a.a locala = this.tIK.cPW();
      AppMethodBeat.o(140251);
      return locala;
    }
    AppMethodBeat.o(140251);
    return null;
  }
  
  public final boolean cPZ()
  {
    AppMethodBeat.i(140248);
    ab.i("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", new Object[] { Boolean.valueOf(this.tIH), this.tIL });
    if ((!this.tIH) && (this.tIL != null)) {}
    try
    {
      s locals1 = s.tyN;
      s.cNE();
      b.cPU();
      this.tIH = true;
      ab.i("MicroMsg.VoipRenderer", "attachGLContext done!");
      boolean bool = this.tIH;
      AppMethodBeat.o(140248);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.tIH = false;
        ab.printErrStackTrace("MicroMsg.VoipRenderer", localException, "attachGLContext error!", new Object[0]);
        s locals2 = s.tyN;
        s.cNF();
      }
    }
  }
  
  public final boolean cQa()
  {
    AppMethodBeat.i(140249);
    ab.i("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", new Object[] { Boolean.valueOf(this.tIH) });
    if ((this.tIH) && (this.tIL != null)) {}
    try
    {
      s locals1 = s.tyN;
      s.cNG();
      b.cPV();
      this.tIH = false;
      ab.i("MicroMsg.VoipRenderer", "detachGLContext done!");
      boolean bool = this.tIH;
      AppMethodBeat.o(140249);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.tIH = true;
        ab.printErrStackTrace("MicroMsg.VoipRenderer", localException, "detachGLContext error!", new Object[0]);
        s locals2 = s.tyN;
        s.cNH();
      }
    }
  }
  
  public final void gr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140243);
    ab.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.tIM = paramInt1;
    this.tIN = paramInt2;
    a(this.tIM, this.tIN, b.eZq, b.tIw);
    AppMethodBeat.o(140243);
  }
  
  public final void gs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140245);
    if ((this.tIO != 1) && (this.tIK != null))
    {
      if ((this.tIP == 0) || (this.tIP == 1))
      {
        a(paramInt1, paramInt2, true, this.tIK.tID, this.tIK.tIC);
        AppMethodBeat.o(140245);
        return;
      }
      a(paramInt1, paramInt2, false, this.tIK.tID, this.tIK.tIC);
    }
    AppMethodBeat.o(140245);
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(140244);
    for (;;)
    {
      int i;
      Object localObject1;
      Object localObject2;
      int j;
      int k;
      try
      {
        GLES20.glViewport(0, 0, this.mScreenWidth, this.mScreenHeight);
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        if (this.eYb)
        {
          ab.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(this.tIO) });
          this.eYb = false;
          if ((this.tIO == 1) && (this.tIL != null)) {
            this.tIL.updateTexImage();
          }
          return;
        }
        if (this.tIO != 0) {
          break label1110;
        }
        if ((!this.tIX) || (this.tIK == null)) {
          break label1099;
        }
        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth)
        {
          this.y.position(0);
          i = this.mVideoHeight * this.mVideoWidth / 4;
          if (this.tIP == 3) {
            if (this.tIT.capacity() == i * 2)
            {
              this.tIT.position(0);
              paramGL10 = this.tIK;
              localObject1 = this.y;
              localObject2 = this.tIT;
              j = this.mVideoWidth;
              i = this.mVideoHeight;
              paramGL10.a((ByteBuffer)localObject1, j, i, 0);
              j /= 2;
              i /= 2;
              GLES20.glBindTexture(3553, paramGL10.tIx.get(1));
              GLES20.glTexParameteri(3553, 10241, 9729);
              GLES20.glTexParameteri(3553, 10240, 9729);
              GLES20.glTexParameteri(3553, 10242, 33071);
              GLES20.glTexParameteri(3553, 10243, 33071);
              GLES20.glTexImage2D(3553, 0, 6410, j, i, 0, 6410, 5121, (Buffer)localObject2);
            }
          }
        }
      }
      finally
      {
        int m;
        int n;
        AppMethodBeat.o(140244);
      }
      try
      {
        paramGL10 = this.tIK;
        i = this.tIP;
        j = this.tIV;
        if (i == 0) {
          break label1373;
        }
        if (i != 1) {
          break label1065;
        }
      }
      catch (Exception paramGL10)
      {
        ab.w("MicroMsg.VoipRenderer", paramGL10.getMessage());
        continue;
      }
      paramGL10.tIB = bool;
      if (paramGL10.tIB)
      {
        j = paramGL10.eYx;
        k = paramGL10.eYw;
        m = paramGL10.eXo;
        n = paramGL10.eXp;
        GLES20.glBindFramebuffer(36160, j);
        GLES20.glBindTexture(3553, k);
        GLES20.glTexImage2D(3553, 0, 6408, m, n, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, k, 0);
        GLES20.glBindTexture(3553, 0);
        paramGL10.c(paramGL10.tIE, paramGL10.tIF);
        GLES20.glViewport(0, 0, paramGL10.eXo, paramGL10.eXp);
        paramGL10.HX(i);
        c.Vo();
        localObject1 = paramGL10.tIA;
        localObject2 = paramGL10.tIC;
        Object localObject3 = paramGL10.tID;
        if ((localObject3 != null) && (localObject2 != null))
        {
          localObject3 = Arrays.copyOf((float[])localObject3, localObject3.length);
          a.k((float[])localObject3);
          if ((((a)localObject1).tIh == null) || (((a)localObject1).tIh.capacity() < localObject3.length)) {
            ((a)localObject1).tIh = ByteBuffer.allocateDirect(localObject3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((a)localObject1).tIh.put((float[])localObject3);
          ((a)localObject1).tIh.position(0);
          localObject2 = Arrays.copyOf((float[])localObject2, localObject2.length);
          if ((((a)localObject1).tIi == null) || (((a)localObject1).tIi.capacity() < localObject2.length)) {
            ((a)localObject1).tIi = ByteBuffer.allocateDirect(localObject2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((a)localObject1).tIi.put((float[])localObject2);
          ((a)localObject1).tIi.position(0);
        }
        paramGL10 = paramGL10.tIA;
        if ((paramGL10.tIe <= 0) || (paramGL10.tIm <= 0) || (paramGL10.tIn <= 0)) {
          paramGL10.gq(paramGL10.eXo, paramGL10.eXp);
        }
        a.r(paramGL10.tIe, paramGL10.tIf, paramGL10.tIm, paramGL10.tIn);
        paramGL10.a(paramGL10.tIb, paramGL10.tId, paramGL10.tIg, paramGL10.tIr, true);
        paramGL10.ng(true);
        a.r(0, 0, 0, 0);
        paramGL10.a(paramGL10.tIc, paramGL10.tIf, paramGL10.tIi, paramGL10.tIh, false);
        paramGL10.ng(false);
        c.Vo();
        c.Vo();
        this.tIX = false;
        AppMethodBeat.o(140244);
        return;
        ab.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.tIT.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        if ((this.tIR.capacity() == i) && (this.tIS.capacity() == i))
        {
          this.tIR.position(0);
          this.tIS.position(0);
          paramGL10 = this.tIK;
          localObject1 = this.y;
          localObject2 = this.tIR;
          localObject3 = this.tIS;
          i = this.mVideoWidth;
          j = this.mVideoHeight;
          paramGL10.a((ByteBuffer)localObject1, i, j, 0);
          paramGL10.a((ByteBuffer)localObject2, i / 2, j / 2, 1);
          paramGL10.a((ByteBuffer)localObject3, i / 2, j / 2, 2);
          continue;
        }
        ab.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.tIR.capacity()), Integer.valueOf(this.tIS.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        ab.e("MicroMsg.VoipRenderer", "draw error, y buffer size not match, y.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(this.y.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
        continue;
        label1065:
        if ((j & 0x8) != 0)
        {
          bool = true;
          continue;
        }
      }
      else
      {
        paramGL10.HX(i);
        continue;
        label1099:
        ab.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
        continue;
        label1110:
        if (this.tIL == null) {
          continue;
        }
        this.tIZ += 1;
        if (this.tIZ % 100 == 0) {
          ab.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", new Object[] { Integer.valueOf(this.tIM), Integer.valueOf(this.tIN), Integer.valueOf(this.tIZ) });
        }
        a(this.tIM, this.tIN, b.eZq, b.tIw);
        paramGL10 = this.tIL;
        localObject1 = paramGL10.bbI;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          paramGL10.updateTexImage();
          GLES20.glUseProgram(paramGL10.tIu);
          i = GLES20.glGetAttribLocation(paramGL10.tIu, "vPosition");
          j = GLES20.glGetAttribLocation(paramGL10.tIu, "vTexCoord");
          k = GLES20.glGetUniformLocation(paramGL10.tIu, "sTexture");
          GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, paramGL10.mVertexBuffer);
          GLES20.glEnableVertexAttribArray(i);
          GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, paramGL10.tIv);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramGL10.textureId);
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
          ab.printErrStackTrace("MicroMsg.VoipGLHProgram", paramGL10, "renderThis error", new Object[0]);
        }
        continue;
      }
      label1373:
      boolean bool = false;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140241);
    ab.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", new Object[] { Integer.valueOf(this.tIO), Integer.valueOf(this.tIP) });
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.tIK == null) {
      this.tIK = new c();
    }
    if (this.tIL == null) {
      this.tIL = new b();
    }
    this.mScreenHeight = paramInt2;
    this.mScreenWidth = paramInt1;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {
      gs(this.mVideoWidth, this.mVideoHeight);
    }
    if (this.tIK != null)
    {
      paramGL10 = this.tIK;
      ab.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramGL10.fbH), Integer.valueOf(paramGL10.fbI) });
      if ((paramInt1 != paramGL10.fbH) || (paramGL10.fbI != paramInt2))
      {
        paramGL10.fbH = paramInt1;
        paramGL10.fbI = paramInt2;
        paramGL10 = paramGL10.tIA;
        ab.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramGL10.fbH = paramInt1;
        paramGL10.fbI = paramInt2;
      }
    }
    this.tIW = true;
    ab.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight) });
    AppMethodBeat.o(140241);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(140240);
    ab.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", new Object[] { Integer.valueOf(this.tIO) });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.tIH = false;
    this.tIK = new c();
    this.tIL = new b();
    this.tIY = 0;
    this.tIZ = 0;
    AppMethodBeat.o(140240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.f
 * JD-Core Version:    0.7.0.1
 */