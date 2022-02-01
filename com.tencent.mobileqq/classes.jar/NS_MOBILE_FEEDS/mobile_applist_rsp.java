package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_applist_rsp
  extends JceStruct
{
  static last_album_area_info cache_album_area_info = new last_album_area_info();
  static ArrayList<single_feed> cache_all_applist_data = new ArrayList();
  static Map<String, String> cache_extend_info;
  static s_life_moment cache_life_moment_info;
  static Map<String, byte[]> cache_mapEx;
  static single_feed cache_share_album;
  static s_memory_seal_off cache_stMemoryInfo;
  public last_album_area_info album_area_info = null;
  public int album_count = 0;
  public ArrayList<single_feed> all_applist_data = null;
  public String attach_info = "";
  public int auto_load = 0;
  public int dailyShuoShuoCount = 0;
  public Map<String, String> extend_info = null;
  public int hasmore = 0;
  public int kantu_album_count = 0;
  public s_life_moment life_moment_info = null;
  public int lossy_service = 0;
  public Map<String, byte[]> mapEx = null;
  public int photo_count = 0;
  public int remain_count = 0;
  public single_feed share_album = null;
  public int shuoshuo_timer_unpublished_count = 0;
  public s_memory_seal_off stMemoryInfo = null;
  public int video_count = 0;
  
  static
  {
    Object localObject = new single_feed();
    cache_all_applist_data.add(localObject);
    cache_share_album = new single_feed();
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
    cache_stMemoryInfo = new s_memory_seal_off();
    cache_mapEx = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_mapEx.put("", localObject);
    cache_life_moment_info = new s_life_moment();
  }
  
  public mobile_applist_rsp() {}
  
  public mobile_applist_rsp(ArrayList<single_feed> paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, single_feed paramsingle_feed, int paramInt4, Map<String, String> paramMap, int paramInt5, int paramInt6, int paramInt7, s_memory_seal_off params_memory_seal_off, Map<String, byte[]> paramMap1, int paramInt8, s_life_moment params_life_moment, last_album_area_info paramlast_album_area_info, int paramInt9, int paramInt10)
  {
    this.all_applist_data = paramArrayList;
    this.hasmore = paramInt1;
    this.remain_count = paramInt2;
    this.attach_info = paramString;
    this.auto_load = paramInt3;
    this.share_album = paramsingle_feed;
    this.lossy_service = paramInt4;
    this.extend_info = paramMap;
    this.album_count = paramInt5;
    this.photo_count = paramInt6;
    this.video_count = paramInt7;
    this.stMemoryInfo = params_memory_seal_off;
    this.mapEx = paramMap1;
    this.shuoshuo_timer_unpublished_count = paramInt8;
    this.life_moment_info = params_life_moment;
    this.album_area_info = paramlast_album_area_info;
    this.kantu_album_count = paramInt9;
    this.dailyShuoShuoCount = paramInt10;
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
    this.album_count = paramJceInputStream.read(this.album_count, 9, false);
    this.photo_count = paramJceInputStream.read(this.photo_count, 10, false);
    this.video_count = paramJceInputStream.read(this.video_count, 11, false);
    this.stMemoryInfo = ((s_memory_seal_off)paramJceInputStream.read(cache_stMemoryInfo, 12, false));
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 13, false));
    this.shuoshuo_timer_unpublished_count = paramJceInputStream.read(this.shuoshuo_timer_unpublished_count, 14, false);
    this.life_moment_info = ((s_life_moment)paramJceInputStream.read(cache_life_moment_info, 15, false));
    this.album_area_info = ((last_album_area_info)paramJceInputStream.read(cache_album_area_info, 16, false));
    this.kantu_album_count = paramJceInputStream.read(this.kantu_album_count, 17, false);
    this.dailyShuoShuoCount = paramJceInputStream.read(this.dailyShuoShuoCount, 18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_applist_data != null) {
      paramJceOutputStream.write(this.all_applist_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    paramJceOutputStream.write(this.remain_count, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.auto_load, 4);
    if (this.share_album != null) {
      paramJceOutputStream.write(this.share_album, 5);
    }
    paramJceOutputStream.write(this.lossy_service, 7);
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 8);
    }
    paramJceOutputStream.write(this.album_count, 9);
    paramJceOutputStream.write(this.photo_count, 10);
    paramJceOutputStream.write(this.video_count, 11);
    if (this.stMemoryInfo != null) {
      paramJceOutputStream.write(this.stMemoryInfo, 12);
    }
    if (this.mapEx != null) {
      paramJceOutputStream.write(this.mapEx, 13);
    }
    paramJceOutputStream.write(this.shuoshuo_timer_unpublished_count, 14);
    if (this.life_moment_info != null) {
      paramJceOutputStream.write(this.life_moment_info, 15);
    }
    if (this.album_area_info != null) {
      paramJceOutputStream.write(this.album_area_info, 16);
    }
    paramJceOutputStream.write(this.kantu_album_count, 17);
    paramJceOutputStream.write(this.dailyShuoShuoCount, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_applist_rsp
 * JD-Core Version:    0.7.0.1
 */