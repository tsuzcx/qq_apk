package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_visit_hb_callback_req
  extends JceStruct
{
  static Map<String, String> cache_trans_info = new HashMap();
  public String client_key = "";
  public String comment = "";
  public String hb_id = "";
  public short hb_type = 0;
  public Map<String, String> trans_info = null;
  public long uin = 0L;
  
  static
  {
    cache_trans_info.put("", "");
  }
  
  public mobile_visit_hb_callback_req() {}
  
  public mobile_visit_hb_callback_req(long paramLong, short paramShort, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.hb_type = paramShort;
    this.hb_id = paramString1;
    this.comment = paramString2;
    this.client_key = paramString3;
    this.trans_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.hb_type = paramJceInputStream.read(this.hb_type, 1, false);
    this.hb_id = paramJceInputStream.readString(2, false);
    this.comment = paramJceInputStream.readString(3, false);
    this.client_key = paramJceInputStream.readString(4, false);
    this.trans_info = ((Map)paramJceInputStream.read(cache_trans_info, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.hb_type, 1);
    if (this.hb_id != null) {
      paramJceOutputStream.write(this.hb_id, 2);
    }
    if (this.comment != null) {
      paramJceOutputStream.write(this.comment, 3);
    }
    if (this.client_key != null) {
      paramJceOutputStream.write(this.client_key, 4);
    }
    if (this.trans_info != null) {
      paramJceOutputStream.write(this.trans_info, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_visit_hb_callback_req
 * JD-Core Version:    0.7.0.1
 */