package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@TargetApi(17)
public class EglSurfaceBase
{
  protected static final String TAG = GlUtil.TAG;
  private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
  protected EglCore mEglCore;
  private int mHeight = -1;
  private int mWidth = -1;
  
  protected EglSurfaceBase(EglCore paramEglCore)
  {
    this.mEglCore = paramEglCore;
  }
  
  public void createOffscreenSurface(int paramInt1, int paramInt2)
  {
    if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.mEGLSurface = this.mEglCore.createOffscreenSurface(paramInt1, paramInt2);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void createWindowSurface(Object paramObject)
  {
    if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.mEGLSurface = this.mEglCore.createWindowSurface(paramObject);
  }
  
  public int getHeight()
  {
    if (this.mHeight < 0) {
      return this.mEglCore.querySurface(this.mEGLSurface, 12374);
    }
    return this.mHeight;
  }
  
  public int getWidth()
  {
    if (this.mWidth < 0) {
      return this.mEglCore.querySurface(this.mEGLSurface, 12375);
    }
    return this.mWidth;
  }
  
  public void makeCurrent()
  {
    this.mEglCore.makeCurrent(this.mEGLSurface);
  }
  
  public void makeCurrentReadFrom(EglSurfaceBase paramEglSurfaceBase)
  {
    this.mEglCore.makeCurrent(this.mEGLSurface, paramEglSurfaceBase.mEGLSurface);
  }
  
  public void releaseEglSurface()
  {
    this.mEglCore.releaseSurface(this.mEGLSurface);
    this.mEGLSurface = EGL14.EGL_NO_SURFACE;
    this.mHeight = -1;
    this.mWidth = -1;
  }
  
  public void saveFrame(File paramFile)
  {
    if (!this.mEglCore.isCurrent(this.mEGLSurface)) {
      throw new RuntimeException("Expected EGL context/surface is not current");
    }
    paramFile = paramFile.toString();
    int i = getWidth();
    int j = getHeight();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(i * j * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    GLES20.glReadPixels(0, 0, i, j, 6408, 5121, localByteBuffer);
    GlUtil.checkGlError("glReadPixels");
    localByteBuffer.rewind();
    BufferedOutputStream localBufferedOutputStream;
    try
    {
      localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile));
      Bitmap localBitmap;
      if (localBufferedOutputStream == null) {
        break label193;
      }
    }
    finally
    {
      try
      {
        localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localBitmap.copyPixelsFromBuffer(localByteBuffer);
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, localBufferedOutputStream);
        localBitmap.recycle();
        localBufferedOutputStream.close();
        new StringBuilder("Saved ").append(i).append("x").append(j).append(" frame as '").append(paramFile).append("'");
        return;
      }
      finally {}
      paramFile = finally;
      localBufferedOutputStream = null;
    }
    localBufferedOutputStream.close();
    label193:
    throw paramFile;
  }
  
  public void setPresentationTime(long paramLong)
  {
    this.mEglCore.setPresentationTime(this.mEGLSurface, paramLong);
  }
  
  public boolean swapBuffers()
  {
    return this.mEglCore.swapBuffers(this.mEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.gles.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */