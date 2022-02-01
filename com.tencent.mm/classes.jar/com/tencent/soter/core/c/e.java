package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  private static volatile e IuL = null;
  public String IuM = b.IuJ;
  
  public static e fna()
  {
    AppMethodBeat.i(88659);
    if (IuL == null) {
      try
      {
        if (IuL == null) {
          IuL = new e();
        }
        e locale1 = IuL;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(88659);
      }
    }
    e locale2 = IuL;
    AppMethodBeat.o(88659);
    return locale2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.e
 * JD-Core Version:    0.7.0.1
 */