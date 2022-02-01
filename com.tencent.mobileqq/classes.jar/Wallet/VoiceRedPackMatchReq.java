package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VoiceRedPackMatchReq
  extends JceStruct
{
  static C2CVoiceInfo cache_c2cVoiceInfo = new C2CVoiceInfo();
  static GroupVoiceInfo cache_groupVoiceInfo = new GroupVoiceInfo();
  static VoiceMatchStatus cache_voiceMatchStatus = new VoiceMatchStatus();
  public long appid = 0L;
  public String billno = "";
  public C2CVoiceInfo c2cVoiceInfo = null;
  public int fromType = 0;
  public long grabUin = 0L;
  public GroupVoiceInfo groupVoiceInfo = null;
  public long makeUin = 0L;
  public int platform = 0;
  public String qqVersion = "";
  public String sKey = "";
  public VoiceMatchStatus voiceMatchStatus = null;
  public String voiceText = "";
  
  public VoiceRedPackMatchReq() {}
  
  public VoiceRedPackMatchReq(long paramLong1, String paramString1, String paramString2, long paramLong2, String paramString3, long paramLong3, int paramInt1, GroupVoiceInfo paramGroupVoiceInfo, int paramInt2, C2CVoiceInfo paramC2CVoiceInfo, String paramString4, VoiceMatchStatus paramVoiceMatchStatus)
  {
    this.grabUin = paramLong1;
    this.billno = paramString1;
    this.voiceText = paramString2;
    this.makeUin = paramLong2;
    this.sKey = paramString3;
    this.appid = paramLong3;
    this.fromType = paramInt1;
    this.groupVoiceInfo = paramGroupVoiceInfo;
    this.platform = paramInt2;
    this.c2cVoiceInfo = paramC2CVoiceInfo;
    this.qqVersion = paramString4;
    this.voiceMatchStatus = paramVoiceMatchStatus;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grabUin = paramJceInputStream.read(this.grabUin, 0, false);
    this.billno = paramJceInputStream.readString(1, false);
    this.voiceText = paramJceInputStream.readString(2, false);
    this.makeUin = paramJceInputStream.read(this.makeUin, 3, false);
    this.sKey = paramJceInputStream.readString(4, false);
    this.appid = paramJceInputStream.read(this.appid, 5, false);
    this.fromType = paramJceInputStream.read(this.fromType, 6, false);
    this.groupVoiceInfo = ((GroupVoiceInfo)paramJceInputStream.read(cache_groupVoiceInfo, 7, false));
    this.platform = paramJceInputStream.read(this.platform, 8, false);
    this.c2cVoiceInfo = ((C2CVoiceInfo)paramJceInputStream.read(cache_c2cVoiceInfo, 9, false));
    this.qqVersion = paramJceInputStream.readString(10, false);
    this.voiceMatchStatus = ((VoiceMatchStatus)paramJceInputStream.read(cache_voiceMatchStatus, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.grabUin, 0);
    Object localObject = this.billno;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.voiceText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.makeUin, 3);
    localObject = this.sKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.appid, 5);
    paramJceOutputStream.write(this.fromType, 6);
    localObject = this.groupVoiceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    paramJceOutputStream.write(this.platform, 8);
    localObject = this.c2cVoiceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.qqVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.voiceMatchStatus;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.VoiceRedPackMatchReq
 * JD-Core Version:    0.7.0.1
 */