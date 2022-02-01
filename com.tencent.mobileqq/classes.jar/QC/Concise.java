package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Concise
  extends JceStruct
{
  public int isSwitch = 0;
  
  public Concise() {}
  
  public Concise(int paramInt)
  {
    this.isSwitch = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isSwitch = paramJceInputStream.read(this.isSwitch, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isSwitch, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.Concise
 * JD-Core Version:    0.7.0.1
 */