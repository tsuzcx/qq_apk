package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class material_item_get_rsp
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static MaterialItem cache_stItem = new MaterialItem();
  public int iCode;
  public Map<String, String> mapExtInfo;
  public MaterialItem stItem;
  
  static
  {
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public material_item_get_rsp() {}
  
  public material_item_get_rsp(int paramInt, MaterialItem paramMaterialItem, Map<String, String> paramMap)
  {
    this.iCode = paramInt;
    this.stItem = paramMaterialItem;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, true);
    this.stItem = ((MaterialItem)paramJceInputStream.read(cache_stItem, 1, false));
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.stItem != null) {
      paramJceOutputStream.write(this.stItem, 1);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_item_get_rsp
 * JD-Core Version:    0.7.0.1
 */