package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUpdateWatchDramaRsp
  extends JceStruct
{
  public int code = 0;
  
  public stUpdateWatchDramaRsp() {}
  
  public stUpdateWatchDramaRsp(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stUpdateWatchDramaRsp
 * JD-Core Version:    0.7.0.1
 */