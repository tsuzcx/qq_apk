package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetBatchPoiReq_V2
  extends JceStruct
{
  static Map<String, String> cache_map_ext;
  static ReqCommon_V2 cache_stCommon = new ReqCommon_V2();
  static ArrayList<GPS_V2> cache_vecGpsInfo = new ArrayList();
  public Map<String, String> map_ext;
  public int opMask;
  public ReqCommon_V2 stCommon;
  public ArrayList<GPS_V2> vecGpsInfo;
  
  static
  {
    GPS_V2 localGPS_V2 = new GPS_V2();
    cache_vecGpsInfo.add(localGPS_V2);
    cache_map_ext = new HashMap();
    cache_map_ext.put("", "");
  }
  
  public GetBatchPoiReq_V2() {}
  
  public GetBatchPoiReq_V2(ReqCommon_V2 paramReqCommon_V2, ArrayList<GPS_V2> paramArrayList, int paramInt, Map<String, String> paramMap)
  {
    this.stCommon = paramReqCommon_V2;
    this.vecGpsInfo = paramArrayList;
    this.opMask = paramInt;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCommon = ((ReqCommon_V2)paramJceInputStream.read(cache_stCommon, 0, true));
    this.vecGpsInfo = ((ArrayList)paramJceInputStream.read(cache_vecGpsInfo, 1, false));
    this.opMask = paramJceInputStream.read(this.opMask, 2, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stCommon, 0);
    if (this.vecGpsInfo != null) {
      paramJceOutputStream.write(this.vecGpsInfo, 1);
    }
    paramJceOutputStream.write(this.opMask, 2);
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetBatchPoiReq_V2
 * JD-Core Version:    0.7.0.1
 */