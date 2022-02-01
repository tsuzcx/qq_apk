package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
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
  private static d OOc = null;
  
  public static Bankcard a(vm paramvm)
  {
    boolean bool = true;
    AppMethodBeat.i(70229);
    Log.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[] { paramvm });
    Bankcard localBankcard = new Bankcard();
    for (;;)
    {
      try
      {
        localBankcard.field_bankName = paramvm.DNV;
        localBankcard.field_bankcardTypeName = paramvm.ROo;
        localBankcard.field_bankcardType = paramvm.fvP;
        localBankcard.field_bindSerial = paramvm.GGC;
        Log.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { localBankcard.field_bindSerial });
        if (2 == Util.getInt(paramvm.ROm, 2))
        {
          i = 1;
          if (i != 0) {
            localBankcard.field_cardType |= Bankcard.ONq;
          }
          if (!"NORMAL".equals(paramvm.Shi))
          {
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.ONr;
            }
            if (!Util.isNullOrNil(paramvm.fLC)) {
              localBankcard.field_mobile = URLDecoder.decode(paramvm.fLC.replaceAll("x", "%"), "utf-8");
            }
            localBankcard.field_onceQuotaKind = g.a(paramvm.She, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_onceQuotaVirtual = g.a(paramvm.Shc, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaKind = g.a(paramvm.Sha, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaVirtual = g.a(paramvm.SgY, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_bankcardTail = paramvm.ROn;
            localBankcard.field_forbidWord = paramvm.GGD;
            localBankcard.field_repay_url = paramvm.QOl;
            localBankcard.field_wxcreditState = 2;
            if (Util.isNullOrNil(localBankcard.field_forbidWord)) {
              continue;
            }
            localBankcard.field_bankcardState = 8;
            localBankcard.field_bankPhone = paramvm.OPo;
            localBankcard.field_fetchArriveTime = (Util.getLong(paramvm.Shn, 0L) * 1000L);
            localBankcard.field_fetchArriveTimeWording = paramvm.Shz;
            localBankcard.field_bankcardTag = Util.getInt(paramvm.Shf, 1);
            if (localBankcard.field_bankcardTag != 2) {
              break label719;
            }
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.ONp;
            }
            if (paramvm.Shk != 1) {
              break label724;
            }
            localBankcard.field_support_micropay = bool;
            Log.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramvm.Shk);
            localBankcard.field_arrive_type = paramvm.Sht;
            localBankcard.field_avail_save_wording = paramvm.Shv;
            i = paramvm.ShA;
            Log.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            localBankcard.field_fetch_charge_rate = (i / 10000.0D);
            Log.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + localBankcard.field_fetch_charge_rate);
            i = paramvm.ShB;
            Log.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + localBankcard.field_full_fetch_charge_fee);
            localBankcard.field_full_fetch_charge_fee = (i / 100.0D);
            localBankcard.field_fetch_charge_info = paramvm.ShC;
            localBankcard.field_tips = paramvm.tsf;
            localBankcard.field_forbid_title = paramvm.ROe;
            localBankcard.field_forbid_url = paramvm.ROf;
            localBankcard.field_no_micro_word = paramvm.Shu;
            localBankcard.field_card_bottom_wording = paramvm.ShI;
            localBankcard.field_support_lqt_turn_in = paramvm.ShL;
            localBankcard.field_support_lqt_turn_out = paramvm.ShM;
            localBankcard.field_is_hightlight_pre_arrive_time_wording = paramvm.ShK;
            if (paramvm.ROi != null)
            {
              localBankcard.field_prompt_info_prompt_text = paramvm.ROi.Soo;
              localBankcard.field_prompt_info_jump_text = paramvm.ROi.Sop;
              localBankcard.field_prompt_info_jump_url = paramvm.ROi.jump_url;
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
        if (1 == Util.getInt(paramvm.Shb, 0))
        {
          localBankcard.field_bankcardState = 1;
          continue;
        }
        if (Util.getInt(paramvm.OPn, 1) != 0) {
          break label711;
        }
      }
      catch (Exception paramvm)
      {
        Log.printErrStackTrace("MicroMsg.BankcardParser", paramvm, "parseFromBindQueryRecord() error:" + paramvm.getMessage(), new Object[0]);
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
    if (paramBankcard.gIH())
    {
      paramBankcard.field_desc = paramBankcard.field_bankName;
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.gIL())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_honeypay_card_desc, new Object[] { paramBankcard.ONU, g.id(paramBankcard.ONR, 8) });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.gIJ())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_credit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.gIG())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_wxcredit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.gIM())
    {
      paramBankcard.field_desc = paramBankcard.OOa;
      AppMethodBeat.o(70230);
      return;
    }
    paramBankcard.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_deposit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
    AppMethodBeat.o(70230);
  }
  
  public static d gIN()
  {
    AppMethodBeat.i(70226);
    if (OOc == null) {
      OOc = new d();
    }
    d locald = OOc;
    AppMethodBeat.o(70226);
    return locald;
  }
  
  public static List<Bankcard> iN(List<vm> paramList)
  {
    AppMethodBeat.i(70228);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Log.i("MicroMsg.BankcardParser", "record size: %s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((vm)paramList.next()));
      }
    }
    AppMethodBeat.o(70228);
    return localArrayList;
  }
  
  public Bankcard bL(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(70227);
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = "";
      Log.i("MicroMsg.BankcardParser", "parseJson jsonBankcard %s", new Object[] { localObject1 });
      localObject1 = new Bankcard();
    }
    int i;
    label161:
    label196:
    Object localObject2;
    try
    {
      ((Bankcard)localObject1).field_bankName = paramJSONObject.getString("bank_name");
      ((Bankcard)localObject1).field_bankcardTypeName = paramJSONObject.optString("bankacc_type_name");
      ((Bankcard)localObject1).field_bankcardType = paramJSONObject.getString("bank_type");
      ((Bankcard)localObject1).field_bindSerial = paramJSONObject.optString("bind_serial");
      ((Bankcard)localObject1).field_defaultCardState = paramJSONObject.optInt("default_card_state", 0);
      Log.i("MicroMsg.BankcardParser", "bankcard bind_serial: %s，default stats：%s", new Object[] { ((Bankcard)localObject1).field_bindSerial, Integer.valueOf(((Bankcard)localObject1).field_defaultCardState) });
      ((Bankcard)localObject1).ONB = paramJSONObject.optString("h_bind_serialno");
      if (2 != paramJSONObject.optInt("bankacc_type", 0)) {
        break label1208;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.ONq;
      }
      if ("NORMAL".equals(paramJSONObject.optString("extra_bind_flag"))) {
        break label1213;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.ONr;
      }
      if ("QMF".equals(((Bankcard)localObject1).field_bankcardType))
      {
        ((Bankcard)localObject1).field_cardType |= Bankcard.ONw;
        localObject2 = paramJSONObject.optJSONObject("qmfCardInfo");
        if (localObject2 != null)
        {
          ((Bankcard)localObject1).ONO = ((JSONObject)localObject2).optLong("total_credit_line", 0L);
          ((Bankcard)localObject1).ONP = ((JSONObject)localObject2).optLong("use_credit_line", 0L);
          ((Bankcard)localObject1).ONQ = ((JSONObject)localObject2).optLong("unuse_credit_line", 0L);
          ((Bankcard)localObject1).ONR = ((JSONObject)localObject2).optString("payer_username", "");
          ((Bankcard)localObject1).ONS = ((JSONObject)localObject2).optInt("hide_credit_line", 0);
          ((Bankcard)localObject1).ONT = ((JSONObject)localObject2).optInt("card_type", 0);
          ((Bankcard)localObject1).ONU = ((JSONObject)localObject2).optString("card_type_name", "");
          ((Bankcard)localObject1).ONV = ((JSONObject)localObject2).optString("icon_url", "");
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
      ((Bankcard)localObject1).ONz = paramJSONObject.optString("card_mask");
      ((Bankcard)localObject1).field_forbidWord = paramJSONObject.optString("forbid_word");
      ((Bankcard)localObject1).field_repay_url = paramJSONObject.optString("repay_url");
      ((Bankcard)localObject1).field_wxcreditState = 2;
      if (Util.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) {
        break label1218;
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
      label580:
      Log.i("MicroMsg.BankcardParser", "parseJson() Exception:" + paramJSONObject.getMessage());
      Log.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(70227);
      return null;
    }
    if (Util.isEqual("FQF", ((Bankcard)localObject1).field_bankcardType))
    {
      ((Bankcard)localObject1).field_cardType |= Bankcard.ONx;
      localObject2 = paramJSONObject.optJSONObject("fqf_info");
      if (localObject2 != null)
      {
        ((Bankcard)localObject1).ONZ = ((JSONObject)localObject2).optString("fqf_pay_desk_title", "");
        ((Bankcard)localObject1).OOa = ((JSONObject)localObject2).optString("fqf_title", "");
        ((Bankcard)localObject1).OOb = ((JSONObject)localObject2).optString("fqf_sub_title", "");
      }
    }
    ((Bankcard)localObject1).Ooe = paramJSONObject.optString("tinyapp_username", "");
    ((Bankcard)localObject1).Oof = paramJSONObject.optString("tinyapp_path", "");
    ((Bankcard)localObject1).field_bankPhone = paramJSONObject.optString("bank_phone");
    ((Bankcard)localObject1).field_fetchArriveTime = (paramJSONObject.optLong("fetch_pre_arrive_time") * 1000L);
    ((Bankcard)localObject1).field_fetchArriveTimeWording = paramJSONObject.optString("fetch_pre_arrive_time_wording");
    ((Bankcard)localObject1).field_bankcardTag = paramJSONObject.optInt("bank_card_tag", 1);
    if (((Bankcard)localObject1).field_bankcardTag == 2)
    {
      i = j;
      label764:
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.ONp;
      }
      localObject2 = paramJSONObject.optString("support_micropay");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Bankcard)localObject1).field_support_micropay = true;
      }
      if (!"1".equals(localObject2)) {
        break label1414;
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
      ((Bankcard)localObject1).ONW = paramJSONObject.optInt("support_foreign_mobile", 0);
      ((Bankcard)localObject1).field_card_state_name = paramJSONObject.optString("card_state_name");
      ((Bankcard)localObject1).ONX = paramJSONObject.optString("card_fetch_wording");
      ((Bankcard)localObject1).ONY = paramJSONObject.optLong("card_min_charge_fee");
      paramJSONObject = paramJSONObject.optJSONObject("prompt_info");
      if (paramJSONObject != null)
      {
        ((Bankcard)localObject1).field_prompt_info_prompt_text = paramJSONObject.optString("prompt_text");
        ((Bankcard)localObject1).field_prompt_info_jump_text = paramJSONObject.optString("jump_text");
        ((Bankcard)localObject1).field_prompt_info_jump_url = paramJSONObject.optString("jump_url");
      }
      f((Bankcard)localObject1);
      AppMethodBeat.o(70227);
      return localObject1;
      localObject1 = paramJSONObject;
      break;
      label1208:
      i = 0;
      break label161;
      label1213:
      i = 0;
      break label196;
      label1218:
      if (1 == paramJSONObject.optInt("expired_flag", 0))
      {
        ((Bankcard)localObject1).field_bankcardState = 1;
        break label580;
      }
      i = 0;
      break label764;
      label1414:
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