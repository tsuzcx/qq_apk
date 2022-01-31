package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFaceInfo
  extends JceStruct
{
  public String url = "";
  
  public stFaceInfo() {}
  
  public stFaceInfo(String paramString)
  {
    this.url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.stFaceInfo
 * JD-Core Version:    0.7.0.1
 */