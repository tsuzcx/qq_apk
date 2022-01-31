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
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 0);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_app_acc
 * JD-Core Version:    0.7.0.1
 */