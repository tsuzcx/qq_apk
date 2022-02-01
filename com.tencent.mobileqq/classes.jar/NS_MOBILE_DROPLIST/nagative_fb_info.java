package NS_MOBILE_DROPLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class nagative_fb_info
  extends JceStruct
{
  public String attach_info = "";
  public String fb_name = "";
  public int fb_type = 0;
  public String tag_name = "";
  public int tag_type = 0;
  
  public nagative_fb_info() {}
  
  public nagative_fb_info(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    this.fb_type = paramInt1;
    this.fb_name = paramString1;
    this.tag_type = paramInt2;
    this.tag_name = paramString2;
    this.attach_info = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fb_type = paramJceInputStream.read(this.fb_type, 0, false);
    this.fb_name = paramJceInputStream.readString(1, false);
    this.tag_type = paramJceInputStream.read(this.tag_type, 2, false);
    this.tag_name = paramJceInputStream.readString(3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fb_type, 0);
    if (this.fb_name != null) {
      paramJceOutputStream.write(this.fb_name, 1);
    }
    paramJceOutputStream.write(this.tag_type, 2);
    if (this.tag_name != null) {
      paramJceOutputStream.write(this.tag_name, 3);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_DROPLIST.nagative_fb_info
 * JD-Core Version:    0.7.0.1
 */