package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Font
  extends JceStruct
{
  public int forbidThemeFont;
  public int isBlackWhiteFont;
  public int isWithTheme;
  
  public Font() {}
  
  public Font(int paramInt1, int paramInt2, int paramInt3)
  {
    this.isWithTheme = paramInt1;
    this.isBlackWhiteFont = paramInt2;
    this.forbidThemeFont = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isWithTheme = paramJceInputStream.read(this.isWithTheme, 0, false);
    this.isBlackWhiteFont = paramJceInputStream.read(this.isBlackWhiteFont, 1, false);
    this.forbidThemeFont = paramJceInputStream.read(this.forbidThemeFont, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isWithTheme, 0);
    paramJceOutputStream.write(this.isBlackWhiteFont, 1);
    paramJceOutputStream.write(this.forbidThemeFont, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.Font
 * JD-Core Version:    0.7.0.1
 */