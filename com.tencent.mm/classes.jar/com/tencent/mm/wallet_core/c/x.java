package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class x
{
  private static boolean AXg = false;
  private static int AXh = -1;
  private static String AXi = "";
  
  public static void RT(int paramInt)
  {
    AppMethodBeat.i(49086);
    if (!AXg)
    {
      AXg = true;
      AXh = paramInt;
      AXi = UUID.randomUUID().toString();
    }
    AppMethodBeat.o(49086);
  }
  
  public static boolean dSp()
  {
    return AXg;
  }
  
  public static int dSq()
  {
    return AXh;
  }
  
  public static String dSr()
  {
    return AXi;
  }
  
  public static void dSs()
  {
    AXg = false;
    AXh = -1;
    AXi = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.x
 * JD-Core Version:    0.7.0.1
 */