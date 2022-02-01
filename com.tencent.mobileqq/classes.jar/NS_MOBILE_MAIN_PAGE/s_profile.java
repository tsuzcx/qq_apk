package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_profile
  extends JceStruct
{
  static byte[] cache_QzmallProfileDecoGetRsp;
  static combine_diamond_info cache_stuCombineDiamondInfo;
  static star_info cache_stuStarInfo = new star_info();
  public byte[] QzmallProfileDecoGetRsp = null;
  public byte age = 0;
  public String astro = "";
  public String authinfo = "";
  public int birthday = 0;
  public int brand_flag = 0;
  public String city = "";
  public String country = "";
  public int fans_limit = 0;
  public long fans_num = 0L;
  public String fans_num_express = "";
  public int follow_num = 0;
  public byte gender = 0;
  public byte isAnnualVip = 0;
  public boolean isFamousQzone = true;
  public boolean is_famouse_custom_homepage_white = true;
  public boolean is_readspace = true;
  public boolean is_sweet_user = false;
  public int nameplate_flag = 0;
  public String nick = "";
  public String nickname = "";
  public String province = "";
  public int qzone_right_flag = 0;
  public String qzonename = "";
  public String readspace_picurl = "";
  public boolean show_menu_panel = true;
  public String space_desc = "";
  public int sqqlevel = 0;
  public String strvipoverday = "";
  public combine_diamond_info stuCombineDiamondInfo = null;
  public star_info stuStarInfo = null;
  public long uin = 0L;
  public int user_type = 0;
  public byte vip = 0;
  public int vip_keepdays = 0;
  public int vipexpiretime = 0;
  public int viplevel = 0;
  public int vipratio = 0;
  public int vipscore = 0;
  public int vipspeed = 0;
  public int viptype = 0;
  public String vipurl = "";
  public String weishi_schema = "";
  
  static
  {
    cache_stuCombineDiamondInfo = new combine_diamond_info();
    cache_QzmallProfileDecoGetRsp = (byte[])new byte[1];
    ((byte[])cache_QzmallProfileDecoGetRsp)[0] = 0;
  }
  
  public s_profile() {}
  
  public s_profile(long paramLong1, String paramString1, String paramString2, byte paramByte1, byte paramByte2, byte paramByte3, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, int paramInt3, boolean paramBoolean1, long paramLong2, String paramString7, int paramInt4, String paramString8, boolean paramBoolean2, String paramString9, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString10, String paramString11, int paramInt9, boolean paramBoolean3, byte paramByte4, boolean paramBoolean4, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info, int paramInt10, byte[] paramArrayOfByte, int paramInt11, String paramString12, int paramInt12, boolean paramBoolean5, int paramInt13, int paramInt14, String paramString13, String paramString14, int paramInt15)
  {
    this.uin = paramLong1;
    this.nickname = paramString1;
    this.qzonename = paramString2;
    this.vip = paramByte1;
    this.gender = paramByte2;
    this.age = paramByte3;
    this.birthday = paramInt1;
    this.astro = paramString3;
    this.country = paramString4;
    this.province = paramString5;
    this.city = paramString6;
    this.viplevel = paramInt2;
    this.sqqlevel = paramInt3;
    this.isFamousQzone = paramBoolean1;
    this.fans_num = paramLong2;
    this.fans_num_express = paramString7;
    this.viptype = paramInt4;
    this.nick = paramString8;
    this.is_readspace = paramBoolean2;
    this.authinfo = paramString9;
    this.vipscore = paramInt5;
    this.vipspeed = paramInt6;
    this.vipratio = paramInt7;
    this.vipexpiretime = paramInt8;
    this.strvipoverday = paramString10;
    this.readspace_picurl = paramString11;
    this.qzone_right_flag = paramInt9;
    this.is_famouse_custom_homepage_white = paramBoolean3;
    this.isAnnualVip = paramByte4;
    this.is_sweet_user = paramBoolean4;
    this.stuStarInfo = paramstar_info;
    this.stuCombineDiamondInfo = paramcombine_diamond_info;
    this.nameplate_flag = paramInt10;
    this.QzmallProfileDecoGetRsp = paramArrayOfByte;
    this.user_type = paramInt11;
    this.vipurl = paramString12;
    this.follow_num = paramInt12;
    this.show_menu_panel = paramBoolean5;
    this.fans_limit = paramInt13;
    this.brand_flag = paramInt14;
    this.space_desc = paramString13;
    this.weishi_schema = paramString14;
    this.vip_keepdays = paramInt15;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.qzonename = paramJceInputStream.readString(2, false);
    this.vip = paramJceInputStream.read(this.vip, 3, false);
    this.gender = paramJceInputStream.read(this.gender, 4, false);
    this.age = paramJceInputStream.read(this.age, 5, false);
    this.birthday = paramJceInputStream.read(this.birthday, 6, false);
    this.astro = paramJceInputStream.readString(7, false);
    this.country = paramJceInputStream.readString(8, false);
    this.province = paramJceInputStream.readString(9, false);
    this.city = paramJceInputStream.readString(10, false);
    this.viplevel = paramJceInputStream.read(this.viplevel, 11, false);
    this.sqqlevel = paramJceInputStream.read(this.sqqlevel, 12, false);
    this.isFamousQzone = paramJceInputStream.read(this.isFamousQzone, 13, false);
    this.fans_num = paramJceInputStream.read(this.fans_num, 14, false);
    this.fans_num_express = paramJceInputStream.readString(15, false);
    this.viptype = paramJceInputStream.read(this.viptype, 16, false);
    this.nick = paramJceInputStream.readString(17, false);
    this.is_readspace = paramJceInputStream.read(this.is_readspace, 18, false);
    this.authinfo = paramJceInputStream.readString(19, false);
    this.vipscore = paramJceInputStream.read(this.vipscore, 20, false);
    this.vipspeed = paramJceInputStream.read(this.vipspeed, 21, false);
    this.vipratio = paramJceInputStream.read(this.vipratio, 22, false);
    this.vipexpiretime = paramJceInputStream.read(this.vipexpiretime, 23, false);
    this.strvipoverday = paramJceInputStream.readString(24, false);
    this.readspace_picurl = paramJceInputStream.readString(25, false);
    this.qzone_right_flag = paramJceInputStream.read(this.qzone_right_flag, 26, false);
    this.is_famouse_custom_homepage_white = paramJceInputStream.read(this.is_famouse_custom_homepage_white, 27, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 28, false);
    this.is_sweet_user = paramJceInputStream.read(this.is_sweet_user, 29, false);
    this.stuStarInfo = ((star_info)paramJceInputStream.read(cache_stuStarInfo, 30, false));
    this.stuCombineDiamondInfo = ((combine_diamond_info)paramJceInputStream.read(cache_stuCombineDiamondInfo, 31, false));
    this.nameplate_flag = paramJceInputStream.read(this.nameplate_flag, 32, false);
    this.QzmallProfileDecoGetRsp = ((byte[])paramJceInputStream.read(cache_QzmallProfileDecoGetRsp, 33, false));
    this.user_type = paramJceInputStream.read(this.user_type, 34, false);
    this.vipurl = paramJceInputStream.readString(35, false);
    this.follow_num = paramJceInputStream.read(this.follow_num, 36, false);
    this.show_menu_panel = paramJceInputStream.read(this.show_menu_panel, 37, false);
    this.fans_limit = paramJceInputStream.read(this.fans_limit, 38, false);
    this.brand_flag = paramJceInputStream.read(this.brand_flag, 39, false);
    this.space_desc = paramJceInputStream.readString(40, false);
    this.weishi_schema = paramJceInputStream.readString(41, false);
    this.vip_keepdays = paramJceInputStream.read(this.vip_keepdays, 42, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    if (this.qzonename != null) {
      paramJceOutputStream.write(this.qzonename, 2);
    }
    paramJceOutputStream.write(this.vip, 3);
    paramJceOutputStream.write(this.gender, 4);
    paramJceOutputStream.write(this.age, 5);
    paramJceOutputStream.write(this.birthday, 6);
    if (this.astro != null) {
      paramJceOutputStream.write(this.astro, 7);
    }
    if (this.country != null) {
      paramJceOutputStream.write(this.country, 8);
    }
    if (this.province != null) {
      paramJceOutputStream.write(this.province, 9);
    }
    if (this.city != null) {
      paramJceOutputStream.write(this.city, 10);
    }
    paramJceOutputStream.write(this.viplevel, 11);
    paramJceOutputStream.write(this.sqqlevel, 12);
    paramJceOutputStream.write(this.isFamousQzone, 13);
    paramJceOutputStream.write(this.fans_num, 14);
    if (this.fans_num_express != null) {
      paramJceOutputStream.write(this.fans_num_express, 15);
    }
    paramJceOutputStream.write(this.viptype, 16);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 17);
    }
    paramJceOutputStream.write(this.is_readspace, 18);
    if (this.authinfo != null) {
      paramJceOutputStream.write(this.authinfo, 19);
    }
    paramJceOutputStream.write(this.vipscore, 20);
    paramJceOutputStream.write(this.vipspeed, 21);
    paramJceOutputStream.write(this.vipratio, 22);
    paramJceOutputStream.write(this.vipexpiretime, 23);
    if (this.strvipoverday != null) {
      paramJceOutputStream.write(this.strvipoverday, 24);
    }
    if (this.readspace_picurl != null) {
      paramJceOutputStream.write(this.readspace_picurl, 25);
    }
    paramJceOutputStream.write(this.qzone_right_flag, 26);
    paramJceOutputStream.write(this.is_famouse_custom_homepage_white, 27);
    paramJceOutputStream.write(this.isAnnualVip, 28);
    paramJceOutputStream.write(this.is_sweet_user, 29);
    if (this.stuStarInfo != null) {
      paramJceOutputStream.write(this.stuStarInfo, 30);
    }
    if (this.stuCombineDiamondInfo != null) {
      paramJceOutputStream.write(this.stuCombineDiamondInfo, 31);
    }
    paramJceOutputStream.write(this.nameplate_flag, 32);
    if (this.QzmallProfileDecoGetRsp != null) {
      paramJceOutputStream.write(this.QzmallProfileDecoGetRsp, 33);
    }
    paramJceOutputStream.write(this.user_type, 34);
    if (this.vipurl != null) {
      paramJceOutputStream.write(this.vipurl, 35);
    }
    paramJceOutputStream.write(this.follow_num, 36);
    paramJceOutputStream.write(this.show_menu_panel, 37);
    paramJceOutputStream.write(this.fans_limit, 38);
    paramJceOutputStream.write(this.brand_flag, 39);
    if (this.space_desc != null) {
      paramJceOutputStream.write(this.space_desc, 40);
    }
    if (this.weishi_schema != null) {
      paramJceOutputStream.write(this.weishi_schema, 41);
    }
    paramJceOutputStream.write(this.vip_keepdays, 42);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_profile
 * JD-Core Version:    0.7.0.1
 */