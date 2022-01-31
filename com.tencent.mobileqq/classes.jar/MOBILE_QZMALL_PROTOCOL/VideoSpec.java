package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VideoSpec
  extends JceStruct
{
  public long uiDuration;
  public long uiHeight;
  public long uiSize;
  public long uiWidth;
  
  public VideoSpec() {}
  
  public VideoSpec(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.uiWidth = paramLong1;
    this.uiHeight = paramLong2;
    this.uiDuration = paramLong3;
    this.uiSize = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiWidth = paramJceInputStream.read(this.uiWidth, 0, false);
    this.uiHeight = paramJceInputStream.read(this.uiHeight, 1, false);
    this.uiDuration = paramJceInputStream.read(this.uiDuration, 2, false);
    this.uiSize = paramJceInputStream.read(this.uiSize, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiWidth, 0);
    paramJceOutputStream.write(this.uiHeight, 1);
    paramJceOutputStream.write(this.uiDuration, 2);
    paramJceOutputStream.write(this.uiSize, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.VideoSpec
 * JD-Core Version:    0.7.0.1
 */