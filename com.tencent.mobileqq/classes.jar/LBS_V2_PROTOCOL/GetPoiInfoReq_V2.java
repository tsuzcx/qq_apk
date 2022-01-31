package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetPoiInfoReq_V2
  extends JceStruct
{
  static ReqCommon_V2 cache_stCommon;
  static GPS_V2 cache_stGps;
  static ArrayList cache_vCellData;
  static ArrayList cache_vWifiData;
  public int iAccuracy;
  public int iAppID;
  public int iDistance = 100;
  public int iLocateCostTime;
  public ReqCommon_V2 stCommon;
  public GPS_V2 stGps;
  public String strAttachInfo = "";
  public String strClientIP = "";
  public String strKeyWord = "";
  public ArrayList vCellData;
  public ArrayList vWifiData;
  
  public GetPoiInfoReq_V2() {}
  
  public GetPoiInfoReq_V2(ReqCommon_V2 paramReqCommon_V2, GPS_V2 paramGPS_V2, ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    this.stCommon = paramReqCommon_V2;
    this.stGps = paramGPS_V2;
    this.vCellData = paramArrayList1;
    this.vWifiData = paramArrayList2;
    this.strClientIP = paramString1;
    this.strKeyWord = paramString2;
    this.iDistance = paramInt1;
    this.iAccuracy = paramInt2;
    this.iLocateCostTime = paramInt3;
    this.strAttachInfo = paramString3;
    this.iAppID = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stCommon == null) {
      cache_stCommon = new ReqCommon_V2();
    }
    this.stCommon = ((ReqCommon_V2)paramJceInputStream.read(cache_stCommon, 0, true));
    if (cache_stGps == null) {
      cache_stGps = new GPS_V2();
    }
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 1, true));
    Object localObject;
    if (cache_vCellData == null)
    {
      cache_vCellData = new ArrayList();
      localObject = new Cell_V2();
      cache_vCellData.add(localObject);
    }
    this.vCellData = ((ArrayList)paramJceInputStream.read(cache_vCellData, 2, true));
    if (cache_vWifiData == null)
    {
      cache_vWifiData = new ArrayList();
      localObject = new Wifi_V2();
      cache_vWifiData.add(localObject);
    }
    this.vWifiData = ((ArrayList)paramJceInputStream.read(cache_vWifiData, 3, true));
    this.strClientIP = paramJceInputStream.readString(4, true);
    this.strKeyWord = paramJceInputStream.readString(5, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 6, true);
    this.iAccuracy = paramJceInputStream.read(this.iAccuracy, 7, false);
    this.iLocateCostTime = paramJceInputStream.read(this.iLocateCostTime, 8, false);
    this.strAttachInfo = paramJceInputStream.readString(9, false);
    this.iAppID = paramJceInputStream.read(this.iAppID, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stCommon, 0);
    paramJceOutputStream.write(this.stGps, 1);
    paramJceOutputStream.write(this.vCellData, 2);
    paramJceOutputStream.write(this.vWifiData, 3);
    paramJceOutputStream.write(this.strClientIP, 4);
    paramJceOutputStream.write(this.strKeyWord, 5);
    paramJceOutputStream.write(this.iDistance, 6);
    paramJceOutputStream.write(this.iAccuracy, 7);
    paramJceOutputStream.write(this.iLocateCostTime, 8);
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 9);
    }
    paramJceOutputStream.write(this.iAppID, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetPoiInfoReq_V2
 * JD-Core Version:    0.7.0.1
 */