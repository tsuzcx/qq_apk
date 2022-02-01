package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class comm_qzone_report_req
  extends JceStruct
{
  static Map<Integer, byte[]> cache_mapQzoneReportReq = new HashMap();
  public Map<Integer, byte[]> mapQzoneReportReq = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_mapQzoneReportReq.put(Integer.valueOf(0), arrayOfByte);
  }
  
  public comm_qzone_report_req() {}
  
  public comm_qzone_report_req(Map<Integer, byte[]> paramMap)
  {
    this.mapQzoneReportReq = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapQzoneReportReq = ((Map)paramJceInputStream.read(cache_mapQzoneReportReq, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.mapQzoneReportReq;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.comm_qzone_report_req
 * JD-Core Version:    0.7.0.1
 */