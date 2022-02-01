package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210
  extends JceStruct
{
  static MsgType0x210SubMsgType0x13 cache_stMsgInfo0x13;
  static MsgType0x210SubMsgType0x17 cache_stMsgInfo0x17;
  static MsgType0x210SubMsgType0x1d cache_stMsgInfo0x1d;
  static MsgType0x210SubMsgType0x2 cache_stMsgInfo0x2;
  static MsgType0x210SubMsgType0x20 cache_stMsgInfo0x20;
  static MsgType0x210SubMsgType0x24 cache_stMsgInfo0x24;
  static MsgType0x210SubMsgType0xa cache_stMsgInfo0xa;
  static MsgType0x210SubMsgType0xe cache_stMsgInfo0xe;
  static byte[] cache_vProtobuf;
  public MsgType0x210SubMsgType0x13 stMsgInfo0x13 = null;
  public MsgType0x210SubMsgType0x17 stMsgInfo0x17 = null;
  public MsgType0x210SubMsgType0x1d stMsgInfo0x1d = null;
  public MsgType0x210SubMsgType0x2 stMsgInfo0x2 = null;
  public MsgType0x210SubMsgType0x20 stMsgInfo0x20 = null;
  public MsgType0x210SubMsgType0x24 stMsgInfo0x24 = null;
  public MsgType0x210SubMsgType0xa stMsgInfo0xa = null;
  public MsgType0x210SubMsgType0xe stMsgInfo0xe = null;
  public long uSubMsgType = 0L;
  public byte[] vProtobuf = null;
  
  public MsgType0x210() {}
  
  public MsgType0x210(long paramLong, MsgType0x210SubMsgType0x2 paramMsgType0x210SubMsgType0x2, MsgType0x210SubMsgType0xa paramMsgType0x210SubMsgType0xa, MsgType0x210SubMsgType0xe paramMsgType0x210SubMsgType0xe, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13, MsgType0x210SubMsgType0x17 paramMsgType0x210SubMsgType0x17, MsgType0x210SubMsgType0x20 paramMsgType0x210SubMsgType0x20, MsgType0x210SubMsgType0x1d paramMsgType0x210SubMsgType0x1d, MsgType0x210SubMsgType0x24 paramMsgType0x210SubMsgType0x24, byte[] paramArrayOfByte)
  {
    this.uSubMsgType = paramLong;
    this.stMsgInfo0x2 = paramMsgType0x210SubMsgType0x2;
    this.stMsgInfo0xa = paramMsgType0x210SubMsgType0xa;
    this.stMsgInfo0xe = paramMsgType0x210SubMsgType0xe;
    this.stMsgInfo0x13 = paramMsgType0x210SubMsgType0x13;
    this.stMsgInfo0x17 = paramMsgType0x210SubMsgType0x17;
    this.stMsgInfo0x20 = paramMsgType0x210SubMsgType0x20;
    this.stMsgInfo0x1d = paramMsgType0x210SubMsgType0x1d;
    this.stMsgInfo0x24 = paramMsgType0x210SubMsgType0x24;
    this.vProtobuf = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uSubMsgType = paramJceInputStream.read(this.uSubMsgType, 0, true);
    if (cache_stMsgInfo0x2 == null) {
      cache_stMsgInfo0x2 = new MsgType0x210SubMsgType0x2();
    }
    this.stMsgInfo0x2 = ((MsgType0x210SubMsgType0x2)paramJceInputStream.read(cache_stMsgInfo0x2, 1, false));
    if (cache_stMsgInfo0xa == null) {
      cache_stMsgInfo0xa = new MsgType0x210SubMsgType0xa();
    }
    this.stMsgInfo0xa = ((MsgType0x210SubMsgType0xa)paramJceInputStream.read(cache_stMsgInfo0xa, 3, false));
    if (cache_stMsgInfo0xe == null) {
      cache_stMsgInfo0xe = new MsgType0x210SubMsgType0xe();
    }
    this.stMsgInfo0xe = ((MsgType0x210SubMsgType0xe)paramJceInputStream.read(cache_stMsgInfo0xe, 4, false));
    if (cache_stMsgInfo0x13 == null) {
      cache_stMsgInfo0x13 = new MsgType0x210SubMsgType0x13();
    }
    this.stMsgInfo0x13 = ((MsgType0x210SubMsgType0x13)paramJceInputStream.read(cache_stMsgInfo0x13, 5, false));
    if (cache_stMsgInfo0x17 == null) {
      cache_stMsgInfo0x17 = new MsgType0x210SubMsgType0x17();
    }
    this.stMsgInfo0x17 = ((MsgType0x210SubMsgType0x17)paramJceInputStream.read(cache_stMsgInfo0x17, 6, false));
    if (cache_stMsgInfo0x20 == null) {
      cache_stMsgInfo0x20 = new MsgType0x210SubMsgType0x20();
    }
    this.stMsgInfo0x20 = ((MsgType0x210SubMsgType0x20)paramJceInputStream.read(cache_stMsgInfo0x20, 7, false));
    if (cache_stMsgInfo0x1d == null) {
      cache_stMsgInfo0x1d = new MsgType0x210SubMsgType0x1d();
    }
    this.stMsgInfo0x1d = ((MsgType0x210SubMsgType0x1d)paramJceInputStream.read(cache_stMsgInfo0x1d, 8, false));
    if (cache_stMsgInfo0x24 == null) {
      cache_stMsgInfo0x24 = new MsgType0x210SubMsgType0x24();
    }
    this.stMsgInfo0x24 = ((MsgType0x210SubMsgType0x24)paramJceInputStream.read(cache_stMsgInfo0x24, 9, false));
    if (cache_vProtobuf == null)
    {
      cache_vProtobuf = (byte[])new byte[1];
      ((byte[])cache_vProtobuf)[0] = 0;
    }
    this.vProtobuf = ((byte[])paramJceInputStream.read(cache_vProtobuf, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uSubMsgType, 0);
    if (this.stMsgInfo0x2 != null) {
      paramJceOutputStream.write(this.stMsgInfo0x2, 1);
    }
    if (this.stMsgInfo0xa != null) {
      paramJceOutputStream.write(this.stMsgInfo0xa, 3);
    }
    if (this.stMsgInfo0xe != null) {
      paramJceOutputStream.write(this.stMsgInfo0xe, 4);
    }
    if (this.stMsgInfo0x13 != null) {
      paramJceOutputStream.write(this.stMsgInfo0x13, 5);
    }
    if (this.stMsgInfo0x17 != null) {
      paramJceOutputStream.write(this.stMsgInfo0x17, 6);
    }
    if (this.stMsgInfo0x20 != null) {
      paramJceOutputStream.write(this.stMsgInfo0x20, 7);
    }
    if (this.stMsgInfo0x1d != null) {
      paramJceOutputStream.write(this.stMsgInfo0x1d, 8);
    }
    if (this.stMsgInfo0x24 != null) {
      paramJceOutputStream.write(this.stMsgInfo0x24, 9);
    }
    if (this.vProtobuf != null) {
      paramJceOutputStream.write(this.vProtobuf, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210
 * JD-Core Version:    0.7.0.1
 */