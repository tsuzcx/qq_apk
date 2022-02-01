package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class query_order_req
  extends JceStruct
{
  static Map<String, String> cache_extendinfo = new HashMap();
  public Map<String, String> extendinfo = null;
  public String strIMSI = "";
  public String strIphoneNum = "";
  public long uin = 0L;
  
  static
  {
    cache_extendinfo.put("", "");
  }
  
  public query_order_req() {}
  
  public query_order_req(long paramLong, String paramString1, String paramString2, Map<String, String> paramMap)
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
    Object localObject = this.strIphoneNum;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.strIMSI;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.query_order_req
 * JD-Core Version:    0.7.0.1
 */