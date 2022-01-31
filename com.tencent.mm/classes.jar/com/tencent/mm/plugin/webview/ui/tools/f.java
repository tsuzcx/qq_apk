package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class f
{
  public static String ddC()
  {
    AppMethodBeat.i(7477);
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
        localObject1 = fE(((StringBuilder)localObject1).toString(), "");
        AppMethodBeat.o(7477);
      }
    }
    localObject1 = fE(((StringBuilder)localObject1).toString(), "");
    AppMethodBeat.o(7477);
    return localObject1;
    return localObject1;
  }
  
  private static String fE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7479);
    try
    {
      localObject = a.b.eEW;
      localObject = a.me("100460");
      if ((localObject == null) || (!((c)localObject).isValid()))
      {
        ab.w("MicroMsg.WebViewHelper", "check point 1, explained by src code.");
        AppMethodBeat.o(7479);
        return paramString2;
      }
    }
    catch (Throwable paramString1)
    {
      ab.printErrStackTrace("MicroMsg.WebViewHelper", paramString1, "check point 1-1, explained by src code.", new Object[0]);
      AppMethodBeat.o(7479);
      return paramString2;
    }
    Object localObject = ((c)localObject).dvN();
    if (localObject == null)
    {
      ab.w("MicroMsg.WebViewHelper", "check point 2, explained by src code.");
      AppMethodBeat.o(7479);
      return paramString2;
    }
    localObject = (String)((Map)localObject).get(paramString1);
    if (localObject != null)
    {
      ab.i("MicroMsg.WebViewHelper", "st, sk: %s, val:%s", new Object[] { paramString1, localObject });
      AppMethodBeat.o(7479);
      return localObject;
    }
    AppMethodBeat.o(7479);
    return paramString2;
  }
  
  public static boolean isBlock()
  {
    AppMethodBeat.i(7478);
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
        localStringBuilder.append((f.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (localStringBuilder.toString().equals(fE(str2, localStringBuilder.toString()))) {
          break label178;
        }
        AppMethodBeat.o(7478);
        return true;
        AppMethodBeat.o(7478);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((f.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(fE(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(7478);
      return true;
    }
    AppMethodBeat.o(7478);
    return false;
    label178:
    return false;
  }
  
  public static boolean isEnabled()
  {
    AppMethodBeat.i(7476);
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
        localStringBuilder.append((f.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (localStringBuilder.toString().equals(fE(str2, localStringBuilder.toString()))) {
          break label178;
        }
        AppMethodBeat.o(7476);
        return true;
        AppMethodBeat.o(7476);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((f.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(fE(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(7476);
      return true;
    }
    AppMethodBeat.o(7476);
    return false;
    label178:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */