package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AccessRspHead
  extends JceStruct
{
  public int err_code = 0;
  public String err_msg = "";
  
  public AccessRspHead() {}
  
  public AccessRspHead(int paramInt, String paramString)
  {
    this.err_code = paramInt;
    this.err_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.err_code = paramJceInputStream.read(this.err_code, 0, false);
    this.err_msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.err_code, 0);
    String str = this.err_msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_NEW_MOBILE_REPORT.AccessRspHead
 * JD-Core Version:    0.7.0.1
 */