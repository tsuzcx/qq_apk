package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_forward_list
  extends JceStruct
{
  static Map cache_extendinfo;
  static ArrayList cache_fwdmans = new ArrayList();
  public String actionUrl = "";
  public Map extendinfo;
  public String forwardkey = "";
  public ArrayList fwdmans;
  public int isforward;
  public int num;
  
  static
  {
    s_user locals_user = new s_user();
    cache_fwdmans.add(locals_user);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public cell_forward_list() {}
  
  public cell_forward_list(int paramInt1, int paramInt2, ArrayList paramArrayList, String paramString1, Map paramMap, String paramString2)
  {
    this.num = paramInt1;
    this.isforward = paramInt2;
    this.fwdmans = paramArrayList;
    this.actionUrl = paramString1;
    this.extendinfo = paramMap;
    this.forwardkey = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.isforward = paramJceInputStream.read(this.isforward, 1, false);
    this.fwdmans = ((ArrayList)paramJceInputStream.read(cache_fwdmans, 2, false));
    this.actionUrl = paramJceInputStream.readString(3, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 4, false));
    this.forwardkey = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    paramJceOutputStream.write(this.isforward, 1);
    if (this.fwdmans != null) {
      paramJceOutputStream.write(this.fwdmans, 2);
    }
    if (this.actionUrl != null) {
      paramJceOutputStream.write(this.actionUrl, 3);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 4);
    }
    if (this.forwardkey != null) {
      paramJceOutputStream.write(this.forwardkey, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_forward_list
 * JD-Core Version:    0.7.0.1
 */