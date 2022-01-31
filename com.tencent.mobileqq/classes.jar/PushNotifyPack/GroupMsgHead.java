package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupMsgHead
  extends JceStruct
{
  public byte cCurPkg;
  public byte cTotalPkg;
  public long dwReserved;
  public int usCmdType;
  public int usPkgSeq;
  
  public GroupMsgHead() {}
  
  public GroupMsgHead(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, long paramLong)
  {
    this.usCmdType = paramInt1;
    this.cTotalPkg = paramByte1;
    this.cCurPkg = paramByte2;
    this.usPkgSeq = paramInt2;
    this.dwReserved = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.usCmdType = paramJceInputStream.read(this.usCmdType, 0, true);
    this.cTotalPkg = paramJceInputStream.read(this.cTotalPkg, 1, true);
    this.cCurPkg = paramJceInputStream.read(this.cCurPkg, 2, true);
    this.usPkgSeq = paramJceInputStream.read(this.usPkgSeq, 3, true);
    this.dwReserved = paramJceInputStream.read(this.dwReserved, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.usCmdType, 0);
    paramJceOutputStream.write(this.cTotalPkg, 1);
    paramJceOutputStream.write(this.cCurPkg, 2);
    paramJceOutputStream.write(this.usPkgSeq, 3);
    paramJceOutputStream.write(this.dwReserved, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PushNotifyPack.GroupMsgHead
 * JD-Core Version:    0.7.0.1
 */