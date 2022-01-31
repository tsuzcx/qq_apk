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
  static Map cache_extra_info;
  static ArrayList cache_info = new ArrayList();
  static ArrayList cache_multi_info;
  public Map extra_info;
  public ArrayList info;
  public ArrayList multi_info;
  public long type;
  
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
  
  public CLIENT_REPORT_REQ(long paramLong, ArrayList paramArrayList1, Map paramMap, ArrayList paramArrayList2)
  {
    this.type = paramLong;
    this.info = paramArrayList1;
    this.extra_info = paramMap;
    this.multi_info = paramArrayList2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_REQ
 * JD-Core Version:    0.7.0.1
 */