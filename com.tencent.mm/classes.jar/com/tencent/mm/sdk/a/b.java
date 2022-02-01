package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  public static String IbD = "unknow";
  private static c IbE = null;
  private static boolean IbF = false;
  private static boolean IbG = false;
  private static boolean IbH = false;
  private static boolean IbI = false;
  private static boolean IbJ = false;
  public static boolean foreground = false;
  
  public static void O(String paramString1, String paramString2)
  {
    if (IbE != null) {
      IbE.O(paramString1, paramString2);
    }
  }
  
  public static void P(String paramString1, String paramString2)
  {
    if (IbE != null) {
      IbE.P(paramString1, paramString2);
    }
  }
  
  public static void a(a parama)
  {
    if (IbE != null) {
      IbE.a(parama);
    }
  }
  
  public static void a(c paramc)
  {
    IbE = paramc;
  }
  
  public static void aPW(String paramString)
  {
    IbD = paramString;
  }
  
  @Deprecated
  public static void aPX(String paramString)
  {
    bu.aRx(paramString);
  }
  
  public static void b(c.a parama)
  {
    c localc = IbE;
    if (localc != null) {
      localc.a(parama);
    }
  }
  
  public static void d(int paramInt, String paramString1, String paramString2)
  {
    if (IbE != null) {
      IbE.d(paramInt, paramString1, paramString2);
    }
  }
  
  public static boolean duL()
  {
    try
    {
      boolean bool = IbJ;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean duM()
  {
    try
    {
      boolean bool = IbH;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean duN()
  {
    try
    {
      boolean bool = IbI;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void eE(boolean paramBoolean)
  {
    foreground = paramBoolean;
  }
  
  public static void fjK() {}
  
  @Deprecated
  public static boolean fjL()
  {
    return bu.fjL();
  }
  
  @Deprecated
  public static void fjM() {}
  
  @Deprecated
  public static boolean fjN()
  {
    return bu.flY();
  }
  
  @Deprecated
  public static String fjO()
  {
    return bu.flZ();
  }
  
  public static boolean fjP()
  {
    return IbF;
  }
  
  public static boolean fjQ()
  {
    return IbG;
  }
  
  public static void fm(String paramString)
  {
    if (IbE != null) {
      IbE.fm(paramString);
    }
  }
  
  public static void wA(boolean paramBoolean)
  {
    IbF = paramBoolean;
  }
  
  public static void wB(boolean paramBoolean)
  {
    IbG = paramBoolean;
  }
  
  public static void wC(boolean paramBoolean)
  {
    try
    {
      IbH = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void wD(boolean paramBoolean)
  {
    try
    {
      IbI = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void wE(boolean paramBoolean)
  {
    try
    {
      IbJ = paramBoolean;
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