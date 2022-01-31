package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TicketForQQ
  extends JceStruct
{
  static byte[] cache_A2 = (byte[])new byte[1];
  public byte[] A2;
  public long appId;
  public long uin;
  
  static
  {
    ((byte[])cache_A2)[0] = 0;
  }
  
  public TicketForQQ() {}
  
  public TicketForQQ(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.appId = paramLong1;
    this.A2 = paramArrayOfByte;
    this.uin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appId = paramJceInputStream.read(this.appId, 0, false);
    this.A2 = ((byte[])paramJceInputStream.read(cache_A2, 1, false));
    this.uin = paramJceInputStream.read(this.uin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appId, 0);
    if (this.A2 != null) {
      paramJceOutputStream.write(this.A2, 1);
    }
    paramJceOutputStream.write(this.uin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_NEW_MOBILE_REPORT.TicketForQQ
 * JD-Core Version:    0.7.0.1
 */