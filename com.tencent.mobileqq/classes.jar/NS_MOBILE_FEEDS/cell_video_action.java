package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_video_action
  extends JceStruct
{
  static s_button cache_rooftop_button = new s_button();
  public String relation_desc = "";
  public s_button rooftop_button;
  
  public cell_video_action() {}
  
  public cell_video_action(String paramString, s_button params_button)
  {
    this.relation_desc = paramString;
    this.rooftop_button = params_button;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.relation_desc = paramJceInputStream.readString(0, false);
    this.rooftop_button = ((s_button)paramJceInputStream.read(cache_rooftop_button, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.relation_desc != null) {
      paramJceOutputStream.write(this.relation_desc, 0);
    }
    if (this.rooftop_button != null) {
      paramJceOutputStream.write(this.rooftop_button, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_video_action
 * JD-Core Version:    0.7.0.1
 */