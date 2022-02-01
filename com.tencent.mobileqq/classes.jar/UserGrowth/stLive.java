package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stLive
  extends JceStruct
{
  public int status;
  
  public stLive() {}
  
  public stLive(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stLive
 * JD-Core Version:    0.7.0.1
 */