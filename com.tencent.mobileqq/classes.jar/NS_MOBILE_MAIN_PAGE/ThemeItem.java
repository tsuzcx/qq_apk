package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ThemeItem
  extends JceStruct
{
  static ArrayList cache_vecPreUrls;
  public String strDescription = "";
  public String strH5 = "";
  public String strMd5 = "";
  public String strPackageUrl = "";
  public String strSubThumbUrl = "";
  public String strThemeId = "";
  public String strThemeName = "";
  public String strThumbUrl = "";
  public String strVer = "";
  public long uIsFree;
  public long uIsNew;
  public long uIsVip;
  public long uSize;
  public ArrayList vecPreUrls;
  
  public ThemeItem() {}
  
  public ThemeItem(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList, String paramString5, String paramString6, String paramString7, long paramLong4, String paramString8, String paramString9)
  {
    this.strThemeId = paramString1;
    this.strThemeName = paramString2;
    this.strMd5 = paramString3;
    this.strVer = paramString4;
    this.uIsVip = paramLong1;
    this.uIsFree = paramLong2;
    this.uSize = paramLong3;
    this.vecPreUrls = paramArrayList;
    this.strPackageUrl = paramString5;
    this.strThumbUrl = paramString6;
    this.strSubThumbUrl = paramString7;
    this.uIsNew = paramLong4;
    this.strH5 = paramString8;
    this.strDescription = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strThemeId = paramJceInputStream.readString(0, false);
    this.strThemeName = paramJceInputStream.readString(1, false);
    this.strMd5 = paramJceInputStream.readString(2, false);
    this.strVer = paramJceInputStream.readString(3, false);
    this.uIsVip = paramJceInputStream.read(this.uIsVip, 4, false);
    this.uIsFree = paramJceInputStream.read(this.uIsFree, 5, false);
    this.uSize = paramJceInputStream.read(this.uSize, 6, false);
    if (cache_vecPreUrls == null)
    {
      cache_vecPreUrls = new ArrayList();
      cache_vecPreUrls.add("");
    }
    this.vecPreUrls = ((ArrayList)paramJceInputStream.read(cache_vecPreUrls, 7, false));
    this.strPackageUrl = paramJceInputStream.readString(8, false);
    this.strThumbUrl = paramJceInputStream.readString(9, false);
    this.strSubThumbUrl = paramJceInputStream.readString(10, false);
    this.uIsNew = paramJceInputStream.read(this.uIsNew, 11, false);
    this.strH5 = paramJceInputStream.readString(12, false);
    this.strDescription = paramJceInputStream.readString(13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strThemeId != null) {
      paramJceOutputStream.write(this.strThemeId, 0);
    }
    if (this.strThemeName != null) {
      paramJceOutputStream.write(this.strThemeName, 1);
    }
    if (this.strMd5 != null) {
      paramJceOutputStream.write(this.strMd5, 2);
    }
    if (this.strVer != null) {
      paramJceOutputStream.write(this.strVer, 3);
    }
    paramJceOutputStream.write(this.uIsVip, 4);
    paramJceOutputStream.write(this.uIsFree, 5);
    paramJceOutputStream.write(this.uSize, 6);
    if (this.vecPreUrls != null) {
      paramJceOutputStream.write(this.vecPreUrls, 7);
    }
    if (this.strPackageUrl != null) {
      paramJceOutputStream.write(this.strPackageUrl, 8);
    }
    if (this.strThumbUrl != null) {
      paramJceOutputStream.write(this.strThumbUrl, 9);
    }
    if (this.strSubThumbUrl != null) {
      paramJceOutputStream.write(this.strSubThumbUrl, 10);
    }
    paramJceOutputStream.write(this.uIsNew, 11);
    if (this.strH5 != null) {
      paramJceOutputStream.write(this.strH5, 12);
    }
    if (this.strDescription != null) {
      paramJceOutputStream.write(this.strDescription, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.ThemeItem
 * JD-Core Version:    0.7.0.1
 */