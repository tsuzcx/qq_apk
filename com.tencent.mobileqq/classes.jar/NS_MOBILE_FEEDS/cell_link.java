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
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 0);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
    if (this.post != null) {
      paramJceOutputStream.write(this.post, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_link
 * JD-Core Version:    0.7.0.1
 */