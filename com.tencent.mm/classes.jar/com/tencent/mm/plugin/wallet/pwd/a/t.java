package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class t
  extends m
{
  public String DcL;
  public int DcM;
  public int DcN;
  public int DcO;
  public String dGY;
  public String dOf;
  public String packageName;
  public int scene;
  
  public t(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(69576);
    this.DcN = -1;
    this.scene = -1;
    this.packageName = "";
    this.DcO = -1;
    this.dGY = "";
    this.DcL = paramString1;
    this.DcM = paramInt;
    this.dOf = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("cre_id", q.encode(paramString1));
    localHashMap.put("cre_type", q.encode(String.valueOf(paramInt)));
    localHashMap.put("true_name", q.encode(paramString2));
    localHashMap.put("verifyScene", "1");
    setRequestData(localHashMap);
    AppMethodBeat.o(69576);
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
    AppMethodBeat.i(69577);
    ae.i("MicroMsg.NetSceneVerifyUserRealNameInfo", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if (paramInt == 0)
    {
      paramJSONObject.optString("retcode");
      paramJSONObject.optString("retmsg");
      this.DcN = paramJSONObject.optInt("is_support_face", 0);
      this.scene = paramJSONObject.optInt("scene", 0);
      this.packageName = paramJSONObject.optString("package");
      this.DcO = paramJSONObject.optInt("is_need_cert");
      this.dGY = paramJSONObject.optString("packagesign");
    }
    AppMethodBeat.o(69577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.t
 * JD-Core Version:    0.7.0.1
 */