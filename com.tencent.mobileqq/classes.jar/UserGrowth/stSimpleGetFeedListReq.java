package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stSimpleGetFeedListReq
  extends JceStruct
{
  static ArrayList<String> cache_context_feedids;
  static ArrayList<stExposureFeedInfo> cache_exposureFeedList;
  static stLinkStragegyArgs cache_linkStragetyArgs;
  static ArrayList<String> cache_local_feeds;
  static Map<String, String> cache_request_ext = new HashMap();
  public String attach_info = "";
  public String channel_info = "";
  public ArrayList<String> context_feedids = null;
  public ArrayList<stExposureFeedInfo> exposureFeedList = null;
  public String gdt_args = "";
  public byte isfirst = 0;
  public byte isrefresh = 0;
  public stLinkStragegyArgs linkStragetyArgs = null;
  public ArrayList<String> local_feeds = null;
  public String push_info = "";
  public String qqNum = "";
  public Map<String, String> request_ext = null;
  public String rowkey = "";
  public int scene = 0;
  public String session = "";
  public String subTabID = "";
  
  static
  {
    cache_request_ext.put("", "");
    cache_local_feeds = new ArrayList();
    cache_local_feeds.add("");
    cache_context_feedids = new ArrayList();
    cache_context_feedids.add("");
    cache_linkStragetyArgs = new stLinkStragegyArgs();
    cache_exposureFeedList = new ArrayList();
    stExposureFeedInfo localstExposureFeedInfo = new stExposureFeedInfo();
    cache_exposureFeedList.add(localstExposureFeedInfo);
  }
  
  public stSimpleGetFeedListReq() {}
  
  public stSimpleGetFeedListReq(String paramString1, byte paramByte1, byte paramByte2, String paramString2, Map<String, String> paramMap, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, stLinkStragegyArgs paramstLinkStragegyArgs, String paramString7, String paramString8, ArrayList<stExposureFeedInfo> paramArrayList)
  {
    this.attach_info = paramString1;
    this.isrefresh = paramByte1;
    this.isfirst = paramByte2;
    this.channel_info = paramString2;
    this.request_ext = paramMap;
    this.local_feeds = paramArrayList1;
    this.context_feedids = paramArrayList2;
    this.scene = paramInt;
    this.gdt_args = paramString3;
    this.rowkey = paramString4;
    this.session = paramString5;
    this.push_info = paramString6;
    this.linkStragetyArgs = paramstLinkStragegyArgs;
    this.qqNum = paramString7;
    this.subTabID = paramString8;
    this.exposureFeedList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attach_info = paramJceInputStream.readString(0, false);
    this.isrefresh = paramJceInputStream.read(this.isrefresh, 1, false);
    this.isfirst = paramJceInputStream.read(this.isfirst, 2, false);
    this.channel_info = paramJceInputStream.readString(4, false);
    this.request_ext = ((Map)paramJceInputStream.read(cache_request_ext, 5, false));
    this.local_feeds = ((ArrayList)paramJceInputStream.read(cache_local_feeds, 6, false));
    this.context_feedids = ((ArrayList)paramJceInputStream.read(cache_context_feedids, 7, false));
    this.scene = paramJceInputStream.read(this.scene, 8, false);
    this.gdt_args = paramJceInputStream.readString(9, false);
    this.rowkey = paramJceInputStream.readString(10, false);
    this.session = paramJceInputStream.readString(11, false);
    this.push_info = paramJceInputStream.readString(12, false);
    this.linkStragetyArgs = ((stLinkStragegyArgs)paramJceInputStream.read(cache_linkStragetyArgs, 13, false));
    this.qqNum = paramJceInputStream.readString(14, false);
    this.subTabID = paramJceInputStream.readString(15, false);
    this.exposureFeedList = ((ArrayList)paramJceInputStream.read(cache_exposureFeedList, 16, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.isrefresh, 1);
    paramJceOutputStream.write(this.isfirst, 2);
    localObject = this.channel_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.request_ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    localObject = this.local_feeds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    localObject = this.context_feedids;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    paramJceOutputStream.write(this.scene, 8);
    localObject = this.gdt_args;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.rowkey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.session;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.push_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.linkStragetyArgs;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.qqNum;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.subTabID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    localObject = this.exposureFeedList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSimpleGetFeedListReq
 * JD-Core Version:    0.7.0.1
 */