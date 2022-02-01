package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetFiltPhotoListRsp
  extends JceStruct
{
  static Album cache_albuminfo = new Album();
  static ArrayList<s_picdata> cache_photolist = new ArrayList();
  static s_outshare cache_shareinfo = new s_outshare();
  public Album albuminfo = null;
  public String attach_info = "";
  public boolean hasmore = false;
  public ArrayList<s_picdata> photolist = null;
  public s_outshare shareinfo = null;
  
  static
  {
    s_picdata locals_picdata = new s_picdata();
    cache_photolist.add(locals_picdata);
  }
  
  public GetFiltPhotoListRsp() {}
  
  public GetFiltPhotoListRsp(boolean paramBoolean, String paramString, Album paramAlbum, ArrayList<s_picdata> paramArrayList, s_outshare params_outshare)
  {
    this.hasmore = paramBoolean;
    this.attach_info = paramString;
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList;
    this.shareinfo = params_outshare;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.attach_info = paramJceInputStream.readString(1, false);
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 2, false));
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 3, false));
    this.shareinfo = ((s_outshare)paramJceInputStream.read(cache_shareinfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    Object localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.albuminfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.photolist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.shareinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetFiltPhotoListRsp
 * JD-Core Version:    0.7.0.1
 */