package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OfficialComment
  extends JceStruct
{
  public String strContent = "";
  public String strTagBgColor = "";
  public String strTagName = "";
  
  public OfficialComment() {}
  
  public OfficialComment(String paramString1, String paramString2, String paramString3)
  {
    this.strTagName = paramString1;
    this.strTagBgColor = paramString2;
    this.strContent = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strTagName = paramJceInputStream.readString(0, false);
    this.strTagBgColor = paramJceInputStream.readString(1, false);
    this.strContent = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strTagName != null) {
      paramJceOutputStream.write(this.strTagName, 0);
    }
    if (this.strTagBgColor != null) {
      paramJceOutputStream.write(this.strTagBgColor, 1);
    }
    if (this.strContent != null) {
      paramJceOutputStream.write(this.strContent, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_COMM.OfficialComment
 * JD-Core Version:    0.7.0.1
 */