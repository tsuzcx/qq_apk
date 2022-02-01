package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarkFaceInPhotoRsp
  extends JceStruct
{
  static stFaceItem cache_faceitem = new stFaceItem();
  public stFaceItem faceitem = null;
  public String msg = "";
  public int ret = 0;
  
  public MarkFaceInPhotoRsp() {}
  
  public MarkFaceInPhotoRsp(int paramInt, String paramString, stFaceItem paramstFaceItem)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.faceitem = paramstFaceItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.faceitem = ((stFaceItem)paramJceInputStream.read(cache_faceitem, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.faceitem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.MarkFaceInPhotoRsp
 * JD-Core Version:    0.7.0.1
 */