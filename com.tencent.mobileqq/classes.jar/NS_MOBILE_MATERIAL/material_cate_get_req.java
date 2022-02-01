package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class material_cate_get_req
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo = new HashMap();
  public int iAppid = 0;
  public long lUin = 0L;
  public Map<String, String> mapExtInfo = null;
  public String strAttachInfo = "";
  public String strCateId = "";
  public String strQua = "";
  public String strTraceInfo = "";
  public long uiSettleTime = 0L;
  
  static
  {
    cache_mapExtInfo.put("", "");
  }
  
  public material_cate_get_req() {}
  
  public material_cate_get_req(long paramLong1, int paramInt, String paramString1, String paramString2, long paramLong2, String paramString3, Map<String, String> paramMap, String paramString4)
  {
    this.lUin = paramLong1;
    this.iAppid = paramInt;
    this.strCateId = paramString1;
    this.strAttachInfo = paramString2;
    this.uiSettleTime = paramLong2;
    this.strTraceInfo = paramString3;
    this.mapExtInfo = paramMap;
    this.strQua = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.iAppid = paramJceInputStream.read(this.iAppid, 1, false);
    this.strCateId = paramJceInputStream.readString(2, false);
    this.strAttachInfo = paramJceInputStream.readString(3, false);
    this.uiSettleTime = paramJceInputStream.read(this.uiSettleTime, 4, false);
    this.strTraceInfo = paramJceInputStream.readString(5, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 6, false));
    this.strQua = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iAppid, 1);
    if (this.strCateId != null) {
      paramJceOutputStream.write(this.strCateId, 2);
    }
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 3);
    }
    paramJceOutputStream.write(this.uiSettleTime, 4);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 5);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 6);
    }
    if (this.strQua != null) {
      paramJceOutputStream.write(this.strQua, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_cate_get_req
 * JD-Core Version:    0.7.0.1
 */