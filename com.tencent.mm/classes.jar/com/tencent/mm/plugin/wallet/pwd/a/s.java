package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class s
  extends m
{
  public String VpE;
  public int VpF;
  public int VpG;
  public int VpH;
  public String hYz;
  public String igz;
  public String packageName;
  public int scene;
  
  public s(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(69576);
    this.VpG = -1;
    this.scene = -1;
    this.packageName = "";
    this.VpH = -1;
    this.hYz = "";
    this.VpE = paramString1;
    this.VpF = paramInt;
    this.igz = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("cre_id", r.cg(paramString1));
    localHashMap.put("cre_type", r.cg(String.valueOf(paramInt)));
    localHashMap.put("true_name", r.cg(paramString2));
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
    Log.i("MicroMsg.NetSceneVerifyUserRealNameInfo", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if (paramInt == 0)
    {
      paramJSONObject.optString("retcode");
      paramJSONObject.optString("retmsg");
      this.VpG = paramJSONObject.optInt("is_support_face", 0);
      this.scene = paramJSONObject.optInt("scene", 0);
      this.packageName = paramJSONObject.optString("package");
      this.VpH = paramJSONObject.optInt("is_need_cert");
      this.hYz = paramJSONObject.optString("packagesign");
    }
    AppMethodBeat.o(69577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.s
 * JD-Core Version:    0.7.0.1
 */