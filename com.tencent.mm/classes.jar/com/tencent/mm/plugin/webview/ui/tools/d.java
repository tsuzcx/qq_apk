package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class d
{
  public static String enE()
  {
    AppMethodBeat.i(79675);
    Object localObject1 = new StringBuilder(8);
    int i = 0;
    for (;;)
    {
      char c;
      if (i < 3) {
        c = (char)(int)(1045787241L >> (2 - i) * 8 & 0xFF);
      }
      try
      {
        ((StringBuilder)localObject1).append(c);
        i += 1;
      }
      finally
      {
        localObject1 = hL(((StringBuilder)localObject1).toString(), "");
        AppMethodBeat.o(79675);
      }
    }
    localObject1 = hL(((StringBuilder)localObject1).toString(), "");
    AppMethodBeat.o(79675);
    return localObject1;
    return localObject1;
  }
  
  private static String hL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79677);
    try
    {
      localObject = a.a.gaa;
      localObject = a.qu("100460");
      if ((localObject == null) || (!((c)localObject).isValid()))
      {
        ad.w("MicroMsg.WebViewHelper", "check point 1, explained by src code.");
        AppMethodBeat.o(79677);
        return paramString2;
      }
    }
    catch (Throwable paramString1)
    {
      ad.printErrStackTrace("MicroMsg.WebViewHelper", paramString1, "check point 1-1, explained by src code.", new Object[0]);
      AppMethodBeat.o(79677);
      return paramString2;
    }
    Object localObject = ((c)localObject).eJy();
    if (localObject == null)
    {
      ad.w("MicroMsg.WebViewHelper", "check point 2, explained by src code.");
      AppMethodBeat.o(79677);
      return paramString2;
    }
    localObject = (String)((Map)localObject).get(paramString1);
    if (localObject != null)
    {
      ad.i("MicroMsg.WebViewHelper", "st, sk: %s, val:%s", new Object[] { paramString1, localObject });
      AppMethodBeat.o(79677);
      return localObject;
    }
    AppMethodBeat.o(79677);
    return paramString2;
  }
  
  public static boolean isBlock()
  {
    AppMethodBeat.i(79676);
    StringBuilder localStringBuilder = new StringBuilder(8);
    int i = 0;
    for (;;)
    {
      char c;
      if (i < 5) {
        c = (char)(int)(222416815156331L >> (4 - i) * 8 & 0xFF);
      }
      try
      {
        localStringBuilder.append(c);
        i += 1;
      }
      finally
      {
        String str1;
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (localStringBuilder.toString().equals(hL(str2, localStringBuilder.toString()))) {
          break label174;
        }
        AppMethodBeat.o(79676);
        return true;
        AppMethodBeat.o(79676);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(hL(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(79676);
      return true;
    }
    AppMethodBeat.o(79676);
    return false;
    label174:
    return false;
  }
  
  public static boolean isEnabled()
  {
    AppMethodBeat.i(79674);
    StringBuilder localStringBuilder = new StringBuilder(8);
    int i = 0;
    for (;;)
    {
      char c;
      if (i < 4) {
        c = (char)(int)(1074974115182L >> (3 - i) * 8 & 0xFF);
      }
      try
      {
        localStringBuilder.append(c);
        i += 1;
      }
      finally
      {
        String str1;
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (localStringBuilder.toString().equals(hL(str2, localStringBuilder.toString()))) {
          break label174;
        }
        AppMethodBeat.o(79674);
        return true;
        AppMethodBeat.o(79674);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(hL(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(79674);
      return true;
    }
    AppMethodBeat.o(79674);
    return false;
    label174:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */