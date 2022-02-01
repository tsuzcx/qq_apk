package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetTabsReq
  extends JceStruct
{
  public int reserve = 0;
  
  public stGetTabsReq() {}
  
  public stGetTabsReq(int paramInt)
  {
    this.reserve = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reserve = paramJceInputStream.read(this.reserve, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reserve, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stGetTabsReq
 * JD-Core Version:    0.7.0.1
 */