package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UiExtraAppInfo
  extends JceStruct
{
  public int svipLevel = 0;
  public int svipMonth = 0;
  
  public UiExtraAppInfo() {}
  
  public UiExtraAppInfo(int paramInt1, int paramInt2)
  {
    this.svipLevel = paramInt1;
    this.svipMonth = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.svipLevel = paramJceInputStream.read(this.svipLevel, 0, false);
    this.svipMonth = paramJceInputStream.read(this.svipMonth, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.svipLevel, 0);
    paramJceOutputStream.write(this.svipMonth, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UiExtraAppInfo
 * JD-Core Version:    0.7.0.1
 */