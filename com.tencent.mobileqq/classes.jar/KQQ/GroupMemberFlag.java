package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupMemberFlag
  extends JceStruct
{
  public byte cUinFlag = 0;
  public long dwUin = 0L;
  
  public GroupMemberFlag() {}
  
  public GroupMemberFlag(long paramLong, byte paramByte)
  {
    this.dwUin = paramLong;
    this.cUinFlag = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwUin = paramJceInputStream.read(this.dwUin, 0, true);
    this.cUinFlag = paramJceInputStream.read(this.cUinFlag, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwUin, 0);
    paramJceOutputStream.write(this.cUinFlag, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.GroupMemberFlag
 * JD-Core Version:    0.7.0.1
 */