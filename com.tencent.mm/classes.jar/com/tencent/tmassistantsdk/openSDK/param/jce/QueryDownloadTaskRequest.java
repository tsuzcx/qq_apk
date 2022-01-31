package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class QueryDownloadTaskRequest
  extends JceStruct
{
  static IPCBaseParam cache_baseParam;
  public IPCBaseParam baseParam = null;
  
  public QueryDownloadTaskRequest() {}
  
  public QueryDownloadTaskRequest(IPCBaseParam paramIPCBaseParam)
  {
    this.baseParam = paramIPCBaseParam;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76005);
    if (cache_baseParam == null) {
      cache_baseParam = new IPCBaseParam();
    }
    this.baseParam = ((IPCBaseParam)paramJceInputStream.read(cache_baseParam, 0, true));
    AppMethodBeat.o(76005);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(76004);
    paramJceOutputStream.write(this.baseParam, 0);
    AppMethodBeat.o(76004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.QueryDownloadTaskRequest
 * JD-Core Version:    0.7.0.1
 */