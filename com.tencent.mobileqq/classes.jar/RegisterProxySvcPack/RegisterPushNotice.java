package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RegisterPushNotice
  extends JceStruct
{
  public long uEndSeq = 0L;
  public long uFlag = 0L;
  public long uInterval_forbid_pulldown = 0L;
  public long ulTimeOutFlag = 0L;
  
  public RegisterPushNotice() {}
  
  public RegisterPushNotice(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.uFlag = paramLong1;
    this.uEndSeq = paramLong2;
    this.ulTimeOutFlag = paramLong3;
    this.uInterval_forbid_pulldown = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFlag = paramJceInputStream.read(this.uFlag, 0, false);
    this.uEndSeq = paramJceInputStream.read(this.uEndSeq, 1, false);
    this.ulTimeOutFlag = paramJceInputStream.read(this.ulTimeOutFlag, 2, false);
    this.uInterval_forbid_pulldown = paramJceInputStream.read(this.uInterval_forbid_pulldown, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFlag, 0);
    paramJceOutputStream.write(this.uEndSeq, 1);
    paramJceOutputStream.write(this.ulTimeOutFlag, 2);
    paramJceOutputStream.write(this.uInterval_forbid_pulldown, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     RegisterProxySvcPack.RegisterPushNotice
 * JD-Core Version:    0.7.0.1
 */