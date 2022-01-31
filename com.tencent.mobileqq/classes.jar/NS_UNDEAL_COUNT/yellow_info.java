package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class yellow_info
  extends JceStruct
{
  public int iYellowLevel;
  public int iYellowType;
  public byte isAnnualVip;
  
  public yellow_info() {}
  
  public yellow_info(int paramInt1, int paramInt2, byte paramByte)
  {
    this.iYellowType = paramInt1;
    this.iYellowLevel = paramInt2;
    this.isAnnualVip = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iYellowType = paramJceInputStream.read(this.iYellowType, 0, false);
    this.iYellowLevel = paramJceInputStream.read(this.iYellowLevel, 1, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iYellowType, 0);
    paramJceOutputStream.write(this.iYellowLevel, 1);
    paramJceOutputStream.write(this.isAnnualVip, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_UNDEAL_COUNT.yellow_info
 * JD-Core Version:    0.7.0.1
 */