package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_refer
  extends JceStruct
{
  public int actiontype = 0;
  public String actionurl = "";
  public String appid = "";
  public String appname = "";
  public String downloadurl = "";
  public String icon = "";
  public int icon_height = 0;
  public int icon_width = 0;
  public boolean show_link_color = false;
  
  public cell_refer() {}
  
  public cell_refer(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.appname = paramString1;
    this.actionurl = paramString2;
    this.downloadurl = paramString3;
    this.appid = paramString4;
    this.actiontype = paramInt1;
    this.icon = paramString5;
    this.icon_width = paramInt2;
    this.icon_height = paramInt3;
    this.show_link_color = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appname = paramJceInputStream.readString(0, true);
    this.actionurl = paramJceInputStream.readString(1, true);
    this.downloadurl = paramJceInputStream.readString(2, false);
    this.appid = paramJceInputStream.readString(3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.icon = paramJceInputStream.readString(5, false);
    this.icon_width = paramJceInputStream.read(this.icon_width, 6, false);
    this.icon_height = paramJceInputStream.read(this.icon_height, 7, false);
    this.show_link_color = paramJceInputStream.read(this.show_link_color, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appname, 0);
    paramJceOutputStream.write(this.actionurl, 1);
    String str = this.downloadurl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.appid;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.actiontype, 4);
    str = this.icon;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.icon_width, 6);
    paramJceOutputStream.write(this.icon_height, 7);
    paramJceOutputStream.write(this.show_link_color, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_refer
 * JD-Core Version:    0.7.0.1
 */