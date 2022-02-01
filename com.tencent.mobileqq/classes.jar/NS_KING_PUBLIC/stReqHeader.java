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
    Object localObject = this.authInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.iChid, 1);
    localObject = this.person_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.platform;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.appversion, 4);
    localObject = this.user_ip;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.strQua;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.device_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.h265key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.appid, 9);
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 10);
    }
    paramJceOutputStream.write(this.iAppVersion, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_PUBLIC.stReqHeader
 * JD-Core Version:    0.7.0.1
 */