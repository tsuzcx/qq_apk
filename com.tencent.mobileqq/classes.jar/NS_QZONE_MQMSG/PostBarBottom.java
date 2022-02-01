package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PostBarBottom
  extends JceStruct
{
  public String content = "";
  public String jumpUrl = "";
  
  public PostBarBottom() {}
  
  public PostBarBottom(String paramString1, String paramString2)
  {
    this.content = paramString1;
    this.jumpUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.content = paramJceInputStream.readString(0, false);
    this.jumpUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.jumpUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.PostBarBottom
 * JD-Core Version:    0.7.0.1
 */