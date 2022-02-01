package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasApp
{
  private final long mNativePeer;
  private final IXWebWorkingHandler mWorkingHandler;
  
  static
  {
    AppMethodBeat.i(218226);
    SkiaCanvasLogic.init();
    AppMethodBeat.o(218226);
  }
  
  public SkiaCanvasApp(long paramLong1, long paramLong2, IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(218221);
    this.mWorkingHandler = paramIXWebWorkingHandler;
    if (!this.mWorkingHandler.isRunOnWorkingThread())
    {
      paramIXWebWorkingHandler = new IllegalStateException("SkiaCanvasApp must be created and used on working thread.");
      AppMethodBeat.o(218221);
      throw paramIXWebWorkingHandler;
    }
    this.mNativePeer = init(paramLong1, paramLong2);
    VSyncRenderer.initRenderer(this.mWorkingHandler);
    AppMethodBeat.o(218221);
  }
  
  private long init(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(218222);
    paramLong1 = nativeInit(paramLong1, paramLong2);
    AppMethodBeat.o(218222);
    return paramLong1;
  }
  
  private native long nativeInit(long paramLong1, long paramLong2);
  
  private native void nativeOnJSContextDestroying(long paramLong);
  
  void checkAndPostOnWorkingThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(218224);
    if (this.mWorkingHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(218224);
      return;
    }
    this.mWorkingHandler.post(paramRunnable);
    AppMethodBeat.o(218224);
  }
  
  boolean isRunOnWorkingThread()
  {
    AppMethodBeat.i(218225);
    boolean bool = this.mWorkingHandler.isRunOnWorkingThread();
    AppMethodBeat.o(218225);
    return bool;
  }
  
  public void onJSContextDestroying()
  {
    AppMethodBeat.i(218223);
    if (!this.mWorkingHandler.isRunOnWorkingThread())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Thread during destroy is not matched with init.");
      AppMethodBeat.o(218223);
      throw localIllegalStateException;
    }
    nativeOnJSContextDestroying(this.mNativePeer);
    AppMethodBeat.o(218223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasApp
 * JD-Core Version:    0.7.0.1
 */