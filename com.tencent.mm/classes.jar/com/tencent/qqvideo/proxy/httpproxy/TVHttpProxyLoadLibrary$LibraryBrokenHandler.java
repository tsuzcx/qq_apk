package com.tencent.qqvideo.proxy.httpproxy;

import com.tencent.matrix.trace.core.AppMethodBeat;

class TVHttpProxyLoadLibrary$LibraryBrokenHandler
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler mParent;
  
  public TVHttpProxyLoadLibrary$LibraryBrokenHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.mParent = paramUncaughtExceptionHandler;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    int j = 1;
    AppMethodBeat.i(124391);
    int i;
    if ((!(paramThrowable instanceof UnsatisfiedLinkError)) && ((!(paramThrowable instanceof NoSuchMethodError)) || (!paramThrowable.getMessage().matches(".*sig(nature)?[=:].*"))))
    {
      i = 0;
      if (i == 0) {
        break label96;
      }
    }
    for (;;)
    {
      try
      {
        TVHttpProxyLoadLibrary.access$1(TVHttpProxyLoadLibrary.access$0());
        i = j;
        Throwable localThrowable = paramThrowable;
        if (i != 0) {
          localThrowable = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(paramThrowable);
        }
        this.mParent.uncaughtException(paramThread, localThrowable);
        AppMethodBeat.o(124391);
        return;
      }
      catch (Exception localException) {}
      i = 1;
      break;
      label96:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.LibraryBrokenHandler
 * JD-Core Version:    0.7.0.1
 */