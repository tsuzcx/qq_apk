package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommentBubble
  extends JceStruct
{
  public int iItemId = -1;
  public String strAndBgUrl = "";
  public String strIosBgUrl = "";
  public String strTextColor = "";
  
  public CommentBubble() {}
  
  public CommentBubble(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.iItemId = paramInt;
    this.strTextColor = paramString1;
    this.strAndBgUrl = paramString2;
    this.strIosBgUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.strTextColor = paramJceInputStream.readString(1, false);
    this.strAndBgUrl = paramJceInputStream.readString(2, false);
    this.strIosBgUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strTextColor != null) {
      paramJceOutputStream.write(this.strTextColor, 1);
    }
    if (this.strAndBgUrl != null) {
      paramJceOutputStream.write(this.strAndBgUrl, 2);
    }
    if (this.strIosBgUrl != null) {
      paramJceOutputStream.write(this.strIosBgUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CommentBubble
 * JD-Core Version:    0.7.0.1
 */