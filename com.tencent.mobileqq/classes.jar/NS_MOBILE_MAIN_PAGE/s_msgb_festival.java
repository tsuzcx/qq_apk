package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_msgb_festival
  extends JceStruct
{
  static Map<String, String> cache_extendinfo = new HashMap();
  public String content = "";
  public Map<String, String> extendinfo;
  public boolean is_festival = true;
  
  static
  {
    cache_extendinfo.put("", "");
  }
  
  public s_msgb_festival() {}
  
  public s_msgb_festival(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    this.content = paramString;
    this.is_festival = paramBoolean;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.content = paramJceInputStream.readString(0, false);
    this.is_festival = paramJceInputStream.read(this.is_festival, 1, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 0);
    }
    paramJceOutputStream.write(this.is_festival, 1);
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_msgb_festival
 * JD-Core Version:    0.7.0.1
 */