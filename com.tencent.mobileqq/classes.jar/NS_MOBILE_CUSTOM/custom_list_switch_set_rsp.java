package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class custom_list_switch_set_rsp
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo = new HashMap();
  public int iCode;
  public Map<String, String> mapExtInfo;
  
  static
  {
    cache_mapExtInfo.put("", "");
  }
  
  public custom_list_switch_set_rsp() {}
  
  public custom_list_switch_set_rsp(int paramInt, Map<String, String> paramMap)
  {
    this.iCode = paramInt;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.custom_list_switch_set_rsp
 * JD-Core Version:    0.7.0.1
 */