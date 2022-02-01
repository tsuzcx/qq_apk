package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class material_set_switch_req
  extends JceStruct
{
  static int cache_iSwitchState = 0;
  static Map<String, String> cache_mapExtInfo = new HashMap();
  public int iAppid = 0;
  public int iSwitchState = 0;
  public long lUin = 0L;
  public Map<String, String> mapExtInfo = null;
  
  static
  {
    cache_mapExtInfo.put("", "");
  }
  
  public material_set_switch_req() {}
  
  public material_set_switch_req(long paramLong, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    this.lUin = paramLong;
    this.iAppid = paramInt1;
    this.iSwitchState = paramInt2;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iAppid = paramJceInputStream.read(this.iAppid, 1, true);
    this.iSwitchState = paramJceInputStream.read(this.iSwitchState, 2, true);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iAppid, 1);
    paramJceOutputStream.write(this.iSwitchState, 2);
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_set_switch_req
 * JD-Core Version:    0.7.0.1
 */