package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_photo_list_2_rsp
  extends JceStruct
{
  static Album cache_albuminfo = new Album();
  static Map<Integer, String> cache_busi_param;
  static Map<Integer, byte[]> cache_features;
  static int cache_photo_search_status = 0;
  static ArrayList<s_picdata> cache_photolist = new ArrayList();
  static stPhotoPoiAreaList cache_pos;
  static ArrayList<Album> cache_recommand_album;
  static RecommendPhotos cache_recommend_photos;
  static s_outshare cache_shareinfo;
  static ArrayList<TimeLine> cache_timeline;
  static s_videoflow_user cache_user;
  public Album albuminfo;
  public int appid;
  public String attach_info = "";
  public Map<Integer, String> busi_param;
  public int curindex;
  public Map<Integer, byte[]> features;
  public long finish;
  public int lossy_service;
  public int photo_search_status = 1;
  public ArrayList<s_picdata> photolist;
  public stPhotoPoiAreaList pos;
  public ArrayList<Album> recommand_album;
  public RecommendPhotos recommend_photos;
  public s_outshare shareinfo;
  public ArrayList<TimeLine> timeline;
  public long total;
  public s_videoflow_user user;
  
  static
  {
    Object localObject = new s_picdata();
    cache_photolist.add(localObject);
    cache_shareinfo = new s_outshare();
    cache_recommand_album = new ArrayList();
    localObject = new Album();
    cache_recommand_album.add(localObject);
    cache_user = new s_videoflow_user();
    cache_features = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_features.put(Integer.valueOf(0), localObject);
    cache_recommend_photos = new RecommendPhotos();
    cache_pos = new stPhotoPoiAreaList();
    cache_timeline = new ArrayList();
    localObject = new TimeLine();
    cache_timeline.add(localObject);
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public get_photo_list_2_rsp() {}
  
  public get_photo_list_2_rsp(Album paramAlbum, ArrayList<s_picdata> paramArrayList, int paramInt1, int paramInt2, long paramLong1, long paramLong2, s_outshare params_outshare, int paramInt3, ArrayList<Album> paramArrayList1, s_videoflow_user params_videoflow_user, Map<Integer, byte[]> paramMap, RecommendPhotos paramRecommendPhotos, stPhotoPoiAreaList paramstPhotoPoiAreaList, ArrayList<TimeLine> paramArrayList2, String paramString, Map<Integer, String> paramMap1, int paramInt4)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList;
    this.curindex = paramInt1;
    this.appid = paramInt2;
    this.total = paramLong1;
    this.finish = paramLong2;
    this.shareinfo = params_outshare;
    this.lossy_service = paramInt3;
    this.recommand_album = paramArrayList1;
    this.user = params_videoflow_user;
    this.features = paramMap;
    this.recommend_photos = paramRecommendPhotos;
    this.pos = paramstPhotoPoiAreaList;
    this.timeline = paramArrayList2;
    this.attach_info = paramString;
    this.busi_param = paramMap1;
    this.photo_search_status = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 1, true));
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 2, true));
    this.curindex = paramJceInputStream.read(this.curindex, 3, false);
    this.appid = paramJceInputStream.read(this.appid, 4, false);
    this.total = paramJceInputStream.read(this.total, 5, false);
    this.finish = paramJceInputStream.read(this.finish, 6, false);
    this.shareinfo = ((s_outshare)paramJceInputStream.read(cache_shareinfo, 7, false));
    this.lossy_service = paramJceInputStream.read(this.lossy_service, 8, false);
    this.recommand_album = ((ArrayList)paramJceInputStream.read(cache_recommand_album, 9, false));
    this.user = ((s_videoflow_user)paramJceInputStream.read(cache_user, 11, false));
    this.features = ((Map)paramJceInputStream.read(cache_features, 12, false));
    this.recommend_photos = ((RecommendPhotos)paramJceInputStream.read(cache_recommend_photos, 13, false));
    this.pos = ((stPhotoPoiAreaList)paramJceInputStream.read(cache_pos, 14, false));
    this.timeline = ((ArrayList)paramJceInputStream.read(cache_timeline, 15, false));
    this.attach_info = paramJceInputStream.readString(16, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 17, false));
    this.photo_search_status = paramJceInputStream.read(this.photo_search_status, 18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 1);
    paramJceOutputStream.write(this.photolist, 2);
    paramJceOutputStream.write(this.curindex, 3);
    paramJceOutputStream.write(this.appid, 4);
    paramJceOutputStream.write(this.total, 5);
    paramJceOutputStream.write(this.finish, 6);
    if (this.shareinfo != null) {
      paramJceOutputStream.write(this.shareinfo, 7);
    }
    paramJceOutputStream.write(this.lossy_service, 8);
    if (this.recommand_album != null) {
      paramJceOutputStream.write(this.recommand_album, 9);
    }
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 11);
    }
    if (this.features != null) {
      paramJceOutputStream.write(this.features, 12);
    }
    if (this.recommend_photos != null) {
      paramJceOutputStream.write(this.recommend_photos, 13);
    }
    if (this.pos != null) {
      paramJceOutputStream.write(this.pos, 14);
    }
    if (this.timeline != null) {
      paramJceOutputStream.write(this.timeline, 15);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 16);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 17);
    }
    paramJceOutputStream.write(this.photo_search_status, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_list_2_rsp
 * JD-Core Version:    0.7.0.1
 */