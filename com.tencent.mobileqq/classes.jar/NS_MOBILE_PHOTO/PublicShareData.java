package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PublicShareData
  extends JceStruct
{
  public String cover = "";
  public String desc = "";
  public String h5url = "";
  public String schema = "";
  
  public PublicShareData() {}
  
  public PublicShareData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.cover = paramString1;
    this.desc = paramString2;
    this.h5url = paramString3;
    this.schema = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cover = paramJceInputStream.readString(0, false);
    this.desc = paramJceInputStream.readString(1, false);
    this.h5url = paramJceInputStream.readString(2, false);
    this.schema = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cover != null) {
      paramJceOutputStream.write(this.cover, 0);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
    if (this.h5url != null) {
      paramJceOutputStream.write(this.h5url, 2);
    }
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PublicShareData
 * JD-Core Version:    0.7.0.1
 */