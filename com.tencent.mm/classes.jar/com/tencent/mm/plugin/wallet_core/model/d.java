package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;
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
  private static d BuO = null;
  
  public static Bankcard a(sh paramsh)
  {
    boolean bool = true;
    AppMethodBeat.i(70229);
    ac.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[] { paramsh });
    Bankcard localBankcard = new Bankcard();
    for (;;)
    {
      try
      {
        localBankcard.field_bankName = paramsh.tGS;
        localBankcard.field_bankcardTypeName = paramsh.DVU;
        localBankcard.field_bankcardType = paramsh.cZz;
        localBankcard.field_bindSerial = paramsh.vwo;
        ac.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { localBankcard.field_bindSerial });
        if (2 == bs.getInt(paramsh.DVS, 2))
        {
          i = 1;
          if (i != 0) {
            localBankcard.field_cardType |= Bankcard.Bub;
          }
          if (!"NORMAL".equals(paramsh.ElJ))
          {
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.Buc;
            }
            if (!bs.isNullOrNil(paramsh.dnz)) {
              localBankcard.field_mobile = URLDecoder.decode(paramsh.dnz.replaceAll("x", "%"), "utf-8");
            }
            localBankcard.field_onceQuotaKind = e.b(paramsh.ElF, "100", RoundingMode.HALF_UP);
            localBankcard.field_onceQuotaVirtual = e.b(paramsh.ElD, "100", RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaKind = e.b(paramsh.ElB, "100", RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaVirtual = e.b(paramsh.Elz, "100", RoundingMode.HALF_UP);
            localBankcard.field_bankcardTail = paramsh.DVT;
            localBankcard.field_forbidWord = paramsh.vwp;
            localBankcard.field_repay_url = paramsh.DcG;
            localBankcard.field_wxcreditState = 2;
            if (bs.isNullOrNil(localBankcard.field_forbidWord)) {
              continue;
            }
            localBankcard.field_bankcardState = 8;
            localBankcard.field_bankPhone = paramsh.Bwb;
            localBankcard.field_fetchArriveTime = (bs.getLong(paramsh.ElO, 0L) * 1000L);
            localBankcard.field_fetchArriveTimeWording = paramsh.Ema;
            localBankcard.field_bankcardTag = bs.getInt(paramsh.ElG, 1);
            if (localBankcard.field_bankcardTag != 2) {
              break label715;
            }
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.Bua;
            }
            if (paramsh.ElL != 1) {
              break label720;
            }
            localBankcard.field_support_micropay = bool;
            ac.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramsh.ElL);
            localBankcard.field_arrive_type = paramsh.ElU;
            localBankcard.field_avail_save_wording = paramsh.ElW;
            i = paramsh.Emb;
            ac.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            localBankcard.field_fetch_charge_rate = (i / 10000.0D);
            ac.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + localBankcard.field_fetch_charge_rate);
            i = paramsh.Emc;
            ac.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + localBankcard.field_full_fetch_charge_fee);
            localBankcard.field_full_fetch_charge_fee = (i / 100.0D);
            localBankcard.field_fetch_charge_info = paramsh.Emd;
            localBankcard.field_tips = paramsh.nYv;
            localBankcard.field_forbid_title = paramsh.DVK;
            localBankcard.field_forbid_url = paramsh.DVL;
            localBankcard.field_no_micro_word = paramsh.ElV;
            localBankcard.field_card_bottom_wording = paramsh.Emj;
            localBankcard.field_support_lqt_turn_in = paramsh.Emm;
            localBankcard.field_support_lqt_turn_out = paramsh.Emn;
            localBankcard.field_is_hightlight_pre_arrive_time_wording = paramsh.Eml;
            if (paramsh.DVO != null)
            {
              localBankcard.field_prompt_info_prompt_text = paramsh.DVO.FvM;
              localBankcard.field_prompt_info_jump_text = paramsh.DVO.FvN;
              localBankcard.field_prompt_info_jump_url = paramsh.DVO.nWj;
            }
            e(localBankcard);
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
        if (1 == bs.getInt(paramsh.ElC, 0))
        {
          localBankcard.field_bankcardState = 1;
          continue;
        }
        if (bs.getInt(paramsh.Bwa, 1) != 0) {
          break label707;
        }
      }
      catch (Exception paramsh)
      {
        ac.printErrStackTrace("MicroMsg.BankcardParser", paramsh, "parseFromBindQueryRecord() error:" + paramsh.getMessage(), new Object[0]);
        AppMethodBeat.o(70229);
        return null;
      }
      localBankcard.field_bankcardState = 2;
      continue;
      label707:
      localBankcard.field_bankcardState = 0;
      continue;
      label715:
      int i = 0;
      continue;
      label720:
      bool = false;
    }
  }
  
  public static void e(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70230);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eqR())
    {
      paramBankcard.field_desc = paramBankcard.field_bankName;
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eqV())
    {
      paramBankcard.field_desc = ai.getContext().getString(2131765290, new Object[] { paramBankcard.BuG, e.gs(paramBankcard.BuD, 8) });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eqT())
    {
      paramBankcard.field_desc = ai.getContext().getString(2131765222, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eqQ())
    {
      paramBankcard.field_desc = ai.getContext().getString(2131765998, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eqW())
    {
      paramBankcard.field_desc = paramBankcard.BuM;
      AppMethodBeat.o(70230);
      return;
    }
    paramBankcard.field_desc = ai.getContext().getString(2131765242, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
    AppMethodBeat.o(70230);
  }
  
  public static d eqX()
  {
    AppMethodBeat.i(70226);
    if (BuO == null) {
      BuO = new d();
    }
    d locald = BuO;
    AppMethodBeat.o(70226);
    return locald;
  }
  
  public static List<Bankcard> gv(List<sh> paramList)
  {
    AppMethodBeat.i(70228);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ac.i("MicroMsg.BankcardParser", "record size: %s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((sh)paramList.next()));
      }
    }
    AppMethodBeat.o(70228);
    return localArrayList;
  }
  
  public Bankcard aS(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(70227);
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = "";
      ac.i("MicroMsg.BankcardParser", "parseJson jsonBankcard %s", new Object[] { localObject1 });
      localObject1 = new Bankcard();
    }
    int i;
    label136:
    label171:
    Object localObject2;
    try
    {
      ((Bankcard)localObject1).field_bankName = paramJSONObject.getString("bank_name");
      ((Bankcard)localObject1).field_bankcardTypeName = paramJSONObject.optString("bankacc_type_name");
      ((Bankcard)localObject1).field_bankcardType = paramJSONObject.getString("bank_type");
      ((Bankcard)localObject1).field_bindSerial = paramJSONObject.optString("bind_serial");
      ac.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { ((Bankcard)localObject1).field_bindSerial });
      ((Bankcard)localObject1).Bum = paramJSONObject.optString("h_bind_serialno");
      if (2 != paramJSONObject.optInt("bankacc_type", 0)) {
        break label1183;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.Bub;
      }
      if ("NORMAL".equals(paramJSONObject.optString("extra_bind_flag"))) {
        break label1188;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.Buc;
      }
      if ("QMF".equals(((Bankcard)localObject1).field_bankcardType))
      {
        ((Bankcard)localObject1).field_cardType |= Bankcard.Buh;
        localObject2 = paramJSONObject.optJSONObject("qmfCardInfo");
        if (localObject2 != null)
        {
          ((Bankcard)localObject1).BuA = ((JSONObject)localObject2).optLong("total_credit_line", 0L);
          ((Bankcard)localObject1).BuB = ((JSONObject)localObject2).optLong("use_credit_line", 0L);
          ((Bankcard)localObject1).BuC = ((JSONObject)localObject2).optLong("unuse_credit_line", 0L);
          ((Bankcard)localObject1).BuD = ((JSONObject)localObject2).optString("payer_username", "");
          ((Bankcard)localObject1).BuE = ((JSONObject)localObject2).optInt("hide_credit_line", 0);
          ((Bankcard)localObject1).BuF = ((JSONObject)localObject2).optInt("card_type", 0);
          ((Bankcard)localObject1).BuG = ((JSONObject)localObject2).optString("card_type_name", "");
          ((Bankcard)localObject1).BuH = ((JSONObject)localObject2).optString("icon_url", "");
        }
      }
      ((Bankcard)localObject1).field_mobile = URLDecoder.decode(paramJSONObject.optString("mobile").replaceAll("x", "%"), "utf-8");
      if (bs.isNullOrNil(((Bankcard)localObject1).field_mobile)) {
        ((Bankcard)localObject1).field_mobile = paramJSONObject.optString("mobile_mask");
      }
      ((Bankcard)localObject1).field_onceQuotaKind = (paramJSONObject.optDouble("once_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_onceQuotaVirtual = (paramJSONObject.optDouble("once_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaKind = (paramJSONObject.optDouble("day_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaVirtual = (paramJSONObject.optDouble("day_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("bind_tail");
      if (bs.isNullOrNil(((Bankcard)localObject1).field_bankcardTail)) {
        ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("card_tail");
      }
      ((Bankcard)localObject1).Buk = paramJSONObject.optString("card_mask");
      ((Bankcard)localObject1).field_forbidWord = paramJSONObject.optString("forbid_word");
      ((Bankcard)localObject1).field_repay_url = paramJSONObject.optString("repay_url");
      ((Bankcard)localObject1).field_wxcreditState = 2;
      if (bs.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) {
        break label1193;
      }
      ((Bankcard)localObject1).field_bankcardState = 8;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ac.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + paramJSONObject.getMessage());
        ac.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
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
        ac.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + paramJSONObject.getMessage());
        ac.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70227);
        return null;
        ((Bankcard)localObject1).field_bankcardState = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      label555:
      ac.i("MicroMsg.BankcardParser", "parseJson() Exception:" + paramJSONObject.getMessage());
      ac.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(70227);
      return null;
    }
    if (bs.lr("FQF", ((Bankcard)localObject1).field_bankcardType))
    {
      ((Bankcard)localObject1).field_cardType |= Bankcard.Bui;
      localObject2 = paramJSONObject.optJSONObject("fqf_info");
      if (localObject2 != null)
      {
        ((Bankcard)localObject1).BuL = ((JSONObject)localObject2).optString("fqf_pay_desk_title", "");
        ((Bankcard)localObject1).BuM = ((JSONObject)localObject2).optString("fqf_title", "");
        ((Bankcard)localObject1).BuN = ((JSONObject)localObject2).optString("fqf_sub_title", "");
      }
    }
    ((Bankcard)localObject1).AZE = paramJSONObject.optString("tinyapp_username", "");
    ((Bankcard)localObject1).AZF = paramJSONObject.optString("tinyapp_path", "");
    ((Bankcard)localObject1).field_bankPhone = paramJSONObject.optString("bank_phone");
    ((Bankcard)localObject1).field_fetchArriveTime = (paramJSONObject.optLong("fetch_pre_arrive_time") * 1000L);
    ((Bankcard)localObject1).field_fetchArriveTimeWording = paramJSONObject.optString("fetch_pre_arrive_time_wording");
    ((Bankcard)localObject1).field_bankcardTag = paramJSONObject.optInt("bank_card_tag", 1);
    if (((Bankcard)localObject1).field_bankcardTag == 2)
    {
      i = j;
      label739:
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.Bua;
      }
      localObject2 = paramJSONObject.optString("support_micropay");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Bankcard)localObject1).field_support_micropay = true;
      }
      if (!"1".equals(localObject2)) {
        break label1389;
      }
      ((Bankcard)localObject1).field_support_micropay = true;
    }
    for (;;)
    {
      ((Bankcard)localObject1).field_arrive_type = paramJSONObject.optString("arrive_type");
      ((Bankcard)localObject1).field_avail_save_wording = paramJSONObject.optString("avail_save_wording");
      ac.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramJSONObject.optString("support_micropay"));
      i = paramJSONObject.optInt("fetch_charge_rate", 0);
      ac.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
      ((Bankcard)localObject1).field_fetch_charge_rate = (i / 10000.0D);
      ac.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + ((Bankcard)localObject1).field_fetch_charge_rate);
      i = paramJSONObject.optInt("full_fetch_charge_fee", 0);
      ac.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + ((Bankcard)localObject1).field_full_fetch_charge_fee);
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
      ((Bankcard)localObject1).BuI = paramJSONObject.optInt("support_foreign_mobile", 0);
      ((Bankcard)localObject1).field_card_state_name = paramJSONObject.optString("card_state_name");
      ((Bankcard)localObject1).BuJ = paramJSONObject.optString("card_fetch_wording");
      ((Bankcard)localObject1).BuK = paramJSONObject.optLong("card_min_charge_fee");
      paramJSONObject = paramJSONObject.optJSONObject("prompt_info");
      if (paramJSONObject != null)
      {
        ((Bankcard)localObject1).field_prompt_info_prompt_text = paramJSONObject.optString("prompt_text");
        ((Bankcard)localObject1).field_prompt_info_jump_text = paramJSONObject.optString("jump_text");
        ((Bankcard)localObject1).field_prompt_info_jump_url = paramJSONObject.optString("jump_url");
      }
      e((Bankcard)localObject1);
      AppMethodBeat.o(70227);
      return localObject1;
      localObject1 = paramJSONObject;
      break;
      label1183:
      i = 0;
      break label136;
      label1188:
      i = 0;
      break label171;
      label1193:
      if (1 == paramJSONObject.optInt("expired_flag", 0))
      {
        ((Bankcard)localObject1).field_bankcardState = 1;
        break label555;
      }
      i = 0;
      break label739;
      label1389:
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