package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MobileQbossReportExceptionReq
  extends JceStruct
{
  static ArrayList<ReportExceptionInfo> cache_vecRepInfo = new ArrayList();
  public long uiUin = 0L;
  public ArrayList<ReportExceptionInfo> vecRepInfo = null;
  
  static
  {
    ReportExceptionInfo localReportExceptionInfo = new ReportExceptionInfo();
    cache_vecRepInfo.add(localReportExceptionInfo);
  }
  
  public MobileQbossReportExceptionReq() {}
  
  public MobileQbossReportExceptionReq(long paramLong, ArrayList<ReportExceptionInfo> paramArrayList)
  {
    this.uiUin = paramLong;
    this.vecRepInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiUin = paramJceInputStream.read(this.uiUin, 0, false);
    this.vecRepInfo = ((ArrayList)paramJceInputStream.read(cache_vecRepInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiUin, 0);
    ArrayList localArrayList = this.vecRepInfo;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionReq
 * JD-Core Version:    0.7.0.1
 */