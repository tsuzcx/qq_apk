package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_link
  extends JceStruct
{
  public String data = "";
  public String post = "";
  public String url = "";
  
  public cell_link() {}
  
  public cell_link(String paramString1, String paramString2, String paramString3)
  {
    this.data = paramString1;
    this.url = paramString2;
    this.post = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data = paramJceInputStream.readString(0, false);
    this.url = paramJceInputStream.readString(1, false);
    this.post = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.data;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.post;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_link
 * JD-Core Version:    0.7.0.1
 */