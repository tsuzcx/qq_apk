package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_click_button_req
  extends JceStruct
{
  static Map<String, String> cache_busi_param = new HashMap();
  public Map<String, String> busi_param;
  
  static
  {
    cache_busi_param.put("", "");
  }
  
  public operation_click_button_req() {}
  
  public operation_click_button_req(Map<String, String> paramMap)
  {
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.operation_click_button_req
 * JD-Core Version:    0.7.0.1
 */