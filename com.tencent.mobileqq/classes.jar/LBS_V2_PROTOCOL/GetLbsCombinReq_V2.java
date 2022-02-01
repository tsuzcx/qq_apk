package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetLbsCombinReq_V2
  extends JceStruct
{
  static Map<String, String> cache_map_ext;
  static ReqCommon_V2 cache_stCommon = new ReqCommon_V2();
  static GeoInfo_V2 cache_stGeoInfo;
  static GPS_V2 cache_stGps = new GPS_V2();
  static Date cache_stUserDate;
  static ArrayList<Cell_V2> cache_vCellData = new ArrayList();
  static ArrayList<Wifi_V2> cache_vWifiData;
  public int iAccuracy = 0;
  public int iAppID = 0;
  public int iLocateCostTime = 0;
  public int iMood = 0;
  public int iReqNum = 10;
  public long iUserTime = 0L;
  public Map<String, String> map_ext = null;
  public ReqCommon_V2 stCommon = null;
  public GeoInfo_V2 stGeoInfo = null;
  public GPS_V2 stGps = null;
  public Date stUserDate = null;
  public String strClientIP = "";
  public ArrayList<Cell_V2> vCellData = null;
  public ArrayList<Wifi_V2> vWifiData = null;
  
  static
  {
    Object localObject = new Cell_V2();
    cache_vCellData.add(localObject);
    cache_vWifiData = new ArrayList();
    localObject = new Wifi_V2();
    cache_vWifiData.add(localObject);
    cache_stGeoInfo = new GeoInfo_V2();
    cache_stUserDate = new Date();
    cache_map_ext = new HashMap();
    cache_map_ext.put("", "");
  }
  
  public GetLbsCombinReq_V2() {}
  
  public GetLbsCombinReq_V2(ReqCommon_V2 paramReqCommon_V2, String paramString, GPS_V2 paramGPS_V2, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, GeoInfo_V2 paramGeoInfo_V2, long paramLong, int paramInt5, Date paramDate, Map<String, String> paramMap)
  {
    this.stCommon = paramReqCommon_V2;
    this.strClientIP = paramString;
    this.stGps = paramGPS_V2;
    this.vCellData = paramArrayList;
    this.vWifiData = paramArrayList1;
    this.iReqNum = paramInt1;
    this.iAccuracy = paramInt2;
    this.iLocateCostTime = paramInt3;
    this.iMood = paramInt4;
    this.stGeoInfo = paramGeoInfo_V2;
    this.iUserTime = paramLong;
    this.iAppID = paramInt5;
    this.stUserDate = paramDate;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCommon = ((ReqCommon_V2)paramJceInputStream.read(cache_stCommon, 0, true));
    this.strClientIP = paramJceInputStream.readString(1, true);
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 2, true));
    this.vCellData = ((ArrayList)paramJceInputStream.read(cache_vCellData, 3, true));
    this.vWifiData = ((ArrayList)paramJceInputStream.read(cache_vWifiData, 4, true));
    this.iReqNum = paramJceInputStream.read(this.iReqNum, 5, true);
    this.iAccuracy = paramJceInputStream.read(this.iAccuracy, 6, false);
    this.iLocateCostTime = paramJceInputStream.read(this.iLocateCostTime, 7, false);
    this.iMood = paramJceInputStream.read(this.iMood, 8, false);
    this.stGeoInfo = ((GeoInfo_V2)paramJceInputStream.read(cache_stGeoInfo, 9, false));
    this.iUserTime = paramJceInputStream.read(this.iUserTime, 10, false);
    this.iAppID = paramJceInputStream.read(this.iAppID, 11, false);
    this.stUserDate = ((Date)paramJceInputStream.read(cache_stUserDate, 12, false));
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stCommon, 0);
    paramJceOutputStream.write(this.strClientIP, 1);
    paramJceOutputStream.write(this.stGps, 2);
    paramJceOutputStream.write(this.vCellData, 3);
    paramJceOutputStream.write(this.vWifiData, 4);
    paramJceOutputStream.write(this.iReqNum, 5);
    paramJceOutputStream.write(this.iAccuracy, 6);
    paramJceOutputStream.write(this.iLocateCostTime, 7);
    paramJceOutputStream.write(this.iMood, 8);
    if (this.stGeoInfo != null) {
      paramJceOutputStream.write(this.stGeoInfo, 9);
    }
    paramJceOutputStream.write(this.iUserTime, 10);
    paramJceOutputStream.write(this.iAppID, 11);
    if (this.stUserDate != null) {
      paramJceOutputStream.write(this.stUserDate, 12);
    }
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetLbsCombinReq_V2
 * JD-Core Version:    0.7.0.1
 */