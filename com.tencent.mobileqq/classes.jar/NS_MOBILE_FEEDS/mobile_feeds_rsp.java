package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feeds_rsp
  extends JceStruct
{
  static ArrayList<single_feed> cache_all_feeds_data = new ArrayList();
  static Map<Integer, String> cache_extendinfo;
  static s_cover cache_host_cover;
  static Map<String, String> cache_kitfileData;
  static login_uin_info cache_loginuin_info;
  static Map<Integer, UnifyRecomStruct> cache_mapRecomUnifyList;
  static st_prefetch cache_prefetch_rsp;
  static Map<Integer, String> cache_rank_param;
  static FunnySpace cache_stFunnySpace;
  static s_join_list cache_stJoinList;
  static s_life_moment cache_stLifeMemntInfo;
  static Map<String, String> cache_stMapExtendinfo;
  static s_memory_seal_off cache_stMemoryInfo;
  static s_profile_timeline cache_stProfileTimeLine;
  static byte[] cache_stShangchengInfo;
  static interest_list cache_uin_info;
  public ArrayList<single_feed> all_feeds_data;
  public String attach_info = "";
  public int auto_load;
  public boolean bPsvOpenKapu = true;
  public int dailyShuoShuoCount;
  public Map<Integer, String> extendinfo;
  public int gamebar_video_checking_num;
  public int hasmore;
  public s_cover host_cover;
  public long host_imbitmap;
  public long iFollowNum;
  public int is_detail_report;
  public int is_realname_succ;
  public Map<String, String> kitfileData;
  public login_uin_info loginuin_info;
  public Map<Integer, UnifyRecomStruct> mapRecomUnifyList;
  public int network_report = 1;
  public long newcount;
  public long next_keep_alive_time;
  public int no_update;
  public st_prefetch prefetch_rsp;
  public Map<Integer, String> rank_param;
  public long req_count;
  public FunnySpace stFunnySpace;
  public s_join_list stJoinList;
  public s_life_moment stLifeMemntInfo;
  public Map<String, String> stMapExtendinfo;
  public s_memory_seal_off stMemoryInfo;
  public s_profile_timeline stProfileTimeLine;
  public byte[] stShangchengInfo;
  public interest_list uin_info;
  public int undealFeedCount;
  public String undealFeedTime = "";
  public String user_sid = "";
  
  static
  {
    Object localObject = new single_feed();
    cache_all_feeds_data.add(localObject);
    cache_prefetch_rsp = new st_prefetch();
    cache_host_cover = new s_cover();
    cache_uin_info = new interest_list();
    cache_loginuin_info = new login_uin_info();
    cache_extendinfo = new HashMap();
    cache_extendinfo.put(Integer.valueOf(0), "");
    cache_stMapExtendinfo = new HashMap();
    cache_stMapExtendinfo.put("", "");
    cache_stProfileTimeLine = new s_profile_timeline();
    cache_stJoinList = new s_join_list();
    cache_mapRecomUnifyList = new HashMap();
    localObject = new UnifyRecomStruct();
    cache_mapRecomUnifyList.put(Integer.valueOf(0), localObject);
    cache_stMemoryInfo = new s_memory_seal_off();
    cache_kitfileData = new HashMap();
    cache_kitfileData.put("", "");
    cache_stLifeMemntInfo = new s_life_moment();
    cache_rank_param = new HashMap();
    cache_rank_param.put(Integer.valueOf(0), "");
    cache_stFunnySpace = new FunnySpace();
    cache_stShangchengInfo = (byte[])new byte[1];
    ((byte[])cache_stShangchengInfo)[0] = 0;
  }
  
  public mobile_feeds_rsp() {}
  
  public mobile_feeds_rsp(int paramInt1, String paramString1, ArrayList<single_feed> paramArrayList, long paramLong1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, String paramString2, st_prefetch paramst_prefetch, int paramInt4, s_cover params_cover, interest_list paraminterest_list, int paramInt5, login_uin_info paramlogin_uin_info, Map<Integer, String> paramMap1, int paramInt6, int paramInt7, String paramString3, Map<String, String> paramMap2, int paramInt8, s_profile_timeline params_profile_timeline, long paramLong5, s_join_list params_join_list, Map<Integer, UnifyRecomStruct> paramMap, s_memory_seal_off params_memory_seal_off, Map<String, String> paramMap3, s_life_moment params_life_moment, Map<Integer, String> paramMap4, FunnySpace paramFunnySpace, byte[] paramArrayOfByte, int paramInt9, boolean paramBoolean)
  {
    this.hasmore = paramInt1;
    this.attach_info = paramString1;
    this.all_feeds_data = paramArrayList;
    this.newcount = paramLong1;
    this.auto_load = paramInt2;
    this.no_update = paramInt3;
    this.req_count = paramLong2;
    this.iFollowNum = paramLong3;
    this.host_imbitmap = paramLong4;
    this.user_sid = paramString2;
    this.prefetch_rsp = paramst_prefetch;
    this.is_realname_succ = paramInt4;
    this.host_cover = params_cover;
    this.uin_info = paraminterest_list;
    this.gamebar_video_checking_num = paramInt5;
    this.loginuin_info = paramlogin_uin_info;
    this.extendinfo = paramMap1;
    this.is_detail_report = paramInt6;
    this.network_report = paramInt7;
    this.undealFeedTime = paramString3;
    this.stMapExtendinfo = paramMap2;
    this.undealFeedCount = paramInt8;
    this.stProfileTimeLine = params_profile_timeline;
    this.next_keep_alive_time = paramLong5;
    this.stJoinList = params_join_list;
    this.mapRecomUnifyList = paramMap;
    this.stMemoryInfo = params_memory_seal_off;
    this.kitfileData = paramMap3;
    this.stLifeMemntInfo = params_life_moment;
    this.rank_param = paramMap4;
    this.stFunnySpace = paramFunnySpace;
    this.stShangchengInfo = paramArrayOfByte;
    this.dailyShuoShuoCount = paramInt9;
    this.bPsvOpenKapu = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.attach_info = paramJceInputStream.readString(1, false);
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 2, false));
    this.newcount = paramJceInputStream.read(this.newcount, 3, false);
    this.auto_load = paramJceInputStream.read(this.auto_load, 4, false);
    this.no_update = paramJceInputStream.read(this.no_update, 5, false);
    this.req_count = paramJceInputStream.read(this.req_count, 6, false);
    this.iFollowNum = paramJceInputStream.read(this.iFollowNum, 7, false);
    this.host_imbitmap = paramJceInputStream.read(this.host_imbitmap, 8, false);
    this.user_sid = paramJceInputStream.readString(9, false);
    this.prefetch_rsp = ((st_prefetch)paramJceInputStream.read(cache_prefetch_rsp, 10, false));
    this.is_realname_succ = paramJceInputStream.read(this.is_realname_succ, 11, false);
    this.host_cover = ((s_cover)paramJceInputStream.read(cache_host_cover, 12, false));
    this.uin_info = ((interest_list)paramJceInputStream.read(cache_uin_info, 13, false));
    this.gamebar_video_checking_num = paramJceInputStream.read(this.gamebar_video_checking_num, 14, false);
    this.loginuin_info = ((login_uin_info)paramJceInputStream.read(cache_loginuin_info, 15, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 16, false));
    this.is_detail_report = paramJceInputStream.read(this.is_detail_report, 17, false);
    this.network_report = paramJceInputStream.read(this.network_report, 18, false);
    this.undealFeedTime = paramJceInputStream.readString(19, false);
    this.stMapExtendinfo = ((Map)paramJceInputStream.read(cache_stMapExtendinfo, 20, false));
    this.undealFeedCount = paramJceInputStream.read(this.undealFeedCount, 21, false);
    this.stProfileTimeLine = ((s_profile_timeline)paramJceInputStream.read(cache_stProfileTimeLine, 22, false));
    this.next_keep_alive_time = paramJceInputStream.read(this.next_keep_alive_time, 23, false);
    this.stJoinList = ((s_join_list)paramJceInputStream.read(cache_stJoinList, 24, false));
    this.mapRecomUnifyList = ((Map)paramJceInputStream.read(cache_mapRecomUnifyList, 25, false));
    this.stMemoryInfo = ((s_memory_seal_off)paramJceInputStream.read(cache_stMemoryInfo, 26, false));
    this.kitfileData = ((Map)paramJceInputStream.read(cache_kitfileData, 27, false));
    this.stLifeMemntInfo = ((s_life_moment)paramJceInputStream.read(cache_stLifeMemntInfo, 28, false));
    this.rank_param = ((Map)paramJceInputStream.read(cache_rank_param, 29, false));
    this.stFunnySpace = ((FunnySpace)paramJceInputStream.read(cache_stFunnySpace, 30, false));
    this.stShangchengInfo = ((byte[])paramJceInputStream.read(cache_stShangchengInfo, 31, false));
    this.dailyShuoShuoCount = paramJceInputStream.read(this.dailyShuoShuoCount, 32, false);
    this.bPsvOpenKapu = paramJceInputStream.read(this.bPsvOpenKapu, 33, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 1);
    }
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 2);
    }
    paramJceOutputStream.write(this.newcount, 3);
    paramJceOutputStream.write(this.auto_load, 4);
    paramJceOutputStream.write(this.no_update, 5);
    paramJceOutputStream.write(this.req_count, 6);
    paramJceOutputStream.write(this.iFollowNum, 7);
    paramJceOutputStream.write(this.host_imbitmap, 8);
    if (this.user_sid != null) {
      paramJceOutputStream.write(this.user_sid, 9);
    }
    if (this.prefetch_rsp != null) {
      paramJceOutputStream.write(this.prefetch_rsp, 10);
    }
    paramJceOutputStream.write(this.is_realname_succ, 11);
    if (this.host_cover != null) {
      paramJceOutputStream.write(this.host_cover, 12);
    }
    if (this.uin_info != null) {
      paramJceOutputStream.write(this.uin_info, 13);
    }
    paramJceOutputStream.write(this.gamebar_video_checking_num, 14);
    if (this.loginuin_info != null) {
      paramJceOutputStream.write(this.loginuin_info, 15);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 16);
    }
    paramJceOutputStream.write(this.is_detail_report, 17);
    paramJceOutputStream.write(this.network_report, 18);
    if (this.undealFeedTime != null) {
      paramJceOutputStream.write(this.undealFeedTime, 19);
    }
    if (this.stMapExtendinfo != null) {
      paramJceOutputStream.write(this.stMapExtendinfo, 20);
    }
    paramJceOutputStream.write(this.undealFeedCount, 21);
    if (this.stProfileTimeLine != null) {
      paramJceOutputStream.write(this.stProfileTimeLine, 22);
    }
    paramJceOutputStream.write(this.next_keep_alive_time, 23);
    if (this.stJoinList != null) {
      paramJceOutputStream.write(this.stJoinList, 24);
    }
    if (this.mapRecomUnifyList != null) {
      paramJceOutputStream.write(this.mapRecomUnifyList, 25);
    }
    if (this.stMemoryInfo != null) {
      paramJceOutputStream.write(this.stMemoryInfo, 26);
    }
    if (this.kitfileData != null) {
      paramJceOutputStream.write(this.kitfileData, 27);
    }
    if (this.stLifeMemntInfo != null) {
      paramJceOutputStream.write(this.stLifeMemntInfo, 28);
    }
    if (this.rank_param != null) {
      paramJceOutputStream.write(this.rank_param, 29);
    }
    if (this.stFunnySpace != null) {
      paramJceOutputStream.write(this.stFunnySpace, 30);
    }
    if (this.stShangchengInfo != null) {
      paramJceOutputStream.write(this.stShangchengInfo, 31);
    }
    paramJceOutputStream.write(this.dailyShuoShuoCount, 32);
    paramJceOutputStream.write(this.bPsvOpenKapu, 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */