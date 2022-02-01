package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class BatchGetFacadeRsp
  extends JceStruct
{
  static Map<Long, UserFacadeInfo> cache_info = new HashMap();
  public Map<Long, UserFacadeInfo> info = null;
  public String jumpUrl = "";
  
  static
  {
    UserFacadeInfo localUserFacadeInfo = new UserFacadeInfo();
    cache_info.put(Long.valueOf(0L), localUserFacadeInfo);
  }
  
  public BatchGetFacadeRsp() {}
  
  public BatchGetFacadeRsp(Map<Long, UserFacadeInfo> paramMap, String paramString)
  {
    this.info = paramMap;
    this.jumpUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.info = ((Map)paramJceInputStream.read(cache_info, 0, false));
    this.jumpUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.info != null) {
      paramJceOutputStream.write(this.info, 0);
    }
    if (this.jumpUrl != null) {
      paramJceOutputStream.write(this.jumpUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     FACADE_DIY.BatchGetFacadeRsp
 * JD-Core Version:    0.7.0.1
 */