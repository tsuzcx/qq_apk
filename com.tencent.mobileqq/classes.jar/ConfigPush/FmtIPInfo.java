package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FmtIPInfo
  extends JceStruct
{
  public long iGateIpOper;
  public String sGateIp = "";
  
  public FmtIPInfo() {}
  
  public FmtIPInfo(String paramString, long paramLong)
  {
    this.sGateIp = paramString;
    this.iGateIpOper = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sGateIp = paramJceInputStream.readString(0, true);
    this.iGateIpOper = paramJceInputStream.read(this.iGateIpOper, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sGateIp, 0);
    paramJceOutputStream.write(this.iGateIpOper, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     ConfigPush.FmtIPInfo
 * JD-Core Version:    0.7.0.1
 */