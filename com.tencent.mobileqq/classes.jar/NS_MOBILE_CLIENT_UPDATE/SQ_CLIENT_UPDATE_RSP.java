package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class SQ_CLIENT_UPDATE_RSP
  extends JceStruct
{
  static Map<String, String> cache_extra_info;
  static int cache_upType = 0;
  static ArrayList<UPDATE_INFO> cache_vModule;
  static ArrayList<UPDATE_INFO> cache_vPlugin;
  public Map<String, String> extra_info = null;
  public String md5 = "";
  public String upMsg = "";
  public int upType = 0;
  public String upUrl = "";
  public ArrayList<UPDATE_INFO> vModule = null;
  public ArrayList<UPDATE_INFO> vPlugin = null;
  public String version = "";
  
  static
  {
    cache_extra_info = new HashMap();
    cache_extra_info.put("", "");
    cache_vPlugin = new ArrayList();
    UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
    cache_vPlugin.add(localUPDATE_INFO);
    cache_vModule = new ArrayList();
    localUPDATE_INFO = new UPDATE_INFO();
    cache_vModule.add(localUPDATE_INFO);
  }
  
  public SQ_CLIENT_UPDATE_RSP() {}
  
  public SQ_CLIENT_UPDATE_RSP(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, Map<String, String> paramMap, ArrayList<UPDATE_INFO> paramArrayList1, ArrayList<UPDATE_INFO> paramArrayList2)
  {
    this.version = paramString1;
    this.upUrl = paramString2;
    this.md5 = paramString3;
    this.upMsg = paramString4;
    this.upType = paramInt;
    this.extra_info = paramMap;
    this.vPlugin = paramArrayList1;
    this.vModule = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.version = paramJceInputStream.readString(0, false);
    this.upUrl = paramJceInputStream.readString(1, false);
    this.md5 = paramJceInputStream.readString(2, false);
    this.upMsg = paramJceInputStream.readString(3, false);
    this.upType = paramJceInputStream.read(this.upType, 4, false);
    this.extra_info = ((Map)paramJceInputStream.read(cache_extra_info, 5, false));
    this.vPlugin = ((ArrayList)paramJceInputStream.read(cache_vPlugin, 6, false));
    this.vModule = ((ArrayList)paramJceInputStream.read(cache_vModule, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 0);
    }
    if (this.upUrl != null) {
      paramJceOutputStream.write(this.upUrl, 1);
    }
    if (this.md5 != null) {
      paramJceOutputStream.write(this.md5, 2);
    }
    if (this.upMsg != null) {
      paramJceOutputStream.write(this.upMsg, 3);
    }
    paramJceOutputStream.write(this.upType, 4);
    if (this.extra_info != null) {
      paramJceOutputStream.write(this.extra_info, 5);
    }
    if (this.vPlugin != null) {
      paramJceOutputStream.write(this.vPlugin, 6);
    }
    if (this.vModule != null) {
      paramJceOutputStream.write(this.vModule, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP
 * JD-Core Version:    0.7.0.1
 */