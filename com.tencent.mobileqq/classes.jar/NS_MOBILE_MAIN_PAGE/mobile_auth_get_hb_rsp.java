package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_auth_get_hb_rsp
  extends JceStruct
{
  static callback_info cache_hb_info = new callback_info();
  static Map<Long, String> cache_uin_nick = new HashMap();
  public int auth_res = 0;
  public long channel = 0L;
  public String encryp_key = "";
  public String err_msg = "";
  public callback_info hb_info = null;
  public int operate_type = 0;
  public Map<Long, String> uin_nick = null;
  
  static
  {
    cache_uin_nick.put(Long.valueOf(0L), "");
  }
  
  public mobile_auth_get_hb_rsp() {}
  
  public mobile_auth_get_hb_rsp(int paramInt1, String paramString1, long paramLong, callback_info paramcallback_info, String paramString2, int paramInt2, Map<Long, String> paramMap)
  {
    this.auth_res = paramInt1;
    this.encryp_key = paramString1;
    this.channel = paramLong;
    this.hb_info = paramcallback_info;
    this.err_msg = paramString2;
    this.operate_type = paramInt2;
    this.uin_nick = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.auth_res = paramJceInputStream.read(this.auth_res, 0, true);
    this.encryp_key = paramJceInputStream.readString(1, false);
    this.channel = paramJceInputStream.read(this.channel, 2, false);
    this.hb_info = ((callback_info)paramJceInputStream.read(cache_hb_info, 3, false));
    this.err_msg = paramJceInputStream.readString(4, false);
    this.operate_type = paramJceInputStream.read(this.operate_type, 5, false);
    this.uin_nick = ((Map)paramJceInputStream.read(cache_uin_nick, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.auth_res, 0);
    Object localObject = this.encryp_key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.channel, 2);
    localObject = this.hb_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.err_msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.operate_type, 5);
    localObject = this.uin_nick;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_auth_get_hb_rsp
 * JD-Core Version:    0.7.0.1
 */