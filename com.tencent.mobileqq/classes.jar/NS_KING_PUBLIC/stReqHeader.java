package NS_KING_PUBLIC;

import android.support.annotation.Nullable;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stReqHeader
  extends JceStruct
{
  static stAuth cache_authInfo = new stAuth();
  static Map<String, String> cache_mapExt = new HashMap();
  private static final long serialVersionUID = 0L;
  public int appid = 0;
  public int appversion = 0;
  @Nullable
  public stAuth authInfo = null;
  @Nullable
  public String device_info = "";
  @Nullable
  public String h265key = "";
  public int iAppVersion = 0;
  public int iChid = 0;
  @Nullable
  public Map<String, String> mapExt = null;
  @Nullable
  public String person_id = "";
  @Nullable
  public String platform = "";
  @Nullable
  public String strQua = "";
  @Nullable
  public String user_ip = "";
  
  static
  {
    cache_mapExt.put("", "");
  }
  
  public stReqHeader() {}
  
  public stReqHeader(stAuth paramstAuth)
  {
    this.authInfo = paramstAuth;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt, String paramString)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt;
    this.person_id = paramString;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt, String paramString1, String paramString2)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt;
    this.person_id = paramString1;
    this.platform = paramString2;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt1;
    this.person_id = paramString1;
    this.platform = paramString2;
    this.appversion = paramInt2;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt1;
    this.person_id = paramString1;
    this.platform = paramString2;
    this.appversion = paramInt2;
    this.user_ip = paramString3;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt1;
    this.person_id = paramString1;
    this.platform = paramString2;
    this.appversion = paramInt2;
    this.user_ip = paramString3;
    this.strQua = paramString4;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt1;
    this.person_id = paramString1;
    this.platform = paramString2;
    this.appversion = paramInt2;
    this.user_ip = paramString3;
    this.strQua = paramString4;
    this.device_info = paramString5;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt1;
    this.person_id = paramString1;
    this.platform = paramString2;
    this.appversion = paramInt2;
    this.user_ip = paramString3;
    this.strQua = paramString4;
    this.device_info = paramString5;
    this.h265key = paramString6;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt1;
    this.person_id = paramString1;
    this.platform = paramString2;
    this.appversion = paramInt2;
    this.user_ip = paramString3;
    this.strQua = paramString4;
    this.device_info = paramString5;
    this.h265key = paramString6;
    this.appid = paramInt3;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, Map<String, String> paramMap)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt1;
    this.person_id = paramString1;
    this.platform = paramString2;
    this.appversion = paramInt2;
    this.user_ip = paramString3;
    this.strQua = paramString4;
    this.device_info = paramString5;
    this.h265key = paramString6;
    this.appid = paramInt3;
    this.mapExt = paramMap;
  }
  
  public stReqHeader(stAuth paramstAuth, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, Map<String, String> paramMap, int paramInt4)
  {
    this.authInfo = paramstAuth;
    this.iChid = paramInt1;
    this.person_id = paramString1;
    this.platform = paramString2;
    this.appversion = paramInt2;
    this.user_ip = paramString3;
    this.strQua = paramString4;
    this.device_info = paramString5;
    this.h265key = paramString6;
    this.appid = paramInt3;
    this.mapExt = paramMap;
    this.iAppVersion = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.authInfo = ((stAuth)paramJceInputStream.read(cache_authInfo, 0, false));
    this.iChid = paramJceInputStream.read(this.iChid, 1, false);
    this.person_id = paramJceInputStream.readString(2, false);
    this.platform = paramJceInputStream.readString(3, false);
    this.appversion = paramJceInputStream.read(this.appversion, 4, false);
    this.user_ip = paramJceInputStream.readString(5, false);
    this.strQua = paramJceInputStream.readString(6, false);
    this.device_info = paramJceInputStream.readString(7, false);
    this.h265key = paramJceInputStream.readString(8, false);
    this.appid = paramJceInputStream.read(this.appid, 9, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 10, false));
    this.iAppVersion = paramJceInputStream.read(this.iAppVersion, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.authInfo != null) {
      paramJceOutputStream.write(this.authInfo, 0);
    }
    paramJceOutputStream.write(this.iChid, 1);
    if (this.person_id != null) {
      paramJceOutputStream.write(this.person_id, 2);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 3);
    }
    paramJceOutputStream.write(this.appversion, 4);
    if (this.user_ip != null) {
      paramJceOutputStream.write(this.user_ip, 5);
    }
    if (this.strQua != null) {
      paramJceOutputStream.write(this.strQua, 6);
    }
    if (this.device_info != null) {
      paramJceOutputStream.write(this.device_info, 7);
    }
    if (this.h265key != null) {
      paramJceOutputStream.write(this.h265key, 8);
    }
    paramJceOutputStream.write(this.appid, 9);
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 10);
    }
    paramJceOutputStream.write(this.iAppVersion, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_PUBLIC.stReqHeader
 * JD-Core Version:    0.7.0.1
 */