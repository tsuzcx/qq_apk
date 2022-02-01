package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestCancelBindMobile
  extends JceStruct
{
  static byte[] cache_encrptCancelMobileInfo = (byte[])new byte[1];
  public byte[] encrptCancelMobileInfo = null;
  public boolean isFromChangeBind = false;
  public boolean isFromUni = false;
  public boolean isSecNewReq = false;
  public String mobileNo = "";
  public String nationCode = "";
  
  static
  {
    ((byte[])cache_encrptCancelMobileInfo)[0] = 0;
  }
  
  public RequestCancelBindMobile() {}
  
  public RequestCancelBindMobile(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte)
  {
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.isFromUni = paramBoolean1;
    this.isFromChangeBind = paramBoolean2;
    this.isSecNewReq = paramBoolean3;
    this.encrptCancelMobileInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
    this.isFromUni = paramJceInputStream.read(this.isFromUni, 2, false);
    this.isFromChangeBind = paramJceInputStream.read(this.isFromChangeBind, 3, false);
    this.isSecNewReq = paramJceInputStream.read(this.isSecNewReq, 4, false);
    this.encrptCancelMobileInfo = ((byte[])paramJceInputStream.read(cache_encrptCancelMobileInfo, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
    paramJceOutputStream.write(this.isFromUni, 2);
    paramJceOutputStream.write(this.isFromChangeBind, 3);
    paramJceOutputStream.write(this.isSecNewReq, 4);
    if (this.encrptCancelMobileInfo != null) {
      paramJceOutputStream.write(this.encrptCancelMobileInfo, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestCancelBindMobile
 * JD-Core Version:    0.7.0.1
 */