package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LocationInfo
  extends JceStruct
{
  public int iBottom = 0;
  public int iLeft = 0;
  public int iRight = 0;
  public int iTop = 0;
  
  public LocationInfo() {}
  
  public LocationInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iLeft = paramInt1;
    this.iRight = paramInt2;
    this.iTop = paramInt3;
    this.iBottom = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLeft = paramJceInputStream.read(this.iLeft, 0, false);
    this.iRight = paramJceInputStream.read(this.iRight, 1, false);
    this.iTop = paramJceInputStream.read(this.iTop, 2, false);
    this.iBottom = paramJceInputStream.read(this.iBottom, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLeft, 0);
    paramJceOutputStream.write(this.iRight, 1);
    paramJceOutputStream.write(this.iTop, 2);
    paramJceOutputStream.write(this.iBottom, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.LocationInfo
 * JD-Core Version:    0.7.0.1
 */