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
  public Map<Integer, String> busi_param = null;
  public String clientkey = "";
  public String content = "";
  public Map<String, String> extend_info = null;
  public short frames = 0;
  public LbsInfo hidden_poi = null;
  public int isWinPhone = 0;
  public boolean issynctoweibo = true;
  public boolean isverified = true;
  public LbsInfo lbsinfo = null;
  public long lock_days = 0L;
  public int mediaSubType = 0;
  public int mediabittype = 0;
  public MediaInfo mediainfo = null;
  public int mediatype = 0;
  public int modifyflag = 0;
  public String open_appid = "";
  public Map<String, byte[]> proto_extend_info = null;
  public long publishTime = 0L;
  public String richtype = "";
  public String richval = "";
  public UgcRightInfo right_info = null;
  public long seal_id = 0L;
  public ShootInfo shootInfo = null;
  public Source source = null;
  public String sourceName = "";
  public String srcid = "";
  public Map<String, String> stored_extend_info = null;
  public long uin = 0L;
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
    Object localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.isverified, 2);
    paramJceOutputStream.write(this.issynctoweibo, 3);
    localObject = this.weibourl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.mediatype, 5);
    localObject = this.mediainfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.lbsinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.source;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    paramJceOutputStream.write(this.mediabittype, 9);
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 10);
    }
    localObject = this.clientkey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.open_appid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.right_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.shootInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    paramJceOutputStream.write(this.publishTime, 15);
    paramJceOutputStream.write(this.mediaSubType, 16);
    localObject = this.srcid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 17);
    }
    paramJceOutputStream.write(this.modifyflag, 18);
    localObject = this.extend_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 19);
    }
    localObject = this.richtype;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    localObject = this.richval;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
    paramJceOutputStream.write(this.isWinPhone, 22);
    localObject = this.sourceName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 23);
    }
    localObject = this.hidden_poi;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 24);
    }
    paramJceOutputStream.write(this.seal_id, 25);
    paramJceOutputStream.write(this.frames, 26);
    paramJceOutputStream.write(this.lock_days, 27);
    localObject = this.stored_extend_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 28);
    }
    localObject = this.proto_extend_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 29);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_publishmood_req
 * JD-Core Version:    0.7.0.1
 */