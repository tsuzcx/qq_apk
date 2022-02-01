package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DcStandardReportRsp
  extends JceStruct
{
  public int ret_code = 0;
  public String ret_msg = "";
  
  public DcStandardReportRsp() {}
  
  public DcStandardReportRsp(int paramInt, String paramString)
  {
    this.ret_code = paramInt;
    this.ret_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.ret_msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    String str = this.ret_msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.DcStandardReportRsp
 * JD-Core Version:    0.7.0.1
 */