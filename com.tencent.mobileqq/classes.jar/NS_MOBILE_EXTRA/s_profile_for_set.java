package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_profile_for_set
  extends JceStruct
{
  public short birthday;
  public short birthmonth;
  public int birthyear;
  public String city = "";
  public String country = "";
  public byte gender = -1;
  public byte islunar;
  public String nickname = "";
  public String province = "";
  public String qzonedesc = "";
  
  public s_profile_for_set() {}
  
  public s_profile_for_set(String paramString1, byte paramByte1, byte paramByte2, int paramInt, short paramShort1, short paramShort2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.nickname = paramString1;
    this.gender = paramByte1;
    this.islunar = paramByte2;
    this.birthyear = paramInt;
    this.birthmonth = paramShort1;
    this.birthday = paramShort2;
    this.country = paramString2;
    this.province = paramString3;
    this.city = paramString4;
    this.qzonedesc = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, false);
    this.gender = paramJceInputStream.read(this.gender, 1, false);
    this.islunar = paramJceInputStream.read(this.islunar, 2, false);
    this.birthyear = paramJceInputStream.read(this.birthyear, 3, false);
    this.birthmonth = paramJceInputStream.read(this.birthmonth, 4, false);
    this.birthday = paramJceInputStream.read(this.birthday, 5, false);
    this.country = paramJceInputStream.readString(6, false);
    this.province = paramJceInputStream.readString(7, false);
    this.city = paramJceInputStream.readString(8, false);
    this.qzonedesc = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.nickname;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.gender, 1);
    paramJceOutputStream.write(this.islunar, 2);
    paramJceOutputStream.write(this.birthyear, 3);
    paramJceOutputStream.write(this.birthmonth, 4);
    paramJceOutputStream.write(this.birthday, 5);
    str = this.country;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.province;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.city;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.qzonedesc;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.s_profile_for_set
 * JD-Core Version:    0.7.0.1
 */