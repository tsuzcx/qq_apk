package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FontReq
  extends JceStruct
{
  public int fontID = 0;
  
  public FontReq() {}
  
  public FontReq(int paramInt)
  {
    this.fontID = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fontID = paramJceInputStream.read(this.fontID, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fontID, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.FontReq
 * JD-Core Version:    0.7.0.1
 */