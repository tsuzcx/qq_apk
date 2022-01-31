package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  private static volatile e Bmq = null;
  public String Bmr = b.Bmo;
  
  public static e dVl()
  {
    AppMethodBeat.i(73032);
    if (Bmq == null) {
      try
      {
        if (Bmq == null) {
          Bmq = new e();
        }
        e locale1 = Bmq;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(73032);
      }
    }
    e locale2 = Bmq;
    AppMethodBeat.o(73032);
    return locale2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.core.c.e
 * JD-Core Version:    0.7.0.1
 */