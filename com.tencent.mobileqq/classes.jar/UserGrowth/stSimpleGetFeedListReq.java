package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stSimpleGetFeedListReq
  extends JceStruct
{
  static ArrayList<String> cache_context_feedids;
  static stLinkStragegyArgs cache_linkStragetyArgs = new stLinkStragegyArgs();
  static ArrayList<String> cache_local_feeds;
  static Map<String, String> cache_request_ext = new HashMap();
  public String attach_info = "";
  public String channel_info = "";
  public ArrayList<String> context_feedids;
  public String gdt_args = "";
  public byte isfirst;
  public byte isrefresh;
  public stLinkStragegyArgs linkStragetyArgs;
  public ArrayList<String> local_feeds;
  public String push_info = "";
  public Map<String, String> request_ext;
  public String rowkey = "";
  public int scene;
  public String session = "";
  
  static
  {
    cache_request_ext.put("", "");
    cache_local_feeds = new ArrayList();
    cache_local_feeds.add("");
    cache_context_feedids = new ArrayList();
    cache_context_feedids.add("");
  }
  
  public stSimpleGetFeedListReq() {}
  
  public stSimpleGetFeedListReq(String paramString1, byte paramByte1, byte paramByte2, String paramString2, Map<String, String> paramMap, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, stLinkStragegyArgs paramstLinkStragegyArgs)
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
  }
  
  public String toString()
  {
    return "stSimpleGetFeedListReq{attach_info='" + this.attach_info + '\'' + ", isrefresh=" + this.isrefresh + ", isfirst=" + this.isfirst + ", channel_info='" + this.channel_info + '\'' + ", scene=" + this.scene + ", gdt_args='" + this.gdt_args + '\'' + ", rowkey='" + this.rowkey + '\'' + ", session='" + this.session + '\'' + ", push_info='" + this.push_info + '\'' + ", linkStragetyArgs=" + this.linkStragetyArgs + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 0);
    }
    paramJceOutputStream.write(this.isrefresh, 1);
    paramJceOutputStream.write(this.isfirst, 2);
    if (this.channel_info != null) {
      paramJceOutputStream.write(this.channel_info, 4);
    }
    if (this.request_ext != null) {
      paramJceOutputStream.write(this.request_ext, 5);
    }
    if (this.local_feeds != null) {
      paramJceOutputStream.write(this.local_feeds, 6);
    }
    if (this.context_feedids != null) {
      paramJceOutputStream.write(this.context_feedids, 7);
    }
    paramJceOutputStream.write(this.scene, 8);
    if (this.gdt_args != null) {
      paramJceOutputStream.write(this.gdt_args, 9);
    }
    if (this.rowkey != null) {
      paramJceOutputStream.write(this.rowkey, 10);
    }
    if (this.session != null) {
      paramJceOutputStream.write(this.session, 11);
    }
    if (this.push_info != null) {
      paramJceOutputStream.write(this.push_info, 12);
    }
    if (this.linkStragetyArgs != null) {
      paramJceOutputStream.write(this.linkStragetyArgs, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stSimpleGetFeedListReq
 * JD-Core Version:    0.7.0.1
 */