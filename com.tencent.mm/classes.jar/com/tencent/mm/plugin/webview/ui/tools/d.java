package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.a.b;

public final class d
{
  private static Boolean QbJ = null;
  
  private static boolean gXu()
  {
    AppMethodBeat.i(268225);
    StringBuilder localStringBuilder = new StringBuilder(8);
    try
    {
      localStringBuilder.append(b.aUn("´¼¸±µ«¿®¡£¸ ¨¦¢­§§"));
      String str1;
      return false;
    }
    finally
    {
      String str2 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (!localStringBuilder.toString().equals(mE(str2, localStringBuilder.toString())))
      {
        AppMethodBeat.o(268225);
        return true;
      }
      AppMethodBeat.o(268225);
    }
    return false;
  }
  
  public static String gXv()
  {
    AppMethodBeat.i(79675);
    Object localObject1 = new StringBuilder(8);
    try
    {
      ((StringBuilder)localObject1).append(b.aUn("±¿¥®¨¨¸«¢°´®¬¦ö"));
      return localObject1;
    }
    finally
    {
      localObject1 = mE(((StringBuilder)localObject1).toString(), "");
      AppMethodBeat.o(79675);
    }
    return localObject1;
  }
  
  public static boolean isBlock()
  {
    AppMethodBeat.i(79676);
    StringBuilder localStringBuilder = new StringBuilder(8);
    try
    {
      localStringBuilder.append(b.aUn("²¾º¯«©¹¨£­¶¥¬®¡¨"));
      String str1;
      return false;
    }
    finally
    {
      String str2 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (!localStringBuilder.toString().equals(mE(str2, localStringBuilder.toString())))
      {
        AppMethodBeat.o(79676);
        return true;
      }
      AppMethodBeat.o(79676);
    }
    return false;
  }
  
  public static boolean isEnabled()
  {
    AppMethodBeat.i(79674);
    if (QbJ == null) {
      QbJ = Boolean.valueOf(gXu());
    }
    boolean bool = QbJ.booleanValue();
    AppMethodBeat.o(79674);
    return bool;
  }
  
  private static String mE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79677);
    paramString1 = com.tencent.mm.plugin.expt.h.d.dgX().a(paramString1, paramString2, false, true);
    AppMethodBeat.o(79677);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */