package com.tencent.skyline.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeHandler
  implements INativeHandler
{
  private static final String TAG = "NativeHandler";
  private static NativeHandler nativeHandler;
  private INativeHandler nativeHandlerProxy;
  
  static
  {
    AppMethodBeat.i(210716);
    nativeHandler = new NativeHandler();
    AppMethodBeat.o(210716);
  }
  
  public static void init()
  {
    AppMethodBeat.i(210705);
    instance().nativeInit();
    AppMethodBeat.o(210705);
  }
  
  public static NativeHandler instance()
  {
    return nativeHandler;
  }
  
  public void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(210736);
    if (this.nativeHandlerProxy != null) {
      this.nativeHandlerProxy.checkAndPost(paramRunnable);
    }
    AppMethodBeat.o(210736);
  }
  
  public void init(INativeHandler paramINativeHandler)
  {
    this.nativeHandlerProxy = paramINativeHandler;
  }
  
  public native void nativeInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.skyline.jni.NativeHandler
 * JD-Core Version:    0.7.0.1
 */