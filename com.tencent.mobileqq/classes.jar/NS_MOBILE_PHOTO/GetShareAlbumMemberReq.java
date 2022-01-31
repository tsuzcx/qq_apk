package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class GetShareAlbumMemberReq
  extends JceStruct
{
  public String albumid;
  public long uin;
  
  public GetShareAlbumMemberReq() {}
  
  public GetShareAlbumMemberReq(long paramLong, String paramString)
  {
    this.uin = paramLong;
    this.albumid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.albumid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetShareAlbumMemberReq
 * JD-Core Version:    0.7.0.1
 */