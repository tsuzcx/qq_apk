package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
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
  public stGlobalConfig config;
  public stFeedStatus contextFeedStatus;
  public ArrayList<stSimpleMetaFeed> feeds;
  public boolean is_finished = true;
  public Map<String, String> map_ext;
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
    if (this.feeds != null) {
      paramJceOutputStream.write(this.feeds, 0);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 1);
    }
    paramJceOutputStream.write(this.is_finished, 2);
    if (this.config != null) {
      paramJceOutputStream.write(this.config, 3);
    }
    if (this.traceId != null) {
      paramJceOutputStream.write(this.traceId, 4);
    }
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 5);
    }
    if (this.contextFeedStatus != null) {
      paramJceOutputStream.write(this.contextFeedStatus, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stGetPersonalFeedListRsp
 * JD-Core Version:    0.7.0.1
 */