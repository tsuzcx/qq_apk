package com.tencent.mm.wallet_core.c;

import java.util.UUID;

public final class v
{
  private static boolean wAK = false;
  private static int wAL = -1;
  private static String wAM = "";
  
  public static void IX(int paramInt)
  {
    if (!wAK)
    {
      wAK = true;
      wAL = paramInt;
      wAM = UUID.randomUUID().toString();
    }
  }
  
  public static boolean cMA()
  {
    return wAK;
  }
  
  public static int cMB()
  {
    return wAL;
  }
  
  public static String cMC()
  {
    return wAM;
  }
  
  public static void cMD()
  {
    wAK = false;
    wAL = -1;
    wAM = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */