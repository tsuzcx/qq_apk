package NS_MOBILE_VIDEO;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class get_video_float_layer_rsp
  extends JceStruct
{
  static WeishiAggregatePageRsp cache_aggregate_page_rsp;
  static ArrayList<single_feed> cache_all_after_paster_adv;
  static ArrayList<single_feed> cache_all_videolist_data = new ArrayList();
  static byte[] cache_busi_binary_data;
  static Map<Integer, String> cache_busi_param;
  static Map<String, String> cache_extend_info;
  static QzoneWeisiReqcommendRsp cache_qzone_weisi_rsp;
  static video_floating_layer_search_bar cache_search_bar;
  public WeishiAggregatePageRsp aggregate_page_rsp = null;
  public ArrayList<single_feed> all_after_paster_adv = null;
  public ArrayList<single_feed> all_videolist_data = null;
  public String attach_info = "";
  public byte[] busi_binary_data = null;
  public Map<Integer, String> busi_param = null;
  public Map<String, String> extend_info = null;
  public int hasmore = 0;
  public QzoneWeisiReqcommendRsp qzone_weisi_rsp = null;
  public video_floating_layer_search_bar search_bar = null;
  
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
    cache_qzone_weisi_rsp = new QzoneWeisiReqcommendRsp();
    cache_aggregate_page_rsp = new WeishiAggregatePageRsp();
    cache_busi_binary_data = (byte[])new byte[1];
    ((byte[])cache_busi_binary_data)[0] = 0;
  }
  
  public get_video_float_layer_rsp() {}
  
  public get_video_float_layer_rsp(ArrayList<single_feed> paramArrayList1, Map<Integer, String> paramMap, Map<String, String> paramMap1, int paramInt, String paramString, video_floating_layer_search_bar paramvideo_floating_layer_search_bar, ArrayList<single_feed> paramArrayList2, QzoneWeisiReqcommendRsp paramQzoneWeisiReqcommendRsp, WeishiAggregatePageRsp paramWeishiAggregatePageRsp, byte[] paramArrayOfByte)
  {
    this.all_videolist_data = paramArrayList1;
    this.busi_param = paramMap;
    this.extend_info = paramMap1;
    this.hasmore = paramInt;
    this.attach_info = paramString;
    this.search_bar = paramvideo_floating_layer_search_bar;
    this.all_after_paster_adv = paramArrayList2;
    this.qzone_weisi_rsp = paramQzoneWeisiReqcommendRsp;
    this.aggregate_page_rsp = paramWeishiAggregatePageRsp;
    this.busi_binary_data = paramArrayOfByte;
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
    this.aggregate_page_rsp = ((WeishiAggregatePageRsp)paramJceInputStream.read(cache_aggregate_page_rsp, 8, false));
    this.busi_binary_data = ((byte[])paramJceInputStream.read(cache_busi_binary_data, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.all_videolist_data;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.extend_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    paramJceOutputStream.write(this.hasmore, 3);
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.search_bar;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.all_after_paster_adv;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    localObject = this.qzone_weisi_rsp;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.aggregate_page_rsp;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.busi_binary_data;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.get_video_float_layer_rsp
 * JD-Core Version:    0.7.0.1
 */