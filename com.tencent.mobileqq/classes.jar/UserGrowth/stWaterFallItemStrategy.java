package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWaterFallItemStrategy
  extends JceStruct
{
  public boolean isCallWeishi = true;
  public boolean isDonwloadWeish = true;
  
  public stWaterFallItemStrategy() {}
  
  public stWaterFallItemStrategy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isCallWeishi = paramBoolean1;
    this.isDonwloadWeish = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isCallWeishi = paramJceInputStream.read(this.isCallWeishi, 0, false);
    this.isDonwloadWeish = paramJceInputStream.read(this.isDonwloadWeish, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isCallWeishi, 0);
    paramJceOutputStream.write(this.isDonwloadWeish, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stWaterFallItemStrategy
 * JD-Core Version:    0.7.0.1
 */