package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import org.json.JSONObject;

public final class k
  extends j
{
  public String bXA = "";
  public String cdi;
  public String packageName = "";
  public String qoq;
  public int qor;
  public int qos = -1;
  public int qot = -1;
  public int scene = -1;
  
  public k(String paramString1, int paramInt, String paramString2)
  {
    this.qoq = paramString1;
    this.qor = paramInt;
    this.cdi = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("cre_id", paramString1);
    localHashMap.put("cre_type", String.valueOf(paramInt));
    localHashMap.put("true_name", paramString2);
    localHashMap.put("verifyScene", "1");
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 2784;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneVerifyUserRealNameInfo", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if (paramInt == 0)
    {
      paramJSONObject.optString("retcode");
      paramJSONObject.optString("retmsg");
      this.qos = paramJSONObject.optInt("is_support_face", 0);
      this.scene = paramJSONObject.optInt("scene", 0);
      this.packageName = paramJSONObject.optString("package");
      this.qot = paramJSONObject.optInt("is_need_cert");
      this.bXA = paramJSONObject.optString("packagesign");
    }
  }
  
  public final int aEC()
  {
    return 2784;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/verifyuserrealnameinfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.k
 * JD-Core Version:    0.7.0.1
 */