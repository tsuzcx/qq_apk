package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_visit_hb_callback_rsp
  extends JceStruct
{
  static Map<String, String> cache_ext_info = new HashMap();
  public String err_msg = "";
  public Map<String, String> ext_info = null;
  public int ret = 0;
  
  static
  {
    cache_ext_info.put("", "");
  }
  
  public mobile_visit_hb_callback_rsp() {}
  
  public mobile_visit_hb_callback_rsp(int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.ret = paramInt;
    this.err_msg = paramString;
    this.ext_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.err_msg = paramJceInputStream.readString(1, false);
    this.ext_info = ((Map)paramJceInputStream.read(cache_ext_info, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.err_msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.ext_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_visit_hb_callback_rsp
 * JD-Core Version:    0.7.0.1
 */