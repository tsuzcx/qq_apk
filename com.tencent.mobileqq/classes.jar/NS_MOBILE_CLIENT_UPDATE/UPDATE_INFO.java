package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UPDATE_INFO
  extends JceStruct
{
  static int cache_actype = 0;
  static Map<String, String> cache_extra_info = new HashMap();
  static Map<Integer, String> cache_plugin_info;
  public int actype;
  public String app = "";
  public Map<String, String> extra_info;
  public String id = "";
  public String mainVersion = "";
  public String md5 = "";
  public String name = "";
  public Map<Integer, String> plugin_info;
  public String ver = "";
  
  static
  {
    cache_extra_info.put("", "");
    cache_plugin_info = new HashMap();
    cache_plugin_info.put(Integer.valueOf(0), "");
  }
  
  public UPDATE_INFO() {}
  
  public UPDATE_INFO(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, String paramString4, String paramString5, String paramString6, Map<Integer, String> paramMap1, int paramInt)
  {
    this.app = paramString1;
    this.ver = paramString2;
    this.name = paramString3;
    this.extra_info = paramMap;
    this.id = paramString4;
    this.mainVersion = paramString5;
    this.md5 = paramString6;
    this.plugin_info = paramMap1;
    this.actype = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.app = paramJceInputStream.readString(0, true);
    this.ver = paramJceInputStream.readString(1, true);
    this.name = paramJceInputStream.readString(2, false);
    this.extra_info = ((Map)paramJceInputStream.read(cache_extra_info, 3, false));
    this.id = paramJceInputStream.readString(4, false);
    this.mainVersion = paramJceInputStream.readString(5, false);
    this.md5 = paramJceInputStream.readString(6, false);
    this.plugin_info = ((Map)paramJceInputStream.read(cache_plugin_info, 7, false));
    this.actype = paramJceInputStream.read(this.actype, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.app, 0);
    paramJceOutputStream.write(this.ver, 1);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 2);
    }
    if (this.extra_info != null) {
      paramJceOutputStream.write(this.extra_info, 3);
    }
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 4);
    }
    if (this.mainVersion != null) {
      paramJceOutputStream.write(this.mainVersion, 5);
    }
    if (this.md5 != null) {
      paramJceOutputStream.write(this.md5, 6);
    }
    if (this.plugin_info != null) {
      paramJceOutputStream.write(this.plugin_info, 7);
    }
    paramJceOutputStream.write(this.actype, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO
 * JD-Core Version:    0.7.0.1
 */