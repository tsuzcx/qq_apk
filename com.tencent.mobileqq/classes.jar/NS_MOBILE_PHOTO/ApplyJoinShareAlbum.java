package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class ApplyJoinShareAlbum
  extends JceStruct
{
  public String albumid = "";
  public long owner;
  
  public ApplyJoinShareAlbum() {}
  
  public ApplyJoinShareAlbum(long paramLong, String paramString)
  {
    this.owner = paramLong;
    this.albumid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.owner = paramJceInputStream.read(this.owner, 0, false);
    this.albumid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.owner, 0);
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.ApplyJoinShareAlbum
 * JD-Core Version:    0.7.0.1
 */