package com.tencent.mm.plugin.sns.ad.widget.alphavideo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public final class b
  extends f
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final float[] QeT = { -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private static final short[] QeU = { 0, 1, 2, 0, 2, 3 };
  private static final float[] QeV = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F, 0.0F, 1.0F };
  private static final float[] QeW = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private final boolean QeL;
  private final int[] QeX;
  private int QeY;
  private ShortBuffer QeZ;
  SurfaceTexture Qfa;
  private final float[] Qfb;
  private boolean Qfc;
  private final boolean Qfd;
  private long Qfe;
  long Qff;
  private int frames;
  private final Context mContext;
  private boolean mFrameAvailable;
  private FloatBuffer mVertexBuffer;
  private FloatBuffer textureBuffer;
  
  public b(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramSurfaceTexture, paramInt1, paramInt2);
    AppMethodBeat.i(310496);
    this.QeX = new int[1];
    this.mFrameAvailable = false;
    this.Qfc = false;
    this.Qfe = 0L;
    this.Qff = 0L;
    this.mContext = paramContext;
    this.Qfb = new float[16];
    this.QeL = paramBoolean1;
    this.Qfd = paramBoolean2;
    h.ahAA.bo(this);
    AppMethodBeat.o(310496);
  }
  
  private static void aWT(String paramString)
  {
    AppMethodBeat.i(310504);
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      c.e("AlphaTextureRenderer", paramString + ": glError " + GLUtils.getEGLErrorString(i));
    }
    AppMethodBeat.o(310504);
  }
  
  protected final boolean hcL()
  {
    AppMethodBeat.i(310526);
    for (;;)
    {
      try {}finally
      {
        c.e("AlphaTextureRenderer", "draw called error", localThrowable);
        continue;
        boolean bool = false;
        continue;
      }
      try
      {
        if (!this.mFrameAvailable)
        {
          if (!(this.mContext instanceof MMActivity)) {
            continue;
          }
          bool = ((MMActivity)this.mContext).isPaused();
          if ((System.currentTimeMillis() - this.Qff >= 500L) && (!bool))
          {
            c.i("AlphaTextureRenderer", "flush without input! mFrameHasAvailabled = " + this.Qfc);
            if (this.Qfc) {
              continue;
            }
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GLES20.glClear(16384);
            return true;
          }
          return false;
        }
        try
        {
          this.Qfa.updateTexImage();
          this.Qfa.getTransformMatrix(this.Qfb);
          if (this.Qfe == 0L) {
            this.Qfe = System.currentTimeMillis();
          }
          this.frames += 1;
          if (System.currentTimeMillis() - this.Qfe > 1000L)
          {
            c.d("AlphaTextureRenderer", "FPS: " + this.frames);
            this.Qfe = System.currentTimeMillis();
            this.frames = 0;
          }
          this.mFrameAvailable = false;
          aWT("gl draw texture");
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16384);
          aWT("gl draw texture");
          GLES20.glUseProgram(this.QeY);
          aWT("gl draw texture");
          int i = GLES20.glGetUniformLocation(this.QeY, "texture");
          int j = GLES20.glGetAttribLocation(this.QeY, "vTexCoordinate");
          int k = GLES20.glGetAttribLocation(this.QeY, "vPosition");
          int m = GLES20.glGetUniformLocation(this.QeY, "textureTransform");
          GLES20.glUniform2f(GLES20.glGetUniformLocation(this.QeY, "vSurfaceWidth"), this.surfaceWidth, this.surfaceHeight);
          GLES20.glEnableVertexAttribArray(k);
          GLES20.glVertexAttribPointer(k, 3, 5126, false, 0, this.mVertexBuffer);
          aWT("gl draw texture");
          GLES20.glBindTexture(36197, this.QeX[0]);
          GLES20.glActiveTexture(33984);
          GLES20.glUniform1i(i, 0);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glVertexAttribPointer(j, 4, 5126, false, 0, this.textureBuffer);
          GLES20.glUniformMatrix4fv(m, 1, false, this.Qfb, 0);
          aWT("gl draw texture");
          GLES20.glDrawElements(4, QeU.length, 5123, this.QeZ);
          aWT("gl draw texture");
          GLES20.glDisableVertexAttribArray(k);
          GLES20.glDisableVertexAttribArray(j);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(1, 771);
          aWT("gl draw texture");
          this.Qff = System.currentTimeMillis();
          AppMethodBeat.o(310526);
          return true;
        }
        catch (Exception localException)
        {
          c.e("AlphaTextureRenderer", localException);
          return false;
        }
        localThrowable = finally;
      }
      finally
      {
        AppMethodBeat.o(310526);
      }
    }
  }
  
  protected final void hcM()
  {
    AppMethodBeat.i(310539);
    Object localObject = ByteBuffer.allocateDirect(QeU.length * 2);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.QeZ = ((ByteBuffer)localObject).asShortBuffer();
    this.QeZ.put(QeU);
    this.QeZ.position(0);
    localObject = ByteBuffer.allocateDirect(QeT.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.mVertexBuffer = ((ByteBuffer)localObject).asFloatBuffer();
    this.mVertexBuffer.put(QeT);
    this.mVertexBuffer.position(0);
    if (this.QeL)
    {
      localObject = QeV;
      localObject = ByteBuffer.allocateDirect(localObject.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.textureBuffer = ((ByteBuffer)localObject).asFloatBuffer();
      FloatBuffer localFloatBuffer = this.textureBuffer;
      if (!this.QeL) {
        break label286;
      }
      localObject = QeV;
      label149:
      localFloatBuffer.put((float[])localObject);
      this.textureBuffer.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glGenTextures(1, this.QeX, 0);
      aWT("gl generate texture");
      GLES20.glBindTexture(36197, this.QeX[0]);
      aWT("gl bind texture");
      this.Qfa = new SurfaceTexture(this.QeX[0]);
      this.Qfa.setOnFrameAvailableListener(this);
      localObject = this.mContext;
      if (!this.QeL) {
        break label293;
      }
    }
    label286:
    label293:
    for (int i = b.i.montage_horizontal_vertext;; i = b.i.montage_vertical_vertext)
    {
      this.QeY = e.lQ(e.aV((Context)localObject, i), e.aV(this.mContext, b.i.montage_alpha_shader));
      c.d("AlphaTextureRenderer", "initGLComponents");
      AppMethodBeat.o(310539);
      return;
      localObject = QeW;
      break;
      localObject = QeW;
      break label149;
    }
  }
  
  protected final void hcN()
  {
    AppMethodBeat.i(310547);
    GLES20.glDeleteTextures(1, this.QeX, 0);
    GLES20.glDeleteProgram(this.QeY);
    this.Qfa.release();
    this.Qfa.setOnFrameAvailableListener(null);
    c.d("AlphaTextureRenderer", "releaseGLComponents");
    AppMethodBeat.o(310547);
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.mFrameAvailable = true;
      this.Qfc = true;
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public final void setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.alphavideo.b
 * JD-Core Version:    0.7.0.1
 */