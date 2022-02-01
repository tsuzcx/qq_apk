package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

class NativeRunnable
  implements Runnable
{
  private boolean mHasRun;
  private final long mNativePeer;
  
  private NativeRunnable(long paramLong)
  {
    this.mNativePeer = paramLong;
  }
  
  static NativeRunnable Create(long paramLong)
  {
    AppMethodBeat.i(213744);
    NativeRunnable localNativeRunnable = new NativeRunnable(paramLong);
    AppMethodBeat.o(213744);
    return localNativeRunnable;
  }
  
  private native void releaseNative(long paramLong);
  
  private native void runNative(long paramLong);
  
  protected void finalize()
  {
    AppMethodBeat.i(213783);
    super.finalize();
    if (!this.mHasRun) {
      releaseNative(this.mNativePeer);
    }
    AppMethodBeat.o(213783);
  }
  
  public void run()
  {
    AppMethodBeat.i(213776);
    if (!this.mHasRun)
    {
      runNative(this.mNativePeer);
      releaseNative(this.mNativePeer);
      this.mHasRun = true;
    }
    AppMethodBeat.o(213776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.NativeRunnable
 * JD-Core Version:    0.7.0.1
 */