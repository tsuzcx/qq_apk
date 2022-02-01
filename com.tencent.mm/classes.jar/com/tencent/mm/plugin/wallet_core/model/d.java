package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ehq;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static d VDW = null;
  
  public static Bankcard a(xe paramxe)
  {
    boolean bool = true;
    AppMethodBeat.i(70229);
    Log.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[] { paramxe });
    Bankcard localBankcard = new Bankcard();
    for (;;)
    {
      try
      {
        localBankcard.field_bankName = paramxe.JFk;
        localBankcard.field_bankcardTypeName = paramxe.YLC;
        localBankcard.field_bankcardType = paramxe.hAk;
        localBankcard.field_bindSerial = paramxe.MDt;
        Log.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { localBankcard.field_bindSerial });
        if (2 == Util.getInt(paramxe.YLA, 2))
        {
          i = 1;
          if (i != 0) {
            localBankcard.field_cardType |= Bankcard.VDb;
          }
          if (!"NORMAL".equals(paramxe.Zfm))
          {
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.VDc;
            }
            if (!Util.isNullOrNil(paramxe.hRk)) {
              localBankcard.field_mobile = URLDecoder.decode(paramxe.hRk.replaceAll("x", "%"), "utf-8");
            }
            localBankcard.field_onceQuotaKind = i.a(paramxe.Zfi, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_onceQuotaVirtual = i.a(paramxe.Zfg, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaKind = i.a(paramxe.Zfe, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaVirtual = i.a(paramxe.Zfc, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_bankcardTail = paramxe.YLB;
            localBankcard.field_forbidWord = paramxe.MDu;
            localBankcard.field_repay_url = paramxe.XHJ;
            localBankcard.field_wxcreditState = 2;
            if (Util.isNullOrNil(localBankcard.field_forbidWord)) {
              continue;
            }
            localBankcard.field_bankcardState = 8;
            localBankcard.field_bankPhone = paramxe.VFi;
            localBankcard.field_fetchArriveTime = (Util.getLong(paramxe.Zfr, 0L) * 1000L);
            localBankcard.field_fetchArriveTimeWording = paramxe.ZfD;
            localBankcard.field_bankcardTag = Util.getInt(paramxe.Zfj, 1);
            if (localBankcard.field_bankcardTag != 2) {
              break label719;
            }
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.VDa;
            }
            if (paramxe.Zfo != 1) {
              break label724;
            }
            localBankcard.field_support_micropay = bool;
            Log.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramxe.Zfo);
            localBankcard.field_arrive_type = paramxe.Zfx;
            localBankcard.field_avail_save_wording = paramxe.Zfz;
            i = paramxe.ZfE;
            Log.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            localBankcard.field_fetch_charge_rate = (i / 10000.0D);
            Log.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + localBankcard.field_fetch_charge_rate);
            i = paramxe.ZfF;
            Log.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + localBankcard.field_full_fetch_charge_fee);
            localBankcard.field_full_fetch_charge_fee = (i / 100.0D);
            localBankcard.field_fetch_charge_info = paramxe.ZfG;
            localBankcard.field_tips = paramxe.lym;
            localBankcard.field_forbid_title = paramxe.YLs;
            localBankcard.field_forbid_url = paramxe.YLt;
            localBankcard.field_no_micro_word = paramxe.Zfy;
            localBankcard.field_card_bottom_wording = paramxe.ZfM;
            localBankcard.field_support_lqt_turn_in = paramxe.ZfP;
            localBankcard.field_support_lqt_turn_out = paramxe.ZfQ;
            localBankcard.field_is_hightlight_pre_arrive_time_wording = paramxe.ZfO;
            if (paramxe.YLw != null)
            {
              localBankcard.field_prompt_info_prompt_text = paramxe.YLw.ZmZ;
              localBankcard.field_prompt_info_jump_text = paramxe.YLw.Zna;
              localBankcard.field_prompt_info_jump_url = paramxe.YLw.jump_url;
            }
            g(localBankcard);
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
        if (1 == Util.getInt(paramxe.Zff, 0))
        {
          localBankcard.field_bankcardState = 1;
          continue;
        }
        if (Util.getInt(paramxe.VFh, 1) != 0) {
          break label711;
        }
      }
      catch (Exception paramxe)
      {
        Log.printErrStackTrace("MicroMsg.BankcardParser", paramxe, "parseFromBindQueryRecord() error:" + paramxe.getMessage(), new Object[0]);
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
  
  public static void g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70230);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.ihV())
    {
      paramBankcard.field_desc = paramBankcard.field_bankName;
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.ihZ())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_honeypay_card_desc, new Object[] { paramBankcard.VDF, i.jp(paramBankcard.VDC, 8) });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.ihX())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_credit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.ihU())
    {
      paramBankcard.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_wxcredit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.iia())
    {
      paramBankcard.field_desc = paramBankcard.VDL;
      AppMethodBeat.o(70230);
      return;
    }
    paramBankcard.field_desc = MMApplicationContext.getContext().getString(a.i.wallet_deposit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
    AppMethodBeat.o(70230);
  }
  
  public static d iib()
  {
    AppMethodBeat.i(70226);
    if (VDW == null) {
      VDW = new d();
    }
    d locald = VDW;
    AppMethodBeat.o(70226);
    return locald;
  }
  
  public static List<Bankcard> lV(List<xe> paramList)
  {
    AppMethodBeat.i(70228);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Log.i("MicroMsg.BankcardParser", "record size: %s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((xe)paramList.next()));
      }
    }
    AppMethodBeat.o(70228);
    return localArrayList;
  }
  
  public Bankcard cg(JSONObject paramJSONObject)
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
    label1665:
    label1670:
    for (;;)
    {
      Object localObject2;
      try
      {
        ((Bankcard)localObject1).field_bankName = paramJSONObject.getString("bank_name");
        ((Bankcard)localObject1).field_bankcardTypeName = paramJSONObject.optString("bankacc_type_name");
        ((Bankcard)localObject1).field_bankcardType = paramJSONObject.getString("bank_type");
        ((Bankcard)localObject1).field_bindSerial = paramJSONObject.optString("bind_serial");
        ((Bankcard)localObject1).field_defaultCardState = paramJSONObject.optInt("default_card_state", 0);
        Log.i("MicroMsg.BankcardParser", "bankcard bind_serial: %s，default stats：%s", new Object[] { ((Bankcard)localObject1).field_bindSerial, Integer.valueOf(((Bankcard)localObject1).field_defaultCardState) });
        ((Bankcard)localObject1).VDm = paramJSONObject.optString("h_bind_serialno");
        if (2 != paramJSONObject.optInt("bankacc_type", 0)) {
          break label1665;
        }
        i = 1;
        if (i != 0) {
          ((Bankcard)localObject1).field_cardType |= Bankcard.VDb;
        }
        if ("NORMAL".equals(paramJSONObject.optString("extra_bind_flag"))) {
          break label1670;
        }
        i = 1;
        if (i != 0) {
          ((Bankcard)localObject1).field_cardType |= Bankcard.VDc;
        }
        if ("QMF".equals(((Bankcard)localObject1).field_bankcardType))
        {
          ((Bankcard)localObject1).field_cardType |= Bankcard.VDh;
          localObject2 = paramJSONObject.optJSONObject("qmfCardInfo");
          if (localObject2 != null)
          {
            ((Bankcard)localObject1).VDz = ((JSONObject)localObject2).optLong("total_credit_line", 0L);
            ((Bankcard)localObject1).VDA = ((JSONObject)localObject2).optLong("use_credit_line", 0L);
            ((Bankcard)localObject1).VDB = ((JSONObject)localObject2).optLong("unuse_credit_line", 0L);
            ((Bankcard)localObject1).VDC = ((JSONObject)localObject2).optString("payer_username", "");
            ((Bankcard)localObject1).VDD = ((JSONObject)localObject2).optInt("hide_credit_line", 0);
            ((Bankcard)localObject1).VDE = ((JSONObject)localObject2).optInt("card_type", 0);
            ((Bankcard)localObject1).VDF = ((JSONObject)localObject2).optString("card_type_name", "");
            ((Bankcard)localObject1).VDG = ((JSONObject)localObject2).optString("icon_url", "");
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
        ((Bankcard)localObject1).VDk = paramJSONObject.optString("card_mask");
        ((Bankcard)localObject1).field_forbidWord = paramJSONObject.optString("forbid_word");
        ((Bankcard)localObject1).field_repay_url = paramJSONObject.optString("repay_url");
        ((Bankcard)localObject1).field_wxcreditState = 2;
        if (Util.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) {
          continue;
        }
        ((Bankcard)localObject1).field_bankcardState = 8;
      }
      catch (JSONException paramJSONObject)
      {
        Log.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + paramJSONObject.getMessage());
        Log.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70227);
        return null;
        if (paramJSONObject.optInt("bank_flag", 1) != 0) {
          continue;
        }
        ((Bankcard)localObject1).field_bankcardState = 2;
        continue;
      }
      catch (UnsupportedEncodingException paramJSONObject)
      {
        Log.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + paramJSONObject.getMessage());
        Log.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70227);
        return null;
        ((Bankcard)localObject1).field_bankcardState = 0;
        continue;
      }
      catch (Exception paramJSONObject)
      {
        Log.i("MicroMsg.BankcardParser", "parseJson() Exception:" + paramJSONObject.getMessage());
        Log.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70227);
        return null;
      }
      if (Util.isEqual("FQF", ((Bankcard)localObject1).field_bankcardType))
      {
        ((Bankcard)localObject1).field_cardType |= Bankcard.VDi;
        localObject2 = paramJSONObject.optJSONObject("fqf_info");
        if (localObject2 != null)
        {
          ((Bankcard)localObject1).VDK = ((JSONObject)localObject2).optString("fqf_pay_desk_title", "");
          ((Bankcard)localObject1).VDL = ((JSONObject)localObject2).optString("fqf_title", "");
          ((Bankcard)localObject1).VDM = ((JSONObject)localObject2).optString("fqf_sub_title", "");
        }
      }
      ((Bankcard)localObject1).VcU = paramJSONObject.optString("tinyapp_username", "");
      ((Bankcard)localObject1).VcV = paramJSONObject.optString("tinyapp_path", "");
      ((Bankcard)localObject1).field_bankPhone = paramJSONObject.optString("bank_phone");
      ((Bankcard)localObject1).field_fetchArriveTime = (paramJSONObject.optLong("fetch_pre_arrive_time") * 1000L);
      ((Bankcard)localObject1).field_fetchArriveTimeWording = paramJSONObject.optString("fetch_pre_arrive_time_wording");
      ((Bankcard)localObject1).field_bankcardTag = paramJSONObject.optInt("bank_card_tag", 1);
      if (((Bankcard)localObject1).field_bankcardTag == 2)
      {
        i = j;
        if (i != 0) {
          ((Bankcard)localObject1).field_cardType |= Bankcard.VDa;
        }
        localObject2 = paramJSONObject.optString("support_micropay");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Bankcard)localObject1).field_support_micropay = true;
        }
        if (!"1".equals(localObject2)) {
          break label1503;
        }
        ((Bankcard)localObject1).field_support_micropay = true;
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
        ((Bankcard)localObject1).VDH = paramJSONObject.optInt("support_foreign_mobile", 0);
        ((Bankcard)localObject1).field_card_state_name = paramJSONObject.optString("card_state_name");
        ((Bankcard)localObject1).VDI = paramJSONObject.optString("card_fetch_wording");
        ((Bankcard)localObject1).VDJ = paramJSONObject.optLong("card_min_charge_fee");
        localObject2 = paramJSONObject.optJSONObject("prompt_info");
        if (localObject2 != null)
        {
          ((Bankcard)localObject1).field_prompt_info_prompt_text = ((JSONObject)localObject2).optString("prompt_text");
          ((Bankcard)localObject1).field_prompt_info_jump_text = ((JSONObject)localObject2).optString("jump_text");
          ((Bankcard)localObject1).field_prompt_info_jump_url = ((JSONObject)localObject2).optString("jump_url");
        }
        ((Bankcard)localObject1).VDN = paramJSONObject.optString("fetch_limit_title");
        if (Util.isNullOrNil(((Bankcard)localObject1).VDN)) {
          break label1523;
        }
        ((Bankcard)localObject1).VDO = paramJSONObject.optString("fetch_limit_popup_title");
        ((Bankcard)localObject1).VDP = paramJSONObject.optString("fetch_limit_popup_wording");
        localObject2 = paramJSONObject.optJSONArray("fetch_limit_array");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label1523;
        }
        ((Bankcard)localObject1).VDQ = new ArrayList();
        i = 0;
        if (i >= ((JSONArray)localObject2).length()) {
          break label1523;
        }
        ((Bankcard)localObject1).VDQ.add(i, ((JSONArray)localObject2).optString(i));
        i += 1;
        continue;
        if (1 == paramJSONObject.optInt("expired_flag", 0))
        {
          ((Bankcard)localObject1).field_bankcardState = 1;
          continue;
        }
      }
      int i = 0;
      continue;
      label1503:
      if ("0".equals(localObject2))
      {
        ((Bankcard)localObject1).field_support_micropay = false;
        continue;
        label1523:
        ((Bankcard)localObject1).VDR = paramJSONObject.optString("fetch_limit_recommend_wording");
        if (!Util.isNullOrNil(((Bankcard)localObject1).VDR))
        {
          ((Bankcard)localObject1).VDS = paramJSONObject.optString("fetch_limit_recommend_bank_logo");
          ((Bankcard)localObject1).VDU = paramJSONObject.optString("fetch_limit_recommend_action_wording");
          ((Bankcard)localObject1).VDT = paramJSONObject.optInt("fetch_limit_recommend_action", 0);
          paramJSONObject = paramJSONObject.optJSONArray("fetch_limit_recommend_bind_serial");
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
          {
            ((Bankcard)localObject1).VDV = new ArrayList();
            i = 0;
            while (i < paramJSONObject.length())
            {
              ((Bankcard)localObject1).VDV.add(i, paramJSONObject.optString(i));
              i += 1;
            }
          }
        }
        g((Bankcard)localObject1);
        AppMethodBeat.o(70227);
        return localObject1;
        localObject1 = paramJSONObject;
        break;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.d
 * JD-Core Version:    0.7.0.1
 */