package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class DownloadChunkLogInfo
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "DownloadChunkLogInfo";
  public String UUID = "";
  public String appId = "";
  public byte currentRetryCnt = 0;
  public long endTime = 0L;
  public int errorCode = 0;
  public String flag = "";
  public byte isWap = 0;
  public String networkOperator = "";
  public int networkType = 0;
  public long readHeaderTime = 0L;
  public long receiveDataSize = 0L;
  public long requestRanagePosition = 0L;
  public long requestRanageSize = 0L;
  public String requestUrl = "";
  public long responseContentLength = 0L;
  public int responseHttpCode = 0;
  public long responseRangeLength = 0L;
  public long responseRangePosition = 0L;
  public int resultState = 0;
  public long startTime = 0L;
  public byte type = 0;
  public String via = "";
  
  static
  {
    AppMethodBeat.i(102287);
    if (!DownloadChunkLogInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102287);
      return;
    }
  }
  
  public DownloadChunkLogInfo() {}
  
  public DownloadChunkLogInfo(String paramString1, byte paramByte1, String paramString2, String paramString3, int paramInt1, byte paramByte2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, long paramLong6, long paramLong7, long paramLong8, long paramLong9, int paramInt3, int paramInt4, byte paramByte3, String paramString4, String paramString5, String paramString6)
  {
    this.UUID = paramString1;
    this.type = paramByte1;
    this.requestUrl = paramString2;
    this.networkOperator = paramString3;
    this.networkType = paramInt1;
    this.isWap = paramByte2;
    this.requestRanagePosition = paramLong1;
    this.requestRanageSize = paramLong2;
    this.responseRangePosition = paramLong3;
    this.responseRangeLength = paramLong4;
    this.responseContentLength = paramLong5;
    this.responseHttpCode = paramInt2;
    this.receiveDataSize = paramLong6;
    this.startTime = paramLong7;
    this.readHeaderTime = paramLong8;
    this.endTime = paramLong9;
    this.errorCode = paramInt3;
    this.resultState = paramInt4;
    this.currentRetryCnt = paramByte3;
    this.via = paramString4;
    this.appId = paramString5;
    this.flag = paramString6;
  }
  
  public final String className()
  {
    return "jce.DownloadChunkLogInfo";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(102282);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(102282);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(102282);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102285);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.UUID, "UUID");
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.requestUrl, "requestUrl");
    paramStringBuilder.display(this.networkOperator, "networkOperator");
    paramStringBuilder.display(this.networkType, "networkType");
    paramStringBuilder.display(this.isWap, "isWap");
    paramStringBuilder.display(this.requestRanagePosition, "requestRanagePosition");
    paramStringBuilder.display(this.requestRanageSize, "requestRanageSize");
    paramStringBuilder.display(this.responseRangePosition, "responseRangePosition");
    paramStringBuilder.display(this.responseRangeLength, "responseRangeLength");
    paramStringBuilder.display(this.responseContentLength, "responseContentLength");
    paramStringBuilder.display(this.responseHttpCode, "responseHttpCode");
    paramStringBuilder.display(this.receiveDataSize, "receiveDataSize");
    paramStringBuilder.display(this.startTime, "startTime");
    paramStringBuilder.display(this.readHeaderTime, "readHeaderTime");
    paramStringBuilder.display(this.endTime, "endTime");
    paramStringBuilder.display(this.errorCode, "errorCode");
    paramStringBuilder.display(this.resultState, "resultState");
    paramStringBuilder.display(this.currentRetryCnt, "currentRetryCnt");
    paramStringBuilder.display(this.via, "via");
    paramStringBuilder.display(this.appId, "appId");
    paramStringBuilder.display(this.flag, "flag");
    AppMethodBeat.o(102285);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102286);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.UUID, true);
    paramStringBuilder.displaySimple(this.type, true);
    paramStringBuilder.displaySimple(this.requestUrl, true);
    paramStringBuilder.displaySimple(this.networkOperator, true);
    paramStringBuilder.displaySimple(this.networkType, true);
    paramStringBuilder.displaySimple(this.isWap, true);
    paramStringBuilder.displaySimple(this.requestRanagePosition, true);
    paramStringBuilder.displaySimple(this.requestRanageSize, true);
    paramStringBuilder.displaySimple(this.responseRangePosition, true);
    paramStringBuilder.displaySimple(this.responseRangeLength, true);
    paramStringBuilder.displaySimple(this.responseContentLength, true);
    paramStringBuilder.displaySimple(this.responseHttpCode, true);
    paramStringBuilder.displaySimple(this.receiveDataSize, true);
    paramStringBuilder.displaySimple(this.startTime, true);
    paramStringBuilder.displaySimple(this.readHeaderTime, true);
    paramStringBuilder.displaySimple(this.endTime, true);
    paramStringBuilder.displaySimple(this.errorCode, true);
    paramStringBuilder.displaySimple(this.resultState, true);
    paramStringBuilder.displaySimple(this.currentRetryCnt, true);
    paramStringBuilder.displaySimple(this.via, true);
    paramStringBuilder.displaySimple(this.appId, true);
    paramStringBuilder.displaySimple(this.flag, false);
    AppMethodBeat.o(102286);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102280);
    if (paramObject == null)
    {
      AppMethodBeat.o(102280);
      return false;
    }
    paramObject = (DownloadChunkLogInfo)paramObject;
    if ((JceUtil.equals(this.UUID, paramObject.UUID)) && (JceUtil.equals(this.type, paramObject.type)) && (JceUtil.equals(this.requestUrl, paramObject.requestUrl)) && (JceUtil.equals(this.networkOperator, paramObject.networkOperator)) && (JceUtil.equals(this.networkType, paramObject.networkType)) && (JceUtil.equals(this.isWap, paramObject.isWap)) && (JceUtil.equals(this.requestRanagePosition, paramObject.requestRanagePosition)) && (JceUtil.equals(this.requestRanageSize, paramObject.requestRanageSize)) && (JceUtil.equals(this.responseRangePosition, paramObject.responseRangePosition)) && (JceUtil.equals(this.responseRangeLength, paramObject.responseRangeLength)) && (JceUtil.equals(this.responseContentLength, paramObject.responseContentLength)) && (JceUtil.equals(this.responseHttpCode, paramObject.responseHttpCode)) && (JceUtil.equals(this.receiveDataSize, paramObject.receiveDataSize)) && (JceUtil.equals(this.startTime, paramObject.startTime)) && (JceUtil.equals(this.readHeaderTime, paramObject.readHeaderTime)) && (JceUtil.equals(this.endTime, paramObject.endTime)) && (JceUtil.equals(this.errorCode, paramObject.errorCode)) && (JceUtil.equals(this.resultState, paramObject.resultState)) && (JceUtil.equals(this.currentRetryCnt, paramObject.currentRetryCnt)) && (JceUtil.equals(this.via, paramObject.via)) && (JceUtil.equals(this.appId, paramObject.appId)) && (JceUtil.equals(this.flag, paramObject.flag)))
    {
      AppMethodBeat.o(102280);
      return true;
    }
    AppMethodBeat.o(102280);
    return false;
  }
  
  public final String fullClassName()
  {
    return "DownloadChunkLogInfo";
  }
  
  public final String getAppId()
  {
    return this.appId;
  }
  
  public final byte getCurrentRetryCnt()
  {
    return this.currentRetryCnt;
  }
  
  public final long getEndTime()
  {
    return this.endTime;
  }
  
  public final int getErrorCode()
  {
    return this.errorCode;
  }
  
  public final String getFlag()
  {
    return this.flag;
  }
  
  public final byte getIsWap()
  {
    return this.isWap;
  }
  
  public final String getNetworkOperator()
  {
    return this.networkOperator;
  }
  
  public final int getNetworkType()
  {
    return this.networkType;
  }
  
  public final long getReadHeaderTime()
  {
    return this.readHeaderTime;
  }
  
  public final long getReceiveDataSize()
  {
    return this.receiveDataSize;
  }
  
  public final long getRequestRanagePosition()
  {
    return this.requestRanagePosition;
  }
  
  public final long getRequestRanageSize()
  {
    return this.requestRanageSize;
  }
  
  public final String getRequestUrl()
  {
    return this.requestUrl;
  }
  
  public final long getResponseContentLength()
  {
    return this.responseContentLength;
  }
  
  public final int getResponseHttpCode()
  {
    return this.responseHttpCode;
  }
  
  public final long getResponseRangeLength()
  {
    return this.responseRangeLength;
  }
  
  public final long getResponseRangePosition()
  {
    return this.responseRangePosition;
  }
  
  public final int getResultState()
  {
    return this.resultState;
  }
  
  public final long getStartTime()
  {
    return this.startTime;
  }
  
  public final byte getType()
  {
    return this.type;
  }
  
  public final String getUUID()
  {
    return this.UUID;
  }
  
  public final String getVia()
  {
    return this.via;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(102281);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(102281);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ac.printErrStackTrace("DownloadChunkLogInfo", localException2, "", new Object[0]);
      AppMethodBeat.o(102281);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102284);
    this.UUID = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.requestUrl = paramJceInputStream.readString(2, false);
    this.networkOperator = paramJceInputStream.readString(3, false);
    this.networkType = paramJceInputStream.read(this.networkType, 4, false);
    this.isWap = paramJceInputStream.read(this.isWap, 5, false);
    this.requestRanagePosition = paramJceInputStream.read(this.requestRanagePosition, 6, false);
    this.requestRanageSize = paramJceInputStream.read(this.requestRanageSize, 7, false);
    this.responseRangePosition = paramJceInputStream.read(this.responseRangePosition, 9, false);
    this.responseRangeLength = paramJceInputStream.read(this.responseRangeLength, 10, false);
    this.responseContentLength = paramJceInputStream.read(this.responseContentLength, 11, false);
    this.responseHttpCode = paramJceInputStream.read(this.responseHttpCode, 12, false);
    this.receiveDataSize = paramJceInputStream.read(this.receiveDataSize, 13, false);
    this.startTime = paramJceInputStream.read(this.startTime, 14, false);
    this.readHeaderTime = paramJceInputStream.read(this.readHeaderTime, 15, false);
    this.endTime = paramJceInputStream.read(this.endTime, 16, false);
    this.errorCode = paramJceInputStream.read(this.errorCode, 17, false);
    this.resultState = paramJceInputStream.read(this.resultState, 18, false);
    this.currentRetryCnt = paramJceInputStream.read(this.currentRetryCnt, 19, false);
    this.via = paramJceInputStream.readString(20, false);
    this.appId = paramJceInputStream.readString(21, false);
    this.flag = paramJceInputStream.readString(22, false);
    AppMethodBeat.o(102284);
  }
  
  public final void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public final void setCurrentRetryCnt(byte paramByte)
  {
    this.currentRetryCnt = paramByte;
  }
  
  public final void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public final void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public final void setFlag(String paramString)
  {
    this.flag = paramString;
  }
  
  public final void setIsWap(byte paramByte)
  {
    this.isWap = paramByte;
  }
  
  public final void setNetworkOperator(String paramString)
  {
    this.networkOperator = paramString;
  }
  
  public final void setNetworkType(int paramInt)
  {
    this.networkType = paramInt;
  }
  
  public final void setReadHeaderTime(long paramLong)
  {
    this.readHeaderTime = paramLong;
  }
  
  public final void setReceiveDataSize(long paramLong)
  {
    this.receiveDataSize = paramLong;
  }
  
  public final void setRequestRanagePosition(long paramLong)
  {
    this.requestRanagePosition = paramLong;
  }
  
  public final void setRequestRanageSize(long paramLong)
  {
    this.requestRanageSize = paramLong;
  }
  
  public final void setRequestUrl(String paramString)
  {
    this.requestUrl = paramString;
  }
  
  public final void setResponseContentLength(long paramLong)
  {
    this.responseContentLength = paramLong;
  }
  
  public final void setResponseHttpCode(int paramInt)
  {
    this.responseHttpCode = paramInt;
  }
  
  public final void setResponseRangeLength(long paramLong)
  {
    this.responseRangeLength = paramLong;
  }
  
  public final void setResponseRangePosition(long paramLong)
  {
    this.responseRangePosition = paramLong;
  }
  
  public final void setResultState(int paramInt)
  {
    this.resultState = paramInt;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public final void setType(byte paramByte)
  {
    this.type = paramByte;
  }
  
  public final void setUUID(String paramString)
  {
    this.UUID = paramString;
  }
  
  public final void setVia(String paramString)
  {
    this.via = paramString;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102283);
    if (this.UUID != null) {
      paramJceOutputStream.write(this.UUID, 0);
    }
    paramJceOutputStream.write(this.type, 1);
    if (this.requestUrl != null) {
      paramJceOutputStream.write(this.requestUrl, 2);
    }
    if (this.networkOperator != null) {
      paramJceOutputStream.write(this.networkOperator, 3);
    }
    paramJceOutputStream.write(this.networkType, 4);
    paramJceOutputStream.write(this.isWap, 5);
    paramJceOutputStream.write(this.requestRanagePosition, 6);
    paramJceOutputStream.write(this.requestRanageSize, 7);
    paramJceOutputStream.write(this.responseRangePosition, 9);
    paramJceOutputStream.write(this.responseRangeLength, 10);
    paramJceOutputStream.write(this.responseContentLength, 11);
    paramJceOutputStream.write(this.responseHttpCode, 12);
    paramJceOutputStream.write(this.receiveDataSize, 13);
    paramJceOutputStream.write(this.startTime, 14);
    paramJceOutputStream.write(this.readHeaderTime, 15);
    paramJceOutputStream.write(this.endTime, 16);
    paramJceOutputStream.write(this.errorCode, 17);
    paramJceOutputStream.write(this.resultState, 18);
    paramJceOutputStream.write(this.currentRetryCnt, 19);
    if (this.via != null) {
      paramJceOutputStream.write(this.via, 20);
    }
    if (this.appId != null) {
      paramJceOutputStream.write(this.appId, 21);
    }
    if (this.flag != null) {
      paramJceOutputStream.write(this.flag, 22);
    }
    AppMethodBeat.o(102283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo
 * JD-Core Version:    0.7.0.1
 */