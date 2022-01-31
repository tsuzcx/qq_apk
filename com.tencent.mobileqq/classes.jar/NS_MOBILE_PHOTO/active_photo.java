package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class active_photo
  extends JceStruct
{
  public String albumid = "";
  public String desc = "";
  public String photoid = "";
  public String title = "";
  
  public active_photo() {}
  
  public active_photo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.albumid = paramString1;
    this.photoid = paramString2;
    this.title = paramString3;
    this.desc = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof active_photo)) {}
    do
    {
      return false;
      paramObject = (active_photo)paramObject;
    } while ((!paramObject.albumid.equals(this.albumid)) || (!paramObject.photoid.equals(this.photoid)) || (!paramObject.title.equals(this.title)) || (!paramObject.desc.equals(this.desc)));
    return true;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.photoid = paramJceInputStream.readString(1, true);
    this.title = paramJceInputStream.readString(2, true);
    this.desc = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.photoid, 1);
    paramJceOutputStream.write(this.title, 2);
    paramJceOutputStream.write(this.desc, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.active_photo
 * JD-Core Version:    0.7.0.1
 */