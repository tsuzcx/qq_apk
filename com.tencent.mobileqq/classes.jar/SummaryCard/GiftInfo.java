package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GiftInfo
  extends JceStruct
{
  static byte[] cache_vGiftInfo;
  public long uOpenFlag;
  public byte[] vGiftInfo;
  
  public GiftInfo() {}
  
  public GiftInfo(long paramLong, byte[] paramArrayOfByte)
  {
    this.uOpenFlag = paramLong;
    this.vGiftInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOpenFlag = paramJceInputStream.read(this.uOpenFlag, 0, false);
    if (cache_vGiftInfo == null)
    {
      cache_vGiftInfo = (byte[])new byte[1];
      ((byte[])cache_vGiftInfo)[0] = 0;
    }
    this.vGiftInfo = ((byte[])paramJceInputStream.read(cache_vGiftInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOpenFlag, 0);
    if (this.vGiftInfo != null) {
      paramJceOutputStream.write(this.vGiftInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SummaryCard.GiftInfo
 * JD-Core Version:    0.7.0.1
 */