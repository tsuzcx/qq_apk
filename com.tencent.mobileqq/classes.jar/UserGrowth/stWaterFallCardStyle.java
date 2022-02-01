package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWaterFallCardStyle
  extends JceStruct
{
  public int cardType = 0;
  public boolean isFullSpan = true;
  public boolean isVertical = true;
  public int ratioH = 0;
  public int ratioW = 0;
  
  public stWaterFallCardStyle() {}
  
  public stWaterFallCardStyle(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cardType = paramInt1;
    this.ratioW = paramInt2;
    this.ratioH = paramInt3;
    this.isFullSpan = paramBoolean1;
    this.isVertical = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cardType = paramJceInputStream.read(this.cardType, 0, false);
    this.ratioW = paramJceInputStream.read(this.ratioW, 1, false);
    this.ratioH = paramJceInputStream.read(this.ratioH, 2, false);
    this.isFullSpan = paramJceInputStream.read(this.isFullSpan, 3, false);
    this.isVertical = paramJceInputStream.read(this.isVertical, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cardType, 0);
    paramJceOutputStream.write(this.ratioW, 1);
    paramJceOutputStream.write(this.ratioH, 2);
    paramJceOutputStream.write(this.isFullSpan, 3);
    paramJceOutputStream.write(this.isVertical, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stWaterFallCardStyle
 * JD-Core Version:    0.7.0.1
 */