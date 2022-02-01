package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
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
  public Album albuminfo = null;
  public int appid = 0;
  public String attach_info = "";
  public Map<Integer, String> busi_param = null;
  public int curindex = 0;
  public Map<Integer, byte[]> features = null;
  public long finish = 0L;
  public int lossy_service = 0;
  public int photo_search_status = 1;
  public ArrayList<s_picdata> photolist = null;
  public stPhotoPoiAreaList pos = null;
  public ArrayList<Album> recommand_album = null;
  public RecommendPhotos recommend_photos = null;
  public s_outshare shareinfo = null;
  public ArrayList<TimeLine> timeline = null;
  public long total = 0L;
  public s_videoflow_user user = null;
  
  static
  {
    Object localObject1 = new s_picdata();
    cache_photolist.add(localObject1);
    cache_shareinfo = new s_outshare();
    cache_recommand_album = new ArrayList();
    localObject1 = new Album();
    cache_recommand_album.add(localObject1);
    cache_user = new s_videoflow_user();
    cache_features = new HashMap();
    localObject1 = Integer.valueOf(0);
    Object localObject2 = (byte[])new byte[1];
    ((byte[])localObject2)[0] = 0;
    cache_features.put(localObject1, localObject2);
    cache_recommend_photos = new RecommendPhotos();
    cache_pos = new stPhotoPoiAreaList();
    cache_timeline = new ArrayList();
    localObject2 = new TimeLine();
    cache_timeline.add(localObject2);
    cache_busi_param = new HashMap();
    cache_busi_param.put(localObject1, "");
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
    Object localObject = this.shareinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    paramJceOutputStream.write(this.lossy_service, 8);
    localObject = this.recommand_album;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.features;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 12);
    }
    localObject = this.recommend_photos;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.pos;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    localObject = this.timeline;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 15);
    }
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 17);
    }
    paramJceOutputStream.write(this.photo_search_status, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_list_2_rsp
 * JD-Core Version:    0.7.0.1
 */