package MyCarrier.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PreLoadCarrierReq
  extends JceStruct
{
  public String MQQVersion = "";
  public int bindType;
  public String mobile = "";
  public int netType;
  public int osType;
  
  public PreLoadCarrierReq() {}
  
  public PreLoadCarrierReq(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    this.mobile = paramString1;
    this.bindType = paramInt1;
    this.osType = paramInt2;
    this.MQQVersion = paramString2;
    this.netType = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mobile = paramJceInputStream.readString(0, true);
    this.bindType = paramJceInputStream.read(this.bindType, 1, true);
    this.osType = paramJceInputStream.read(this.osType, 2, true);
    this.MQQVersion = paramJceInputStream.readString(3, true);
    this.netType = paramJceInputStream.read(this.netType, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mobile, 0);
    paramJceOutputStream.write(this.bindType, 1);
    paramJceOutputStream.write(this.osType, 2);
    paramJceOutputStream.write(this.MQQVersion, 3);
    paramJceOutputStream.write(this.netType, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     MyCarrier.MQQ.PreLoadCarrierReq
 * JD-Core Version:    0.7.0.1
 */