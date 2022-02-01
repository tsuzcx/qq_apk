package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class z
{
  private static int LyA = -1;
  private static String LyB = "";
  private static boolean Lyz = false;
  
  public static void agm(int paramInt)
  {
    AppMethodBeat.i(72805);
    if (!Lyz)
    {
      Lyz = true;
      LyA = paramInt;
      LyB = UUID.randomUUID().toString();
    }
    AppMethodBeat.o(72805);
  }
  
  public static boolean fRx()
  {
    return Lyz;
  }
  
  public static int fRy()
  {
    return LyA;
  }
  
  public static void fRz()
  {
    Lyz = false;
    LyA = -1;
    LyB = "";
  }
  
  public static String getBindCardUuid()
  {
    return LyB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */