package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  public static String ESD = "unknow";
  private static c ESE = null;
  private static boolean ESF = false;
  private static boolean ESG = false;
  private static boolean ESH = false;
  private static boolean ESI = false;
  private static boolean ESJ = false;
  public static boolean foreground = false;
  
  public static void M(String paramString1, String paramString2)
  {
    if (ESE != null) {
      ESE.M(paramString1, paramString2);
    }
  }
  
  public static void N(String paramString1, String paramString2)
  {
    if (ESE != null) {
      ESE.N(paramString1, paramString2);
    }
  }
  
  public static void a(a parama)
  {
    if (ESE != null) {
      ESE.a(parama);
    }
  }
  
  public static void a(c paramc)
  {
    ESE = paramc;
  }
  
  public static void aEZ(String paramString)
  {
    ESD = paramString;
  }
  
  @Deprecated
  public static void aFa(String paramString)
  {
    bu.aGz(paramString);
  }
  
  public static void b(c.a parama)
  {
    c localc = ESE;
    if (localc != null) {
      localc.a(parama);
    }
  }
  
  public static boolean cWR()
  {
    try
    {
      boolean bool = ESJ;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean cWS()
  {
    try
    {
      boolean bool = ESH;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean cWT()
  {
    try
    {
      boolean bool = ESI;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void d(int paramInt, String paramString1, String paramString2)
  {
    if (ESE != null) {
      ESE.d(paramInt, paramString1, paramString2);
    }
  }
  
  public static void eEN() {}
  
  @Deprecated
  public static boolean eEO()
  {
    return bu.eEO();
  }
  
  @Deprecated
  public static void eEP() {}
  
  @Deprecated
  public static boolean eEQ()
  {
    return bu.eGT();
  }
  
  @Deprecated
  public static String eER()
  {
    return bu.eGU();
  }
  
  public static boolean eES()
  {
    return ESF;
  }
  
  public static boolean eET()
  {
    return ESG;
  }
  
  public static void eh(boolean paramBoolean)
  {
    foreground = paramBoolean;
  }
  
  public static void uM(boolean paramBoolean)
  {
    ESF = paramBoolean;
  }
  
  public static void uN(boolean paramBoolean)
  {
    ESG = paramBoolean;
  }
  
  public static void uO(boolean paramBoolean)
  {
    try
    {
      ESH = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void uP(boolean paramBoolean)
  {
    try
    {
      ESI = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void uQ(boolean paramBoolean)
  {
    try
    {
      ESJ = paramBoolean;
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