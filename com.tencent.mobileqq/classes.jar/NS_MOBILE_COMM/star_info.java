package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class star_info
  extends JceStruct
{
  public int iStarLevel;
  public int iStarStatus;
  public byte isAnnualVip;
  public byte isHighStarVip;
  
  public star_info() {}
  
  public star_info(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    this.iStarStatus = paramInt1;
    this.iStarLevel = paramInt2;
    this.isAnnualVip = paramByte1;
    this.isHighStarVip = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iStarStatus = paramJceInputStream.read(this.iStarStatus, 0, false);
    this.iStarLevel = paramJceInputStream.read(this.iStarLevel, 1, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 2, false);
    this.isHighStarVip = paramJceInputStream.read(this.isHighStarVip, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iStarStatus, 0);
    paramJceOutputStream.write(this.iStarLevel, 1);
    paramJceOutputStream.write(this.isAnnualVip, 2);
    paramJceOutputStream.write(this.isHighStarVip, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_COMM.star_info
 * JD-Core Version:    0.7.0.1
 */