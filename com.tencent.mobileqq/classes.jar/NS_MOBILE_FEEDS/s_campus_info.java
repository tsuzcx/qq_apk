package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_campus_info
  extends JceStruct
{
  static int cache_eVerfyStatus = 0;
  public int eVerfyStatus;
  public long iSchoolIdx;
  public String strSchoolID = "";
  public String strSchoolName = "";
  
  public s_campus_info() {}
  
  public s_campus_info(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.strSchoolName = paramString1;
    this.eVerfyStatus = paramInt;
    this.iSchoolIdx = paramLong;
    this.strSchoolID = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strSchoolName = paramJceInputStream.readString(0, false);
    this.eVerfyStatus = paramJceInputStream.read(this.eVerfyStatus, 1, false);
    this.iSchoolIdx = paramJceInputStream.read(this.iSchoolIdx, 2, false);
    this.strSchoolID = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strSchoolName != null) {
      paramJceOutputStream.write(this.strSchoolName, 0);
    }
    paramJceOutputStream.write(this.eVerfyStatus, 1);
    paramJceOutputStream.write(this.iSchoolIdx, 2);
    if (this.strSchoolID != null) {
      paramJceOutputStream.write(this.strSchoolID, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_campus_info
 * JD-Core Version:    0.7.0.1
 */