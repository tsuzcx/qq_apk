package NS_MOBILE_COMM_CONF;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NewMobileGlobalConf
  extends JceStruct
{
  public long version = 0L;
  
  public NewMobileGlobalConf() {}
  
  public NewMobileGlobalConf(long paramLong)
  {
    this.version = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.version = paramJceInputStream.read(this.version, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.version, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_COMM_CONF.NewMobileGlobalConf
 * JD-Core Version:    0.7.0.1
 */