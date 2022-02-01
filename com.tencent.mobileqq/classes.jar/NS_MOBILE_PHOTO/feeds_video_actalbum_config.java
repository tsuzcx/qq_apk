package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class feeds_video_actalbum_config
  extends JceStruct
{
  public String banner_btn_title = "";
  public String banner_main_title = "";
  public String banner_sub_title = "";
  public String banner_title = "";
  public String fscreen_btn_title = "";
  public String fscreen_jump_h5 = "";
  public String fscreen_sub_title = "";
  public String fscreen_title = "";
  
  public feeds_video_actalbum_config() {}
  
  public feeds_video_actalbum_config(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.banner_title = paramString1;
    this.banner_main_title = paramString2;
    this.banner_sub_title = paramString3;
    this.banner_btn_title = paramString4;
    this.fscreen_title = paramString5;
    this.fscreen_sub_title = paramString6;
    this.fscreen_jump_h5 = paramString7;
    this.fscreen_btn_title = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.banner_title = paramJceInputStream.readString(0, false);
    this.banner_main_title = paramJceInputStream.readString(1, false);
    this.banner_sub_title = paramJceInputStream.readString(2, false);
    this.banner_btn_title = paramJceInputStream.readString(3, false);
    this.fscreen_title = paramJceInputStream.readString(4, false);
    this.fscreen_sub_title = paramJceInputStream.readString(5, false);
    this.fscreen_jump_h5 = paramJceInputStream.readString(6, false);
    this.fscreen_btn_title = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.banner_title;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.banner_main_title;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.banner_sub_title;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.banner_btn_title;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.fscreen_title;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.fscreen_sub_title;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.fscreen_jump_h5;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.fscreen_btn_title;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.feeds_video_actalbum_config
 * JD-Core Version:    0.7.0.1
 */