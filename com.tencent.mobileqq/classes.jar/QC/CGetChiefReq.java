package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CGetChiefReq
  extends JceStruct
{
  static Map<String, String> cache_mParams;
  static LoginInfo cache_stLogin = new LoginInfo();
  public int appid;
  public long lUid;
  public int locationtype;
  public Map<String, String> mParams;
  public LoginInfo stLogin;
  
  static
  {
    cache_mParams = new HashMap();
    cache_mParams.put("", "");
  }
  
  public CGetChiefReq() {}
  
  public CGetChiefReq(LoginInfo paramLoginInfo, int paramInt1, int paramInt2, long paramLong, Map<String, String> paramMap)
  {
    this.stLogin = paramLoginInfo;
    this.appid = paramInt1;
    this.locationtype = paramInt2;
    this.lUid = paramLong;
    this.mParams = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.locationtype = paramJceInputStream.read(this.locationtype, 2, false);
    this.lUid = paramJceInputStream.read(this.lUid, 3, false);
    this.mParams = ((Map)paramJceInputStream.read(cache_mParams, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.locationtype, 2);
    paramJceOutputStream.write(this.lUid, 3);
    if (this.mParams != null) {
      paramJceOutputStream.write(this.mParams, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.CGetChiefReq
 * JD-Core Version:    0.7.0.1
 */