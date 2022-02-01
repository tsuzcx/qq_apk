package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqGetEncounterV2
  extends JceStruct
{
  static byte[] cache_appoint_params;
  static int cache_eNewListType;
  static byte[] cache_nearbyGroupReq;
  static byte[] cache_nearbyPublicAcctReq;
  static int cache_neighbor_list_source = 0;
  static ReqUserInfo cache_stLocalUserInfo;
  static UserData cache_stUserData;
  static ReqUserInfo cache_stUserInfo = new ReqUserInfo();
  static byte[] cache_strA2;
  static ArrayList<Long> cache_vTagsID;
  public long ad_ctrl = 0L;
  public String ad_extra = "";
  public byte age_lower = 0;
  public byte age_up = 0;
  public byte[] appoint_params = null;
  public byte bTraversing = 0;
  public byte constellation = 0;
  public int eNewListType = 0;
  public byte encrypt_proto = 0;
  public int home_city = 0;
  public int home_country = 0;
  public int home_province = 0;
  public int iListSize = -1;
  public int iMaxSearchNum = -1;
  public int iRadius = 2000;
  public int iSimpleSort = 0;
  public byte interest_id = 0;
  public int is_new_user = 0;
  public long last_color_time = 0L;
  public byte near_rank_list_num = 4;
  public byte[] nearbyGroupReq = null;
  public byte[] nearbyPublicAcctReq = null;
  public int neighbor_list_source = 0;
  public int profession_id = 0;
  public int random_trav_dis_level = 0;
  public ReqUserInfo stLocalUserInfo = null;
  public UserData stUserData = null;
  public ReqUserInfo stUserInfo = null;
  public byte[] strA2 = null;
  public long sub_interest_id = 0L;
  public int support_entrace_type = 0;
  public int time_interval = 480;
  public byte use_tinyid = 0;
  public byte use_watch = 0;
  public ArrayList<Long> vTagsID = null;
  public byte watch_color = 0;
  
  static
  {
    cache_stUserData = new UserData();
    cache_eNewListType = 0;
    cache_vTagsID = new ArrayList();
    cache_vTagsID.add(Long.valueOf(0L));
    cache_strA2 = (byte[])new byte[1];
    ((byte[])cache_strA2)[0] = 0;
    cache_nearbyGroupReq = (byte[])new byte[1];
    ((byte[])cache_nearbyGroupReq)[0] = 0;
    cache_nearbyPublicAcctReq = (byte[])new byte[1];
    ((byte[])cache_nearbyPublicAcctReq)[0] = 0;
    cache_stLocalUserInfo = new ReqUserInfo();
    cache_appoint_params = (byte[])new byte[1];
    ((byte[])cache_appoint_params)[0] = 0;
  }
  
  public ReqGetEncounterV2() {}
  
  public ReqGetEncounterV2(ReqUserInfo paramReqUserInfo1, UserData paramUserData, int paramInt1, int paramInt2, ArrayList<Long> paramArrayList, byte[] paramArrayOfByte1, byte paramByte1, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt6, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte paramByte6, int paramInt11, ReqUserInfo paramReqUserInfo2, int paramInt12, byte[] paramArrayOfByte4, byte paramByte7, byte paramByte8, byte paramByte9, String paramString, long paramLong1, long paramLong2, byte paramByte10, int paramInt13, int paramInt14, long paramLong3)
  {
    this.stUserInfo = paramReqUserInfo1;
    this.stUserData = paramUserData;
    this.eNewListType = paramInt1;
    this.iListSize = paramInt2;
    this.vTagsID = paramArrayList;
    this.strA2 = paramArrayOfByte1;
    this.bTraversing = paramByte1;
    this.iRadius = paramInt3;
    this.iMaxSearchNum = paramInt4;
    this.iSimpleSort = paramInt5;
    this.nearbyGroupReq = paramArrayOfByte2;
    this.nearbyPublicAcctReq = paramArrayOfByte3;
    this.random_trav_dis_level = paramInt6;
    this.encrypt_proto = paramByte2;
    this.constellation = paramByte3;
    this.age_lower = paramByte4;
    this.age_up = paramByte5;
    this.time_interval = paramInt7;
    this.profession_id = paramInt8;
    this.home_province = paramInt9;
    this.home_city = paramInt10;
    this.use_tinyid = paramByte6;
    this.home_country = paramInt11;
    this.stLocalUserInfo = paramReqUserInfo2;
    this.support_entrace_type = paramInt12;
    this.appoint_params = paramArrayOfByte4;
    this.use_watch = paramByte7;
    this.watch_color = paramByte8;
    this.interest_id = paramByte9;
    this.ad_extra = paramString;
    this.ad_ctrl = paramLong1;
    this.last_color_time = paramLong2;
    this.near_rank_list_num = paramByte10;
    this.is_new_user = paramInt13;
    this.neighbor_list_source = paramInt14;
    this.sub_interest_id = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 1, true));
    this.eNewListType = paramJceInputStream.read(this.eNewListType, 2, false);
    this.iListSize = paramJceInputStream.read(this.iListSize, 3, false);
    this.vTagsID = ((ArrayList)paramJceInputStream.read(cache_vTagsID, 4, false));
    this.strA2 = ((byte[])paramJceInputStream.read(cache_strA2, 5, false));
    this.bTraversing = paramJceInputStream.read(this.bTraversing, 6, false);
    this.iRadius = paramJceInputStream.read(this.iRadius, 7, false);
    this.iMaxSearchNum = paramJceInputStream.read(this.iMaxSearchNum, 8, false);
    this.iSimpleSort = paramJceInputStream.read(this.iSimpleSort, 9, false);
    this.nearbyGroupReq = ((byte[])paramJceInputStream.read(cache_nearbyGroupReq, 10, false));
    this.nearbyPublicAcctReq = ((byte[])paramJceInputStream.read(cache_nearbyPublicAcctReq, 11, false));
    this.random_trav_dis_level = paramJceInputStream.read(this.random_trav_dis_level, 12, false);
    this.encrypt_proto = paramJceInputStream.read(this.encrypt_proto, 13, false);
    this.constellation = paramJceInputStream.read(this.constellation, 14, false);
    this.age_lower = paramJceInputStream.read(this.age_lower, 15, false);
    this.age_up = paramJceInputStream.read(this.age_up, 16, false);
    this.time_interval = paramJceInputStream.read(this.time_interval, 17, false);
    this.profession_id = paramJceInputStream.read(this.profession_id, 18, false);
    this.home_province = paramJceInputStream.read(this.home_province, 19, false);
    this.home_city = paramJceInputStream.read(this.home_city, 20, false);
    this.use_tinyid = paramJceInputStream.read(this.use_tinyid, 21, false);
    this.home_country = paramJceInputStream.read(this.home_country, 22, false);
    this.stLocalUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stLocalUserInfo, 23, false));
    this.support_entrace_type = paramJceInputStream.read(this.support_entrace_type, 24, false);
    this.appoint_params = ((byte[])paramJceInputStream.read(cache_appoint_params, 25, false));
    this.use_watch = paramJceInputStream.read(this.use_watch, 26, false);
    this.watch_color = paramJceInputStream.read(this.watch_color, 27, false);
    this.interest_id = paramJceInputStream.read(this.interest_id, 28, false);
    this.ad_extra = paramJceInputStream.readString(29, false);
    this.ad_ctrl = paramJceInputStream.read(this.ad_ctrl, 30, false);
    this.last_color_time = paramJceInputStream.read(this.last_color_time, 31, false);
    this.near_rank_list_num = paramJceInputStream.read(this.near_rank_list_num, 32, false);
    this.is_new_user = paramJceInputStream.read(this.is_new_user, 33, false);
    this.neighbor_list_source = paramJceInputStream.read(this.neighbor_list_source, 34, false);
    this.sub_interest_id = paramJceInputStream.read(this.sub_interest_id, 35, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.stUserData, 1);
    paramJceOutputStream.write(this.eNewListType, 2);
    paramJceOutputStream.write(this.iListSize, 3);
    if (this.vTagsID != null) {
      paramJceOutputStream.write(this.vTagsID, 4);
    }
    if (this.strA2 != null) {
      paramJceOutputStream.write(this.strA2, 5);
    }
    paramJceOutputStream.write(this.bTraversing, 6);
    paramJceOutputStream.write(this.iRadius, 7);
    paramJceOutputStream.write(this.iMaxSearchNum, 8);
    paramJceOutputStream.write(this.iSimpleSort, 9);
    if (this.nearbyGroupReq != null) {
      paramJceOutputStream.write(this.nearbyGroupReq, 10);
    }
    if (this.nearbyPublicAcctReq != null) {
      paramJceOutputStream.write(this.nearbyPublicAcctReq, 11);
    }
    paramJceOutputStream.write(this.random_trav_dis_level, 12);
    paramJceOutputStream.write(this.encrypt_proto, 13);
    paramJceOutputStream.write(this.constellation, 14);
    paramJceOutputStream.write(this.age_lower, 15);
    paramJceOutputStream.write(this.age_up, 16);
    paramJceOutputStream.write(this.time_interval, 17);
    paramJceOutputStream.write(this.profession_id, 18);
    paramJceOutputStream.write(this.home_province, 19);
    paramJceOutputStream.write(this.home_city, 20);
    paramJceOutputStream.write(this.use_tinyid, 21);
    paramJceOutputStream.write(this.home_country, 22);
    if (this.stLocalUserInfo != null) {
      paramJceOutputStream.write(this.stLocalUserInfo, 23);
    }
    paramJceOutputStream.write(this.support_entrace_type, 24);
    if (this.appoint_params != null) {
      paramJceOutputStream.write(this.appoint_params, 25);
    }
    paramJceOutputStream.write(this.use_watch, 26);
    paramJceOutputStream.write(this.watch_color, 27);
    paramJceOutputStream.write(this.interest_id, 28);
    if (this.ad_extra != null) {
      paramJceOutputStream.write(this.ad_extra, 29);
    }
    paramJceOutputStream.write(this.ad_ctrl, 30);
    paramJceOutputStream.write(this.last_color_time, 31);
    paramJceOutputStream.write(this.near_rank_list_num, 32);
    paramJceOutputStream.write(this.is_new_user, 33);
    paramJceOutputStream.write(this.neighbor_list_source, 34);
    paramJceOutputStream.write(this.sub_interest_id, 35);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     EncounterSvc.ReqGetEncounterV2
 * JD-Core Version:    0.7.0.1
 */