package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_KapuPraise
  extends JceStruct
{
  public long iCount;
  public int iItemId;
  public String strName = "";
  
  public s_KapuPraise() {}
  
  public s_KapuPraise(int paramInt, long paramLong, String paramString)
  {
    this.iItemId = paramInt;
    this.iCount = paramLong;
    this.strName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.iCount = paramJceInputStream.read(this.iCount, 1, false);
    this.strName = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    paramJceOutputStream.write(this.iCount, 1);
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_KapuPraise
 * JD-Core Version:    0.7.0.1
 */