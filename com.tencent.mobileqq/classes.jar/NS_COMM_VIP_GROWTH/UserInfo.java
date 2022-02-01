package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserInfo
  extends JceStruct
{
  static int cache_iUserType = 0;
  public int iEverSSuperVip = 0;
  public int iEverSuperVip = 0;
  public int iEverVip = 0;
  public int iEverYearVip = 0;
  public int iLevel = 0;
  public int iMaxScore = 0;
  public int iSSuperVip = 0;
  public int iScore = 0;
  public int iSpeed = 0;
  public int iSuperVip = 0;
  public int iUserType = 0;
  public int iVip = 0;
  public int iYearVip = 0;
  public String strSSuperVipRenewal = "";
  public String strSuperVipRenewal = "";
  public String strUid = "";
  public String strVipRenewal = "";
  public long uiLastCalcTime = 0L;
  public long uiSSuperVipCloseTime = 0L;
  public long uiSSuperVipOpenTime = 0L;
  public long uiSuperVipCloseTime = 0L;
  public long uiSuperVipOpenTime = 0L;
  public long uiVipCloseTime = 0L;
  public long uiVipOpenTime = 0L;
  public long uiYearVipCloseTime = 0L;
  public long uiYearVipOpenTime = 0L;
  
  public UserInfo() {}
  
  public UserInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt12, int paramInt13, long paramLong8, long paramLong9, String paramString2, String paramString3, String paramString4)
  {
    this.strUid = paramString1;
    this.iUserType = paramInt1;
    this.iVip = paramInt2;
    this.iEverVip = paramInt3;
    this.iSuperVip = paramInt4;
    this.iEverSuperVip = paramInt5;
    this.iYearVip = paramInt6;
    this.iEverYearVip = paramInt7;
    this.iScore = paramInt8;
    this.iMaxScore = paramInt9;
    this.iLevel = paramInt10;
    this.iSpeed = paramInt11;
    this.uiLastCalcTime = paramLong1;
    this.uiVipOpenTime = paramLong2;
    this.uiVipCloseTime = paramLong3;
    this.uiSuperVipOpenTime = paramLong4;
    this.uiSuperVipCloseTime = paramLong5;
    this.uiYearVipOpenTime = paramLong6;
    this.uiYearVipCloseTime = paramLong7;
    this.iSSuperVip = paramInt12;
    this.iEverSSuperVip = paramInt13;
    this.uiSSuperVipOpenTime = paramLong8;
    this.uiSSuperVipCloseTime = paramLong9;
    this.strVipRenewal = paramString2;
    this.strSuperVipRenewal = paramString3;
    this.strSSuperVipRenewal = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strUid = paramJceInputStream.readString(0, false);
    this.iUserType = paramJceInputStream.read(this.iUserType, 1, false);
    this.iVip = paramJceInputStream.read(this.iVip, 2, false);
    this.iEverVip = paramJceInputStream.read(this.iEverVip, 3, false);
    this.iSuperVip = paramJceInputStream.read(this.iSuperVip, 4, false);
    this.iEverSuperVip = paramJceInputStream.read(this.iEverSuperVip, 5, false);
    this.iYearVip = paramJceInputStream.read(this.iYearVip, 6, false);
    this.iEverYearVip = paramJceInputStream.read(this.iEverYearVip, 7, false);
    this.iScore = paramJceInputStream.read(this.iScore, 8, false);
    this.iMaxScore = paramJceInputStream.read(this.iMaxScore, 9, false);
    this.iLevel = paramJceInputStream.read(this.iLevel, 10, false);
    this.iSpeed = paramJceInputStream.read(this.iSpeed, 11, false);
    this.uiLastCalcTime = paramJceInputStream.read(this.uiLastCalcTime, 12, false);
    this.uiVipOpenTime = paramJceInputStream.read(this.uiVipOpenTime, 13, false);
    this.uiVipCloseTime = paramJceInputStream.read(this.uiVipCloseTime, 14, false);
    this.uiSuperVipOpenTime = paramJceInputStream.read(this.uiSuperVipOpenTime, 15, false);
    this.uiSuperVipCloseTime = paramJceInputStream.read(this.uiSuperVipCloseTime, 16, false);
    this.uiYearVipOpenTime = paramJceInputStream.read(this.uiYearVipOpenTime, 17, false);
    this.uiYearVipCloseTime = paramJceInputStream.read(this.uiYearVipCloseTime, 18, false);
    this.iSSuperVip = paramJceInputStream.read(this.iSSuperVip, 19, false);
    this.iEverSSuperVip = paramJceInputStream.read(this.iEverSSuperVip, 20, false);
    this.uiSSuperVipOpenTime = paramJceInputStream.read(this.uiSSuperVipOpenTime, 21, false);
    this.uiSSuperVipCloseTime = paramJceInputStream.read(this.uiSSuperVipCloseTime, 22, false);
    this.strVipRenewal = paramJceInputStream.readString(23, false);
    this.strSuperVipRenewal = paramJceInputStream.readString(24, false);
    this.strSSuperVipRenewal = paramJceInputStream.readString(25, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strUid != null) {
      paramJceOutputStream.write(this.strUid, 0);
    }
    paramJceOutputStream.write(this.iUserType, 1);
    paramJceOutputStream.write(this.iVip, 2);
    paramJceOutputStream.write(this.iEverVip, 3);
    paramJceOutputStream.write(this.iSuperVip, 4);
    paramJceOutputStream.write(this.iEverSuperVip, 5);
    paramJceOutputStream.write(this.iYearVip, 6);
    paramJceOutputStream.write(this.iEverYearVip, 7);
    paramJceOutputStream.write(this.iScore, 8);
    paramJceOutputStream.write(this.iMaxScore, 9);
    paramJceOutputStream.write(this.iLevel, 10);
    paramJceOutputStream.write(this.iSpeed, 11);
    paramJceOutputStream.write(this.uiLastCalcTime, 12);
    paramJceOutputStream.write(this.uiVipOpenTime, 13);
    paramJceOutputStream.write(this.uiVipCloseTime, 14);
    paramJceOutputStream.write(this.uiSuperVipOpenTime, 15);
    paramJceOutputStream.write(this.uiSuperVipCloseTime, 16);
    paramJceOutputStream.write(this.uiYearVipOpenTime, 17);
    paramJceOutputStream.write(this.uiYearVipCloseTime, 18);
    paramJceOutputStream.write(this.iSSuperVip, 19);
    paramJceOutputStream.write(this.iEverSSuperVip, 20);
    paramJceOutputStream.write(this.uiSSuperVipOpenTime, 21);
    paramJceOutputStream.write(this.uiSSuperVipCloseTime, 22);
    if (this.strVipRenewal != null) {
      paramJceOutputStream.write(this.strVipRenewal, 23);
    }
    if (this.strSuperVipRenewal != null) {
      paramJceOutputStream.write(this.strSuperVipRenewal, 24);
    }
    if (this.strSSuperVipRenewal != null) {
      paramJceOutputStream.write(this.strSSuperVipRenewal, 25);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_COMM_VIP_GROWTH.UserInfo
 * JD-Core Version:    0.7.0.1
 */