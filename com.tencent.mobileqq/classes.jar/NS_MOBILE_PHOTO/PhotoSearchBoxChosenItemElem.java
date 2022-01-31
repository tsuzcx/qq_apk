package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoSearchBoxChosenItemElem
  extends JceStruct
{
  static int cache_type = 0;
  public String categoryid = "";
  public int type;
  
  public PhotoSearchBoxChosenItemElem() {}
  
  public PhotoSearchBoxChosenItemElem(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.categoryid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.categoryid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.categoryid != null) {
      paramJceOutputStream.write(this.categoryid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBoxChosenItemElem
 * JD-Core Version:    0.7.0.1
 */