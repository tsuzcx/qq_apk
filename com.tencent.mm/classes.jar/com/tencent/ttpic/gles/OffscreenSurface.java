package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OffscreenSurface
  extends EglSurfaceBase
{
  public OffscreenSurface(EglCore paramEglCore, int paramInt1, int paramInt2)
  {
    super(paramEglCore);
    AppMethodBeat.i(50019);
    createOffscreenSurface(paramInt1, paramInt2);
    AppMethodBeat.o(50019);
  }
  
  public void release()
  {
    AppMethodBeat.i(50020);
    releaseEglSurface();
    AppMethodBeat.o(50020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.gles.OffscreenSurface
 * JD-Core Version:    0.7.0.1
 */