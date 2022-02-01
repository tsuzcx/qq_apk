package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.bv;

public final class b
{
  public static String IvL = "unknow";
  private static c IvM = null;
  private static boolean IvN = false;
  private static boolean IvO = false;
  private static boolean IvP = false;
  private static boolean IvQ = false;
  private static boolean IvR = false;
  public static boolean foreground = false;
  
  public static void O(String paramString1, String paramString2)
  {
    if (IvM != null) {
      IvM.O(paramString1, paramString2);
    }
  }
  
  public static void P(String paramString1, String paramString2)
  {
    if (IvM != null) {
      IvM.P(paramString1, paramString2);
    }
  }
  
  public static void a(a parama)
  {
    if (IvM != null) {
      IvM.a(parama);
    }
  }
  
  public static void a(c paramc)
  {
    IvM = paramc;
  }
  
  public static void aRt(String paramString)
  {
    IvL = paramString;
  }
  
  @Deprecated
  public static void aRu(String paramString)
  {
    bv.aSU(paramString);
  }
  
  public static void b(c.a parama)
  {
    c localc = IvM;
    if (localc != null) {
      localc.a(parama);
    }
  }
  
  public static void d(int paramInt, String paramString1, String paramString2)
  {
    if (IvM != null) {
      IvM.d(paramInt, paramString1, paramString2);
    }
  }
  
  public static boolean dyb()
  {
    try
    {
      boolean bool = IvR;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean dyc()
  {
    try
    {
      boolean bool = IvP;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean dyd()
  {
    try
    {
      boolean bool = IvQ;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void eG(boolean paramBoolean)
  {
    foreground = paramBoolean;
  }
  
  public static void fnC() {}
  
  @Deprecated
  public static boolean fnD()
  {
    return bv.fnD();
  }
  
  @Deprecated
  public static void fnE() {}
  
  @Deprecated
  public static boolean fnF()
  {
    return bv.fpT();
  }
  
  @Deprecated
  public static String fnG()
  {
    return bv.fpU();
  }
  
  public static boolean fnH()
  {
    return IvN;
  }
  
  public static boolean fnI()
  {
    return IvO;
  }
  
  public static void fs(String paramString)
  {
    if (IvM != null) {
      IvM.fs(paramString);
    }
  }
  
  public static void wI(boolean paramBoolean)
  {
    IvN = paramBoolean;
  }
  
  public static void wJ(boolean paramBoolean)
  {
    IvO = paramBoolean;
  }
  
  public static void wK(boolean paramBoolean)
  {
    try
    {
      IvP = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void wL(boolean paramBoolean)
  {
    try
    {
      IvQ = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void wM(boolean paramBoolean)
  {
    try
    {
      IvR = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */