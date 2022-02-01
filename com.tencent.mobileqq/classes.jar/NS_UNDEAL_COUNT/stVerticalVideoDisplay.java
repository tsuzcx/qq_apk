package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVerticalVideoDisplay
  extends JceStruct
{
  public int iAspectRatioHeight = -1;
  public int iAspectRatioWidth = -1;
  public int iFeedAspectRatio = -1;
  public int iType = -1;
  
  public stVerticalVideoDisplay() {}
  
  public stVerticalVideoDisplay(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iType = paramInt1;
    this.iFeedAspectRatio = paramInt2;
    this.iAspectRatioWidth = paramInt3;
    this.iAspectRatioHeight = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, false);
    this.iFeedAspectRatio = paramJceInputStream.read(this.iFeedAspectRatio, 1, false);
    this.iAspectRatioWidth = paramJceInputStream.read(this.iAspectRatioWidth, 2, false);
    this.iAspectRatioHeight = paramJceInputStream.read(this.iAspectRatioHeight, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    paramJceOutputStream.write(this.iFeedAspectRatio, 1);
    paramJceOutputStream.write(this.iAspectRatioWidth, 2);
    paramJceOutputStream.write(this.iAspectRatioHeight, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.stVerticalVideoDisplay
 * JD-Core Version:    0.7.0.1
 */