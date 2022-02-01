package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SortPicReq
  extends JceStruct
{
  static int cache_sort_type;
  public String albumid = "";
  public int sort_type = 0;
  public long uin = 0L;
  
  public SortPicReq() {}
  
  public SortPicReq(long paramLong, String paramString, int paramInt)
  {
    this.uin = paramLong;
    this.albumid = paramString;
    this.sort_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.albumid = paramJceInputStream.readString(1, false);
    this.sort_type = paramJceInputStream.read(this.sort_type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    String str = this.albumid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.sort_type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.SortPicReq
 * JD-Core Version:    0.7.0.1
 */