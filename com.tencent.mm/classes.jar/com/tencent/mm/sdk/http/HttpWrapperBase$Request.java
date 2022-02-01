package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpWrapperBase$Request
{
  public HttpWrapperBase.Attachment attachment;
  public Map<String, String> cookie;
  public byte[] customPostData;
  public String host;
  public int method;
  public Map<String, String> params;
  public String protocal;
  public int timeout;
  public String uri;
  
  public HttpWrapperBase$Request(int paramInt, Map<String, String> paramMap1, Map<String, String> paramMap2, HttpWrapperBase.Attachment paramAttachment)
  {
    this.method = paramInt;
    this.params = paramMap1;
    this.cookie = paramMap2;
    this.attachment = paramAttachment;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(157522);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((!this.uri.startsWith("http://")) && (!this.uri.startsWith("https://"))) {
      localStringBuilder.append(this.protocal + this.host);
    }
    localStringBuilder.append(this.uri);
    if (this.params == null)
    {
      str1 = localStringBuilder.toString();
      AppMethodBeat.o(157522);
      return str1;
    }
    localStringBuilder.append('?');
    Iterator localIterator = this.params.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str3 = (String)this.params.get(str2);
      if (i != 0) {}
      for (str1 = "";; str1 = "&")
      {
        localStringBuilder.append(str1).append(URLEncoder.encode(str2, "utf-8")).append('=').append(URLEncoder.encode(Util.nullAsNil(str3), "utf-8"));
        i = 0;
        break;
      }
    }
    String str1 = localStringBuilder.toString();
    AppMethodBeat.o(157522);
    return str1;
  }
  
  public String toString()
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
      Log.printErrStackTrace("MicroMsg.HttpWrapperBase", localUnsupportedEncodingException, "", new Object[0]);
      AppMethodBeat.o(157523);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.http.HttpWrapperBase.Request
 * JD-Core Version:    0.7.0.1
 */