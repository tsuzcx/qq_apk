package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_visit_hb_callback_rsp
  extends JceStruct
{
  static Map cache_ext_info = new HashMap();
  public String err_msg = "";
  public Map ext_info;
  public int ret;
  
  static
  {
    cache_ext_info.put("", "");
  }
  
  public mobile_visit_hb_callback_rsp() {}
  
  public mobile_visit_hb_callback_rsp(int paramInt, String paramString, Map paramMap)
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
    if (this.err_msg != null) {
      paramJceOutputStream.write(this.err_msg, 1);
    }
    if (this.ext_info != null) {
      paramJceOutputStream.write(this.ext_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_visit_hb_callback_rsp
 * JD-Core Version:    0.7.0.1
 */