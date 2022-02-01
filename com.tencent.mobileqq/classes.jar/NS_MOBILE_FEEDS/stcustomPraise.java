package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stcustomPraise
  extends JceStruct
{
  public int customPraisetype = 0;
  public int iFrameRate = 0;
  public int iItemId = 0;
  public int iPraiseActId = 0;
  public String strPraiseButton = "";
  public String strPraiseComboZip = "";
  public String strPraisePic = "";
  public String strPraiseZip = "";
  public int subpraisetype = 0;
  public long uiComboCount = 0L;
  
  public stcustomPraise() {}
  
  public stcustomPraise(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, long paramLong, int paramInt4, int paramInt5)
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
    this.iPraiseActId = paramInt5;
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
    this.iPraiseActId = paramJceInputStream.read(this.iPraiseActId, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    String str = this.strPraisePic;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strPraiseZip;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strPraiseComboZip;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.iFrameRate, 4);
    str = this.strPraiseButton;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.customPraisetype, 6);
    paramJceOutputStream.write(this.uiComboCount, 7);
    paramJceOutputStream.write(this.subpraisetype, 8);
    paramJceOutputStream.write(this.iPraiseActId, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.stcustomPraise
 * JD-Core Version:    0.7.0.1
 */