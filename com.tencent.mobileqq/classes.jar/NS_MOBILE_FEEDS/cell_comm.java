package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.UgcRightInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_comm
  extends JceStruct
{
  static ArrayList<s_droplist_option> cache_custom_droplist;
  static Map<String, String> cache_extendInfo;
  static Map<String, byte[]> cache_extendInfoData;
  static UgcRightInfo cache_right_info = new UgcRightInfo();
  static Map<Integer, Integer> cache_stMapABTest = new HashMap();
  public int actiontype;
  public String actionurl = "";
  public long adv_stytle;
  public long adv_subtype;
  public int appid;
  public String clientkey = "";
  public String curlikekey = "";
  public ArrayList<s_droplist_option> custom_droplist;
  public long editmask = 4294967295L;
  public Map<String, String> extendInfo;
  public Map<String, byte[]> extendInfoData;
  public long feedsDelTime;
  public int feedsattr;
  public int feedsattr2;
  public String feedsid = "";
  public String feedskey = "";
  public int feedstype;
  public int hot_score;
  public int iClick_area = 0;
  public String interestkey = "";
  public boolean is_kuolie;
  public boolean is_stay;
  public int operatemask;
  public int operatemask2;
  public long operatemask3;
  public String orglikekey = "";
  public int originaltype;
  public String paykey = "";
  public int positionmask;
  public int positionmask2;
  public boolean pull_qzone;
  public int recom_show_type;
  public int recomlayout;
  public long recomreportid;
  public int recomtype;
  public String refer = "";
  public int reportfeedsattr;
  public UgcRightInfo right_info;
  public int shield;
  public long show_mask;
  public int space_right;
  public String sqDynamicFeedsKey = "";
  public Map<Integer, Integer> stMapABTest;
  public int subid;
  public int time;
  public int uflag;
  public String ugckey = "";
  public String ugcrightkey = "";
  public int wup_feeds_type;
  
  static
  {
    cache_stMapABTest.put(Integer.valueOf(0), Integer.valueOf(0));
    cache_custom_droplist = new ArrayList();
    Object localObject = new s_droplist_option();
    cache_custom_droplist.add(localObject);
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
    cache_extendInfoData = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_extendInfoData.put("", localObject);
  }
  
  public cell_comm() {}
  
  public cell_comm(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, String paramString3, String paramString4, String paramString5, int paramInt7, int paramInt8, String paramString6, String paramString7, long paramLong1, int paramInt9, int paramInt10, String paramString8, String paramString9, int paramInt11, String paramString10, long paramLong2, long paramLong3, UgcRightInfo paramUgcRightInfo, int paramInt12, long paramLong4, int paramInt13, int paramInt14, int paramInt15, int paramInt16, Map<Integer, Integer> paramMap, boolean paramBoolean1, String paramString11, int paramInt17, int paramInt18, int paramInt19, long paramLong5, ArrayList<s_droplist_option> paramArrayList, Map<String, String> paramMap1, int paramInt20, long paramLong6, String paramString12, int paramInt21, Map<String, byte[]> paramMap2, int paramInt22, boolean paramBoolean2, boolean paramBoolean3, long paramLong7)
  {
    this.appid = paramInt1;
    this.subid = paramInt2;
    this.refer = paramString1;
    this.time = paramInt3;
    this.actiontype = paramInt4;
    this.actionurl = paramString2;
    this.originaltype = paramInt5;
    this.operatemask = paramInt6;
    this.feedskey = paramString3;
    this.orglikekey = paramString4;
    this.curlikekey = paramString5;
    this.feedstype = paramInt7;
    this.feedsattr = paramInt8;
    this.ugckey = paramString6;
    this.clientkey = paramString7;
    this.show_mask = paramLong1;
    this.uflag = paramInt9;
    this.shield = paramInt10;
    this.ugcrightkey = paramString8;
    this.interestkey = paramString9;
    this.recomtype = paramInt11;
    this.feedsid = paramString10;
    this.adv_stytle = paramLong2;
    this.adv_subtype = paramLong3;
    this.right_info = paramUgcRightInfo;
    this.recomlayout = paramInt12;
    this.recomreportid = paramLong4;
    this.space_right = paramInt13;
    this.reportfeedsattr = paramInt14;
    this.recom_show_type = paramInt15;
    this.wup_feeds_type = paramInt16;
    this.stMapABTest = paramMap;
    this.is_stay = paramBoolean1;
    this.paykey = paramString11;
    this.operatemask2 = paramInt17;
    this.positionmask = paramInt18;
    this.positionmask2 = paramInt19;
    this.editmask = paramLong5;
    this.custom_droplist = paramArrayList;
    this.extendInfo = paramMap1;
    this.feedsattr2 = paramInt20;
    this.feedsDelTime = paramLong6;
    this.sqDynamicFeedsKey = paramString12;
    this.iClick_area = paramInt21;
    this.extendInfoData = paramMap2;
    this.hot_score = paramInt22;
    this.is_kuolie = paramBoolean2;
    this.pull_qzone = paramBoolean3;
    this.operatemask3 = paramLong7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.subid = paramJceInputStream.read(this.subid, 1, false);
    this.refer = paramJceInputStream.readString(2, false);
    this.time = paramJceInputStream.read(this.time, 3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.actionurl = paramJceInputStream.readString(5, false);
    this.originaltype = paramJceInputStream.read(this.originaltype, 6, false);
    this.operatemask = paramJceInputStream.read(this.operatemask, 7, false);
    this.feedskey = paramJceInputStream.readString(8, false);
    this.orglikekey = paramJceInputStream.readString(9, false);
    this.curlikekey = paramJceInputStream.readString(10, false);
    this.feedstype = paramJceInputStream.read(this.feedstype, 11, false);
    this.feedsattr = paramJceInputStream.read(this.feedsattr, 12, false);
    this.ugckey = paramJceInputStream.readString(13, false);
    this.clientkey = paramJceInputStream.readString(14, false);
    this.show_mask = paramJceInputStream.read(this.show_mask, 15, false);
    this.uflag = paramJceInputStream.read(this.uflag, 16, false);
    this.shield = paramJceInputStream.read(this.shield, 17, false);
    this.ugcrightkey = paramJceInputStream.readString(18, false);
    this.interestkey = paramJceInputStream.readString(19, false);
    this.recomtype = paramJceInputStream.read(this.recomtype, 20, false);
    this.feedsid = paramJceInputStream.readString(21, false);
    this.adv_stytle = paramJceInputStream.read(this.adv_stytle, 22, false);
    this.adv_subtype = paramJceInputStream.read(this.adv_subtype, 23, false);
    this.right_info = ((UgcRightInfo)paramJceInputStream.read(cache_right_info, 24, false));
    this.recomlayout = paramJceInputStream.read(this.recomlayout, 25, false);
    this.recomreportid = paramJceInputStream.read(this.recomreportid, 26, false);
    this.space_right = paramJceInputStream.read(this.space_right, 27, false);
    this.reportfeedsattr = paramJceInputStream.read(this.reportfeedsattr, 28, false);
    this.recom_show_type = paramJceInputStream.read(this.recom_show_type, 29, false);
    this.wup_feeds_type = paramJceInputStream.read(this.wup_feeds_type, 30, false);
    this.stMapABTest = ((Map)paramJceInputStream.read(cache_stMapABTest, 31, false));
    this.is_stay = paramJceInputStream.read(this.is_stay, 32, false);
    this.paykey = paramJceInputStream.readString(33, false);
    this.operatemask2 = paramJceInputStream.read(this.operatemask2, 34, false);
    this.positionmask = paramJceInputStream.read(this.positionmask, 35, false);
    this.positionmask2 = paramJceInputStream.read(this.positionmask2, 36, false);
    this.editmask = paramJceInputStream.read(this.editmask, 37, false);
    this.custom_droplist = ((ArrayList)paramJceInputStream.read(cache_custom_droplist, 38, false));
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 39, false));
    this.feedsattr2 = paramJceInputStream.read(this.feedsattr2, 40, false);
    this.feedsDelTime = paramJceInputStream.read(this.feedsDelTime, 41, false);
    this.sqDynamicFeedsKey = paramJceInputStream.readString(42, false);
    this.iClick_area = paramJceInputStream.read(this.iClick_area, 43, false);
    this.extendInfoData = ((Map)paramJceInputStream.read(cache_extendInfoData, 44, false));
    this.hot_score = paramJceInputStream.read(this.hot_score, 45, false);
    this.is_kuolie = paramJceInputStream.read(this.is_kuolie, 46, false);
    this.pull_qzone = paramJceInputStream.read(this.pull_qzone, 47, false);
    this.operatemask3 = paramJceInputStream.read(this.operatemask3, 48, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.subid, 1);
    if (this.refer != null) {
      paramJceOutputStream.write(this.refer, 2);
    }
    paramJceOutputStream.write(this.time, 3);
    paramJceOutputStream.write(this.actiontype, 4);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 5);
    }
    paramJceOutputStream.write(this.originaltype, 6);
    paramJceOutputStream.write(this.operatemask, 7);
    if (this.feedskey != null) {
      paramJceOutputStream.write(this.feedskey, 8);
    }
    if (this.orglikekey != null) {
      paramJceOutputStream.write(this.orglikekey, 9);
    }
    if (this.curlikekey != null) {
      paramJceOutputStream.write(this.curlikekey, 10);
    }
    paramJceOutputStream.write(this.feedstype, 11);
    paramJceOutputStream.write(this.feedsattr, 12);
    if (this.ugckey != null) {
      paramJceOutputStream.write(this.ugckey, 13);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 14);
    }
    paramJceOutputStream.write(this.show_mask, 15);
    paramJceOutputStream.write(this.uflag, 16);
    paramJceOutputStream.write(this.shield, 17);
    if (this.ugcrightkey != null) {
      paramJceOutputStream.write(this.ugcrightkey, 18);
    }
    if (this.interestkey != null) {
      paramJceOutputStream.write(this.interestkey, 19);
    }
    paramJceOutputStream.write(this.recomtype, 20);
    if (this.feedsid != null) {
      paramJceOutputStream.write(this.feedsid, 21);
    }
    paramJceOutputStream.write(this.adv_stytle, 22);
    paramJceOutputStream.write(this.adv_subtype, 23);
    if (this.right_info != null) {
      paramJceOutputStream.write(this.right_info, 24);
    }
    paramJceOutputStream.write(this.recomlayout, 25);
    paramJceOutputStream.write(this.recomreportid, 26);
    paramJceOutputStream.write(this.space_right, 27);
    paramJceOutputStream.write(this.reportfeedsattr, 28);
    paramJceOutputStream.write(this.recom_show_type, 29);
    paramJceOutputStream.write(this.wup_feeds_type, 30);
    if (this.stMapABTest != null) {
      paramJceOutputStream.write(this.stMapABTest, 31);
    }
    paramJceOutputStream.write(this.is_stay, 32);
    if (this.paykey != null) {
      paramJceOutputStream.write(this.paykey, 33);
    }
    paramJceOutputStream.write(this.operatemask2, 34);
    paramJceOutputStream.write(this.positionmask, 35);
    paramJceOutputStream.write(this.positionmask2, 36);
    paramJceOutputStream.write(this.editmask, 37);
    if (this.custom_droplist != null) {
      paramJceOutputStream.write(this.custom_droplist, 38);
    }
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 39);
    }
    paramJceOutputStream.write(this.feedsattr2, 40);
    paramJceOutputStream.write(this.feedsDelTime, 41);
    if (this.sqDynamicFeedsKey != null) {
      paramJceOutputStream.write(this.sqDynamicFeedsKey, 42);
    }
    paramJceOutputStream.write(this.iClick_area, 43);
    if (this.extendInfoData != null) {
      paramJceOutputStream.write(this.extendInfoData, 44);
    }
    paramJceOutputStream.write(this.hot_score, 45);
    paramJceOutputStream.write(this.is_kuolie, 46);
    paramJceOutputStream.write(this.pull_qzone, 47);
    paramJceOutputStream.write(this.operatemask3, 48);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_comm
 * JD-Core Version:    0.7.0.1
 */