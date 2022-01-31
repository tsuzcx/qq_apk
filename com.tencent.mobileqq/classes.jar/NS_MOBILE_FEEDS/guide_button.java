package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class guide_button
  extends JceStruct
{
  public String action_url = "";
  public String button_title = "";
  public String pic_url = "";
  
  public guide_button() {}
  
  public guide_button(String paramString1, String paramString2, String paramString3)
  {
    this.button_title = paramString1;
    this.action_url = paramString2;
    this.pic_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.button_title = paramJceInputStream.readString(0, false);
    this.action_url = paramJceInputStream.readString(1, false);
    this.pic_url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.button_title != null) {
      paramJceOutputStream.write(this.button_title, 0);
    }
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 1);
    }
    if (this.pic_url != null) {
      paramJceOutputStream.write(this.pic_url, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.guide_button
 * JD-Core Version:    0.7.0.1
 */