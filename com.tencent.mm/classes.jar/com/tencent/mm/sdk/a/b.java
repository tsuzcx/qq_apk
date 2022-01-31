package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.bl;

public final class b
{
  public static boolean foreground = false;
  public static String udL = "unknow";
  private static c udM = null;
  private static boolean udN = false;
  
  public static void YQ(String paramString)
  {
    udL = paramString;
  }
  
  @Deprecated
  public static void YR(String paramString)
  {
    bl.aaj(paramString);
  }
  
  public static void a(a parama)
  {
    if (udM != null) {
      udM.a(parama);
    }
  }
  
  public static void a(c paramc)
  {
    udM = paramc;
  }
  
  public static void bN(boolean paramBoolean)
  {
    foreground = paramBoolean;
  }
  
  @Deprecated
  public static boolean cqi()
  {
    return bl.cqi();
  }
  
  @Deprecated
  public static void cqj() {}
  
  @Deprecated
  public static boolean cqk()
  {
    return bl.csf();
  }
  
  @Deprecated
  public static String cql()
  {
    return bl.csg();
  }
  
  public static boolean cqm()
  {
    return udN;
  }
  
  public static void h(int paramInt, String paramString)
  {
    if (udM != null) {
      udM.h(paramInt, paramString);
    }
  }
  
  public static void mr(boolean paramBoolean)
  {
    udN = paramBoolean;
  }
  
  public static void t(String paramString1, String paramString2)
  {
    if (udM != null) {
      udM.t(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */