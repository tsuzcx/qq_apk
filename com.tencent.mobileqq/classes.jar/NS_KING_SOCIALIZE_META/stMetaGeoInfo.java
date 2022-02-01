package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaGeoInfo
  extends JceStruct
{
  public float altitude = -10000000.0F;
  public String city = "";
  public String country = "";
  public int distance = 0;
  public String district = "";
  public float latitude = 9.0E+008F;
  public float longitude = 9.0E+008F;
  public String name = "";
  public String polyGeoID = "";
  public String province = "";
  
  public stMetaGeoInfo() {}
  
  public stMetaGeoInfo(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this.country = paramString1;
    this.province = paramString2;
    this.city = paramString3;
    this.latitude = paramFloat1;
    this.longitude = paramFloat2;
    this.altitude = paramFloat3;
    this.district = paramString4;
    this.name = paramString5;
    this.distance = paramInt;
    this.polyGeoID = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.country = paramJceInputStream.readString(0, false);
    this.province = paramJceInputStream.readString(1, false);
    this.city = paramJceInputStream.readString(2, false);
    this.latitude = paramJceInputStream.read(this.latitude, 3, false);
    this.longitude = paramJceInputStream.read(this.longitude, 4, false);
    this.altitude = paramJceInputStream.read(this.altitude, 5, false);
    this.district = paramJceInputStream.readString(6, false);
    this.name = paramJceInputStream.readString(7, false);
    this.distance = paramJceInputStream.read(this.distance, 8, false);
    this.polyGeoID = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.country;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.province;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.city;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.latitude, 3);
    paramJceOutputStream.write(this.longitude, 4);
    paramJceOutputStream.write(this.altitude, 5);
    str = this.district;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.name;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    paramJceOutputStream.write(this.distance, 8);
    str = this.polyGeoID;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaGeoInfo
 * JD-Core Version:    0.7.0.1
 */