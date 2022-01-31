package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AdvExposureInfo
  extends JceStruct
{
  static int cache_iAuditResult = 0;
  public int iAuditResult;
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
    if (this.strAdvId != null) {
      paramJceOutputStream.write(this.strAdvId, 0);
    }
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 1);
    }
    paramJceOutputStream.write(this.iAuditResult, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.AdvExposureInfo
 * JD-Core Version:    0.7.0.1
 */