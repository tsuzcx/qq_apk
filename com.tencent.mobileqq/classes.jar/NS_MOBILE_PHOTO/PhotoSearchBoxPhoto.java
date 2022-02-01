package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PhotoSearchBoxPhoto
  extends JceStruct
{
  static ArrayList<PhotoFeedsData> cache_photos = new ArrayList();
  public String attach_info = "";
  public boolean hasmore = false;
  public ArrayList<PhotoFeedsData> photos = null;
  public long total = 0L;
  
  static
  {
    PhotoFeedsData localPhotoFeedsData = new PhotoFeedsData();
    cache_photos.add(localPhotoFeedsData);
  }
  
  public PhotoSearchBoxPhoto() {}
  
  public PhotoSearchBoxPhoto(ArrayList<PhotoFeedsData> paramArrayList, long paramLong, boolean paramBoolean, String paramString)
  {
    this.photos = paramArrayList;
    this.total = paramLong;
    this.hasmore = paramBoolean;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 0, false));
    this.total = paramJceInputStream.read(this.total, 1, false);
    this.hasmore = paramJceInputStream.read(this.hasmore, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.photos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    paramJceOutputStream.write(this.total, 1);
    paramJceOutputStream.write(this.hasmore, 2);
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBoxPhoto
 * JD-Core Version:    0.7.0.1
 */