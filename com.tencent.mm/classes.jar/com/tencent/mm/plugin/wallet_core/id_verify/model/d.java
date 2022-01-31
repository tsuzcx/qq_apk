package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.protocal.c.bxh;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.c.t;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends o
{
  public String token;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("true_name", paramString1);
    localHashMap.put("identify_card", paramString2);
    localHashMap.put("cre_type", "1");
    localHashMap.put("realname_scene", String.valueOf(paramInt));
    y.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    D(localHashMap);
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = this.dmK;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).ecH = new bxg();
      ((b.a)localObject1).ecI = new bxh();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
      ((b.a)localObject1).ecG = 1616;
      ((b.a)localObject1).ecJ = 185;
      ((b.a)localObject1).ecK = 1000000185;
      localObject1 = ((b.a)localObject1).Kt();
      ((k)localObject1).ecZ = true;
    }
    localObject2 = (bxg)((b)localObject1).ecE.ecN;
    if (paramBoolean2) {
      ((bxg)localObject2).tlq = 1;
    }
    this.dmK = ((b)localObject1);
  }
  
  public final String Qm(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt == 0) {
      this.token = paramJSONObject.optString("token");
    }
  }
  
  public final void a(b paramb, bmk parambmk)
  {
    ((bxg)paramb.ecE.ecN).tlr = parambmk;
  }
  
  public final void b(b paramb, bmk parambmk)
  {
    ((bxg)paramb.ecE.ecN).tzn = parambmk;
  }
  
  public final int bUs()
  {
    return 0;
  }
  
  public final t e(b paramb)
  {
    paramb = (bxh)paramb.ecF.ecN;
    t localt = new t();
    localt.tlv = paramb.tlv;
    localt.tlu = paramb.tlu;
    localt.tlt = paramb.tlt;
    localt.tls = paramb.tls;
    localt.jxm = paramb.tzp;
    localt.wAI = paramb.tzo;
    return localt;
  }
  
  public final int getType()
  {
    return 1616;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.d
 * JD-Core Version:    0.7.0.1
 */