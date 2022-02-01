package com.tencent.mm.plugin.qqmail;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class c
{
  protected static String BqJ = "";
  public static String USER_AGENT;
  protected static String host = "";
  protected static int timeout = 0;
  
  static
  {
    USER_AGENT = "weixin/android";
  }
  
  public static String d(String paramString1, String paramString2, Map<String, String> paramMap)
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
        localStringBuilder.append(paramString1).append(URLEncoder.encode(str1, "utf-8")).append('=').append(URLEncoder.encode(Util.nullAsNil(str2), "utf-8"));
        i = 0;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String getCookie(Map<String, String> paramMap)
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
  
  public static Map<String, String> parseCookie(String paramString)
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
  
  public abstract f a(String paramString1, String paramString2, e parame, d paramd);
  
  public abstract void cancel();
  
  public static abstract class a
  {
    public void onComplete() {}
    
    public abstract void onError(int paramInt, String paramString);
    
    public boolean onReady()
    {
      return true;
    }
    
    public abstract void onSuccess(String paramString, Map<String, String> paramMap);
  }
  
  public static final class b
  {
    public boolean BqK = false;
    public boolean BqL = true;
    public boolean BqM = true;
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(198565);
      this.BqK = paramBundle.getBoolean("qqmail_httpoptions_expired");
      this.BqL = paramBundle.getBoolean("qqmail_httpoptions_needcache");
      this.BqM = paramBundle.getBoolean("qqmail_httpoptions_needparse");
      AppMethodBeat.o(198565);
    }
  }
  
  public static final class c
  {
    public c.b BqN;
    public c.e BqO;
    public c.f BqP;
    public Map<String, String> BqQ;
    public c.a BqR;
    public long id;
    public String uri;
    
    public c(String paramString, c.e parame, c.a parama)
    {
      AppMethodBeat.i(198566);
      this.id = System.currentTimeMillis();
      this.uri = paramString;
      this.BqO = parame;
      this.BqR = parama;
      AppMethodBeat.o(198566);
    }
  }
  
  public static abstract interface d
  {
    public abstract void eGj();
  }
  
  public static final class e
  {
    public c.g BqS;
    public Map<String, String> cookie;
    public int method;
    public Map<String, String> params;
    
    public e(int paramInt, Map<String, String> paramMap1, Map<String, String> paramMap2)
    {
      this.method = paramInt;
      this.params = paramMap1;
      this.cookie = paramMap2;
      this.BqS = null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198567);
      StringBuilder localStringBuilder = new StringBuilder("Request method:").append(this.method).append(", params:");
      if (this.params != null)
      {
        localObject = this.params;
        localStringBuilder = localStringBuilder.append(localObject).append(", cookie:");
        if (this.cookie == null) {
          break label84;
        }
      }
      label84:
      for (Object localObject = this.cookie;; localObject = "")
      {
        localObject = localObject;
        AppMethodBeat.o(198567);
        return localObject;
        localObject = "";
        break;
      }
    }
  }
  
  public static final class f
  {
    public String content;
    public Map<String, String> cookie;
    public int status = 0;
    
    public f(int paramInt, Map<String, String> paramMap, String paramString)
    {
      this.status = paramInt;
      this.cookie = paramMap;
      this.content = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198568);
      StringBuilder localStringBuilder = new StringBuilder("Response status:").append(this.status).append(", cookie:");
      Object localObject;
      if (this.cookie != null)
      {
        localObject = this.cookie;
        localObject = localStringBuilder.append(localObject).append(", content length :");
        if (this.content == null) {
          break label87;
        }
      }
      label87:
      for (int i = this.content.length();; i = 0)
      {
        localObject = i;
        AppMethodBeat.o(198568);
        return localObject;
        localObject = "";
        break;
      }
    }
  }
  
  public static final class g
  {
    public String filePath;
    public String param;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c
 * JD-Core Version:    0.7.0.1
 */