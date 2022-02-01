package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_address
  extends JceStruct
{
  public String cityid = "";
  public String countryid = "";
  public String provinceid = "";
  
  public s_address() {}
  
  public s_address(String paramString1, String paramString2, String paramString3)
  {
    this.countryid = paramString1;
    this.provinceid = paramString2;
    this.cityid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.countryid = paramJceInputStream.readString(0, false);
    this.provinceid = paramJceInputStream.readString(1, false);
    this.cityid = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.countryid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.provinceid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.cityid;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.s_address
 * JD-Core Version:    0.7.0.1
 */