package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210SubMsgType0x1d
  extends JceStruct
{
  public long dwID = 0L;
  public long dwOpType = 0L;
  public long dwUin = 0L;
  public String strValue = "";
  
  public MsgType0x210SubMsgType0x1d() {}
  
  public MsgType0x210SubMsgType0x1d(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.dwOpType = paramLong1;
    this.dwUin = paramLong2;
    this.dwID = paramLong3;
    this.strValue = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwOpType = paramJceInputStream.read(this.dwOpType, 0, false);
    this.dwUin = paramJceInputStream.read(this.dwUin, 1, false);
    this.dwID = paramJceInputStream.read(this.dwID, 2, false);
    this.strValue = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwOpType, 0);
    paramJceOutputStream.write(this.dwUin, 1);
    paramJceOutputStream.write(this.dwID, 2);
    String str = this.strValue;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0x1d
 * JD-Core Version:    0.7.0.1
 */