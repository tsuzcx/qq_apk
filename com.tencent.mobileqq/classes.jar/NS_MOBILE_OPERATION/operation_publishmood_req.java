package NS_MOBILE_OPERATION;

import NS_MOBILE_COMM.UgcRightInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_publishmood_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param;
  static Map<String, String> cache_extend_info;
  static LbsInfo cache_hidden_poi;
  static LbsInfo cache_lbsinfo;
  static MediaInfo cache_mediainfo = new MediaInfo();
  static Map<String, byte[]> cache_proto_extend_info;
  static UgcRightInfo cache_right_info;
  static ShootInfo cache_shootInfo;
  static Source cache_source;
  static Map<String, String> cache_stored_extend_info;
  public Map<Integer, String> busi_param;
  public String clientkey = "";
  public String content = "";
  public Map<String, String> extend_info;
  public short frames;
  public LbsInfo hidden_poi;
  public int isWinPhone;
  public boolean issynctoweibo = true;
  public boolean isverified = true;
  public LbsInfo lbsinfo;
  public long lock_days;
  public int mediaSubType;
  public int mediabittype;
  public MediaInfo mediainfo;
  public int mediatype;
  public int modifyflag;
  public String open_appid = "";
  public Map<String, byte[]> proto_extend_info;
  public long publishTime;
  public String richtype = "";
  public String richval = "";
  public UgcRightInfo right_info;
  public long seal_id;
  public ShootInfo shootInfo;
  public Source source;
  public String sourceName = "";
  public String srcid = "";
  public Map<String, String> stored_extend_info;
  public long uin;
  public String weibourl = "";
  
  static
  {
    cache_lbsinfo = new LbsInfo();
    cache_source = new Source();
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_right_info = new UgcRightInfo();
    cache_shootInfo = new ShootInfo();
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
    cache_hidden_poi = new LbsInfo();
    cache_stored_extend_info = new HashMap();
    cache_stored_extend_info.put("", "");
    cache_proto_extend_info = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_proto_extend_info.put("", arrayOfByte);
  }
  
  public operation_publishmood_req() {}
  
  public operation_publishmood_req(long paramLong1, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt1, MediaInfo paramMediaInfo, LbsInfo paramLbsInfo1, Source paramSource, int paramInt2, Map<Integer, String> paramMap, String paramString3, String paramString4, UgcRightInfo paramUgcRightInfo, ShootInfo paramShootInfo, long paramLong2, int paramInt3, String paramString5, int paramInt4, Map<String, String> paramMap1, String paramString6, String paramString7, int paramInt5, String paramString8, LbsInfo paramLbsInfo2, long paramLong3, short paramShort, long paramLong4, Map<String, String> paramMap2, Map<String, byte[]> paramMap3)
  {
    this.uin = paramLong1;
    this.content = paramString1;
    this.isverified = paramBoolean1;
    this.issynctoweibo = paramBoolean2;
    this.weibourl = paramString2;
    this.mediatype = paramInt1;
    this.mediainfo = paramMediaInfo;
    this.lbsinfo = paramLbsInfo1;
    this.source = paramSource;
    this.mediabittype = paramInt2;
    this.busi_param = paramMap;
    this.clientkey = paramString3;
    this.open_appid = paramString4;
    this.right_info = paramUgcRightInfo;
    this.shootInfo = paramShootInfo;
    this.publishTime = paramLong2;
    this.mediaSubType = paramInt3;
    this.srcid = paramString5;
    this.modifyflag = paramInt4;
    this.extend_info = paramMap1;
    this.richtype = paramString6;
    this.richval = paramString7;
    this.isWinPhone = paramInt5;
    this.sourceName = paramString8;
    this.hidden_poi = paramLbsInfo2;
    this.seal_id = paramLong3;
    this.frames = paramShort;
    this.lock_days = paramLong4;
    this.stored_extend_info = paramMap2;
    this.proto_extend_info = paramMap3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.content = paramJceInputStream.readString(1, false);
    this.isverified = paramJceInputStream.read(this.isverified, 2, false);
    this.issynctoweibo = paramJceInputStream.read(this.issynctoweibo, 3, false);
    this.weibourl = paramJceInputStream.readString(4, false);
    this.mediatype = paramJceInputStream.read(this.mediatype, 5, false);
    this.mediainfo = ((MediaInfo)paramJceInputStream.read(cache_mediainfo, 6, false));
    this.lbsinfo = ((LbsInfo)paramJceInputStream.read(cache_lbsinfo, 7, false));
    this.source = ((Source)paramJceInputStream.read(cache_source, 8, false));
    this.mediabittype = paramJceInputStream.read(this.mediabittype, 9, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 10, false));
    this.clientkey = paramJceInputStream.readString(11, false);
    this.open_appid = paramJceInputStream.readString(12, false);
    this.right_info = ((UgcRightInfo)paramJceInputStream.read(cache_right_info, 13, false));
    this.shootInfo = ((ShootInfo)paramJceInputStream.read(cache_shootInfo, 14, false));
    this.publishTime = paramJceInputStream.read(this.publishTime, 15, false);
    this.mediaSubType = paramJceInputStream.read(this.mediaSubType, 16, false);
    this.srcid = paramJceInputStream.readString(17, false);
    this.modifyflag = paramJceInputStream.read(this.modifyflag, 18, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 19, false));
    this.richtype = paramJceInputStream.readString(20, false);
    this.richval = paramJceInputStream.readString(21, false);
    this.isWinPhone = paramJceInputStream.read(this.isWinPhone, 22, false);
    this.sourceName = paramJceInputStream.readString(23, false);
    this.hidden_poi = ((LbsInfo)paramJceInputStream.read(cache_hidden_poi, 24, false));
    this.seal_id = paramJceInputStream.read(this.seal_id, 25, false);
    this.frames = paramJceInputStream.read(this.frames, 26, false);
    this.lock_days = paramJceInputStream.read(this.lock_days, 27, false);
    this.stored_extend_info = ((Map)paramJceInputStream.read(cache_stored_extend_info, 28, false));
    this.proto_extend_info = ((Map)paramJceInputStream.read(cache_proto_extend_info, 29, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 1);
    }
    paramJceOutputStream.write(this.isverified, 2);
    paramJceOutputStream.write(this.issynctoweibo, 3);
    if (this.weibourl != null) {
      paramJceOutputStream.write(this.weibourl, 4);
    }
    paramJceOutputStream.write(this.mediatype, 5);
    if (this.mediainfo != null) {
      paramJceOutputStream.write(this.mediainfo, 6);
    }
    if (this.lbsinfo != null) {
      paramJceOutputStream.write(this.lbsinfo, 7);
    }
    if (this.source != null) {
      paramJceOutputStream.write(this.source, 8);
    }
    paramJceOutputStream.write(this.mediabittype, 9);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 10);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 11);
    }
    if (this.open_appid != null) {
      paramJceOutputStream.write(this.open_appid, 12);
    }
    if (this.right_info != null) {
      paramJceOutputStream.write(this.right_info, 13);
    }
    if (this.shootInfo != null) {
      paramJceOutputStream.write(this.shootInfo, 14);
    }
    paramJceOutputStream.write(this.publishTime, 15);
    paramJceOutputStream.write(this.mediaSubType, 16);
    if (this.srcid != null) {
      paramJceOutputStream.write(this.srcid, 17);
    }
    paramJceOutputStream.write(this.modifyflag, 18);
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 19);
    }
    if (this.richtype != null) {
      paramJceOutputStream.write(this.richtype, 20);
    }
    if (this.richval != null) {
      paramJceOutputStream.write(this.richval, 21);
    }
    paramJceOutputStream.write(this.isWinPhone, 22);
    if (this.sourceName != null) {
      paramJceOutputStream.write(this.sourceName, 23);
    }
    if (this.hidden_poi != null) {
      paramJceOutputStream.write(this.hidden_poi, 24);
    }
    paramJceOutputStream.write(this.seal_id, 25);
    paramJceOutputStream.write(this.frames, 26);
    paramJceOutputStream.write(this.lock_days, 27);
    if (this.stored_extend_info != null) {
      paramJceOutputStream.write(this.stored_extend_info, 28);
    }
    if (this.proto_extend_info != null) {
      paramJceOutputStream.write(this.proto_extend_info, 29);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_publishmood_req
 * JD-Core Version:    0.7.0.1
 */