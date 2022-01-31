package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetCustomOnlineStatusRsp
  extends JceStruct
{
  public int iRet;
  public String sBuffer = "";
  public String sMsg = "";
  
  public GetCustomOnlineStatusRsp() {}
  
  public GetCustomOnlineStatusRsp(int paramInt, String paramString1, String paramString2)
  {
    this.iRet = paramInt;
    this.sMsg = paramString1;
    this.sBuffer = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, false);
    this.sMsg = paramJceInputStream.readString(1, false);
    this.sBuffer = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    if (this.sMsg != null) {
      paramJceOutputStream.write(this.sMsg, 1);
    }
    if (this.sBuffer != null) {
      paramJceOutputStream.write(this.sBuffer, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.GetCustomOnlineStatusRsp
 * JD-Core Version:    0.7.0.1
 */