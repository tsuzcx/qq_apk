package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_video_float_layer_req
  extends JceStruct
{
  static Map cache_busi_param = new HashMap();
  static Map cache_extend_info;
  static QzoneWeisiReqcommendReq cache_qzone_weisi_req = new QzoneWeisiReqcommendReq();
  static int cache_req_type;
  public int appid;
  public String attach_info = "";
  public Map busi_param;
  public Map extend_info;
  public int get_type;
  public QzoneWeisiReqcommendReq qzone_weisi_req;
  public int req_type = 1;
  public int scene;
  public String ugckey = "";
  public long uin;
  public String video_url = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
    cache_req_type = 0;
  }
  
  public get_video_float_layer_req() {}
  
  public get_video_float_layer_req(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, Map paramMap1, Map paramMap2, String paramString3, int paramInt3, int paramInt4, QzoneWeisiReqcommendReq paramQzoneWeisiReqcommendReq)
  {
    this.uin = paramLong;
    this.scene = paramInt1;
    this.appid = paramInt2;
    this.ugckey = paramString1;
    this.video_url = paramString2;
    this.busi_param = paramMap1;
    this.extend_info = paramMap2;
    this.attach_info = paramString3;
    this.get_type = paramInt3;
    this.req_type = paramInt4;
    this.qzone_weisi_req = paramQzoneWeisiReqcommendReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.appid = paramJceInputStream.read(this.appid, 2, false);
    this.ugckey = paramJceInputStream.readString(3, false);
    this.video_url = paramJceInputStream.readString(4, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 6, false));
    this.attach_info = paramJceInputStream.readString(7, false);
    this.get_type = paramJceInputStream.read(this.get_type, 8, false);
    this.req_type = paramJceInputStream.read(this.req_type, 9, false);
    this.qzone_weisi_req = ((QzoneWeisiReqcommendReq)paramJceInputStream.read(cache_qzone_weisi_req, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.scene, 1);
    paramJceOutputStream.write(this.appid, 2);
    if (this.ugckey != null) {
      paramJceOutputStream.write(this.ugckey, 3);
    }
    if (this.video_url != null) {
      paramJceOutputStream.write(this.video_url, 4);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 6);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 7);
    }
    paramJceOutputStream.write(this.get_type, 8);
    paramJceOutputStream.write(this.req_type, 9);
    if (this.qzone_weisi_req != null) {
      paramJceOutputStream.write(this.qzone_weisi_req, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.get_video_float_layer_req
 * JD-Core Version:    0.7.0.1
 */