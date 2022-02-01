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
    if (this.strContent1 != null) {
      paramJceOutputStream.write(this.strContent1, 1);
    }
    if (this.strIcon != null) {
      paramJceOutputStream.write(this.strIcon, 2);
    }
    if (this.strShowInfo != null) {
      paramJceOutputStream.write(this.strShowInfo, 3);
    }
    if (this.strUrl != null) {
      paramJceOutputStream.write(this.strUrl, 4);
    }
    if (this.strContent2 != null) {
      paramJceOutputStream.write(this.strContent2, 5);
    }
    if (this.strContent3 != null) {
      paramJceOutputStream.write(this.strContent3, 6);
    }
    paramJceOutputStream.write(this.iTagSource, 7);
    if (this.strTagId != null) {
      paramJceOutputStream.write(this.strTagId, 8);
    }
    paramJceOutputStream.write(this.iCode, 9);
    if (this.strShowContent != null) {
      paramJceOutputStream.write(this.strShowContent, 10);
    }
    if (this.strThumbContent != null) {
      paramJceOutputStream.write(this.strThumbContent, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_FASHION_FEEDS_TAG_PROTO.TagInfo
 * JD-Core Version:    0.7.0.1
 */