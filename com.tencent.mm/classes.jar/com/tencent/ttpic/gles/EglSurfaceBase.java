package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(49973);
    if (this.mEGLSurface != EGL14.EGL_NO_SURFACE)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("surface already created");
      AppMethodBeat.o(49973);
      throw localIllegalStateException;
    }
    this.mEGLSurface = this.mEglCore.createOffscreenSurface(paramInt1, paramInt2);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    AppMethodBeat.o(49973);
  }
  
  public void createWindowSurface(Object paramObject)
  {
    AppMethodBeat.i(49972);
    if (this.mEGLSurface != EGL14.EGL_NO_SURFACE)
    {
      paramObject = new IllegalStateException("surface already created");
      AppMethodBeat.o(49972);
      throw paramObject;
    }
    this.mEGLSurface = this.mEglCore.createWindowSurface(paramObject);
    AppMethodBeat.o(49972);
  }
  
  public int getHeight()
  {
    AppMethodBeat.i(49975);
    if (this.mHeight < 0)
    {
      i = this.mEglCore.querySurface(this.mEGLSurface, 12374);
      AppMethodBeat.o(49975);
      return i;
    }
    int i = this.mHeight;
    AppMethodBeat.o(49975);
    return i;
  }
  
  public int getWidth()
  {
    AppMethodBeat.i(49974);
    if (this.mWidth < 0)
    {
      i = this.mEglCore.querySurface(this.mEGLSurface, 12375);
      AppMethodBeat.o(49974);
      return i;
    }
    int i = this.mWidth;
    AppMethodBeat.o(49974);
    return i;
  }
  
  public void makeCurrent()
  {
    AppMethodBeat.i(49977);
    this.mEglCore.makeCurrent(this.mEGLSurface);
    AppMethodBeat.o(49977);
  }
  
  public void makeCurrentReadFrom(EglSurfaceBase paramEglSurfaceBase)
  {
    AppMethodBeat.i(49978);
    this.mEglCore.makeCurrent(this.mEGLSurface, paramEglSurfaceBase.mEGLSurface);
    AppMethodBeat.o(49978);
  }
  
  public void releaseEglSurface()
  {
    AppMethodBeat.i(49976);
    this.mEglCore.releaseSurface(this.mEGLSurface);
    this.mEGLSurface = EGL14.EGL_NO_SURFACE;
    this.mHeight = -1;
    this.mWidth = -1;
    AppMethodBeat.o(49976);
  }
  
  public void saveFrame(File paramFile)
  {
    AppMethodBeat.i(49981);
    if (!this.mEglCore.isCurrent(this.mEGLSurface))
    {
      paramFile = new RuntimeException("Expected EGL context/surface is not current");
      AppMethodBeat.o(49981);
      throw paramFile;
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
        break label210;
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
        AppMethodBeat.o(49981);
        return;
      }
      finally {}
      paramFile = finally;
      localBufferedOutputStream = null;
    }
    localBufferedOutputStream.close();
    label210:
    AppMethodBeat.o(49981);
    throw paramFile;
  }
  
  public void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(49980);
    this.mEglCore.setPresentationTime(this.mEGLSurface, paramLong);
    AppMethodBeat.o(49980);
  }
  
  public boolean swapBuffers()
  {
    AppMethodBeat.i(49979);
    boolean bool = this.mEglCore.swapBuffers(this.mEGLSurface);
    AppMethodBeat.o(49979);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.gles.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */