package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_video_float_layer_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_extend_info;
  static byte[] cache_layer_user_session_action;
  static QzoneWeisiReqcommendReq cache_qzone_weisi_req;
  static int cache_req_type;
  public int appid;
  public String attach_info = "";
  public Map<Integer, String> busi_param;
  public Map<String, String> extend_info;
  public int get_type;
  public byte[] layer_user_session_action;
  public QzoneWeisiReqcommendReq qzone_weisi_req;
  public int req_type = 1;
  public String rooftop_id = "";
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
    cache_qzone_weisi_req = new QzoneWeisiReqcommendReq();
    cache_layer_user_session_action = (byte[])new byte[1];
    ((byte[])cache_layer_user_session_action)[0] = 0;
  }
  
  public get_video_float_layer_req() {}
  
  public get_video_float_layer_req(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, Map<Integer, String> paramMap, Map<String, String> paramMap1, String paramString3, int paramInt3, int paramInt4, QzoneWeisiReqcommendReq paramQzoneWeisiReqcommendReq, String paramString4, byte[] paramArrayOfByte)
  {
    this.uin = paramLong;
    this.scene = paramInt1;
    this.appid = paramInt2;
    this.ugckey = paramString1;
    this.video_url = paramString2;
    this.busi_param = paramMap;
    this.extend_info = paramMap1;
    this.attach_info = paramString3;
    this.get_type = paramInt3;
    this.req_type = paramInt4;
    this.qzone_weisi_req = paramQzoneWeisiReqcommendReq;
    this.rooftop_id = paramString4;
    this.layer_user_session_action = paramArrayOfByte;
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
    this.rooftop_id = paramJceInputStream.readString(11, false);
    this.layer_user_session_action = ((byte[])paramJceInputStream.read(cache_layer_user_session_action, 12, false));
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
    if (this.rooftop_id != null) {
      paramJceOutputStream.write(this.rooftop_id, 11);
    }
    if (this.layer_user_session_action != null) {
      paramJceOutputStream.write(this.layer_user_session_action, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.get_video_float_layer_req
 * JD-Core Version:    0.7.0.1
 */