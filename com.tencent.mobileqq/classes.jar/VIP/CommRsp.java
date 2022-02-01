package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommRsp
  extends JceStruct
{
  public int iErrCode = 0;
  public String sErrMsg = "";
  
  public CommRsp() {}
  
  public CommRsp(int paramInt, String paramString)
  {
    this.iErrCode = paramInt;
    this.sErrMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iErrCode = paramJceInputStream.read(this.iErrCode, 0, false);
    this.sErrMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iErrCode, 0);
    String str = this.sErrMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.CommRsp
 * JD-Core Version:    0.7.0.1
 */