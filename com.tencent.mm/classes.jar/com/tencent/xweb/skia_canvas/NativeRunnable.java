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
    AppMethodBeat.i(189186);
    NativeRunnable localNativeRunnable = new NativeRunnable(paramLong);
    AppMethodBeat.o(189186);
    return localNativeRunnable;
  }
  
  private native void releaseNative(long paramLong);
  
  private native void runNative(long paramLong);
  
  protected void finalize()
  {
    AppMethodBeat.i(189188);
    super.finalize();
    if (!this.mHasRun) {
      releaseNative(this.mNativePeer);
    }
    AppMethodBeat.o(189188);
  }
  
  public void run()
  {
    AppMethodBeat.i(189187);
    if (!this.mHasRun)
    {
      runNative(this.mNativePeer);
      releaseNative(this.mNativePeer);
      this.mHasRun = true;
    }
    AppMethodBeat.o(189187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.NativeRunnable
 * JD-Core Version:    0.7.0.1
 */