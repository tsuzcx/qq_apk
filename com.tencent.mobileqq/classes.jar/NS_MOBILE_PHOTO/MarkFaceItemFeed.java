package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarkFaceItemFeed
  extends JceStruct
{
  static stFaceItem cache_faceinfo = new stFaceItem();
  static int cache_op = 0;
  public String albumid = "";
  public stFaceItem faceinfo;
  public int op = 0;
  public String photoid = "";
  
  public MarkFaceItemFeed() {}
  
  public MarkFaceItemFeed(int paramInt, stFaceItem paramstFaceItem, String paramString1, String paramString2)
  {
    this.op = paramInt;
    this.faceinfo = paramstFaceItem;
    this.albumid = paramString1;
    this.photoid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op = paramJceInputStream.read(this.op, 0, false);
    this.faceinfo = ((stFaceItem)paramJceInputStream.read(cache_faceinfo, 1, false));
    this.albumid = paramJceInputStream.readString(2, false);
    this.photoid = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op, 0);
    if (this.faceinfo != null) {
      paramJceOutputStream.write(this.faceinfo, 1);
    }
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 2);
    }
    if (this.photoid != null) {
      paramJceOutputStream.write(this.photoid, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.MarkFaceItemFeed
 * JD-Core Version:    0.7.0.1
 */