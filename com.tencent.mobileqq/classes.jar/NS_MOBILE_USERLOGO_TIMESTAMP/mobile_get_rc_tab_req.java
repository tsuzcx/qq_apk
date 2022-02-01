package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_get_rc_tab_req
  extends JceStruct
{
  public long last_timestamp;
  
  public mobile_get_rc_tab_req() {}
  
  public mobile_get_rc_tab_req(long paramLong)
  {
    this.last_timestamp = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.last_timestamp = paramJceInputStream.read(this.last_timestamp, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.last_timestamp, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.mobile_get_rc_tab_req
 * JD-Core Version:    0.7.0.1
 */