package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class qun_get_photo_list_rsp
  extends JceStruct
{
  static ArrayList<Long> cache_adminUin;
  static Album cache_albuminfo;
  static ArrayList<s_picdata> cache_photolist;
  public ArrayList<Long> adminUin;
  public Album albuminfo;
  public String attach_info = "";
  public int hasmore;
  public int operationMask;
  public long ownerUin;
  public ArrayList<s_picdata> photolist;
  
  public qun_get_photo_list_rsp() {}
  
  public qun_get_photo_list_rsp(Album paramAlbum, ArrayList<s_picdata> paramArrayList, int paramInt1, String paramString, long paramLong, ArrayList<Long> paramArrayList1, int paramInt2)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList;
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.ownerUin = paramLong;
    this.adminUin = paramArrayList1;
    this.operationMask = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_albuminfo == null) {
      cache_albuminfo = new Album();
    }
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, true));
    if (cache_photolist == null)
    {
      cache_photolist = new ArrayList();
      s_picdata locals_picdata = new s_picdata();
      cache_photolist.add(locals_picdata);
    }
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, true));
    this.hasmore = paramJceInputStream.read(this.hasmore, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.ownerUin = paramJceInputStream.read(this.ownerUin, 4, false);
    if (cache_adminUin == null)
    {
      cache_adminUin = new ArrayList();
      cache_adminUin.add(Long.valueOf(0L));
    }
    this.adminUin = ((ArrayList)paramJceInputStream.read(cache_adminUin, 5, false));
    this.operationMask = paramJceInputStream.read(this.operationMask, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 0);
    paramJceOutputStream.write(this.photolist, 1);
    paramJceOutputStream.write(this.hasmore, 2);
    Object localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.ownerUin, 4);
    localObject = this.adminUin;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    paramJceOutputStream.write(this.operationMask, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_photo_list_rsp
 * JD-Core Version:    0.7.0.1
 */