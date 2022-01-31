package com.tencent.ttpic.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WindowSurface
  extends EglSurfaceBase
{
  private boolean mReleaseSurface;
  private Surface mSurface;
  
  public WindowSurface(EglCore paramEglCore, SurfaceTexture paramSurfaceTexture)
  {
    super(paramEglCore);
    AppMethodBeat.i(50054);
    createWindowSurface(paramSurfaceTexture);
    AppMethodBeat.o(50054);
  }
  
  public WindowSurface(EglCore paramEglCore, Surface paramSurface, boolean paramBoolean)
  {
    super(paramEglCore);
    AppMethodBeat.i(50053);
    createWindowSurface(paramSurface);
    this.mSurface = paramSurface;
    this.mReleaseSurface = paramBoolean;
    AppMethodBeat.o(50053);
  }
  
  public void recreate(EglCore paramEglCore)
  {
    AppMethodBeat.i(50056);
    if (this.mSurface == null)
    {
      paramEglCore = new RuntimeException("not yet implemented for SurfaceTexture");
      AppMethodBeat.o(50056);
      throw paramEglCore;
    }
    this.mEglCore = paramEglCore;
    createWindowSurface(this.mSurface);
    AppMethodBeat.o(50056);
  }
  
  public void release()
  {
    AppMethodBeat.i(50055);
    releaseEglSurface();
    if (this.mSurface != null)
    {
      if (this.mReleaseSurface) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    AppMethodBeat.o(50055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.gles.WindowSurface
 * JD-Core Version:    0.7.0.1
 */