package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiSimpleFontItem
  extends JceStruct
{
  public int fontType = 0;
  
  public UniBusiSimpleFontItem() {}
  
  public UniBusiSimpleFontItem(int paramInt)
  {
    this.fontType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fontType = paramJceInputStream.read(this.fontType, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fontType, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiSimpleFontItem
 * JD-Core Version:    0.7.0.1
 */