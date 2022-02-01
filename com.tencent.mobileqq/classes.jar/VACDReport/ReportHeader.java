package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportHeader
  extends JceStruct
  implements Cloneable
{
  public long createTime = 0L;
  public String guid = "";
  public int iNetType = 0;
  public String imei = "";
  public String platform = "";
  public int result = 0;
  public String sAction = "";
  public String sKey = "";
  public String sModule = "";
  public long seqno = 0L;
  public long startTime = 0L;
  public long totalTime = -1L;
  public long uin = 0L;
  public String version = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.platform = paramJceInputStream.readString(0, false);
    this.version = paramJceInputStream.readString(1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, true);
    this.seqno = paramJceInputStream.read(this.seqno, 3, true);
    this.sModule = paramJceInputStream.readString(4, false);
    this.sAction = paramJceInputStream.readString(5, false);
    this.iNetType = paramJceInputStream.read(this.iNetType, 6, false);
    this.result = paramJceInputStream.read(this.result, 7, false);
    this.imei = paramJceInputStream.readString(8, false);
    this.guid = paramJceInputStream.readString(9, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.result);
    localStringBuilder.append("|");
    localStringBuilder.append(this.seqno);
    localStringBuilder.append("|");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("|");
    localStringBuilder.append(this.platform);
    localStringBuilder.append("|");
    localStringBuilder.append(this.version);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sModule);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sAction);
    localStringBuilder.append("|");
    localStringBuilder.append(this.iNetType);
    localStringBuilder.append("|");
    localStringBuilder.append(this.imei);
    localStringBuilder.append("|");
    localStringBuilder.append(this.guid);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.platform;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.version;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.seqno, 3);
    str = this.sModule;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.sAction;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.iNetType, 6);
    paramJceOutputStream.write(this.result, 7);
    str = this.imei;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.guid;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VACDReport.ReportHeader
 * JD-Core Version:    0.7.0.1
 */