package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class r
  extends m
{
  public String cFw;
  public String cLS;
  public String packageName;
  public int scene;
  public String tYd;
  public int tYe;
  public int tYf;
  public int tYg;
  
  public r(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46202);
    this.tYf = -1;
    this.scene = -1;
    this.packageName = "";
    this.tYg = -1;
    this.cFw = "";
    this.tYd = paramString1;
    this.tYe = paramInt;
    this.cLS = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("cre_id", q.encode(paramString1));
    localHashMap.put("cre_type", q.encode(String.valueOf(paramInt)));
    localHashMap.put("true_name", q.encode(paramString2));
    localHashMap.put("verifyScene", "1");
    setRequestData(localHashMap);
    AppMethodBeat.o(46202);
  }
  
  public final int getFuncId()
  {
    return 2784;
  }
  
  public final int getTenpayCgicmd()
  {
    return 2784;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/verifyuserrealnameinfo";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46203);
    ab.i("MicroMsg.NetSceneVerifyUserRealNameInfo", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if (paramInt == 0)
    {
      paramJSONObject.optString("retcode");
      paramJSONObject.optString("retmsg");
      this.tYf = paramJSONObject.optInt("is_support_face", 0);
      this.scene = paramJSONObject.optInt("scene", 0);
      this.packageName = paramJSONObject.optString("package");
      this.tYg = paramJSONObject.optInt("is_need_cert");
      this.cFw = paramJSONObject.optString("packagesign");
    }
    AppMethodBeat.o(46203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.r
 * JD-Core Version:    0.7.0.1
 */