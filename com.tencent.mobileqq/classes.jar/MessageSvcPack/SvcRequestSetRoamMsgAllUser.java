package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestSetRoamMsgAllUser
  extends JceStruct
{
  public byte cValue = 0;
  public byte cVerifyType = 0;
  public long lUin = 0L;
  public short shType = 0;
  
  public SvcRequestSetRoamMsgAllUser() {}
  
  public SvcRequestSetRoamMsgAllUser(long paramLong, byte paramByte1, short paramShort, byte paramByte2)
  {
    this.lUin = paramLong;
    this.cVerifyType = paramByte1;
    this.shType = paramShort;
    this.cValue = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, true);
    this.shType = paramJceInputStream.read(this.shType, 2, true);
    this.cValue = paramJceInputStream.read(this.cValue, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.shType, 2);
    paramJceOutputStream.write(this.cValue, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestSetRoamMsgAllUser
 * JD-Core Version:    0.7.0.1
 */