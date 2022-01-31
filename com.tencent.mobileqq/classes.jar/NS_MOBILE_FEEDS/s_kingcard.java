package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_kingcard
  extends JceStruct
{
  public String button_title = "";
  public boolean is_guide;
  public String jump_url = "";
  
  public s_kingcard() {}
  
  public s_kingcard(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.is_guide = paramBoolean;
    this.button_title = paramString1;
    this.jump_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_guide = paramJceInputStream.read(this.is_guide, 0, false);
    this.button_title = paramJceInputStream.readString(1, false);
    this.jump_url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_guide, 0);
    if (this.button_title != null) {
      paramJceOutputStream.write(this.button_title, 1);
    }
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_kingcard
 * JD-Core Version:    0.7.0.1
 */