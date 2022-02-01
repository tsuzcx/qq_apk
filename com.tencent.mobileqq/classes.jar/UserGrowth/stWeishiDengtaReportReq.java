package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stWeishiDengtaReportReq
  extends JceStruct
{
  static Map<String, String> cache_params = new HashMap();
  public String eventName = "";
  public Map<String, String> params = null;
  
  static
  {
    cache_params.put("", "");
  }
  
  public stWeishiDengtaReportReq() {}
  
  public stWeishiDengtaReportReq(String paramString, Map<String, String> paramMap)
  {
    this.eventName = paramString;
    this.params = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eventName = paramJceInputStream.readString(0, false);
    this.params = ((Map)paramJceInputStream.read(cache_params, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.eventName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.params;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stWeishiDengtaReportReq
 * JD-Core Version:    0.7.0.1
 */