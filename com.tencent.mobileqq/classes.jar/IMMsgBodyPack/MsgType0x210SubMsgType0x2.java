package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210SubMsgType0x2
  extends JceStruct
{
  static byte[] cache_strFileIndex;
  static byte[] cache_strFileKey;
  static byte[] cache_strFileMd5;
  static byte[] cache_strFileName;
  static byte[] cache_strOriginfile_md5;
  public long lFileLen;
  public long lSessionId;
  public byte[] strFileIndex;
  public byte[] strFileKey;
  public byte[] strFileMd5;
  public byte[] strFileName;
  public byte[] strOriginfile_md5;
  public long uDstAppId;
  public long uDstInstId;
  public long uDstUin;
  public long uOriginfiletype;
  public long uSeq;
  public long uServerIp;
  public long uServerPort;
  public long uSrcAppId;
  public long uSrcInstId;
  
  public MsgType0x210SubMsgType0x2() {}
  
  public MsgType0x210SubMsgType0x2(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong6, long paramLong7, long paramLong8, long paramLong9, byte[] paramArrayOfByte5, long paramLong10, long paramLong11)
  {
    this.uSrcAppId = paramLong1;
    this.uSrcInstId = paramLong2;
    this.uDstAppId = paramLong3;
    this.uDstInstId = paramLong4;
    this.uDstUin = paramLong5;
    this.strFileName = paramArrayOfByte1;
    this.strFileIndex = paramArrayOfByte2;
    this.strFileMd5 = paramArrayOfByte3;
    this.strFileKey = paramArrayOfByte4;
    this.uServerIp = paramLong6;
    this.uServerPort = paramLong7;
    this.lFileLen = paramLong8;
    this.lSessionId = paramLong9;
    this.strOriginfile_md5 = paramArrayOfByte5;
    this.uOriginfiletype = paramLong10;
    this.uSeq = paramLong11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uSrcAppId = paramJceInputStream.read(this.uSrcAppId, 0, false);
    this.uSrcInstId = paramJceInputStream.read(this.uSrcInstId, 1, false);
    this.uDstAppId = paramJceInputStream.read(this.uDstAppId, 2, false);
    this.uDstInstId = paramJceInputStream.read(this.uDstInstId, 3, false);
    this.uDstUin = paramJceInputStream.read(this.uDstUin, 4, false);
    if (cache_strFileName == null)
    {
      cache_strFileName = (byte[])new byte[1];
      ((byte[])cache_strFileName)[0] = 0;
    }
    this.strFileName = ((byte[])paramJceInputStream.read(cache_strFileName, 5, false));
    if (cache_strFileIndex == null)
    {
      cache_strFileIndex = (byte[])new byte[1];
      ((byte[])cache_strFileIndex)[0] = 0;
    }
    this.strFileIndex = ((byte[])paramJceInputStream.read(cache_strFileIndex, 6, false));
    if (cache_strFileMd5 == null)
    {
      cache_strFileMd5 = (byte[])new byte[1];
      ((byte[])cache_strFileMd5)[0] = 0;
    }
    this.strFileMd5 = ((byte[])paramJceInputStream.read(cache_strFileMd5, 7, false));
    if (cache_strFileKey == null)
    {
      cache_strFileKey = (byte[])new byte[1];
      ((byte[])cache_strFileKey)[0] = 0;
    }
    this.strFileKey = ((byte[])paramJceInputStream.read(cache_strFileKey, 8, false));
    this.uServerIp = paramJceInputStream.read(this.uServerIp, 9, false);
    this.uServerPort = paramJceInputStream.read(this.uServerPort, 10, false);
    this.lFileLen = paramJceInputStream.read(this.lFileLen, 11, false);
    this.lSessionId = paramJceInputStream.read(this.lSessionId, 12, false);
    if (cache_strOriginfile_md5 == null)
    {
      cache_strOriginfile_md5 = (byte[])new byte[1];
      ((byte[])cache_strOriginfile_md5)[0] = 0;
    }
    this.strOriginfile_md5 = ((byte[])paramJceInputStream.read(cache_strOriginfile_md5, 13, false));
    this.uOriginfiletype = paramJceInputStream.read(this.uOriginfiletype, 14, false);
    this.uSeq = paramJceInputStream.read(this.uSeq, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uSrcAppId, 0);
    paramJceOutputStream.write(this.uSrcInstId, 1);
    paramJceOutputStream.write(this.uDstAppId, 2);
    paramJceOutputStream.write(this.uDstInstId, 3);
    paramJceOutputStream.write(this.uDstUin, 4);
    if (this.strFileName != null) {
      paramJceOutputStream.write(this.strFileName, 5);
    }
    if (this.strFileIndex != null) {
      paramJceOutputStream.write(this.strFileIndex, 6);
    }
    if (this.strFileMd5 != null) {
      paramJceOutputStream.write(this.strFileMd5, 7);
    }
    if (this.strFileKey != null) {
      paramJceOutputStream.write(this.strFileKey, 8);
    }
    paramJceOutputStream.write(this.uServerIp, 9);
    paramJceOutputStream.write(this.uServerPort, 10);
    paramJceOutputStream.write(this.lFileLen, 11);
    paramJceOutputStream.write(this.lSessionId, 12);
    if (this.strOriginfile_md5 != null) {
      paramJceOutputStream.write(this.strOriginfile_md5, 13);
    }
    paramJceOutputStream.write(this.uOriginfiletype, 14);
    paramJceOutputStream.write(this.uSeq, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0x2
 * JD-Core Version:    0.7.0.1
 */