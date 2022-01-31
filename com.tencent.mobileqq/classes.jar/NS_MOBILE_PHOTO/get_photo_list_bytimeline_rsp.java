package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_photo_list_bytimeline_rsp
  extends JceStruct
{
  static Album cache_albuminfo = new Album();
  static Map<Integer, String> cache_busi_param;
  static ArrayList<s_picdata> cache_photolist = new ArrayList();
  static stPhotoPoiAreaList cache_pos;
  static s_outshare cache_shareinfo;
  static ArrayList<TimeEvent> cache_timeevent;
  static ArrayList<TimeLine> cache_timeline;
  public Album albuminfo;
  public int appid;
  public String attach_info = "";
  public Map<Integer, String> busi_param;
  public ArrayList<s_picdata> photolist;
  public stPhotoPoiAreaList pos;
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
    cache_pos = new stPhotoPoiAreaList();
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_shareinfo = new s_outshare();
    cache_timeevent = new ArrayList();
    localObject = new TimeEvent();
    cache_timeevent.add(localObject);
  }
  
  public get_photo_list_bytimeline_rsp() {}
  
  public get_photo_list_bytimeline_rsp(Album paramAlbum, ArrayList<s_picdata> paramArrayList, String paramString, ArrayList<TimeLine> paramArrayList1, stPhotoPoiAreaList paramstPhotoPoiAreaList, Map<Integer, String> paramMap, int paramInt, s_outshare params_outshare, ArrayList<TimeEvent> paramArrayList2)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList;
    this.attach_info = paramString;
    this.timeline = paramArrayList1;
    this.pos = paramstPhotoPoiAreaList;
    this.busi_param = paramMap;
    this.appid = paramInt;
    this.shareinfo = params_outshare;
    this.timeevent = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, true));
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, true));
    this.attach_info = paramJceInputStream.readString(2, false);
    this.timeline = ((ArrayList)paramJceInputStream.read(cache_timeline, 3, false));
    this.pos = ((stPhotoPoiAreaList)paramJceInputStream.read(cache_pos, 4, false));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.appid = paramJceInputStream.read(this.appid, 6, false);
    this.shareinfo = ((s_outshare)paramJceInputStream.read(cache_shareinfo, 7, false));
    this.timeevent = ((ArrayList)paramJceInputStream.read(cache_timeevent, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 0);
    paramJceOutputStream.write(this.photolist, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    if (this.timeline != null) {
      paramJceOutputStream.write(this.timeline, 3);
    }
    if (this.pos != null) {
      paramJceOutputStream.write(this.pos, 4);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_list_bytimeline_rsp
 * JD-Core Version:    0.7.0.1
 */