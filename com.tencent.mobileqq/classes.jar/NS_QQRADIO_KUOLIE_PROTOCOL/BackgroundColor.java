package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BackgroundColor
  extends JceStruct
{
  public int beginVal = 0;
  public int endVal = 0;
  
  public BackgroundColor() {}
  
  public BackgroundColor(int paramInt1, int paramInt2)
  {
    this.beginVal = paramInt1;
    this.endVal = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.beginVal = paramJceInputStream.read(this.beginVal, 0, false);
    this.endVal = paramJceInputStream.read(this.endVal, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.beginVal, 0);
    paramJceOutputStream.write(this.endVal, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.BackgroundColor
 * JD-Core Version:    0.7.0.1
 */