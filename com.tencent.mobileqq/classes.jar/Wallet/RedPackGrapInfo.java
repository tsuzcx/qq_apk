package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RedPackGrapInfo
  extends JceStruct
{
  static ArrayList cache_vecGrapUin = new ArrayList();
  public int iConfType;
  public int iEffectsId;
  public int iEnvelopeId;
  public int iMsgType;
  public int iRedChannel;
  public int iRedType;
  public int iResourceType;
  public int iSkinId;
  public int iSoundRecordDuration;
  public int iSpecialPopId;
  public int iSubjectId;
  public long lCreateTime;
  public long lUin;
  public String sAuthKey = "";
  public String sBiilNo = "";
  public String sContent = "";
  public String sIndex = "";
  public String sName = "";
  public String sTitle = "";
  public ArrayList vecGrapUin;
  
  static
  {
    cache_vecGrapUin.add(Long.valueOf(0L));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.sTitle = paramJceInputStream.readString(1, false);
    this.iRedType = paramJceInputStream.read(this.iRedType, 2, false);
    this.sBiilNo = paramJceInputStream.readString(3, false);
    this.sAuthKey = paramJceInputStream.readString(4, false);
    this.iMsgType = paramJceInputStream.read(this.iMsgType, 5, false);
    this.iEnvelopeId = paramJceInputStream.read(this.iEnvelopeId, 6, false);
    this.sName = paramJceInputStream.readString(7, false);
    this.iRedChannel = paramJceInputStream.read(this.iRedChannel, 8, false);
    this.vecGrapUin = ((ArrayList)paramJceInputStream.read(cache_vecGrapUin, 9, false));
    this.sContent = paramJceInputStream.readString(10, false);
    this.iSoundRecordDuration = paramJceInputStream.read(this.iSoundRecordDuration, 11, false);
    this.iResourceType = paramJceInputStream.read(this.iResourceType, 12, false);
    this.iSkinId = paramJceInputStream.read(this.iSkinId, 13, false);
    this.iEffectsId = paramJceInputStream.read(this.iEffectsId, 14, false);
    this.iSpecialPopId = paramJceInputStream.read(this.iSpecialPopId, 15, false);
    this.iConfType = paramJceInputStream.read(this.iConfType, 16, false);
    this.iSubjectId = paramJceInputStream.read(this.iSubjectId, 17, false);
    this.lCreateTime = paramJceInputStream.read(this.lCreateTime, 18, false);
    this.sIndex = paramJceInputStream.readString(19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    if (this.sTitle != null) {
      paramJceOutputStream.write(this.sTitle, 1);
    }
    paramJceOutputStream.write(this.iRedType, 2);
    if (this.sBiilNo != null) {
      paramJceOutputStream.write(this.sBiilNo, 3);
    }
    if (this.sAuthKey != null) {
      paramJceOutputStream.write(this.sAuthKey, 4);
    }
    paramJceOutputStream.write(this.iMsgType, 5);
    paramJceOutputStream.write(this.iEnvelopeId, 6);
    if (this.sName != null) {
      paramJceOutputStream.write(this.sName, 7);
    }
    paramJceOutputStream.write(this.iRedChannel, 8);
    if (this.vecGrapUin != null) {
      paramJceOutputStream.write(this.vecGrapUin, 9);
    }
    if (this.sContent != null) {
      paramJceOutputStream.write(this.sContent, 10);
    }
    paramJceOutputStream.write(this.iSoundRecordDuration, 11);
    paramJceOutputStream.write(this.iResourceType, 12);
    paramJceOutputStream.write(this.iSkinId, 13);
    paramJceOutputStream.write(this.iEffectsId, 14);
    paramJceOutputStream.write(this.iSpecialPopId, 15);
    paramJceOutputStream.write(this.iConfType, 16);
    paramJceOutputStream.write(this.iSubjectId, 17);
    paramJceOutputStream.write(this.lCreateTime, 18);
    if (this.sIndex != null) {
      paramJceOutputStream.write(this.sIndex, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.RedPackGrapInfo
 * JD-Core Version:    0.7.0.1
 */