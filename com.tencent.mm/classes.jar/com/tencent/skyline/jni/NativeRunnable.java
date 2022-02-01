package com.tencent.skyline.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeRunnable
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
    AppMethodBeat.i(210711);
    NativeRunnable localNativeRunnable = new NativeRunnable(paramLong);
    AppMethodBeat.o(210711);
    return localNativeRunnable;
  }
  
  public static void init() {}
  
  private native void releaseNative(long paramLong);
  
  private native void runNative(long paramLong);
  
  protected void finalize()
  {
    AppMethodBeat.i(210732);
    super.finalize();
    if (!this.mHasRun) {
      releaseNative(this.mNativePeer);
    }
    AppMethodBeat.o(210732);
  }
  
  public void run()
  {
    AppMethodBeat.i(210729);
    if (!this.mHasRun)
    {
      runNative(this.mNativePeer);
      releaseNative(this.mNativePeer);
      this.mHasRun = true;
    }
    AppMethodBeat.o(210729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.skyline.jni.NativeRunnable
 * JD-Core Version:    0.7.0.1
 */