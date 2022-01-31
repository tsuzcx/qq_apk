package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiCommItemAidInfo
  extends JceStruct
{
  public String androidAid = "";
  public String errMsg = "";
  public String iosAid = "";
  public String month = "";
  public String payType = "";
  
  public UniBusiCommItemAidInfo() {}
  
  public UniBusiCommItemAidInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
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
    if (this.androidAid != null) {
      paramJceOutputStream.write(this.androidAid, 1);
    }
    if (this.iosAid != null) {
      paramJceOutputStream.write(this.iosAid, 2);
    }
    if (this.payType != null) {
      paramJceOutputStream.write(this.payType, 3);
    }
    if (this.month != null) {
      paramJceOutputStream.write(this.month, 4);
    }
    if (this.errMsg != null) {
      paramJceOutputStream.write(this.errMsg, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiCommItemAidInfo
 * JD-Core Version:    0.7.0.1
 */