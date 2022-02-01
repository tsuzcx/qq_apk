package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_get_photo_list_ex_rsp
  extends JceStruct
{
  static Album cache_albuminfo = new Album();
  static ArrayList<s_picdata> cache_photolist = new ArrayList();
  public Album albuminfo = null;
  public int appid = 0;
  public int imaxfetch = 0;
  public int index = 0;
  public int indexInVec = 0;
  public long left_finish = 0L;
  public ArrayList<s_picdata> photolist = null;
  public long right_finish = 0L;
  
  static
  {
    s_picdata locals_picdata = new s_picdata();
    cache_photolist.add(locals_picdata);
  }
  
  public qun_get_photo_list_ex_rsp() {}
  
  public qun_get_photo_list_ex_rsp(int paramInt1, Album paramAlbum, long paramLong1, long paramLong2, ArrayList<s_picdata> paramArrayList, int paramInt2, int paramInt3, int paramInt4)
  {
    this.index = paramInt1;
    this.albuminfo = paramAlbum;
    this.left_finish = paramLong1;
    this.right_finish = paramLong2;
    this.photolist = paramArrayList;
    this.imaxfetch = paramInt2;
    this.indexInVec = paramInt3;
    this.appid = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.index = paramJceInputStream.read(this.index, 0, true);
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 1, true));
    this.left_finish = paramJceInputStream.read(this.left_finish, 2, true);
    this.right_finish = paramJceInputStream.read(this.right_finish, 3, true);
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 4, true));
    this.imaxfetch = paramJceInputStream.read(this.imaxfetch, 5, false);
    this.indexInVec = paramJceInputStream.read(this.indexInVec, 6, false);
    this.appid = paramJceInputStream.read(this.appid, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.index, 0);
    paramJceOutputStream.write(this.albuminfo, 1);
    paramJceOutputStream.write(this.left_finish, 2);
    paramJceOutputStream.write(this.right_finish, 3);
    paramJceOutputStream.write(this.photolist, 4);
    paramJceOutputStream.write(this.imaxfetch, 5);
    paramJceOutputStream.write(this.indexInVec, 6);
    paramJceOutputStream.write(this.appid, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_photo_list_ex_rsp
 * JD-Core Version:    0.7.0.1
 */