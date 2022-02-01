package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_video_action
  extends JceStruct
{
  static s_button cache_rooftop_button = new s_button();
  public String relation_desc = "";
  public s_button rooftop_button = null;
  
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
    Object localObject = this.relation_desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.rooftop_button;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_video_action
 * JD-Core Version:    0.7.0.1
 */