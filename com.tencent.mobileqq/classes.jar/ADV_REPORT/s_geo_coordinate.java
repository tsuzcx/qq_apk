package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_geo_coordinate
  extends JceStruct
{
  public double latitude_axis = 0.0D;
  public double longitude_axis = 0.0D;
  
  public s_geo_coordinate() {}
  
  public s_geo_coordinate(double paramDouble1, double paramDouble2)
  {
    this.longitude_axis = paramDouble1;
    this.latitude_axis = paramDouble2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.longitude_axis = paramJceInputStream.read(this.longitude_axis, 0, false);
    this.latitude_axis = paramJceInputStream.read(this.latitude_axis, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.longitude_axis, 0);
    paramJceOutputStream.write(this.latitude_axis, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ADV_REPORT.s_geo_coordinate
 * JD-Core Version:    0.7.0.1
 */