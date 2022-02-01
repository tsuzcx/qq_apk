package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_profile_for_get
  extends JceStruct
{
  static s_address cache_addressid;
  public s_address addressid;
  public int age = -1;
  public short birthday;
  public short birthmonth;
  public int birthyear;
  public String city = "";
  public String constellation = "";
  public String country = "";
  public byte gender = -1;
  public byte isBrandQzone;
  public byte islunar;
  public long limitsMask;
  public String nickname = "";
  public String province = "";
  public String qzonedesc = "";
  public long systime = -1L;
  public byte vip;
  public int viplevel;
  public int viptype;
  
  public s_profile_for_get() {}
  
  public s_profile_for_get(String paramString1, byte paramByte1, byte paramByte2, int paramInt1, short paramShort1, short paramShort2, String paramString2, String paramString3, String paramString4, byte paramByte3, int paramInt2, int paramInt3, byte paramByte4, long paramLong1, int paramInt4, String paramString5, long paramLong2, s_address params_address, String paramString6)
  {
    this.nickname = paramString1;
    this.gender = paramByte1;
    this.islunar = paramByte2;
    this.birthyear = paramInt1;
    this.birthmonth = paramShort1;
    this.birthday = paramShort2;
    this.country = paramString2;
    this.province = paramString3;
    this.city = paramString4;
    this.vip = paramByte3;
    this.viplevel = paramInt2;
    this.viptype = paramInt3;
    this.isBrandQzone = paramByte4;
    this.limitsMask = paramLong1;
    this.age = paramInt4;
    this.constellation = paramString5;
    this.systime = paramLong2;
    this.addressid = params_address;
    this.qzonedesc = paramString6;
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
    this.vip = paramJceInputStream.read(this.vip, 9, false);
    this.viplevel = paramJceInputStream.read(this.viplevel, 10, false);
    this.viptype = paramJceInputStream.read(this.viptype, 11, false);
    this.isBrandQzone = paramJceInputStream.read(this.isBrandQzone, 12, false);
    this.limitsMask = paramJceInputStream.read(this.limitsMask, 13, false);
    this.age = paramJceInputStream.read(this.age, 14, false);
    this.constellation = paramJceInputStream.readString(15, false);
    this.systime = paramJceInputStream.read(this.systime, 16, false);
    if (cache_addressid == null) {
      cache_addressid = new s_address();
    }
    this.addressid = ((s_address)paramJceInputStream.read(cache_addressid, 17, false));
    this.qzonedesc = paramJceInputStream.readString(18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.nickname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.gender, 1);
    paramJceOutputStream.write(this.islunar, 2);
    paramJceOutputStream.write(this.birthyear, 3);
    paramJceOutputStream.write(this.birthmonth, 4);
    paramJceOutputStream.write(this.birthday, 5);
    localObject = this.country;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.province;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.city;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.vip, 9);
    paramJceOutputStream.write(this.viplevel, 10);
    paramJceOutputStream.write(this.viptype, 11);
    paramJceOutputStream.write(this.isBrandQzone, 12);
    paramJceOutputStream.write(this.limitsMask, 13);
    paramJceOutputStream.write(this.age, 14);
    localObject = this.constellation;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    paramJceOutputStream.write(this.systime, 16);
    localObject = this.addressid;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 17);
    }
    localObject = this.qzonedesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.s_profile_for_get
 * JD-Core Version:    0.7.0.1
 */