package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IPCBaseParam
  extends JceStruct
{
  public String channelId = "";
  public String hostAppId = "";
  public String taskAppId = "";
  public String taskPackageName = "";
  public String taskVersion = "";
  public String uin = "";
  public String uinType = "";
  public String via = "";
  
  public IPCBaseParam() {}
  
  public IPCBaseParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.hostAppId = paramString1;
    this.taskAppId = paramString2;
    this.taskVersion = paramString3;
    this.taskPackageName = paramString4;
    this.uin = paramString5;
    this.uinType = paramString6;
    this.via = paramString7;
    this.channelId = paramString8;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102233);
    this.hostAppId = paramJceInputStream.readString(0, true);
    this.taskAppId = paramJceInputStream.readString(1, false);
    this.taskVersion = paramJceInputStream.readString(2, true);
    this.taskPackageName = paramJceInputStream.readString(3, true);
    this.uin = paramJceInputStream.readString(4, false);
    this.uinType = paramJceInputStream.readString(5, false);
    this.via = paramJceInputStream.readString(6, false);
    this.channelId = paramJceInputStream.readString(7, false);
    AppMethodBeat.o(102233);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102232);
    paramJceOutputStream.write(this.hostAppId, 0);
    if (this.taskAppId != null) {
      paramJceOutputStream.write(this.taskAppId, 1);
    }
    paramJceOutputStream.write(this.taskVersion, 2);
    paramJceOutputStream.write(this.taskPackageName, 3);
    if (this.uin != null) {
      paramJceOutputStream.write(this.uin, 4);
    }
    if (this.uinType != null) {
      paramJceOutputStream.write(this.uinType, 5);
    }
    if (this.via != null) {
      paramJceOutputStream.write(this.via, 6);
    }
    if (this.channelId != null) {
      paramJceOutputStream.write(this.channelId, 7);
    }
    AppMethodBeat.o(102232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.IPCBaseParam
 * JD-Core Version:    0.7.0.1
 */