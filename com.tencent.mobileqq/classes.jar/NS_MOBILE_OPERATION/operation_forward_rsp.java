package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_forward_rsp
  extends JceStruct
{
  public String msg = "";
  public String newid = "";
  public int ret;
  public String verifyurl = "";
  
  public operation_forward_rsp() {}
  
  public operation_forward_rsp(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.newid = paramString2;
    this.verifyurl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.newid = paramJceInputStream.readString(2, false);
    this.verifyurl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.newid != null) {
      paramJceOutputStream.write(this.newid, 2);
    }
    if (this.verifyurl != null) {
      paramJceOutputStream.write(this.verifyurl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_forward_rsp
 * JD-Core Version:    0.7.0.1
 */