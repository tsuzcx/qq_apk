package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AdvExposureInfo
  extends JceStruct
{
  static int cache_iAuditResult;
  public int iAuditResult = 0;
  public String strAdvId = "";
  public String strName = "";
  
  public AdvExposureInfo() {}
  
  public AdvExposureInfo(String paramString1, String paramString2, int paramInt)
  {
    this.strAdvId = paramString1;
    this.strName = paramString2;
    this.iAuditResult = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strAdvId = paramJceInputStream.readString(0, false);
    this.strName = paramJceInputStream.readString(1, false);
    this.iAuditResult = paramJceInputStream.read(this.iAuditResult, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strAdvId;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.iAuditResult, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.AdvExposureInfo
 * JD-Core Version:    0.7.0.1
 */