package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAioAction
  extends JceStruct
{
  static int cache_landingPage;
  public int landingPage = 0;
  
  public stAioAction() {}
  
  public stAioAction(int paramInt)
  {
    this.landingPage = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.landingPage = paramJceInputStream.read(this.landingPage, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.landingPage, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stAioAction
 * JD-Core Version:    0.7.0.1
 */