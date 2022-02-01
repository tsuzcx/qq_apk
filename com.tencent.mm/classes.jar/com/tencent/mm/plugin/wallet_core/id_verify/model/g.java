package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.dmk;
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
  public u COB;
  public boolean CSG;
  public boolean CSH;
  public boolean CSI;
  public String CSJ;
  public String CSK;
  public String dFT;
  public String dve;
  public long hki;
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
      localHashMap.put("profession_name", paramProfession.CSY);
      localHashMap.put("profession_type", String.valueOf(paramProfession.CSZ));
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
      ((b.a)localObject1).hNM = new dmj();
      ((b.a)localObject1).hNN = new dmk();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
      ((b.a)localObject1).funcId = 1616;
      ((b.a)localObject1).hNO = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((b.a)localObject1).aDC();
      ((b)localObject1).setIsUserCmd(true);
    }
    localObject2 = (dmj)((b)localObject1).hNK.hNQ;
    if (paramBoolean2) {
      ((dmj)localObject2).GJn = 1;
    }
    setCommReqResp((b)localObject1);
    AppMethodBeat.o(70148);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(70152);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(70152);
    return i;
  }
  
  public final int doSceneSimulately(b paramb, e parame, f paramf)
  {
    AppMethodBeat.i(70151);
    paramb = (dmj)paramb.hNK.hNQ;
    if (paramb.GJo != null) {
      new String(paramb.GJo.getBufferToBytes());
    }
    if (paramb.HdC != null) {
      new String(paramb.HdC.getBufferToBytes());
    }
    aj.getContext();
    getPayCgicmd();
    ae.fRE();
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
    paramb = (dmk)paramb.hNL.hNQ;
    x localx = new x();
    localx.GJs = paramb.GJs;
    localx.GJr = paramb.GJr;
    localx.GJq = paramb.GJq;
    localx.GJp = paramb.GJp;
    localx.qem = paramb.HdE;
    localx.Lyx = paramb.HdD;
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
      this.CSG = paramJSONObject.optBoolean("is_need_bind");
      this.CSH = paramJSONObject.optBoolean("is_need_face");
      this.CSI = paramJSONObject.optBoolean("is_need_Laund");
      this.CSJ = paramJSONObject.optString("laundh5");
      this.hki = paramJSONObject.optLong("scene");
      this.packageExt = paramJSONObject.optString("package", "");
      this.dFT = paramJSONObject.optString("packagesign", "");
      this.CSK = paramJSONObject.optString("addbankword");
      this.dve = this.token;
      this.COB = u.bm(paramJSONObject);
    }
    AppMethodBeat.o(70147);
  }
  
  public final void putToReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dmj)paramb.hNK.hNQ).GJo = paramSKBuiltinBuffer_t;
  }
  
  public final void putToWXReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dmj)paramb.hNK.hNQ).HdC = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.g
 * JD-Core Version:    0.7.0.1
 */