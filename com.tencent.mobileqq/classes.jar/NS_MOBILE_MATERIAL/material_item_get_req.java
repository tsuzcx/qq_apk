package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class material_item_get_req
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo = new HashMap();
  public int iAppid = 0;
  public long lUin = 0L;
  public Map<String, String> mapExtInfo = null;
  public String strItemId = "";
  public String strTraceInfo = "";
  public long uiSettleTime = 0L;
  
  static
  {
    cache_mapExtInfo.put("", "");
  }
  
  public material_item_get_req() {}
  
  public material_item_get_req(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, Map<String, String> paramMap)
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
    Object localObject = this.strItemId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.uiSettleTime, 3);
    localObject = this.strTraceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.mapExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_item_get_req
 * JD-Core Version:    0.7.0.1
 */