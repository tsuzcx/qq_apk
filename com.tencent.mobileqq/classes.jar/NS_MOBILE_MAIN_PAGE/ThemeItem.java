package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class ThemeItem
  extends JceStruct
{
  static ArrayList<String> cache_vecPreUrls;
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
  public ArrayList<String> vecPreUrls;
  
  public ThemeItem() {}
  
  public ThemeItem(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, String paramString5, String paramString6, String paramString7, long paramLong4, String paramString8, String paramString9)
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
    Object localObject = this.strThemeId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.strThemeName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.strMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.strVer;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.uIsVip, 4);
    paramJceOutputStream.write(this.uIsFree, 5);
    paramJceOutputStream.write(this.uSize, 6);
    localObject = this.vecPreUrls;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.strPackageUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.strThumbUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.strSubThumbUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.uIsNew, 11);
    localObject = this.strH5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.strDescription;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.ThemeItem
 * JD-Core Version:    0.7.0.1
 */