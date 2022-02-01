package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WidgetMargin
  extends JceStruct
{
  public int iToRightBorderMargin = 0;
  public int iToTopBorderMargin = 0;
  
  public WidgetMargin() {}
  
  public WidgetMargin(int paramInt1, int paramInt2)
  {
    this.iToRightBorderMargin = paramInt1;
    this.iToTopBorderMargin = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iToRightBorderMargin = paramJceInputStream.read(this.iToRightBorderMargin, 0, false);
    this.iToTopBorderMargin = paramJceInputStream.read(this.iToTopBorderMargin, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iToRightBorderMargin, 0);
    paramJceOutputStream.write(this.iToTopBorderMargin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.WidgetMargin
 * JD-Core Version:    0.7.0.1
 */