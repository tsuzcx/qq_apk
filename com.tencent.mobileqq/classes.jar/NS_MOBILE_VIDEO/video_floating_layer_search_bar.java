package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class video_floating_layer_search_bar
  extends JceStruct
{
  public String history_jump_url = "";
  public String hot_word = "";
  public String hot_word_jump_url = "";
  public String video_play_history_description = "";
  
  public video_floating_layer_search_bar() {}
  
  public video_floating_layer_search_bar(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.hot_word = paramString1;
    this.hot_word_jump_url = paramString2;
    this.video_play_history_description = paramString3;
    this.history_jump_url = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hot_word = paramJceInputStream.readString(0, false);
    this.hot_word_jump_url = paramJceInputStream.readString(1, false);
    this.video_play_history_description = paramJceInputStream.readString(3, false);
    this.history_jump_url = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.hot_word != null) {
      paramJceOutputStream.write(this.hot_word, 0);
    }
    if (this.hot_word_jump_url != null) {
      paramJceOutputStream.write(this.hot_word_jump_url, 1);
    }
    if (this.video_play_history_description != null) {
      paramJceOutputStream.write(this.video_play_history_description, 3);
    }
    if (this.history_jump_url != null) {
      paramJceOutputStream.write(this.history_jump_url, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_VIDEO.video_floating_layer_search_bar
 * JD-Core Version:    0.7.0.1
 */