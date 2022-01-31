package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqMSFLoginNotify
  extends JceStruct
{
  public byte cStatus;
  public byte cTablet;
  public long iAppId;
  public long iClientType;
  public long iPlatform;
  public long iProductType;
  public String strInfo = "";
  public String strTitle = "";
  
  public SvcReqMSFLoginNotify() {}
  
  public SvcReqMSFLoginNotify(long paramLong1, byte paramByte1, byte paramByte2, long paramLong2, String paramString1, String paramString2, long paramLong3, long paramLong4)
  {
    this.iAppId = paramLong1;
    this.cStatus = paramByte1;
    this.cTablet = paramByte2;
    this.iPlatform = paramLong2;
    this.strTitle = paramString1;
    this.strInfo = paramString2;
    this.iProductType = paramLong3;
    this.iClientType = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 0, true);
    this.cStatus = paramJceInputStream.read(this.cStatus, 1, true);
    this.cTablet = paramJceInputStream.read(this.cTablet, 2, false);
    this.iPlatform = paramJceInputStream.read(this.iPlatform, 3, false);
    this.strTitle = paramJceInputStream.readString(4, false);
    this.strInfo = paramJceInputStream.readString(5, false);
    this.iProductType = paramJceInputStream.read(this.iProductType, 6, false);
    this.iClientType = paramJceInputStream.read(this.iClientType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 0);
    paramJceOutputStream.write(this.cStatus, 1);
    paramJceOutputStream.write(this.cTablet, 2);
    paramJceOutputStream.write(this.iPlatform, 3);
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 4);
    }
    if (this.strInfo != null) {
      paramJceOutputStream.write(this.strInfo, 5);
    }
    paramJceOutputStream.write(this.iProductType, 6);
    paramJceOutputStream.write(this.iClientType, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.SvcReqMSFLoginNotify
 * JD-Core Version:    0.7.0.1
 */