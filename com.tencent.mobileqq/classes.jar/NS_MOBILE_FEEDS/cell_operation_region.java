package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_operation_region
  extends JceStruct
{
  static ArrayList<stRegionData> cache_vcRegion = new ArrayList();
  public String gestureLineColor = "";
  public int gestureRadius = 0;
  public int gestureStartTime = 0;
  public int interactiveType = 0;
  public ArrayList<stRegionData> vcRegion = null;
  
  static
  {
    stRegionData localstRegionData = new stRegionData();
    cache_vcRegion.add(localstRegionData);
  }
  
  public cell_operation_region() {}
  
  public cell_operation_region(ArrayList<stRegionData> paramArrayList, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.vcRegion = paramArrayList;
    this.interactiveType = paramInt1;
    this.gestureRadius = paramInt2;
    this.gestureStartTime = paramInt3;
    this.gestureLineColor = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vcRegion = ((ArrayList)paramJceInputStream.read(cache_vcRegion, 0, false));
    this.interactiveType = paramJceInputStream.read(this.interactiveType, 1, false);
    this.gestureRadius = paramJceInputStream.read(this.gestureRadius, 2, false);
    this.gestureStartTime = paramJceInputStream.read(this.gestureStartTime, 3, false);
    this.gestureLineColor = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vcRegion != null) {
      paramJceOutputStream.write(this.vcRegion, 0);
    }
    paramJceOutputStream.write(this.interactiveType, 1);
    paramJceOutputStream.write(this.gestureRadius, 2);
    paramJceOutputStream.write(this.gestureStartTime, 3);
    if (this.gestureLineColor != null) {
      paramJceOutputStream.write(this.gestureLineColor, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_operation_region
 * JD-Core Version:    0.7.0.1
 */