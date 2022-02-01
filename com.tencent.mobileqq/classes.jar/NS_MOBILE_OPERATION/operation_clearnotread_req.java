package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_clearnotread_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_mapEx;
  public int appid = 0;
  public Map<Integer, String> busi_param = null;
  public int clear_type = 0;
  public Map<String, String> mapEx = null;
  public long uin = 0L;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_mapEx = new HashMap();
    cache_mapEx.put("", "");
  }
  
  public operation_clearnotread_req() {}
  
  public operation_clearnotread_req(int paramInt1, long paramLong, int paramInt2, Map<Integer, String> paramMap, Map<String, String> paramMap1)
  {
    this.appid = paramInt1;
    this.uin = paramLong;
    this.clear_type = paramInt2;
    this.busi_param = paramMap;
    this.mapEx = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.clear_type = paramJceInputStream.read(this.clear_type, 2, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 3, false));
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.clear_type, 2);
    Map localMap = this.busi_param;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 3);
    }
    localMap = this.mapEx;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_clearnotread_req
 * JD-Core Version:    0.7.0.1
 */