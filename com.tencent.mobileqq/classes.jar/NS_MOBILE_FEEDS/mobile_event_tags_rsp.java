package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_event_tags_rsp
  extends JceStruct
{
  static ArrayList<s_event_tag> cache_event_tags = new ArrayList();
  public ArrayList<s_event_tag> event_tags;
  
  static
  {
    s_event_tag locals_event_tag = new s_event_tag();
    cache_event_tags.add(locals_event_tag);
  }
  
  public mobile_event_tags_rsp() {}
  
  public mobile_event_tags_rsp(ArrayList<s_event_tag> paramArrayList)
  {
    this.event_tags = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.event_tags = ((ArrayList)paramJceInputStream.read(cache_event_tags, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.event_tags != null) {
      paramJceOutputStream.write(this.event_tags, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_event_tags_rsp
 * JD-Core Version:    0.7.0.1
 */