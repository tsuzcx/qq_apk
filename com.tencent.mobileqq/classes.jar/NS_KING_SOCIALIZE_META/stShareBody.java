package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stShareBody
  extends JceStruct
{
  public String desc = "";
  public String image_url = "";
  public String title = "";
  
  public stShareBody() {}
  
  public stShareBody(String paramString1, String paramString2, String paramString3)
  {
    this.title = paramString1;
    this.desc = paramString2;
    this.image_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.desc = paramJceInputStream.readString(1, false);
    this.image_url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.title;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.image_url;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stShareBody
 * JD-Core Version:    0.7.0.1
 */