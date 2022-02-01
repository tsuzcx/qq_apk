package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

public class WebResourceResponse
{
  public boolean aaaT = false;
  public String mEncoding;
  public InputStream mInputStream;
  public String mMimeType;
  public String mReasonPhrase;
  public Map<String, String> mResponseHeaders;
  public int mStatusCode = 200;
  
  public WebResourceResponse(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap, InputStream paramInputStream)
  {
    this(paramString1, paramString2, paramInputStream);
    AppMethodBeat.i(156796);
    this.mStatusCode = paramInt;
    this.mReasonPhrase = paramString3;
    this.mResponseHeaders = paramMap;
    this.aaaT = true;
    AppMethodBeat.o(156796);
  }
  
  public WebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream)
  {
    this.mMimeType = paramString1;
    this.mEncoding = paramString2;
    this.mInputStream = paramInputStream;
    this.aaaT = false;
  }
  
  public final String getMimeType()
  {
    return this.mMimeType;
  }
  
  public final String getReasonPhrase()
  {
    return this.mReasonPhrase;
  }
  
  public final Map<String, String> getResponseHeaders()
  {
    return this.mResponseHeaders;
  }
  
  public final int getStatusCode()
  {
    return this.mStatusCode;
  }
  
  public final void setResponseHeaders(Map<String, String> paramMap)
  {
    this.mResponseHeaders = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.WebResourceResponse
 * JD-Core Version:    0.7.0.1
 */