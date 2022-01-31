package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FeedSkinInfo
  extends JceStruct
{
  static Map cache_mapExtInfo = new HashMap();
  public String desc = "";
  public int iExpireTime;
  public int iHasNewFlag;
  public int iPrice;
  public int iVipPrize;
  public long lTime;
  public long lUin;
  public Map mapExtInfo;
  public String sPicUrl = "";
  public String sSkinId = "";
  public int sSkinType;
  public String strBgColor = "";
  public String strDesignerInfo = "";
  public String strGradientColorBegin = "";
  public String strGradientColorEnd = "";
  public String strItemSummary = "";
  public String strMusicH5Url = "";
  public String strThumbUrl = "";
  public String strTraceInfo = "";
  public String title = "";
  public long uiSettleTime;
  public int vip_property;
  
  static
  {
    cache_mapExtInfo.put("", "");
  }
  
  public FeedSkinInfo() {}
  
  public FeedSkinInfo(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3, String paramString5, String paramString6, String paramString7, int paramInt6, String paramString8, String paramString9, Map paramMap, String paramString10, String paramString11, String paramString12)
  {
    this.sSkinId = paramString1;
    this.lUin = paramLong1;
    this.sPicUrl = paramString2;
    this.lTime = paramLong2;
    this.desc = paramString3;
    this.title = paramString4;
    this.vip_property = paramInt1;
    this.sSkinType = paramInt2;
    this.iPrice = paramInt3;
    this.iVipPrize = paramInt4;
    this.iExpireTime = paramInt5;
    this.uiSettleTime = paramLong3;
    this.strItemSummary = paramString5;
    this.strThumbUrl = paramString6;
    this.strTraceInfo = paramString7;
    this.iHasNewFlag = paramInt6;
    this.strDesignerInfo = paramString8;
    this.strMusicH5Url = paramString9;
    this.mapExtInfo = paramMap;
    this.strBgColor = paramString10;
    this.strGradientColorBegin = paramString11;
    this.strGradientColorEnd = paramString12;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sSkinId = paramJceInputStream.readString(0, false);
    this.lUin = paramJceInputStream.read(this.lUin, 1, false);
    this.sPicUrl = paramJceInputStream.readString(2, false);
    this.lTime = paramJceInputStream.read(this.lTime, 3, false);
    this.desc = paramJceInputStream.readString(4, false);
    this.title = paramJceInputStream.readString(5, false);
    this.vip_property = paramJceInputStream.read(this.vip_property, 6, false);
    this.sSkinType = paramJceInputStream.read(this.sSkinType, 7, false);
    this.iPrice = paramJceInputStream.read(this.iPrice, 8, false);
    this.iVipPrize = paramJceInputStream.read(this.iVipPrize, 9, false);
    this.iExpireTime = paramJceInputStream.read(this.iExpireTime, 10, false);
    this.uiSettleTime = paramJceInputStream.read(this.uiSettleTime, 11, false);
    this.strItemSummary = paramJceInputStream.readString(12, false);
    this.strThumbUrl = paramJceInputStream.readString(13, false);
    this.strTraceInfo = paramJceInputStream.readString(14, false);
    this.iHasNewFlag = paramJceInputStream.read(this.iHasNewFlag, 15, false);
    this.strDesignerInfo = paramJceInputStream.readString(16, false);
    this.strMusicH5Url = paramJceInputStream.readString(17, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 18, false));
    this.strBgColor = paramJceInputStream.readString(19, false);
    this.strGradientColorBegin = paramJceInputStream.readString(20, false);
    this.strGradientColorEnd = paramJceInputStream.readString(21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sSkinId != null) {
      paramJceOutputStream.write(this.sSkinId, 0);
    }
    paramJceOutputStream.write(this.lUin, 1);
    if (this.sPicUrl != null) {
      paramJceOutputStream.write(this.sPicUrl, 2);
    }
    paramJceOutputStream.write(this.lTime, 3);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 4);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 5);
    }
    paramJceOutputStream.write(this.vip_property, 6);
    paramJceOutputStream.write(this.sSkinType, 7);
    paramJceOutputStream.write(this.iPrice, 8);
    paramJceOutputStream.write(this.iVipPrize, 9);
    paramJceOutputStream.write(this.iExpireTime, 10);
    paramJceOutputStream.write(this.uiSettleTime, 11);
    if (this.strItemSummary != null) {
      paramJceOutputStream.write(this.strItemSummary, 12);
    }
    if (this.strThumbUrl != null) {
      paramJceOutputStream.write(this.strThumbUrl, 13);
    }
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 14);
    }
    paramJceOutputStream.write(this.iHasNewFlag, 15);
    if (this.strDesignerInfo != null) {
      paramJceOutputStream.write(this.strDesignerInfo, 16);
    }
    if (this.strMusicH5Url != null) {
      paramJceOutputStream.write(this.strMusicH5Url, 17);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 18);
    }
    if (this.strBgColor != null) {
      paramJceOutputStream.write(this.strBgColor, 19);
    }
    if (this.strGradientColorBegin != null) {
      paramJceOutputStream.write(this.strGradientColorBegin, 20);
    }
    if (this.strGradientColorEnd != null) {
      paramJceOutputStream.write(this.strGradientColorEnd, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.FeedSkinInfo
 * JD-Core Version:    0.7.0.1
 */