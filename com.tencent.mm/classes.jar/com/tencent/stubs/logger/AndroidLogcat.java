package com.tencent.stubs.logger;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AndroidLogcat
  implements Log.Logger
{
  public final boolean isLoggable(String paramString, int paramInt)
  {
    AppMethodBeat.i(73496);
    boolean bool = Log.isLoggable(paramString, paramInt);
    AppMethodBeat.o(73496);
    return bool;
  }
  
  public final void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73495);
    Log.println(paramInt, paramString1, paramString2);
    AppMethodBeat.o(73495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.stubs.logger.AndroidLogcat
 * JD-Core Version:    0.7.0.1
 */