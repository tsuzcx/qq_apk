package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVideoDesc
  extends JceStruct
{
  public boolean isOpVideo = true;
  
  public stVideoDesc() {}
  
  public stVideoDesc(boolean paramBoolean)
  {
    this.isOpVideo = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isOpVideo = paramJceInputStream.read(this.isOpVideo, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isOpVideo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stVideoDesc
 * JD-Core Version:    0.7.0.1
 */