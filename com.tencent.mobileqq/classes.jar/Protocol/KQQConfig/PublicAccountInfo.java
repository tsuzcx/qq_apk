package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PublicAccountInfo
  extends JceStruct
{
  public String strContent = "";
  public String strLinkURL = "";
  public String strNeighborContent = "";
  public String strPicURL = "";
  public String strTitle = "";
  
  public PublicAccountInfo() {}
  
  public PublicAccountInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.strPicURL = paramString1;
    this.strLinkURL = paramString2;
    this.strTitle = paramString3;
    this.strContent = paramString4;
    this.strNeighborContent = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicURL = paramJceInputStream.readString(1, false);
    this.strLinkURL = paramJceInputStream.readString(2, false);
    this.strTitle = paramJceInputStream.readString(3, false);
    this.strContent = paramJceInputStream.readString(4, false);
    this.strNeighborContent = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strPicURL;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strLinkURL;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strTitle;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.strContent;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.strNeighborContent;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     protocol.KQQConfig.PublicAccountInfo
 * JD-Core Version:    0.7.0.1
 */