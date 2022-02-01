package com.tencent.mm.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class b
{
  protected final String userAgent = "weixin/android";
  
  public static Map<String, String> apT(String paramString)
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
  
  public abstract void a(b paramb, c paramc);
  
  public static final class a
  {
    public String filePath;
  }
  
  public static final class b
  {
    public String Gqk;
    public b.a Gql = null;
    public String host;
    public int timeout;
    public String uri;
    public int vUk = 0;
    public Map<String, String> vUl = null;
    public Map<String, String> vUm = null;
    
    public final String getUrl()
    {
      AppMethodBeat.i(157522);
      StringBuilder localStringBuilder = new StringBuilder();
      if ((!this.uri.startsWith("http://")) && (!this.uri.startsWith("https://"))) {
        localStringBuilder.append(this.Gqk + this.host);
      }
      localStringBuilder.append(this.uri);
      if (this.vUl == null)
      {
        str1 = localStringBuilder.toString();
        AppMethodBeat.o(157522);
        return str1;
      }
      localStringBuilder.append('?');
      Iterator localIterator = this.vUl.keySet().iterator();
      int i = 1;
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str3 = (String)this.vUl.get(str2);
        if (i != 0) {}
        for (str1 = "";; str1 = "&")
        {
          localStringBuilder.append(str1).append(URLEncoder.encode(str2, "utf-8")).append('=').append(URLEncoder.encode(bs.nullAsNil(str3), "utf-8"));
          i = 0;
          break;
        }
      }
      String str1 = localStringBuilder.toString();
      AppMethodBeat.o(157522);
      return str1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(157523);
      try
      {
        String str = getUrl();
        AppMethodBeat.o(157523);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        ac.printErrStackTrace("MicroMsg.HttpWrapperBase", localUnsupportedEncodingException, "", new Object[0]);
        AppMethodBeat.o(157523);
      }
      return "";
    }
  }
  
  public static class c
  {
    public b.a Gql;
    public String content;
    public int status = 0;
    public Map<String, String> vUm = null;
    
    public c(String paramString)
    {
      this.content = paramString;
    }
    
    public void onComplete() {}
    
    public String toString()
    {
      AppMethodBeat.i(157524);
      StringBuilder localStringBuilder = new StringBuilder("Response status:").append(this.status).append(", cookie:");
      Object localObject;
      if (this.vUm != null)
      {
        localObject = this.vUm;
        localObject = localStringBuilder.append(localObject).append(", content length :");
        if (this.content == null) {
          break label87;
        }
      }
      label87:
      for (int i = this.content.length();; i = 0)
      {
        localObject = i;
        AppMethodBeat.o(157524);
        return localObject;
        localObject = "";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */