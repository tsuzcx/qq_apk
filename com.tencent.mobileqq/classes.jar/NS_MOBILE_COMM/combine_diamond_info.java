package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class combine_diamond_info
  extends JceStruct
{
  public int iShowType;
  public int iVipLevel;
  public byte isAnnualVip;
  public byte isAnnualVipEver;
  
  public combine_diamond_info() {}
  
  public combine_diamond_info(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    this.iShowType = paramInt1;
    this.iVipLevel = paramInt2;
    this.isAnnualVip = paramByte1;
    this.isAnnualVipEver = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iShowType = paramJceInputStream.read(this.iShowType, 0, false);
    this.iVipLevel = paramJceInputStream.read(this.iVipLevel, 1, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 2, false);
    this.isAnnualVipEver = paramJceInputStream.read(this.isAnnualVipEver, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iShowType, 0);
    paramJceOutputStream.write(this.iVipLevel, 1);
    paramJceOutputStream.write(this.isAnnualVip, 2);
    paramJceOutputStream.write(this.isAnnualVipEver, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_COMM.combine_diamond_info
 * JD-Core Version:    0.7.0.1
 */