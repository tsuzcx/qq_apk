package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_memory_seal_off;
import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class get_all_feedsphoto_ex_rsp
  extends JceStruct
{
  static ArrayList<PhotoFeedsData> cache_all_applist_data = new ArrayList();
  static photo_tab_category_control cache_category_infos;
  static Map<String, String> cache_extend_info;
  static single_feed cache_share_album;
  static s_memory_seal_off cache_stMemoryInfo = new s_memory_seal_off();
  static ArrayList<TabTimeLine> cache_timeline;
  public ArrayList<PhotoFeedsData> all_applist_data = null;
  public String attach_info = "";
  public int auto_load = 0;
  public photo_tab_category_control category_infos = null;
  public Map<String, String> extend_info = null;
  public int hasmore = 0;
  public int lossy_service = 0;
  public int remain_count = 0;
  public single_feed share_album = null;
  public s_memory_seal_off stMemoryInfo = null;
  public ArrayList<TabTimeLine> timeline = null;
  
  static
  {
    Object localObject = new PhotoFeedsData();
    cache_all_applist_data.add(localObject);
    cache_share_album = new single_feed();
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
    cache_category_infos = new photo_tab_category_control();
    cache_timeline = new ArrayList();
    localObject = new TabTimeLine();
    cache_timeline.add(localObject);
  }
  
  public get_all_feedsphoto_ex_rsp() {}
  
  public get_all_feedsphoto_ex_rsp(ArrayList<PhotoFeedsData> paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, single_feed paramsingle_feed, int paramInt4, Map<String, String> paramMap, photo_tab_category_control paramphoto_tab_category_control, ArrayList<TabTimeLine> paramArrayList1, s_memory_seal_off params_memory_seal_off)
  {
    this.all_applist_data = paramArrayList;
    this.hasmore = paramInt1;
    this.remain_count = paramInt2;
    this.attach_info = paramString;
    this.auto_load = paramInt3;
    this.share_album = paramsingle_feed;
    this.lossy_service = paramInt4;
    this.extend_info = paramMap;
    this.category_infos = paramphoto_tab_category_control;
    this.timeline = paramArrayList1;
    this.stMemoryInfo = params_memory_seal_off;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_applist_data = ((ArrayList)paramJceInputStream.read(cache_all_applist_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.remain_count = paramJceInputStream.read(this.remain_count, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.auto_load = paramJceInputStream.read(this.auto_load, 4, false);
    this.share_album = ((single_feed)paramJceInputStream.read(cache_share_album, 5, false));
    this.lossy_service = paramJceInputStream.read(this.lossy_service, 7, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 8, false));
    this.category_infos = ((photo_tab_category_control)paramJceInputStream.read(cache_category_infos, 9, false));
    this.timeline = ((ArrayList)paramJceInputStream.read(cache_timeline, 10, false));
    this.stMemoryInfo = ((s_memory_seal_off)paramJceInputStream.read(cache_stMemoryInfo, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.all_applist_data;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    paramJceOutputStream.write(this.remain_count, 2);
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.auto_load, 4);
    localObject = this.share_album;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.lossy_service, 7);
    localObject = this.extend_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    localObject = this.category_infos;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.timeline;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
    }
    localObject = this.stMemoryInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_all_feedsphoto_ex_rsp
 * JD-Core Version:    0.7.0.1
 */