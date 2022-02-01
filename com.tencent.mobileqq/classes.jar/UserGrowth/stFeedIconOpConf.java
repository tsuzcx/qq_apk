package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFeedIconOpConf
  extends JceStruct
{
  public int duringTime = 0;
  public int startTime = 0;
  
  public stFeedIconOpConf() {}
  
  public stFeedIconOpConf(int paramInt1, int paramInt2)
  {
    this.startTime = paramInt1;
    this.duringTime = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.startTime = paramJceInputStream.read(this.startTime, 0, false);
    this.duringTime = paramJceInputStream.read(this.duringTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.startTime, 0);
    paramJceOutputStream.write(this.duringTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFeedIconOpConf
 * JD-Core Version:    0.7.0.1
 */