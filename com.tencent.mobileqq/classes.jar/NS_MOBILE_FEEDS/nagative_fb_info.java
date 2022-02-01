package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class nagative_fb_info
  extends JceStruct
{
  public String attach_info = "";
  public String fb_name = "";
  public String fb_tag_txt = "";
  public int fb_type = 0;
  public int id = -1;
  public String tag_name = "";
  public int tag_type = 0;
  
  public nagative_fb_info() {}
  
  public nagative_fb_info(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    this.fb_type = paramInt1;
    this.fb_name = paramString1;
    this.tag_type = paramInt2;
    this.tag_name = paramString2;
    this.attach_info = paramString3;
    this.fb_tag_txt = paramString4;
    this.id = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fb_type = paramJceInputStream.read(this.fb_type, 0, false);
    this.fb_name = paramJceInputStream.readString(1, false);
    this.tag_type = paramJceInputStream.read(this.tag_type, 2, false);
    this.tag_name = paramJceInputStream.readString(3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
    this.fb_tag_txt = paramJceInputStream.readString(5, false);
    this.id = paramJceInputStream.read(this.id, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fb_type, 0);
    String str = this.fb_name;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.tag_type, 2);
    str = this.tag_name;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.attach_info;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.fb_tag_txt;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    int i = this.id;
    if (-1 != i) {
      paramJceOutputStream.write(i, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.nagative_fb_info
 * JD-Core Version:    0.7.0.1
 */