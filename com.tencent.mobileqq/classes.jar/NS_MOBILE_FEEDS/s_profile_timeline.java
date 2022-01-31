package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class s_profile_timeline
  extends JceStruct
{
  static Map cache_map_timeline = new HashMap();
  public Map map_timeline;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new s_profile_calendar());
    cache_map_timeline.put(Integer.valueOf(0), localArrayList);
  }
  
  public s_profile_timeline() {}
  
  public s_profile_timeline(Map paramMap)
  {
    this.map_timeline = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.map_timeline = ((Map)paramJceInputStream.read(cache_map_timeline, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.map_timeline != null) {
      paramJceOutputStream.write(this.map_timeline, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_profile_timeline
 * JD-Core Version:    0.7.0.1
 */