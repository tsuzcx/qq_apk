package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSmallPopWindow
  extends JceStruct
{
  public int direction;
  public String imgurl = "";
  public int time_to_open;
  public int y_percent;
  
  public stSmallPopWindow() {}
  
  public stSmallPopWindow(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.imgurl = paramString;
    this.direction = paramInt1;
    this.y_percent = paramInt2;
    this.time_to_open = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imgurl = paramJceInputStream.readString(1, false);
    this.direction = paramJceInputStream.read(this.direction, 2, false);
    this.y_percent = paramJceInputStream.read(this.y_percent, 3, false);
    this.time_to_open = paramJceInputStream.read(this.time_to_open, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.imgurl != null) {
      paramJceOutputStream.write(this.imgurl, 1);
    }
    paramJceOutputStream.write(this.direction, 2);
    paramJceOutputStream.write(this.y_percent, 3);
    paramJceOutputStream.write(this.time_to_open, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stSmallPopWindow
 * JD-Core Version:    0.7.0.1
 */