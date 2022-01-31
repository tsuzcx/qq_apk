package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LBSInfo
  extends JceStruct
  implements Cloneable
{
  public double accuracy;
  public double altitude;
  public String city = "";
  public String district = "";
  public double latitude;
  public double longtitude;
  public String province = "";
  public String town = "";
  
  public LBSInfo() {}
  
  public LBSInfo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.latitude = paramDouble1;
    this.longtitude = paramDouble2;
    this.altitude = paramDouble3;
    this.accuracy = paramDouble4;
    this.province = paramString1;
    this.city = paramString2;
    this.district = paramString3;
    this.town = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.latitude = paramJceInputStream.read(this.latitude, 0, true);
    this.longtitude = paramJceInputStream.read(this.longtitude, 1, true);
    this.altitude = paramJceInputStream.read(this.altitude, 2, true);
    this.accuracy = paramJceInputStream.read(this.accuracy, 3, true);
    this.province = paramJceInputStream.readString(4, true);
    this.city = paramJceInputStream.readString(5, true);
    this.district = paramJceInputStream.readString(6, true);
    this.town = paramJceInputStream.readString(7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.latitude, 0);
    paramJceOutputStream.write(this.longtitude, 1);
    paramJceOutputStream.write(this.altitude, 2);
    paramJceOutputStream.write(this.accuracy, 3);
    paramJceOutputStream.write(this.province, 4);
    paramJceOutputStream.write(this.city, 5);
    paramJceOutputStream.write(this.district, 6);
    paramJceOutputStream.write(this.town, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     CardPay.LBSInfo
 * JD-Core Version:    0.7.0.1
 */