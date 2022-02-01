package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AlarmInfo
  extends JceStruct
{
  public String issueContent = "";
  public int issueTime = 0;
  public float lat = 0.0F;
  public float lon = 0.0F;
  public int relieveTime = 0;
  public String signalLevel = "";
  public int signalLevelInt = 0;
  public String signalType = "";
  public int signalTypeInt = 0;
  public long stationId = 0L;
  public String stationName = "";
  
  public AlarmInfo() {}
  
  public AlarmInfo(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4)
  {
    this.stationId = paramLong;
    this.stationName = paramString1;
    this.signalType = paramString2;
    this.signalLevel = paramString3;
    this.issueTime = paramInt1;
    this.relieveTime = paramInt2;
    this.issueContent = paramString4;
    this.lon = paramFloat1;
    this.lat = paramFloat2;
    this.signalTypeInt = paramInt3;
    this.signalLevelInt = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stationId = paramJceInputStream.read(this.stationId, 0, true);
    this.stationName = paramJceInputStream.readString(1, true);
    this.signalType = paramJceInputStream.readString(2, true);
    this.signalLevel = paramJceInputStream.readString(3, true);
    this.issueTime = paramJceInputStream.read(this.issueTime, 4, true);
    this.relieveTime = paramJceInputStream.read(this.relieveTime, 5, true);
    this.issueContent = paramJceInputStream.readString(6, true);
    this.lon = paramJceInputStream.read(this.lon, 7, true);
    this.lat = paramJceInputStream.read(this.lat, 8, true);
    this.signalTypeInt = paramJceInputStream.read(this.signalTypeInt, 9, false);
    this.signalLevelInt = paramJceInputStream.read(this.signalLevelInt, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stationId, 0);
    paramJceOutputStream.write(this.stationName, 1);
    paramJceOutputStream.write(this.signalType, 2);
    paramJceOutputStream.write(this.signalLevel, 3);
    paramJceOutputStream.write(this.issueTime, 4);
    paramJceOutputStream.write(this.relieveTime, 5);
    paramJceOutputStream.write(this.issueContent, 6);
    paramJceOutputStream.write(this.lon, 7);
    paramJceOutputStream.write(this.lat, 8);
    paramJceOutputStream.write(this.signalTypeInt, 9);
    paramJceOutputStream.write(this.signalLevelInt, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.AlarmInfo
 * JD-Core Version:    0.7.0.1
 */