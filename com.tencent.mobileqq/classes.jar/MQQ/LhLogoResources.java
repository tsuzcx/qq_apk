package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LhLogoResources
  extends JceStruct
{
  public String apngUrl = "";
  public String backUrl = "";
  public String lightColor = "";
  public String logoUrl = "";
  public String normalColor = "";
  
  public LhLogoResources() {}
  
  public LhLogoResources(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.backUrl = paramString1;
    this.apngUrl = paramString2;
    this.logoUrl = paramString3;
    this.normalColor = paramString4;
    this.lightColor = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.backUrl = paramJceInputStream.readString(0, false);
    this.apngUrl = paramJceInputStream.readString(1, false);
    this.logoUrl = paramJceInputStream.readString(2, false);
    this.normalColor = paramJceInputStream.readString(3, false);
    this.lightColor = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.backUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.apngUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.logoUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.normalColor;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.lightColor;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.LhLogoResources
 * JD-Core Version:    0.7.0.1
 */