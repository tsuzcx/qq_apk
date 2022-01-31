package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWaterFallCardStyle
  extends JceStruct
{
  public int cardType;
  public boolean isFullSpan = true;
  public int ratioH;
  public int ratioW;
  
  public stWaterFallCardStyle() {}
  
  public stWaterFallCardStyle(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.cardType = paramInt1;
    this.ratioW = paramInt2;
    this.ratioH = paramInt3;
    this.isFullSpan = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cardType = paramJceInputStream.read(this.cardType, 0, false);
    this.ratioW = paramJceInputStream.read(this.ratioW, 1, false);
    this.ratioH = paramJceInputStream.read(this.ratioH, 2, false);
    this.isFullSpan = paramJceInputStream.read(this.isFullSpan, 3, false);
  }
  
  public String toString()
  {
    return "stWaterFallCardStyle{cardType=" + this.cardType + ", ratioW=" + this.ratioW + ", ratioH=" + this.ratioH + ", isFullSpan=" + this.isFullSpan + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cardType, 0);
    paramJceOutputStream.write(this.ratioW, 1);
    paramJceOutputStream.write(this.ratioH, 2);
    paramJceOutputStream.write(this.isFullSpan, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stWaterFallCardStyle
 * JD-Core Version:    0.7.0.1
 */