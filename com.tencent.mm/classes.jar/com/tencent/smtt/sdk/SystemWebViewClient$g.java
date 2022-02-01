package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

class SystemWebViewClient$g
  extends com.tencent.smtt.export.external.interfaces.WebResourceResponse
{
  android.webkit.WebResourceResponse a;
  
  public SystemWebViewClient$g(android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    this.a = paramWebResourceResponse;
  }
  
  public InputStream getData()
  {
    AppMethodBeat.i(55361);
    InputStream localInputStream = this.a.getData();
    AppMethodBeat.o(55361);
    return localInputStream;
  }
  
  public String getEncoding()
  {
    AppMethodBeat.i(55362);
    String str = this.a.getEncoding();
    AppMethodBeat.o(55362);
    return str;
  }
  
  public String getMimeType()
  {
    AppMethodBeat.i(55363);
    String str = this.a.getMimeType();
    AppMethodBeat.o(55363);
    return str;
  }
  
  public String getReasonPhrase()
  {
    AppMethodBeat.i(55364);
    String str = this.a.getReasonPhrase();
    AppMethodBeat.o(55364);
    return str;
  }
  
  public Map<String, String> getResponseHeaders()
  {
    AppMethodBeat.i(55365);
    Map localMap = this.a.getResponseHeaders();
    AppMethodBeat.o(55365);
    return localMap;
  }
  
  public int getStatusCode()
  {
    AppMethodBeat.i(55366);
    int i = this.a.getStatusCode();
    AppMethodBeat.o(55366);
    return i;
  }
  
  public void setData(InputStream paramInputStream)
  {
    AppMethodBeat.i(55367);
    this.a.setData(paramInputStream);
    AppMethodBeat.o(55367);
  }
  
  public void setEncoding(String paramString)
  {
    AppMethodBeat.i(55368);
    this.a.setEncoding(paramString);
    AppMethodBeat.o(55368);
  }
  
  public void setMimeType(String paramString)
  {
    AppMethodBeat.i(55369);
    this.a.setMimeType(paramString);
    AppMethodBeat.o(55369);
  }
  
  public void setResponseHeaders(Map<String, String> paramMap)
  {
    AppMethodBeat.i(55370);
    this.a.setResponseHeaders(paramMap);
    AppMethodBeat.o(55370);
  }
  
  public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
  {
    AppMethodBeat.i(55371);
    this.a.setStatusCodeAndReasonPhrase(paramInt, paramString);
    AppMethodBeat.o(55371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.g
 * JD-Core Version:    0.7.0.1
 */