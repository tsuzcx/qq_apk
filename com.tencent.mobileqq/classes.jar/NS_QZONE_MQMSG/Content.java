package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class Content
  extends JceStruct
{
  static ArrayList<PhotoCell> cache_vecPhotoCell = new ArrayList();
  public String contentMainTitle = "";
  public String contentSmallTitle = "";
  public int mediaType = 0;
  public ArrayList<PhotoCell> vecPhotoCell = null;
  
  static
  {
    PhotoCell localPhotoCell = new PhotoCell();
    cache_vecPhotoCell.add(localPhotoCell);
  }
  
  public Content() {}
  
  public Content(int paramInt, String paramString1, String paramString2, ArrayList<PhotoCell> paramArrayList)
  {
    this.mediaType = paramInt;
    this.contentMainTitle = paramString1;
    this.contentSmallTitle = paramString2;
    this.vecPhotoCell = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mediaType = paramJceInputStream.read(this.mediaType, 0, false);
    this.contentMainTitle = paramJceInputStream.readString(1, false);
    this.contentSmallTitle = paramJceInputStream.readString(2, false);
    this.vecPhotoCell = ((ArrayList)paramJceInputStream.read(cache_vecPhotoCell, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mediaType, 0);
    Object localObject = this.contentMainTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.contentSmallTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.vecPhotoCell;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.Content
 * JD-Core Version:    0.7.0.1
 */