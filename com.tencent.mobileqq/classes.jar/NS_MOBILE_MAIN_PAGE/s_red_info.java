package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_red_info
  extends JceStruct
{
  public String desc = "";
  public String logo = "";
  public String summary = "";
  public long uIsNew;
  public long uin;
  
  public s_red_info() {}
  
  public s_red_info(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    this.logo = paramString1;
    this.summary = paramString2;
    this.desc = paramString3;
    this.uIsNew = paramLong1;
    this.uin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.logo = paramJceInputStream.readString(0, false);
    this.summary = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.uIsNew = paramJceInputStream.read(this.uIsNew, 3, false);
    this.uin = paramJceInputStream.read(this.uin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.logo;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.summary;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.uIsNew, 3);
    paramJceOutputStream.write(this.uin, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_red_info
 * JD-Core Version:    0.7.0.1
 */