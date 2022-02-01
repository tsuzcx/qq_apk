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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stPopWindowsButton{\n   title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append("\n   jumpurl=");
    localStringBuilder.append(this.jumpurl);
    localStringBuilder.append("\n   iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.title;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.jumpurl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.iconUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPopWindowsButton
 * JD-Core Version:    0.7.0.1
 */