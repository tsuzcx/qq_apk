package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetBatchPoiReq_V2
  extends JceStruct
{
  static ReqCommon_V2 cache_stCommon = new ReqCommon_V2();
  static ArrayList cache_vecGpsInfo = new ArrayList();
  public int opMask;
  public ReqCommon_V2 stCommon;
  public ArrayList vecGpsInfo;
  
  static
  {
    GPS_V2 localGPS_V2 = new GPS_V2();
    cache_vecGpsInfo.add(localGPS_V2);
  }
  
  public GetBatchPoiReq_V2() {}
  
  public GetBatchPoiReq_V2(ReqCommon_V2 paramReqCommon_V2, ArrayList paramArrayList, int paramInt)
  {
    this.stCommon = paramReqCommon_V2;
    this.vecGpsInfo = paramArrayList;
    this.opMask = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCommon = ((ReqCommon_V2)paramJceInputStream.read(cache_stCommon, 0, true));
    this.vecGpsInfo = ((ArrayList)paramJceInputStream.read(cache_vecGpsInfo, 1, false));
    this.opMask = paramJceInputStream.read(this.opMask, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stCommon, 0);
    if (this.vecGpsInfo != null) {
      paramJceOutputStream.write(this.vecGpsInfo, 1);
    }
    paramJceOutputStream.write(this.opMask, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetBatchPoiReq_V2
 * JD-Core Version:    0.7.0.1
 */