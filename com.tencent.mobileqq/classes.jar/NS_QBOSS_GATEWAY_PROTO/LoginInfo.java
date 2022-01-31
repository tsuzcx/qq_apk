package NS_QBOSS_GATEWAY_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LoginInfo
  extends JceStruct
{
  public String strAuthKey = "";
  public long uAuthType;
  public long uHostUin;
  public long uPtId;
  public long uUserIpNet;
  
  public LoginInfo() {}
  
  public LoginInfo(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    this.uAuthType = paramLong1;
    this.strAuthKey = paramString;
    this.uUserIpNet = paramLong2;
    this.uHostUin = paramLong3;
    this.uPtId = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uAuthType = paramJceInputStream.read(this.uAuthType, 0, false);
    this.strAuthKey = paramJceInputStream.readString(1, false);
    this.uUserIpNet = paramJceInputStream.read(this.uUserIpNet, 2, false);
    this.uHostUin = paramJceInputStream.read(this.uHostUin, 3, false);
    this.uPtId = paramJceInputStream.read(this.uPtId, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uAuthType, 0);
    if (this.strAuthKey != null) {
      paramJceOutputStream.write(this.strAuthKey, 1);
    }
    paramJceOutputStream.write(this.uUserIpNet, 2);
    paramJceOutputStream.write(this.uHostUin, 3);
    paramJceOutputStream.write(this.uPtId, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QBOSS_GATEWAY_PROTO.LoginInfo
 * JD-Core Version:    0.7.0.1
 */