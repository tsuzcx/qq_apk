package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PushSwitchData
  extends JceStruct
{
  public long appid;
  public byte cPushSwitch;
  public long uin;
  
  public PushSwitchData() {}
  
  public PushSwitchData(long paramLong1, long paramLong2, byte paramByte)
  {
    this.uin = paramLong1;
    this.appid = paramLong2;
    this.cPushSwitch = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.cPushSwitch = paramJceInputStream.read(this.cPushSwitch, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.cPushSwitch, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     KQQ.PushSwitchData
 * JD-Core Version:    0.7.0.1
 */