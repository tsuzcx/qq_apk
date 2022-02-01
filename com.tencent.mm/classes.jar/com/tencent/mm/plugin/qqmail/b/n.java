package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class n
{
  protected static String host = "";
  protected static int timeout = 0;
  protected static String uLs;
  protected static String userAgent = "weixin/android";
  
  static
  {
    uLs = "";
  }
  
  public static void akT(String paramString)
  {
    uLs = paramString;
  }
  
  protected static Map<String, String> akU(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return localHashMap;
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
  }
  
  protected static String as(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode((String)paramMap.get(str), "utf-8"));
      i += 1;
      if (paramMap.size() > i) {
        localStringBuilder.append("; ");
      }
    }
    return localStringBuilder.toString();
  }
  
  protected static String d(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((!paramString2.startsWith("http://")) && (!paramString2.startsWith("https://"))) {
      localStringBuilder.append(paramString1 + host);
    }
    localStringBuilder.append(paramString2);
    if (paramMap == null) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append('?');
    paramString2 = paramMap.keySet().iterator();
    int i = 1;
    if (paramString2.hasNext())
    {
      String str1 = (String)paramString2.next();
      String str2 = (String)paramMap.get(str1);
      if (i != 0) {}
      for (paramString1 = "";; paramString1 = "&")
      {
        localStringBuilder.append(paramString1).append(URLEncoder.encode(str1, "utf-8")).append('=').append(URLEncoder.encode(bt.nullAsNil(str2), "utf-8"));
        i = 0;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void setHost(String paramString)
  {
    ag.host = paramString;
  }
  
  public static void setUserAgent(String paramString)
  {
    ag.userAgent = paramString;
  }
  
  public abstract c a(String paramString1, String paramString2, b paramb, a parama);
  
  public abstract void cancel();
  
  public static abstract interface a
  {
    public abstract void ddV();
  }
  
  public static final class b
  {
    int uLt;
    Map<String, String> uLu;
    Map<String, String> uLv;
    n.d uLw;
    
    public b(int paramInt, Map<String, String> paramMap1, Map<String, String> paramMap2, n.d paramd)
    {
      this.uLt = paramInt;
      this.uLu = paramMap1;
      this.uLv = paramMap2;
      this.uLw = paramd;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(122692);
      StringBuilder localStringBuilder = new StringBuilder("Request method:").append(this.uLt).append(", params:");
      if (this.uLu != null)
      {
        localObject = this.uLu;
        localStringBuilder = localStringBuilder.append(localObject).append(", cookie:");
        if (this.uLv == null) {
          break label84;
        }
      }
      label84:
      for (Object localObject = this.uLv;; localObject = "")
      {
        localObject = localObject;
        AppMethodBeat.o(122692);
        return localObject;
        localObject = "";
        break;
      }
    }
  }
  
  public static final class c
  {
    String content;
    int status = 0;
    Map<String, String> uLv;
    
    public c(int paramInt, Map<String, String> paramMap, String paramString)
    {
      this.status = paramInt;
      this.uLv = paramMap;
      this.content = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(122693);
      StringBuilder localStringBuilder = new StringBuilder("Response status:").append(this.status).append(", cookie:");
      Object localObject;
      if (this.uLv != null)
      {
        localObject = this.uLv;
        localObject = localStringBuilder.append(localObject).append(", content length :");
        if (this.content == null) {
          break label87;
        }
      }
      label87:
      for (int i = this.content.length();; i = 0)
      {
        localObject = i;
        AppMethodBeat.o(122693);
        return localObject;
        localObject = "";
        break;
      }
    }
  }
  
  public static final class d
  {
    String dln;
    String filePath;
    
    public d(String paramString1, String paramString2)
    {
      this.dln = paramString1;
      this.filePath = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.n
 * JD-Core Version:    0.7.0.1
 */