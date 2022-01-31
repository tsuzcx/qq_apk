package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class material_item_get_req
  extends JceStruct
{
  static Map cache_mapExtInfo = new HashMap();
  public int iAppid;
  public long lUin;
  public Map mapExtInfo;
  public String strItemId = "";
  public String strTraceInfo = "";
  public long uiSettleTime;
  
  static
  {
    cache_mapExtInfo.put("", "");
  }
  
  public material_item_get_req() {}
  
  public material_item_get_req(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, Map paramMap)
  {
    this.lUin = paramLong1;
    this.iAppid = paramInt;
    this.strItemId = paramString1;
    this.uiSettleTime = paramLong2;
    this.strTraceInfo = paramString2;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.iAppid = paramJceInputStream.read(this.iAppid, 1, false);
    this.strItemId = paramJceInputStream.readString(2, false);
    this.uiSettleTime = paramJceInputStream.read(this.uiSettleTime, 3, false);
    this.strTraceInfo = paramJceInputStream.readString(4, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iAppid, 1);
    if (this.strItemId != null) {
      paramJceOutputStream.write(this.strItemId, 2);
    }
    paramJceOutputStream.write(this.uiSettleTime, 3);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 4);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_item_get_req
 * JD-Core Version:    0.7.0.1
 */