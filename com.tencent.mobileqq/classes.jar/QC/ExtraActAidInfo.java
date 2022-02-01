package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ExtraActAidInfo
  extends JceStruct
{
  public String androidAid = "";
  public String errMsg = "";
  public String iosAid = "";
  public String month = "";
  public String payType = "";
  
  public ExtraActAidInfo() {}
  
  public ExtraActAidInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.androidAid = paramString1;
    this.iosAid = paramString2;
    this.payType = paramString3;
    this.month = paramString4;
    this.errMsg = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.androidAid = paramJceInputStream.readString(1, false);
    this.iosAid = paramJceInputStream.readString(2, false);
    this.payType = paramJceInputStream.readString(3, false);
    this.month = paramJceInputStream.readString(4, false);
    this.errMsg = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.androidAid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.iosAid;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.payType;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.month;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.errMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.ExtraActAidInfo
 * JD-Core Version:    0.7.0.1
 */