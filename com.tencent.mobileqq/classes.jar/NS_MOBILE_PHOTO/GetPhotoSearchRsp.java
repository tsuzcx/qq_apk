package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetPhotoSearchRsp
  extends JceStruct
{
  static PhotoSearchBox cache_photo_search_box = new PhotoSearchBox();
  static PhotoSearchBoxPhoto cache_photo_search_box_photo = new PhotoSearchBoxPhoto();
  static s_outshare cache_shareinfo = new s_outshare();
  public String msg = "";
  public PhotoSearchBox photo_search_box = null;
  public PhotoSearchBoxPhoto photo_search_box_photo = null;
  public int ret = 0;
  public long share_ctime = 0L;
  public s_outshare shareinfo = null;
  
  public GetPhotoSearchRsp() {}
  
  public GetPhotoSearchRsp(int paramInt, String paramString, PhotoSearchBox paramPhotoSearchBox, PhotoSearchBoxPhoto paramPhotoSearchBoxPhoto, s_outshare params_outshare, long paramLong)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.photo_search_box = paramPhotoSearchBox;
    this.photo_search_box_photo = paramPhotoSearchBoxPhoto;
    this.shareinfo = params_outshare;
    this.share_ctime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.photo_search_box = ((PhotoSearchBox)paramJceInputStream.read(cache_photo_search_box, 2, false));
    this.photo_search_box_photo = ((PhotoSearchBoxPhoto)paramJceInputStream.read(cache_photo_search_box_photo, 3, false));
    this.shareinfo = ((s_outshare)paramJceInputStream.read(cache_shareinfo, 4, false));
    this.share_ctime = paramJceInputStream.read(this.share_ctime, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.photo_search_box != null) {
      paramJceOutputStream.write(this.photo_search_box, 2);
    }
    if (this.photo_search_box_photo != null) {
      paramJceOutputStream.write(this.photo_search_box_photo, 3);
    }
    if (this.shareinfo != null) {
      paramJceOutputStream.write(this.shareinfo, 4);
    }
    paramJceOutputStream.write(this.share_ctime, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetPhotoSearchRsp
 * JD-Core Version:    0.7.0.1
 */