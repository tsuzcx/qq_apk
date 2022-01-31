package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_get_time_rsp
  extends JceStruct
{
  public long server_time;
  
  public qun_get_time_rsp() {}
  
  public qun_get_time_rsp(long paramLong)
  {
    this.server_time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.server_time = paramJceInputStream.read(this.server_time, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.server_time, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_time_rsp
 * JD-Core Version:    0.7.0.1
 */