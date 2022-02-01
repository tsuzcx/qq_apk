package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestSetConfMsgRead
  extends JceStruct
{
  public byte cVerifyType = 0;
  public long lConfUin = 0L;
  public long lLastReadSeq = 0L;
  
  public SvcRequestSetConfMsgRead() {}
  
  public SvcRequestSetConfMsgRead(long paramLong1, long paramLong2, byte paramByte)
  {
    this.lConfUin = paramLong1;
    this.lLastReadSeq = paramLong2;
    this.cVerifyType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lConfUin = paramJceInputStream.read(this.lConfUin, 0, true);
    this.lLastReadSeq = paramJceInputStream.read(this.lLastReadSeq, 1, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lConfUin, 0);
    paramJceOutputStream.write(this.lLastReadSeq, 1);
    paramJceOutputStream.write(this.cVerifyType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestSetConfMsgRead
 * JD-Core Version:    0.7.0.1
 */