package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_theme
  extends JceStruct
{
  static Map cache_extendinfo;
  static Map cache_photourl = new HashMap();
  public Map extendinfo;
  public boolean is_deepcolor = true;
  public boolean is_optpalette = true;
  public String major_forecolor = "";
  public String minor_forecolor = "";
  public Map photourl;
  
  static
  {
    s_picurl locals_picurl = new s_picurl();
    cache_photourl.put(Integer.valueOf(0), locals_picurl);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public cell_theme() {}
  
  public cell_theme(String paramString1, String paramString2, boolean paramBoolean1, Map paramMap1, boolean paramBoolean2, Map paramMap2)
  {
    this.major_forecolor = paramString1;
    this.minor_forecolor = paramString2;
    this.is_deepcolor = paramBoolean1;
    this.photourl = paramMap1;
    this.is_optpalette = paramBoolean2;
    this.extendinfo = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.major_forecolor = paramJceInputStream.readString(0, false);
    this.minor_forecolor = paramJceInputStream.readString(1, false);
    this.is_deepcolor = paramJceInputStream.read(this.is_deepcolor, 2, false);
    this.photourl = ((Map)paramJceInputStream.read(cache_photourl, 3, false));
    this.is_optpalette = paramJceInputStream.read(this.is_optpalette, 4, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.major_forecolor != null) {
      paramJceOutputStream.write(this.major_forecolor, 0);
    }
    if (this.minor_forecolor != null) {
      paramJceOutputStream.write(this.minor_forecolor, 1);
    }
    paramJceOutputStream.write(this.is_deepcolor, 2);
    if (this.photourl != null) {
      paramJceOutputStream.write(this.photourl, 3);
    }
    paramJceOutputStream.write(this.is_optpalette, 4);
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_theme
 * JD-Core Version:    0.7.0.1
 */