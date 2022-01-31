package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AvatarItemView
  extends JceStruct
{
  static CustomFileInfo cache_stFileInfo;
  public int iPlayInterval = -1;
  public CustomFileInfo stFileInfo;
  public String strStaticUrl = "";
  
  public AvatarItemView() {}
  
  public AvatarItemView(CustomFileInfo paramCustomFileInfo, String paramString, int paramInt)
  {
    this.stFileInfo = paramCustomFileInfo;
    this.strStaticUrl = paramString;
    this.iPlayInterval = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stFileInfo == null) {
      cache_stFileInfo = new CustomFileInfo();
    }
    this.stFileInfo = ((CustomFileInfo)paramJceInputStream.read(cache_stFileInfo, 0, false));
    this.strStaticUrl = paramJceInputStream.readString(1, false);
    this.iPlayInterval = paramJceInputStream.read(this.iPlayInterval, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFileInfo != null) {
      paramJceOutputStream.write(this.stFileInfo, 0);
    }
    if (this.strStaticUrl != null) {
      paramJceOutputStream.write(this.strStaticUrl, 1);
    }
    paramJceOutputStream.write(this.iPlayInterval, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.AvatarItemView
 * JD-Core Version:    0.7.0.1
 */