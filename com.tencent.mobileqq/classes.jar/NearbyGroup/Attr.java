package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Attr
  extends JceStruct
{
  public String strImei = "";
  public String strImsi = "";
  public String strPhonenum = "";
  
  public Attr() {}
  
  public Attr(String paramString1, String paramString2, String paramString3)
  {
    this.strImei = paramString1;
    this.strImsi = paramString2;
    this.strPhonenum = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strImei = paramJceInputStream.readString(0, false);
    this.strImsi = paramJceInputStream.readString(1, false);
    this.strPhonenum = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strImei;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strImsi;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strPhonenum;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NearbyGroup.Attr
 * JD-Core Version:    0.7.0.1
 */