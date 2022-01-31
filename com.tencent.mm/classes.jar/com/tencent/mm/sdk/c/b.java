package com.tencent.mm.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class b
{
  protected final String userAgent = "weixin/android";
  
  public static Map<String, String> Xr(String paramString)
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
  
  public abstract void a(b paramb, b.c paramc);
  
  public final void a(b paramb, b.c paramc, ak paramak)
  {
    d.post(new b.1(this, paramb, paramc, paramak), getClass().getName());
  }
  
  public static final class b
  {
    public int eBM;
    public String host;
    public int pJa = 0;
    public Map<String, String> pJb = null;
    public Map<String, String> pJc = null;
    public String uri;
    public String ymw;
    public b.a ymx = null;
    
    public final String getUrl()
    {
      AppMethodBeat.i(51969);
      StringBuilder localStringBuilder = new StringBuilder();
      if ((!this.uri.startsWith("http://")) && (!this.uri.startsWith("https://"))) {
        localStringBuilder.append(this.ymw + this.host);
      }
      localStringBuilder.append(this.uri);
      if (this.pJb == null)
      {
        str1 = localStringBuilder.toString();
        AppMethodBeat.o(51969);
        return str1;
      }
      localStringBuilder.append('?');
      Iterator localIterator = this.pJb.keySet().iterator();
      int i = 1;
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str3 = (String)this.pJb.get(str2);
        if (i != 0) {}
        for (str1 = "";; str1 = "&")
        {
          localStringBuilder.append(str1).append(URLEncoder.encode(str2, "utf-8")).append('=').append(URLEncoder.encode(bo.nullAsNil(str3), "utf-8"));
          i = 0;
          break;
        }
      }
      String str1 = localStringBuilder.toString();
      AppMethodBeat.o(51969);
      return str1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51970);
      try
      {
        String str = getUrl();
        AppMethodBeat.o(51970);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        ab.printErrStackTrace("MicroMsg.HttpWrapperBase", localUnsupportedEncodingException, "", new Object[0]);
        AppMethodBeat.o(51970);
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */