package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomPraise
  extends JceStruct
{
  public int iFrameRate;
  public int iItemId = -1;
  public int iSubPraisetype;
  public int iType;
  public long lUin;
  public String strItemSummary = "";
  public String strPraiseComboZip = "";
  public String strPraiseListPic = "";
  public String strPraisePic = "";
  public String strPraisePicBefore = "";
  public String strPraiseZip = "";
  public String strPraiseZipAfter = "";
  
  public QzmallCustomPraise() {}
  
  public QzmallCustomPraise(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, long paramLong, int paramInt3, int paramInt4, String paramString6, String paramString7)
  {
    this.iItemId = paramInt1;
    this.strItemSummary = paramString1;
    this.strPraisePic = paramString2;
    this.strPraiseZip = paramString3;
    this.strPraiseComboZip = paramString4;
    this.iFrameRate = paramInt2;
    this.strPraiseListPic = paramString5;
    this.lUin = paramLong;
    this.iType = paramInt3;
    this.iSubPraisetype = paramInt4;
    this.strPraisePicBefore = paramString6;
    this.strPraiseZipAfter = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strItemSummary = paramJceInputStream.readString(1, false);
    this.strPraisePic = paramJceInputStream.readString(2, false);
    this.strPraiseZip = paramJceInputStream.readString(3, false);
    this.strPraiseComboZip = paramJceInputStream.readString(5, false);
    this.iFrameRate = paramJceInputStream.read(this.iFrameRate, 6, false);
    this.strPraiseListPic = paramJceInputStream.readString(7, false);
    this.lUin = paramJceInputStream.read(this.lUin, 8, false);
    this.iType = paramJceInputStream.read(this.iType, 9, false);
    this.iSubPraisetype = paramJceInputStream.read(this.iSubPraisetype, 10, false);
    this.strPraisePicBefore = paramJceInputStream.readString(11, false);
    this.strPraiseZipAfter = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strItemSummary != null) {
      paramJceOutputStream.write(this.strItemSummary, 1);
    }
    if (this.strPraisePic != null) {
      paramJceOutputStream.write(this.strPraisePic, 2);
    }
    if (this.strPraiseZip != null) {
      paramJceOutputStream.write(this.strPraiseZip, 3);
    }
    if (this.strPraiseComboZip != null) {
      paramJceOutputStream.write(this.strPraiseComboZip, 5);
    }
    paramJceOutputStream.write(this.iFrameRate, 6);
    if (this.strPraiseListPic != null) {
      paramJceOutputStream.write(this.strPraiseListPic, 7);
    }
    paramJceOutputStream.write(this.lUin, 8);
    paramJceOutputStream.write(this.iType, 9);
    paramJceOutputStream.write(this.iSubPraisetype, 10);
    if (this.strPraisePicBefore != null) {
      paramJceOutputStream.write(this.strPraisePicBefore, 11);
    }
    if (this.strPraiseZipAfter != null) {
      paramJceOutputStream.write(this.strPraiseZipAfter, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomPraise
 * JD-Core Version:    0.7.0.1
 */