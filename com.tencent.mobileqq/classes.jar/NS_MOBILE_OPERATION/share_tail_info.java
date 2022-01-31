package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class share_tail_info
  extends JceStruct
{
  public String strButtonText = "";
  public String strButtonURL = "";
  public String strIconUrl = "";
  public String strTailSummary = "";
  public String strTailTitle = "";
  
  public share_tail_info() {}
  
  public share_tail_info(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.strTailTitle = paramString1;
    this.strTailSummary = paramString2;
    this.strButtonText = paramString3;
    this.strButtonURL = paramString4;
    this.strIconUrl = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strTailTitle = paramJceInputStream.readString(0, false);
    this.strTailSummary = paramJceInputStream.readString(1, false);
    this.strButtonText = paramJceInputStream.readString(2, false);
    this.strButtonURL = paramJceInputStream.readString(3, false);
    this.strIconUrl = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strTailTitle != null) {
      paramJceOutputStream.write(this.strTailTitle, 0);
    }
    if (this.strTailSummary != null) {
      paramJceOutputStream.write(this.strTailSummary, 1);
    }
    if (this.strButtonText != null) {
      paramJceOutputStream.write(this.strButtonText, 2);
    }
    if (this.strButtonURL != null) {
      paramJceOutputStream.write(this.strButtonURL, 3);
    }
    if (this.strIconUrl != null) {
      paramJceOutputStream.write(this.strIconUrl, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.share_tail_info
 * JD-Core Version:    0.7.0.1
 */