package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class material_tab_get_rsp
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static MaterialTab cache_stTab = new MaterialTab();
  public int iCode = 0;
  public int iHasMore = 0;
  public Map<String, String> mapExtInfo = null;
  public MaterialTab stTab = null;
  public String strAttachInfo = "";
  
  static
  {
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public material_tab_get_rsp() {}
  
  public material_tab_get_rsp(int paramInt1, MaterialTab paramMaterialTab, String paramString, int paramInt2, Map<String, String> paramMap)
  {
    this.iCode = paramInt1;
    this.stTab = paramMaterialTab;
    this.strAttachInfo = paramString;
    this.iHasMore = paramInt2;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, true);
    this.stTab = ((MaterialTab)paramJceInputStream.read(cache_stTab, 1, false));
    this.strAttachInfo = paramJceInputStream.readString(2, false);
    this.iHasMore = paramJceInputStream.read(this.iHasMore, 3, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    Object localObject = this.stTab;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.strAttachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.iHasMore, 3);
    localObject = this.mapExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_tab_get_rsp
 * JD-Core Version:    0.7.0.1
 */