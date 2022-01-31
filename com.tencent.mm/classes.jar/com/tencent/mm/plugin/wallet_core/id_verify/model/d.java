package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.v;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends q
{
  public String cFw;
  public long foo;
  public String packageExt;
  public String token;
  public boolean ueb;
  public boolean uec;
  public boolean ued;
  public String uee;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46641);
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("true_name", paramString1);
    localHashMap.put("identify_card", paramString2);
    localHashMap.put("cre_type", "1");
    localHashMap.put("realname_scene", String.valueOf(paramInt));
    ab.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    setRequestData(localHashMap);
    AppMethodBeat.o(46641);
  }
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, Profession paramProfession, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8)
  {
    AppMethodBeat.i(142472);
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("true_name", paramString1);
    localHashMap.put("identify_card", paramString2);
    localHashMap.put("realname_scene", String.valueOf(paramInt1));
    localHashMap.put("cre_type", String.valueOf(paramInt2));
    if (paramProfession != null)
    {
      localHashMap.put("profession_name", paramProfession.ues);
      localHashMap.put("profession_type", String.valueOf(paramProfession.uet));
    }
    localHashMap.put("user_country", paramString3);
    localHashMap.put("user_province", paramString4);
    localHashMap.put("user_city", paramString5);
    localHashMap.put("cre_expire_date", paramString6);
    localHashMap.put("creid_renewal", String.valueOf(paramLong));
    localHashMap.put("birth_date", paramString7);
    localHashMap.put("nationality", paramString8);
    ab.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt1) });
    setRequestData(localHashMap);
    AppMethodBeat.o(142472);
  }
  
  public final void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(46643);
    Object localObject2 = getCommReqResp();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).fsX = new cjs();
      ((b.a)localObject1).fsY = new cjt();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
      ((b.a)localObject1).funcId = 1616;
      ((b.a)localObject1).reqCmdId = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((b.a)localObject1).ado();
      ((b)localObject1).setIsUserCmd(true);
    }
    localObject2 = (cjs)((b)localObject1).fsV.fta;
    if (paramBoolean2) {
      ((cjs)localObject2).xkJ = 1;
    }
    setCommReqResp((b)localObject1);
    AppMethodBeat.o(46643);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46646);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46646);
    return i;
  }
  
  public final int doSceneSimulately(b paramb, e parame, f paramf)
  {
    AppMethodBeat.i(142473);
    paramb = (cjs)paramb.fsV.fta;
    if (paramb.xkK != null) {
      new String(paramb.xkK.getBufferToBytes());
    }
    if (paramb.xAv != null) {
      new String(paramb.xAv.getBufferToBytes());
    }
    ah.getContext();
    getPayCgicmd();
    ac.dSx();
    AppMethodBeat.o(142473);
    return -1;
  }
  
  public final String getEncryptUrl(String paramString)
  {
    AppMethodBeat.i(46644);
    paramString = TenpayUtil.signWith3Des(paramString);
    AppMethodBeat.o(46644);
    return paramString;
  }
  
  public final int getPayCgicmd()
  {
    return 0;
  }
  
  public final v getRetModel(b paramb)
  {
    AppMethodBeat.i(46645);
    paramb = (cjt)paramb.fsW.fta;
    v localv = new v();
    localv.xkO = paramb.xkO;
    localv.xkN = paramb.xkN;
    localv.xkM = paramb.xkM;
    localv.xkL = paramb.xkL;
    localv.lGL = paramb.xAx;
    localv.AXe = paramb.xAw;
    AppMethodBeat.o(46645);
    return localv;
  }
  
  public final int getType()
  {
    return 1616;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46642);
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.ueb = paramJSONObject.optBoolean("is_need_bind");
      this.uec = paramJSONObject.optBoolean("is_need_face");
      this.ued = paramJSONObject.optBoolean("is_need_Laund");
      this.uee = paramJSONObject.optString("laundh5");
      this.foo = paramJSONObject.optLong("scene");
      this.packageExt = paramJSONObject.optString("package", "");
      this.cFw = paramJSONObject.optString("packagesign", "");
    }
    AppMethodBeat.o(46642);
  }
  
  public final void putToReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cjs)paramb.fsV.fta).xkK = paramSKBuiltinBuffer_t;
  }
  
  public final void putToWXReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cjs)paramb.fsV.fta).xAv = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.d
 * JD-Core Version:    0.7.0.1
 */