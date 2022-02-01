package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  private static volatile e ahxd = null;
  public String ahxe = b.ahxb;
  
  public static e jYf()
  {
    AppMethodBeat.i(88659);
    if (ahxd == null) {
      try
      {
        if (ahxd == null) {
          ahxd = new e();
        }
        e locale1 = ahxd;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(88659);
      }
    }
    e locale2 = ahxd;
    AppMethodBeat.o(88659);
    return locale2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.core.c.e
 * JD-Core Version:    0.7.0.1
 */