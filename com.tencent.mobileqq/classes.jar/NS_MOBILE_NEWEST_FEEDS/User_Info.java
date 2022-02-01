package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class User_Info
  extends JceStruct
{
  static Map<String, String> cache_extendInfo = new HashMap();
  public int eStarState = 0;
  public Map<String, String> extendInfo = null;
  
  static
  {
    cache_extendInfo.put("", "");
  }
  
  public User_Info() {}
  
  public User_Info(int paramInt, Map<String, String> paramMap)
  {
    this.eStarState = paramInt;
    this.extendInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eStarState = paramJceInputStream.read(this.eStarState, 0, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eStarState, 0);
    Map localMap = this.extendInfo;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_NEWEST_FEEDS.User_Info
 * JD-Core Version:    0.7.0.1
 */