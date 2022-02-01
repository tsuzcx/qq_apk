package com.tencent.mm.plugin.wallet_core.c.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.d.a.a
{
  private boolean VyD;
  
  public a()
  {
    this("");
  }
  
  private a(String paramString)
  {
    this(paramString, true);
  }
  
  public a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69976);
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_key", paramString);
    setRequestData(localHashMap);
    this.VyD = paramBoolean;
    AppMethodBeat.o(69976);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69977);
    int i = super.doScene(paramg, paramh);
    AppMethodBeat.o(69977);
    return i;
  }
  
  public final int ihO()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69978);
    Log.i("MicroMsg.NetScenePayUQueryBoundBankcard", "hy: payu query bind on gy net end. errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt != 0)
    {
      AppMethodBeat.o(69978);
      return;
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        long l = paramJSONObject.optLong("time_stamp");
        if (l > 0L)
        {
          y.setTimeStamp(String.valueOf(l));
          localObject1 = paramJSONObject.getJSONObject("user_info");
          paramString = new al();
          if ((localObject1 != null) && (((JSONObject)localObject1).length() > 0))
          {
            paramString.field_is_reg = Util.getInt(((JSONObject)localObject1).optString("is_reg"), 0);
            paramString.field_true_name = ((JSONObject)localObject1).optString("true_name");
            paramString.field_main_card_bind_serialno = ((JSONObject)localObject1).optString("main_card_bind_serialno");
            paramString.field_ftf_pay_url = ((JSONObject)localObject1).optString("transfer_url");
            u.iiC();
            am.bgG(paramString.field_main_card_bind_serialno);
            paramString.field_switchConfig = paramJSONObject.getJSONObject("switch_info").getInt("switch_bit");
            localObject2 = paramJSONObject.optJSONArray("Array");
            localObject1 = new ArrayList();
            if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
              break label324;
            }
            int i = ((JSONArray)localObject2).length();
            paramInt = 0;
            if (paramInt >= i) {
              break label324;
            }
            Object localObject3 = ((JSONArray)localObject2).getJSONObject(paramInt);
            ((JSONObject)localObject3).put("extra_bind_flag", "NORMAL");
            localObject3 = com.tencent.mm.plugin.wallet_core.model.a.a.iki().cg((JSONObject)localObject3);
            if (localObject3 == null) {
              break label471;
            }
            ((ArrayList)localObject1).add(localObject3);
            break label471;
          }
        }
        else
        {
          Log.w("MicroMsg.NetScenePayUQueryBoundBankcard", "no time_stamp in bindquerynew.");
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetScenePayUQueryBoundBankcard", paramString, "", new Object[0]);
        if ((this.VyD) && (!u.iiC().ijf()))
        {
          this.callback.onSceneEnd(1000, -100869, "", this);
          this.isChildConsume = true;
        }
        AppMethodBeat.o(69978);
        return;
      }
      continue;
      label324:
      Object localObject2 = paramJSONObject.optJSONObject("balance_info");
      if ((localObject2 != null) && (((JSONObject)localObject2).length() > 0))
      {
        paramJSONObject = new Bankcard((byte)0);
        paramJSONObject.VDo = (((JSONObject)localObject2).optInt("avail_balance") / 100.0D);
        paramJSONObject.VDq = (((JSONObject)localObject2).optInt("fetch_balance") / 100.0D);
        paramJSONObject.field_bankcardType = ((JSONObject)localObject2).optString("balance_bank_type");
        paramJSONObject.field_bindSerial = ((JSONObject)localObject2).optString("balance_bind_serial");
        paramJSONObject.field_forbidWord = ((JSONObject)localObject2).optString("balance_forbid_word");
        paramJSONObject.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_harcode_balance_desc);
        paramJSONObject.field_cardType |= Bankcard.VDd;
      }
      for (;;)
      {
        u.iiC().a(paramString, (ArrayList)localObject1, null, paramJSONObject, null, null, null, null, 0, 0, null);
        break;
        paramJSONObject = null;
      }
      label471:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b.a
 * JD-Core Version:    0.7.0.1
 */