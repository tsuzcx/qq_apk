package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class InstanceInfo
  extends JceStruct
{
  public byte cTablet = 0;
  public int iAppId = 0;
  public long iClientType = 0L;
  public long iPlatform = 0L;
  public long iProductType = 0L;
  
  public InstanceInfo() {}
  
  public InstanceInfo(int paramInt, byte paramByte, long paramLong1, long paramLong2, long paramLong3)
  {
    this.iAppId = paramInt;
    this.cTablet = paramByte;
    this.iPlatform = paramLong1;
    this.iProductType = paramLong2;
    this.iClientType = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 0, false);
    this.cTablet = paramJceInputStream.read(this.cTablet, 1, false);
    this.iPlatform = paramJceInputStream.read(this.iPlatform, 2, false);
    this.iProductType = paramJceInputStream.read(this.iProductType, 3, false);
    this.iClientType = paramJceInputStream.read(this.iClientType, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 0);
    paramJceOutputStream.write(this.cTablet, 1);
    paramJceOutputStream.write(this.iPlatform, 2);
    paramJceOutputStream.write(this.iProductType, 3);
    paramJceOutputStream.write(this.iClientType, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.InstanceInfo
 * JD-Core Version:    0.7.0.1
 */