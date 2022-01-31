package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MobileQbossReportRsp
  extends JceStruct
{
  public int iRet;
  public String sMsg = "";
  
  public MobileQbossReportRsp() {}
  
  public MobileQbossReportRsp(int paramInt, String paramString)
  {
    this.iRet = paramInt;
    this.sMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.sMsg = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.sMsg, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp
 * JD-Core Version:    0.7.0.1
 */