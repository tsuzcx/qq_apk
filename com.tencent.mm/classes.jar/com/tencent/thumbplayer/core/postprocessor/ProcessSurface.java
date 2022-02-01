package com.tencent.thumbplayer.core.postprocessor;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProcessSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final String TAG = "sifeng: ProcessSurface";
  private boolean mFrameAvailable;
  private Object mFrameSyncObject;
  private int mHeight;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private SharpenFilterGroup mTextureRender;
  private int mWidth;
  
  public ProcessSurface(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(227393);
    this.mFrameSyncObject = new Object();
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    setup(paramString);
    AppMethodBeat.o(227393);
  }
  
  private void setup(String paramString)
  {
    AppMethodBeat.i(227402);
    this.mTextureRender = new SharpenFilterGroup(paramString);
    this.mTextureRender.genOESTexture();
    this.mTextureRender.checkGlError("Render surface create");
    this.mSurfaceTexture = new SurfaceTexture(this.mTextureRender.getOESTextureid());
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mSurface = new Surface(this.mSurfaceTexture);
    AppMethodBeat.o(227402);
  }
  
  public void awaitNewImage()
  {
    AppMethodBeat.i(227427);
    synchronized (this.mFrameSyncObject)
    {
      for (;;)
      {
        boolean bool = this.mFrameAvailable;
        if (bool) {
          break;
        }
        try
        {
          this.mFrameSyncObject.wait(16L);
          if (!this.mFrameAvailable)
          {
            RuntimeException localRuntimeException = new RuntimeException("sifeng: Surface frame wait timed out");
            AppMethodBeat.o(227427);
            throw localRuntimeException;
          }
        }
        catch (InterruptedException localInterruptedException) {}
      }
      this.mFrameAvailable = false;
      this.mTextureRender.checkGlError("before updateTexImage");
      this.mSurfaceTexture.updateTexImage();
      AppMethodBeat.o(227427);
      return;
    }
  }
  
  public void drawImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    AppMethodBeat.i(227437);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mTextureRender.process(this.mSurfaceTexture, this.mWidth, this.mHeight, paramInt3, paramInt4, paramBoolean, paramInt5);
    AppMethodBeat.o(227437);
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    AppMethodBeat.i(227445);
    synchronized (this.mFrameSyncObject)
    {
      if (this.mFrameAvailable)
      {
        RuntimeException localRuntimeException = new RuntimeException("mFrameAvailable already set, frame could be dropped");
        AppMethodBeat.o(227445);
        throw localRuntimeException;
      }
    }
    this.mFrameAvailable = true;
    this.mFrameSyncObject.notifyAll();
    AppMethodBeat.o(227445);
  }
  
  public void release()
  {
    AppMethodBeat.i(227413);
    this.mTextureRender.destroyBuffers();
    this.mTextureRender = null;
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    AppMethodBeat.o(227413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.postprocessor.ProcessSurface
 * JD-Core Version:    0.7.0.1
 */