package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class lbs_info
  extends JceStruct
{
  public int category_id = 0;
  public String city = "";
  public int city_id = 0;
  public String continent = "";
  public String country = "";
  public String district = "";
  public int eType = 0;
  public String geoDesc = "";
  public int iAlt = 0;
  public int iLat = 0;
  public int iLon = 0;
  public int isInland = 0;
  public String poiDesc = "";
  public String province = "";
  public String road = "";
  public String scenery = "";
  public int source = 0;
  public String town = "";
  
  public lbs_info() {}
  
  public lbs_info(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt6, int paramInt7, String paramString9, String paramString10, int paramInt8)
  {
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.eType = paramInt3;
    this.iAlt = paramInt4;
    this.isInland = paramInt5;
    this.continent = paramString1;
    this.country = paramString2;
    this.province = paramString3;
    this.city = paramString4;
    this.district = paramString5;
    this.town = paramString6;
    this.road = paramString7;
    this.scenery = paramString8;
    this.category_id = paramInt6;
    this.city_id = paramInt7;
    this.geoDesc = paramString9;
    this.poiDesc = paramString10;
    this.source = paramInt8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLat = paramJceInputStream.read(this.iLat, 0, true);
    this.iLon = paramJceInputStream.read(this.iLon, 1, true);
    this.eType = paramJceInputStream.read(this.eType, 2, true);
    this.iAlt = paramJceInputStream.read(this.iAlt, 3, false);
    this.isInland = paramJceInputStream.read(this.isInland, 4, false);
    this.continent = paramJceInputStream.readString(5, false);
    this.country = paramJceInputStream.readString(6, false);
    this.province = paramJceInputStream.readString(7, false);
    this.city = paramJceInputStream.readString(8, false);
    this.district = paramJceInputStream.readString(9, false);
    this.town = paramJceInputStream.readString(10, false);
    this.road = paramJceInputStream.readString(11, false);
    this.scenery = paramJceInputStream.readString(12, false);
    this.category_id = paramJceInputStream.read(this.category_id, 13, false);
    this.city_id = paramJceInputStream.read(this.city_id, 14, false);
    this.geoDesc = paramJceInputStream.readString(15, false);
    this.poiDesc = paramJceInputStream.readString(16, false);
    this.source = paramJceInputStream.read(this.source, 17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
    paramJceOutputStream.write(this.eType, 2);
    paramJceOutputStream.write(this.iAlt, 3);
    paramJceOutputStream.write(this.isInland, 4);
    String str = this.continent;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.country;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.province;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.city;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.district;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.town;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.road;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.scenery;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    paramJceOutputStream.write(this.category_id, 13);
    paramJceOutputStream.write(this.city_id, 14);
    str = this.geoDesc;
    if (str != null) {
      paramJceOutputStream.write(str, 15);
    }
    str = this.poiDesc;
    if (str != null) {
      paramJceOutputStream.write(str, 16);
    }
    paramJceOutputStream.write(this.source, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.lbs_info
 * JD-Core Version:    0.7.0.1
 */