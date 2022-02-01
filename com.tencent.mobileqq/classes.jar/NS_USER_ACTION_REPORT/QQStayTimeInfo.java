package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QQStayTimeInfo
  extends JceStruct
{
  public long enter_time = 0L;
  public String page_info = "";
  public String page_info_ext = "";
  public String path_desc = "";
  public long report_time = 0L;
  public long stay_time = 0L;
  
  public QQStayTimeInfo() {}
  
  public QQStayTimeInfo(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    this.report_time = paramLong1;
    this.page_info = paramString1;
    this.page_info_ext = paramString2;
    this.path_desc = paramString3;
    this.enter_time = paramLong2;
    this.stay_time = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.report_time = paramJceInputStream.read(this.report_time, 0, true);
    this.page_info = paramJceInputStream.readString(1, true);
    this.page_info_ext = paramJceInputStream.readString(2, false);
    this.path_desc = paramJceInputStream.readString(3, false);
    this.enter_time = paramJceInputStream.read(this.enter_time, 4, true);
    this.stay_time = paramJceInputStream.read(this.stay_time, 5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.report_time, 0);
    paramJceOutputStream.write(this.page_info, 1);
    String str = this.page_info_ext;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.path_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.enter_time, 4);
    paramJceOutputStream.write(this.stay_time, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.QQStayTimeInfo
 * JD-Core Version:    0.7.0.1
 */