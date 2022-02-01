package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadFriendInfo
  extends JceStruct
{
  static byte[] cache_vSignature;
  static byte[] cache_vToMID;
  public long lAppID = 0L;
  public long lFromMID = 0L;
  public long lGroupMID = 0L;
  public int nType = 0;
  public short shType = 0;
  public byte[] vSignature = null;
  public byte[] vToMID = null;
  
  public UploadFriendInfo() {}
  
  public UploadFriendInfo(long paramLong1, int paramInt, byte[] paramArrayOfByte1, long paramLong2, long paramLong3, short paramShort, byte[] paramArrayOfByte2)
  {
    this.lFromMID = paramLong1;
    this.nType = paramInt;
    this.vToMID = paramArrayOfByte1;
    this.lGroupMID = paramLong2;
    this.lAppID = paramLong3;
    this.shType = paramShort;
    this.vSignature = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromMID = paramJceInputStream.read(this.lFromMID, 0, true);
    this.nType = paramJceInputStream.read(this.nType, 1, true);
    if (cache_vToMID == null)
    {
      cache_vToMID = (byte[])new byte[1];
      ((byte[])cache_vToMID)[0] = 0;
    }
    this.vToMID = ((byte[])paramJceInputStream.read(cache_vToMID, 2, false));
    this.lGroupMID = paramJceInputStream.read(this.lGroupMID, 3, false);
    this.lAppID = paramJceInputStream.read(this.lAppID, 4, true);
    this.shType = paramJceInputStream.read(this.shType, 5, true);
    if (cache_vSignature == null)
    {
      cache_vSignature = (byte[])new byte[1];
      ((byte[])cache_vSignature)[0] = 0;
    }
    this.vSignature = ((byte[])paramJceInputStream.read(cache_vSignature, 6, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromMID, 0);
    paramJceOutputStream.write(this.nType, 1);
    if (this.vToMID != null) {
      paramJceOutputStream.write(this.vToMID, 2);
    }
    paramJceOutputStream.write(this.lGroupMID, 3);
    paramJceOutputStream.write(this.lAppID, 4);
    paramJceOutputStream.write(this.shType, 5);
    paramJceOutputStream.write(this.vSignature, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.UploadFriendInfo
 * JD-Core Version:    0.7.0.1
 */