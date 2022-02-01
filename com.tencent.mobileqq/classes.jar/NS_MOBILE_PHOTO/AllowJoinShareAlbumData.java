package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AllowJoinShareAlbumData
  extends JceStruct
{
  public String albumid = "";
  public long joiner = 0L;
  public long owner = 0L;
  
  public AllowJoinShareAlbumData() {}
  
  public AllowJoinShareAlbumData(long paramLong1, long paramLong2, String paramString)
  {
    this.joiner = paramLong1;
    this.owner = paramLong2;
    this.albumid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.joiner = paramJceInputStream.read(this.joiner, 0, false);
    this.owner = paramJceInputStream.read(this.owner, 1, false);
    this.albumid = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.joiner, 0);
    paramJceOutputStream.write(this.owner, 1);
    String str = this.albumid;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.AllowJoinShareAlbumData
 * JD-Core Version:    0.7.0.1
 */