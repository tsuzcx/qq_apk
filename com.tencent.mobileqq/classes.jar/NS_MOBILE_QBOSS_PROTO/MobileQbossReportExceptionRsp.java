package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MobileQbossReportExceptionRsp
  extends JceStruct
{
  public int iRet = 0;
  
  public MobileQbossReportExceptionRsp() {}
  
  public MobileQbossReportExceptionRsp(int paramInt)
  {
    this.iRet = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionRsp
 * JD-Core Version:    0.7.0.1
 */