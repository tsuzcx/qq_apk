package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAnnexation
  extends JceStruct
{
  public int money;
  
  public stAnnexation() {}
  
  public stAnnexation(int paramInt)
  {
    this.money = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.money = paramJceInputStream.read(this.money, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.money, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stAnnexation
 * JD-Core Version:    0.7.0.1
 */