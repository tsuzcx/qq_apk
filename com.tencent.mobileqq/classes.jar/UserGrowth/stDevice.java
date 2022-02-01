package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stDevice
  extends JceStruct
{
  public String encrypted_deviceid = "";
  public String idfa = "";
  public String imei = "";
  public String qimei = "";
  
  public stDevice() {}
  
  public stDevice(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.encrypted_deviceid = paramString1;
    this.imei = paramString2;
    this.idfa = paramString3;
    this.qimei = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.encrypted_deviceid = paramJceInputStream.readString(0, false);
    this.imei = paramJceInputStream.readString(1, false);
    this.idfa = paramJceInputStream.readString(2, false);
    this.qimei = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.encrypted_deviceid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.imei;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.idfa;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.qimei;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stDevice
 * JD-Core Version:    0.7.0.1
 */