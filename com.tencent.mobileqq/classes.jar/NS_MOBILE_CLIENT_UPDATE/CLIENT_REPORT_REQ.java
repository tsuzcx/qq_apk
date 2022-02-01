package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class CLIENT_REPORT_REQ
  extends JceStruct
{
  static Map<String, String> cache_extra_info;
  static ArrayList<Map<String, String>> cache_info = new ArrayList();
  static ArrayList<REPORT_INFO> cache_multi_info;
  public Map<String, String> extra_info = null;
  public ArrayList<Map<String, String>> info = null;
  public ArrayList<REPORT_INFO> multi_info = null;
  public long type = 0L;
  
  static
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("", "");
    cache_info.add(localObject);
    cache_extra_info = new HashMap();
    cache_extra_info.put("", "");
    cache_multi_info = new ArrayList();
    localObject = new REPORT_INFO();
    cache_multi_info.add(localObject);
  }
  
  public CLIENT_REPORT_REQ() {}
  
  public CLIENT_REPORT_REQ(long paramLong, ArrayList<Map<String, String>> paramArrayList, Map<String, String> paramMap, ArrayList<REPORT_INFO> paramArrayList1)
  {
    this.type = paramLong;
    this.info = paramArrayList;
    this.extra_info = paramMap;
    this.multi_info = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.info = ((ArrayList)paramJceInputStream.read(cache_info, 1, false));
    this.extra_info = ((Map)paramJceInputStream.read(cache_extra_info, 2, false));
    this.multi_info = ((ArrayList)paramJceInputStream.read(cache_multi_info, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.info != null) {
      paramJceOutputStream.write(this.info, 1);
    }
    if (this.extra_info != null) {
      paramJceOutputStream.write(this.extra_info, 2);
    }
    if (this.multi_info != null) {
      paramJceOutputStream.write(this.multi_info, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_REQ
 * JD-Core Version:    0.7.0.1
 */