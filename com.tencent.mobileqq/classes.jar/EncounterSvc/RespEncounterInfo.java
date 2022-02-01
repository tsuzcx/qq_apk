package EncounterSvc;

import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespEncounterInfo
  extends JceStruct
{
  static int cache_eMerchantType;
  static int cache_eUserIdentityType;
  static RishState cache_richState;
  static byte[] cache_sig;
  static byte[] cache_vDateFaceInfo;
  static byte[] cache_vDateInfo;
  static byte[] cache_vDateVideoInfo;
  static byte[] cache_vFaceID;
  static byte[] cache_vInterestInfo;
  static byte[] cache_vIntroContent = (byte[])new byte[1];
  static byte[] cache_vTheSameLabels;
  static VipBaseInfo cache_vipBaseInfo;
  public String actionData = "";
  public byte authFlag = 0;
  public String avatarBgGif = "";
  public byte bIsSingle = 0;
  public byte cAge = -1;
  public byte cGroupId = 0;
  public byte cSex = -1;
  public byte cSpecialFlag = 0;
  public int charm = 0;
  public int charm_level = 0;
  public byte charm_shown = 0;
  public int common_face_timestamp = 0;
  public byte constellation = 0;
  public int eMerchantType = 0;
  public int eUserIdentityType = 0;
  public String enc_id = "";
  public byte god_flag = 0;
  public int hasAvatarAnimation = 0;
  public byte host_flag = 0;
  public byte host_online_flag = 0;
  public int iDistance = -1;
  public int iLat = 900000000;
  public int iLon = 900000000;
  public int iRank = 0;
  public int iVoteIncrement = -1;
  public int iVoteNum = 0;
  public byte is_trav = 0;
  public long lEctID = 0L;
  public int lTime = 0;
  public long lTotalVisitorsNum = 0L;
  public byte live_flag = 0;
  public byte marriage = 0;
  public int nFaceNum = 0;
  public String nowBoardcastGif = "";
  public String nowBoardcastWording = "";
  public String personal_imprint = "";
  public int profession_id = 0;
  public RishState richState = null;
  public int ruleId = 0;
  public short shIntroType = 0;
  public byte[] sig = null;
  public String strCertification = "";
  public String strCompanyName = "";
  public String strDescription = "";
  public String strNick = "";
  public String strPYFaceUrl = "";
  public String strPYName = "";
  public String strSchoolName = "";
  public int stranger_face_timestamp = 0;
  public long tiny_id = 0L;
  public String uid = "";
  public byte[] vDateFaceInfo = null;
  public byte[] vDateInfo = null;
  public byte[] vDateVideoInfo = null;
  public byte[] vFaceID = null;
  public byte[] vInterestInfo = null;
  public byte[] vIntroContent = null;
  public byte[] vTheSameLabels = null;
  public VipBaseInfo vipBaseInfo = null;
  public short wFace = 0;
  public byte watch_color = 0;
  
  static
  {
    ((byte[])cache_vIntroContent)[0] = 0;
    cache_vFaceID = (byte[])new byte[1];
    ((byte[])cache_vFaceID)[0] = 0;
    cache_eMerchantType = 0;
    cache_eUserIdentityType = 0;
    cache_vipBaseInfo = new VipBaseInfo();
    cache_richState = new RishState();
    cache_sig = (byte[])new byte[1];
    ((byte[])cache_sig)[0] = 0;
    cache_vDateInfo = (byte[])new byte[1];
    ((byte[])cache_vDateInfo)[0] = 0;
    cache_vInterestInfo = (byte[])new byte[1];
    ((byte[])cache_vInterestInfo)[0] = 0;
    cache_vTheSameLabels = (byte[])new byte[1];
    ((byte[])cache_vTheSameLabels)[0] = 0;
    cache_vDateFaceInfo = (byte[])new byte[1];
    ((byte[])cache_vDateFaceInfo)[0] = 0;
    cache_vDateVideoInfo = (byte[])new byte[1];
    ((byte[])cache_vDateVideoInfo)[0] = 0;
  }
  
  public RespEncounterInfo() {}
  
  public RespEncounterInfo(long paramLong1, int paramInt1, int paramInt2, String paramString1, short paramShort1, byte paramByte1, byte paramByte2, String paramString2, byte paramByte3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, short paramShort2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6, byte paramByte4, int paramInt7, int paramInt8, int paramInt9, long paramLong2, byte paramByte5, VipBaseInfo paramVipBaseInfo, RishState paramRishState, byte[] paramArrayOfByte3, String paramString8, String paramString9, byte paramByte6, byte paramByte7, int paramInt10, byte[] paramArrayOfByte4, byte paramByte8, long paramLong3, int paramInt11, int paramInt12, byte paramByte9, int paramInt13, byte paramByte10, int paramInt14, int paramInt15, byte paramByte11, byte paramByte12, byte[] paramArrayOfByte5, byte paramByte13, byte paramByte14, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, int paramInt16, byte paramByte15, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, int paramInt17)
  {
    this.lEctID = paramLong1;
    this.iDistance = paramInt1;
    this.lTime = paramInt2;
    this.strDescription = paramString1;
    this.wFace = paramShort1;
    this.cSex = paramByte1;
    this.cAge = paramByte2;
    this.strNick = paramString2;
    this.cGroupId = paramByte3;
    this.strPYFaceUrl = paramString3;
    this.strSchoolName = paramString4;
    this.strCompanyName = paramString5;
    this.strPYName = paramString6;
    this.nFaceNum = paramInt3;
    this.strCertification = paramString7;
    this.shIntroType = paramShort2;
    this.vIntroContent = paramArrayOfByte1;
    this.vFaceID = paramArrayOfByte2;
    this.eMerchantType = paramInt4;
    this.eUserIdentityType = paramInt5;
    this.iVoteIncrement = paramInt6;
    this.bIsSingle = paramByte4;
    this.iLat = paramInt7;
    this.iLon = paramInt8;
    this.iRank = paramInt9;
    this.lTotalVisitorsNum = paramLong2;
    this.cSpecialFlag = paramByte5;
    this.vipBaseInfo = paramVipBaseInfo;
    this.richState = paramRishState;
    this.sig = paramArrayOfByte3;
    this.enc_id = paramString8;
    this.uid = paramString9;
    this.is_trav = paramByte6;
    this.constellation = paramByte7;
    this.profession_id = paramInt10;
    this.vDateInfo = paramArrayOfByte4;
    this.marriage = paramByte8;
    this.tiny_id = paramLong3;
    this.common_face_timestamp = paramInt11;
    this.stranger_face_timestamp = paramInt12;
    this.authFlag = paramByte9;
    this.iVoteNum = paramInt13;
    this.god_flag = paramByte10;
    this.charm = paramInt14;
    this.charm_level = paramInt15;
    this.watch_color = paramByte11;
    this.charm_shown = paramByte12;
    this.vInterestInfo = paramArrayOfByte5;
    this.host_flag = paramByte13;
    this.host_online_flag = paramByte14;
    this.vTheSameLabels = paramArrayOfByte6;
    this.vDateFaceInfo = paramArrayOfByte7;
    this.vDateVideoInfo = paramArrayOfByte8;
    this.ruleId = paramInt16;
    this.live_flag = paramByte15;
    this.personal_imprint = paramString10;
    this.actionData = paramString11;
    this.avatarBgGif = paramString12;
    this.nowBoardcastGif = paramString13;
    this.nowBoardcastWording = paramString14;
    this.hasAvatarAnimation = paramInt17;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lEctID = paramJceInputStream.read(this.lEctID, 0, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 1, true);
    this.lTime = paramJceInputStream.read(this.lTime, 2, true);
    this.strDescription = paramJceInputStream.readString(3, true);
    this.wFace = paramJceInputStream.read(this.wFace, 4, true);
    this.cSex = paramJceInputStream.read(this.cSex, 5, true);
    this.cAge = paramJceInputStream.read(this.cAge, 6, true);
    this.strNick = paramJceInputStream.readString(7, true);
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 8, false);
    this.strPYFaceUrl = paramJceInputStream.readString(9, false);
    this.strSchoolName = paramJceInputStream.readString(10, false);
    this.strCompanyName = paramJceInputStream.readString(11, false);
    this.strPYName = paramJceInputStream.readString(12, false);
    this.nFaceNum = paramJceInputStream.read(this.nFaceNum, 13, false);
    this.strCertification = paramJceInputStream.readString(14, false);
    this.shIntroType = paramJceInputStream.read(this.shIntroType, 15, false);
    this.vIntroContent = ((byte[])paramJceInputStream.read(cache_vIntroContent, 16, false));
    this.vFaceID = ((byte[])paramJceInputStream.read(cache_vFaceID, 17, false));
    this.eMerchantType = paramJceInputStream.read(this.eMerchantType, 18, false);
    this.eUserIdentityType = paramJceInputStream.read(this.eUserIdentityType, 19, false);
    this.iVoteIncrement = paramJceInputStream.read(this.iVoteIncrement, 20, false);
    this.bIsSingle = paramJceInputStream.read(this.bIsSingle, 21, false);
    this.iLat = paramJceInputStream.read(this.iLat, 22, false);
    this.iLon = paramJceInputStream.read(this.iLon, 23, false);
    this.iRank = paramJceInputStream.read(this.iRank, 24, false);
    this.lTotalVisitorsNum = paramJceInputStream.read(this.lTotalVisitorsNum, 25, false);
    this.cSpecialFlag = paramJceInputStream.read(this.cSpecialFlag, 26, false);
    this.vipBaseInfo = ((VipBaseInfo)paramJceInputStream.read(cache_vipBaseInfo, 27, false));
    this.richState = ((RishState)paramJceInputStream.read(cache_richState, 28, false));
    this.sig = ((byte[])paramJceInputStream.read(cache_sig, 29, false));
    this.enc_id = paramJceInputStream.readString(30, false);
    this.uid = paramJceInputStream.readString(31, false);
    this.is_trav = paramJceInputStream.read(this.is_trav, 32, false);
    this.constellation = paramJceInputStream.read(this.constellation, 33, false);
    this.profession_id = paramJceInputStream.read(this.profession_id, 34, false);
    this.vDateInfo = ((byte[])paramJceInputStream.read(cache_vDateInfo, 35, false));
    this.marriage = paramJceInputStream.read(this.marriage, 36, false);
    this.tiny_id = paramJceInputStream.read(this.tiny_id, 37, false);
    this.common_face_timestamp = paramJceInputStream.read(this.common_face_timestamp, 38, false);
    this.stranger_face_timestamp = paramJceInputStream.read(this.stranger_face_timestamp, 39, false);
    this.authFlag = paramJceInputStream.read(this.authFlag, 40, false);
    this.iVoteNum = paramJceInputStream.read(this.iVoteNum, 41, false);
    this.god_flag = paramJceInputStream.read(this.god_flag, 42, false);
    this.charm = paramJceInputStream.read(this.charm, 43, false);
    this.charm_level = paramJceInputStream.read(this.charm_level, 44, false);
    this.watch_color = paramJceInputStream.read(this.watch_color, 45, false);
    this.charm_shown = paramJceInputStream.read(this.charm_shown, 46, false);
    this.vInterestInfo = ((byte[])paramJceInputStream.read(cache_vInterestInfo, 47, false));
    this.host_flag = paramJceInputStream.read(this.host_flag, 48, false);
    this.host_online_flag = paramJceInputStream.read(this.host_online_flag, 49, false);
    this.vTheSameLabels = ((byte[])paramJceInputStream.read(cache_vTheSameLabels, 50, false));
    this.vDateFaceInfo = ((byte[])paramJceInputStream.read(cache_vDateFaceInfo, 51, false));
    this.vDateVideoInfo = ((byte[])paramJceInputStream.read(cache_vDateVideoInfo, 52, false));
    this.ruleId = paramJceInputStream.read(this.ruleId, 53, false);
    this.live_flag = paramJceInputStream.read(this.live_flag, 54, false);
    this.personal_imprint = paramJceInputStream.readString(55, false);
    this.actionData = paramJceInputStream.readString(56, false);
    this.avatarBgGif = paramJceInputStream.readString(57, false);
    this.nowBoardcastGif = paramJceInputStream.readString(58, false);
    this.nowBoardcastWording = paramJceInputStream.readString(59, false);
    this.hasAvatarAnimation = paramJceInputStream.read(this.hasAvatarAnimation, 60, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lEctID, 0);
    paramJceOutputStream.write(this.iDistance, 1);
    paramJceOutputStream.write(this.lTime, 2);
    paramJceOutputStream.write(this.strDescription, 3);
    paramJceOutputStream.write(this.wFace, 4);
    paramJceOutputStream.write(this.cSex, 5);
    paramJceOutputStream.write(this.cAge, 6);
    paramJceOutputStream.write(this.strNick, 7);
    paramJceOutputStream.write(this.cGroupId, 8);
    if (this.strPYFaceUrl != null) {
      paramJceOutputStream.write(this.strPYFaceUrl, 9);
    }
    if (this.strSchoolName != null) {
      paramJceOutputStream.write(this.strSchoolName, 10);
    }
    if (this.strCompanyName != null) {
      paramJceOutputStream.write(this.strCompanyName, 11);
    }
    if (this.strPYName != null) {
      paramJceOutputStream.write(this.strPYName, 12);
    }
    paramJceOutputStream.write(this.nFaceNum, 13);
    if (this.strCertification != null) {
      paramJceOutputStream.write(this.strCertification, 14);
    }
    paramJceOutputStream.write(this.shIntroType, 15);
    if (this.vIntroContent != null) {
      paramJceOutputStream.write(this.vIntroContent, 16);
    }
    if (this.vFaceID != null) {
      paramJceOutputStream.write(this.vFaceID, 17);
    }
    paramJceOutputStream.write(this.eMerchantType, 18);
    paramJceOutputStream.write(this.eUserIdentityType, 19);
    paramJceOutputStream.write(this.iVoteIncrement, 20);
    paramJceOutputStream.write(this.bIsSingle, 21);
    paramJceOutputStream.write(this.iLat, 22);
    paramJceOutputStream.write(this.iLon, 23);
    paramJceOutputStream.write(this.iRank, 24);
    paramJceOutputStream.write(this.lTotalVisitorsNum, 25);
    paramJceOutputStream.write(this.cSpecialFlag, 26);
    if (this.vipBaseInfo != null) {
      paramJceOutputStream.write(this.vipBaseInfo, 27);
    }
    if (this.richState != null) {
      paramJceOutputStream.write(this.richState, 28);
    }
    if (this.sig != null) {
      paramJceOutputStream.write(this.sig, 29);
    }
    if (this.enc_id != null) {
      paramJceOutputStream.write(this.enc_id, 30);
    }
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 31);
    }
    paramJceOutputStream.write(this.is_trav, 32);
    paramJceOutputStream.write(this.constellation, 33);
    paramJceOutputStream.write(this.profession_id, 34);
    if (this.vDateInfo != null) {
      paramJceOutputStream.write(this.vDateInfo, 35);
    }
    paramJceOutputStream.write(this.marriage, 36);
    paramJceOutputStream.write(this.tiny_id, 37);
    paramJceOutputStream.write(this.common_face_timestamp, 38);
    paramJceOutputStream.write(this.stranger_face_timestamp, 39);
    paramJceOutputStream.write(this.authFlag, 40);
    paramJceOutputStream.write(this.iVoteNum, 41);
    paramJceOutputStream.write(this.god_flag, 42);
    paramJceOutputStream.write(this.charm, 43);
    paramJceOutputStream.write(this.charm_level, 44);
    paramJceOutputStream.write(this.watch_color, 45);
    paramJceOutputStream.write(this.charm_shown, 46);
    if (this.vInterestInfo != null) {
      paramJceOutputStream.write(this.vInterestInfo, 47);
    }
    paramJceOutputStream.write(this.host_flag, 48);
    paramJceOutputStream.write(this.host_online_flag, 49);
    if (this.vTheSameLabels != null) {
      paramJceOutputStream.write(this.vTheSameLabels, 50);
    }
    if (this.vDateFaceInfo != null) {
      paramJceOutputStream.write(this.vDateFaceInfo, 51);
    }
    if (this.vDateVideoInfo != null) {
      paramJceOutputStream.write(this.vDateVideoInfo, 52);
    }
    paramJceOutputStream.write(this.ruleId, 53);
    paramJceOutputStream.write(this.live_flag, 54);
    if (this.personal_imprint != null) {
      paramJceOutputStream.write(this.personal_imprint, 55);
    }
    if (this.actionData != null) {
      paramJceOutputStream.write(this.actionData, 56);
    }
    if (this.avatarBgGif != null) {
      paramJceOutputStream.write(this.avatarBgGif, 57);
    }
    if (this.nowBoardcastGif != null) {
      paramJceOutputStream.write(this.nowBoardcastGif, 58);
    }
    if (this.nowBoardcastWording != null) {
      paramJceOutputStream.write(this.nowBoardcastWording, 59);
    }
    paramJceOutputStream.write(this.hasAvatarAnimation, 60);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     EncounterSvc.RespEncounterInfo
 * JD-Core Version:    0.7.0.1
 */