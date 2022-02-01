package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Terminal
  extends JceStruct
{
  public String androidId = "";
  public String imei = "";
  public String imei2 = "";
  public String imsi = "";
  public String imsi2 = "";
  public String macAddress = "";
  public String manufacture = "";
  public String mid = "";
  public String mode = "";
  public String qimei = "";
  
  public Terminal() {}
  
  public Terminal(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    this.imei = paramString1;
    this.macAddress = paramString2;
    this.androidId = paramString3;
    this.imsi = paramString4;
    this.mid = paramString5;
    this.imsi2 = paramString6;
    this.imei2 = paramString7;
    this.mode = paramString8;
    this.manufacture = paramString9;
    this.qimei = paramString10;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, false);
    this.macAddress = paramJceInputStream.readString(1, false);
    this.androidId = paramJceInputStream.readString(2, false);
    this.imsi = paramJceInputStream.readString(3, false);
    this.mid = paramJceInputStream.readString(4, false);
    this.imsi2 = paramJceInputStream.readString(5, false);
    this.imei2 = paramJceInputStream.readString(6, false);
    this.mode = paramJceInputStream.readString(7, false);
    this.manufacture = paramJceInputStream.readString(8, false);
    this.qimei = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.imei;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.macAddress;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.androidId;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.imsi;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.mid;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.imsi2;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.imei2;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.mode;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.manufacture;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.qimei;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_NEW_MOBILE_REPORT.Terminal
 * JD-Core Version:    0.7.0.1
 */