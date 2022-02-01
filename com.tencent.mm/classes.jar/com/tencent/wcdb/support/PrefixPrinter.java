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
    AppMethodBeat.i(3422);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(3422);
      return paramPrinter;
    }
    paramPrinter = new PrefixPrinter(paramPrinter, paramString);
    AppMethodBeat.o(3422);
    return paramPrinter;
  }
  
  public void println(String paramString)
  {
    AppMethodBeat.i(3423);
    this.mPrinter.println(this.mPrefix + paramString);
    AppMethodBeat.o(3423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.support.PrefixPrinter
 * JD-Core Version:    0.7.0.1
 */