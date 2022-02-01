package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stImgReplacement
  extends JceStruct
{
  public String format = "";
  public int height = 0;
  public String img = "";
  public int imgType = 0;
  public String photo_rgb = "";
  public int width = 0;
  
  public stImgReplacement() {}
  
  public stImgReplacement(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    this.imgType = paramInt1;
    this.img = paramString1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.photo_rgb = paramString2;
    this.format = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imgType = paramJceInputStream.read(this.imgType, 0, false);
    this.img = paramJceInputStream.readString(1, false);
    this.width = paramJceInputStream.read(this.width, 2, false);
    this.height = paramJceInputStream.read(this.height, 3, false);
    this.photo_rgb = paramJceInputStream.readString(4, false);
    this.format = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imgType, 0);
    String str = this.img;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.width, 2);
    paramJceOutputStream.write(this.height, 3);
    str = this.photo_rgb;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.format;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stImgReplacement
 * JD-Core Version:    0.7.0.1
 */