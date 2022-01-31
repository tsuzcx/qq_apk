package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class BatchDownloadActionResponse
  extends JceStruct
{
  static ArrayList<IPCQueryDownloadInfo> cache_batchData;
  public ArrayList<IPCQueryDownloadInfo> batchData = null;
  public int batchRequestType = 0;
  
  public BatchDownloadActionResponse() {}
  
  public BatchDownloadActionResponse(int paramInt, ArrayList<IPCQueryDownloadInfo> paramArrayList)
  {
    this.batchRequestType = paramInt;
    this.batchData = paramArrayList;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(75981);
    this.batchRequestType = paramJceInputStream.read(this.batchRequestType, 0, true);
    if (cache_batchData == null)
    {
      cache_batchData = new ArrayList();
      IPCQueryDownloadInfo localIPCQueryDownloadInfo = new IPCQueryDownloadInfo();
      cache_batchData.add(localIPCQueryDownloadInfo);
    }
    this.batchData = ((ArrayList)paramJceInputStream.read(cache_batchData, 1, false));
    AppMethodBeat.o(75981);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(75980);
    paramJceOutputStream.write(this.batchRequestType, 0);
    if (this.batchData != null) {
      paramJceOutputStream.write(this.batchData, 1);
    }
    AppMethodBeat.o(75980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionResponse
 * JD-Core Version:    0.7.0.1
 */