package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GameCoverInfo
  extends JceStruct
{
  public int jmpType;
  public String jmpUrl = "";
  public String schema = "";
  public double xCoordLU;
  public double xCoordRD;
  public double yCoordLU;
  public double yCoordRD;
  
  public GameCoverInfo() {}
  
  public GameCoverInfo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, int paramInt)
  {
    this.xCoordLU = paramDouble1;
    this.yCoordLU = paramDouble2;
    this.xCoordRD = paramDouble3;
    this.yCoordRD = paramDouble4;
    this.jmpUrl = paramString1;
    this.schema = paramString2;
    this.jmpType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.xCoordLU = paramJceInputStream.read(this.xCoordLU, 0, false);
    this.yCoordLU = paramJceInputStream.read(this.yCoordLU, 1, false);
    this.xCoordRD = paramJceInputStream.read(this.xCoordRD, 2, false);
    this.yCoordRD = paramJceInputStream.read(this.yCoordRD, 3, false);
    this.jmpUrl = paramJceInputStream.readString(4, false);
    this.schema = paramJceInputStream.readString(5, false);
    this.jmpType = paramJceInputStream.read(this.jmpType, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.xCoordLU, 0);
    paramJceOutputStream.write(this.yCoordLU, 1);
    paramJceOutputStream.write(this.xCoordRD, 2);
    paramJceOutputStream.write(this.yCoordRD, 3);
    if (this.jmpUrl != null) {
      paramJceOutputStream.write(this.jmpUrl, 4);
    }
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 5);
    }
    paramJceOutputStream.write(this.jmpType, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_COVER_DATE.GameCoverInfo
 * JD-Core Version:    0.7.0.1
 */