package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CLIENT_REPORT_RSP
  extends JceStruct
{
  static Map<String, String> cache_msg = new HashMap();
  public int code;
  public Map<String, String> msg;
  
  static
  {
    cache_msg.put("", "");
  }
  
  public CLIENT_REPORT_RSP() {}
  
  public CLIENT_REPORT_RSP(int paramInt, Map<String, String> paramMap)
  {
    this.code = paramInt;
    this.msg = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.msg = ((Map)paramJceInputStream.read(cache_msg, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_RSP
 * JD-Core Version:    0.7.0.1
 */