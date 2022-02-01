package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stGetPersonalFeedListRsp
  extends JceStruct
{
  static stGlobalConfig cache_config;
  static stFeedStatus cache_contextFeedStatus = new stFeedStatus();
  static ArrayList<stSimpleMetaFeed> cache_feeds = new ArrayList();
  static Map<String, String> cache_map_ext;
  public String attach_info = "";
  public stGlobalConfig config = null;
  public stFeedStatus contextFeedStatus = null;
  public ArrayList<stSimpleMetaFeed> feeds = null;
  public boolean is_finished = true;
  public Map<String, String> map_ext = null;
  public String traceId = "";
  
  static
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    cache_feeds.add(localstSimpleMetaFeed);
    cache_config = new stGlobalConfig();
    cache_map_ext = new HashMap();
    cache_map_ext.put("", "");
  }
  
  public stGetPersonalFeedListRsp() {}
  
  public stGetPersonalFeedListRsp(ArrayList<stSimpleMetaFeed> paramArrayList, String paramString1, boolean paramBoolean, stGlobalConfig paramstGlobalConfig, String paramString2, Map<String, String> paramMap, stFeedStatus paramstFeedStatus)
  {
    this.feeds = paramArrayList;
    this.attach_info = paramString1;
    this.is_finished = paramBoolean;
    this.config = paramstGlobalConfig;
    this.traceId = paramString2;
    this.map_ext = paramMap;
    this.contextFeedStatus = paramstFeedStatus;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feeds = ((ArrayList)paramJceInputStream.read(cache_feeds, 0, false));
    this.attach_info = paramJceInputStream.readString(1, false);
    this.is_finished = paramJceInputStream.read(this.is_finished, 2, false);
    this.config = ((stGlobalConfig)paramJceInputStream.read(cache_config, 3, false));
    this.traceId = paramJceInputStream.readString(4, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 5, false));
    this.contextFeedStatus = ((stFeedStatus)paramJceInputStream.read(cache_contextFeedStatus, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.feeds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.is_finished, 2);
    localObject = this.config;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.traceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.map_ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    localObject = this.contextFeedStatus;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetPersonalFeedListRsp
 * JD-Core Version:    0.7.0.1
 */