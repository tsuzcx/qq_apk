package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stSimpleGetFeedListRsp
  extends JceStruct
{
  static stGlobalConfig cache_config = new stGlobalConfig();
  static ArrayList<stSimpleMetaFeed> cache_feeds = new ArrayList();
  static Map<String, Integer> cache_followinfo;
  static stMyVideoInfo cache_my_vinfo = new stMyVideoInfo();
  public String attach_info = "";
  public byte clearcache = 0;
  public stGlobalConfig config = null;
  public ArrayList<stSimpleMetaFeed> feeds = null;
  public Map<String, Integer> followinfo = null;
  public String gdt_args = "";
  public boolean is_finished = true;
  public stMyVideoInfo my_vinfo = null;
  public String session = "";
  public String trace_id = "";
  
  static
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    cache_feeds.add(localstSimpleMetaFeed);
    cache_followinfo = new HashMap();
    cache_followinfo.put("", Integer.valueOf(0));
  }
  
  public stSimpleGetFeedListRsp() {}
  
  public stSimpleGetFeedListRsp(String paramString1, ArrayList<stSimpleMetaFeed> paramArrayList, boolean paramBoolean, Map<String, Integer> paramMap, byte paramByte, stGlobalConfig paramstGlobalConfig, String paramString2, stMyVideoInfo paramstMyVideoInfo, String paramString3, String paramString4)
  {
    this.attach_info = paramString1;
    this.feeds = paramArrayList;
    this.is_finished = paramBoolean;
    this.followinfo = paramMap;
    this.clearcache = paramByte;
    this.config = paramstGlobalConfig;
    this.gdt_args = paramString2;
    this.my_vinfo = paramstMyVideoInfo;
    this.session = paramString3;
    this.trace_id = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attach_info = paramJceInputStream.readString(0, false);
    this.feeds = ((ArrayList)paramJceInputStream.read(cache_feeds, 1, false));
    this.is_finished = paramJceInputStream.read(this.is_finished, 2, false);
    this.followinfo = ((Map)paramJceInputStream.read(cache_followinfo, 3, false));
    this.clearcache = paramJceInputStream.read(this.clearcache, 4, false);
    this.config = ((stGlobalConfig)paramJceInputStream.read(cache_config, 5, false));
    this.gdt_args = paramJceInputStream.readString(6, false);
    this.my_vinfo = ((stMyVideoInfo)paramJceInputStream.read(cache_my_vinfo, 7, false));
    this.session = paramJceInputStream.readString(8, false);
    this.trace_id = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.feeds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    paramJceOutputStream.write(this.is_finished, 2);
    localObject = this.followinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    paramJceOutputStream.write(this.clearcache, 4);
    localObject = this.config;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.gdt_args;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.my_vinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.session;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.trace_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSimpleGetFeedListRsp
 * JD-Core Version:    0.7.0.1
 */