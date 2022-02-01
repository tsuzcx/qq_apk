package com.tencent.mm.plugin.qqmail;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class c
{
  public static String USER_AGENT;
  protected static String host = "";
  protected static int timeout = 0;
  protected static String xqD;
  
  static
  {
    USER_AGENT = "weixin/android";
    xqD = "";
  }
  
  public static String aG(Map<String, String> paramMap)
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
  
  public static Map<String, String> awj(String paramString)
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
  
  public static String f(String paramString1, String paramString2, Map<String, String> paramMap)
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
        localStringBuilder.append(paramString1).append(URLEncoder.encode(str1, "utf-8")).append('=').append(URLEncoder.encode(bu.nullAsNil(str2), "utf-8"));
        i = 0;
        break;
      }
    }
    return localStringBuilder.toString();
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
    public boolean xqE = false;
    public boolean xqF = true;
    public boolean xqG = true;
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(217911);
      this.xqE = paramBundle.getBoolean("qqmail_httpoptions_expired");
      this.xqF = paramBundle.getBoolean("qqmail_httpoptions_needcache");
      this.xqG = paramBundle.getBoolean("qqmail_httpoptions_needparse");
      AppMethodBeat.o(217911);
    }
  }
  
  public static final class c
  {
    public long id;
    public String uri;
    public c.b xqH;
    public c.e xqI;
    public c.f xqJ;
    public Map<String, String> xqK;
    public c.a xqL;
    
    public c(String paramString, c.e parame, c.a parama)
    {
      AppMethodBeat.i(217912);
      this.id = System.currentTimeMillis();
      this.uri = paramString;
      this.xqI = parame;
      this.xqL = parama;
      AppMethodBeat.o(217912);
    }
  }
  
  public static abstract interface d
  {
    public abstract void dFu();
  }
  
  public static final class e
  {
    public int xqM;
    public Map<String, String> xqN;
    public Map<String, String> xqO;
    public c.g xqP;
    
    public e(int paramInt, Map<String, String> paramMap1, Map<String, String> paramMap2)
    {
      this.xqM = paramInt;
      this.xqN = paramMap1;
      this.xqO = paramMap2;
      this.xqP = null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(217913);
      StringBuilder localStringBuilder = new StringBuilder("Request method:").append(this.xqM).append(", params:");
      if (this.xqN != null)
      {
        localObject = this.xqN;
        localStringBuilder = localStringBuilder.append(localObject).append(", cookie:");
        if (this.xqO == null) {
          break label84;
        }
      }
      label84:
      for (Object localObject = this.xqO;; localObject = "")
      {
        localObject = localObject;
        AppMethodBeat.o(217913);
        return localObject;
        localObject = "";
        break;
      }
    }
  }
  
  public static final class f
  {
    public String content;
    public int status = 0;
    public Map<String, String> xqO;
    
    public f(int paramInt, Map<String, String> paramMap, String paramString)
    {
      this.status = paramInt;
      this.xqO = paramMap;
      this.content = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(217914);
      StringBuilder localStringBuilder = new StringBuilder("Response status:").append(this.status).append(", cookie:");
      Object localObject;
      if (this.xqO != null)
      {
        localObject = this.xqO;
        localObject = localStringBuilder.append(localObject).append(", content length :");
        if (this.content == null) {
          break label87;
        }
      }
      label87:
      for (int i = this.content.length();; i = 0)
      {
        localObject = i;
        AppMethodBeat.o(217914);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c
 * JD-Core Version:    0.7.0.1
 */