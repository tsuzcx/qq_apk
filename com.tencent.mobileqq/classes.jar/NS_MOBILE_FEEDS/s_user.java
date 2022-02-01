package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_user
  extends JceStruct
{
  static s_medal cache_authqzoneMedalInfo;
  static byte[] cache_decoration;
  static s_kuolie_info cache_kuoliestate;
  static s_medal cache_liveshowMedalInfo;
  static s_medal cache_medalInfo = new s_medal();
  static s_openid_user cache_openid_users;
  static combine_diamond_info cache_stuCombineDiamondInfo;
  static star_info cache_stuStarInfo = new star_info();
  static ArrayList<s_yytag> cache_tagInfos;
  static ArrayList<String> cache_user_tags;
  public int actiontype;
  public String actionurl = "";
  public int age;
  public s_medal authqzoneMedalInfo;
  public String avatarRecomBar = "";
  public byte[] decoration;
  public String descicon = "";
  public int displayflag;
  public long eUserTypeReport = 0L;
  public int from = 1;
  public int iCurUserType = 0;
  public int iVipActType;
  public int icon_height;
  public int icon_width;
  public byte isAnnualVip;
  public int isCmtVerifyOpen;
  public int isFamousWhite;
  public int isPrivateMode;
  public int isQzoneUser;
  public byte isSafeModeUser;
  public byte isSetNickGlint;
  public int isSweetVip;
  public int isVideoCircleVUser;
  public int is_own;
  public int is_owner;
  public s_kuolie_info kuoliestate;
  public int level;
  public s_medal liveshowMedalInfo;
  public String logo = "";
  public s_medal medalInfo;
  public int namePlate;
  public String nickname = "";
  public s_openid_user openid_users;
  public int operation_mask;
  public int portrait_id;
  public String qzonedesc = "";
  public byte sex;
  public String strPortraitId = "";
  public combine_diamond_info stuCombineDiamondInfo;
  public star_info stuStarInfo;
  public ArrayList<s_yytag> tagInfos;
  public String talk_id = "";
  public int timestamp;
  public long uFansCount;
  public long uFeedsCount;
  public long uVisitorCount;
  public String uid = "";
  public long uin;
  public String uinkey = "";
  public String under_nickname_desc = "";
  public ArrayList<String> user_tags;
  public int vip;
  public byte vipShowType = -1;
  public int viplevel;
  public int viptype;
  public long vtime;
  
  static
  {
    cache_stuCombineDiamondInfo = new combine_diamond_info();
    cache_decoration = (byte[])new byte[1];
    ((byte[])cache_decoration)[0] = 0;
    cache_tagInfos = new ArrayList();
    s_yytag locals_yytag = new s_yytag();
    cache_tagInfos.add(locals_yytag);
    cache_liveshowMedalInfo = new s_medal();
    cache_authqzoneMedalInfo = new s_medal();
    cache_openid_users = new s_openid_user();
    cache_kuoliestate = new s_kuolie_info();
    cache_user_tags = new ArrayList();
    cache_user_tags.add("");
  }
  
  public s_user() {}
  
  public s_user(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString4, int paramInt7, int paramInt8, String paramString5, String paramString6, int paramInt9, int paramInt10, int paramInt11, int paramInt12, byte paramByte1, byte paramByte2, s_medal params_medal1, String paramString7, int paramInt13, int paramInt14, int paramInt15, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info, byte paramByte3, byte paramByte4, int paramInt16, int paramInt17, String paramString8, byte[] paramArrayOfByte, ArrayList<s_yytag> paramArrayList, String paramString9, String paramString10, s_medal params_medal2, long paramLong2, long paramLong3, int paramInt18, int paramInt19, int paramInt20, long paramLong4, s_medal params_medal3, long paramLong5, int paramInt21, s_openid_user params_openid_user, byte paramByte5, s_kuolie_info params_kuolie_info, int paramInt22, String paramString11, ArrayList<String> paramArrayList1, int paramInt23, int paramInt24, long paramLong6)
  {
    this.uin = paramLong1;
    this.nickname = paramString1;
    this.timestamp = paramInt1;
    this.from = paramInt2;
    this.uinkey = paramString2;
    this.logo = paramString3;
    this.vip = paramInt3;
    this.level = paramInt4;
    this.viplevel = paramInt5;
    this.viptype = paramInt6;
    this.qzonedesc = paramString4;
    this.is_owner = paramInt7;
    this.operation_mask = paramInt8;
    this.uid = paramString5;
    this.talk_id = paramString6;
    this.portrait_id = paramInt9;
    this.is_own = paramInt10;
    this.isFamousWhite = paramInt11;
    this.isQzoneUser = paramInt12;
    this.isAnnualVip = paramByte1;
    this.isSetNickGlint = paramByte2;
    this.medalInfo = params_medal1;
    this.descicon = paramString7;
    this.icon_width = paramInt13;
    this.icon_height = paramInt14;
    this.isSweetVip = paramInt15;
    this.stuStarInfo = paramstar_info;
    this.stuCombineDiamondInfo = paramcombine_diamond_info;
    this.isSafeModeUser = paramByte3;
    this.vipShowType = paramByte4;
    this.namePlate = paramInt16;
    this.actiontype = paramInt17;
    this.actionurl = paramString8;
    this.decoration = paramArrayOfByte;
    this.tagInfos = paramArrayList;
    this.strPortraitId = paramString9;
    this.under_nickname_desc = paramString10;
    this.liveshowMedalInfo = params_medal2;
    this.uFansCount = paramLong2;
    this.uVisitorCount = paramLong3;
    this.isCmtVerifyOpen = paramInt18;
    this.iCurUserType = paramInt19;
    this.displayflag = paramInt20;
    this.vtime = paramLong4;
    this.authqzoneMedalInfo = params_medal3;
    this.eUserTypeReport = paramLong5;
    this.iVipActType = paramInt21;
    this.openid_users = params_openid_user;
    this.sex = paramByte5;
    this.kuoliestate = params_kuolie_info;
    this.isPrivateMode = paramInt22;
    this.avatarRecomBar = paramString11;
    this.user_tags = paramArrayList1;
    this.age = paramInt23;
    this.isVideoCircleVUser = paramInt24;
    this.uFeedsCount = paramLong6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, false);
    this.from = paramJceInputStream.read(this.from, 3, false);
    this.uinkey = paramJceInputStream.readString(4, false);
    this.logo = paramJceInputStream.readString(5, false);
    this.vip = paramJceInputStream.read(this.vip, 6, false);
    this.level = paramJceInputStream.read(this.level, 7, false);
    this.viplevel = paramJceInputStream.read(this.viplevel, 8, false);
    this.viptype = paramJceInputStream.read(this.viptype, 9, false);
    this.qzonedesc = paramJceInputStream.readString(10, false);
    this.is_owner = paramJceInputStream.read(this.is_owner, 11, false);
    this.operation_mask = paramJceInputStream.read(this.operation_mask, 12, false);
    this.uid = paramJceInputStream.readString(13, false);
    this.talk_id = paramJceInputStream.readString(14, false);
    this.portrait_id = paramJceInputStream.read(this.portrait_id, 15, false);
    this.is_own = paramJceInputStream.read(this.is_own, 16, false);
    this.isFamousWhite = paramJceInputStream.read(this.isFamousWhite, 17, false);
    this.isQzoneUser = paramJceInputStream.read(this.isQzoneUser, 18, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 19, false);
    this.isSetNickGlint = paramJceInputStream.read(this.isSetNickGlint, 20, false);
    this.medalInfo = ((s_medal)paramJceInputStream.read(cache_medalInfo, 21, false));
    this.descicon = paramJceInputStream.readString(22, false);
    this.icon_width = paramJceInputStream.read(this.icon_width, 23, false);
    this.icon_height = paramJceInputStream.read(this.icon_height, 24, false);
    this.isSweetVip = paramJceInputStream.read(this.isSweetVip, 25, false);
    this.stuStarInfo = ((star_info)paramJceInputStream.read(cache_stuStarInfo, 26, false));
    this.stuCombineDiamondInfo = ((combine_diamond_info)paramJceInputStream.read(cache_stuCombineDiamondInfo, 27, false));
    this.isSafeModeUser = paramJceInputStream.read(this.isSafeModeUser, 28, false);
    this.vipShowType = paramJceInputStream.read(this.vipShowType, 29, false);
    this.namePlate = paramJceInputStream.read(this.namePlate, 30, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 31, false);
    this.actionurl = paramJceInputStream.readString(32, false);
    this.decoration = ((byte[])paramJceInputStream.read(cache_decoration, 33, false));
    this.tagInfos = ((ArrayList)paramJceInputStream.read(cache_tagInfos, 34, false));
    this.strPortraitId = paramJceInputStream.readString(35, false);
    this.under_nickname_desc = paramJceInputStream.readString(36, false);
    this.liveshowMedalInfo = ((s_medal)paramJceInputStream.read(cache_liveshowMedalInfo, 37, false));
    this.uFansCount = paramJceInputStream.read(this.uFansCount, 38, false);
    this.uVisitorCount = paramJceInputStream.read(this.uVisitorCount, 39, false);
    this.isCmtVerifyOpen = paramJceInputStream.read(this.isCmtVerifyOpen, 40, false);
    this.iCurUserType = paramJceInputStream.read(this.iCurUserType, 41, false);
    this.displayflag = paramJceInputStream.read(this.displayflag, 42, false);
    this.vtime = paramJceInputStream.read(this.vtime, 43, false);
    this.authqzoneMedalInfo = ((s_medal)paramJceInputStream.read(cache_authqzoneMedalInfo, 44, false));
    this.eUserTypeReport = paramJceInputStream.read(this.eUserTypeReport, 45, false);
    this.iVipActType = paramJceInputStream.read(this.iVipActType, 46, false);
    this.openid_users = ((s_openid_user)paramJceInputStream.read(cache_openid_users, 47, false));
    this.sex = paramJceInputStream.read(this.sex, 48, false);
    this.kuoliestate = ((s_kuolie_info)paramJceInputStream.read(cache_kuoliestate, 49, false));
    this.isPrivateMode = paramJceInputStream.read(this.isPrivateMode, 50, false);
    this.avatarRecomBar = paramJceInputStream.readString(51, false);
    this.user_tags = ((ArrayList)paramJceInputStream.read(cache_user_tags, 52, false));
    this.age = paramJceInputStream.read(this.age, 53, false);
    this.isVideoCircleVUser = paramJceInputStream.read(this.isVideoCircleVUser, 54, false);
    this.uFeedsCount = paramJceInputStream.read(this.uFeedsCount, 55, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    paramJceOutputStream.write(this.timestamp, 2);
    paramJceOutputStream.write(this.from, 3);
    if (this.uinkey != null) {
      paramJceOutputStream.write(this.uinkey, 4);
    }
    if (this.logo != null) {
      paramJceOutputStream.write(this.logo, 5);
    }
    paramJceOutputStream.write(this.vip, 6);
    paramJceOutputStream.write(this.level, 7);
    paramJceOutputStream.write(this.viplevel, 8);
    paramJceOutputStream.write(this.viptype, 9);
    if (this.qzonedesc != null) {
      paramJceOutputStream.write(this.qzonedesc, 10);
    }
    paramJceOutputStream.write(this.is_owner, 11);
    paramJceOutputStream.write(this.operation_mask, 12);
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 13);
    }
    if (this.talk_id != null) {
      paramJceOutputStream.write(this.talk_id, 14);
    }
    paramJceOutputStream.write(this.portrait_id, 15);
    paramJceOutputStream.write(this.is_own, 16);
    paramJceOutputStream.write(this.isFamousWhite, 17);
    paramJceOutputStream.write(this.isQzoneUser, 18);
    paramJceOutputStream.write(this.isAnnualVip, 19);
    paramJceOutputStream.write(this.isSetNickGlint, 20);
    if (this.medalInfo != null) {
      paramJceOutputStream.write(this.medalInfo, 21);
    }
    if (this.descicon != null) {
      paramJceOutputStream.write(this.descicon, 22);
    }
    paramJceOutputStream.write(this.icon_width, 23);
    paramJceOutputStream.write(this.icon_height, 24);
    paramJceOutputStream.write(this.isSweetVip, 25);
    if (this.stuStarInfo != null) {
      paramJceOutputStream.write(this.stuStarInfo, 26);
    }
    if (this.stuCombineDiamondInfo != null) {
      paramJceOutputStream.write(this.stuCombineDiamondInfo, 27);
    }
    paramJceOutputStream.write(this.isSafeModeUser, 28);
    paramJceOutputStream.write(this.vipShowType, 29);
    paramJceOutputStream.write(this.namePlate, 30);
    paramJceOutputStream.write(this.actiontype, 31);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 32);
    }
    if (this.decoration != null) {
      paramJceOutputStream.write(this.decoration, 33);
    }
    if (this.tagInfos != null) {
      paramJceOutputStream.write(this.tagInfos, 34);
    }
    if (this.strPortraitId != null) {
      paramJceOutputStream.write(this.strPortraitId, 35);
    }
    if (this.under_nickname_desc != null) {
      paramJceOutputStream.write(this.under_nickname_desc, 36);
    }
    if (this.liveshowMedalInfo != null) {
      paramJceOutputStream.write(this.liveshowMedalInfo, 37);
    }
    paramJceOutputStream.write(this.uFansCount, 38);
    paramJceOutputStream.write(this.uVisitorCount, 39);
    paramJceOutputStream.write(this.isCmtVerifyOpen, 40);
    paramJceOutputStream.write(this.iCurUserType, 41);
    paramJceOutputStream.write(this.displayflag, 42);
    paramJceOutputStream.write(this.vtime, 43);
    if (this.authqzoneMedalInfo != null) {
      paramJceOutputStream.write(this.authqzoneMedalInfo, 44);
    }
    paramJceOutputStream.write(this.eUserTypeReport, 45);
    paramJceOutputStream.write(this.iVipActType, 46);
    if (this.openid_users != null) {
      paramJceOutputStream.write(this.openid_users, 47);
    }
    paramJceOutputStream.write(this.sex, 48);
    if (this.kuoliestate != null) {
      paramJceOutputStream.write(this.kuoliestate, 49);
    }
    paramJceOutputStream.write(this.isPrivateMode, 50);
    if (this.avatarRecomBar != null) {
      paramJceOutputStream.write(this.avatarRecomBar, 51);
    }
    if (this.user_tags != null) {
      paramJceOutputStream.write(this.user_tags, 52);
    }
    paramJceOutputStream.write(this.age, 53);
    paramJceOutputStream.write(this.isVideoCircleVUser, 54);
    paramJceOutputStream.write(this.uFeedsCount, 55);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_user
 * JD-Core Version:    0.7.0.1
 */