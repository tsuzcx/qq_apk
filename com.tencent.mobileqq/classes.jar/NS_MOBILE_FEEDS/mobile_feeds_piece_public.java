package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feeds_piece_public
  extends JceStruct
{
  static Map cache_extendinfo;
  static s_cover cache_host_cover = new s_cover();
  static Map cache_stMapExtendinfo;
  static interest_list cache_uin_info = new interest_list();
  public String attach_info = "";
  public Map extendinfo;
  public int hasmore;
  public s_cover host_cover;
  public long host_imbitmap;
  public String hostnick = "";
  public long iFollowNum;
  public int iYellowLevel;
  public int iYellowType;
  public int is_detail_report;
  public int network_report = 1;
  public long newcount;
  public int no_update;
  public long req_count;
  public Map stMapExtendinfo;
  public interest_list uin_info;
  public String user_sid = "";
  
  static
  {
    cache_extendinfo = new HashMap();
    cache_extendinfo.put(Integer.valueOf(0), "");
    cache_stMapExtendinfo = new HashMap();
    cache_stMapExtendinfo.put("", "");
  }
  
  public mobile_feeds_piece_public() {}
  
  public mobile_feeds_piece_public(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2, int paramInt3, int paramInt4, long paramLong3, long paramLong4, String paramString3, s_cover params_cover, interest_list paraminterest_list, Map paramMap1, int paramInt5, int paramInt6, Map paramMap2)
  {
    this.hasmore = paramInt1;
    this.newcount = paramLong1;
    this.hostnick = paramString1;
    this.attach_info = paramString2;
    this.no_update = paramInt2;
    this.req_count = paramLong2;
    this.iYellowType = paramInt3;
    this.iYellowLevel = paramInt4;
    this.iFollowNum = paramLong3;
    this.host_imbitmap = paramLong4;
    this.user_sid = paramString3;
    this.host_cover = params_cover;
    this.uin_info = paraminterest_list;
    this.extendinfo = paramMap1;
    this.is_detail_report = paramInt5;
    this.network_report = paramInt6;
    this.stMapExtendinfo = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.newcount = paramJceInputStream.read(this.newcount, 1, false);
    this.hostnick = paramJceInputStream.readString(2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.no_update = paramJceInputStream.read(this.no_update, 4, false);
    this.req_count = paramJceInputStream.read(this.req_count, 5, false);
    this.iYellowType = paramJceInputStream.read(this.iYellowType, 6, false);
    this.iYellowLevel = paramJceInputStream.read(this.iYellowLevel, 7, false);
    this.iFollowNum = paramJceInputStream.read(this.iFollowNum, 8, false);
    this.host_imbitmap = paramJceInputStream.read(this.host_imbitmap, 9, false);
    this.user_sid = paramJceInputStream.readString(10, false);
    this.host_cover = ((s_cover)paramJceInputStream.read(cache_host_cover, 11, false));
    this.uin_info = ((interest_list)paramJceInputStream.read(cache_uin_info, 12, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 13, false));
    this.is_detail_report = paramJceInputStream.read(this.is_detail_report, 14, false);
    this.network_report = paramJceInputStream.read(this.network_report, 15, false);
    this.stMapExtendinfo = ((Map)paramJceInputStream.read(cache_stMapExtendinfo, 16, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    paramJceOutputStream.write(this.newcount, 1);
    if (this.hostnick != null) {
      paramJceOutputStream.write(this.hostnick, 2);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.no_update, 4);
    paramJceOutputStream.write(this.req_count, 5);
    paramJceOutputStream.write(this.iYellowType, 6);
    paramJceOutputStream.write(this.iYellowLevel, 7);
    paramJceOutputStream.write(this.iFollowNum, 8);
    paramJceOutputStream.write(this.host_imbitmap, 9);
    if (this.user_sid != null) {
      paramJceOutputStream.write(this.user_sid, 10);
    }
    if (this.host_cover != null) {
      paramJceOutputStream.write(this.host_cover, 11);
    }
    if (this.uin_info != null) {
      paramJceOutputStream.write(this.uin_info, 12);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 13);
    }
    paramJceOutputStream.write(this.is_detail_report, 14);
    paramJceOutputStream.write(this.network_report, 15);
    if (this.stMapExtendinfo != null) {
      paramJceOutputStream.write(this.stMapExtendinfo, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_piece_public
 * JD-Core Version:    0.7.0.1
 */