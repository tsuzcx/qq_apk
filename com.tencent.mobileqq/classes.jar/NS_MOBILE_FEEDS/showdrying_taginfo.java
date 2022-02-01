package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class showdrying_taginfo
  extends JceStruct
{
  public int iTagType = 0;
  public String strContent = "";
  public String strIcon = "";
  public String strShowInfo = "";
  public String strUrl = "";
  
  public showdrying_taginfo() {}
  
  public showdrying_taginfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.iTagType = paramInt;
    this.strContent = paramString1;
    this.strIcon = paramString2;
    this.strShowInfo = paramString3;
    this.strUrl = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTagType = paramJceInputStream.read(this.iTagType, 0, false);
    this.strContent = paramJceInputStream.readString(1, false);
    this.strIcon = paramJceInputStream.readString(2, false);
    this.strShowInfo = paramJceInputStream.readString(3, false);
    this.strUrl = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTagType, 0);
    String str = this.strContent;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strIcon;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strShowInfo;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.strUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.showdrying_taginfo
 * JD-Core Version:    0.7.0.1
 */