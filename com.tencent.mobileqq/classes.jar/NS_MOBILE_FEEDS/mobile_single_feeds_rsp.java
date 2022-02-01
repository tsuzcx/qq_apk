package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_single_feeds_rsp
  extends JceStruct
{
  static ArrayList<single_feed> cache_all_feeds_data = new ArrayList();
  static Map<String, String> cache_stMapExtendinfo;
  public ArrayList<single_feed> all_feeds_data = null;
  public long next_keep_alive_time = 0L;
  public Map<String, String> stMapExtendinfo = null;
  
  static
  {
    single_feed localsingle_feed = new single_feed();
    cache_all_feeds_data.add(localsingle_feed);
    cache_stMapExtendinfo = new HashMap();
    cache_stMapExtendinfo.put("", "");
  }
  
  public mobile_single_feeds_rsp() {}
  
  public mobile_single_feeds_rsp(ArrayList<single_feed> paramArrayList, long paramLong, Map<String, String> paramMap)
  {
    this.all_feeds_data = paramArrayList;
    this.next_keep_alive_time = paramLong;
    this.stMapExtendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 0, false));
    this.next_keep_alive_time = paramJceInputStream.read(this.next_keep_alive_time, 1, false);
    this.stMapExtendinfo = ((Map)paramJceInputStream.read(cache_stMapExtendinfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 0);
    }
    paramJceOutputStream.write(this.next_keep_alive_time, 1);
    if (this.stMapExtendinfo != null) {
      paramJceOutputStream.write(this.stMapExtendinfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_single_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */