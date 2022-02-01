package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportExceptionInfo
  extends JceStruct
{
  static int cache_iCode;
  public int iAppid = 0;
  public int iCode = 0;
  public int iTaskId = 0;
  public String strMsg = "";
  
  public ReportExceptionInfo() {}
  
  public ReportExceptionInfo(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.iAppid = paramInt1;
    this.iTaskId = paramInt2;
    this.iCode = paramInt3;
    this.strMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppid = paramJceInputStream.read(this.iAppid, 0, false);
    this.iTaskId = paramJceInputStream.read(this.iTaskId, 1, false);
    this.iCode = paramJceInputStream.read(this.iCode, 2, false);
    this.strMsg = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppid, 0);
    paramJceOutputStream.write(this.iTaskId, 1);
    paramJceOutputStream.write(this.iCode, 2);
    String str = this.strMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.ReportExceptionInfo
 * JD-Core Version:    0.7.0.1
 */