package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasApp
{
  private final long mNativePeer;
  private final IXWebWorkingHandler mWorkingHandler;
  
  static
  {
    AppMethodBeat.i(196699);
    SkiaCanvasLogic.init();
    AppMethodBeat.o(196699);
  }
  
  public SkiaCanvasApp(long paramLong1, long paramLong2, IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(196690);
    this.mWorkingHandler = paramIXWebWorkingHandler;
    if (!this.mWorkingHandler.isRunOnWorkingThread())
    {
      paramIXWebWorkingHandler = new IllegalStateException("SkiaCanvasApp must be created and used on working thread.");
      AppMethodBeat.o(196690);
      throw paramIXWebWorkingHandler;
    }
    this.mNativePeer = init(paramLong1, paramLong2);
    VSyncRenderer.initRenderer(this.mWorkingHandler);
    AppMethodBeat.o(196690);
  }
  
  private long init(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(196692);
    paramLong1 = nativeInit(paramLong1, paramLong2);
    AppMethodBeat.o(196692);
    return paramLong1;
  }
  
  private native long nativeInit(long paramLong1, long paramLong2);
  
  private native void nativeOnJSContextDestroying(long paramLong);
  
  void checkAndPostOnWorkingThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(196696);
    if (this.mWorkingHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(196696);
      return;
    }
    this.mWorkingHandler.post(paramRunnable);
    AppMethodBeat.o(196696);
  }
  
  boolean isRunOnWorkingThread()
  {
    AppMethodBeat.i(196697);
    boolean bool = this.mWorkingHandler.isRunOnWorkingThread();
    AppMethodBeat.o(196697);
    return bool;
  }
  
  public void onJSContextDestroying()
  {
    AppMethodBeat.i(196695);
    if (!this.mWorkingHandler.isRunOnWorkingThread())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Thread during destroy is not matched with init.");
      AppMethodBeat.o(196695);
      throw localIllegalStateException;
    }
    nativeOnJSContextDestroying(this.mNativePeer);
    AppMethodBeat.o(196695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasApp
 * JD-Core Version:    0.7.0.1
 */