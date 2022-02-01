package com.tencent.wcdb.support;

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
    AppMethodBeat.i(3410);
    Log.println(this.mPriority, this.mTag, paramString);
    AppMethodBeat.o(3410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.support.LogPrinter
 * JD-Core Version:    0.7.0.1
 */