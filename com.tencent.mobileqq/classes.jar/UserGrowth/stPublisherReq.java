package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPublisherReq
  extends JceStruct
{
  public int nothing = 0;
  
  public stPublisherReq() {}
  
  public stPublisherReq(int paramInt)
  {
    this.nothing = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nothing = paramJceInputStream.read(this.nothing, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nothing, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stPublisherReq
 * JD-Core Version:    0.7.0.1
 */