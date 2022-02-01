package NS_QZONE_GASHAPON;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_user_gashapon_req
  extends JceStruct
{
  public long lUin = 0L;
  
  public get_user_gashapon_req() {}
  
  public get_user_gashapon_req(long paramLong)
  {
    this.lUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_GASHAPON.get_user_gashapon_req
 * JD-Core Version:    0.7.0.1
 */