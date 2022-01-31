package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class callback_info
  extends JceStruct
{
  static Map cache_trans_info = new HashMap();
  public String content = "";
  public String h5hb_url = "";
  public boolean has_grabed = true;
  public short hb_type;
  public Map trans_info;
  
  static
  {
    cache_trans_info.put("", "");
  }
  
  public callback_info() {}
  
  public callback_info(short paramShort, boolean paramBoolean, String paramString1, Map paramMap, String paramString2)
  {
    this.hb_type = paramShort;
    this.has_grabed = paramBoolean;
    this.content = paramString1;
    this.trans_info = paramMap;
    this.h5hb_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hb_type = paramJceInputStream.read(this.hb_type, 0, false);
    this.has_grabed = paramJceInputStream.read(this.has_grabed, 1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.trans_info = ((Map)paramJceInputStream.read(cache_trans_info, 3, false));
    this.h5hb_url = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hb_type, 0);
    paramJceOutputStream.write(this.has_grabed, 1);
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    if (this.trans_info != null) {
      paramJceOutputStream.write(this.trans_info, 3);
    }
    if (this.h5hb_url != null) {
      paramJceOutputStream.write(this.h5hb_url, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.callback_info
 * JD-Core Version:    0.7.0.1
 */