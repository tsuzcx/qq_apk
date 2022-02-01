package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class get_feedsphoto_bytimeline_rsp
  extends JceStruct
{
  static ArrayList<PhotoFeedsData> cache_all_applist_data = new ArrayList();
  public ArrayList<PhotoFeedsData> all_applist_data = null;
  public String attach_info = "";
  public int hasmore = 0;
  
  static
  {
    PhotoFeedsData localPhotoFeedsData = new PhotoFeedsData();
    cache_all_applist_data.add(localPhotoFeedsData);
  }
  
  public get_feedsphoto_bytimeline_rsp() {}
  
  public get_feedsphoto_bytimeline_rsp(ArrayList<PhotoFeedsData> paramArrayList, int paramInt, String paramString)
  {
    this.all_applist_data = paramArrayList;
    this.hasmore = paramInt;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_applist_data = ((ArrayList)paramJceInputStream.read(cache_all_applist_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.all_applist_data;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_feedsphoto_bytimeline_rsp
 * JD-Core Version:    0.7.0.1
 */