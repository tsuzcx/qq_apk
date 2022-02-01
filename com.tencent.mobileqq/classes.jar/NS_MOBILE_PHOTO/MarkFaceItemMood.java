package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarkFaceItemMood
  extends JceStruct
{
  static stFaceItem cache_faceinfo = new stFaceItem();
  static int cache_op;
  public stFaceItem faceinfo = null;
  public int op = 0;
  public String photo_url = "";
  public String shuoshuo_id = "";
  
  public MarkFaceItemMood() {}
  
  public MarkFaceItemMood(int paramInt, stFaceItem paramstFaceItem, String paramString1, String paramString2)
  {
    this.op = paramInt;
    this.faceinfo = paramstFaceItem;
    this.shuoshuo_id = paramString1;
    this.photo_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op = paramJceInputStream.read(this.op, 0, false);
    this.faceinfo = ((stFaceItem)paramJceInputStream.read(cache_faceinfo, 1, false));
    this.shuoshuo_id = paramJceInputStream.readString(2, false);
    this.photo_url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op, 0);
    Object localObject = this.faceinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.shuoshuo_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.photo_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.MarkFaceItemMood
 * JD-Core Version:    0.7.0.1
 */