package NS_MOBILE_CLIENT_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CLIENT_NBP_REPORT_RSP
  extends JceStruct
{
  static Map<String, String> cache_extra_info = new HashMap();
  public int code = 0;
  public Map<String, String> extra_info = null;
  
  static
  {
    cache_extra_info.put("", "");
  }
  
  public CLIENT_NBP_REPORT_RSP() {}
  
  public CLIENT_NBP_REPORT_RSP(int paramInt, Map<String, String> paramMap)
  {
    this.code = paramInt;
    this.extra_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.extra_info = ((Map)paramJceInputStream.read(cache_extra_info, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    Map localMap = this.extra_info;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_CLIENT_REPORT.CLIENT_NBP_REPORT_RSP
 * JD-Core Version:    0.7.0.1
 */