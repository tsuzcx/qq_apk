package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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
  public v OHH;
  public boolean OLM;
  public boolean OLN;
  public boolean OLO;
  public String OLP;
  public String OLQ;
  public String fHb;
  public String fSC;
  public long kVd;
  public String packageExt;
  public String token;
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(70145);
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("true_name", paramString1);
    localHashMap.put("identify_card", paramString2);
    localHashMap.put("cre_type", "1");
    localHashMap.put("realname_scene", String.valueOf(paramInt));
    Log.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
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
      localHashMap.put("profession_name", paramProfession.OLY);
      localHashMap.put("profession_type", String.valueOf(paramProfession.OLZ));
    }
    localHashMap.put("user_country", paramString3);
    localHashMap.put("user_province", paramString4);
    localHashMap.put("user_city", paramString5);
    localHashMap.put("cre_expire_date", paramString6);
    localHashMap.put("creid_renewal", String.valueOf(paramLong));
    localHashMap.put("birth_date", paramString7);
    localHashMap.put("nationality", paramString8);
    localHashMap.put("session_id", paramString9);
    Log.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt1) });
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
      localObject1 = new d.a();
      ((d.a)localObject1).lBU = new erc();
      ((d.a)localObject1).lBV = new erd();
      ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
      ((d.a)localObject1).funcId = 1616;
      ((d.a)localObject1).lBW = 185;
      ((d.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((d.a)localObject1).bgN();
      ((d)localObject1).setIsUserCmd(true);
    }
    localObject2 = (erc)d.b.b(((d)localObject1).lBR);
    if (paramBoolean2) {
      ((erc)localObject2).TrE = 1;
    }
    setCommReqResp((d)localObject1);
    AppMethodBeat.o(70148);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(70152);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(70152);
    return i;
  }
  
  public final int doSceneSimulately(d paramd, com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(70151);
    paramd = (erc)d.b.b(paramd.lBR);
    if (paramd.TrF != null) {
      new String(paramd.TrF.Tkb.UH);
    }
    if (paramd.TRP != null) {
      new String(paramd.TRP.Tkb.UH);
    }
    MMApplicationContext.getContext();
    getPayCgicmd();
    ae.iiZ();
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
  
  public final x getRetModel(d paramd)
  {
    AppMethodBeat.i(70150);
    paramd = (erd)d.c.b(paramd.lBS);
    x localx = new x();
    localx.TrJ = paramd.TrJ;
    localx.TrI = paramd.TrI;
    localx.TrH = paramd.TrH;
    localx.TrG = paramd.TrG;
    localx.vhu = paramd.TRR;
    localx.YVB = paramd.TRQ;
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
      this.OLM = paramJSONObject.optBoolean("is_need_bind");
      this.OLN = paramJSONObject.optBoolean("is_need_face");
      this.OLO = paramJSONObject.optBoolean("is_need_Laund");
      this.OLP = paramJSONObject.optString("laundh5");
      this.kVd = paramJSONObject.optLong("scene");
      this.packageExt = paramJSONObject.optString("package", "");
      this.fSC = paramJSONObject.optString("packagesign", "");
      this.OLQ = paramJSONObject.optString("addbankword");
      this.fHb = this.token;
      this.OHH = v.bX(paramJSONObject);
    }
    AppMethodBeat.o(70147);
  }
  
  public final void putToReqText(d paramd, eae parameae)
  {
    AppMethodBeat.i(197100);
    ((erc)d.b.b(paramd.lBR)).TrF = parameae;
    AppMethodBeat.o(197100);
  }
  
  public final void putToWXReqText(d paramd, eae parameae)
  {
    AppMethodBeat.i(197101);
    ((erc)d.b.b(paramd.lBR)).TRP = parameae;
    AppMethodBeat.o(197101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.g
 * JD-Core Version:    0.7.0.1
 */