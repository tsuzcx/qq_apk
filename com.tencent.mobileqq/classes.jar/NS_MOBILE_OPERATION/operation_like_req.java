package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_like_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_bypass_param;
  static Map<String, byte[]> cache_bypass_param_binary;
  static Map<Integer, String> cache_extern_param;
  public int action;
  public int appid;
  public Map<Integer, String> busi_param;
  public Map<String, String> bypass_param;
  public Map<String, byte[]> bypass_param_binary;
  public String curkey = "";
  public Map<Integer, String> extern_param;
  public long hostuin;
  public long uin;
  public String unikey = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_extern_param = new HashMap();
    cache_extern_param.put(Integer.valueOf(0), "");
    cache_bypass_param = new HashMap();
    cache_bypass_param.put("", "");
    cache_bypass_param_binary = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_bypass_param_binary.put("", arrayOfByte);
  }
  
  public operation_like_req() {}
  
  public operation_like_req(long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, Map<Integer, String> paramMap1, long paramLong2, Map<Integer, String> paramMap2, Map<String, String> paramMap, Map<String, byte[]> paramMap3)
  {
    this.uin = paramLong1;
    this.curkey = paramString1;
    this.unikey = paramString2;
    this.action = paramInt1;
    this.appid = paramInt2;
    this.busi_param = paramMap1;
    this.hostuin = paramLong2;
    this.extern_param = paramMap2;
    this.bypass_param = paramMap;
    this.bypass_param_binary = paramMap3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.curkey = paramJceInputStream.readString(1, false);
    this.unikey = paramJceInputStream.readString(2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.appid = paramJceInputStream.read(this.appid, 4, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.hostuin = paramJceInputStream.read(this.hostuin, 6, false);
    this.extern_param = ((Map)paramJceInputStream.read(cache_extern_param, 7, false));
    this.bypass_param = ((Map)paramJceInputStream.read(cache_bypass_param, 8, false));
    this.bypass_param_binary = ((Map)paramJceInputStream.read(cache_bypass_param_binary, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.curkey != null) {
      paramJceOutputStream.write(this.curkey, 1);
    }
    if (this.unikey != null) {
      paramJceOutputStream.write(this.unikey, 2);
    }
    paramJceOutputStream.write(this.action, 3);
    paramJceOutputStream.write(this.appid, 4);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
    paramJceOutputStream.write(this.hostuin, 6);
    if (this.extern_param != null) {
      paramJceOutputStream.write(this.extern_param, 7);
    }
    if (this.bypass_param != null) {
      paramJceOutputStream.write(this.bypass_param, 8);
    }
    if (this.bypass_param_binary != null) {
      paramJceOutputStream.write(this.bypass_param_binary, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_like_req
 * JD-Core Version:    0.7.0.1
 */