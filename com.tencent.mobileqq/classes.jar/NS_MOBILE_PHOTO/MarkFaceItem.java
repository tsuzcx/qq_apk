package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarkFaceItem
  extends JceStruct
{
  static stFaceItem cache_faceinfo = new stFaceItem();
  static int cache_op = 0;
  public stFaceItem faceinfo;
  public int op = 0;
  
  public MarkFaceItem() {}
  
  public MarkFaceItem(int paramInt, stFaceItem paramstFaceItem)
  {
    this.op = paramInt;
    this.faceinfo = paramstFaceItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op = paramJceInputStream.read(this.op, 0, false);
    this.faceinfo = ((stFaceItem)paramJceInputStream.read(cache_faceinfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op, 0);
    if (this.faceinfo != null) {
      paramJceOutputStream.write(this.faceinfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.MarkFaceItem
 * JD-Core Version:    0.7.0.1
 */