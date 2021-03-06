package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class URIActionRequest
  extends JceStruct
{
  public String uri = "";
  
  public URIActionRequest() {}
  
  public URIActionRequest(String paramString)
  {
    this.uri = paramString;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102259);
    this.uri = paramJceInputStream.readString(0, true);
    AppMethodBeat.o(102259);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102258);
    paramJceOutputStream.write(this.uri, 0);
    AppMethodBeat.o(102258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.URIActionRequest
 * JD-Core Version:    0.7.0.1
 */