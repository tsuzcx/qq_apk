package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class z
{
  private static boolean YVD = false;
  private static int YVE = -1;
  private static String YVF = "";
  
  public static void azF(int paramInt)
  {
    AppMethodBeat.i(72805);
    if (!YVD)
    {
      YVD = true;
      YVE = paramInt;
      YVF = UUID.randomUUID().toString();
    }
    AppMethodBeat.o(72805);
  }
  
  public static String getBindCardUuid()
  {
    return YVF;
  }
  
  public static boolean iiS()
  {
    return YVD;
  }
  
  public static int iiT()
  {
    return YVE;
  }
  
  public static void iiU()
  {
    YVD = false;
    YVE = -1;
    YVF = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */