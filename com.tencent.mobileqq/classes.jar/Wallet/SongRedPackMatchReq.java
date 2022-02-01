package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SongRedPackMatchReq
  extends JceStruct
{
  static C2CVoiceInfo cache_c2cRecordMixVoiceInfo = new C2CVoiceInfo();
  static C2CVoiceInfo cache_c2cRecordVoiceInfo;
  static GroupVoiceInfo cache_gVoiceMixRecordInfo;
  static GroupVoiceInfo cache_gVoiceRecordInfo = new GroupVoiceInfo();
  public long appid = 0L;
  public String billno = "";
  public C2CVoiceInfo c2cRecordMixVoiceInfo = null;
  public C2CVoiceInfo c2cRecordVoiceInfo = null;
  public int earphoneStatus = 0;
  public int fromType = 0;
  public GroupVoiceInfo gVoiceMixRecordInfo = null;
  public GroupVoiceInfo gVoiceRecordInfo = null;
  public long grabUin = 0L;
  public long makeUin = 0L;
  public int platform = 0;
  public String qqVersion = "";
  public String sKey = "";
  public int songId = 0;
  public int songType = 0;
  
  static
  {
    cache_gVoiceMixRecordInfo = new GroupVoiceInfo();
    cache_c2cRecordVoiceInfo = new C2CVoiceInfo();
  }
  
  public SongRedPackMatchReq(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, String paramString2, long paramLong3, int paramInt4, int paramInt5, String paramString3, GroupVoiceInfo paramGroupVoiceInfo1, GroupVoiceInfo paramGroupVoiceInfo2, C2CVoiceInfo paramC2CVoiceInfo1, C2CVoiceInfo paramC2CVoiceInfo2)
  {
    this.grabUin = paramLong1;
    this.billno = paramString1;
    this.songId = paramInt1;
    this.songType = paramInt2;
    this.earphoneStatus = paramInt3;
    this.makeUin = paramLong2;
    this.sKey = paramString2;
    this.appid = paramLong3;
    this.fromType = paramInt4;
    this.platform = paramInt5;
    this.qqVersion = paramString3;
    this.gVoiceRecordInfo = paramGroupVoiceInfo1;
    this.gVoiceMixRecordInfo = paramGroupVoiceInfo2;
    this.c2cRecordVoiceInfo = paramC2CVoiceInfo1;
    this.c2cRecordMixVoiceInfo = paramC2CVoiceInfo2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grabUin = paramJceInputStream.read(this.grabUin, 0, false);
    this.billno = paramJceInputStream.readString(1, false);
    this.songId = paramJceInputStream.read(this.songId, 2, false);
    this.songType = paramJceInputStream.read(this.songType, 3, false);
    this.earphoneStatus = paramJceInputStream.read(this.earphoneStatus, 4, false);
    this.makeUin = paramJceInputStream.read(this.makeUin, 5, false);
    this.sKey = paramJceInputStream.readString(6, false);
    this.appid = paramJceInputStream.read(this.appid, 7, false);
    this.fromType = paramJceInputStream.read(this.fromType, 8, false);
    this.platform = paramJceInputStream.read(this.platform, 9, false);
    this.qqVersion = paramJceInputStream.readString(10, false);
    this.gVoiceRecordInfo = ((GroupVoiceInfo)paramJceInputStream.read(cache_gVoiceRecordInfo, 11, false));
    this.gVoiceMixRecordInfo = ((GroupVoiceInfo)paramJceInputStream.read(cache_gVoiceMixRecordInfo, 12, false));
    this.c2cRecordVoiceInfo = ((C2CVoiceInfo)paramJceInputStream.read(cache_c2cRecordVoiceInfo, 13, false));
    this.c2cRecordMixVoiceInfo = ((C2CVoiceInfo)paramJceInputStream.read(cache_c2cRecordMixVoiceInfo, 14, false));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SongRedPackMatchReq{grabUin=");
    localStringBuilder.append(this.grabUin);
    localStringBuilder.append(", billno='");
    localStringBuilder.append(this.billno);
    localStringBuilder.append('\'');
    localStringBuilder.append(", songId=");
    localStringBuilder.append(this.songId);
    localStringBuilder.append(", songType=");
    localStringBuilder.append(this.songType);
    localStringBuilder.append(", earphoneStatus=");
    localStringBuilder.append(this.earphoneStatus);
    localStringBuilder.append(", makeUin=");
    localStringBuilder.append(this.makeUin);
    localStringBuilder.append(", sKey='");
    localStringBuilder.append(this.sKey);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.grabUin, 0);
    Object localObject = this.billno;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.songId, 2);
    paramJceOutputStream.write(this.songType, 3);
    paramJceOutputStream.write(this.earphoneStatus, 4);
    paramJceOutputStream.write(this.makeUin, 5);
    localObject = this.sKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.appid, 7);
    paramJceOutputStream.write(this.fromType, 8);
    paramJceOutputStream.write(this.platform, 9);
    localObject = this.qqVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.gVoiceRecordInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.gVoiceMixRecordInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
    localObject = this.c2cRecordVoiceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.c2cRecordMixVoiceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.SongRedPackMatchReq
 * JD-Core Version:    0.7.0.1
 */