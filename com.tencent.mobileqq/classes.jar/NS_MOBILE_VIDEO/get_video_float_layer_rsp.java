package NS_MOBILE_VIDEO;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_video_float_layer_rsp
  extends JceStruct
{
  static ArrayList cache_all_after_paster_adv;
  static ArrayList cache_all_videolist_data = new ArrayList();
  static Map cache_busi_param;
  static Map cache_extend_info;
  static QzoneWeisiReqcommendRsp cache_qzone_weisi_rsp = new QzoneWeisiReqcommendRsp();
  static video_floating_layer_search_bar cache_search_bar;
  public ArrayList all_after_paster_adv;
  public ArrayList all_videolist_data;
  public String attach_info = "";
  public Map busi_param;
  public Map extend_info;
  public int hasmore;
  public QzoneWeisiReqcommendRsp qzone_weisi_rsp;
  public video_floating_layer_search_bar search_bar;
  
  static
  {
    single_feed localsingle_feed = new single_feed();
    cache_all_videolist_data.add(localsingle_feed);
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
    cache_search_bar = new video_floating_layer_search_bar();
    cache_all_after_paster_adv = new ArrayList();
    localsingle_feed = new single_feed();
    cache_all_after_paster_adv.add(localsingle_feed);
  }
  
  public get_video_float_layer_rsp() {}
  
  public get_video_float_layer_rsp(ArrayList paramArrayList1, Map paramMap1, Map paramMap2, int paramInt, String paramString, video_floating_layer_search_bar paramvideo_floating_layer_search_bar, ArrayList paramArrayList2, QzoneWeisiReqcommendRsp paramQzoneWeisiReqcommendRsp)
  {
    this.all_videolist_data = paramArrayList1;
    this.busi_param = paramMap1;
    this.extend_info = paramMap2;
    this.hasmore = paramInt;
    this.attach_info = paramString;
    this.search_bar = paramvideo_floating_layer_search_bar;
    this.all_after_paster_adv = paramArrayList2;
    this.qzone_weisi_rsp = paramQzoneWeisiReqcommendRsp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_videolist_data = ((ArrayList)paramJceInputStream.read(cache_all_videolist_data, 0, false));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 2, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
    this.search_bar = ((video_floating_layer_search_bar)paramJceInputStream.read(cache_search_bar, 5, false));
    this.all_after_paster_adv = ((ArrayList)paramJceInputStream.read(cache_all_after_paster_adv, 6, false));
    this.qzone_weisi_rsp = ((QzoneWeisiReqcommendRsp)paramJceInputStream.read(cache_qzone_weisi_rsp, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_videolist_data != null) {
      paramJceOutputStream.write(this.all_videolist_data, 0);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 2);
    }
    paramJceOutputStream.write(this.hasmore, 3);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 4);
    }
    if (this.search_bar != null) {
      paramJceOutputStream.write(this.search_bar, 5);
    }
    if (this.all_after_paster_adv != null) {
      paramJceOutputStream.write(this.all_after_paster_adv, 6);
    }
    if (this.qzone_weisi_rsp != null) {
      paramJceOutputStream.write(this.qzone_weisi_rsp, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.get_video_float_layer_rsp
 * JD-Core Version:    0.7.0.1
 */