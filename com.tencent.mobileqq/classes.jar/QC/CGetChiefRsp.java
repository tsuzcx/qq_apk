package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CGetChiefRsp
  extends JceStruct
{
  static Map<String, String> cache_extParams;
  static ArrayList<ModuleData> cache_modData = new ArrayList();
  public String errmsg = "";
  public Map<String, String> extParams = null;
  public ArrayList<ModuleData> modData = null;
  public int ret = 0;
  
  static
  {
    ModuleData localModuleData = new ModuleData();
    cache_modData.add(localModuleData);
    cache_extParams = new HashMap();
    cache_extParams.put("", "");
  }
  
  public CGetChiefRsp() {}
  
  public CGetChiefRsp(int paramInt, String paramString, ArrayList<ModuleData> paramArrayList, Map<String, String> paramMap)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.modData = paramArrayList;
    this.extParams = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.modData = ((ArrayList)paramJceInputStream.read(cache_modData, 2, false));
    this.extParams = ((Map)paramJceInputStream.read(cache_extParams, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.errmsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.modData;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.extParams;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.CGetChiefRsp
 * JD-Core Version:    0.7.0.1
 */