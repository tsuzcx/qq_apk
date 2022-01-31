package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_recom_tag
  extends JceStruct
{
  static s_event_tag cache_tagData = new s_event_tag();
  public int action_type;
  public String action_url = "";
  public s_event_tag tagData;
  
  public cell_recom_tag() {}
  
  public cell_recom_tag(s_event_tag params_event_tag, int paramInt, String paramString)
  {
    this.tagData = params_event_tag;
    this.action_type = paramInt;
    this.action_url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tagData = ((s_event_tag)paramJceInputStream.read(cache_tagData, 0, false));
    this.action_type = paramJceInputStream.read(this.action_type, 1, false);
    this.action_url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.tagData != null) {
      paramJceOutputStream.write(this.tagData, 0);
    }
    paramJceOutputStream.write(this.action_type, 1);
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recom_tag
 * JD-Core Version:    0.7.0.1
 */