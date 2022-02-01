package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PostBar
  extends JceStruct
{
  static PostBarBottom cache_bottom = new PostBarBottom();
  static ArrayList<String> cache_userAvatar;
  static ArrayList<PhotoCell> cache_vecImage = new ArrayList();
  public PostBarBottom bottom = null;
  public String icon = "";
  public int leadType = 0;
  public String summary = "";
  public String title = "";
  public ArrayList<String> userAvatar = null;
  public ArrayList<PhotoCell> vecImage = null;
  
  static
  {
    PhotoCell localPhotoCell = new PhotoCell();
    cache_vecImage.add(localPhotoCell);
    cache_userAvatar = new ArrayList();
    cache_userAvatar.add("");
  }
  
  public PostBar() {}
  
  public PostBar(int paramInt, ArrayList<PhotoCell> paramArrayList, ArrayList<String> paramArrayList1, String paramString1, String paramString2, String paramString3, PostBarBottom paramPostBarBottom)
  {
    this.leadType = paramInt;
    this.vecImage = paramArrayList;
    this.userAvatar = paramArrayList1;
    this.icon = paramString1;
    this.title = paramString2;
    this.summary = paramString3;
    this.bottom = paramPostBarBottom;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.leadType = paramJceInputStream.read(this.leadType, 0, false);
    this.vecImage = ((ArrayList)paramJceInputStream.read(cache_vecImage, 1, false));
    this.userAvatar = ((ArrayList)paramJceInputStream.read(cache_userAvatar, 2, false));
    this.icon = paramJceInputStream.readString(3, false);
    this.title = paramJceInputStream.readString(4, false);
    this.summary = paramJceInputStream.readString(5, false);
    this.bottom = ((PostBarBottom)paramJceInputStream.read(cache_bottom, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.leadType, 0);
    Object localObject = this.vecImage;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.userAvatar;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.bottom;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.PostBar
 * JD-Core Version:    0.7.0.1
 */