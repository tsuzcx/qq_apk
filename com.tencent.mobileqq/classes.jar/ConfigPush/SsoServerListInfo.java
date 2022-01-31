package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SsoServerListInfo
  extends JceStruct
{
  public byte bLinkType;
  public byte bProtocolType;
  public byte bProxy;
  public int iPort;
  public int iTimeOut = 10;
  public String sIP = "";
  
  public SsoServerListInfo() {}
  
  public SsoServerListInfo(String paramString, int paramInt1, byte paramByte1, byte paramByte2, byte paramByte3, int paramInt2)
  {
    this.sIP = paramString;
    this.iPort = paramInt1;
    this.bLinkType = paramByte1;
    this.bProxy = paramByte2;
    this.bProtocolType = paramByte3;
    this.iTimeOut = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sIP = paramJceInputStream.readString(1, true);
    this.iPort = paramJceInputStream.read(this.iPort, 2, true);
    this.bLinkType = paramJceInputStream.read(this.bLinkType, 3, true);
    this.bProxy = paramJceInputStream.read(this.bProxy, 4, true);
    this.bProtocolType = paramJceInputStream.read(this.bProtocolType, 5, false);
    this.iTimeOut = paramJceInputStream.read(this.iTimeOut, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sIP, 1);
    paramJceOutputStream.write(this.iPort, 2);
    paramJceOutputStream.write(this.bLinkType, 3);
    paramJceOutputStream.write(this.bProxy, 4);
    paramJceOutputStream.write(this.bProtocolType, 5);
    paramJceOutputStream.write(this.iTimeOut, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     ConfigPush.SsoServerListInfo
 * JD-Core Version:    0.7.0.1
 */