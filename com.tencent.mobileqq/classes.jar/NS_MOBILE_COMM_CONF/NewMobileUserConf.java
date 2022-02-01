package NS_MOBILE_COMM_CONF;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NewMobileUserConf
  extends JceStruct
{
  public long uBeginTime = 0L;
  public long uEndTime = 0L;
  public long version = 0L;
  
  public NewMobileUserConf() {}
  
  public NewMobileUserConf(long paramLong1, long paramLong2, long paramLong3)
  {
    this.version = paramLong1;
    this.uBeginTime = paramLong2;
    this.uEndTime = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.version = paramJceInputStream.read(this.version, 0, false);
    this.uBeginTime = paramJceInputStream.read(this.uBeginTime, 1, false);
    this.uEndTime = paramJceInputStream.read(this.uEndTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.version, 0);
    paramJceOutputStream.write(this.uBeginTime, 1);
    paramJceOutputStream.write(this.uEndTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_COMM_CONF.NewMobileUserConf
 * JD-Core Version:    0.7.0.1
 */