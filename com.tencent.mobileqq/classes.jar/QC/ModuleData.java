package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ModuleData
  extends JceStruct
{
  static Map<String, String> cache_extModParams;
  static ArrayList<ItemDisDetail> cache_vitem = new ArrayList();
  public String cname = "";
  public Map<String, String> extModParams = null;
  public ArrayList<ItemDisDetail> vitem = null;
  
  static
  {
    ItemDisDetail localItemDisDetail = new ItemDisDetail();
    cache_vitem.add(localItemDisDetail);
    cache_extModParams = new HashMap();
    cache_extModParams.put("", "");
  }
  
  public ModuleData() {}
  
  public ModuleData(String paramString, ArrayList<ItemDisDetail> paramArrayList, Map<String, String> paramMap)
  {
    this.cname = paramString;
    this.vitem = paramArrayList;
    this.extModParams = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cname = paramJceInputStream.readString(0, false);
    this.vitem = ((ArrayList)paramJceInputStream.read(cache_vitem, 1, false));
    this.extModParams = ((Map)paramJceInputStream.read(cache_extModParams, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.cname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.vitem;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.extModParams;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.ModuleData
 * JD-Core Version:    0.7.0.1
 */