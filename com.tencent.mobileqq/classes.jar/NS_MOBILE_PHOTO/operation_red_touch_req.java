package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_red_touch_req
  extends JceStruct
{
  public long opera_type;
  
  public operation_red_touch_req() {}
  
  public operation_red_touch_req(long paramLong)
  {
    this.opera_type = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opera_type = paramJceInputStream.read(this.opera_type, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.opera_type, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.operation_red_touch_req
 * JD-Core Version:    0.7.0.1
 */