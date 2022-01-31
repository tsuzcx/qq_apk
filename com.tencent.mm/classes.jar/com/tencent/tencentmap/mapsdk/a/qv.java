package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class qv
  implements qr
{
  private static final String[] a = { lh.a(), "https://vectorsdk.map.qq.com", "https://tafrtt.map.qq.com", "diditaf.map.qq.com" };
  private static ea b;
  private static ed c;
  
  private static String b(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i];
        if (!str1.contains("charset")) {
          break label69;
        }
        paramString = str1.split("=");
        str1 = str2;
        if (paramString.length > 1) {
          str1 = paramString[1].trim();
        }
      }
      return str1;
      label69:
      i += 1;
    }
  }
  
  public qt a(String paramString)
  {
    return a(paramString, "QQ Map Mobile");
  }
  
  public qt a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 1);
  }
  
  public qt a(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1, paramString2, paramInt, null);
  }
  
  public qt a(String paramString1, String paramString2, int paramInt, nf paramnf)
  {
    return a(paramString1, paramString2, paramInt, null, paramnf);
  }
  
  public qt a(String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, nf paramnf)
  {
    if (c == null) {
      throw new IOException("HttpClient Init Failed and is Null");
    }
    paramString1 = c.a(paramString1, null);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.b(bool);
      paramString1.a(3000);
      paramString1.b(3000);
      paramString1.a(true);
      if (!StringUtil.isEmpty(paramString2)) {
        paramString1.a("User-Agent", paramString2);
      }
      if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
        break;
      }
      paramString2 = paramHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramHashMap = (Map.Entry)paramString2.next();
        if (paramHashMap != null) {
          paramString1.a((String)paramHashMap.getKey(), (String)paramHashMap.getValue());
        }
      }
    }
    if (paramnf != null) {
      paramnf.a(paramString1);
    }
    paramString1 = c.a(paramString1);
    if (paramString1 != null)
    {
      paramInt = paramString1.c();
      int i = paramString1.a();
      if ((i == 0) && (paramInt == 200))
      {
        paramString2 = new qt();
        paramString2.a = paramString1.d();
        paramString2.b = b(paramString1.a("Content-Type"));
        return paramString2;
      }
      paramString1 = "errorCode" + i + ", statusCode:" + paramInt + ", detailErrorInfo:" + paramString1.b();
      if (i == -4) {
        throw new qw(paramString1);
      }
      throw new IOException(paramString1);
    }
    throw new IOException("response is null");
  }
  
  public qt a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return a(paramString1, paramString2, paramArrayOfByte, 1);
  }
  
  public qt a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramString1, paramString2, paramArrayOfByte, paramInt, null);
  }
  
  public qt a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, nf paramnf)
  {
    return a(paramString1, paramString2, paramArrayOfByte, paramInt, null, paramnf);
  }
  
  public qt a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HashMap<String, String> paramHashMap, nf paramnf)
  {
    return a(paramString1, paramString2, paramArrayOfByte, paramInt, paramHashMap, paramnf, 0);
  }
  
  public qt a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, nf paramnf, int paramInt2)
  {
    boolean bool = false;
    if (c == null) {
      throw new IOException("HttpClient Init Failed and is Null");
    }
    paramString1 = c.a(paramString1, paramArrayOfByte);
    paramString1.a(false);
    if (paramInt1 > 0) {
      bool = true;
    }
    paramString1.b(bool);
    if (!StringUtil.isEmpty(paramString2)) {
      paramString1.a("User-Agent", paramString2);
    }
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      paramString2 = paramHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramArrayOfByte = (Map.Entry)paramString2.next();
        if (paramArrayOfByte != null) {
          paramString1.a((String)paramArrayOfByte.getKey(), (String)paramArrayOfByte.getValue());
        }
      }
    }
    if (paramnf != null) {
      paramnf.a(paramString1);
    }
    if (paramInt2 > 0)
    {
      paramString1.a(paramInt2);
      paramString1.b(paramInt2);
    }
    for (;;)
    {
      paramString1 = c.a(paramString1);
      if (paramString1 == null) {
        break label341;
      }
      paramInt1 = paramString1.c();
      paramInt2 = paramString1.a();
      if ((paramInt2 != 0) || (paramInt1 != 200)) {
        break;
      }
      paramString2 = new qt();
      paramString2.a = paramString1.d();
      paramString2.b = b(paramString1.a("Content-Type"));
      return paramString2;
      paramString1.a(3000);
      paramString1.b(3000);
    }
    paramString1 = "errorCode" + paramInt2 + ", statusCode:" + paramInt1 + ", detailErrorInfo:" + paramString1.b();
    if (paramInt2 == -4) {
      throw new qw(paramString1);
    }
    throw new IOException(paramString1);
    label341:
    throw new IOException("response is null");
  }
  
  public void a(Context paramContext)
  {
    try
    {
      paramContext = new ea(paramContext, 3203, lq.a, "android_vector_sdk_4.1.1.2");
      b = paramContext;
      c = dz.b(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("initNet error:").append(paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qv
 * JD-Core Version:    0.7.0.1
 */