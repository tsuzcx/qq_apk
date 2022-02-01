package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MobileContactsDetailInfo
  extends JceStruct
{
  public String QQ = "";
  public int accountAbi = 0;
  public long bindingDate = 0L;
  public long isRecommend = 0L;
  public String mobileCode = "";
  public String mobileNo = "";
  public String name = "";
  public String nationCode = "";
  public String nickname = "";
  public long originBinder = 0L;
  public String originMobileNo = "";
  public short rmdScore = 0;
  
  public MobileContactsDetailInfo() {}
  
  public MobileContactsDetailInfo(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong3, int paramInt, short paramShort)
  {
    this.QQ = paramString1;
    this.mobileNo = paramString2;
    this.name = paramString3;
    this.bindingDate = paramLong1;
    this.isRecommend = paramLong2;
    this.nationCode = paramString4;
    this.mobileCode = paramString5;
    this.nickname = paramString6;
    this.originMobileNo = paramString7;
    this.originBinder = paramLong3;
    this.accountAbi = paramInt;
    this.rmdScore = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.QQ = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
    this.name = paramJceInputStream.readString(2, true);
    this.bindingDate = paramJceInputStream.read(this.bindingDate, 3, false);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 4, false);
    this.nationCode = paramJceInputStream.readString(5, false);
    this.mobileCode = paramJceInputStream.readString(6, false);
    this.nickname = paramJceInputStream.readString(7, false);
    this.originMobileNo = paramJceInputStream.readString(8, false);
    this.originBinder = paramJceInputStream.read(this.originBinder, 9, false);
    this.accountAbi = paramJceInputStream.read(this.accountAbi, 10, false);
    this.rmdScore = paramJceInputStream.read(this.rmdScore, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.QQ, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
    paramJceOutputStream.write(this.name, 2);
    paramJceOutputStream.write(this.bindingDate, 3);
    paramJceOutputStream.write(this.isRecommend, 4);
    String str = this.nationCode;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.mobileCode;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.nickname;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.originMobileNo;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.originBinder, 9);
    paramJceOutputStream.write(this.accountAbi, 10);
    paramJceOutputStream.write(this.rmdScore, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.MobileContactsDetailInfo
 * JD-Core Version:    0.7.0.1
 */