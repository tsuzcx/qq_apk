package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RoamInfo
  extends JceStruct
{
  public byte cValue = 0;
  public long lFriendUin = 0L;
  
  public RoamInfo() {}
  
  public RoamInfo(long paramLong, byte paramByte)
  {
    this.lFriendUin = paramLong;
    this.cValue = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFriendUin = paramJceInputStream.read(this.lFriendUin, 0, true);
    this.cValue = paramJceInputStream.read(this.cValue, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFriendUin, 0);
    paramJceOutputStream.write(this.cValue, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.RoamInfo
 * JD-Core Version:    0.7.0.1
 */