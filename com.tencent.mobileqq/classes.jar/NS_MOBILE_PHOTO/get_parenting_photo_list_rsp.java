package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
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
  public Album albuminfo;
  public int appid;
  public String attach_info = "";
  public Map<Integer, String> busi_param;
  public Map<Integer, byte[]> features;
  public int hasmore;
  public int photo_search_status = 1;
  public ArrayList<s_picdata> photolist;
  public ArrayList<Album> recommand_album;
  public RecommendPhotos recommend_photos;
  public s_outshare shareinfo;
  public ArrayList<TimeEvent> timeevent;
  public ArrayList<TimeLine> timeline;
  
  static
  {
    Object localObject = new s_picdata();
    cache_photolist.add(localObject);
    cache_timeline = new ArrayList();
    localObject = new TimeLine();
    cache_timeline.add(localObject);
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_shareinfo = new s_outshare();
    cache_timeevent = new ArrayList();
    localObject = new TimeEvent();
    cache_timeevent.add(localObject);
    cache_recommand_album = new ArrayList();
    localObject = new Album();
    cache_recommand_album.add(localObject);
    cache_features = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_features.put(Integer.valueOf(0), localObject);
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
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.hasmore, 3);
    if (this.timeline != null) {
      paramJceOutputStream.write(this.timeline, 4);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
    paramJceOutputStream.write(this.appid, 6);
    if (this.shareinfo != null) {
      paramJceOutputStream.write(this.shareinfo, 7);
    }
    if (this.timeevent != null) {
      paramJceOutputStream.write(this.timeevent, 8);
    }
    if (this.recommand_album != null) {
      paramJceOutputStream.write(this.recommand_album, 9);
    }
    if (this.features != null) {
      paramJceOutputStream.write(this.features, 10);
    }
    if (this.recommend_photos != null) {
      paramJceOutputStream.write(this.recommend_photos, 11);
    }
    paramJceOutputStream.write(this.photo_search_status, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_parenting_photo_list_rsp
 * JD-Core Version:    0.7.0.1
 */