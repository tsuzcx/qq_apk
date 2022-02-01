package com.tencent.mm.sdk.thread;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class DeprecatedThreadFactory
{
  private static final String TAG = "[D]";
  
  @Deprecated
  public static HandlerThread createHandlerThread(String paramString)
  {
    AppMethodBeat.i(182972);
    paramString = new HandlerThread("[D]#".concat(String.valueOf(paramString)));
    paramString.start();
    AppMethodBeat.o(182972);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.thread.DeprecatedThreadFactory
 * JD-Core Version:    0.7.0.1
 */