package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_app_acc
  extends JceStruct
{
  public String name = "";
  public String url = "";
  
  public s_app_acc() {}
  
  public s_app_acc(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, false);
    this.url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.name;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_app_acc
 * JD-Core Version:    0.7.0.1
 */