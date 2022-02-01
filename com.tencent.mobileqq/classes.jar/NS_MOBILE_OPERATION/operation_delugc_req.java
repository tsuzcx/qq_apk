package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_delugc_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_mapEx;
  public int appid = 0;
  public Map<Integer, String> busi_param = null;
  public String content = "";
  public int isverified = 0;
  public Map<String, String> mapEx = null;
  public long ownuin = 0L;
  public String srcId = "";
  public String srcSubid = "";
  public long uin = 0L;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_mapEx = new HashMap();
    cache_mapEx.put("", "");
  }
  
  public operation_delugc_req() {}
  
  public operation_delugc_req(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt2, Map<Integer, String> paramMap, Map<String, String> paramMap1)
  {
    this.appid = paramInt1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.srcId = paramString1;
    this.srcSubid = paramString2;
    this.content = paramString3;
    this.isverified = paramInt2;
    this.busi_param = paramMap;
    this.mapEx = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.srcId = paramJceInputStream.readString(3, false);
    this.srcSubid = paramJceInputStream.readString(4, false);
    this.content = paramJceInputStream.readString(5, false);
    this.isverified = paramJceInputStream.read(this.isverified, 6, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 7, false));
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    Object localObject = this.srcId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.srcSubid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.isverified, 6);
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
    localObject = this.mapEx;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_delugc_req
 * JD-Core Version:    0.7.0.1
 */