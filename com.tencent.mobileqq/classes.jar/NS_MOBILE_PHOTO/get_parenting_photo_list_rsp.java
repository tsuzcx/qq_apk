package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class get_parenting_photo_list_rsp
  extends JceStruct
{
  static Album cache_albuminfo = new Album();
  static Map<Integer, String> cache_busi_param;
  static Map<Integer, byte[]> cache_features;
  static int cache_photo_search_status = 0;
  static ArrayList<s_picdata> cache_photolist = new ArrayList();
  static ArrayList<Album> cache_recommand_album;
  static RecommendPhotos cache_recommend_photos;
  static s_outshare cache_shareinfo;
  static ArrayList<TimeEvent> cache_timeevent;
  static ArrayList<TimeLine> cache_timeline;
  public Album albuminfo = null;
  public int appid = 0;
  public String attach_info = "";
  public Map<Integer, String> busi_param = null;
  public Map<Integer, byte[]> features = null;
  public int hasmore = 0;
  public int photo_search_status = 1;
  public ArrayList<s_picdata> photolist = null;
  public ArrayList<Album> recommand_album = null;
  public RecommendPhotos recommend_photos = null;
  public s_outshare shareinfo = null;
  public ArrayList<TimeEvent> timeevent = null;
  public ArrayList<TimeLine> timeline = null;
  
  static
  {
    Object localObject1 = new s_picdata();
    cache_photolist.add(localObject1);
    cache_timeline = new ArrayList();
    localObject1 = new TimeLine();
    cache_timeline.add(localObject1);
    cache_busi_param = new HashMap();
    localObject1 = Integer.valueOf(0);
    cache_busi_param.put(localObject1, "");
    cache_shareinfo = new s_outshare();
    cache_timeevent = new ArrayList();
    Object localObject2 = new TimeEvent();
    cache_timeevent.add(localObject2);
    cache_recommand_album = new ArrayList();
    localObject2 = new Album();
    cache_recommand_album.add(localObject2);
    cache_features = new HashMap();
    localObject2 = (byte[])new byte[1];
    ((byte[])localObject2)[0] = 0;
    cache_features.put(localObject1, localObject2);
    cache_recommend_photos = new RecommendPhotos();
  }
  
  public get_parenting_photo_list_rsp() {}
  
  public get_parenting_photo_list_rsp(Album paramAlbum, ArrayList<s_picdata> paramArrayList, String paramString, int paramInt1, ArrayList<TimeLine> paramArrayList1, Map<Integer, String> paramMap, int paramInt2, s_outshare params_outshare, ArrayList<TimeEvent> paramArrayList2, ArrayList<Album> paramArrayList3, Map<Integer, byte[]> paramMap1, RecommendPhotos paramRecommendPhotos, int paramInt3)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList;
    this.attach_info = paramString;
    this.hasmore = paramInt1;
    this.timeline = paramArrayList1;
    this.busi_param = paramMap;
    this.appid = paramInt2;
    this.shareinfo = params_outshare;
    this.timeevent = paramArrayList2;
    this.recommand_album = paramArrayList3;
    this.features = paramMap1;
    this.recommend_photos = paramRecommendPhotos;
    this.photo_search_status = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, true));
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, true));
    this.attach_info = paramJceInputStream.readString(2, false);
    this.hasmore = paramJceInputStream.read(this.hasmore, 3, false);
    this.timeline = ((ArrayList)paramJceInputStream.read(cache_timeline, 4, false));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.appid = paramJceInputStream.read(this.appid, 6, false);
    this.shareinfo = ((s_outshare)paramJceInputStream.read(cache_shareinfo, 7, false));
    this.timeevent = ((ArrayList)paramJceInputStream.read(cache_timeevent, 8, false));
    this.recommand_album = ((ArrayList)paramJceInputStream.read(cache_recommand_album, 9, false));
    this.features = ((Map)paramJceInputStream.read(cache_features, 10, false));
    this.recommend_photos = ((RecommendPhotos)paramJceInputStream.read(cache_recommend_photos, 11, false));
    this.photo_search_status = paramJceInputStream.read(this.photo_search_status, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 0);
    paramJceOutputStream.write(this.photolist, 1);
    Object localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.hasmore, 3);
    localObject = this.timeline;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    paramJceOutputStream.write(this.appid, 6);
    localObject = this.shareinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.timeevent;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    localObject = this.recommand_album;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    localObject = this.features;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 10);
    }
    localObject = this.recommend_photos;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    paramJceOutputStream.write(this.photo_search_status, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_parenting_photo_list_rsp
 * JD-Core Version:    0.7.0.1
 */