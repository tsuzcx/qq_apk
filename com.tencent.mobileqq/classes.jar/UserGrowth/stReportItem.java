package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stReportItem
  extends JceStruct
{
  static stDevice cache_device;
  static Map<String, String> cache_ext_map;
  static Map<String, String> cache_feed_map_ext;
  static Map<Integer, byte[]> cache_map_pass_back = new HashMap();
  public String authorid = "";
  public String authorname = "";
  public int card_type;
  public String cate = "";
  public int cid;
  public String city = "";
  public int comment_loctaion;
  public stDevice device;
  public String dislike_reason = "";
  public String downloadscene = "";
  public int exist_weishi;
  public Map<String, String> ext_map;
  public Map<String, String> feed_map_ext;
  public String feedid = "";
  public long imp_date;
  public String ip = "";
  public boolean isFullSpan = true;
  public String jubao_reason = "";
  public Map<Integer, byte[]> map_pass_back;
  public String network_type = "";
  public int op_location;
  public int optype;
  public String originImgUrl = "";
  public String os = "";
  public int pagetype;
  public String personid = "";
  public int play_time;
  public int policy_type;
  public int pool_type;
  public String pushid = "";
  public String qua = "";
  public int ratioH;
  public int ratioW;
  public int shareto;
  public String tag = "";
  public String title = "";
  public String traceId = "";
  public long uin;
  public int upos;
  public String vendor = "";
  public int video_time;
  public int video_type;
  public int windowsid;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_map_pass_back.put(Integer.valueOf(0), arrayOfByte);
    cache_ext_map = new HashMap();
    cache_ext_map.put("", "");
    cache_device = new stDevice();
    cache_feed_map_ext = new HashMap();
    cache_feed_map_ext.put("", "");
  }
  
  public stReportItem() {}
  
  public stReportItem(long paramLong1, String paramString1, long paramLong2, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5, int paramInt5, String paramString6, String paramString7, int paramInt6, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, Map<Integer, byte[]> paramMap, int paramInt7, Map<String, String> paramMap1, int paramInt8, int paramInt9, String paramString14, String paramString15, String paramString16, stDevice paramstDevice, String paramString17, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, boolean paramBoolean, String paramString18, int paramInt17, String paramString19, Map<String, String> paramMap2)
  {
    this.imp_date = paramLong1;
    this.personid = paramString1;
    this.uin = paramLong2;
    this.feedid = paramString2;
    this.pagetype = paramInt1;
    this.optype = paramInt2;
    this.play_time = paramInt3;
    this.video_time = paramInt4;
    this.authorid = paramString3;
    this.authorname = paramString4;
    this.title = paramString5;
    this.upos = paramInt5;
    this.dislike_reason = paramString6;
    this.jubao_reason = paramString7;
    this.shareto = paramInt6;
    this.cate = paramString8;
    this.tag = paramString9;
    this.network_type = paramString10;
    this.os = paramString11;
    this.city = paramString12;
    this.ip = paramString13;
    this.map_pass_back = paramMap;
    this.windowsid = paramInt7;
    this.ext_map = paramMap1;
    this.cid = paramInt8;
    this.video_type = paramInt9;
    this.qua = paramString14;
    this.vendor = paramString15;
    this.downloadscene = paramString16;
    this.device = paramstDevice;
    this.pushid = paramString17;
    this.exist_weishi = paramInt10;
    this.policy_type = paramInt11;
    this.op_location = paramInt12;
    this.card_type = paramInt13;
    this.pool_type = paramInt14;
    this.ratioH = paramInt15;
    this.ratioW = paramInt16;
    this.isFullSpan = paramBoolean;
    this.originImgUrl = paramString18;
    this.comment_loctaion = paramInt17;
    this.traceId = paramString19;
    this.feed_map_ext = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imp_date = paramJceInputStream.read(this.imp_date, 0, false);
    this.personid = paramJceInputStream.readString(1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, false);
    this.feedid = paramJceInputStream.readString(3, false);
    this.pagetype = paramJceInputStream.read(this.pagetype, 4, false);
    this.optype = paramJceInputStream.read(this.optype, 5, false);
    this.play_time = paramJceInputStream.read(this.play_time, 6, false);
    this.video_time = paramJceInputStream.read(this.video_time, 7, false);
    this.authorid = paramJceInputStream.readString(8, false);
    this.authorname = paramJceInputStream.readString(9, false);
    this.title = paramJceInputStream.readString(10, false);
    this.upos = paramJceInputStream.read(this.upos, 11, false);
    this.dislike_reason = paramJceInputStream.readString(12, false);
    this.jubao_reason = paramJceInputStream.readString(13, false);
    this.shareto = paramJceInputStream.read(this.shareto, 14, false);
    this.cate = paramJceInputStream.readString(15, false);
    this.tag = paramJceInputStream.readString(16, false);
    this.network_type = paramJceInputStream.readString(17, false);
    this.os = paramJceInputStream.readString(18, false);
    this.city = paramJceInputStream.readString(19, false);
    this.ip = paramJceInputStream.readString(20, false);
    this.map_pass_back = ((Map)paramJceInputStream.read(cache_map_pass_back, 21, false));
    this.windowsid = paramJceInputStream.read(this.windowsid, 22, false);
    this.ext_map = ((Map)paramJceInputStream.read(cache_ext_map, 23, false));
    this.cid = paramJceInputStream.read(this.cid, 24, false);
    this.video_type = paramJceInputStream.read(this.video_type, 25, false);
    this.qua = paramJceInputStream.readString(26, false);
    this.vendor = paramJceInputStream.readString(27, false);
    this.downloadscene = paramJceInputStream.readString(28, false);
    this.device = ((stDevice)paramJceInputStream.read(cache_device, 29, false));
    this.pushid = paramJceInputStream.readString(30, false);
    this.exist_weishi = paramJceInputStream.read(this.exist_weishi, 31, false);
    this.policy_type = paramJceInputStream.read(this.policy_type, 32, false);
    this.op_location = paramJceInputStream.read(this.op_location, 33, false);
    this.card_type = paramJceInputStream.read(this.card_type, 34, false);
    this.pool_type = paramJceInputStream.read(this.pool_type, 35, false);
    this.ratioH = paramJceInputStream.read(this.ratioH, 36, false);
    this.ratioW = paramJceInputStream.read(this.ratioW, 37, false);
    this.isFullSpan = paramJceInputStream.read(this.isFullSpan, 38, false);
    this.originImgUrl = paramJceInputStream.readString(39, false);
    this.comment_loctaion = paramJceInputStream.read(this.comment_loctaion, 40, false);
    this.traceId = paramJceInputStream.readString(41, false);
    this.feed_map_ext = ((Map)paramJceInputStream.read(cache_feed_map_ext, 42, false));
  }
  
  public String toString()
  {
    return "stReportItem{imp_date=" + this.imp_date + ", personid='" + this.personid + '\'' + ", uin=" + this.uin + ", feedid='" + this.feedid + '\'' + ", pagetype=" + this.pagetype + ", optype=" + this.optype + ", play_time=" + this.play_time + ", video_time=" + this.video_time + ", authorid='" + this.authorid + '\'' + ", authorname='" + this.authorname + '\'' + ", title='" + this.title + '\'' + ", upos=" + this.upos + ", dislike_reason='" + this.dislike_reason + '\'' + ", jubao_reason='" + this.jubao_reason + '\'' + ", shareto=" + this.shareto + ", cate='" + this.cate + '\'' + ", tag='" + this.tag + '\'' + ", network_type='" + this.network_type + '\'' + ", os='" + this.os + '\'' + ", city='" + this.city + '\'' + ", ip='" + this.ip + '\'' + ", map_pass_back=" + this.map_pass_back + ", windowsid=" + this.windowsid + ", ext_map=" + this.ext_map + ", cid=" + this.cid + ", video_type=" + this.video_type + ", qua='" + this.qua + '\'' + ", vendor='" + this.vendor + '\'' + ", downloadscene='" + this.downloadscene + '\'' + ", device=" + this.device + ", pushid='" + this.pushid + '\'' + ", exist_weishi=" + this.exist_weishi + ", policy_type=" + this.policy_type + ", op_location=" + this.op_location + ", card_type=" + this.card_type + ", pool_type=" + this.pool_type + ", ratioH=" + this.ratioH + ", ratioW=" + this.ratioW + ", isFullSpan=" + this.isFullSpan + ", originImgUrl='" + this.originImgUrl + '\'' + ", comment_loctaion=" + this.comment_loctaion + ", traceId='" + this.traceId + '\'' + ", feed_map_ext=" + this.feed_map_ext + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imp_date, 0);
    if (this.personid != null) {
      paramJceOutputStream.write(this.personid, 1);
    }
    paramJceOutputStream.write(this.uin, 2);
    if (this.feedid != null) {
      paramJceOutputStream.write(this.feedid, 3);
    }
    paramJceOutputStream.write(this.pagetype, 4);
    paramJceOutputStream.write(this.optype, 5);
    paramJceOutputStream.write(this.play_time, 6);
    paramJceOutputStream.write(this.video_time, 7);
    if (this.authorid != null) {
      paramJceOutputStream.write(this.authorid, 8);
    }
    if (this.authorname != null) {
      paramJceOutputStream.write(this.authorname, 9);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 10);
    }
    paramJceOutputStream.write(this.upos, 11);
    if (this.dislike_reason != null) {
      paramJceOutputStream.write(this.dislike_reason, 12);
    }
    if (this.jubao_reason != null) {
      paramJceOutputStream.write(this.jubao_reason, 13);
    }
    paramJceOutputStream.write(this.shareto, 14);
    if (this.cate != null) {
      paramJceOutputStream.write(this.cate, 15);
    }
    if (this.tag != null) {
      paramJceOutputStream.write(this.tag, 16);
    }
    if (this.network_type != null) {
      paramJceOutputStream.write(this.network_type, 17);
    }
    if (this.os != null) {
      paramJceOutputStream.write(this.os, 18);
    }
    if (this.city != null) {
      paramJceOutputStream.write(this.city, 19);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 20);
    }
    if (this.map_pass_back != null) {
      paramJceOutputStream.write(this.map_pass_back, 21);
    }
    paramJceOutputStream.write(this.windowsid, 22);
    if (this.ext_map != null) {
      paramJceOutputStream.write(this.ext_map, 23);
    }
    paramJceOutputStream.write(this.cid, 24);
    paramJceOutputStream.write(this.video_type, 25);
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 26);
    }
    if (this.vendor != null) {
      paramJceOutputStream.write(this.vendor, 27);
    }
    if (this.downloadscene != null) {
      paramJceOutputStream.write(this.downloadscene, 28);
    }
    if (this.device != null) {
      paramJceOutputStream.write(this.device, 29);
    }
    if (this.pushid != null) {
      paramJceOutputStream.write(this.pushid, 30);
    }
    paramJceOutputStream.write(this.exist_weishi, 31);
    paramJceOutputStream.write(this.policy_type, 32);
    paramJceOutputStream.write(this.op_location, 33);
    paramJceOutputStream.write(this.card_type, 34);
    paramJceOutputStream.write(this.pool_type, 35);
    paramJceOutputStream.write(this.ratioH, 36);
    paramJceOutputStream.write(this.ratioW, 37);
    paramJceOutputStream.write(this.isFullSpan, 38);
    if (this.originImgUrl != null) {
      paramJceOutputStream.write(this.originImgUrl, 39);
    }
    paramJceOutputStream.write(this.comment_loctaion, 40);
    if (this.traceId != null) {
      paramJceOutputStream.write(this.traceId, 41);
    }
    if (this.feed_map_ext != null) {
      paramJceOutputStream.write(this.feed_map_ext, 42);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stReportItem
 * JD-Core Version:    0.7.0.1
 */