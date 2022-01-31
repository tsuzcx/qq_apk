package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_photo_list_ex_rsp
  extends JceStruct
{
  static Album cache_albuminfo = new Album();
  static Map cache_features;
  static ArrayList cache_photolist = new ArrayList();
  public Album albuminfo;
  public int appid;
  public Map features;
  public int imaxfetch;
  public int index;
  public int indexInVec;
  public long left_finish;
  public int lossy_service;
  public ArrayList photolist;
  public long right_finish;
  
  static
  {
    Object localObject = new Photo();
    cache_photolist.add(localObject);
    cache_features = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_features.put(Integer.valueOf(0), localObject);
  }
  
  public get_photo_list_ex_rsp() {}
  
  public get_photo_list_ex_rsp(int paramInt1, Album paramAlbum, long paramLong1, long paramLong2, ArrayList paramArrayList, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Map paramMap)
  {
    this.index = paramInt1;
    this.albuminfo = paramAlbum;
    this.left_finish = paramLong1;
    this.right_finish = paramLong2;
    this.photolist = paramArrayList;
    this.imaxfetch = paramInt2;
    this.appid = paramInt3;
    this.indexInVec = paramInt4;
    this.lossy_service = paramInt5;
    this.features = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.index = paramJceInputStream.read(this.index, 0, true);
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 1, true));
    this.left_finish = paramJceInputStream.read(this.left_finish, 2, true);
    this.right_finish = paramJceInputStream.read(this.right_finish, 3, true);
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 4, true));
    this.imaxfetch = paramJceInputStream.read(this.imaxfetch, 5, false);
    this.appid = paramJceInputStream.read(this.appid, 6, false);
    this.indexInVec = paramJceInputStream.read(this.indexInVec, 7, false);
    this.lossy_service = paramJceInputStream.read(this.lossy_service, 8, false);
    this.features = ((Map)paramJceInputStream.read(cache_features, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.index, 0);
    paramJceOutputStream.write(this.albuminfo, 1);
    paramJceOutputStream.write(this.left_finish, 2);
    paramJceOutputStream.write(this.right_finish, 3);
    paramJceOutputStream.write(this.photolist, 4);
    paramJceOutputStream.write(this.imaxfetch, 5);
    paramJceOutputStream.write(this.appid, 6);
    paramJceOutputStream.write(this.indexInVec, 7);
    paramJceOutputStream.write(this.lossy_service, 8);
    if (this.features != null) {
      paramJceOutputStream.write(this.features, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_list_ex_rsp
 * JD-Core Version:    0.7.0.1
 */