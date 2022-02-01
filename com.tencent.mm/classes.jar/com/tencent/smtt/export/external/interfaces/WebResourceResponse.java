package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

public class WebResourceResponse
{
  private String mEncoding;
  private InputStream mInputStream;
  private String mMimeType;
  private String mReasonPhrase;
  private Map<String, String> mResponseHeaders;
  private int mStatusCode;
  
  public WebResourceResponse() {}
  
  public WebResourceResponse(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap, InputStream paramInputStream)
  {
    this(paramString1, paramString2, paramInputStream);
    AppMethodBeat.i(53225);
    setStatusCodeAndReasonPhrase(paramInt, paramString3);
    setResponseHeaders(paramMap);
    AppMethodBeat.o(53225);
  }
  
  public WebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream)
  {
    AppMethodBeat.i(53224);
    this.mMimeType = paramString1;
    this.mEncoding = paramString2;
    setData(paramInputStream);
    AppMethodBeat.o(53224);
  }
  
  public InputStream getData()
  {
    return this.mInputStream;
  }
  
  public String getEncoding()
  {
    return this.mEncoding;
  }
  
  public String getMimeType()
  {
    return this.mMimeType;
  }
  
  public String getReasonPhrase()
  {
    return this.mReasonPhrase;
  }
  
  public Map<String, String> getResponseHeaders()
  {
    return this.mResponseHeaders;
  }
  
  public int getStatusCode()
  {
    return this.mStatusCode;
  }
  
  public void setData(InputStream paramInputStream)
  {
    this.mInputStream = paramInputStream;
  }
  
  public void setEncoding(String paramString)
  {
    this.mEncoding = paramString;
  }
  
  public void setMimeType(String paramString)
  {
    this.mMimeType = paramString;
  }
  
  public void setResponseHeaders(Map<String, String> paramMap)
  {
    this.mResponseHeaders = paramMap;
  }
  
  public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
  {
    this.mStatusCode = paramInt;
    this.mReasonPhrase = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.WebResourceResponse
 * JD-Core Version:    0.7.0.1
 */