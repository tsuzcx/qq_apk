package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stFollowFeedsRsp
  extends JceStruct
{
  static stFollowFeedsGlobalConfig cache_config = new stFollowFeedsGlobalConfig();
  static ArrayList<stFeed> cache_feeds = new ArrayList();
  static Map<String, String> cache_map_ext;
  public String attatch_info = "";
  public int cache_size = 0;
  public stFollowFeedsGlobalConfig config = null;
  public ArrayList<stFeed> feeds = null;
  public String feeds_source = "";
  public boolean is_finished = true;
  public Map<String, String> map_ext = null;
  public String trace_id = "";
  
  static
  {
    stFeed localstFeed = new stFeed();
    cache_feeds.add(localstFeed);
    cache_map_ext = new HashMap();
    cache_map_ext.put("", "");
  }
  
  public stFollowFeedsRsp() {}
  
  public stFollowFeedsRsp(ArrayList<stFeed> paramArrayList, String paramString1, boolean paramBoolean, int paramInt, String paramString2, String paramString3, Map<String, String> paramMap, stFollowFeedsGlobalConfig paramstFollowFeedsGlobalConfig)
  {
    this.feeds = paramArrayList;
    this.attatch_info = paramString1;
    this.is_finished = paramBoolean;
    this.cache_size = paramInt;
    this.feeds_source = paramString2;
    this.trace_id = paramString3;
    this.map_ext = paramMap;
    this.config = paramstFollowFeedsGlobalConfig;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feeds = ((ArrayList)paramJceInputStream.read(cache_feeds, 0, false));
    this.attatch_info = paramJceInputStream.readString(1, false);
    this.is_finished = paramJceInputStream.read(this.is_finished, 2, false);
    this.cache_size = paramJceInputStream.read(this.cache_size, 3, false);
    this.feeds_source = paramJceInputStream.readString(4, false);
    this.trace_id = paramJceInputStream.readString(5, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 6, false));
    this.config = ((stFollowFeedsGlobalConfig)paramJceInputStream.read(cache_config, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.feeds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.attatch_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.is_finished, 2);
    paramJceOutputStream.write(this.cache_size, 3);
    localObject = this.feeds_source;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.trace_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.map_ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    localObject = this.config;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFollowFeedsRsp
 * JD-Core Version:    0.7.0.1
 */