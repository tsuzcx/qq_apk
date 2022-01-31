package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AlbumThemeSkin
  extends JceStruct
{
  public int iColor;
  public int iItemId = -1;
  public long lTabBarSelectedFontColor;
  public long lTabBarUnselectedFontColor;
  public long lTabbarUnderLineColor;
  public long lVideoButonColor;
  public long lVideoButtonBgColor;
  public String strPicZipUrl = "";
  
  public AlbumThemeSkin() {}
  
  public AlbumThemeSkin(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.iItemId = paramInt1;
    this.iColor = paramInt2;
    this.strPicZipUrl = paramString;
    this.lTabBarSelectedFontColor = paramLong1;
    this.lTabBarUnselectedFontColor = paramLong2;
    this.lVideoButtonBgColor = paramLong3;
    this.lVideoButonColor = paramLong4;
    this.lTabbarUnderLineColor = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.iColor = paramJceInputStream.read(this.iColor, 1, false);
    this.strPicZipUrl = paramJceInputStream.readString(2, false);
    this.lTabBarSelectedFontColor = paramJceInputStream.read(this.lTabBarSelectedFontColor, 3, false);
    this.lTabBarUnselectedFontColor = paramJceInputStream.read(this.lTabBarUnselectedFontColor, 4, false);
    this.lVideoButtonBgColor = paramJceInputStream.read(this.lVideoButtonBgColor, 5, false);
    this.lVideoButonColor = paramJceInputStream.read(this.lVideoButonColor, 6, false);
    this.lTabbarUnderLineColor = paramJceInputStream.read(this.lTabbarUnderLineColor, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    paramJceOutputStream.write(this.iColor, 1);
    if (this.strPicZipUrl != null) {
      paramJceOutputStream.write(this.strPicZipUrl, 2);
    }
    paramJceOutputStream.write(this.lTabBarSelectedFontColor, 3);
    paramJceOutputStream.write(this.lTabBarUnselectedFontColor, 4);
    paramJceOutputStream.write(this.lVideoButtonBgColor, 5);
    paramJceOutputStream.write(this.lVideoButonColor, 6);
    paramJceOutputStream.write(this.lTabbarUnderLineColor, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.AlbumThemeSkin
 * JD-Core Version:    0.7.0.1
 */