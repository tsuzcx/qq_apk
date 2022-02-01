package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_search_word
  extends JceStruct
{
  public String hot_word = "";
  public String jump_url = "";
  
  public s_search_word() {}
  
  public s_search_word(String paramString1, String paramString2)
  {
    this.hot_word = paramString1;
    this.jump_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hot_word = paramJceInputStream.readString(0, false);
    this.jump_url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.hot_word;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.jump_url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_search_word
 * JD-Core Version:    0.7.0.1
 */