package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CGetMoreReq
  extends JceStruct
{
  static Map<String, String> cache_mParams;
  static LoginInfo cache_stLogin = new LoginInfo();
  public int appid = 0;
  public long lUid = 0L;
  public int listindex = 0;
  public int locationtype = 0;
  public Map<String, String> mParams = null;
  public int pagesize = 0;
  public LoginInfo stLogin = null;
  
  static
  {
    cache_mParams = new HashMap();
    cache_mParams.put("", "");
  }
  
  public CGetMoreReq() {}
  
  public CGetMoreReq(LoginInfo paramLoginInfo, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, Map<String, String> paramMap)
  {
    this.stLogin = paramLoginInfo;
    this.appid = paramInt1;
    this.locationtype = paramInt2;
    this.lUid = paramLong;
    this.listindex = paramInt3;
    this.pagesize = paramInt4;
    this.mParams = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.locationtype = paramJceInputStream.read(this.locationtype, 2, false);
    this.lUid = paramJceInputStream.read(this.lUid, 3, false);
    this.listindex = paramJceInputStream.read(this.listindex, 4, false);
    this.pagesize = paramJceInputStream.read(this.pagesize, 5, false);
    this.mParams = ((Map)paramJceInputStream.read(cache_mParams, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.locationtype, 2);
    paramJceOutputStream.write(this.lUid, 3);
    paramJceOutputStream.write(this.listindex, 4);
    paramJceOutputStream.write(this.pagesize, 5);
    if (this.mParams != null) {
      paramJceOutputStream.write(this.mParams, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.CGetMoreReq
 * JD-Core Version:    0.7.0.1
 */