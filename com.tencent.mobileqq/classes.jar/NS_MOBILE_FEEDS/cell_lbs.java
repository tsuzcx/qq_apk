package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_lbs
  extends JceStruct
{
  static Map<String, String> cache_extendinfo;
  static s_gps cache_gps = new s_gps();
  public Map<String, String> extendinfo;
  public s_gps gps;
  public String location = "";
  
  static
  {
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public cell_lbs() {}
  
  public cell_lbs(s_gps params_gps, String paramString, Map<String, String> paramMap)
  {
    this.gps = params_gps;
    this.location = paramString;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.gps = ((s_gps)paramJceInputStream.read(cache_gps, 0, false));
    this.location = paramJceInputStream.readString(1, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.gps != null) {
      paramJceOutputStream.write(this.gps, 0);
    }
    if (this.location != null) {
      paramJceOutputStream.write(this.location, 1);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_lbs
 * JD-Core Version:    0.7.0.1
 */