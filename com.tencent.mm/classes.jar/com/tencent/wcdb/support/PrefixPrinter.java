package com.tencent.wcdb.support;

import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PrefixPrinter
  implements Printer
{
  private final String mPrefix;
  private final Printer mPrinter;
  
  private PrefixPrinter(Printer paramPrinter, String paramString)
  {
    this.mPrinter = paramPrinter;
    this.mPrefix = paramString;
  }
  
  public static Printer create(Printer paramPrinter, String paramString)
  {
    AppMethodBeat.i(12736);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(12736);
      return paramPrinter;
    }
    paramPrinter = new PrefixPrinter(paramPrinter, paramString);
    AppMethodBeat.o(12736);
    return paramPrinter;
  }
  
  public void println(String paramString)
  {
    AppMethodBeat.i(12737);
    this.mPrinter.println(this.mPrefix + paramString);
    AppMethodBeat.o(12737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.PrefixPrinter
 * JD-Core Version:    0.7.0.1
 */