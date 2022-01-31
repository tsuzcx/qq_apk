package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class query_order_req
  extends JceStruct
{
  static Map cache_extendinfo = new HashMap();
  public Map extendinfo;
  public String strIMSI = "";
  public String strIphoneNum = "";
  public long uin;
  
  static
  {
    cache_extendinfo.put("", "");
  }
  
  public query_order_req() {}
  
  public query_order_req(long paramLong, String paramString1, String paramString2, Map paramMap)
  {
    this.uin = paramLong;
    this.strIphoneNum = paramString1;
    this.strIMSI = paramString2;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.strIphoneNum = paramJceInputStream.readString(1, false);
    this.strIMSI = paramJceInputStream.readString(2, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.strIphoneNum != null) {
      paramJceOutputStream.write(this.strIphoneNum, 1);
    }
    if (this.strIMSI != null) {
      paramJceOutputStream.write(this.strIMSI, 2);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.query_order_req
 * JD-Core Version:    0.7.0.1
 */