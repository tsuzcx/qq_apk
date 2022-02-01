package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.f;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static d HWb = null;
  
  public static Bankcard a(vk paramvk)
  {
    boolean bool = true;
    AppMethodBeat.i(70229);
    Log.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[] { paramvk });
    Bankcard localBankcard = new Bankcard();
    for (;;)
    {
      try
      {
        localBankcard.field_bankName = paramvk.ynT;
        localBankcard.field_bankcardTypeName = paramvk.KNu;
        localBankcard.field_bankcardType = paramvk.dDj;
        localBankcard.field_bindSerial = paramvk.ANo;
        Log.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { localBankcard.field_bindSerial });
        if (2 == Util.getInt(paramvk.KNs, 2))
        {
          i = 1;
          if (i != 0) {
            localBankcard.field_cardType |= Bankcard.HVp;
          }
          if (!"NORMAL".equals(paramvk.LfU))
          {
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.HVq;
            }
            if (!Util.isNullOrNil(paramvk.dSf)) {
              localBankcard.field_mobile = URLDecoder.decode(paramvk.dSf.replaceAll("x", "%"), "utf-8");
            }
            localBankcard.field_onceQuotaKind = f.a(paramvk.LfQ, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_onceQuotaVirtual = f.a(paramvk.LfO, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaKind = f.a(paramvk.LfM, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaVirtual = f.a(paramvk.LfK, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_bankcardTail = paramvk.KNt;
            localBankcard.field_forbidWord = paramvk.ANp;
            localBankcard.field_repay_url = paramvk.JPU;
            localBankcard.field_wxcreditState = 2;
            if (Util.isNullOrNil(localBankcard.field_forbidWord)) {
              continue;
            }
            localBankcard.field_bankcardState = 8;
            localBankcard.field_bankPhone = paramvk.HXo;
            localBankcard.field_fetchArriveTime = (Util.getLong(paramvk.LfZ, 0L) * 1000L);
            localBankcard.field_fetchArriveTimeWording = paramvk.Lgl;
            localBankcard.field_bankcardTag = Util.getInt(paramvk.LfR, 1);
            if (localBankcard.field_bankcardTag != 2) {
              break label719;
            }
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.HVo;
            }
            if (paramvk.LfW != 1) {
              break label724;
            }
            localBankcard.field_support_micropay = bool;
            Log.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramvk.LfW);
            localBankcard.field_arrive_type = paramvk.Lgf;
            localBankcard.field_avail_save_wording = paramvk.Lgh;
            i = paramvk.Lgm;
            Log.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            localBankcard.field_fetch_charge_rate = (i / 10000.0D);
            Log.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + localBankcard.field_fetch_charge_rate);
            i = paramvk.Lgn;
            Log.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + localBankcard.field_full_fetch_charge_fee);
            localBankcard.field_full_fetch_charge_fee = (i / 100.0D);
            localBankcard.field_fetch_charge_info = paramvk.Lgo;
            localBankcard.field_tips = paramvk.pWf;
            localBankcard.field_forbid_title = paramvk.KNk;
            localBankcard.field_forbid_url = paramvk.KNl;
            localBankcard.field_no_micro_word = paramvk.Lgg;
            localBankcard.field_card_bottom_wording = paramvk.Lgu;
            localBankcard.field_support_lqt_turn_in = paramvk.Lgx;
            localBankcard.field_support_lqt_turn_out = paramvk.Lgy;
            localBankcard.field_is_hightlight_pre_arrive_time_wording = paramvk.Lgw;
            if (paramvk.KNo != null)
            {
              localBankcard.field_prompt_info_prompt_text = paramvk.KNo.LmX;
              localBankcard.field_prompt_info_jump_text = paramvk.KNo.LmY;
              localBankcard.field_prompt_info_jump_url = paramvk.KNo.pTL;
            }
            f(localBankcard);
            AppMethodBeat.o(70229);
            return localBankcard;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        i = 0;
        continue;
        if (1 == Util.getInt(paramvk.LfN, 0))
        {
          localBankcard.field_bankcardState = 1;
          continue;
        }
        if (Util.getInt(paramvk.HXn, 1) != 0) {
          break label711;
        }
      }
      catch (Exception paramvk)
      {
        Log.printErrStackTrace("MicroMsg.BankcardParser", paramvk, "parseFromBindQueryRecord() error:" + paramvk.getMessage(), new Object[0]);
        AppMethodBeat.o(70229);
        return null;
      }
      localBankcard.field_bankcardState = 2;
      continue;
      label711:
      localBankcard.field_bankcardState = 0;
      continue;
      label719:
      int i = 0;
      continue;
      label724:
      bool = false;
    }
  }
  
  public static void f(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70230);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.fQb())
    {
      paramBankcard.field_desc = paramBankcard.field_bankName;
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.fQf())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(2131767733, new Object[] { paramBankcard.HVT, f.ht(paramBankcard.HVQ, 8) });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.fQd())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(2131767665, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.fQa())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(2131768451, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.fQg())
    {
      paramBankcard.field_desc = paramBankcard.HVZ;
      AppMethodBeat.o(70230);
      return;
    }
    paramBankcard.field_desc = MMApplicationContext.getContext().getString(2131767685, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
    AppMethodBeat.o(70230);
  }
  
  public static d fQh()
  {
    AppMethodBeat.i(70226);
    if (HWb == null) {
      HWb = new d();
    }
    d locald = HWb;
    AppMethodBeat.o(70226);
    return locald;
  }
  
  public static List<Bankcard> hX(List<vk> paramList)
  {
    AppMethodBeat.i(70228);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Log.i("MicroMsg.BankcardParser", "record size: %s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((vk)paramList.next()));
      }
    }
    AppMethodBeat.o(70228);
    return localArrayList;
  }
  
  public Bankcard bA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70227);
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = "";
      Log.i("MicroMsg.BankcardParser", "parseJson jsonBankcard %s", new Object[] { localObject1 });
      localObject1 = new Bankcard();
    }
    int i;
    label125:
    Object localObject2;
    try
    {
      ((Bankcard)localObject1).field_bankName = paramJSONObject.getString("bank_name");
      ((Bankcard)localObject1).field_bankcardTypeName = paramJSONObject.optString("bankacc_type_name");
      ((Bankcard)localObject1).field_bankcardType = paramJSONObject.getString("bank_type");
      ((Bankcard)localObject1).field_bindSerial = paramJSONObject.optString("bind_serial");
      Log.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { ((Bankcard)localObject1).field_bindSerial });
      ((Bankcard)localObject1).HVA = paramJSONObject.optString("h_bind_serialno");
      if (2 != paramJSONObject.optInt("bankacc_type", 0)) {
        break label1151;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.HVp;
      }
      if ("NORMAL".equals(paramJSONObject.optString("extra_bind_flag"))) {
        break label1156;
      }
      i = 1;
      label158:
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.HVq;
      }
      if ("QMF".equals(((Bankcard)localObject1).field_bankcardType))
      {
        ((Bankcard)localObject1).field_cardType |= Bankcard.HVv;
        localObject2 = paramJSONObject.optJSONObject("qmfCardInfo");
        if (localObject2 != null)
        {
          ((Bankcard)localObject1).HVN = ((JSONObject)localObject2).optLong("total_credit_line", 0L);
          ((Bankcard)localObject1).HVO = ((JSONObject)localObject2).optLong("use_credit_line", 0L);
          ((Bankcard)localObject1).HVP = ((JSONObject)localObject2).optLong("unuse_credit_line", 0L);
          ((Bankcard)localObject1).HVQ = ((JSONObject)localObject2).optString("payer_username", "");
          ((Bankcard)localObject1).HVR = ((JSONObject)localObject2).optInt("hide_credit_line", 0);
          ((Bankcard)localObject1).HVS = ((JSONObject)localObject2).optInt("card_type", 0);
          ((Bankcard)localObject1).HVT = ((JSONObject)localObject2).optString("card_type_name", "");
          ((Bankcard)localObject1).HVU = ((JSONObject)localObject2).optString("icon_url", "");
        }
      }
      ((Bankcard)localObject1).field_mobile = URLDecoder.decode(paramJSONObject.optString("mobile").replaceAll("x", "%"), "utf-8");
      if (Util.isNullOrNil(((Bankcard)localObject1).field_mobile)) {
        ((Bankcard)localObject1).field_mobile = paramJSONObject.optString("mobile_mask");
      }
      ((Bankcard)localObject1).field_onceQuotaKind = (paramJSONObject.optDouble("once_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_onceQuotaVirtual = (paramJSONObject.optDouble("once_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaKind = (paramJSONObject.optDouble("day_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaVirtual = (paramJSONObject.optDouble("day_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("bind_tail");
      if (Util.isNullOrNil(((Bankcard)localObject1).field_bankcardTail)) {
        ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("card_tail");
      }
      ((Bankcard)localObject1).HVy = paramJSONObject.optString("card_mask");
      ((Bankcard)localObject1).field_forbidWord = paramJSONObject.optString("forbid_word");
      ((Bankcard)localObject1).field_repay_url = paramJSONObject.optString("repay_url");
      ((Bankcard)localObject1).field_wxcreditState = 2;
      if (Util.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) {
        break label1161;
      }
      ((Bankcard)localObject1).field_bankcardState = 8;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + paramJSONObject.getMessage());
        Log.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70227);
        return null;
        if (paramJSONObject.optInt("bank_flag", 1) != 0) {
          break;
        }
        ((Bankcard)localObject1).field_bankcardState = 2;
      }
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      for (;;)
      {
        Log.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + paramJSONObject.getMessage());
        Log.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70227);
        return null;
        ((Bankcard)localObject1).field_bankcardState = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      label513:
      Log.i("MicroMsg.BankcardParser", "parseJson() Exception:" + paramJSONObject.getMessage());
      Log.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(70227);
      return null;
    }
    if (Util.isEqual("FQF", ((Bankcard)localObject1).field_bankcardType))
    {
      ((Bankcard)localObject1).field_cardType |= Bankcard.HVw;
      localObject2 = paramJSONObject.optJSONObject("fqf_info");
      if (localObject2 != null)
      {
        ((Bankcard)localObject1).HVY = ((JSONObject)localObject2).optString("fqf_pay_desk_title", "");
        ((Bankcard)localObject1).HVZ = ((JSONObject)localObject2).optString("fqf_title", "");
        ((Bankcard)localObject1).HWa = ((JSONObject)localObject2).optString("fqf_sub_title", "");
      }
    }
    ((Bankcard)localObject1).Hwr = paramJSONObject.optString("tinyapp_username", "");
    ((Bankcard)localObject1).Hws = paramJSONObject.optString("tinyapp_path", "");
    ((Bankcard)localObject1).field_bankPhone = paramJSONObject.optString("bank_phone");
    ((Bankcard)localObject1).field_fetchArriveTime = (paramJSONObject.optLong("fetch_pre_arrive_time") * 1000L);
    ((Bankcard)localObject1).field_fetchArriveTimeWording = paramJSONObject.optString("fetch_pre_arrive_time_wording");
    ((Bankcard)localObject1).field_bankcardTag = paramJSONObject.optInt("bank_card_tag", 1);
    if (((Bankcard)localObject1).field_bankcardTag == 2)
    {
      i = 1;
      label684:
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.HVo;
      }
      localObject2 = paramJSONObject.optString("support_micropay");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Bankcard)localObject1).field_support_micropay = true;
      }
      if (!"1".equals(localObject2)) {
        break label1354;
      }
      ((Bankcard)localObject1).field_support_micropay = true;
    }
    for (;;)
    {
      ((Bankcard)localObject1).field_arrive_type = paramJSONObject.optString("arrive_type");
      ((Bankcard)localObject1).field_avail_save_wording = paramJSONObject.optString("avail_save_wording");
      Log.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramJSONObject.optString("support_micropay"));
      i = paramJSONObject.optInt("fetch_charge_rate", 0);
      Log.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
      ((Bankcard)localObject1).field_fetch_charge_rate = (i / 10000.0D);
      Log.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + ((Bankcard)localObject1).field_fetch_charge_rate);
      i = paramJSONObject.optInt("full_fetch_charge_fee", 0);
      Log.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + ((Bankcard)localObject1).field_full_fetch_charge_fee);
      ((Bankcard)localObject1).field_full_fetch_charge_fee = (i / 100.0D);
      ((Bankcard)localObject1).field_fetch_charge_info = paramJSONObject.optString("fetch_charge_info");
      ((Bankcard)localObject1).field_tips = paramJSONObject.optString("tips");
      ((Bankcard)localObject1).field_forbid_title = paramJSONObject.optString("forbid_title");
      ((Bankcard)localObject1).field_forbid_url = paramJSONObject.optString("forbid_url");
      ((Bankcard)localObject1).field_no_micro_word = paramJSONObject.optString("no_micro_word");
      ((Bankcard)localObject1).field_card_bottom_wording = paramJSONObject.optString("card_bottom_wording");
      ((Bankcard)localObject1).field_support_lqt_turn_in = paramJSONObject.optInt("support_lqt_turn_in", 0);
      ((Bankcard)localObject1).field_support_lqt_turn_out = paramJSONObject.optInt("support_lqt_turn_out", 0);
      ((Bankcard)localObject1).field_is_hightlight_pre_arrive_time_wording = paramJSONObject.optInt("is_hightlight_pre_arrive_time_wording", 0);
      ((Bankcard)localObject1).HVV = paramJSONObject.optInt("support_foreign_mobile", 0);
      ((Bankcard)localObject1).field_card_state_name = paramJSONObject.optString("card_state_name");
      ((Bankcard)localObject1).HVW = paramJSONObject.optString("card_fetch_wording");
      ((Bankcard)localObject1).HVX = paramJSONObject.optLong("card_min_charge_fee");
      localObject2 = paramJSONObject.optJSONObject("prompt_info");
      if (localObject2 != null)
      {
        ((Bankcard)localObject1).field_prompt_info_prompt_text = ((JSONObject)localObject2).optString("prompt_text");
        ((Bankcard)localObject1).field_prompt_info_jump_text = ((JSONObject)localObject2).optString("jump_text");
        ((Bankcard)localObject1).field_prompt_info_jump_url = ((JSONObject)localObject2).optString("jump_url");
      }
      f((Bankcard)localObject1);
      i = paramJSONObject.optInt("default_card_state");
      Log.i("MicroMsg.BankcardParser", "fqfCardSettingState : %s", new Object[] { Integer.valueOf(i) });
      if (i != 0) {
        g.aAh().azQ().set(ar.a.NTC, Integer.valueOf(i));
      }
      AppMethodBeat.o(70227);
      return localObject1;
      localObject1 = paramJSONObject;
      break;
      label1151:
      i = 0;
      break label125;
      label1156:
      i = 0;
      break label158;
      label1161:
      if (1 == paramJSONObject.optInt("expired_flag", 0))
      {
        ((Bankcard)localObject1).field_bankcardState = 1;
        break label513;
      }
      i = 0;
      break label684;
      label1354:
      if ("0".equals(localObject2)) {
        ((Bankcard)localObject1).field_support_micropay = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.d
 * JD-Core Version:    0.7.0.1
 */