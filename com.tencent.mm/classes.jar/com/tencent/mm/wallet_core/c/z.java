package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class z
{
  private static boolean Rue = false;
  private static int Ruf = -1;
  private static String Rug = "";
  
  public static void aqh(int paramInt)
  {
    AppMethodBeat.i(72805);
    if (!Rue)
    {
      Rue = true;
      Ruf = paramInt;
      Rug = UUID.randomUUID().toString();
    }
    AppMethodBeat.o(72805);
  }
  
  public static String getBindCardUuid()
  {
    return Rug;
  }
  
  public static boolean hhq()
  {
    return Rue;
  }
  
  public static int hhr()
  {
    return Ruf;
  }
  
  public static void hhs()
  {
    Rue = false;
    Ruf = -1;
    Rug = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */