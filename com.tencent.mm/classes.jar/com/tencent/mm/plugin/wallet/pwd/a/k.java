package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.h;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public int tXW;
  public String tXX;
  public int tXY;
  public String tXZ;
  public String tYa;
  public String tYb;
  
  public k()
  {
    AppMethodBeat.i(46184);
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceid", q.bP(false));
    setRequestData(localHashMap);
    AppMethodBeat.o(46184);
  }
  
  private static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(46188);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46188);
      return false;
    }
    int i = paramString.length();
    int j;
    do
    {
      i -= 1;
      if (i < 0)
      {
        AppMethodBeat.o(46188);
        return true;
      }
      j = paramString.charAt(i);
    } while ((j >= 48) && (j <= 57));
    AppMethodBeat.o(46188);
    return false;
  }
  
  private static af k(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(46186);
    af localaf = new af();
    localaf.field_is_show = paramJSONObject.optInt("show_label", 0);
    localaf.field_pref_key = paramString;
    localaf.field_pref_title = paramJSONObject.optString("title");
    localaf.field_pref_desc = paramJSONObject.optString("desc");
    localaf.field_logo_url = paramJSONObject.optString("logo_url");
    localaf.field_jump_type = paramJSONObject.optInt("jump_type");
    localaf.field_pref_url = paramJSONObject.optString("jump_h5_url");
    localaf.field_tinyapp_username = paramJSONObject.optString("tinyapp_username");
    localaf.field_tinyapp_path = paramJSONObject.optString("tinyapp_path");
    AppMethodBeat.o(46186);
    return localaf;
  }
  
  public final int getFuncId()
  {
    return 1654;
  }
  
  public final int getPayCgicmd()
  {
    return 100000;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/paymanage";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46185);
    ab.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + paramInt + ";errMsg:" + paramString);
    ab.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[] { paramJSONObject.toString() });
    label112:
    String str;
    if (paramInt == 0)
    {
      paramString = paramJSONObject.optString("is_show_deduct", "0");
      if (!isNumeric(paramString)) {
        break label587;
      }
      this.tXW = Integer.valueOf(paramString).intValue();
      this.tXX = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!isNumeric(paramString)) {
        break label593;
      }
      this.tXY = Integer.valueOf(paramString).intValue();
      this.tXZ = paramJSONObject.optString("deduct_title", "");
      this.tYa = paramJSONObject.optString("realname_url", "");
      this.tYb = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new af();
      ((af)localObject).field_is_show = this.tXW;
      ((af)localObject).field_pref_key = "wallet_open_auto_pay";
      ((af)localObject).field_pref_title = this.tXZ;
      ((af)localObject).field_pref_url = this.tXX;
      t.cTM().afy("wallet_open_auto_pay");
      ab.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.tXY), this.tYb });
      t.cTM().insert((c)localObject);
      localObject = paramJSONObject.optJSONObject("switch_wallet");
      if (localObject != null)
      {
        localObject = k((JSONObject)localObject, "wallet_switch_currency");
        t.cTM().afy("wallet_switch_currency");
        t.cTM().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("im_mch");
      if (localObject != null)
      {
        localObject = k((JSONObject)localObject, "wallet_im_mch");
        t.cTM().afy("wallet_im_mch");
        t.cTM().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label600;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      g.RM();
      g.RL().Ru().set(ac.a.yIf, paramJSONObject);
      g.RM();
      g.RL().Ru().set(ac.a.yIg, localObject);
    }
    for (;;)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yCk, Long.valueOf(new Date().getTime() / 1000L));
      g.RM();
      g.RL().Ru().set(ac.a.yCl, Integer.valueOf(this.tXY));
      g.RM();
      g.RL().Ru().set(ac.a.yCr, this.tYa);
      g.RM();
      g.RL().Ru().set(ac.a.yCA, this.tYb);
      if (!bo.isNullOrNil(paramString))
      {
        g.RM();
        g.RL().Ru().set(ac.a.yCy, paramString);
      }
      if (!bo.isNullOrNil(str))
      {
        g.RM();
        g.RL().Ru().set(ac.a.yCz, str);
      }
      g.RM();
      g.RL().Ru().dww();
      AppMethodBeat.o(46185);
      return;
      label587:
      paramString = "0";
      break;
      label593:
      paramString = "84600";
      break label112;
      label600:
      g.RM();
      g.RL().Ru().set(ac.a.yIf, "");
      g.RM();
      g.RL().Ru().set(ac.a.yIg, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.k
 * JD-Core Version:    0.7.0.1
 */