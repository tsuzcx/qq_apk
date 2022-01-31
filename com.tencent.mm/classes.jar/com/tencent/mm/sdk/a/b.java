package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.bp;

public final class b
{
  public static boolean foreground = false;
  public static String ymf = "unknow";
  private static c ymg = null;
  private static boolean ymh = false;
  private static boolean ymi = false;
  
  public static void G(String paramString1, String paramString2)
  {
    if (ymg != null) {
      ymg.G(paramString1, paramString2);
    }
  }
  
  public static void a(a parama)
  {
    if (ymg != null) {
      ymg.a(parama);
    }
  }
  
  public static void a(c paramc)
  {
    ymg = paramc;
  }
  
  public static void aoO(String paramString)
  {
    ymf = paramString;
  }
  
  @Deprecated
  public static void aoP(String paramString)
  {
    bp.aqn(paramString);
  }
  
  public static void b(c.a parama)
  {
    c localc = ymg;
    if (localc != null) {
      localc.a(parama);
    }
  }
  
  public static void cP(boolean paramBoolean)
  {
    foreground = paramBoolean;
  }
  
  public static void dsc() {}
  
  @Deprecated
  public static boolean dsd()
  {
    return bp.dsd();
  }
  
  @Deprecated
  public static void dse() {}
  
  @Deprecated
  public static boolean dsf()
  {
    return bp.dud();
  }
  
  @Deprecated
  public static String dsg()
  {
    return bp.due();
  }
  
  public static boolean dsh()
  {
    return ymh;
  }
  
  public static boolean dsi()
  {
    return ymi;
  }
  
  public static void k(int paramInt, String paramString)
  {
    if (ymg != null) {
      ymg.k(paramInt, paramString);
    }
  }
  
  public static void pG(boolean paramBoolean)
  {
    ymh = paramBoolean;
  }
  
  public static void pH(boolean paramBoolean)
  {
    ymi = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */