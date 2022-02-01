package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_single_feeds_req
  extends JceStruct
{
  static ArrayList<single_feeds_req_info> cache_req_feeds_info = new ArrayList();
  static Map<String, String> cache_stMapExtendinfo;
  public int get_type = 0;
  public ArrayList<single_feeds_req_info> req_feeds_info = null;
  public Map<String, String> stMapExtendinfo = null;
  
  static
  {
    single_feeds_req_info localsingle_feeds_req_info = new single_feeds_req_info();
    cache_req_feeds_info.add(localsingle_feeds_req_info);
    cache_stMapExtendinfo = new HashMap();
    cache_stMapExtendinfo.put("", "");
  }
  
  public mobile_single_feeds_req() {}
  
  public mobile_single_feeds_req(int paramInt, ArrayList<single_feeds_req_info> paramArrayList, Map<String, String> paramMap)
  {
    this.get_type = paramInt;
    this.req_feeds_info = paramArrayList;
    this.stMapExtendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.get_type = paramJceInputStream.read(this.get_type, 0, false);
    this.req_feeds_info = ((ArrayList)paramJceInputStream.read(cache_req_feeds_info, 1, false));
    this.stMapExtendinfo = ((Map)paramJceInputStream.read(cache_stMapExtendinfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.get_type, 0);
    if (this.req_feeds_info != null) {
      paramJceOutputStream.write(this.req_feeds_info, 1);
    }
    if (this.stMapExtendinfo != null) {
      paramJceOutputStream.write(this.stMapExtendinfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_single_feeds_req
 * JD-Core Version:    0.7.0.1
 */