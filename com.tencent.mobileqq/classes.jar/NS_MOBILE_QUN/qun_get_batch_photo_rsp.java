package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_get_batch_photo_rsp
  extends JceStruct
{
  static Album cache_albuminfo;
  static ArrayList<s_picdata> cache_photolist;
  public Album albuminfo;
  public String attach_info = "";
  public int hasmore;
  public ArrayList<s_picdata> photolist;
  
  public qun_get_batch_photo_rsp() {}
  
  public qun_get_batch_photo_rsp(Album paramAlbum, ArrayList<s_picdata> paramArrayList, int paramInt, String paramString)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList;
    this.hasmore = paramInt;
    this.attach_info = paramString;
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 0);
    paramJceOutputStream.write(this.photolist, 1);
    paramJceOutputStream.write(this.hasmore, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_batch_photo_rsp
 * JD-Core Version:    0.7.0.1
 */