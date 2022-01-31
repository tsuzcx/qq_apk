package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestPullGroupMsg
  extends JceStruct
{
  public byte cGetGroupNick;
  public byte cGetPttUrl;
  public byte cGroupMsgRoam;
  public byte cMsgStoreType;
  public byte cVerifyType;
  public long lBeginSeq;
  public long lEndSeq;
  public long lGroupCode;
  
  public SvcRequestPullGroupMsg() {}
  
  public SvcRequestPullGroupMsg(byte paramByte1, long paramLong1, long paramLong2, long paramLong3, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.cVerifyType = paramByte1;
    this.lGroupCode = paramLong1;
    this.lBeginSeq = paramLong2;
    this.lEndSeq = paramLong3;
    this.cGetGroupNick = paramByte2;
    this.cGroupMsgRoam = paramByte3;
    this.cMsgStoreType = paramByte4;
    this.cGetPttUrl = paramByte5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 0, true);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 1, true);
    this.lBeginSeq = paramJceInputStream.read(this.lBeginSeq, 2, true);
    this.lEndSeq = paramJceInputStream.read(this.lEndSeq, 3, true);
    this.cGetGroupNick = paramJceInputStream.read(this.cGetGroupNick, 4, false);
    this.cGroupMsgRoam = paramJceInputStream.read(this.cGroupMsgRoam, 5, false);
    this.cMsgStoreType = paramJceInputStream.read(this.cMsgStoreType, 6, false);
    this.cGetPttUrl = paramJceInputStream.read(this.cGetPttUrl, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVerifyType, 0);
    paramJceOutputStream.write(this.lGroupCode, 1);
    paramJceOutputStream.write(this.lBeginSeq, 2);
    paramJceOutputStream.write(this.lEndSeq, 3);
    paramJceOutputStream.write(this.cGetGroupNick, 4);
    paramJceOutputStream.write(this.cGroupMsgRoam, 5);
    paramJceOutputStream.write(this.cMsgStoreType, 6);
    paramJceOutputStream.write(this.cGetPttUrl, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestPullGroupMsg
 * JD-Core Version:    0.7.0.1
 */