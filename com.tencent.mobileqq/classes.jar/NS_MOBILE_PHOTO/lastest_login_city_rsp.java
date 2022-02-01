package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class lastest_login_city_rsp
  extends JceStruct
{
  public String city_name = "";
  
  public lastest_login_city_rsp() {}
  
  public lastest_login_city_rsp(String paramString)
  {
    this.city_name = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.city_name = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.city_name;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.lastest_login_city_rsp
 * JD-Core Version:    0.7.0.1
 */