package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFloatingLayerCardStyle
  extends JceStruct
{
  public int cardType = 0;
  public boolean commentHidden = false;
  public boolean dingHidden = false;
  public boolean shareHidden = false;
  
  public stFloatingLayerCardStyle() {}
  
  public stFloatingLayerCardStyle(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.cardType = paramInt;
    this.dingHidden = paramBoolean1;
    this.commentHidden = paramBoolean2;
    this.shareHidden = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cardType = paramJceInputStream.read(this.cardType, 0, false);
    this.dingHidden = paramJceInputStream.read(this.dingHidden, 1, false);
    this.commentHidden = paramJceInputStream.read(this.commentHidden, 2, false);
    this.shareHidden = paramJceInputStream.read(this.shareHidden, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cardType, 0);
    paramJceOutputStream.write(this.dingHidden, 1);
    paramJceOutputStream.write(this.commentHidden, 2);
    paramJceOutputStream.write(this.shareHidden, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stFloatingLayerCardStyle
 * JD-Core Version:    0.7.0.1
 */