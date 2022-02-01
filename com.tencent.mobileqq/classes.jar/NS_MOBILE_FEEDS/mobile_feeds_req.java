package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feeds_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_feed_infos;
  static s_gps cache_gps_info;
  static Map<String, String> cache_kitFileInfos;
  static Map<String, byte[]> cache_mapBinaryExtendInfo;
  static Map<Integer, String> cache_mapDesc;
  static Map<Integer, String> cache_rank_param;
  static Map<String, String> cache_stMapExtendinfo;
  public String attach_info = "";
  public Map<Integer, String> busi_param = null;
  public int count = 0;
  public String device_info = "";
  public String feed_attach_info = "";
  public Map<String, String> feed_infos = null;
  public byte force = 0;
  public s_gps gps_info = null;
  public Map<String, String> kitFileInfos = null;
  public Map<String, byte[]> mapBinaryExtendInfo = null;
  public Map<Integer, String> mapDesc = null;
  public long offset = 0L;
  public Map<Integer, String> rank_param = null;
  public int refresh_type = 0;
  public int relation_type = 0;
  public int scene = 0;
  public Map<String, String> stMapExtendinfo = null;
  public String tlv_attach_info = "";
  
  static
  {
    Object localObject = Integer.valueOf(0);
    cache_busi_param.put(localObject, "");
    cache_feed_infos = new HashMap();
    cache_feed_infos.put("", "");
    cache_gps_info = new s_gps();
    cache_stMapExtendinfo = new HashMap();
    cache_stMapExtendinfo.put("", "");
    cache_kitFileInfos = new HashMap();
    cache_kitFileInfos.put("", "");
    cache_rank_param = new HashMap();
    cache_rank_param.put(localObject, "");
    cache_mapDesc = new HashMap();
    cache_mapDesc.put(localObject, "");
    cache_mapBinaryExtendInfo = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_mapBinaryExtendInfo.put("", localObject);
  }
  
  public mobile_feeds_req() {}
  
  public mobile_feeds_req(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, Map<Integer, String> paramMap1, long paramLong, String paramString3, Map<String, String> paramMap2, String paramString4, byte paramByte, s_gps params_gps, Map<String, String> paramMap3, Map<String, String> paramMap4, Map<Integer, String> paramMap5, Map<Integer, String> paramMap6, Map<String, byte[]> paramMap, int paramInt4)
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
    this.rank_param = paramMap5;
    this.mapDesc = paramMap6;
    this.mapBinaryExtendInfo = paramMap;
    this.scene = paramInt4;
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
    this.rank_param = ((Map)paramJceInputStream.read(cache_rank_param, 14, false));
    this.mapDesc = ((Map)paramJceInputStream.read(cache_mapDesc, 15, false));
    this.mapBinaryExtendInfo = ((Map)paramJceInputStream.read(cache_mapBinaryExtendInfo, 16, false));
    this.scene = paramJceInputStream.read(this.scene, 17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.refresh_type, 0);
    paramJceOutputStream.write(this.relation_type, 1);
    paramJceOutputStream.write(this.count, 2);
    Object localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.device_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    paramJceOutputStream.write(this.offset, 6);
    localObject = this.tlv_attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.feed_infos;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    localObject = this.feed_attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.force, 10);
    localObject = this.gps_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.stMapExtendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 12);
    }
    localObject = this.kitFileInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
    localObject = this.rank_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 14);
    }
    localObject = this.mapDesc;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 15);
    }
    localObject = this.mapBinaryExtendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 16);
    }
    paramJceOutputStream.write(this.scene, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_req
 * JD-Core Version:    0.7.0.1
 */