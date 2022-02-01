package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class comm_qzone_report_rsp
  extends JceStruct
{
  public int iRetCode = 0;
  public String strErrorMsg = "";
  
  public comm_qzone_report_rsp() {}
  
  public comm_qzone_report_rsp(int paramInt, String paramString)
  {
    this.iRetCode = paramInt;
    this.strErrorMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRetCode = paramJceInputStream.read(this.iRetCode, 0, false);
    this.strErrorMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRetCode, 0);
    if (this.strErrorMsg != null) {
      paramJceOutputStream.write(this.strErrorMsg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.comm_qzone_report_rsp
 * JD-Core Version:    0.7.0.1
 */