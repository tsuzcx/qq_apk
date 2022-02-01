package NS_UNDEAL_COUNT;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class mobile_count_rsp_new
  extends JceStruct
{
  static byte[] cache_QzmallProfileDecoGetRsp;
  static int cache_cancellation_status;
  static Map<Integer, String> cache_extendinfo;
  static int cache_isShowNewFeedBanner;
  static int cache_jumpType;
  static Map<String, byte[]> cache_mapAutoTransData;
  static Map<Long, s_comm_data> cache_mapBuf;
  static Map<Long, Long> cache_mapDyncShowTime;
  static Map<Integer, ArrayList<entrance_cfg>> cache_mapEntranceCfg = new HashMap();
  static Map<String, String> cache_mapExtendinfo;
  static Map<Integer, mobile_feeds_tab_info> cache_mapFeedsTabInfo;
  static Map<Long, Long> cache_mapLastGetTime;
  static Map<String, byte[]> cache_mapTransData;
  static Map<Integer, yy_icon> cache_mapYYIconInfo;
  static Map<Integer, String> cache_map_strAdvUrl;
  static master_info cache_masterinfo;
  static stPlusRecomInfo cache_plusRecom;
  static stNuanNuanComment cache_sContentOpComment;
  static stNuanNuanComment cache_snnComment;
  static ban_info cache_stBanInfo;
  static birth_info cache_stBirthInfo;
  static Map<Integer, count_info> cache_stMapCountInfo;
  static master_info cache_stMasterInfo;
  static medal_banner cache_stMedalBanner;
  static medal_info cache_stMedalInfo;
  static yellow_info cache_stYellowInfo;
  static combine_diamond_info cache_stuCombineDiamondInfo;
  static star_info cache_stuStarInfo;
  static ArrayList<operat_data> cache_vecOperateInfo;
  static ArrayList<String> cache_vec_blackReportPid;
  static ArrayList<String> cache_vec_reportid;
  static ArrayList<stSoftInfo> cache_vec_soft_infos;
  static ArrayList<String> cache_veckuolieHotTag;
  static stVerticalVideoDisplay cache_vertVideoDisplay;
  public byte[] QzmallProfileDecoGetRsp = null;
  public int cancellation_status = 0;
  public Map<Integer, String> extendinfo = null;
  public int grayOperateMask = 0;
  public int iNextTimeout = 0;
  public int isGetActiveWeiShi = 50;
  public int isLiveShow = 0;
  public int isNotRegisterQzone = 0;
  public int isOpenFeedUpdate = 0;
  public int isPlusRedBous = 0;
  public int isPreLoad = 0;
  public int isSetMemorySeal = 0;
  public int isShowNewFeedBanner = 0;
  public int isShowNewStyles = 0;
  public int isUpdateFeed = 0;
  public int isVistorRedBous = 0;
  public int jumpType = 0;
  public Map<String, byte[]> mapAutoTransData = null;
  public Map<Long, s_comm_data> mapBuf = null;
  public Map<Long, Long> mapDyncShowTime = null;
  public Map<Integer, ArrayList<entrance_cfg>> mapEntranceCfg = null;
  public Map<String, String> mapExtendinfo = null;
  public Map<Integer, mobile_feeds_tab_info> mapFeedsTabInfo = null;
  public Map<Long, Long> mapLastGetTime = null;
  public Map<String, byte[]> mapTransData = null;
  public Map<Integer, yy_icon> mapYYIconInfo = null;
  public Map<Integer, String> map_strAdvUrl = null;
  public master_info masterinfo = null;
  public int operate_nbp_type = 0;
  public int operate_newyear_mask = 0;
  public stPlusRecomInfo plusRecom = null;
  public int report_counts = 0;
  public int report_nexttime = 0;
  public int report_sq_switch = 0;
  public stNuanNuanComment sContentOpComment = null;
  public String sTransParam = "";
  public stNuanNuanComment snnComment = null;
  public String sqDyncFeedsJson = "";
  public ban_info stBanInfo = null;
  public birth_info stBirthInfo = null;
  public Map<Integer, count_info> stMapCountInfo = null;
  public master_info stMasterInfo = null;
  public medal_banner stMedalBanner = null;
  public medal_info stMedalInfo = null;
  public yellow_info stYellowInfo = null;
  public String strABTestId = "";
  public String strDeviceName = "";
  public String strNick = "";
  public String strRedBousUrl = "";
  public combine_diamond_info stuCombineDiamondInfo = null;
  public star_info stuStarInfo = null;
  public int switchTimeout = 0;
  public String undealCountTime = "";
  public ArrayList<operat_data> vecOperateInfo = null;
  public ArrayList<String> vec_blackReportPid = null;
  public ArrayList<String> vec_reportid = null;
  public ArrayList<stSoftInfo> vec_soft_infos = null;
  public ArrayList<String> veckuolieHotTag = null;
  public stVerticalVideoDisplay vertVideoDisplay = null;
  
  static
  {
    Object localObject1 = Integer.valueOf(0);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new entrance_cfg());
    cache_mapEntranceCfg.put(localObject1, localObject2);
    cache_stMapCountInfo = new HashMap();
    localObject2 = new count_info();
    cache_stMapCountInfo.put(localObject1, localObject2);
    cache_stBanInfo = new ban_info();
    cache_stBirthInfo = new birth_info();
    cache_stYellowInfo = new yellow_info();
    cache_mapBuf = new HashMap();
    localObject2 = Long.valueOf(0L);
    Object localObject3 = new s_comm_data();
    cache_mapBuf.put(localObject2, localObject3);
    cache_masterinfo = new master_info();
    cache_vecOperateInfo = new ArrayList();
    localObject3 = new operat_data();
    cache_vecOperateInfo.add(localObject3);
    cache_mapLastGetTime = new HashMap();
    cache_mapLastGetTime.put(localObject2, localObject2);
    cache_stMasterInfo = new master_info();
    cache_stMedalInfo = new medal_info();
    cache_jumpType = 0;
    cache_stMedalBanner = new medal_banner();
    cache_mapYYIconInfo = new HashMap();
    localObject3 = new yy_icon();
    cache_mapYYIconInfo.put(localObject1, localObject3);
    cache_stuStarInfo = new star_info();
    cache_stuCombineDiamondInfo = new combine_diamond_info();
    cache_extendinfo = new HashMap();
    cache_extendinfo.put(localObject1, "");
    cache_QzmallProfileDecoGetRsp = (byte[])new byte[1];
    ((byte[])cache_QzmallProfileDecoGetRsp)[0] = 0;
    cache_isShowNewFeedBanner = 0;
    cache_mapFeedsTabInfo = new HashMap();
    localObject3 = new mobile_feeds_tab_info();
    cache_mapFeedsTabInfo.put(localObject1, localObject3);
    cache_map_strAdvUrl = new HashMap();
    cache_map_strAdvUrl.put(localObject1, "");
    cache_mapTransData = new HashMap();
    localObject1 = (byte[])new byte[1];
    ((byte[])localObject1)[0] = 0;
    cache_mapTransData.put("", localObject1);
    cache_mapExtendinfo = new HashMap();
    cache_mapExtendinfo.put("", "");
    cache_vertVideoDisplay = new stVerticalVideoDisplay();
    cache_snnComment = new stNuanNuanComment();
    cache_mapDyncShowTime = new HashMap();
    cache_mapDyncShowTime.put(localObject2, localObject2);
    cache_vec_reportid = new ArrayList();
    cache_vec_reportid.add("");
    cache_vec_blackReportPid = new ArrayList();
    cache_vec_blackReportPid.add("");
    cache_sContentOpComment = new stNuanNuanComment();
    cache_vec_soft_infos = new ArrayList();
    localObject1 = new stSoftInfo();
    cache_vec_soft_infos.add(localObject1);
    cache_plusRecom = new stPlusRecomInfo();
    cache_cancellation_status = 0;
    cache_veckuolieHotTag = new ArrayList();
    cache_veckuolieHotTag.add("");
    cache_mapAutoTransData = new HashMap();
    localObject1 = (byte[])new byte[1];
    ((byte[])localObject1)[0] = 0;
    cache_mapAutoTransData.put("", localObject1);
  }
  
  public mobile_count_rsp_new() {}
  
  public mobile_count_rsp_new(Map<Integer, ArrayList<entrance_cfg>> paramMap, Map<Integer, count_info> paramMap1, ban_info paramban_info, birth_info parambirth_info, String paramString1, int paramInt1, yellow_info paramyellow_info, String paramString2, Map<Long, s_comm_data> paramMap2, master_info parammaster_info1, ArrayList<operat_data> paramArrayList, Map<Long, Long> paramMap3, String paramString3, master_info parammaster_info2, medal_info parammedal_info, int paramInt2, medal_banner parammedal_banner, Map<Integer, yy_icon> paramMap4, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info, Map<Integer, String> paramMap5, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7, int paramInt8, int paramInt9, String paramString5, int paramInt10, int paramInt11, int paramInt12, Map<Integer, mobile_feeds_tab_info> paramMap6, int paramInt13, String paramString6, Map<Integer, String> paramMap7, Map<String, byte[]> paramMap8, Map<String, String> paramMap9, int paramInt14, stVerticalVideoDisplay paramstVerticalVideoDisplay, int paramInt15, stNuanNuanComment paramstNuanNuanComment1, Map<Long, Long> paramMap10, int paramInt16, String paramString7, int paramInt17, ArrayList<String> paramArrayList1, int paramInt18, int paramInt19, int paramInt20, ArrayList<String> paramArrayList2, stNuanNuanComment paramstNuanNuanComment2, ArrayList<stSoftInfo> paramArrayList3, stPlusRecomInfo paramstPlusRecomInfo, int paramInt21, ArrayList<String> paramArrayList4, Map<String, byte[]> paramMap11)
  {
    this.mapEntranceCfg = paramMap;
    this.stMapCountInfo = paramMap1;
    this.stBanInfo = paramban_info;
    this.stBirthInfo = parambirth_info;
    this.strNick = paramString1;
    this.iNextTimeout = paramInt1;
    this.stYellowInfo = paramyellow_info;
    this.strDeviceName = paramString2;
    this.mapBuf = paramMap2;
    this.masterinfo = parammaster_info1;
    this.vecOperateInfo = paramArrayList;
    this.mapLastGetTime = paramMap3;
    this.sTransParam = paramString3;
    this.stMasterInfo = parammaster_info2;
    this.stMedalInfo = parammedal_info;
    this.jumpType = paramInt2;
    this.stMedalBanner = parammedal_banner;
    this.mapYYIconInfo = paramMap4;
    this.stuStarInfo = paramstar_info;
    this.stuCombineDiamondInfo = paramcombine_diamond_info;
    this.extendinfo = paramMap5;
    this.undealCountTime = paramString4;
    this.isPreLoad = paramInt3;
    this.switchTimeout = paramInt4;
    this.isLiveShow = paramInt5;
    this.isShowNewStyles = paramInt6;
    this.QzmallProfileDecoGetRsp = paramArrayOfByte;
    this.isShowNewFeedBanner = paramInt7;
    this.isPlusRedBous = paramInt8;
    this.isVistorRedBous = paramInt9;
    this.strRedBousUrl = paramString5;
    this.isSetMemorySeal = paramInt10;
    this.isNotRegisterQzone = paramInt11;
    this.isOpenFeedUpdate = paramInt12;
    this.mapFeedsTabInfo = paramMap6;
    this.isUpdateFeed = paramInt13;
    this.sqDyncFeedsJson = paramString6;
    this.map_strAdvUrl = paramMap7;
    this.mapTransData = paramMap8;
    this.mapExtendinfo = paramMap9;
    this.grayOperateMask = paramInt14;
    this.vertVideoDisplay = paramstVerticalVideoDisplay;
    this.isGetActiveWeiShi = paramInt15;
    this.snnComment = paramstNuanNuanComment1;
    this.mapDyncShowTime = paramMap10;
    this.operate_newyear_mask = paramInt16;
    this.strABTestId = paramString7;
    this.operate_nbp_type = paramInt17;
    this.vec_reportid = paramArrayList1;
    this.report_nexttime = paramInt18;
    this.report_counts = paramInt19;
    this.report_sq_switch = paramInt20;
    this.vec_blackReportPid = paramArrayList2;
    this.sContentOpComment = paramstNuanNuanComment2;
    this.vec_soft_infos = paramArrayList3;
    this.plusRecom = paramstPlusRecomInfo;
    this.cancellation_status = paramInt21;
    this.veckuolieHotTag = paramArrayList4;
    this.mapAutoTransData = paramMap11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapEntranceCfg = ((Map)paramJceInputStream.read(cache_mapEntranceCfg, 0, false));
    this.stMapCountInfo = ((Map)paramJceInputStream.read(cache_stMapCountInfo, 1, false));
    this.stBanInfo = ((ban_info)paramJceInputStream.read(cache_stBanInfo, 2, false));
    this.stBirthInfo = ((birth_info)paramJceInputStream.read(cache_stBirthInfo, 3, false));
    this.strNick = paramJceInputStream.readString(4, false);
    this.iNextTimeout = paramJceInputStream.read(this.iNextTimeout, 5, false);
    this.stYellowInfo = ((yellow_info)paramJceInputStream.read(cache_stYellowInfo, 6, false));
    this.strDeviceName = paramJceInputStream.readString(7, false);
    this.mapBuf = ((Map)paramJceInputStream.read(cache_mapBuf, 8, false));
    this.masterinfo = ((master_info)paramJceInputStream.read(cache_masterinfo, 9, false));
    this.vecOperateInfo = ((ArrayList)paramJceInputStream.read(cache_vecOperateInfo, 10, false));
    this.mapLastGetTime = ((Map)paramJceInputStream.read(cache_mapLastGetTime, 11, false));
    this.sTransParam = paramJceInputStream.readString(12, false);
    this.stMasterInfo = ((master_info)paramJceInputStream.read(cache_stMasterInfo, 13, false));
    this.stMedalInfo = ((medal_info)paramJceInputStream.read(cache_stMedalInfo, 14, false));
    this.jumpType = paramJceInputStream.read(this.jumpType, 15, false);
    this.stMedalBanner = ((medal_banner)paramJceInputStream.read(cache_stMedalBanner, 16, false));
    this.mapYYIconInfo = ((Map)paramJceInputStream.read(cache_mapYYIconInfo, 17, false));
    this.stuStarInfo = ((star_info)paramJceInputStream.read(cache_stuStarInfo, 18, false));
    this.stuCombineDiamondInfo = ((combine_diamond_info)paramJceInputStream.read(cache_stuCombineDiamondInfo, 19, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 20, false));
    this.undealCountTime = paramJceInputStream.readString(21, false);
    this.isPreLoad = paramJceInputStream.read(this.isPreLoad, 22, false);
    this.switchTimeout = paramJceInputStream.read(this.switchTimeout, 23, false);
    this.isLiveShow = paramJceInputStream.read(this.isLiveShow, 24, false);
    this.isShowNewStyles = paramJceInputStream.read(this.isShowNewStyles, 25, false);
    this.QzmallProfileDecoGetRsp = ((byte[])paramJceInputStream.read(cache_QzmallProfileDecoGetRsp, 26, false));
    this.isShowNewFeedBanner = paramJceInputStream.read(this.isShowNewFeedBanner, 27, false);
    this.isPlusRedBous = paramJceInputStream.read(this.isPlusRedBous, 28, false);
    this.isVistorRedBous = paramJceInputStream.read(this.isVistorRedBous, 29, false);
    this.strRedBousUrl = paramJceInputStream.readString(30, false);
    this.isSetMemorySeal = paramJceInputStream.read(this.isSetMemorySeal, 31, false);
    this.isNotRegisterQzone = paramJceInputStream.read(this.isNotRegisterQzone, 32, false);
    this.isOpenFeedUpdate = paramJceInputStream.read(this.isOpenFeedUpdate, 33, false);
    this.mapFeedsTabInfo = ((Map)paramJceInputStream.read(cache_mapFeedsTabInfo, 34, false));
    this.isUpdateFeed = paramJceInputStream.read(this.isUpdateFeed, 35, false);
    this.sqDyncFeedsJson = paramJceInputStream.readString(36, false);
    this.map_strAdvUrl = ((Map)paramJceInputStream.read(cache_map_strAdvUrl, 37, false));
    this.mapTransData = ((Map)paramJceInputStream.read(cache_mapTransData, 38, false));
    this.mapExtendinfo = ((Map)paramJceInputStream.read(cache_mapExtendinfo, 39, false));
    this.grayOperateMask = paramJceInputStream.read(this.grayOperateMask, 40, false);
    this.vertVideoDisplay = ((stVerticalVideoDisplay)paramJceInputStream.read(cache_vertVideoDisplay, 41, false));
    this.isGetActiveWeiShi = paramJceInputStream.read(this.isGetActiveWeiShi, 42, false);
    this.snnComment = ((stNuanNuanComment)paramJceInputStream.read(cache_snnComment, 43, false));
    this.mapDyncShowTime = ((Map)paramJceInputStream.read(cache_mapDyncShowTime, 44, false));
    this.operate_newyear_mask = paramJceInputStream.read(this.operate_newyear_mask, 45, false);
    this.strABTestId = paramJceInputStream.readString(46, false);
    this.operate_nbp_type = paramJceInputStream.read(this.operate_nbp_type, 47, false);
    this.vec_reportid = ((ArrayList)paramJceInputStream.read(cache_vec_reportid, 48, false));
    this.report_nexttime = paramJceInputStream.read(this.report_nexttime, 49, false);
    this.report_counts = paramJceInputStream.read(this.report_counts, 50, false);
    this.report_sq_switch = paramJceInputStream.read(this.report_sq_switch, 51, false);
    this.vec_blackReportPid = ((ArrayList)paramJceInputStream.read(cache_vec_blackReportPid, 52, false));
    this.sContentOpComment = ((stNuanNuanComment)paramJceInputStream.read(cache_sContentOpComment, 53, false));
    this.vec_soft_infos = ((ArrayList)paramJceInputStream.read(cache_vec_soft_infos, 54, false));
    this.plusRecom = ((stPlusRecomInfo)paramJceInputStream.read(cache_plusRecom, 55, false));
    this.cancellation_status = paramJceInputStream.read(this.cancellation_status, 56, false);
    this.veckuolieHotTag = ((ArrayList)paramJceInputStream.read(cache_veckuolieHotTag, 57, false));
    this.mapAutoTransData = ((Map)paramJceInputStream.read(cache_mapAutoTransData, 58, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.mapEntranceCfg;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 0);
    }
    localObject = this.stMapCountInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.stBanInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.stBirthInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.strNick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.iNextTimeout, 5);
    localObject = this.stYellowInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.strDeviceName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.mapBuf;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    localObject = this.masterinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.vecOperateInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
    }
    localObject = this.mapLastGetTime;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 11);
    }
    localObject = this.sTransParam;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.stMasterInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.stMedalInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    paramJceOutputStream.write(this.jumpType, 15);
    localObject = this.stMedalBanner;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 16);
    }
    localObject = this.mapYYIconInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 17);
    }
    localObject = this.stuStarInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 18);
    }
    localObject = this.stuCombineDiamondInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 19);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 20);
    }
    localObject = this.undealCountTime;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
    paramJceOutputStream.write(this.isPreLoad, 22);
    paramJceOutputStream.write(this.switchTimeout, 23);
    paramJceOutputStream.write(this.isLiveShow, 24);
    paramJceOutputStream.write(this.isShowNewStyles, 25);
    localObject = this.QzmallProfileDecoGetRsp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 26);
    }
    paramJceOutputStream.write(this.isShowNewFeedBanner, 27);
    paramJceOutputStream.write(this.isPlusRedBous, 28);
    paramJceOutputStream.write(this.isVistorRedBous, 29);
    localObject = this.strRedBousUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 30);
    }
    paramJceOutputStream.write(this.isSetMemorySeal, 31);
    paramJceOutputStream.write(this.isNotRegisterQzone, 32);
    paramJceOutputStream.write(this.isOpenFeedUpdate, 33);
    localObject = this.mapFeedsTabInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 34);
    }
    paramJceOutputStream.write(this.isUpdateFeed, 35);
    localObject = this.sqDyncFeedsJson;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 36);
    }
    localObject = this.map_strAdvUrl;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 37);
    }
    localObject = this.mapTransData;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 38);
    }
    localObject = this.mapExtendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 39);
    }
    paramJceOutputStream.write(this.grayOperateMask, 40);
    localObject = this.vertVideoDisplay;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 41);
    }
    paramJceOutputStream.write(this.isGetActiveWeiShi, 42);
    localObject = this.snnComment;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 43);
    }
    localObject = this.mapDyncShowTime;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 44);
    }
    paramJceOutputStream.write(this.operate_newyear_mask, 45);
    localObject = this.strABTestId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 46);
    }
    paramJceOutputStream.write(this.operate_nbp_type, 47);
    localObject = this.vec_reportid;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 48);
    }
    paramJceOutputStream.write(this.report_nexttime, 49);
    paramJceOutputStream.write(this.report_counts, 50);
    paramJceOutputStream.write(this.report_sq_switch, 51);
    localObject = this.vec_blackReportPid;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 52);
    }
    localObject = this.sContentOpComment;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 53);
    }
    localObject = this.vec_soft_infos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 54);
    }
    localObject = this.plusRecom;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 55);
    }
    paramJceOutputStream.write(this.cancellation_status, 56);
    localObject = this.veckuolieHotTag;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 57);
    }
    localObject = this.mapAutoTransData;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 58);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_count_rsp_new
 * JD-Core Version:    0.7.0.1
 */