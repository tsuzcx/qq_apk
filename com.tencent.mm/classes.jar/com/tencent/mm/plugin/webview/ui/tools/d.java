package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class d
{
  public static boolean bqd()
  {
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
        String str2;
        do
        {
          String str1;
          str2 = localStringBuilder.toString();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        } while (!localStringBuilder.toString().equals(ej(str2, localStringBuilder.toString())));
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    return !localStringBuilder.toString().equals(ej(str1, localStringBuilder.toString()));
    return false;
  }
  
  public static String cdC()
  {
    StringBuilder localStringBuilder = new StringBuilder(8);
    int i = 0;
    for (;;)
    {
      char c;
      if (i < 3) {
        c = (char)(int)(1045787241L >> (2 - i) * 8 & 0xFF);
      }
      try
      {
        localStringBuilder.append(c);
        i += 1;
      }
      finally {}
    }
    return ej(localStringBuilder.toString(), "");
    return ej(localStringBuilder.toString(), "");
  }
  
  private static String ej(String paramString1, String paramString2)
  {
    Object localObject;
    do
    {
      try
      {
        localObject = a.b.dHs;
        localObject = a.fJ("100460");
        if ((localObject == null) || (!((c)localObject).isValid()))
        {
          y.w("MicroMsg.WebViewHelper", "check point 1, explained by src code.");
          return paramString2;
        }
      }
      catch (Throwable paramString1)
      {
        y.printErrStackTrace("MicroMsg.WebViewHelper", paramString1, "check point 1-1, explained by src code.", new Object[0]);
        return paramString2;
      }
      localObject = ((c)localObject).ctr();
      if (localObject == null)
      {
        y.w("MicroMsg.WebViewHelper", "check point 2, explained by src code.");
        return paramString2;
      }
      localObject = (String)((Map)localObject).get(paramString1);
    } while (localObject == null);
    y.i("MicroMsg.WebViewHelper", "st, sk: %s, val:%s", new Object[] { paramString1, localObject });
    return localObject;
  }
  
  public static boolean isEnabled()
  {
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
        String str2;
        do
        {
          String str1;
          str2 = localStringBuilder.toString();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        } while (!localStringBuilder.toString().equals(ej(str2, localStringBuilder.toString())));
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((d.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    return !localStringBuilder.toString().equals(ej(str1, localStringBuilder.toString()));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */