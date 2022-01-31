package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
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
  public byte clearcache;
  public stGlobalConfig config;
  public ArrayList<stSimpleMetaFeed> feeds;
  public Map<String, Integer> followinfo;
  public String gdt_args = "";
  public boolean is_finished = true;
  public stMyVideoInfo my_vinfo;
  public String session = "";
  
  static
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    cache_feeds.add(localstSimpleMetaFeed);
    cache_followinfo = new HashMap();
    cache_followinfo.put("", Integer.valueOf(0));
  }
  
  public stSimpleGetFeedListRsp() {}
  
  public stSimpleGetFeedListRsp(String paramString1, ArrayList<stSimpleMetaFeed> paramArrayList, boolean paramBoolean, Map<String, Integer> paramMap, byte paramByte, stGlobalConfig paramstGlobalConfig, String paramString2, stMyVideoInfo paramstMyVideoInfo, String paramString3)
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 0);
    }
    if (this.feeds != null) {
      paramJceOutputStream.write(this.feeds, 1);
    }
    paramJceOutputStream.write(this.is_finished, 2);
    if (this.followinfo != null) {
      paramJceOutputStream.write(this.followinfo, 3);
    }
    paramJceOutputStream.write(this.clearcache, 4);
    if (this.config != null) {
      paramJceOutputStream.write(this.config, 5);
    }
    if (this.gdt_args != null) {
      paramJceOutputStream.write(this.gdt_args, 6);
    }
    if (this.my_vinfo != null) {
      paramJceOutputStream.write(this.my_vinfo, 7);
    }
    if (this.session != null) {
      paramJceOutputStream.write(this.session, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stSimpleGetFeedListRsp
 * JD-Core Version:    0.7.0.1
 */