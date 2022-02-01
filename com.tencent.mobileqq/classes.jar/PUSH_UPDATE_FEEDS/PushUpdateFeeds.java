package PUSH_UPDATE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PushUpdateFeeds
  extends JceStruct
{
  static Map<Integer, String> cache_cell_checksum;
  static Map<Integer, String> cache_cell_infos;
  static CommentReplyInfo cache_commmet_reply_info;
  static Map<String, String> cache_extendinfo;
  static Map<Integer, byte[]> cache_feeds_data = new HashMap();
  public boolean all_pull = true;
  public Map<Integer, String> cell_checksum = null;
  public Map<Integer, String> cell_infos = null;
  public CommentReplyInfo commmet_reply_info = null;
  public Map<String, String> extendinfo = null;
  public Map<Integer, byte[]> feeds_data = null;
  public long feeds_update_time = 0L;
  public boolean need_pull = true;
  public String ugc_key = "";
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_feeds_data.put(localInteger, arrayOfByte);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
    cache_cell_infos = new HashMap();
    cache_cell_infos.put(localInteger, "");
    cache_commmet_reply_info = new CommentReplyInfo();
    cache_cell_checksum = new HashMap();
    cache_cell_checksum.put(localInteger, "");
  }
  
  public PushUpdateFeeds() {}
  
  public PushUpdateFeeds(String paramString, Map<Integer, byte[]> paramMap, Map<String, String> paramMap1, Map<Integer, String> paramMap2, CommentReplyInfo paramCommentReplyInfo, long paramLong, boolean paramBoolean1, Map<Integer, String> paramMap3, boolean paramBoolean2)
  {
    this.ugc_key = paramString;
    this.feeds_data = paramMap;
    this.extendinfo = paramMap1;
    this.cell_infos = paramMap2;
    this.commmet_reply_info = paramCommentReplyInfo;
    this.feeds_update_time = paramLong;
    this.need_pull = paramBoolean1;
    this.cell_checksum = paramMap3;
    this.all_pull = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ugc_key = paramJceInputStream.readString(0, false);
    this.feeds_data = ((Map)paramJceInputStream.read(cache_feeds_data, 1, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 2, false));
    this.cell_infos = ((Map)paramJceInputStream.read(cache_cell_infos, 3, false));
    this.commmet_reply_info = ((CommentReplyInfo)paramJceInputStream.read(cache_commmet_reply_info, 4, false));
    this.feeds_update_time = paramJceInputStream.read(this.feeds_update_time, 5, false);
    this.need_pull = paramJceInputStream.read(this.need_pull, 6, false);
    this.cell_checksum = ((Map)paramJceInputStream.read(cache_cell_checksum, 7, false));
    this.all_pull = paramJceInputStream.read(this.all_pull, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.ugc_key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.feeds_data;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.cell_infos;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    localObject = this.commmet_reply_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    paramJceOutputStream.write(this.feeds_update_time, 5);
    paramJceOutputStream.write(this.need_pull, 6);
    localObject = this.cell_checksum;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
    paramJceOutputStream.write(this.all_pull, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     PUSH_UPDATE_FEEDS.PushUpdateFeeds
 * JD-Core Version:    0.7.0.1
 */