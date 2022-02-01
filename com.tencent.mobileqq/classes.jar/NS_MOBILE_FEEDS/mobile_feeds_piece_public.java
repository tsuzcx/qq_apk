package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feeds_piece_public
  extends JceStruct
{
  static Map<Integer, String> cache_extendinfo;
  static s_cover cache_host_cover = new s_cover();
  static Map<String, String> cache_stMapExtendinfo;
  static interest_list cache_uin_info = new interest_list();
  public String attach_info = "";
  public Map<Integer, String> extendinfo = null;
  public int hasmore = 0;
  public s_cover host_cover = null;
  public long host_imbitmap = 0L;
  public String hostnick = "";
  public long iFollowNum = 0L;
  public int iYellowLevel = 0;
  public int iYellowType = 0;
  public int is_detail_report = 0;
  public int network_report = 1;
  public long newcount = 0L;
  public int no_update = 0;
  public long req_count = 0L;
  public Map<String, String> stMapExtendinfo = null;
  public interest_list uin_info = null;
  public String user_sid = "";
  
  static
  {
    cache_extendinfo = new HashMap();
    cache_extendinfo.put(Integer.valueOf(0), "");
    cache_stMapExtendinfo = new HashMap();
    cache_stMapExtendinfo.put("", "");
  }
  
  public mobile_feeds_piece_public() {}
  
  public mobile_feeds_piece_public(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2, int paramInt3, int paramInt4, long paramLong3, long paramLong4, String paramString3, s_cover params_cover, interest_list paraminterest_list, Map<Integer, String> paramMap, int paramInt5, int paramInt6, Map<String, String> paramMap1)
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
    this.extendinfo = paramMap;
    this.is_detail_report = paramInt5;
    this.network_report = paramInt6;
    this.stMapExtendinfo = paramMap1;
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
    Object localObject = this.hostnick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.no_update, 4);
    paramJceOutputStream.write(this.req_count, 5);
    paramJceOutputStream.write(this.iYellowType, 6);
    paramJceOutputStream.write(this.iYellowLevel, 7);
    paramJceOutputStream.write(this.iFollowNum, 8);
    paramJceOutputStream.write(this.host_imbitmap, 9);
    localObject = this.user_sid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.host_cover;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.uin_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
    paramJceOutputStream.write(this.is_detail_report, 14);
    paramJceOutputStream.write(this.network_report, 15);
    localObject = this.stMapExtendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_piece_public
 * JD-Core Version:    0.7.0.1
 */