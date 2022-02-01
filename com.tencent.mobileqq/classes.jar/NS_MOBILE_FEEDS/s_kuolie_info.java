package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_kuolie_info
  extends JceStruct
{
  static s_campus_info cache_vecCampusInfo = new s_campus_info();
  public int iDays = 0;
  public int iFrdFlag = 0;
  public int iFrdsCnt = 0;
  public int iLastNuanTime = 0;
  public int iState = 0;
  public String strKuolieCampusAIOKey = "";
  public s_campus_info vecCampusInfo = null;
  
  public s_kuolie_info() {}
  
  public s_kuolie_info(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, s_campus_info params_campus_info, String paramString)
  {
    this.iFrdFlag = paramInt1;
    this.iFrdsCnt = paramInt2;
    this.iState = paramInt3;
    this.iDays = paramInt4;
    this.iLastNuanTime = paramInt5;
    this.vecCampusInfo = params_campus_info;
    this.strKuolieCampusAIOKey = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFrdFlag = paramJceInputStream.read(this.iFrdFlag, 0, false);
    this.iFrdsCnt = paramJceInputStream.read(this.iFrdsCnt, 1, false);
    this.iState = paramJceInputStream.read(this.iState, 2, false);
    this.iDays = paramJceInputStream.read(this.iDays, 3, false);
    this.iLastNuanTime = paramJceInputStream.read(this.iLastNuanTime, 4, false);
    this.vecCampusInfo = ((s_campus_info)paramJceInputStream.read(cache_vecCampusInfo, 5, false));
    this.strKuolieCampusAIOKey = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFrdFlag, 0);
    paramJceOutputStream.write(this.iFrdsCnt, 1);
    paramJceOutputStream.write(this.iState, 2);
    paramJceOutputStream.write(this.iDays, 3);
    paramJceOutputStream.write(this.iLastNuanTime, 4);
    Object localObject = this.vecCampusInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.strKuolieCampusAIOKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_kuolie_info
 * JD-Core Version:    0.7.0.1
 */