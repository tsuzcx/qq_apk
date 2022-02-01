package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPoi
  extends JceStruct
{
  public String poi_address = "";
  public String poi_id = "";
  public String poi_name = "";
  public int poi_type;
  public String poi_x = "";
  public String poi_y = "";
  
  public stPoi() {}
  
  public stPoi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.poi_id = paramString1;
    this.poi_x = paramString2;
    this.poi_y = paramString3;
    this.poi_name = paramString4;
    this.poi_address = paramString5;
    this.poi_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.poi_id = paramJceInputStream.readString(0, true);
    this.poi_x = paramJceInputStream.readString(1, true);
    this.poi_y = paramJceInputStream.readString(2, true);
    this.poi_name = paramJceInputStream.readString(3, true);
    this.poi_address = paramJceInputStream.readString(4, true);
    this.poi_type = paramJceInputStream.read(this.poi_type, 5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.poi_id, 0);
    paramJceOutputStream.write(this.poi_x, 1);
    paramJceOutputStream.write(this.poi_y, 2);
    paramJceOutputStream.write(this.poi_name, 3);
    paramJceOutputStream.write(this.poi_address, 4);
    paramJceOutputStream.write(this.poi_type, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.stPoi
 * JD-Core Version:    0.7.0.1
 */