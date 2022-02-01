package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryNewUserRecommendedListNotBind
  extends JceStruct
{
  public String MobileUniqueNo = "";
  public long WantNum = 0L;
  
  public RequestQueryNewUserRecommendedListNotBind() {}
  
  public RequestQueryNewUserRecommendedListNotBind(String paramString, long paramLong)
  {
    this.MobileUniqueNo = paramString;
    this.WantNum = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MobileUniqueNo = paramJceInputStream.readString(1, false);
    this.WantNum = paramJceInputStream.read(this.WantNum, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.MobileUniqueNo;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.WantNum, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryNewUserRecommendedListNotBind
 * JD-Core Version:    0.7.0.1
 */