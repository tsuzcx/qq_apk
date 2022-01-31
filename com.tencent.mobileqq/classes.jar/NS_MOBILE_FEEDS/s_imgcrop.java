package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_imgcrop
  extends JceStruct
{
  public long centerx_scale;
  public long centery_scale;
  
  public s_imgcrop() {}
  
  public s_imgcrop(long paramLong1, long paramLong2)
  {
    this.centerx_scale = paramLong1;
    this.centery_scale = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.centerx_scale = paramJceInputStream.read(this.centerx_scale, 0, false);
    this.centery_scale = paramJceInputStream.read(this.centery_scale, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.centerx_scale, 0);
    paramJceOutputStream.write(this.centery_scale, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_imgcrop
 * JD-Core Version:    0.7.0.1
 */