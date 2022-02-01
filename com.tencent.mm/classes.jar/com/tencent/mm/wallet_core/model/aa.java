package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class aa
{
  private static boolean agTx = false;
  private static int agTy = -1;
  private static String agTz = "";
  
  public static void aGq(int paramInt)
  {
    AppMethodBeat.i(72805);
    if (!agTx)
    {
      agTx = true;
      agTy = paramInt;
      agTz = UUID.randomUUID().toString();
    }
    AppMethodBeat.o(72805);
  }
  
  public static String getBindCardUuid()
  {
    return agTz;
  }
  
  public static boolean jOO()
  {
    return agTx;
  }
  
  public static int jOP()
  {
    return agTy;
  }
  
  public static void jOQ()
  {
    agTx = false;
    agTy = -1;
    agTz = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */