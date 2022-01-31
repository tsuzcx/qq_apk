package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class material_cate_get_rsp
  extends JceStruct
{
  static Map cache_mapExtInfo;
  static MaterialCate cache_stCate = new MaterialCate();
  public int iCode;
  public int iHasMore;
  public Map mapExtInfo;
  public MaterialCate stCate;
  public String strAttachInfo = "";
  
  static
  {
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public material_cate_get_rsp() {}
  
  public material_cate_get_rsp(int paramInt1, MaterialCate paramMaterialCate, String paramString, int paramInt2, Map paramMap)
  {
    this.iCode = paramInt1;
    this.stCate = paramMaterialCate;
    this.strAttachInfo = paramString;
    this.iHasMore = paramInt2;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, true);
    this.stCate = ((MaterialCate)paramJceInputStream.read(cache_stCate, 1, false));
    this.strAttachInfo = paramJceInputStream.readString(2, false);
    this.iHasMore = paramJceInputStream.read(this.iHasMore, 3, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.stCate != null) {
      paramJceOutputStream.write(this.stCate, 1);
    }
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 2);
    }
    paramJceOutputStream.write(this.iHasMore, 3);
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_cate_get_rsp
 * JD-Core Version:    0.7.0.1
 */