package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PhotoSearchBoxItem
  extends JceStruct
{
  static ArrayList<PhotoSearchBoxItemElem> cache_elems = new ArrayList();
  public String desc = "";
  public ArrayList<PhotoSearchBoxItemElem> elems = null;
  
  static
  {
    PhotoSearchBoxItemElem localPhotoSearchBoxItemElem = new PhotoSearchBoxItemElem();
    cache_elems.add(localPhotoSearchBoxItemElem);
  }
  
  public PhotoSearchBoxItem() {}
  
  public PhotoSearchBoxItem(ArrayList<PhotoSearchBoxItemElem> paramArrayList, String paramString)
  {
    this.elems = paramArrayList;
    this.desc = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.elems = ((ArrayList)paramJceInputStream.read(cache_elems, 0, false));
    this.desc = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.elems;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBoxItem
 * JD-Core Version:    0.7.0.1
 */