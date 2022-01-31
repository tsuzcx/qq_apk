package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stImgReplacement
  extends JceStruct
{
  public int height;
  public String img = "";
  public int imgType;
  public int width;
  
  public stImgReplacement() {}
  
  public stImgReplacement(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.imgType = paramInt1;
    this.img = paramString;
    this.width = paramInt2;
    this.height = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imgType = paramJceInputStream.read(this.imgType, 0, false);
    this.img = paramJceInputStream.readString(1, false);
    this.width = paramJceInputStream.read(this.width, 2, false);
    this.height = paramJceInputStream.read(this.height, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imgType, 0);
    if (this.img != null) {
      paramJceOutputStream.write(this.img, 1);
    }
    paramJceOutputStream.write(this.width, 2);
    paramJceOutputStream.write(this.height, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stImgReplacement
 * JD-Core Version:    0.7.0.1
 */