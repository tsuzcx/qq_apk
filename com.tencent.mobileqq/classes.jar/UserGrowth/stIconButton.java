package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stIconButton
  extends JceStruct
{
  public String buttonBgColor = "";
  public String buttonIcon = "";
  public String buttonText = "";
  public String buttonTextColor = "";
  
  public stIconButton() {}
  
  public stIconButton(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.buttonText = paramString1;
    this.buttonIcon = paramString2;
    this.buttonBgColor = paramString3;
    this.buttonTextColor = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.buttonText = paramJceInputStream.readString(0, false);
    this.buttonIcon = paramJceInputStream.readString(1, false);
    this.buttonBgColor = paramJceInputStream.readString(2, false);
    this.buttonTextColor = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.buttonText != null) {
      paramJceOutputStream.write(this.buttonText, 0);
    }
    if (this.buttonIcon != null) {
      paramJceOutputStream.write(this.buttonIcon, 1);
    }
    if (this.buttonBgColor != null) {
      paramJceOutputStream.write(this.buttonBgColor, 2);
    }
    if (this.buttonTextColor != null) {
      paramJceOutputStream.write(this.buttonTextColor, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stIconButton
 * JD-Core Version:    0.7.0.1
 */