package com.tencent.stubs.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class NativeLogger
  implements Log.Logger
{
  private static final NativeLogger sInstance;
  
  static
  {
    AppMethodBeat.i(4040);
    sInstance = new NativeLogger();
    AppMethodBeat.o(4040);
  }
  
  private static void setLogger(long paramLong)
  {
    Log.sLoggerPtr = paramLong;
    Log.sLogger = sInstance;
  }
  
  public final native boolean isLoggable(String paramString, int paramInt);
  
  public final native void println(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.stubs.logger.NativeLogger
 * JD-Core Version:    0.7.0.1
 */