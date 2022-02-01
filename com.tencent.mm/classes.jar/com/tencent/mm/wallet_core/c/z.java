package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class z
{
  private static boolean IdT = false;
  private static int IdU = -1;
  private static String IdV = "";
  
  public static void abt(int paramInt)
  {
    AppMethodBeat.i(72805);
    if (!IdT)
    {
      IdT = true;
      IdU = paramInt;
      IdV = UUID.randomUUID().toString();
    }
    AppMethodBeat.o(72805);
  }
  
  public static boolean fjX()
  {
    return IdT;
  }
  
  public static int fjY()
  {
    return IdU;
  }
  
  public static void fjZ()
  {
    IdT = false;
    IdU = -1;
    IdV = "";
  }
  
  public static String getBindCardUuid()
  {
    return IdV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */