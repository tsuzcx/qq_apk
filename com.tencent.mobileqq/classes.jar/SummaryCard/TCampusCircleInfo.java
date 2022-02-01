package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TCampusCircleInfo
  extends JceStruct
{
  static int cache_eStatus;
  static TCampusSchoolInfo cache_stSchoolInfo = new TCampusSchoolInfo();
  public int eStatus = 0;
  public int iIsSigned = 0;
  public TCampusSchoolInfo stSchoolInfo = null;
  public String strAcademy = "";
  public String strName = "";
  
  public TCampusCircleInfo() {}
  
  public TCampusCircleInfo(int paramInt1, String paramString1, String paramString2, int paramInt2, TCampusSchoolInfo paramTCampusSchoolInfo)
  {
    this.iIsSigned = paramInt1;
    this.strName = paramString1;
    this.strAcademy = paramString2;
    this.eStatus = paramInt2;
    this.stSchoolInfo = paramTCampusSchoolInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iIsSigned = paramJceInputStream.read(this.iIsSigned, 0, false);
    this.strName = paramJceInputStream.readString(1, false);
    this.strAcademy = paramJceInputStream.readString(2, false);
    this.eStatus = paramJceInputStream.read(this.eStatus, 3, false);
    this.stSchoolInfo = ((TCampusSchoolInfo)paramJceInputStream.read(cache_stSchoolInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iIsSigned, 0);
    Object localObject = this.strName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.strAcademy;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.eStatus, 3);
    localObject = this.stSchoolInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.TCampusCircleInfo
 * JD-Core Version:    0.7.0.1
 */