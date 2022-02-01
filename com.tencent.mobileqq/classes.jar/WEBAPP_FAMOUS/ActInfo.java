package WEBAPP_FAMOUS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ActInfo
  extends JceStruct
{
  public String act_icon = "";
  public String act_name = "";
  public String act_url = "";
  
  public ActInfo() {}
  
  public ActInfo(String paramString1, String paramString2, String paramString3)
  {
    this.act_name = paramString1;
    this.act_url = paramString2;
    this.act_icon = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.act_name = paramJceInputStream.readString(0, false);
    this.act_url = paramJceInputStream.readString(1, false);
    this.act_icon = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.act_name;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.act_url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.act_icon;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     WEBAPP_FAMOUS.ActInfo
 * JD-Core Version:    0.7.0.1
 */