package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasApp
{
  private final long mNativePeer;
  private final IXWebWorkingHandler mWorkingHandler;
  
  static
  {
    AppMethodBeat.i(213922);
    SkiaCanvasLogic.init();
    AppMethodBeat.o(213922);
  }
  
  public SkiaCanvasApp(long paramLong1, long paramLong2, IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(213852);
    this.mWorkingHandler = paramIXWebWorkingHandler;
    if (!this.mWorkingHandler.isRunOnWorkingThread())
    {
      paramIXWebWorkingHandler = new IllegalStateException("SkiaCanvasApp must be created and used on working thread.");
      AppMethodBeat.o(213852);
      throw paramIXWebWorkingHandler;
    }
    this.mNativePeer = init(paramLong1, paramLong2);
    VSyncRenderer.initRenderer(this.mWorkingHandler);
    AppMethodBeat.o(213852);
  }
  
  private long init(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(213865);
    paramLong1 = nativeInit(paramLong1, paramLong2);
    AppMethodBeat.o(213865);
    return paramLong1;
  }
  
  public static void initConfig(SkiaCanvasApp.ConfigOptions paramConfigOptions)
  {
    AppMethodBeat.i(213876);
    if (paramConfigOptions != null) {
      setV8LockerEnable(paramConfigOptions.isV8LockerEnable());
    }
    AppMethodBeat.o(213876);
  }
  
  private native long nativeInit(long paramLong1, long paramLong2);
  
  private native void nativeOnJSContextDestroying(long paramLong);
  
  private static native void setV8LockerEnable(boolean paramBoolean);
  
  void checkAndPostOnWorkingThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(213950);
    if (this.mWorkingHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(213950);
      return;
    }
    this.mWorkingHandler.post(paramRunnable);
    AppMethodBeat.o(213950);
  }
  
  boolean isRunOnWorkingThread()
  {
    AppMethodBeat.i(213961);
    boolean bool = this.mWorkingHandler.isRunOnWorkingThread();
    AppMethodBeat.o(213961);
    return bool;
  }
  
  public void onJSContextDestroying()
  {
    AppMethodBeat.i(213937);
    if (!this.mWorkingHandler.isRunOnWorkingThread())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Thread during destroy is not matched with init.");
      AppMethodBeat.o(213937);
      throw localIllegalStateException;
    }
    nativeOnJSContextDestroying(this.mNativePeer);
    AppMethodBeat.o(213937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasApp
 * JD-Core Version:    0.7.0.1
 */