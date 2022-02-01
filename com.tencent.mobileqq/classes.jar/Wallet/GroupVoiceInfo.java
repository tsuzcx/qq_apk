package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupVoiceInfo
  extends JceStruct
{
  static byte[] cache_fileMd5 = (byte[])new byte[1];
  public long fileId = 0L;
  public byte[] fileMd5 = null;
  public long groupCode = 0L;
  
  static
  {
    ((byte[])cache_fileMd5)[0] = 0;
  }
  
  public GroupVoiceInfo() {}
  
  public GroupVoiceInfo(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.groupCode = paramLong1;
    this.fileId = paramLong2;
    this.fileMd5 = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.groupCode = paramJceInputStream.read(this.groupCode, 0, false);
    this.fileId = paramJceInputStream.read(this.fileId, 1, false);
    this.fileMd5 = ((byte[])paramJceInputStream.read(cache_fileMd5, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.groupCode, 0);
    paramJceOutputStream.write(this.fileId, 1);
    byte[] arrayOfByte = this.fileMd5;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GroupVoiceInfo
 * JD-Core Version:    0.7.0.1
 */