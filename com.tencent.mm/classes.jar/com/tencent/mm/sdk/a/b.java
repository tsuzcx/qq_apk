package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public static String GpQ = "unknow";
  private static c GpR = null;
  private static boolean GpS = false;
  private static boolean GpT = false;
  private static boolean GpU = false;
  private static boolean GpV = false;
  private static boolean GpW = false;
  public static boolean foreground = false;
  
  public static void N(String paramString1, String paramString2)
  {
    if (GpR != null) {
      GpR.N(paramString1, paramString2);
    }
  }
  
  public static void O(String paramString1, String paramString2)
  {
    if (GpR != null) {
      GpR.O(paramString1, paramString2);
    }
  }
  
  public static void a(a parama)
  {
    if (GpR != null) {
      GpR.a(parama);
    }
  }
  
  public static void a(c paramc)
  {
    GpR = paramc;
  }
  
  public static void aKq(String paramString)
  {
    GpQ = paramString;
  }
  
  @Deprecated
  public static void aKr(String paramString)
  {
    bt.aLQ(paramString);
  }
  
  public static void b(c.a parama)
  {
    c localc = GpR;
    if (localc != null) {
      localc.a(parama);
    }
  }
  
  public static void d(int paramInt, String paramString1, String paramString2)
  {
    if (GpR != null) {
      GpR.d(paramInt, paramString1, paramString2);
    }
  }
  
  public static boolean dkA()
  {
    try
    {
      boolean bool = GpU;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean dkB()
  {
    try
    {
      boolean bool = GpV;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean dkz()
  {
    try
    {
      boolean bool = GpW;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void eC(boolean paramBoolean)
  {
    foreground = paramBoolean;
  }
  
  public static void eUh() {}
  
  @Deprecated
  public static boolean eUi()
  {
    return bt.eUi();
  }
  
  @Deprecated
  public static void eUj() {}
  
  @Deprecated
  public static boolean eUk()
  {
    return bt.eWo();
  }
  
  @Deprecated
  public static String eUl()
  {
    return bt.eWp();
  }
  
  public static boolean eUm()
  {
    return GpS;
  }
  
  public static boolean eUn()
  {
    return GpT;
  }
  
  public static void er(String paramString)
  {
    if (GpR != null) {
      GpR.er(paramString);
    }
  }
  
  public static void vO(boolean paramBoolean)
  {
    GpS = paramBoolean;
  }
  
  public static void vP(boolean paramBoolean)
  {
    GpT = paramBoolean;
  }
  
  public static void vQ(boolean paramBoolean)
  {
    try
    {
      GpU = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void vR(boolean paramBoolean)
  {
    try
    {
      GpV = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void vS(boolean paramBoolean)
  {
    try
    {
      GpW = paramBoolean;
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