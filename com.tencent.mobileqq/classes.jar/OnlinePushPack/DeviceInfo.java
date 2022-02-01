package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DeviceInfo
  extends JceStruct
{
  public byte cNetType = 0;
  public String strDevType = "";
  public String strIOSIdfa = "";
  public String strOSVer = "";
  public String strVendorName = "";
  public String strVendorOSName = "";
  
  public DeviceInfo() {}
  
  public DeviceInfo(byte paramByte, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.cNetType = paramByte;
    this.strDevType = paramString1;
    this.strOSVer = paramString2;
    this.strVendorName = paramString3;
    this.strVendorOSName = paramString4;
    this.strIOSIdfa = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cNetType = paramJceInputStream.read(this.cNetType, 0, false);
    this.strDevType = paramJceInputStream.readString(1, false);
    this.strOSVer = paramJceInputStream.readString(2, false);
    this.strVendorName = paramJceInputStream.readString(3, false);
    this.strVendorOSName = paramJceInputStream.readString(4, false);
    this.strIOSIdfa = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cNetType, 0);
    if (this.strDevType != null) {
      paramJceOutputStream.write(this.strDevType, 1);
    }
    if (this.strOSVer != null) {
      paramJceOutputStream.write(this.strOSVer, 2);
    }
    if (this.strVendorName != null) {
      paramJceOutputStream.write(this.strVendorName, 3);
    }
    if (this.strVendorOSName != null) {
      paramJceOutputStream.write(this.strVendorOSName, 4);
    }
    if (this.strIOSIdfa != null) {
      paramJceOutputStream.write(this.strIOSIdfa, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     OnlinePushPack.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */