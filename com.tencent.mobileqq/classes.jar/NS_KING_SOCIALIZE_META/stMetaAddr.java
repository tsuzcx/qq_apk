package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaAddr
  extends JceStruct
{
  public String city = "";
  public String country = "";
  public String province = "";
  
  public stMetaAddr() {}
  
  public stMetaAddr(String paramString1, String paramString2, String paramString3)
  {
    this.country = paramString1;
    this.province = paramString2;
    this.city = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.country = paramJceInputStream.readString(0, false);
    this.province = paramJceInputStream.readString(1, false);
    this.city = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.country;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.province;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.city;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaAddr
 * JD-Core Version:    0.7.0.1
 */