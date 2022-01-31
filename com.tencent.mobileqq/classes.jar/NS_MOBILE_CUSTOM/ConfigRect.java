package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ConfigRect
  extends JceStruct
{
  static int cache_iContentStyle;
  static int cache_iType;
  static Map cache_mapExtInfo;
  static CustomColor cache_stTextColor;
  static CustomColor cache_stTextColorClick;
  public int iCanEdit;
  public int iContentStyle;
  public int iFontSize;
  public int iHp;
  public int iIndexId;
  public int iType;
  public int iWp;
  public int iXp;
  public int iYp;
  public Map mapExtInfo;
  public CustomColor stTextColor;
  public CustomColor stTextColorClick;
  public String strImageUrl = "";
  public String strSchema = "";
  public String strText = "";
  public String strUserText = "";
  
  public ConfigRect() {}
  
  public ConfigRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString1, String paramString2, CustomColor paramCustomColor1, CustomColor paramCustomColor2, int paramInt8, String paramString3, String paramString4, int paramInt9, Map paramMap)
  {
    this.iIndexId = paramInt1;
    this.iType = paramInt2;
    this.iXp = paramInt3;
    this.iYp = paramInt4;
    this.iWp = paramInt5;
    this.iHp = paramInt6;
    this.iCanEdit = paramInt7;
    this.strText = paramString1;
    this.strUserText = paramString2;
    this.stTextColor = paramCustomColor1;
    this.stTextColorClick = paramCustomColor2;
    this.iFontSize = paramInt8;
    this.strSchema = paramString3;
    this.strImageUrl = paramString4;
    this.iContentStyle = paramInt9;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iIndexId = paramJceInputStream.read(this.iIndexId, 0, false);
    this.iType = paramJceInputStream.read(this.iType, 1, false);
    this.iXp = paramJceInputStream.read(this.iXp, 2, false);
    this.iYp = paramJceInputStream.read(this.iYp, 3, false);
    this.iWp = paramJceInputStream.read(this.iWp, 4, false);
    this.iHp = paramJceInputStream.read(this.iHp, 5, false);
    this.iCanEdit = paramJceInputStream.read(this.iCanEdit, 6, false);
    this.strText = paramJceInputStream.readString(7, false);
    this.strUserText = paramJceInputStream.readString(8, false);
    if (cache_stTextColor == null) {
      cache_stTextColor = new CustomColor();
    }
    this.stTextColor = ((CustomColor)paramJceInputStream.read(cache_stTextColor, 9, false));
    if (cache_stTextColorClick == null) {
      cache_stTextColorClick = new CustomColor();
    }
    this.stTextColorClick = ((CustomColor)paramJceInputStream.read(cache_stTextColorClick, 10, false));
    this.iFontSize = paramJceInputStream.read(this.iFontSize, 11, false);
    this.strSchema = paramJceInputStream.readString(12, false);
    this.strImageUrl = paramJceInputStream.readString(13, false);
    this.iContentStyle = paramJceInputStream.read(this.iContentStyle, 14, false);
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 15, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iIndexId, 0);
    paramJceOutputStream.write(this.iType, 1);
    paramJceOutputStream.write(this.iXp, 2);
    paramJceOutputStream.write(this.iYp, 3);
    paramJceOutputStream.write(this.iWp, 4);
    paramJceOutputStream.write(this.iHp, 5);
    paramJceOutputStream.write(this.iCanEdit, 6);
    if (this.strText != null) {
      paramJceOutputStream.write(this.strText, 7);
    }
    if (this.strUserText != null) {
      paramJceOutputStream.write(this.strUserText, 8);
    }
    if (this.stTextColor != null) {
      paramJceOutputStream.write(this.stTextColor, 9);
    }
    if (this.stTextColorClick != null) {
      paramJceOutputStream.write(this.stTextColorClick, 10);
    }
    paramJceOutputStream.write(this.iFontSize, 11);
    if (this.strSchema != null) {
      paramJceOutputStream.write(this.strSchema, 12);
    }
    if (this.strImageUrl != null) {
      paramJceOutputStream.write(this.strImageUrl, 13);
    }
    paramJceOutputStream.write(this.iContentStyle, 14);
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.ConfigRect
 * JD-Core Version:    0.7.0.1
 */