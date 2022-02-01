package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TimeCtrl
  extends JceStruct
{
  public int validEndTime = 0;
  
  public JceStruct newInit()
  {
    return new TimeCtrl();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.validEndTime = paramJceInputStream.read(this.validEndTime, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.validEndTime != 0) {
      paramJceOutputStream.write(this.validEndTime, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MConch.TimeCtrl
 * JD-Core Version:    0.7.0.1
 */