package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class z
{
  private static boolean JFv = false;
  private static int JFw = -1;
  private static String JFx = "";
  
  public static void adM(int paramInt)
  {
    AppMethodBeat.i(72805);
    if (!JFv)
    {
      JFv = true;
      JFw = paramInt;
      JFx = UUID.randomUUID().toString();
    }
    AppMethodBeat.o(72805);
  }
  
  public static boolean fAn()
  {
    return JFv;
  }
  
  public static int fAo()
  {
    return JFw;
  }
  
  public static void fAp()
  {
    JFv = false;
    JFw = -1;
    JFx = "";
  }
  
  public static String getBindCardUuid()
  {
    return JFx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */