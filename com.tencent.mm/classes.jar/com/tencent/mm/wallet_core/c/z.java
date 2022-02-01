package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class z
{
  private static boolean LVo = false;
  private static int LVp = -1;
  private static String LVq = "";
  
  public static void agV(int paramInt)
  {
    AppMethodBeat.i(72805);
    if (!LVo)
    {
      LVo = true;
      LVp = paramInt;
      LVq = UUID.randomUUID().toString();
    }
    AppMethodBeat.o(72805);
  }
  
  public static boolean fVT()
  {
    return LVo;
  }
  
  public static int fVU()
  {
    return LVp;
  }
  
  public static void fVV()
  {
    LVo = false;
    LVp = -1;
    LVq = "";
  }
  
  public static String getBindCardUuid()
  {
    return LVq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */