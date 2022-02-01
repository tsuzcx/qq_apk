package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_separator
  extends JceStruct
{
  public int action_type;
  public String action_url = "";
  public int pic_height;
  public String pic_url = "";
  public int pic_width;
  
  public cell_separator() {}
  
  public cell_separator(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.pic_url = paramString1;
    this.action_url = paramString2;
    this.action_type = paramInt1;
    this.pic_width = paramInt2;
    this.pic_height = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pic_url = paramJceInputStream.readString(0, false);
    this.action_url = paramJceInputStream.readString(1, false);
    this.action_type = paramJceInputStream.read(this.action_type, 2, false);
    this.pic_width = paramJceInputStream.read(this.pic_width, 3, false);
    this.pic_height = paramJceInputStream.read(this.pic_height, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.pic_url;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.action_url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.action_type, 2);
    paramJceOutputStream.write(this.pic_width, 3);
    paramJceOutputStream.write(this.pic_height, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_separator
 * JD-Core Version:    0.7.0.1
 */