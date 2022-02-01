package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcReqMSFLoginNotify
  extends JceStruct
{
  static ArrayList<InstanceInfo> cache_vecInstanceList = new ArrayList();
  public byte cStatus = 0;
  public byte cTablet = 0;
  public long iAppId = 0L;
  public long iClientType = 0L;
  public long iPlatform = 0L;
  public long iProductType = 0L;
  public String strInfo = "";
  public String strTitle = "";
  public ArrayList<InstanceInfo> vecInstanceList = null;
  
  static
  {
    InstanceInfo localInstanceInfo = new InstanceInfo();
    cache_vecInstanceList.add(localInstanceInfo);
  }
  
  public SvcReqMSFLoginNotify() {}
  
  public SvcReqMSFLoginNotify(long paramLong1, byte paramByte1, byte paramByte2, long paramLong2, String paramString1, String paramString2, long paramLong3, long paramLong4, ArrayList<InstanceInfo> paramArrayList)
  {
    this.iAppId = paramLong1;
    this.cStatus = paramByte1;
    this.cTablet = paramByte2;
    this.iPlatform = paramLong2;
    this.strTitle = paramString1;
    this.strInfo = paramString2;
    this.iProductType = paramLong3;
    this.iClientType = paramLong4;
    this.vecInstanceList = paramArrayList;
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
    this.vecInstanceList = ((ArrayList)paramJceInputStream.read(cache_vecInstanceList, 8, false));
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
    if (this.vecInstanceList != null) {
      paramJceOutputStream.write(this.vecInstanceList, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.SvcReqMSFLoginNotify
 * JD-Core Version:    0.7.0.1
 */