package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Signature
  extends JceStruct
{
  public int fontid = 0;
  
  public Signature() {}
  
  public Signature(int paramInt)
  {
    this.fontid = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fontid = paramJceInputStream.read(this.fontid, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fontid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.Signature
 * JD-Core Version:    0.7.0.1
 */