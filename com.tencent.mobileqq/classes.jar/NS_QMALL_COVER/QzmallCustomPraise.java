package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomPraise
  extends JceStruct
{
  public int iFrameRate = 0;
  public int iItemId = -1;
  public int iSubPraisetype = 0;
  public int iType = 0;
  public long lUin = 0L;
  public String strCmShowActionId = "";
  public String strItemSummary = "";
  public String strPraiseComboZip = "";
  public String strPraiseListPic = "";
  public String strPraisePic = "";
  public String strPraisePicBefore = "";
  public String strPraiseZip = "";
  public String strPraiseZipAfter = "";
  
  public QzmallCustomPraise() {}
  
  public QzmallCustomPraise(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, long paramLong, int paramInt3, int paramInt4, String paramString6, String paramString7, String paramString8)
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
    this.strCmShowActionId = paramString8;
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
    this.strCmShowActionId = paramJceInputStream.readString(13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    String str = this.strItemSummary;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strPraisePic;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strPraiseZip;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.strPraiseComboZip;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.iFrameRate, 6);
    str = this.strPraiseListPic;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    paramJceOutputStream.write(this.lUin, 8);
    paramJceOutputStream.write(this.iType, 9);
    paramJceOutputStream.write(this.iSubPraisetype, 10);
    str = this.strPraisePicBefore;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.strPraiseZipAfter;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.strCmShowActionId;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomPraise
 * JD-Core Version:    0.7.0.1
 */