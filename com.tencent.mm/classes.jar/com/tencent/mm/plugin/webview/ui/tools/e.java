package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.plugin.performance.a.b;

public final class e
{
  private static Boolean WST = null;
  
  public static boolean isBlock()
  {
    AppMethodBeat.i(79676);
    StringBuilder localStringBuilder = new StringBuilder(8);
    try
    {
      localStringBuilder.append(b.aRr("²¾º¯«©¹¨£­¶¥¬®¡¨"));
      String str1;
      return false;
    }
    finally
    {
      String str2 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((e.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (!localStringBuilder.toString().equals(ov(str2, localStringBuilder.toString())))
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
    if (WST == null) {
      WST = Boolean.valueOf(ixo());
    }
    boolean bool = WST.booleanValue();
    AppMethodBeat.o(79674);
    return bool;
  }
  
  private static boolean ixo()
  {
    AppMethodBeat.i(296220);
    StringBuilder localStringBuilder = new StringBuilder(8);
    try
    {
      localStringBuilder.append(b.aRr("´¼¸±µ«¿®¡£¸ ¨¦¢­§§"));
      String str1;
      return false;
    }
    finally
    {
      String str2 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((e.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (!localStringBuilder.toString().equals(ov(str2, localStringBuilder.toString())))
      {
        AppMethodBeat.o(296220);
        return true;
      }
      AppMethodBeat.o(296220);
    }
    return false;
  }
  
  public static String ixp()
  {
    AppMethodBeat.i(79675);
    Object localObject1 = new StringBuilder(8);
    try
    {
      ((StringBuilder)localObject1).append(b.aRr("±¿¥®¨¨¸«¢°´®¬¦ö"));
      return localObject1;
    }
    finally
    {
      localObject1 = ov(((StringBuilder)localObject1).toString(), "");
      AppMethodBeat.o(79675);
    }
    return localObject1;
  }
  
  private static String ov(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79677);
    paramString1 = d.dNI().a(paramString1, paramString2, false, true);
    AppMethodBeat.o(79677);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */