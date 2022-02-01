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
  public int card_type = 0;
  public String cate = "";
  public int cid = 0;
  public String city = "";
  public int comment_loctaion = 0;
  public stDevice device = null;
  public String dislike_reason = "";
  public String downloadscene = "";
  public int exist_weishi = 0;
  public Map<String, String> ext_map = null;
  public Map<String, String> feed_map_ext = null;
  public String feedid = "";
  public long imp_date = 0L;
  public String ip = "";
  public boolean isFullSpan = true;
  public String jubao_reason = "";
  public Map<Integer, byte[]> map_pass_back = null;
  public String network_type = "";
  public int op_location = 0;
  public int optype = 0;
  public String originImgUrl = "";
  public String os = "";
  public int pagetype = 0;
  public String personid = "";
  public int play_time = 0;
  public int policy_type = 0;
  public int pool_type = 0;
  public String pushid = "";
  public String qua = "";
  public int ratioH = 0;
  public int ratioW = 0;
  public int shareto = 0;
  public String tag = "";
  public String title = "";
  public String traceId = "";
  public long uin = 0L;
  public int upos = 0;
  public String vendor = "";
  public int video_time = 0;
  public int video_type = 0;
  public int windowsid = 0;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stReportItem{imp_date=");
    localStringBuilder.append(this.imp_date);
    localStringBuilder.append(", personid='");
    localStringBuilder.append(this.personid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", feedid='");
    localStringBuilder.append(this.feedid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pagetype=");
    localStringBuilder.append(this.pagetype);
    localStringBuilder.append(", optype=");
    localStringBuilder.append(this.optype);
    localStringBuilder.append(", play_time=");
    localStringBuilder.append(this.play_time);
    localStringBuilder.append(", video_time=");
    localStringBuilder.append(this.video_time);
    localStringBuilder.append(", authorid='");
    localStringBuilder.append(this.authorid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authorname='");
    localStringBuilder.append(this.authorname);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", upos=");
    localStringBuilder.append(this.upos);
    localStringBuilder.append(", dislike_reason='");
    localStringBuilder.append(this.dislike_reason);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jubao_reason='");
    localStringBuilder.append(this.jubao_reason);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareto=");
    localStringBuilder.append(this.shareto);
    localStringBuilder.append(", cate='");
    localStringBuilder.append(this.cate);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tag='");
    localStringBuilder.append(this.tag);
    localStringBuilder.append('\'');
    localStringBuilder.append(", network_type='");
    localStringBuilder.append(this.network_type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", os='");
    localStringBuilder.append(this.os);
    localStringBuilder.append('\'');
    localStringBuilder.append(", city='");
    localStringBuilder.append(this.city);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ip='");
    localStringBuilder.append(this.ip);
    localStringBuilder.append('\'');
    localStringBuilder.append(", map_pass_back=");
    localStringBuilder.append(this.map_pass_back);
    localStringBuilder.append(", windowsid=");
    localStringBuilder.append(this.windowsid);
    localStringBuilder.append(", ext_map=");
    localStringBuilder.append(this.ext_map);
    localStringBuilder.append(", cid=");
    localStringBuilder.append(this.cid);
    localStringBuilder.append(", video_type=");
    localStringBuilder.append(this.video_type);
    localStringBuilder.append(", qua='");
    localStringBuilder.append(this.qua);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vendor='");
    localStringBuilder.append(this.vendor);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadscene='");
    localStringBuilder.append(this.downloadscene);
    localStringBuilder.append('\'');
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.device);
    localStringBuilder.append(", pushid='");
    localStringBuilder.append(this.pushid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", exist_weishi=");
    localStringBuilder.append(this.exist_weishi);
    localStringBuilder.append(", policy_type=");
    localStringBuilder.append(this.policy_type);
    localStringBuilder.append(", op_location=");
    localStringBuilder.append(this.op_location);
    localStringBuilder.append(", card_type=");
    localStringBuilder.append(this.card_type);
    localStringBuilder.append(", pool_type=");
    localStringBuilder.append(this.pool_type);
    localStringBuilder.append(", ratioH=");
    localStringBuilder.append(this.ratioH);
    localStringBuilder.append(", ratioW=");
    localStringBuilder.append(this.ratioW);
    localStringBuilder.append(", isFullSpan=");
    localStringBuilder.append(this.isFullSpan);
    localStringBuilder.append(", originImgUrl='");
    localStringBuilder.append(this.originImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comment_loctaion=");
    localStringBuilder.append(this.comment_loctaion);
    localStringBuilder.append(", traceId='");
    localStringBuilder.append(this.traceId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feed_map_ext=");
    localStringBuilder.append(this.feed_map_ext);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imp_date, 0);
    Object localObject = this.personid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.uin, 2);
    localObject = this.feedid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.pagetype, 4);
    paramJceOutputStream.write(this.optype, 5);
    paramJceOutputStream.write(this.play_time, 6);
    paramJceOutputStream.write(this.video_time, 7);
    localObject = this.authorid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.authorname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.upos, 11);
    localObject = this.dislike_reason;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.jubao_reason;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    paramJceOutputStream.write(this.shareto, 14);
    localObject = this.cate;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    localObject = this.tag;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    localObject = this.network_type;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 17);
    }
    localObject = this.os;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
    localObject = this.city;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 19);
    }
    localObject = this.ip;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    localObject = this.map_pass_back;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 21);
    }
    paramJceOutputStream.write(this.windowsid, 22);
    localObject = this.ext_map;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 23);
    }
    paramJceOutputStream.write(this.cid, 24);
    paramJceOutputStream.write(this.video_type, 25);
    localObject = this.qua;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 26);
    }
    localObject = this.vendor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 27);
    }
    localObject = this.downloadscene;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 28);
    }
    localObject = this.device;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 29);
    }
    localObject = this.pushid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 30);
    }
    paramJceOutputStream.write(this.exist_weishi, 31);
    paramJceOutputStream.write(this.policy_type, 32);
    paramJceOutputStream.write(this.op_location, 33);
    paramJceOutputStream.write(this.card_type, 34);
    paramJceOutputStream.write(this.pool_type, 35);
    paramJceOutputStream.write(this.ratioH, 36);
    paramJceOutputStream.write(this.ratioW, 37);
    paramJceOutputStream.write(this.isFullSpan, 38);
    localObject = this.originImgUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 39);
    }
    paramJceOutputStream.write(this.comment_loctaion, 40);
    localObject = this.traceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 41);
    }
    localObject = this.feed_map_ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 42);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stReportItem
 * JD-Core Version:    0.7.0.1
 */