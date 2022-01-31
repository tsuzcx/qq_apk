package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class copy_photo_req
  extends JceStruct
{
  static ArrayList<st_copy_photo> cache_photos = new ArrayList();
  public String desc = "";
  public String dstAlbumType = "";
  public String dstAlbumid = "";
  public ArrayList<st_copy_photo> photos;
  public String reqSource = "";
  public long uin;
  
  static
  {
    st_copy_photo localst_copy_photo = new st_copy_photo();
    cache_photos.add(localst_copy_photo);
  }
  
  public copy_photo_req() {}
  
  public copy_photo_req(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<st_copy_photo> paramArrayList)
  {
    this.uin = paramLong;
    this.reqSource = paramString1;
    this.dstAlbumid = paramString2;
    this.dstAlbumType = paramString3;
    this.desc = paramString4;
    this.photos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.reqSource = paramJceInputStream.readString(1, true);
    this.dstAlbumid = paramJceInputStream.readString(2, true);
    this.dstAlbumType = paramJceInputStream.readString(3, true);
    this.desc = paramJceInputStream.readString(4, true);
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 5, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.reqSource, 1);
    paramJceOutputStream.write(this.dstAlbumid, 2);
    paramJceOutputStream.write(this.dstAlbumType, 3);
    paramJceOutputStream.write(this.desc, 4);
    paramJceOutputStream.write(this.photos, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.copy_photo_req
 * JD-Core Version:    0.7.0.1
 */