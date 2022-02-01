package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends s
{
  public String Aaa;
  public String Aab;
  public String dlJ;
  public String dwg;
  public long gri;
  public String packageExt;
  public String token;
  public t zVS;
  public boolean zZX;
  public boolean zZY;
  public boolean zZZ;
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(70145);
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("true_name", paramString1);
    localHashMap.put("identify_card", paramString2);
    localHashMap.put("cre_type", "1");
    localHashMap.put("realname_scene", String.valueOf(paramInt));
    ad.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    setRequestData(localHashMap);
    AppMethodBeat.o(70145);
  }
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, Profession paramProfession, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8, String paramString9)
  {
    AppMethodBeat.i(70146);
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("true_name", paramString1);
    localHashMap.put("identify_card", paramString2);
    localHashMap.put("realname_scene", String.valueOf(paramInt1));
    localHashMap.put("cre_type", String.valueOf(paramInt2));
    if (paramProfession != null)
    {
      localHashMap.put("profession_name", paramProfession.Aap);
      localHashMap.put("profession_type", String.valueOf(paramProfession.Aaq));
    }
    localHashMap.put("user_country", paramString3);
    localHashMap.put("user_province", paramString4);
    localHashMap.put("user_city", paramString5);
    localHashMap.put("cre_expire_date", paramString6);
    localHashMap.put("creid_renewal", String.valueOf(paramLong));
    localHashMap.put("birth_date", paramString7);
    localHashMap.put("nationality", paramString8);
    localHashMap.put("session_id", paramString9);
    ad.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt1) });
    setRequestData(localHashMap);
    AppMethodBeat.o(70146);
  }
  
  public final void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(70148);
    Object localObject2 = getCommReqResp();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).gUU = new dbk();
      ((b.a)localObject1).gUV = new dbl();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
      ((b.a)localObject1).funcId = 1616;
      ((b.a)localObject1).reqCmdId = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((b.a)localObject1).atI();
      ((b)localObject1).setIsUserCmd(true);
    }
    localObject2 = (dbk)((b)localObject1).gUS.gUX;
    if (paramBoolean2) {
      ((dbk)localObject2).DEt = 1;
    }
    setCommReqResp((b)localObject1);
    AppMethodBeat.o(70148);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(70152);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(70152);
    return i;
  }
  
  public final int doSceneSimulately(b paramb, e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(70151);
    paramb = (dbk)paramb.gUS.gUX;
    if (paramb.DEu != null) {
      new String(paramb.DEu.getBufferToBytes());
    }
    if (paramb.DWE != null) {
      new String(paramb.DWE.getBufferToBytes());
    }
    aj.getContext();
    getPayCgicmd();
    ae.fke();
    AppMethodBeat.o(70151);
    return -1;
  }
  
  public final String getEncryptUrl(String paramString)
  {
    AppMethodBeat.i(70149);
    paramString = TenpayUtil.signWith3Des(paramString);
    AppMethodBeat.o(70149);
    return paramString;
  }
  
  public final int getPayCgicmd()
  {
    return 0;
  }
  
  public final x getRetModel(b paramb)
  {
    AppMethodBeat.i(70150);
    paramb = (dbl)paramb.gUT.gUX;
    x localx = new x();
    localx.DEy = paramb.DEy;
    localx.DEx = paramb.DEx;
    localx.DEw = paramb.DEw;
    localx.DEv = paramb.DEv;
    localx.oXw = paramb.DWG;
    localx.IdR = paramb.DWF;
    AppMethodBeat.o(70150);
    return localx;
  }
  
  public final int getType()
  {
    return 1616;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70147);
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.zZX = paramJSONObject.optBoolean("is_need_bind");
      this.zZY = paramJSONObject.optBoolean("is_need_face");
      this.zZZ = paramJSONObject.optBoolean("is_need_Laund");
      this.Aaa = paramJSONObject.optString("laundh5");
      this.gri = paramJSONObject.optLong("scene");
      this.packageExt = paramJSONObject.optString("package", "");
      this.dwg = paramJSONObject.optString("packagesign", "");
      this.Aab = paramJSONObject.optString("addbankword");
      this.dlJ = this.token;
      this.zVS = t.bc(paramJSONObject);
    }
    AppMethodBeat.o(70147);
  }
  
  public final void putToReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dbk)paramb.gUS.gUX).DEu = paramSKBuiltinBuffer_t;
  }
  
  public final void putToWXReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dbk)paramb.gUS.gUX).DWE = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.g
 * JD-Core Version:    0.7.0.1
 */