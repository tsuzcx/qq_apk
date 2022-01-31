package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

public final class s
{
  public boolean BDU = false;
  public String mEncoding;
  public InputStream mInputStream;
  public String mMimeType;
  public String mReasonPhrase;
  public Map<String, String> mResponseHeaders;
  public int mStatusCode = 200;
  
  public s(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap, InputStream paramInputStream)
  {
    this(paramString1, paramString2, paramInputStream);
    AppMethodBeat.i(3833);
    this.mStatusCode = paramInt;
    this.mReasonPhrase = paramString3;
    this.mResponseHeaders = paramMap;
    this.BDU = true;
    AppMethodBeat.o(3833);
  }
  
  public s(String paramString1, String paramString2, InputStream paramInputStream)
  {
    this.mMimeType = paramString1;
    this.mEncoding = paramString2;
    this.mInputStream = paramInputStream;
    this.BDU = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.s
 * JD-Core Version:    0.7.0.1
 */