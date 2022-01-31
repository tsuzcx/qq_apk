package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPopWindowsButton
  extends JceStruct
{
  public String iconUrl = "";
  public String jumpurl = "";
  public String title = "";
  
  public stPopWindowsButton() {}
  
  public stPopWindowsButton(String paramString1, String paramString2, String paramString3)
  {
    this.title = paramString1;
    this.jumpurl = paramString2;
    this.iconUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.jumpurl = paramJceInputStream.readString(1, false);
    this.iconUrl = paramJceInputStream.readString(2, false);
  }
  
  public String toString()
  {
    return "stPopWindowsButton{\n   title=" + this.title + "\n   jumpurl=" + this.jumpurl + "\n   iconUrl='" + this.iconUrl + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.jumpurl != null) {
      paramJceOutputStream.write(this.jumpurl, 1);
    }
    if (this.iconUrl != null) {
      paramJceOutputStream.write(this.iconUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stPopWindowsButton
 * JD-Core Version:    0.7.0.1
 */