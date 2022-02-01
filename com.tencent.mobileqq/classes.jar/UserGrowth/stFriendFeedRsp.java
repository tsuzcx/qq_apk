package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stFriendFeedRsp
  extends JceStruct
{
  static stFriendFeed cache_friendFeed = new stFriendFeed();
  static Map<String, String> cache_mapExt = new HashMap();
  public stFriendFeed friendFeed = null;
  public int isFinished = 0;
  public Map<String, String> mapExt = null;
  public String traceId = "";
  
  static
  {
    cache_mapExt.put("", "");
  }
  
  public stFriendFeedRsp() {}
  
  public stFriendFeedRsp(stFriendFeed paramstFriendFeed, int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.friendFeed = paramstFriendFeed;
    this.isFinished = paramInt;
    this.traceId = paramString;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.friendFeed = ((stFriendFeed)paramJceInputStream.read(cache_friendFeed, 0, false));
    this.isFinished = paramJceInputStream.read(this.isFinished, 1, false);
    this.traceId = paramJceInputStream.readString(2, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.friendFeed;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.isFinished, 1);
    localObject = this.traceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFriendFeedRsp
 * JD-Core Version:    0.7.0.1
 */