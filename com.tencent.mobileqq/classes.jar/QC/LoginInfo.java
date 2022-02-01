package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LoginInfo
  extends JceStruct
{
  public int iKeyType = 1;
  public int iOpplat = 0;
  public long lUin = 0L;
  public String sClientIp = "";
  public String sClientVer = "";
  public String sSKey = "";
  
  public LoginInfo() {}
  
  public LoginInfo(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    this.lUin = paramLong;
    this.iKeyType = paramInt1;
    this.sSKey = paramString1;
    this.sClientIp = paramString2;
    this.iOpplat = paramInt2;
    this.sClientVer = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.iKeyType = paramJceInputStream.read(this.iKeyType, 1, false);
    this.sSKey = paramJceInputStream.readString(2, false);
    this.sClientIp = paramJceInputStream.readString(3, false);
    this.iOpplat = paramJceInputStream.read(this.iOpplat, 4, false);
    this.sClientVer = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iKeyType, 1);
    if (this.sSKey != null) {
      paramJceOutputStream.write(this.sSKey, 2);
    }
    if (this.sClientIp != null) {
      paramJceOutputStream.write(this.sClientIp, 3);
    }
    paramJceOutputStream.write(this.iOpplat, 4);
    if (this.sClientVer != null) {
      paramJceOutputStream.write(this.sClientVer, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.LoginInfo
 * JD-Core Version:    0.7.0.1
 */