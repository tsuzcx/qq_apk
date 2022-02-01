package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "Lcom/tencent/mm/plugin/voip/video/programv2/IVoIPRenderSurfaceProgram;", "renderSize", "", "(I)V", "mTextureProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipTextureRenderProgram;", "mYUVProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "drawFrame", "", "pBuff", "", "w", "h", "flag", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderMode", "transformMatrix", "", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends b
{
  public static final h.a URm;
  private j URn;
  private l URo;
  
  static
  {
    AppMethodBeat.i(293237);
    URm = new h.a((byte)0);
    AppMethodBeat.o(293237);
  }
  
  public h(int paramInt)
  {
    AppMethodBeat.i(293231);
    if (paramInt == 1)
    {
      this.URo = new l();
      this.URn = new j(true);
      AppMethodBeat.o(293231);
      return;
    }
    this.URn = new j(false);
    AppMethodBeat.o(293231);
  }
  
  public final void a(FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(293273);
    s.u(paramFloatBuffer1, "cubeBuffer");
    s.u(paramFloatBuffer2, "textureCoordBuff");
    s.u(paramArrayOfFloat, "transformMatrix");
    Object localObject;
    if (paramInt2 == 1)
    {
      localObject = this.URn;
      s.u(paramFloatBuffer1, "cubeBuffer");
      s.u(paramFloatBuffer2, "textureCoordBuff");
      s.u(paramArrayOfFloat, "transformMatrix");
      if (((j)localObject).URt)
      {
        if (paramInt1 != -1)
        {
          GLES20.glUseProgram(((j)localObject).programId);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, paramInt1);
          GLES20.glUniform1i(((j)localObject).mWx, 0);
          GLES20.glUniformMatrix4fv(((j)localObject).yob, 1, false, paramArrayOfFloat, 0);
          paramFloatBuffer1.position(0);
          GLES20.glVertexAttribPointer(((j)localObject).mWv, 2, 5126, false, 8, (Buffer)paramFloatBuffer1);
          GLES20.glEnableVertexAttribArray(((j)localObject).mWv);
          paramFloatBuffer2.position(0);
          GLES20.glVertexAttribPointer(((j)localObject).mWw, 2, 5126, false, 8, (Buffer)paramFloatBuffer2);
          GLES20.glEnableVertexAttribArray(((j)localObject).mWw);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((j)localObject).mWv);
          GLES20.glDisableVertexAttribArray(((j)localObject).mWw);
        }
        AppMethodBeat.o(293273);
        return;
      }
      if ((paramInt1 != -1) && (GLES20.glIsTexture(paramInt1)))
      {
        GLES20.glUseProgram(((j)localObject).programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, paramInt1);
        GLES20.glUniform1i(((j)localObject).mWx, 0);
        GLES20.glUniformMatrix4fv(((j)localObject).yob, 1, false, paramArrayOfFloat, 0);
        GLES20.glVertexAttribPointer(((j)localObject).mWv, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
        GLES20.glEnableVertexAttribArray(((j)localObject).mWv);
        GLES20.glVertexAttribPointer(((j)localObject).mWw, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
        GLES20.glEnableVertexAttribArray(((j)localObject).mWw);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((j)localObject).mWv);
        GLES20.glDisableVertexAttribArray(((j)localObject).mWw);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindTexture(36197, 0);
      }
      AppMethodBeat.o(293273);
      return;
    }
    paramFloatBuffer1 = this.URo;
    if (paramFloatBuffer1 != null) {
      paramFloatBuffer1.mLock.lock();
    }
    for (;;)
    {
      int i;
      int j;
      int k;
      int m;
      boolean bool;
      float f2;
      float f1;
      float f4;
      float f3;
      label790:
      label820:
      int n;
      int i1;
      try
      {
        if (paramFloatBuffer1.UMY != null)
        {
          if (paramFloatBuffer1.UMS != 0) {
            continue;
          }
          paramInt1 = paramFloatBuffer1.mHeight;
          if (paramFloatBuffer1.UMR != 0) {
            continue;
          }
          paramInt2 = paramFloatBuffer1.mWidth;
          i = paramFloatBuffer1.mWidth;
          j = paramFloatBuffer1.mHeight;
          k = paramFloatBuffer1.MEW;
          if ((i > 0) && (j > 0))
          {
            m = k >> 2 & 0x3;
            if ((k >> 4 & 0x1) != 1) {
              break label2421;
            }
            bool = true;
            if ((i != paramFloatBuffer1.mVideoWidth) || (j != paramFloatBuffer1.mVideoHeight) || (paramInt2 != paramFloatBuffer1.mScreenWidth) || (paramInt1 != paramFloatBuffer1.mScreenHeight) || (paramFloatBuffer1.RXR != m) || (paramFloatBuffer1.UQZ != bool))
            {
              paramFloatBuffer1.RXR = m;
              paramFloatBuffer1.UQZ = bool;
              Log.i("MicroMsg.VoipYUVRenderProgram", "setYUVDataSize, mAngle is %s, mMirror is %s, width is %s, height is %s, screenWidth: %s, mScreenHeight: %s, renderType:%s, mSoftDrawCnt:%d, mHardDrawCnt:%d", new Object[] { Integer.valueOf(paramFloatBuffer1.RXR), Boolean.valueOf(paramFloatBuffer1.UQZ), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramFloatBuffer1.mWk), Integer.valueOf(paramFloatBuffer1.URe), Integer.valueOf(paramFloatBuffer1.URf) });
              paramFloatBuffer1.mVideoWidth = i;
              paramFloatBuffer1.mVideoHeight = j;
              paramFloatBuffer1.mScreenWidth = paramInt2;
              paramFloatBuffer1.mScreenHeight = paramInt1;
              paramInt1 = paramFloatBuffer1.mVideoWidth;
              paramInt2 = paramFloatBuffer1.mVideoHeight;
              paramFloatBuffer2 = paramFloatBuffer1.URx;
              s.checkNotNull(paramFloatBuffer2);
              paramFloatBuffer2 = paramFloatBuffer2.UQH;
              s.s(paramFloatBuffer2, "mSProgram!!.cropCoordBuffer");
              paramArrayOfFloat = paramFloatBuffer1.URx;
              s.checkNotNull(paramArrayOfFloat);
              paramArrayOfFloat = paramArrayOfFloat.UQG;
              s.s(paramArrayOfFloat, "mSProgram!!.cropVertexBuffer");
              f2 = 0.0F;
              f1 = 0.0F;
              f4 = 0.005F + 64.0F / paramInt1 / 2.0F;
              f3 = 64.0F / paramInt2 / 2.0F + 0.005F;
              k = paramInt1 - 64;
              m = paramInt2 - 64;
              if (paramFloatBuffer1.mScreenWidth * k >= paramFloatBuffer1.mScreenHeight * m) {
                continue;
              }
              f1 = 0.5F - 1.0F * k * paramFloatBuffer1.mScreenWidth / (paramInt2 * 2.0F * paramFloatBuffer1.mScreenHeight) + 0.005F;
            }
          }
        }
      }
      catch (Exception paramFloatBuffer2)
      {
        label1187:
        return;
        f3 = f1;
        continue;
        f3 = f1;
        continue;
        f3 = 1.0F - f1;
        continue;
        f1 = 1.0F - f1;
        continue;
        paramFloatBuffer2[0] = f2;
        if (paramFloatBuffer1.UQZ)
        {
          f3 = 1.0F - f1;
          paramFloatBuffer2[1] = f3;
          paramFloatBuffer2[2] = (1.0F - f2);
          if (!paramFloatBuffer1.UQZ) {
            break label1767;
          }
          f3 = 1.0F - f1;
          paramFloatBuffer2[3] = f3;
          paramFloatBuffer2[4] = f2;
          if (!paramFloatBuffer1.UQZ) {
            break label1774;
          }
          f3 = f1;
          paramFloatBuffer2[5] = f3;
          paramFloatBuffer2[6] = (1.0F - f2);
          if (!paramFloatBuffer1.UQZ) {
            break label1783;
          }
          paramFloatBuffer2[7] = f1;
          paramArrayOfFloat[0] = 1.0F;
          paramArrayOfFloat[1] = 1.0F;
          paramArrayOfFloat[2] = 1.0F;
          paramArrayOfFloat[3] = -1.0F;
          paramArrayOfFloat[4] = -1.0F;
          paramArrayOfFloat[5] = 1.0F;
          paramArrayOfFloat[6] = -1.0F;
          paramArrayOfFloat[7] = -1.0F;
        }
      }
      finally
      {
        paramFloatBuffer1.mLock.unlock();
        AppMethodBeat.o(293273);
      }
      switch (paramFloatBuffer1.RXR)
      {
      case 2: 
        if (paramFloatBuffer1.URx != null)
        {
          localObject = paramFloatBuffer1.URx;
          s.checkNotNull(localObject);
          if ((((e)localObject).mVertexBuffer == null) || (((e)localObject).mVertexBuffer.capacity() != paramArrayOfFloat.length)) {
            ((e)localObject).mVertexBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((e)localObject).mVertexBuffer.put(paramArrayOfFloat);
          ((e)localObject).mVertexBuffer.position(0);
          if ((((e)localObject).UQw == null) || (((e)localObject).UQw.capacity() != paramFloatBuffer2.length)) {
            ((e)localObject).UQw = ByteBuffer.allocateDirect(paramFloatBuffer2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          }
          ((e)localObject).UQw.put(paramFloatBuffer2);
          ((e)localObject).UQw.position(0);
        }
        paramInt1 = i * j;
        paramInt2 = paramInt1 / 4;
        paramFloatBuffer1.UQV = ByteBuffer.allocate(paramInt2 * 2 + paramInt1);
        paramFloatBuffer1.y = ByteBuffer.allocate(paramInt1);
        paramFloatBuffer1.UQW = ByteBuffer.allocate(paramInt2);
        paramFloatBuffer1.UQX = ByteBuffer.allocate(paramInt2);
        paramFloatBuffer1.UQY = ByteBuffer.allocate(paramInt2 * 2);
        paramFloatBuffer2 = paramFloatBuffer1.UMY;
        paramFloatBuffer1.URd = false;
        if (paramFloatBuffer2 != null)
        {
          k = paramFloatBuffer1.mVideoWidth * paramFloatBuffer1.mVideoHeight * 3 / 2;
          paramFloatBuffer1.URe += 1;
          if (paramFloatBuffer1.URe % 100 == 0) {
            Log.i("MicroMsg.VoipYUVRenderProgram", "steve: remote SW yuvData videoSize:%sx%s, mSoftDrawCnt:%d", new Object[] { Integer.valueOf(paramFloatBuffer1.mVideoWidth), Integer.valueOf(paramFloatBuffer1.mVideoHeight), Integer.valueOf(paramFloatBuffer1.URe) });
          }
          if (paramFloatBuffer2.length < k) {
            break label1802;
          }
          m = paramFloatBuffer1.mVideoWidth;
          n = paramFloatBuffer1.mVideoHeight;
          if (paramFloatBuffer1.URe % 100 != 0) {
            break label1797;
          }
          if ((paramFloatBuffer2 != null) && (paramFloatBuffer2.length > m * n * 3 / 2))
          {
            paramInt1 = 0;
            paramInt2 = 0;
            i = 0;
            i1 = m * n;
            if (i1 <= 0) {
              break label2407;
            }
            break label2379;
            if (paramInt1 == 0) {
              break label1802;
            }
            paramFloatBuffer1.y.clear();
            paramFloatBuffer1.UQW.clear();
            paramFloatBuffer1.UQX.clear();
            paramFloatBuffer1.y.put(paramFloatBuffer2, 0, paramFloatBuffer1.mVideoWidth * paramFloatBuffer1.mVideoHeight);
            paramFloatBuffer1.UQW.put(paramFloatBuffer2, paramFloatBuffer1.mVideoWidth * paramFloatBuffer1.mVideoHeight, paramFloatBuffer1.mVideoWidth * paramFloatBuffer1.mVideoHeight / 4);
            paramFloatBuffer1.UQX.put(paramFloatBuffer2, paramFloatBuffer1.mVideoWidth * paramFloatBuffer1.mVideoHeight * 5 / 4, paramFloatBuffer1.mVideoWidth * paramFloatBuffer1.mVideoHeight / 4);
            paramFloatBuffer1.URd = true;
          }
        }
        else
        {
          GLES20.glViewport(0, 0, paramFloatBuffer1.mScreenWidth, paramFloatBuffer1.mScreenHeight);
          if (!paramFloatBuffer1.nDp) {
            break label1865;
          }
          Log.i("MicroMsg.VoipYUVRenderProgram", "onDrawFrame clearFrame, renderType:%s", new Object[] { Integer.valueOf(paramFloatBuffer1.mWk) });
          paramFloatBuffer1.nDp = false;
          paramFloatBuffer1.mLock.unlock();
          AppMethodBeat.o(293273);
          return;
          paramInt1 = paramFloatBuffer1.UMS;
          continue;
          paramInt2 = paramFloatBuffer1.UMR;
          continue;
          f2 = 0.5F - 1.0F * m * paramFloatBuffer1.mScreenHeight / (paramInt1 * 2.0F * paramFloatBuffer1.mScreenWidth) + 0.005F;
        }
        break;
      case 3: 
        paramFloatBuffer2[0] = f2;
        if (paramFloatBuffer1.UQZ)
        {
          f3 = 1.0F - f1;
          paramFloatBuffer2[1] = f3;
          paramFloatBuffer2[2] = (1.0F - f2);
          if (!paramFloatBuffer1.UQZ) {
            continue;
          }
          f3 = 1.0F - f1;
          paramFloatBuffer2[3] = f3;
          paramFloatBuffer2[4] = f2;
          if (!paramFloatBuffer1.UQZ) {
            continue;
          }
          f3 = f1;
          paramFloatBuffer2[5] = f3;
          paramFloatBuffer2[6] = (1.0F - f2);
          if (!paramFloatBuffer1.UQZ) {
            continue;
          }
          paramFloatBuffer2[7] = f1;
          paramArrayOfFloat[0] = -1.0F;
          paramArrayOfFloat[1] = -1.0F;
          paramArrayOfFloat[2] = -1.0F;
          paramArrayOfFloat[3] = 1.0F;
          paramArrayOfFloat[4] = 1.0F;
          paramArrayOfFloat[5] = -1.0F;
          paramArrayOfFloat[6] = 1.0F;
          paramArrayOfFloat[7] = 1.0F;
        }
        break;
      case 1: 
        f3 = f1;
        continue;
        f3 = f1;
        continue;
        f3 = 1.0F - f1;
        continue;
        f1 = 1.0F - f1;
        continue;
        paramInt1 = 0;
        continue;
        paramInt1 = 1;
        continue;
        Log.e("MicroMsg.VoipYUVRenderProgram", "remote yuvData size not match, realSize:%s, desiredSie:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(paramFloatBuffer2.length), Integer.valueOf(k), Integer.valueOf(paramFloatBuffer1.mVideoWidth), Integer.valueOf(paramFloatBuffer1.mVideoHeight) });
        paramFloatBuffer1.URd = false;
        paramFloatBuffer2 = t.UBA;
        t.hYh();
        continue;
        if (!paramFloatBuffer1.URd)
        {
          Log.i("MicroMsg.VoipYUVRenderProgram", "onDrawFrame failed cause image is unavailable");
        }
        else
        {
          if (paramFloatBuffer1.y.capacity() == paramFloatBuffer1.mVideoHeight * paramFloatBuffer1.mVideoWidth)
          {
            paramFloatBuffer1.y.position(0);
            paramInt1 = paramFloatBuffer1.mVideoHeight * paramFloatBuffer1.mVideoWidth / 4;
            if ((paramFloatBuffer1.UQW.capacity() != paramInt1) || (paramFloatBuffer1.UQX.capacity() != paramInt1)) {
              break label2210;
            }
            paramFloatBuffer1.UQW.position(0);
            paramFloatBuffer1.UQX.position(0);
            paramFloatBuffer2 = paramFloatBuffer1.URx;
            paramArrayOfFloat = paramFloatBuffer1.y;
            localObject = paramFloatBuffer1.UQW;
            ByteBuffer localByteBuffer = paramFloatBuffer1.UQX;
            paramInt1 = paramFloatBuffer1.mVideoWidth;
            paramInt2 = paramFloatBuffer1.mVideoHeight;
            paramFloatBuffer2.c(paramArrayOfFloat, paramInt1, paramInt2, 0);
            paramFloatBuffer2.c((ByteBuffer)localObject, paramInt1 / 2, paramInt2 / 2, 1);
            paramFloatBuffer2.c(localByteBuffer, paramInt1 / 2, paramInt2 / 2, 2);
          }
          try
          {
            for (;;)
            {
              paramFloatBuffer2 = paramFloatBuffer1.URx;
              GLES20.glUseProgram(paramFloatBuffer2.mProgram);
              paramFloatBuffer2.mPositionHandle = GLES20.glGetAttribLocation(paramFloatBuffer2.mProgram, "vPosition");
              GLES20.glEnableVertexAttribArray(paramFloatBuffer2.mPositionHandle);
              GLES20.glVertexAttribPointer(paramFloatBuffer2.mPositionHandle, 2, 5126, false, 8, paramFloatBuffer2.mVertexBuffer);
              paramInt1 = GLES20.glGetAttribLocation(paramFloatBuffer2.mProgram, "vTexCoord");
              GLES20.glEnableVertexAttribArray(paramInt1);
              GLES20.glVertexAttribPointer(paramInt1, 2, 5126, false, 8, paramFloatBuffer2.UQw);
              paramFloatBuffer2.UQv[0] = GLES20.glGetUniformLocation(paramFloatBuffer2.mProgram, "samplerY");
              paramFloatBuffer2.UQv[1] = GLES20.glGetUniformLocation(paramFloatBuffer2.mProgram, "samplerU");
              paramFloatBuffer2.UQv[2] = GLES20.glGetUniformLocation(paramFloatBuffer2.mProgram, "samplerV");
              paramInt1 = 0;
              while (paramInt1 < 3)
              {
                GLES20.glActiveTexture(33984 + paramInt1);
                GLES20.glBindTexture(3553, paramFloatBuffer2.UQu[paramInt1].nAF);
                GLES20.glUniform1i(paramFloatBuffer2.UQv[paramInt1], paramInt1);
                paramInt1 += 1;
              }
              Log.e("MicroMsg.VoipYUVRenderProgram", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", new Object[] { Integer.valueOf(paramFloatBuffer1.UQW.capacity()), Integer.valueOf(paramFloatBuffer1.UQX.capacity()), Integer.valueOf(paramFloatBuffer1.mVideoWidth), Integer.valueOf(paramFloatBuffer1.mVideoHeight) });
            }
            paramInt1 = GLES20.glGetUniformLocation(paramFloatBuffer2.mProgram, "yuvType");
            if (paramInt1 >= 0) {
              GLES20.glUniform1i(paramInt1, 0);
            }
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glUseProgram(0);
          }
          catch (Exception paramFloatBuffer2)
          {
            for (;;)
            {
              Log.w("MicroMsg.VoipYUVRenderProgram", paramFloatBuffer2.getMessage());
            }
          }
          paramFloatBuffer1.UMY = null;
          paramFloatBuffer1.UMZ = null;
          continue;
          AppMethodBeat.o(293273);
          return;
          i = j;
          paramInt2 = paramInt1;
          break label2379;
          if (f2 <= f4) {}
        }
        break;
      default: 
        for (;;)
        {
          label1767:
          label1774:
          label1783:
          if (f1 <= f3) {
            break label2434;
          }
          label1797:
          label1802:
          label1865:
          break label790;
          label2210:
          label2347:
          break label820;
          label2379:
          j = i + 1;
          paramInt1 = paramInt2;
          if (paramFloatBuffer2[i] == 0) {
            paramInt1 = paramInt2 + 1;
          }
          if (j < i1) {
            break label2347;
          }
          label2407:
          if (paramInt1 < m * n) {
            break label1797;
          }
          paramInt1 = 0;
          break label1187;
          label2421:
          bool = false;
          break;
          f2 = f4;
        }
        label2434:
        f1 = f3;
      }
    }
  }
  
  /* Error */
  public final void ek(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 425
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 75	com/tencent/mm/plugin/voip/video/c/h:URo	Lcom/tencent/mm/plugin/voip/video/c/l;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +68 -> 80
    //   15: aload_3
    //   16: getfield 167	com/tencent/mm/plugin/voip/video/c/l:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   19: invokevirtual 172	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   22: aload_3
    //   23: iload_1
    //   24: putfield 185	com/tencent/mm/plugin/voip/video/c/l:UMR	I
    //   27: aload_3
    //   28: iload_2
    //   29: putfield 179	com/tencent/mm/plugin/voip/video/c/l:UMS	I
    //   32: aload_3
    //   33: getfield 167	com/tencent/mm/plugin/voip/video/c/l:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   36: invokevirtual 344	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   39: ldc_w 425
    //   42: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: astore 4
    //   48: aload_3
    //   49: getfield 167	com/tencent/mm/plugin/voip/video/c/l:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   52: invokevirtual 344	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   55: ldc_w 425
    //   58: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: astore 4
    //   64: aload_3
    //   65: getfield 167	com/tencent/mm/plugin/voip/video/c/l:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   68: invokevirtual 344	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   71: ldc_w 425
    //   74: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload 4
    //   79: athrow
    //   80: ldc_w 425
    //   83: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	h
    //   0	87	1	paramInt1	int
    //   0	87	2	paramInt2	int
    //   10	55	3	locall	l
    //   46	1	4	localException	Exception
    //   62	16	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	32	46	java/lang/Exception
    //   22	32	62	finally
  }
  
  /* Error */
  public final void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 427
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 428
    //   10: invokestatic 94	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 75	com/tencent/mm/plugin/voip/video/c/h:URo	Lcom/tencent/mm/plugin/voip/video/c/l;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +99 -> 120
    //   24: aload_1
    //   25: ldc_w 428
    //   28: invokestatic 94	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   31: aload 5
    //   33: getfield 167	com/tencent/mm/plugin/voip/video/c/l:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   36: invokevirtual 172	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   39: aload 5
    //   41: getfield 176	com/tencent/mm/plugin/voip/video/c/l:UMY	[B
    //   44: ifnonnull +28 -> 72
    //   47: aload 5
    //   49: iload_2
    //   50: putfield 188	com/tencent/mm/plugin/voip/video/c/l:mWidth	I
    //   53: aload 5
    //   55: iload_3
    //   56: putfield 182	com/tencent/mm/plugin/voip/video/c/l:mHeight	I
    //   59: aload 5
    //   61: iload 4
    //   63: putfield 191	com/tencent/mm/plugin/voip/video/c/l:MEW	I
    //   66: aload 5
    //   68: aload_1
    //   69: putfield 176	com/tencent/mm/plugin/voip/video/c/l:UMY	[B
    //   72: aload 5
    //   74: getfield 167	com/tencent/mm/plugin/voip/video/c/l:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   77: invokevirtual 344	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   80: ldc_w 427
    //   83: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: astore_1
    //   88: aload 5
    //   90: getfield 167	com/tencent/mm/plugin/voip/video/c/l:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   93: invokevirtual 344	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   96: ldc_w 427
    //   99: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: return
    //   103: astore_1
    //   104: aload 5
    //   106: getfield 167	com/tencent/mm/plugin/voip/video/c/l:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   109: invokevirtual 344	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   112: ldc_w 427
    //   115: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: athrow
    //   120: ldc_w 427
    //   123: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	h
    //   0	127	1	paramArrayOfByte	byte[]
    //   0	127	2	paramInt1	int
    //   0	127	3	paramInt2	int
    //   0	127	4	paramInt3	int
    //   17	88	5	locall	l
    // Exception table:
    //   from	to	target	type
    //   39	72	87	java/lang/Exception
    //   39	72	103	finally
  }
  
  public final void release()
  {
    AppMethodBeat.i(293283);
    l locall = this.URo;
    if (locall != null) {
      locall.URx.icX();
    }
    GLES20.glDeleteProgram(this.URn.programId);
    AppMethodBeat.o(293283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.h
 * JD-Core Version:    0.7.0.1
 */