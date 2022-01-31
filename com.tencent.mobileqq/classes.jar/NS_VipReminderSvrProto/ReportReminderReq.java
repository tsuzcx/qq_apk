package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportReminderReq
  extends JceStruct
{
  public int iReportType = 1;
  public int iZoneId;
  public String sReportValue = "";
  public long uiUin;
  
  public ReportReminderReq() {}
  
  public ReportReminderReq(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    this.uiUin = paramLong;
    this.iZoneId = paramInt1;
    this.iReportType = paramInt2;
    this.sReportValue = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiUin = paramJceInputStream.read(this.uiUin, 0, true);
    this.iZoneId = paramJceInputStream.read(this.iZoneId, 1, true);
    this.iReportType = paramJceInputStream.read(this.iReportType, 2, true);
    this.sReportValue = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiUin, 0);
    paramJceOutputStream.write(this.iZoneId, 1);
    paramJceOutputStream.write(this.iReportType, 2);
    paramJceOutputStream.write(this.sReportValue, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_VipReminderSvrProto.ReportReminderReq
 * JD-Core Version:    0.7.0.1
 */