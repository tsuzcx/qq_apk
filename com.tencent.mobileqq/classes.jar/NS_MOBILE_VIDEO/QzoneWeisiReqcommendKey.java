package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzoneWeisiReqcommendKey
  extends JceStruct
{
  public String feed_id = "";
  public String ugckey = "";
  public long uin = 0L;
  
  public QzoneWeisiReqcommendKey() {}
  
  public QzoneWeisiReqcommendKey(String paramString1, String paramString2, long paramLong)
  {
    this.feed_id = paramString1;
    this.ugckey = paramString2;
    this.uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(0, false);
    this.ugckey = paramJceInputStream.readString(1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.feed_id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.ugckey;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.uin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.QzoneWeisiReqcommendKey
 * JD-Core Version:    0.7.0.1
 */