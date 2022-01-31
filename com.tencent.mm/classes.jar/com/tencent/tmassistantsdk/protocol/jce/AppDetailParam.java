package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppDetailParam
  extends JceStruct
{
  public byte actionFlag = 0;
  public long apkId = 0L;
  public int apkVersionCode = 0;
  public long appId = 0L;
  public byte appType = 1;
  public byte authPlatform = 0;
  public String channelId = "";
  public int grayVersionCode = 0;
  public String manifestMd5 = "";
  public String packageName = "";
  public String signatureMd5 = "";
  public String token = "";
  public String verifyAppId = "";
  public byte verifyType = 0;
  public int versionCode = 0;
  
  public AppDetailParam() {}
  
  public AppDetailParam(long paramLong1, String paramString1, String paramString2, int paramInt1, String paramString3, byte paramByte1, long paramLong2, int paramInt2, String paramString4, byte paramByte2, int paramInt3, String paramString5, byte paramByte3, byte paramByte4, String paramString6)
  {
    this.appId = paramLong1;
    this.packageName = paramString1;
    this.signatureMd5 = paramString2;
    this.versionCode = paramInt1;
    this.manifestMd5 = paramString3;
    this.appType = paramByte1;
    this.apkId = paramLong2;
    this.apkVersionCode = paramInt2;
    this.channelId = paramString4;
    this.actionFlag = paramByte2;
    this.grayVersionCode = paramInt3;
    this.token = paramString5;
    this.verifyType = paramByte3;
    this.authPlatform = paramByte4;
    this.verifyAppId = paramString6;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76031);
    this.appId = paramJceInputStream.read(this.appId, 0, false);
    this.packageName = paramJceInputStream.readString(1, false);
    this.signatureMd5 = paramJceInputStream.readString(2, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 3, false);
    this.manifestMd5 = paramJceInputStream.readString(4, false);
    this.appType = paramJceInputStream.read(this.appType, 5, false);
    this.apkId = paramJceInputStream.read(this.apkId, 6, false);
    this.apkVersionCode = paramJceInputStream.read(this.apkVersionCode, 7, false);
    this.channelId = paramJceInputStream.readString(8, false);
    this.actionFlag = paramJceInputStream.read(this.actionFlag, 9, false);
    this.grayVersionCode = paramJceInputStream.read(this.grayVersionCode, 10, false);
    this.token = paramJceInputStream.readString(11, false);
    this.verifyType = paramJceInputStream.read(this.verifyType, 12, false);
    this.authPlatform = paramJceInputStream.read(this.authPlatform, 13, false);
    this.verifyAppId = paramJceInputStream.readString(14, false);
    AppMethodBeat.o(76031);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(76030);
    paramJceOutputStream.write(this.appId, 0);
    if (this.packageName != null) {
      paramJceOutputStream.write(this.packageName, 1);
    }
    if (this.signatureMd5 != null) {
      paramJceOutputStream.write(this.signatureMd5, 2);
    }
    paramJceOutputStream.write(this.versionCode, 3);
    if (this.manifestMd5 != null) {
      paramJceOutputStream.write(this.manifestMd5, 4);
    }
    paramJceOutputStream.write(this.appType, 5);
    paramJceOutputStream.write(this.apkId, 6);
    paramJceOutputStream.write(this.apkVersionCode, 7);
    if (this.channelId != null) {
      paramJceOutputStream.write(this.channelId, 8);
    }
    paramJceOutputStream.write(this.actionFlag, 9);
    paramJceOutputStream.write(this.grayVersionCode, 10);
    if (this.token != null) {
      paramJceOutputStream.write(this.token, 11);
    }
    paramJceOutputStream.write(this.verifyType, 12);
    paramJceOutputStream.write(this.authPlatform, 13);
    if (this.verifyAppId != null) {
      paramJceOutputStream.write(this.verifyAppId, 14);
    }
    AppMethodBeat.o(76030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.AppDetailParam
 * JD-Core Version:    0.7.0.1
 */