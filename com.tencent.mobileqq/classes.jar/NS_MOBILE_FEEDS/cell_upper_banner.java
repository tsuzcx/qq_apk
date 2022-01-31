package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_upper_banner
  extends JceStruct
{
  static Map<String, String> cache_extendInfo;
  static s_picdata cache_picdata = new s_picdata();
  public int actionType;
  public String action_url = "";
  public int banner_type;
  public String button_title = "";
  public Map<String, String> extendInfo;
  public s_picdata picdata;
  public String summary = "";
  public String title = "";
  
  static
  {
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
  }
  
  public cell_upper_banner() {}
  
  public cell_upper_banner(s_picdata params_picdata, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, Map<String, String> paramMap)
  {
    this.picdata = params_picdata;
    this.title = paramString1;
    this.summary = paramString2;
    this.button_title = paramString3;
    this.actionType = paramInt1;
    this.action_url = paramString4;
    this.banner_type = paramInt2;
    this.extendInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picdata = ((s_picdata)paramJceInputStream.read(cache_picdata, 0, false));
    this.title = paramJceInputStream.readString(1, false);
    this.summary = paramJceInputStream.readString(2, false);
    this.button_title = paramJceInputStream.readString(3, false);
    this.actionType = paramJceInputStream.read(this.actionType, 4, false);
    this.action_url = paramJceInputStream.readString(5, false);
    this.banner_type = paramJceInputStream.read(this.banner_type, 6, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 0);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 2);
    }
    if (this.button_title != null) {
      paramJceOutputStream.write(this.button_title, 3);
    }
    paramJceOutputStream.write(this.actionType, 4);
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 5);
    }
    paramJceOutputStream.write(this.banner_type, 6);
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_upper_banner
 * JD-Core Version:    0.7.0.1
 */