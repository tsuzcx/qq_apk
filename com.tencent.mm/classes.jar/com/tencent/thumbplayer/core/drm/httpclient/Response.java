package com.tencent.thumbplayer.core.drm.httpclient;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Response
{
  public final IOException e;
  public final Map<String, List<String>> responseHeaders;
  public final byte[] result;
  
  private Response(IOException paramIOException)
  {
    this.result = null;
    this.responseHeaders = null;
    this.e = paramIOException;
  }
  
  private Response(byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    this.result = paramArrayOfByte;
    this.responseHeaders = paramMap;
    this.e = null;
  }
  
  public static Response error(IOException paramIOException)
  {
    AppMethodBeat.i(228317);
    paramIOException = new Response(paramIOException);
    AppMethodBeat.o(228317);
    return paramIOException;
  }
  
  public static Response success(byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(228309);
    paramArrayOfByte = new Response(paramArrayOfByte, paramMap);
    AppMethodBeat.o(228309);
    return paramArrayOfByte;
  }
  
  public boolean isSuccess()
  {
    return this.e == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Response
 * JD-Core Version:    0.7.0.1
 */