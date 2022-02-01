package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class entrance_cfg
  extends JceStruct
{
  static st_report_info cache_stReportInfo = new st_report_info();
  public int iEntranceId = 0;
  public int isAnchor = 0;
  public int isCanNotShowOnTeenagerMod = 0;
  public int isDefualt = 0;
  public String sEntranceAction = "";
  public String sEntranceIcon = "";
  public String sEntranceName = "";
  public String sQbossEntranceIcon = "";
  public String sQbossTraceInfo = "";
  public st_report_info stReportInfo = null;
  public int tabid = 0;
  
  public entrance_cfg() {}
  
  public entrance_cfg(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4, String paramString5, int paramInt4, st_report_info paramst_report_info, int paramInt5)
  {
    this.iEntranceId = paramInt1;
    this.sEntranceName = paramString1;
    this.sEntranceIcon = paramString2;
    this.sEntranceAction = paramString3;
    this.isDefualt = paramInt2;
    this.tabid = paramInt3;
    this.sQbossEntranceIcon = paramString4;
    this.sQbossTraceInfo = paramString5;
    this.isAnchor = paramInt4;
    this.stReportInfo = paramst_report_info;
    this.isCanNotShowOnTeenagerMod = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iEntranceId = paramJceInputStream.read(this.iEntranceId, 0, false);
    this.sEntranceName = paramJceInputStream.readString(1, false);
    this.sEntranceIcon = paramJceInputStream.readString(2, false);
    this.sEntranceAction = paramJceInputStream.readString(3, false);
    this.isDefualt = paramJceInputStream.read(this.isDefualt, 4, false);
    this.tabid = paramJceInputStream.read(this.tabid, 5, false);
    this.sQbossEntranceIcon = paramJceInputStream.readString(6, false);
    this.sQbossTraceInfo = paramJceInputStream.readString(7, false);
    this.isAnchor = paramJceInputStream.read(this.isAnchor, 8, false);
    this.stReportInfo = ((st_report_info)paramJceInputStream.read(cache_stReportInfo, 9, false));
    this.isCanNotShowOnTeenagerMod = paramJceInputStream.read(this.isCanNotShowOnTeenagerMod, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iEntranceId, 0);
    Object localObject = this.sEntranceName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.sEntranceIcon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.sEntranceAction;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.isDefualt, 4);
    paramJceOutputStream.write(this.tabid, 5);
    localObject = this.sQbossEntranceIcon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.sQbossTraceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.isAnchor, 8);
    localObject = this.stReportInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    paramJceOutputStream.write(this.isCanNotShowOnTeenagerMod, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.entrance_cfg
 * JD-Core Version:    0.7.0.1
 */