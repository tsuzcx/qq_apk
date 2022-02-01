package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetNearbyGroup
  extends JceStruct
{
  static LBSInfo cache_stLBSInfo;
  static byte[] cache_vClientVersion;
  static byte[] cache_vContext = (byte[])new byte[1];
  public boolean bShowActivity = false;
  public boolean bShowOpen = false;
  public boolean bShowXiaoQu = false;
  public int iCount = 0;
  public int iFilterId = 0;
  public int iKeyType = 0;
  public short shSortType = 0;
  public short shVersion = 0;
  public LBSInfo stLBSInfo = null;
  public String strCity = "";
  public String strCityCode = "";
  public String strGroupArea = "";
  public String strKey = "";
  public long uiClientType = 0L;
  public long uiLabelStyle = 0L;
  public byte[] vClientVersion = null;
  public byte[] vContext = null;
  
  static
  {
    ((byte[])cache_vContext)[0] = 0;
    cache_stLBSInfo = new LBSInfo();
    cache_vClientVersion = (byte[])new byte[1];
    ((byte[])cache_vClientVersion)[0] = 0;
  }
  
  public ReqGetNearbyGroup() {}
  
  public ReqGetNearbyGroup(short paramShort1, byte[] paramArrayOfByte1, int paramInt1, LBSInfo paramLBSInfo, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, short paramShort2, String paramString2, String paramString3, String paramString4, int paramInt3, long paramLong1, byte[] paramArrayOfByte2, long paramLong2)
  {
    this.shVersion = paramShort1;
    this.vContext = paramArrayOfByte1;
    this.iCount = paramInt1;
    this.stLBSInfo = paramLBSInfo;
    this.iKeyType = paramInt2;
    this.strKey = paramString1;
    this.bShowOpen = paramBoolean1;
    this.bShowXiaoQu = paramBoolean2;
    this.bShowActivity = paramBoolean3;
    this.shSortType = paramShort2;
    this.strGroupArea = paramString2;
    this.strCity = paramString3;
    this.strCityCode = paramString4;
    this.iFilterId = paramInt3;
    this.uiLabelStyle = paramLong1;
    this.vClientVersion = paramArrayOfByte2;
    this.uiClientType = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.vContext = ((byte[])paramJceInputStream.read(cache_vContext, 1, false));
    this.iCount = paramJceInputStream.read(this.iCount, 2, true);
    this.stLBSInfo = ((LBSInfo)paramJceInputStream.read(cache_stLBSInfo, 3, true));
    this.iKeyType = paramJceInputStream.read(this.iKeyType, 4, false);
    this.strKey = paramJceInputStream.readString(5, false);
    this.bShowOpen = paramJceInputStream.read(this.bShowOpen, 6, false);
    this.bShowXiaoQu = paramJceInputStream.read(this.bShowXiaoQu, 7, false);
    this.bShowActivity = paramJceInputStream.read(this.bShowActivity, 8, false);
    this.shSortType = paramJceInputStream.read(this.shSortType, 9, false);
    this.strGroupArea = paramJceInputStream.readString(10, false);
    this.strCity = paramJceInputStream.readString(11, false);
    this.strCityCode = paramJceInputStream.readString(12, false);
    this.iFilterId = paramJceInputStream.read(this.iFilterId, 13, false);
    this.uiLabelStyle = paramJceInputStream.read(this.uiLabelStyle, 14, false);
    this.vClientVersion = ((byte[])paramJceInputStream.read(cache_vClientVersion, 15, false));
    this.uiClientType = paramJceInputStream.read(this.uiClientType, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    if (this.vContext != null) {
      paramJceOutputStream.write(this.vContext, 1);
    }
    paramJceOutputStream.write(this.iCount, 2);
    paramJceOutputStream.write(this.stLBSInfo, 3);
    paramJceOutputStream.write(this.iKeyType, 4);
    if (this.strKey != null) {
      paramJceOutputStream.write(this.strKey, 5);
    }
    paramJceOutputStream.write(this.bShowOpen, 6);
    paramJceOutputStream.write(this.bShowXiaoQu, 7);
    paramJceOutputStream.write(this.bShowActivity, 8);
    paramJceOutputStream.write(this.shSortType, 9);
    if (this.strGroupArea != null) {
      paramJceOutputStream.write(this.strGroupArea, 10);
    }
    if (this.strCity != null) {
      paramJceOutputStream.write(this.strCity, 11);
    }
    if (this.strCityCode != null) {
      paramJceOutputStream.write(this.strCityCode, 12);
    }
    paramJceOutputStream.write(this.iFilterId, 13);
    paramJceOutputStream.write(this.uiLabelStyle, 14);
    if (this.vClientVersion != null) {
      paramJceOutputStream.write(this.vClientVersion, 15);
    }
    paramJceOutputStream.write(this.uiClientType, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NearbyGroup.ReqGetNearbyGroup
 * JD-Core Version:    0.7.0.1
 */