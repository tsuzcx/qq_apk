package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IOSTerminal
  extends JceStruct
{
  public String idfa = "";
  public String mode = "";
  public String osVersion = "";
  public String ua = "";
  public String uniqueId = "";
  
  public IOSTerminal() {}
  
  public IOSTerminal(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.idfa = paramString1;
    this.osVersion = paramString2;
    this.ua = paramString3;
    this.mode = paramString4;
    this.uniqueId = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.idfa = paramJceInputStream.readString(0, false);
    this.osVersion = paramJceInputStream.readString(1, false);
    this.ua = paramJceInputStream.readString(2, false);
    this.mode = paramJceInputStream.readString(3, false);
    this.uniqueId = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.idfa != null) {
      paramJceOutputStream.write(this.idfa, 0);
    }
    if (this.osVersion != null) {
      paramJceOutputStream.write(this.osVersion, 1);
    }
    if (this.ua != null) {
      paramJceOutputStream.write(this.ua, 2);
    }
    if (this.mode != null) {
      paramJceOutputStream.write(this.mode, 3);
    }
    if (this.uniqueId != null) {
      paramJceOutputStream.write(this.uniqueId, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_NEW_MOBILE_REPORT.IOSTerminal
 * JD-Core Version:    0.7.0.1
 */