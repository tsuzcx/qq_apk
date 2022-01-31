package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class feed_info
  extends JceStruct
{
  public int appid;
  public long has_pic;
  public long opuin;
  public String strcontent = "";
  public String strkey = "";
  public long time;
  public int typeId;
  
  public feed_info() {}
  
  public feed_info(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.appid = paramInt1;
    this.typeId = paramInt2;
    this.time = paramLong1;
    this.opuin = paramLong2;
    this.strkey = paramString1;
    this.strcontent = paramString2;
    this.has_pic = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.typeId = paramJceInputStream.read(this.typeId, 1, false);
    this.time = paramJceInputStream.read(this.time, 2, false);
    this.opuin = paramJceInputStream.read(this.opuin, 3, false);
    this.strkey = paramJceInputStream.readString(4, false);
    this.strcontent = paramJceInputStream.readString(5, false);
    this.has_pic = paramJceInputStream.read(this.has_pic, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.typeId, 1);
    paramJceOutputStream.write(this.time, 2);
    paramJceOutputStream.write(this.opuin, 3);
    if (this.strkey != null) {
      paramJceOutputStream.write(this.strkey, 4);
    }
    if (this.strcontent != null) {
      paramJceOutputStream.write(this.strcontent, 5);
    }
    paramJceOutputStream.write(this.has_pic, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_NEWEST_FEEDS.feed_info
 * JD-Core Version:    0.7.0.1
 */