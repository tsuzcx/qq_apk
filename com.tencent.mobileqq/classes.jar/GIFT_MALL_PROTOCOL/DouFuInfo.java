package GIFT_MALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DouFuInfo
  extends JceStruct
{
  public String background = "";
  public String birthday = "";
  public String blessing = "";
  public String doufu_link = "";
  public String icon = "";
  public long uin = 0L;
  
  public DouFuInfo() {}
  
  public DouFuInfo(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.birthday = paramString1;
    this.uin = paramLong;
    this.icon = paramString2;
    this.blessing = paramString3;
    this.doufu_link = paramString4;
    this.background = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.birthday = paramJceInputStream.readString(0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.icon = paramJceInputStream.readString(2, false);
    this.blessing = paramJceInputStream.readString(3, false);
    this.doufu_link = paramJceInputStream.readString(4, false);
    this.background = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.birthday;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    str = this.icon;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.blessing;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.doufu_link;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.background;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     GIFT_MALL_PROTOCOL.DouFuInfo
 * JD-Core Version:    0.7.0.1
 */