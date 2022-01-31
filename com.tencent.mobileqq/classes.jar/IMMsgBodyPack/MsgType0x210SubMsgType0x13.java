package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210SubMsgType0x13
  extends JceStruct
{
  static byte[] cache_bytes_buf;
  public byte[] bytes_buf;
  public long uint32_dst_app_id;
  public long uint32_dst_inst_id;
  public long uint32_index;
  public long uint32_size;
  public long uint32_src_app_id;
  public long uint32_src_inst_id;
  public long uint32_type;
  public long uint64_dst_uin;
  public long uint64_sessionid;
  
  public MsgType0x210SubMsgType0x13() {}
  
  public MsgType0x210SubMsgType0x13(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, byte[] paramArrayOfByte)
  {
    this.uint32_src_app_id = paramLong1;
    this.uint32_src_inst_id = paramLong2;
    this.uint32_dst_app_id = paramLong3;
    this.uint32_dst_inst_id = paramLong4;
    this.uint64_dst_uin = paramLong5;
    this.uint64_sessionid = paramLong6;
    this.uint32_size = paramLong7;
    this.uint32_index = paramLong8;
    this.uint32_type = paramLong9;
    this.bytes_buf = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uint32_src_app_id = paramJceInputStream.read(this.uint32_src_app_id, 0, false);
    this.uint32_src_inst_id = paramJceInputStream.read(this.uint32_src_inst_id, 1, false);
    this.uint32_dst_app_id = paramJceInputStream.read(this.uint32_dst_app_id, 2, false);
    this.uint32_dst_inst_id = paramJceInputStream.read(this.uint32_dst_inst_id, 3, false);
    this.uint64_dst_uin = paramJceInputStream.read(this.uint64_dst_uin, 4, false);
    this.uint64_sessionid = paramJceInputStream.read(this.uint64_sessionid, 5, false);
    this.uint32_size = paramJceInputStream.read(this.uint32_size, 6, false);
    this.uint32_index = paramJceInputStream.read(this.uint32_index, 7, false);
    this.uint32_type = paramJceInputStream.read(this.uint32_type, 8, false);
    if (cache_bytes_buf == null)
    {
      cache_bytes_buf = (byte[])new byte[1];
      ((byte[])cache_bytes_buf)[0] = 0;
    }
    this.bytes_buf = ((byte[])paramJceInputStream.read(cache_bytes_buf, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uint32_src_app_id, 0);
    paramJceOutputStream.write(this.uint32_src_inst_id, 1);
    paramJceOutputStream.write(this.uint32_dst_app_id, 2);
    paramJceOutputStream.write(this.uint32_dst_inst_id, 3);
    paramJceOutputStream.write(this.uint64_dst_uin, 4);
    paramJceOutputStream.write(this.uint64_sessionid, 5);
    paramJceOutputStream.write(this.uint32_size, 6);
    paramJceOutputStream.write(this.uint32_index, 7);
    paramJceOutputStream.write(this.uint32_type, 8);
    if (this.bytes_buf != null) {
      paramJceOutputStream.write(this.bytes_buf, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0x13
 * JD-Core Version:    0.7.0.1
 */