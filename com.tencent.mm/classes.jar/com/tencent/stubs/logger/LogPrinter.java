package com.tencent.stubs.logger;

import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogPrinter
  implements Printer
{
  private final int mPriority;
  private final String mTag;
  
  public LogPrinter(int paramInt, String paramString)
  {
    this.mPriority = paramInt;
    this.mTag = paramString;
  }
  
  public void println(String paramString)
  {
    AppMethodBeat.i(210405);
    Log.println(this.mPriority, this.mTag, paramString);
    AppMethodBeat.o(210405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.stubs.logger.LogPrinter
 * JD-Core Version:    0.7.0.1
 */