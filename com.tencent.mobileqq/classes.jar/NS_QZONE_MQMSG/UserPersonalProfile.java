package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserPersonalProfile
  extends JceStruct
{
  static byte[] cache_vecBuff = (byte[])new byte[1];
  public int isAnnualVip = 0;
  public int isLoversVip = 0;
  public byte[] vecBuff = null;
  public int vip = 0;
  public int vipLevel = 0;
  
  static
  {
    ((byte[])cache_vecBuff)[0] = 0;
  }
  
  public UserPersonalProfile() {}
  
  public UserPersonalProfile(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.vip = paramInt1;
    this.vipLevel = paramInt2;
    this.isAnnualVip = paramInt3;
    this.isLoversVip = paramInt4;
    this.vecBuff = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vip = paramJceInputStream.read(this.vip, 0, false);
    this.vipLevel = paramJceInputStream.read(this.vipLevel, 1, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 2, false);
    this.isLoversVip = paramJceInputStream.read(this.isLoversVip, 3, false);
    this.vecBuff = ((byte[])paramJceInputStream.read(cache_vecBuff, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vip, 0);
    paramJceOutputStream.write(this.vipLevel, 1);
    paramJceOutputStream.write(this.isAnnualVip, 2);
    paramJceOutputStream.write(this.isLoversVip, 3);
    if (this.vecBuff != null) {
      paramJceOutputStream.write(this.vecBuff, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.UserPersonalProfile
 * JD-Core Version:    0.7.0.1
 */