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
  public int iCode = 0;
  public Map<String, String> mapExtInfo = null;
  public MaterialItem stItem = null;
  
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
    Object localObject = this.stItem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.mapExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_item_get_rsp
 * JD-Core Version:    0.7.0.1
 */