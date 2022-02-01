package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.protocal.protobuf.fmj;
import com.tencent.mm.protocal.protobuf.fmk;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.model.af;
import com.tencent.mm.wallet_core.model.s;
import com.tencent.mm.wallet_core.model.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends s
{
  public String VBA;
  public String VBB;
  public boolean VBx;
  public boolean VBy;
  public boolean VBz;
  public v Vxt;
  public String hMy;
  public String hYz;
  public long nAz;
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
      localHashMap.put("profession_name", paramProfession.VBJ);
      localHashMap.put("profession_type", String.valueOf(paramProfession.VBK));
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
      localObject1 = new c.a();
      ((c.a)localObject1).otE = new fmj();
      ((c.a)localObject1).otF = new fmk();
      ((c.a)localObject1).uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
      ((c.a)localObject1).funcId = 1616;
      ((c.a)localObject1).otG = 185;
      ((c.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((c.a)localObject1).bEF();
      ((c)localObject1).setIsUserCmd(true);
    }
    localObject2 = (fmj)c.b.b(((c)localObject1).otB);
    if (paramBoolean2) {
      ((fmj)localObject2).aaFQ = 1;
    }
    setCommReqResp((c)localObject1);
    AppMethodBeat.o(70148);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(70152);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(70152);
    return i;
  }
  
  public final int doSceneSimulately(c paramc, com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(70151);
    paramg = (fmj)c.b.b(paramc.otB);
    if (paramg.aaFR != null) {
      new String(paramg.aaFR.aaxD.Op);
    }
    if (paramg.abio != null) {
      new String(paramg.abio.aaxD.Op);
    }
    MMApplicationContext.getContext();
    getPayCgicmd();
    paramh = af.jOV();
    if (paramh != null)
    {
      paramg = (fmk)c.c.b(paramc.otC);
      byte[] arrayOfByte = paramh.getBytes();
      paramg.aaFS = new gol().df(arrayOfByte);
      paramg.aaFV = getPayCgicmd();
      paramg.aaFT = 0;
      try
      {
        paramh = new JSONObject(paramh);
        paramg.abip = paramh.optInt("TenpayErrType");
        paramg.abiq = paramh.optString("TenpayErrMsg");
        onGYNetEnd(1, 0, 0, "", paramc, null);
        AppMethodBeat.o(70151);
        return 1;
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneRealNameVerify", paramg, "", new Object[0]);
        }
      }
    }
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
  
  public final x getRetModel(c paramc)
  {
    AppMethodBeat.i(70150);
    paramc = (fmk)c.c.b(paramc.otC);
    x localx = new x();
    localx.aaFV = paramc.aaFV;
    localx.aaFU = paramc.aaFU;
    localx.aaFT = paramc.aaFT;
    localx.aaFS = paramc.aaFS;
    localx.ytw = paramc.abiq;
    localx.agTv = paramc.abip;
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
      this.VBx = paramJSONObject.optBoolean("is_need_bind");
      this.VBy = paramJSONObject.optBoolean("is_need_face");
      this.VBz = paramJSONObject.optBoolean("is_need_Laund");
      this.VBA = paramJSONObject.optString("laundh5");
      this.nAz = paramJSONObject.optLong("scene");
      this.packageExt = paramJSONObject.optString("package", "");
      this.hYz = paramJSONObject.optString("packagesign", "");
      this.VBB = paramJSONObject.optString("addbankword");
      this.hMy = this.token;
      this.Vxt = v.ct(paramJSONObject);
    }
    AppMethodBeat.o(70147);
  }
  
  public final void putToReqText(c paramc, gol paramgol)
  {
    AppMethodBeat.i(301390);
    ((fmj)c.b.b(paramc.otB)).aaFR = paramgol;
    AppMethodBeat.o(301390);
  }
  
  public final void putToWXReqText(c paramc, gol paramgol)
  {
    AppMethodBeat.i(301393);
    ((fmj)c.b.b(paramc.otB)).abio = paramgol;
    AppMethodBeat.o(301393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.g
 * JD-Core Version:    0.7.0.1
 */