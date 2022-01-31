package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stcustomPraise
  extends JceStruct
{
  public int customPraisetype = 0;
  public int iFrameRate;
  public int iItemId;
  public String strPraiseButton = "";
  public String strPraiseComboZip = "";
  public String strPraisePic = "";
  public String strPraiseZip = "";
  public int subpraisetype;
  public long uiComboCount;
  
  public stcustomPraise() {}
  
  public stcustomPraise(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, long paramLong, int paramInt4)
  {
    this.iItemId = paramInt1;
    this.strPraisePic = paramString1;
    this.strPraiseZip = paramString2;
    this.strPraiseComboZip = paramString3;
    this.iFrameRate = paramInt2;
    this.strPraiseButton = paramString4;
    this.customPraisetype = paramInt3;
    this.uiComboCount = paramLong;
    this.subpraisetype = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.strPraisePic = paramJceInputStream.readString(1, false);
    this.strPraiseZip = paramJceInputStream.readString(2, false);
    this.strPraiseComboZip = paramJceInputStream.readString(3, false);
    this.iFrameRate = paramJceInputStream.read(this.iFrameRate, 4, false);
    this.strPraiseButton = paramJceInputStream.readString(5, false);
    this.customPraisetype = paramJceInputStream.read(this.customPraisetype, 6, false);
    this.uiComboCount = paramJceInputStream.read(this.uiComboCount, 7, false);
    this.subpraisetype = paramJceInputStream.read(this.subpraisetype, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strPraisePic != null) {
      paramJceOutputStream.write(this.strPraisePic, 1);
    }
    if (this.strPraiseZip != null) {
      paramJceOutputStream.write(this.strPraiseZip, 2);
    }
    if (this.strPraiseComboZip != null) {
      paramJceOutputStream.write(this.strPraiseComboZip, 3);
    }
    paramJceOutputStream.write(this.iFrameRate, 4);
    if (this.strPraiseButton != null) {
      paramJceOutputStream.write(this.strPraiseButton, 5);
    }
    paramJceOutputStream.write(this.customPraisetype, 6);
    paramJceOutputStream.write(this.uiComboCount, 7);
    paramJceOutputStream.write(this.subpraisetype, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.stcustomPraise
 * JD-Core Version:    0.7.0.1
 */