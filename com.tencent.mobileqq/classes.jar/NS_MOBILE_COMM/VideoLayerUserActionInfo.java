package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class VideoLayerUserActionInfo
  extends JceStruct
{
  static Map<String, VideoLayerUserAction> cache_actions = new HashMap();
  public Map<String, VideoLayerUserAction> actions = null;
  
  static
  {
    VideoLayerUserAction localVideoLayerUserAction = new VideoLayerUserAction();
    cache_actions.put("", localVideoLayerUserAction);
  }
  
  public VideoLayerUserActionInfo() {}
  
  public VideoLayerUserActionInfo(Map<String, VideoLayerUserAction> paramMap)
  {
    this.actions = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.actions = ((Map)paramJceInputStream.read(cache_actions, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.actions;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_COMM.VideoLayerUserActionInfo
 * JD-Core Version:    0.7.0.1
 */