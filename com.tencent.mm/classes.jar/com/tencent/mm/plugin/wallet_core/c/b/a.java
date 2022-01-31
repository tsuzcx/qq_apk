package com.tencent.mm.plugin.wallet_core.c.b;

import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  private boolean qrq;
  
  public a()
  {
    this("");
  }
  
  public a(String paramString)
  {
    this(paramString, true);
  }
  
  public a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_key", paramString);
    D(localHashMap);
    this.qrq = paramBoolean;
  }
  
  public final int a(e parame, f paramf)
  {
    return super.a(parame, paramf);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetScenePayUQueryBoundBankcard", "hy: payu query bind on gy net end. errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt != 0) {
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        long l = paramJSONObject.optLong("time_stamp");
        if (l > 0L)
        {
          u.setTimeStamp(String.valueOf(l));
          localObject1 = paramJSONObject.getJSONObject("user_info");
          paramString = new af();
          if ((localObject1 == null) || (((JSONObject)localObject1).length() <= 0)) {
            break label304;
          }
          paramString.field_is_reg = bk.getInt(((JSONObject)localObject1).optString("is_reg"), 0);
          paramString.field_true_name = ((JSONObject)localObject1).optString("true_name");
          paramString.field_main_card_bind_serialno = ((JSONObject)localObject1).optString("main_card_bind_serialno");
          paramString.field_ftf_pay_url = ((JSONObject)localObject1).optString("transfer_url");
          o.bVs();
          ag.Qu(paramString.field_main_card_bind_serialno);
          paramString.field_switchConfig = paramJSONObject.getJSONObject("switch_info").getInt("switch_bit");
          localObject2 = paramJSONObject.optJSONArray("Array");
          localObject1 = new ArrayList();
          if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
            break label309;
          }
          int i = ((JSONArray)localObject2).length();
          paramInt = 0;
          if (paramInt >= i) {
            break label309;
          }
          Object localObject3 = ((JSONArray)localObject2).getJSONObject(paramInt);
          ((JSONObject)localObject3).put("extra_bind_flag", "NORMAL");
          localObject3 = com.tencent.mm.plugin.wallet_core.model.a.a.bWl().am((JSONObject)localObject3);
          if (localObject3 == null) {
            break label455;
          }
          ((ArrayList)localObject1).add(localObject3);
          break label455;
        }
        y.w("MicroMsg.NetScenePayUQueryBoundBankcard", "no time_stamp in bindquerynew.");
        continue;
        if (!this.qrq) {
          break;
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.NetScenePayUQueryBoundBankcard", paramString, "", new Object[0]);
      }
      label265:
      if (!o.bVs().bVN())
      {
        this.dmL.onSceneEnd(1000, -100869, "", this);
        this.wAD = true;
        return;
        label304:
        paramString = null;
        continue;
        label309:
        localObject2 = paramJSONObject.optJSONObject("balance_info");
        if ((localObject2 == null) || (((JSONObject)localObject2).length() <= 0)) {
          break label450;
        }
        paramJSONObject = new Bankcard((byte)0);
        paramJSONObject.qty = (((JSONObject)localObject2).optInt("avail_balance") / 100.0D);
        paramJSONObject.qtA = (((JSONObject)localObject2).optInt("fetch_balance") / 100.0D);
        paramJSONObject.field_bankcardType = ((JSONObject)localObject2).optString("balance_bank_type");
        paramJSONObject.field_bindSerial = ((JSONObject)localObject2).optString("balance_bind_serial");
        paramJSONObject.field_forbidWord = ((JSONObject)localObject2).optString("balance_forbid_word");
        paramJSONObject.field_desc = ae.getContext().getString(a.i.wallet_harcode_balance_desc);
        paramJSONObject.field_cardType |= Bankcard.qto;
      }
      for (;;)
      {
        o.bVs().a(paramString, (ArrayList)localObject1, null, paramJSONObject, null, null, null, null, 0, 0, null);
        break label265;
        break;
        label450:
        paramJSONObject = null;
      }
      label455:
      paramInt += 1;
    }
  }
  
  public final int bUM()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b.a
 * JD-Core Version:    0.7.0.1
 */