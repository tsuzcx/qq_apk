package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cardDiyTextInfo
  extends JceStruct
{
  public float fRotationAngle = 0.0F;
  public float fScaling = 0.0F;
  public float fTransparency = 0.0F;
  public int iFontId = 0;
  public String strPoint = "";
  public String strText = "";
  
  public cardDiyTextInfo() {}
  
  public cardDiyTextInfo(int paramInt, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.iFontId = paramInt;
    this.strText = paramString1;
    this.strPoint = paramString2;
    this.fRotationAngle = paramFloat1;
    this.fScaling = paramFloat2;
    this.fTransparency = paramFloat3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFontId = paramJceInputStream.read(this.iFontId, 1, false);
    this.strText = paramJceInputStream.readString(2, false);
    this.strPoint = paramJceInputStream.readString(3, false);
    this.fRotationAngle = paramJceInputStream.read(this.fRotationAngle, 4, false);
    this.fScaling = paramJceInputStream.read(this.fScaling, 5, false);
    this.fTransparency = paramJceInputStream.read(this.fTransparency, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFontId, 1);
    String str = this.strText;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strPoint;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.fRotationAngle, 4);
    paramJceOutputStream.write(this.fScaling, 5);
    paramJceOutputStream.write(this.fTransparency, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCardTaf.cardDiyTextInfo
 * JD-Core Version:    0.7.0.1
 */