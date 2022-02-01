package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class tPullADVResponse
  extends JceStruct
{
  static Map<Integer, tAdvDesc> cache_map_adv_desc = new HashMap();
  public Map<Integer, tAdvDesc> map_adv_desc = null;
  public int ret = 0;
  public String s_ret_msg = "";
  
  static
  {
    tAdvDesc localtAdvDesc = new tAdvDesc();
    cache_map_adv_desc.put(Integer.valueOf(0), localtAdvDesc);
  }
  
  public tPullADVResponse() {}
  
  public tPullADVResponse(int paramInt, String paramString, Map<Integer, tAdvDesc> paramMap)
  {
    this.ret = paramInt;
    this.s_ret_msg = paramString;
    this.map_adv_desc = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.s_ret_msg = paramJceInputStream.readString(1, true);
    this.map_adv_desc = ((Map)paramJceInputStream.read(cache_map_adv_desc, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.s_ret_msg, 1);
    paramJceOutputStream.write(this.map_adv_desc, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     BOSSStrategyCenter.tPullADVResponse
 * JD-Core Version:    0.7.0.1
 */