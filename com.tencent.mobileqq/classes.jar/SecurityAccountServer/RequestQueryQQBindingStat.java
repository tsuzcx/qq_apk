package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryQQBindingStat
  extends JceStruct
{
  public String MobileUniqueNo = "";
  
  public RequestQueryQQBindingStat() {}
  
  public RequestQueryQQBindingStat(String paramString)
  {
    this.MobileUniqueNo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MobileUniqueNo = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.MobileUniqueNo;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryQQBindingStat
 * JD-Core Version:    0.7.0.1
 */