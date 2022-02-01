package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_mainPageTabItem
  extends JceStruct
{
  public String content = "";
  public String icon = "";
  public String jumpUrl = "";
  public int order = 0;
  
  public s_mainPageTabItem() {}
  
  public s_mainPageTabItem(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.icon = paramString1;
    this.content = paramString2;
    this.jumpUrl = paramString3;
    this.order = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.icon = paramJceInputStream.readString(0, false);
    this.content = paramJceInputStream.readString(1, false);
    this.jumpUrl = paramJceInputStream.readString(2, false);
    this.order = paramJceInputStream.read(this.order, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.icon;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.jumpUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.order, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_mainPageTabItem
 * JD-Core Version:    0.7.0.1
 */