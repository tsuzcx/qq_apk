package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends j
{
  public int qoj;
  public String qok;
  public int qol;
  public String qom;
  public String qon;
  public String qoo;
  
  public d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceid", q.getDeviceID(ae.getContext()));
    D(localHashMap);
  }
  
  public static boolean bLD()
  {
    g.DQ();
    long l = ((Long)g.DP().Dz().get(ac.a.usk, Long.valueOf(0L))).longValue();
    g.DQ();
    int i = ((Integer)g.DP().Dz().get(ac.a.usl, Integer.valueOf(0))).intValue();
    y.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
    if (l > 0L) {
      return Long.valueOf(new Date().getTime() / 1000L).longValue() > l + i;
    }
    return true;
  }
  
  private static boolean yS(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    int i = paramString.length();
    int j;
    do
    {
      i -= 1;
      if (i < 0) {
        return true;
      }
      j = paramString.charAt(i);
      if (j < 48) {
        break;
      }
    } while (j <= 57);
    return false;
  }
  
  public final int HH()
  {
    return 1654;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + paramInt + ";errMsg:" + paramString);
    y.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[] { paramJSONObject.toString() });
    label107:
    String str1;
    if (paramInt == 0)
    {
      paramString = paramJSONObject.optString("is_show_deduct", "0");
      if (!yS(paramString)) {
        break label538;
      }
      this.qoj = Integer.valueOf(paramString).intValue();
      this.qok = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!yS(paramString)) {
        break label544;
      }
      this.qol = Integer.valueOf(paramString).intValue();
      this.qom = paramJSONObject.optString("deduct_title", "");
      this.qon = paramJSONObject.optString("realname_url", "");
      this.qoo = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str1 = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new com.tencent.mm.plugin.wallet_core.model.z();
      ((com.tencent.mm.plugin.wallet_core.model.z)localObject).field_is_show = this.qoj;
      ((com.tencent.mm.plugin.wallet_core.model.z)localObject).field_pref_key = "wallet_open_auto_pay";
      ((com.tencent.mm.plugin.wallet_core.model.z)localObject).field_pref_title = this.qom;
      ((com.tencent.mm.plugin.wallet_core.model.z)localObject).field_pref_url = this.qok;
      h localh = o.bVr();
      if (!bk.bl("wallet_open_auto_pay"))
      {
        String str2 = "delete from WalletPrefInfo where pref_key='" + "wallet_open_auto_pay" + "'";
        localh.dXw.gk("WalletPrefInfo", str2);
      }
      y.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.qol), this.qoo });
      o.bVr().b((c)localObject);
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label551;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      g.DQ();
      g.DP().Dz().c(ac.a.uxV, paramJSONObject);
      g.DQ();
      g.DP().Dz().c(ac.a.uxW, localObject);
    }
    for (;;)
    {
      g.DQ();
      g.DP().Dz().c(ac.a.usk, Long.valueOf(new Date().getTime() / 1000L));
      g.DQ();
      g.DP().Dz().c(ac.a.usl, Integer.valueOf(this.qol));
      g.DQ();
      g.DP().Dz().c(ac.a.usr, this.qon);
      g.DQ();
      g.DP().Dz().c(ac.a.usA, this.qoo);
      if (!bk.bl(paramString))
      {
        g.DQ();
        g.DP().Dz().c(ac.a.usy, paramString);
      }
      if (!bk.bl(str1))
      {
        g.DQ();
        g.DP().Dz().c(ac.a.usz, str1);
      }
      g.DQ();
      g.DP().Dz().mC(true);
      return;
      label538:
      paramString = "0";
      break;
      label544:
      paramString = "84600";
      break label107;
      label551:
      g.DQ();
      g.DP().Dz().c(ac.a.uxV, "");
      g.DQ();
      g.DP().Dz().c(ac.a.uxW, "");
    }
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final int bUs()
  {
    return 100000;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/paymanage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */