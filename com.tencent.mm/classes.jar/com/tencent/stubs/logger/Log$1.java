package com.tencent.stubs.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

class Log$1
  implements Log.Logger
{
  public boolean isLoggable(String paramString, int paramInt)
  {
    return true;
  }
  
  public void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73525);
    System.out.println("[" + paramString1 + "] " + paramString2);
    AppMethodBeat.o(73525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.stubs.logger.Log.1
 * JD-Core Version:    0.7.0.1
 */