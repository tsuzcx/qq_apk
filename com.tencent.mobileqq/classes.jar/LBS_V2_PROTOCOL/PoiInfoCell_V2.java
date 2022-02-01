package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PoiInfoCell_V2
  extends JceStruct
{
  static GPS_V2 cache_stClientGps = new GPS_V2();
  static GPS_V2 cache_stGps = new GPS_V2();
  static ArrayList<PoiInfo_V2> cache_vPoiList = new ArrayList();
  public int iRet = 0;
  public String stCityName = "";
  public GPS_V2 stClientGps = null;
  public GPS_V2 stGps = null;
  public ArrayList<PoiInfo_V2> vPoiList = null;
  
  static
  {
    PoiInfo_V2 localPoiInfo_V2 = new PoiInfo_V2();
    cache_vPoiList.add(localPoiInfo_V2);
  }
  
  public PoiInfoCell_V2() {}
  
  public PoiInfoCell_V2(GPS_V2 paramGPS_V21, ArrayList<PoiInfo_V2> paramArrayList, int paramInt, GPS_V2 paramGPS_V22, String paramString)
  {
    this.stGps = paramGPS_V21;
    this.vPoiList = paramArrayList;
    this.iRet = paramInt;
    this.stClientGps = paramGPS_V22;
    this.stCityName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 0, false));
    this.vPoiList = ((ArrayList)paramJceInputStream.read(cache_vPoiList, 1, false));
    this.iRet = paramJceInputStream.read(this.iRet, 2, false);
    this.stClientGps = ((GPS_V2)paramJceInputStream.read(cache_stClientGps, 3, false));
    this.stCityName = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stGps;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.vPoiList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    paramJceOutputStream.write(this.iRet, 2);
    localObject = this.stClientGps;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stCityName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.PoiInfoCell_V2
 * JD-Core Version:    0.7.0.1
 */