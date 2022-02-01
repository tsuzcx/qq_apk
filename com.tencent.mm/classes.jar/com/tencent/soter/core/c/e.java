package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  private static volatile e Zsp = null;
  public String Zsq = b.Zsn;
  
  public static e ioS()
  {
    AppMethodBeat.i(88659);
    if (Zsp == null) {
      try
      {
        if (Zsp == null) {
          Zsp = new e();
        }
        e locale1 = Zsp;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(88659);
      }
    }
    e locale2 = Zsp;
    AppMethodBeat.o(88659);
    return locale2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.c.e
 * JD-Core Version:    0.7.0.1
 */