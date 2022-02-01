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
    localStringBuilder.append(this.result).append("|").append(this.seqno).append("|").append(this.uin).append("|").append(this.platform).append("|").append(this.version).append("|").append(this.sModule).append("|").append(this.sAction).append("|").append(this.iNetType).append("|").append(this.imei).append("|").append(this.guid);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 0);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 1);
    }
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.seqno, 3);
    if (this.sModule != null) {
      paramJceOutputStream.write(this.sModule, 4);
    }
    if (this.sAction != null) {
      paramJceOutputStream.write(this.sAction, 5);
    }
    paramJceOutputStream.write(this.iNetType, 6);
    paramJceOutputStream.write(this.result, 7);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 8);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VACDReport.ReportHeader
 * JD-Core Version:    0.7.0.1
 */