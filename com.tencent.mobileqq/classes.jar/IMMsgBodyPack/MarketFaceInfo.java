package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarketFaceInfo
  extends JceStruct
{
  static byte[] cache_marketFaceBuff;
  public long insertIdx = 0L;
  public byte[] marketFaceBuff = null;
  
  public MarketFaceInfo() {}
  
  public MarketFaceInfo(long paramLong, byte[] paramArrayOfByte)
  {
    this.insertIdx = paramLong;
    this.marketFaceBuff = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.insertIdx = paramJceInputStream.read(this.insertIdx, 0, true);
    if (cache_marketFaceBuff == null)
    {
      cache_marketFaceBuff = (byte[])new byte[1];
      ((byte[])cache_marketFaceBuff)[0] = 0;
    }
    this.marketFaceBuff = ((byte[])paramJceInputStream.read(cache_marketFaceBuff, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.insertIdx, 0);
    paramJceOutputStream.write(this.marketFaceBuff, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     IMMsgBodyPack.MarketFaceInfo
 * JD-Core Version:    0.7.0.1
 */