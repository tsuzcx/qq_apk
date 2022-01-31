package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.bk;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class n
{
  protected static String aRC;
  protected static int dEk = 0;
  protected static String host = "";
  protected static String ndJ;
  
  static
  {
    aRC = "weixin/android";
    ndJ = "";
  }
  
  protected static String H(Map<String, String> paramMap)
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
  
  public static void Lg(String paramString)
  {
    ndJ = paramString;
  }
  
  protected static Map<String, String> Lh(String paramString)
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
  
  protected static String c(String paramString1, String paramString2, Map<String, String> paramMap)
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
        localStringBuilder.append(paramString1).append(URLEncoder.encode(str1, "utf-8")).append('=').append(URLEncoder.encode(bk.pm(str2), "utf-8"));
        i = 0;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void setHost(String paramString)
  {
    af.host = paramString;
  }
  
  public static void setUserAgent(String paramString)
  {
    af.aRC = paramString;
  }
  
  public abstract c a(String paramString1, String paramString2, n.b paramb, n.a parama);
  
  public abstract void cancel();
  
  public static final class c
  {
    String content;
    Map<String, String> ndM;
    int status = 0;
    
    public c(int paramInt, Map<String, String> paramMap, String paramString)
    {
      this.status = paramInt;
      this.ndM = paramMap;
      this.content = paramString;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Response status:").append(this.status).append(", cookie:");
      Object localObject;
      if (this.ndM != null)
      {
        localObject = this.ndM;
        localObject = localStringBuilder.append(localObject).append(", content length :");
        if (this.content == null) {
          break label75;
        }
      }
      label75:
      for (int i = this.content.length();; i = 0)
      {
        return i;
        localObject = "";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.n
 * JD-Core Version:    0.7.0.1
 */