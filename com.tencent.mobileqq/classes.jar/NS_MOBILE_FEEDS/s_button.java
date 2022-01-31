package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_button
  extends JceStruct
{
  public int actiontype;
  public String actionurl = "";
  public String button_background_img = "";
  public String button_icon = "";
  public String button_img = "";
  public String text = "";
  
  public s_button() {}
  
  public s_button(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.text = paramString1;
    this.actiontype = paramInt;
    this.actionurl = paramString2;
    this.button_img = paramString3;
    this.button_background_img = paramString4;
    this.button_icon = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.text = paramJceInputStream.readString(0, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 1, false);
    this.actionurl = paramJceInputStream.readString(2, false);
    this.button_img = paramJceInputStream.readString(3, false);
    this.button_background_img = paramJceInputStream.readString(4, false);
    this.button_icon = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 0);
    }
    paramJceOutputStream.write(this.actiontype, 1);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 2);
    }
    if (this.button_img != null) {
      paramJceOutputStream.write(this.button_img, 3);
    }
    if (this.button_background_img != null) {
      paramJceOutputStream.write(this.button_background_img, 4);
    }
    if (this.button_icon != null) {
      paramJceOutputStream.write(this.button_icon, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_button
 * JD-Core Version:    0.7.0.1
 */