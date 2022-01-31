package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_auth_get_hb_req
  extends JceStruct
{
  static Map cache_ext_info = new HashMap();
  public long cuin;
  public Map ext_info;
  public String hb_id = "";
  public short hb_type;
  public long huin;
  public int huin_type;
  
  static
  {
    cache_ext_info.put("", "");
  }
  
  public mobile_auth_get_hb_req() {}
  
  public mobile_auth_get_hb_req(long paramLong1, int paramInt, long paramLong2, String paramString, short paramShort, Map paramMap)
  {
    this.huin = paramLong1;
    this.huin_type = paramInt;
    this.cuin = paramLong2;
    this.hb_id = paramString;
    this.hb_type = paramShort;
    this.ext_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.huin = paramJceInputStream.read(this.huin, 0, true);
    this.huin_type = paramJceInputStream.read(this.huin_type, 1, false);
    this.cuin = paramJceInputStream.read(this.cuin, 2, false);
    this.hb_id = paramJceInputStream.readString(3, false);
    this.hb_type = paramJceInputStream.read(this.hb_type, 4, false);
    this.ext_info = ((Map)paramJceInputStream.read(cache_ext_info, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.huin, 0);
    paramJceOutputStream.write(this.huin_type, 1);
    paramJceOutputStream.write(this.cuin, 2);
    if (this.hb_id != null) {
      paramJceOutputStream.write(this.hb_id, 3);
    }
    paramJceOutputStream.write(this.hb_type, 4);
    if (this.ext_info != null) {
      paramJceOutputStream.write(this.ext_info, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_auth_get_hb_req
 * JD-Core Version:    0.7.0.1
 */