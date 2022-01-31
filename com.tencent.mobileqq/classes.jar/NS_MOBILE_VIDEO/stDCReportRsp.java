package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stDCReportRsp
  extends JceStruct
{
  public String nothing = "";
  
  public stDCReportRsp() {}
  
  public stDCReportRsp(String paramString)
  {
    this.nothing = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nothing = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nothing, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_VIDEO.stDCReportRsp
 * JD-Core Version:    0.7.0.1
 */