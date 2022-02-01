package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BottomContentItem
  extends JceStruct
{
  public String content = "";
  public String url = "";
  
  public BottomContentItem() {}
  
  public BottomContentItem(String paramString1, String paramString2)
  {
    this.content = paramString1;
    this.url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.content = paramJceInputStream.readString(0, false);
    this.url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.BottomContentItem
 * JD-Core Version:    0.7.0.1
 */