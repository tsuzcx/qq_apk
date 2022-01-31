package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GrpMsg
  extends JceStruct
{
  static byte[] cache_strMsg;
  public long GrpMsgID;
  public int iMsgTime;
  public long lFromMID;
  public long lGrpId;
  public short shMsgType;
  public byte[] strMsg;
  
  public GrpMsg() {}
  
  public GrpMsg(short paramShort, long paramLong1, long paramLong2, long paramLong3, int paramInt, byte[] paramArrayOfByte)
  {
    this.shMsgType = paramShort;
    this.GrpMsgID = paramLong1;
    this.lFromMID = paramLong2;
    this.lGrpId = paramLong3;
    this.iMsgTime = paramInt;
    this.strMsg = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shMsgType = paramJceInputStream.read(this.shMsgType, 0, true);
    this.GrpMsgID = paramJceInputStream.read(this.GrpMsgID, 1, true);
    this.lFromMID = paramJceInputStream.read(this.lFromMID, 2, true);
    this.lGrpId = paramJceInputStream.read(this.lGrpId, 3, true);
    this.iMsgTime = paramJceInputStream.read(this.iMsgTime, 4, true);
    if (cache_strMsg == null)
    {
      cache_strMsg = (byte[])new byte[1];
      ((byte[])cache_strMsg)[0] = 0;
    }
    this.strMsg = ((byte[])paramJceInputStream.read(cache_strMsg, 5, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shMsgType, 0);
    paramJceOutputStream.write(this.GrpMsgID, 1);
    paramJceOutputStream.write(this.lFromMID, 2);
    paramJceOutputStream.write(this.lGrpId, 3);
    paramJceOutputStream.write(this.iMsgTime, 4);
    paramJceOutputStream.write(this.strMsg, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.GrpMsg
 * JD-Core Version:    0.7.0.1
 */