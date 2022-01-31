package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadInfo
  extends JceStruct
{
  static byte[] cache_vSignature;
  public long lAppID;
  public long lFromMID;
  public long lToMID;
  public short shType;
  public byte[] vSignature;
  
  public UploadInfo() {}
  
  public UploadInfo(long paramLong1, long paramLong2, long paramLong3, short paramShort, byte[] paramArrayOfByte)
  {
    this.lFromMID = paramLong1;
    this.lToMID = paramLong2;
    this.lAppID = paramLong3;
    this.shType = paramShort;
    this.vSignature = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromMID = paramJceInputStream.read(this.lFromMID, 0, true);
    this.lToMID = paramJceInputStream.read(this.lToMID, 1, true);
    this.lAppID = paramJceInputStream.read(this.lAppID, 2, true);
    this.shType = paramJceInputStream.read(this.shType, 3, true);
    if (cache_vSignature == null)
    {
      cache_vSignature = (byte[])new byte[1];
      ((byte[])cache_vSignature)[0] = 0;
    }
    this.vSignature = ((byte[])paramJceInputStream.read(cache_vSignature, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromMID, 0);
    paramJceOutputStream.write(this.lToMID, 1);
    paramJceOutputStream.write(this.lAppID, 2);
    paramJceOutputStream.write(this.shType, 3);
    paramJceOutputStream.write(this.vSignature, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     KQQ.UploadInfo
 * JD-Core Version:    0.7.0.1
 */