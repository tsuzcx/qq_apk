package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class AppSimpleDetail
  extends JceStruct
{
  static ArrayList<ApkDownUrl> cache_apkDownUrl;
  public ArrayList<ApkDownUrl> apkDownUrl = null;
  public long apkId = 0L;
  public String apkMd5 = "";
  public long appId = 0L;
  public String appName = "";
  public String channelId = "";
  public String diffApkMd5 = "";
  public long diffFileSize = 0L;
  public long fileSize = 0L;
  public String iconUrl = "";
  public String packageName = "";
  public String signatureMd5 = "";
  public int versionCode = 0;
  public String versionName = "";
  
  public AppSimpleDetail() {}
  
  public AppSimpleDetail(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, long paramLong3, ArrayList<ApkDownUrl> paramArrayList, String paramString7, long paramLong4, String paramString8)
  {
    this.appId = paramLong1;
    this.apkId = paramLong2;
    this.appName = paramString1;
    this.iconUrl = paramString2;
    this.packageName = paramString3;
    this.versionName = paramString4;
    this.versionCode = paramInt;
    this.signatureMd5 = paramString5;
    this.apkMd5 = paramString6;
    this.fileSize = paramLong3;
    this.apkDownUrl = paramArrayList;
    this.diffApkMd5 = paramString7;
    this.diffFileSize = paramLong4;
    this.channelId = paramString8;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102279);
    this.appId = paramJceInputStream.read(this.appId, 0, false);
    this.apkId = paramJceInputStream.read(this.apkId, 1, false);
    this.appName = paramJceInputStream.readString(2, false);
    this.iconUrl = paramJceInputStream.readString(3, false);
    this.packageName = paramJceInputStream.readString(4, false);
    this.versionName = paramJceInputStream.readString(5, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 6, false);
    this.signatureMd5 = paramJceInputStream.readString(7, false);
    this.apkMd5 = paramJceInputStream.readString(8, false);
    this.fileSize = paramJceInputStream.read(this.fileSize, 9, false);
    if (cache_apkDownUrl == null)
    {
      cache_apkDownUrl = new ArrayList();
      ApkDownUrl localApkDownUrl = new ApkDownUrl();
      cache_apkDownUrl.add(localApkDownUrl);
    }
    this.apkDownUrl = ((ArrayList)paramJceInputStream.read(cache_apkDownUrl, 10, false));
    this.diffApkMd5 = paramJceInputStream.readString(11, false);
    this.diffFileSize = paramJceInputStream.read(this.diffFileSize, 12, false);
    this.channelId = paramJceInputStream.readString(13, false);
    AppMethodBeat.o(102279);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102278);
    paramJceOutputStream.write(this.appId, 0);
    paramJceOutputStream.write(this.apkId, 1);
    if (this.appName != null) {
      paramJceOutputStream.write(this.appName, 2);
    }
    if (this.iconUrl != null) {
      paramJceOutputStream.write(this.iconUrl, 3);
    }
    if (this.packageName != null) {
      paramJceOutputStream.write(this.packageName, 4);
    }
    if (this.versionName != null) {
      paramJceOutputStream.write(this.versionName, 5);
    }
    paramJceOutputStream.write(this.versionCode, 6);
    if (this.signatureMd5 != null) {
      paramJceOutputStream.write(this.signatureMd5, 7);
    }
    if (this.apkMd5 != null) {
      paramJceOutputStream.write(this.apkMd5, 8);
    }
    paramJceOutputStream.write(this.fileSize, 9);
    if (this.apkDownUrl != null) {
      paramJceOutputStream.write(this.apkDownUrl, 10);
    }
    if (this.diffApkMd5 != null) {
      paramJceOutputStream.write(this.diffApkMd5, 11);
    }
    paramJceOutputStream.write(this.diffFileSize, 12);
    if (this.channelId != null) {
      paramJceOutputStream.write(this.channelId, 13);
    }
    AppMethodBeat.o(102278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.AppSimpleDetail
 * JD-Core Version:    0.7.0.1
 */