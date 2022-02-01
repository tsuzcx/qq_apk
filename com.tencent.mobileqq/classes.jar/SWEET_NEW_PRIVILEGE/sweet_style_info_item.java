package SWEET_NEW_PRIVILEGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class sweet_style_info_item
  extends JceStruct
{
  static Map<String, String> cache_map_ext = new HashMap();
  public String jump_url = "";
  public long level;
  public Map<String, String> map_ext;
  public String pic_url = "";
  
  static
  {
    cache_map_ext.put("", "");
  }
  
  public sweet_style_info_item() {}
  
  public sweet_style_info_item(long paramLong, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.level = paramLong;
    this.pic_url = paramString1;
    this.jump_url = paramString2;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.level = paramJceInputStream.read(this.level, 0, false);
    this.pic_url = paramJceInputStream.readString(1, false);
    this.jump_url = paramJceInputStream.readString(2, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.level, 0);
    if (this.pic_url != null) {
      paramJceOutputStream.write(this.pic_url, 1);
    }
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 2);
    }
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SWEET_NEW_PRIVILEGE.sweet_style_info_item
 * JD-Core Version:    0.7.0.1
 */