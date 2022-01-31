package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b$b
{
  public int dEk;
  public String host;
  public int ndK = 0;
  public Map<String, String> ndL = null;
  public Map<String, String> ndM = null;
  public String ued;
  public b.a uee = null;
  public String uri;
  
  public final String getUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((!this.uri.startsWith("http://")) && (!this.uri.startsWith("https://"))) {
      localStringBuilder.append(this.ued + this.host);
    }
    localStringBuilder.append(this.uri);
    if (this.ndL == null) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append('?');
    Iterator localIterator = this.ndL.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str3 = (String)this.ndL.get(str2);
      if (i != 0) {}
      for (String str1 = "";; str1 = "&")
      {
        localStringBuilder.append(str1).append(URLEncoder.encode(str2, "utf-8")).append('=').append(URLEncoder.encode(bk.pm(str3), "utf-8"));
        i = 0;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public final String toString()
  {
    try
    {
      String str = getUrl();
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      y.printErrStackTrace("MicroMsg.HttpWrapperBase", localUnsupportedEncodingException, "", new Object[0]);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.c.b.b
 * JD-Core Version:    0.7.0.1
 */