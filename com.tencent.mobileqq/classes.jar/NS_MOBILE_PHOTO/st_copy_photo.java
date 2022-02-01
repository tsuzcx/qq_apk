package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class st_copy_photo
  extends JceStruct
{
  public String albumid = "";
  public long owneruin = 0L;
  public String photoid = "";
  
  public st_copy_photo() {}
  
  public st_copy_photo(long paramLong, String paramString1, String paramString2)
  {
    this.owneruin = paramLong;
    this.albumid = paramString1;
    this.photoid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.owneruin = paramJceInputStream.read(this.owneruin, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.photoid = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.owneruin, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.photoid, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.st_copy_photo
 * JD-Core Version:    0.7.0.1
 */