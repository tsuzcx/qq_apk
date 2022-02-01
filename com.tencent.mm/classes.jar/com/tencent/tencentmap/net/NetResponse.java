package com.tencent.tencentmap.net;

import com.tencent.map.tools.net.exception.NetErrorException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetResponse
{
  public String charset;
  public byte[] data;
  public int errorCode;
  public byte[] errorData;
  public Exception exception;
  public int statusCode;
  
  public NetResponse()
  {
    this.errorCode = -1;
    this.charset = "GBK";
  }
  
  public NetResponse(com.tencent.map.tools.net.NetResponse paramNetResponse)
  {
    AppMethodBeat.i(181112);
    this.errorCode = -1;
    this.charset = "GBK";
    if (paramNetResponse != null)
    {
      this.errorCode = paramNetResponse.errorCode;
      this.statusCode = paramNetResponse.statusCode;
      this.data = paramNetResponse.data;
      this.charset = paramNetResponse.charset;
      this.exception = paramNetResponse.exception;
      this.errorData = paramNetResponse.errorData;
    }
    AppMethodBeat.o(181112);
  }
  
  public NetResponse(Exception paramException)
  {
    AppMethodBeat.i(181113);
    this.errorCode = -1;
    this.charset = "GBK";
    this.exception = paramException;
    if ((paramException instanceof NetErrorException))
    {
      this.errorCode = ((NetErrorException)paramException).errorCode;
      this.statusCode = ((NetErrorException)paramException).statusCode;
    }
    AppMethodBeat.o(181113);
  }
  
  public boolean available()
  {
    return ((this.errorCode == 0) && (this.statusCode == 200)) || ((this.data != null) && (this.data.length > 0));
  }
  
  public String toString()
  {
    AppMethodBeat.i(181114);
    try
    {
      if (this.data != null)
      {
        String str = new String(this.data, this.charset);
        AppMethodBeat.o(181114);
        return str;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(181114);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.net.NetResponse
 * JD-Core Version:    0.7.0.1
 */