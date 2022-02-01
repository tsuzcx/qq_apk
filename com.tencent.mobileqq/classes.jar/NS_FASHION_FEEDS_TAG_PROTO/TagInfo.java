package NS_FASHION_FEEDS_TAG_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TagInfo
  extends JceStruct
{
  public int iCode = 0;
  public int iTagSource = 0;
  public int iTagType = 0;
  public String strContent1 = "";
  public String strContent2 = "";
  public String strContent3 = "";
  public String strIcon = "";
  public String strShowContent = "";
  public String strShowInfo = "";
  public String strTagId = "";
  public String strThumbContent = "";
  public String strUrl = "";
  
  public TagInfo() {}
  
  public TagInfo(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, int paramInt3, String paramString8, String paramString9)
  {
    this.iTagType = paramInt1;
    this.strContent1 = paramString1;
    this.strIcon = paramString2;
    this.strShowInfo = paramString3;
    this.strUrl = paramString4;
    this.strContent2 = paramString5;
    this.strContent3 = paramString6;
    this.iTagSource = paramInt2;
    this.strTagId = paramString7;
    this.iCode = paramInt3;
    this.strShowContent = paramString8;
    this.strThumbContent = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTagType = paramJceInputStream.read(this.iTagType, 0, false);
    this.strContent1 = paramJceInputStream.readString(1, false);
    this.strIcon = paramJceInputStream.readString(2, false);
    this.strShowInfo = paramJceInputStream.readString(3, false);
    this.strUrl = paramJceInputStream.readString(4, false);
    this.strContent2 = paramJceInputStream.readString(5, false);
    this.strContent3 = paramJceInputStream.readString(6, false);
    this.iTagSource = paramJceInputStream.read(this.iTagSource, 7, false);
    this.strTagId = paramJceInputStream.readString(8, false);
    this.iCode = paramJceInputStream.read(this.iCode, 9, false);
    this.strShowContent = paramJceInputStream.readString(10, false);
    this.strThumbContent = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTagType, 0);
    String str = this.strContent1;
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
    str = this.strContent2;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.strContent3;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    paramJceOutputStream.write(this.iTagSource, 7);
    str = this.strTagId;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.iCode, 9);
    str = this.strShowContent;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.strThumbContent;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FASHION_FEEDS_TAG_PROTO.TagInfo
 * JD-Core Version:    0.7.0.1
 */