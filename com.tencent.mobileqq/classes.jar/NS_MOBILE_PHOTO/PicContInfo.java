package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PicContInfo
  extends JceStruct
{
  public String md5 = "";
  public long size = 0L;
  
  public PicContInfo() {}
  
  public PicContInfo(String paramString, long paramLong)
  {
    this.md5 = paramString;
    this.size = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.md5 = paramJceInputStream.readString(0, false);
    this.size = paramJceInputStream.read(this.size, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.md5;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.size, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PicContInfo
 * JD-Core Version:    0.7.0.1
 */