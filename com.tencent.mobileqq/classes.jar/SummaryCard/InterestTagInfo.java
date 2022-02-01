package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class InterestTagInfo
  extends JceStruct
{
  static byte[] cache_vGiftInfo;
  public long uFlag = 0L;
  public byte[] vGiftInfo = null;
  
  public InterestTagInfo() {}
  
  public InterestTagInfo(long paramLong, byte[] paramArrayOfByte)
  {
    this.uFlag = paramLong;
    this.vGiftInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFlag = paramJceInputStream.read(this.uFlag, 0, false);
    if (cache_vGiftInfo == null)
    {
      cache_vGiftInfo = (byte[])new byte[1];
      ((byte[])cache_vGiftInfo)[0] = 0;
    }
    this.vGiftInfo = ((byte[])paramJceInputStream.read(cache_vGiftInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFlag, 0);
    if (this.vGiftInfo != null) {
      paramJceOutputStream.write(this.vGiftInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.InterestTagInfo
 * JD-Core Version:    0.7.0.1
 */