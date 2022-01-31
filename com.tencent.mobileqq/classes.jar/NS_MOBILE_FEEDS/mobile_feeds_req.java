package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feeds_req
  extends JceStruct
{
  static Map cache_busi_param = new HashMap();
  static Map cache_feed_infos;
  static s_gps cache_gps_info;
  static Map cache_kitFileInfos;
  static Map cache_stMapExtendinfo;
  public String attach_info = "";
  public Map busi_param;
  public int count;
  public String device_info = "";
  public String feed_attach_info = "";
  public Map feed_infos;
  public byte force;
  public s_gps gps_info;
  public Map kitFileInfos;
  public long offset;
  public int refresh_type;
  public int relation_type;
  public Map stMapExtendinfo;
  public String tlv_attach_info = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_feed_infos = new HashMap();
    cache_feed_infos.put("", "");
    cache_gps_info = new s_gps();
    cache_stMapExtendinfo = new HashMap();
    cache_stMapExtendinfo.put("", "");
    cache_kitFileInfos = new HashMap();
    cache_kitFileInfos.put("", "");
  }
  
  public mobile_feeds_req() {}
  
  public mobile_feeds_req(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, Map paramMap1, long paramLong, String paramString3, Map paramMap2, String paramString4, byte paramByte, s_gps params_gps, Map paramMap3, Map paramMap4)
  {
    this.refresh_type = paramInt1;
    this.relation_type = paramInt2;
    this.count = paramInt3;
    this.attach_info = paramString1;
    this.device_info = paramString2;
    this.busi_param = paramMap1;
    this.offset = paramLong;
    this.tlv_attach_info = paramString3;
    this.feed_infos = paramMap2;
    this.feed_attach_info = paramString4;
    this.force = paramByte;
    this.gps_info = params_gps;
    this.stMapExtendinfo = paramMap3;
    this.kitFileInfos = paramMap4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.refresh_type = paramJceInputStream.read(this.refresh_type, 0, false);
    this.relation_type = paramJceInputStream.read(this.relation_type, 1, false);
    this.count = paramJceInputStream.read(this.count, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.device_info = paramJceInputStream.readString(4, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.offset = paramJceInputStream.read(this.offset, 6, false);
    this.tlv_attach_info = paramJceInputStream.readString(7, false);
    this.feed_infos = ((Map)paramJceInputStream.read(cache_feed_infos, 8, false));
    this.feed_attach_info = paramJceInputStream.readString(9, false);
    this.force = paramJceInputStream.read(this.force, 10, false);
    this.gps_info = ((s_gps)paramJceInputStream.read(cache_gps_info, 11, false));
    this.stMapExtendinfo = ((Map)paramJceInputStream.read(cache_stMapExtendinfo, 12, false));
    this.kitFileInfos = ((Map)paramJceInputStream.read(cache_kitFileInfos, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.refresh_type, 0);
    paramJceOutputStream.write(this.relation_type, 1);
    paramJceOutputStream.write(this.count, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    if (this.device_info != null) {
      paramJceOutputStream.write(this.device_info, 4);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
    paramJceOutputStream.write(this.offset, 6);
    if (this.tlv_attach_info != null) {
      paramJceOutputStream.write(this.tlv_attach_info, 7);
    }
    if (this.feed_infos != null) {
      paramJceOutputStream.write(this.feed_infos, 8);
    }
    if (this.feed_attach_info != null) {
      paramJceOutputStream.write(this.feed_attach_info, 9);
    }
    paramJceOutputStream.write(this.force, 10);
    if (this.gps_info != null) {
      paramJceOutputStream.write(this.gps_info, 11);
    }
    if (this.stMapExtendinfo != null) {
      paramJceOutputStream.write(this.stMapExtendinfo, 12);
    }
    if (this.kitFileInfos != null) {
      paramJceOutputStream.write(this.kitFileInfos, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_req
 * JD-Core Version:    0.7.0.1
 */