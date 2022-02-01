package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class CategoryRecommendItem
  extends JceStruct
{
  static ArrayList<PhotoFeedsData> cache_photos = new ArrayList();
  public String categoryid = "";
  public String desc = "";
  public ArrayList<PhotoFeedsData> photos = null;
  
  static
  {
    PhotoFeedsData localPhotoFeedsData = new PhotoFeedsData();
    cache_photos.add(localPhotoFeedsData);
  }
  
  public CategoryRecommendItem() {}
  
  public CategoryRecommendItem(ArrayList<PhotoFeedsData> paramArrayList, String paramString1, String paramString2)
  {
    this.photos = paramArrayList;
    this.categoryid = paramString1;
    this.desc = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 0, false));
    this.categoryid = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.photos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.categoryid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.CategoryRecommendItem
 * JD-Core Version:    0.7.0.1
 */