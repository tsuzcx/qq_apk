package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_video_layer_adv_req
  extends JceStruct
{
  static Map cache_busi_param;
  static ArrayList cache_context_list = new ArrayList();
  static Map cache_mapExt;
  public Map busi_param;
  public ArrayList context_list;
  public Map mapExt;
  public int req_type;
  public long uin;
  
  static
  {
    feeds_context_info localfeeds_context_info = new feeds_context_info();
    cache_context_list.add(localfeeds_context_info);
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public mobile_video_layer_adv_req() {}
  
  public mobile_video_layer_adv_req(long paramLong, ArrayList paramArrayList, Map paramMap1, Map paramMap2, int paramInt)
  {
    this.uin = paramLong;
    this.context_list = paramArrayList;
    this.busi_param = paramMap1;
    this.mapExt = paramMap2;
    this.req_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.context_list = ((ArrayList)paramJceInputStream.read(cache_context_list, 1, false));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 2, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 3, false));
    this.req_type = paramJceInputStream.read(this.req_type, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.context_list != null) {
      paramJceOutputStream.write(this.context_list, 1);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 2);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 3);
    }
    paramJceOutputStream.write(this.req_type, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_video_layer_adv_req
 * JD-Core Version:    0.7.0.1
 */