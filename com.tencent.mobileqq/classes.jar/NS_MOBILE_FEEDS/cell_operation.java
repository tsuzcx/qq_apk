package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class cell_operation
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_bypass_param;
  static Map<Integer, Map<String, String>> cache_click_stream_report;
  static ArrayList<s_op_btn> cache_custom_btn;
  static Map<Integer, String> cache_droplist_cookie;
  static Map<Integer, String> cache_feed_report_cookie;
  static Map<Integer, String> cache_rank_param;
  static Map<Integer, String> cache_recomm_cookie;
  static s_schema cache_schema_info;
  static s_outshare cache_share_info;
  public Map<Integer, String> busi_param = null;
  public String button_gif_url = "";
  public Map<String, String> bypass_param = null;
  public Map<Integer, Map<String, String>> click_stream_report = null;
  public ArrayList<s_op_btn> custom_btn = null;
  public Map<Integer, String> droplist_cookie = null;
  public Map<Integer, String> feed_report_cookie = null;
  public String generic_url = "";
  public long offline_resource_bid = 0L;
  public String qboss_trace = "";
  public String qq_url = "";
  public Map<Integer, String> rank_param = null;
  public Map<Integer, String> recomm_cookie = null;
  public s_schema schema_info = null;
  public s_outshare share_info = null;
  public String weixin_url = "";
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    cache_busi_param.put(localInteger, "");
    cache_share_info = new s_outshare();
    cache_schema_info = new s_schema();
    cache_recomm_cookie = new HashMap();
    cache_recomm_cookie.put(localInteger, "");
    cache_click_stream_report = new HashMap();
    Object localObject = new HashMap();
    ((Map)localObject).put("", "");
    cache_click_stream_report.put(localInteger, localObject);
    cache_custom_btn = new ArrayList();
    localObject = new s_op_btn();
    cache_custom_btn.add(localObject);
    cache_feed_report_cookie = new HashMap();
    cache_feed_report_cookie.put(localInteger, "");
    cache_bypass_param = new HashMap();
    cache_bypass_param.put("", "");
    cache_droplist_cookie = new HashMap();
    cache_droplist_cookie.put(localInteger, "");
    cache_rank_param = new HashMap();
    cache_rank_param.put(localInteger, "");
  }
  
  public cell_operation() {}
  
  public cell_operation(Map<Integer, String> paramMap1, String paramString1, String paramString2, s_outshare params_outshare, s_schema params_schema, Map<Integer, String> paramMap2, Map<Integer, Map<String, String>> paramMap, String paramString3, ArrayList<s_op_btn> paramArrayList, Map<Integer, String> paramMap3, String paramString4, Map<String, String> paramMap4, Map<Integer, String> paramMap5, Map<Integer, String> paramMap6, String paramString5, long paramLong)
  {
    this.busi_param = paramMap1;
    this.weixin_url = paramString1;
    this.qq_url = paramString2;
    this.share_info = params_outshare;
    this.schema_info = params_schema;
    this.recomm_cookie = paramMap2;
    this.click_stream_report = paramMap;
    this.qboss_trace = paramString3;
    this.custom_btn = paramArrayList;
    this.feed_report_cookie = paramMap3;
    this.generic_url = paramString4;
    this.bypass_param = paramMap4;
    this.droplist_cookie = paramMap5;
    this.rank_param = paramMap6;
    this.button_gif_url = paramString5;
    this.offline_resource_bid = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 0, false));
    this.weixin_url = paramJceInputStream.readString(1, false);
    this.qq_url = paramJceInputStream.readString(2, false);
    this.share_info = ((s_outshare)paramJceInputStream.read(cache_share_info, 3, false));
    this.schema_info = ((s_schema)paramJceInputStream.read(cache_schema_info, 4, false));
    this.recomm_cookie = ((Map)paramJceInputStream.read(cache_recomm_cookie, 5, false));
    this.click_stream_report = ((Map)paramJceInputStream.read(cache_click_stream_report, 6, false));
    this.qboss_trace = paramJceInputStream.readString(7, false);
    this.custom_btn = ((ArrayList)paramJceInputStream.read(cache_custom_btn, 8, false));
    this.feed_report_cookie = ((Map)paramJceInputStream.read(cache_feed_report_cookie, 9, false));
    this.generic_url = paramJceInputStream.readString(10, false);
    this.bypass_param = ((Map)paramJceInputStream.read(cache_bypass_param, 11, false));
    this.droplist_cookie = ((Map)paramJceInputStream.read(cache_droplist_cookie, 12, false));
    this.rank_param = ((Map)paramJceInputStream.read(cache_rank_param, 13, false));
    this.button_gif_url = paramJceInputStream.readString(14, false);
    this.offline_resource_bid = paramJceInputStream.read(this.offline_resource_bid, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 0);
    }
    localObject = this.weixin_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.qq_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.share_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.schema_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.recomm_cookie;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    localObject = this.click_stream_report;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    localObject = this.qboss_trace;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.custom_btn;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    localObject = this.feed_report_cookie;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 9);
    }
    localObject = this.generic_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.bypass_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 11);
    }
    localObject = this.droplist_cookie;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 12);
    }
    localObject = this.rank_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
    localObject = this.button_gif_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    paramJceOutputStream.write(this.offline_resource_bid, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_operation
 * JD-Core Version:    0.7.0.1
 */