package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_droplist_option
  extends JceStruct
{
  static Map<String, String> cache_extend_info = new HashMap();
  public int action_detail;
  public int actiontype;
  public Map<String, String> extend_info;
  public String iconurl = "";
  public String jumpurl = "";
  public String optext = "";
  public String reportattach = "";
  public int reporttype;
  public int reporttypeV2;
  
  static
  {
    cache_extend_info.put("", "");
  }
  
  public s_droplist_option() {}
  
  public s_droplist_option(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, int paramInt3, Map<String, String> paramMap, int paramInt4)
  {
    this.iconurl = paramString1;
    this.optext = paramString2;
    this.actiontype = paramInt1;
    this.jumpurl = paramString3;
    this.reporttype = paramInt2;
    this.reportattach = paramString4;
    this.reporttypeV2 = paramInt3;
    this.extend_info = paramMap;
    this.action_detail = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iconurl = paramJceInputStream.readString(0, false);
    this.optext = paramJceInputStream.readString(1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.jumpurl = paramJceInputStream.readString(3, false);
    this.reporttype = paramJceInputStream.read(this.reporttype, 4, false);
    this.reportattach = paramJceInputStream.readString(5, false);
    this.reporttypeV2 = paramJceInputStream.read(this.reporttypeV2, 6, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 7, false));
    this.action_detail = paramJceInputStream.read(this.action_detail, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.iconurl != null) {
      paramJceOutputStream.write(this.iconurl, 0);
    }
    if (this.optext != null) {
      paramJceOutputStream.write(this.optext, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.jumpurl != null) {
      paramJceOutputStream.write(this.jumpurl, 3);
    }
    paramJceOutputStream.write(this.reporttype, 4);
    if (this.reportattach != null) {
      paramJceOutputStream.write(this.reportattach, 5);
    }
    paramJceOutputStream.write(this.reporttypeV2, 6);
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 7);
    }
    paramJceOutputStream.write(this.action_detail, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_droplist_option
 * JD-Core Version:    0.7.0.1
 */