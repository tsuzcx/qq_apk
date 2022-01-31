package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ShareCell
  extends JceStruct
{
  public String content = "";
  public String imgUrl = "";
  public String jumpUrl = "";
  public String title = "";
  
  public ShareCell() {}
  
  public ShareCell(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.title = paramString1;
    this.content = paramString2;
    this.imgUrl = paramString3;
    this.jumpUrl = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.content = paramJceInputStream.readString(1, false);
    this.imgUrl = paramJceInputStream.readString(2, false);
    this.jumpUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 1);
    }
    if (this.imgUrl != null) {
      paramJceOutputStream.write(this.imgUrl, 2);
    }
    if (this.jumpUrl != null) {
      paramJceOutputStream.write(this.jumpUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.ShareCell
 * JD-Core Version:    0.7.0.1
 */