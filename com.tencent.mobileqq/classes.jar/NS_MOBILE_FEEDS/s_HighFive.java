package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_HighFive
  extends JceStruct
{
  public long iCount;
  public String strResourceUrl = "";
  
  public s_HighFive() {}
  
  public s_HighFive(long paramLong, String paramString)
  {
    this.iCount = paramLong;
    this.strResourceUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCount = paramJceInputStream.read(this.iCount, 0, false);
    this.strResourceUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCount, 0);
    if (this.strResourceUrl != null) {
      paramJceOutputStream.write(this.strResourceUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_HighFive
 * JD-Core Version:    0.7.0.1
 */