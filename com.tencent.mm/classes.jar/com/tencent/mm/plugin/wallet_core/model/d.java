package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.mo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static d qtR = null;
  
  public static Bankcard a(mo parammo)
  {
    boolean bool = true;
    y.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[] { parammo });
    Bankcard localBankcard = new Bankcard();
    for (;;)
    {
      try
      {
        localBankcard.field_bankName = parammo.lnT;
        localBankcard.field_bankcardTypeName = parammo.szQ;
        localBankcard.field_bankcardType = parammo.mOb;
        localBankcard.field_bindSerial = parammo.mOc;
        y.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { localBankcard.field_bindSerial });
        if (2 != bk.getInt(parammo.szO, 2)) {
          break label666;
        }
        i = 1;
        if (i != 0) {
          localBankcard.field_cardType |= Bankcard.qtm;
        }
        if ("NORMAL".equals(parammo.sJH)) {
          break label671;
        }
        i = 1;
        if (i != 0) {
          localBankcard.field_cardType |= Bankcard.qtn;
        }
        if (!bk.bl(parammo.bSe)) {
          localBankcard.field_mobile = URLDecoder.decode(parammo.bSe.replaceAll("x", "%"), "utf-8");
        }
        localBankcard.field_onceQuotaKind = (bk.getDouble(parammo.sJD, 0.0D) / 100.0D);
        localBankcard.field_onceQuotaVirtual = (bk.getDouble(parammo.sJB, 0.0D) / 100.0D);
        localBankcard.field_dayQuotaKind = (bk.getDouble(parammo.sJz, 0.0D) / 100.0D);
        localBankcard.field_dayQuotaVirtual = (bk.getDouble(parammo.sJx, 0.0D) / 100.0D);
        localBankcard.field_bankcardTail = parammo.szP;
        localBankcard.field_forbidWord = parammo.mOd;
        localBankcard.field_repay_url = parammo.rQV;
        localBankcard.field_wxcreditState = 2;
        if (!bk.bl(localBankcard.field_forbidWord))
        {
          localBankcard.field_bankcardState = 8;
          localBankcard.field_bankPhone = parammo.qvi;
          localBankcard.field_fetchArriveTime = (bk.getLong(parammo.sJM, 0L) * 1000L);
          localBankcard.field_fetchArriveTimeWording = parammo.sJY;
          localBankcard.field_bankcardTag = bk.getInt(parammo.sJE, 1);
          if (localBankcard.field_bankcardTag != 2) {
            break label656;
          }
          i = 1;
          if (i != 0) {
            localBankcard.field_cardType |= Bankcard.qtl;
          }
          if (parammo.sJJ != 1) {
            break label661;
          }
          localBankcard.field_support_micropay = bool;
          y.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + parammo.sJJ);
          localBankcard.field_arrive_type = parammo.sJS;
          localBankcard.field_avail_save_wording = parammo.sJU;
          i = parammo.sJZ;
          y.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
          localBankcard.field_fetch_charge_rate = (i / 10000.0D);
          y.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + localBankcard.field_fetch_charge_rate);
          i = parammo.sKa;
          y.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + localBankcard.field_full_fetch_charge_fee);
          localBankcard.field_full_fetch_charge_fee = (i / 100.0D);
          localBankcard.field_fetch_charge_info = parammo.sKb;
          localBankcard.field_tips = parammo.ioU;
          localBankcard.field_forbid_title = parammo.szH;
          localBankcard.field_forbid_url = parammo.szI;
          localBankcard.field_no_micro_word = parammo.sJT;
          localBankcard.field_card_bottom_wording = parammo.sKh;
          localBankcard.field_support_lqt_turn_in = parammo.sKk;
          localBankcard.field_support_lqt_turn_out = parammo.sKl;
          localBankcard.field_is_hightlight_pre_arrive_time_wording = parammo.sKj;
          d(localBankcard);
          return localBankcard;
        }
        if (1 == bk.getInt(parammo.sJA, 0))
        {
          localBankcard.field_bankcardState = 1;
          continue;
        }
        if (bk.getInt(parammo.qvh, 1) != 0) {
          break label648;
        }
      }
      catch (Exception parammo)
      {
        y.printErrStackTrace("MicroMsg.BankcardParser", parammo, "parseFromBindQueryRecord() error:" + parammo.getMessage(), new Object[0]);
        return null;
      }
      localBankcard.field_bankcardState = 2;
      continue;
      label648:
      localBankcard.field_bankcardState = 0;
      continue;
      label656:
      int i = 0;
      continue;
      label661:
      bool = false;
      continue;
      label666:
      i = 0;
      continue;
      label671:
      i = 0;
    }
  }
  
  public static d bUV()
  {
    if (qtR == null) {
      qtR = new d();
    }
    return qtR;
  }
  
  public static void d(Bankcard paramBankcard)
  {
    if (paramBankcard == null) {
      return;
    }
    if (paramBankcard.bUQ())
    {
      paramBankcard.field_desc = paramBankcard.field_bankName;
      return;
    }
    if (paramBankcard.bUU())
    {
      paramBankcard.field_desc = ae.getContext().getString(a.i.wallet_honeypay_card_desc, new Object[] { paramBankcard.qtO, e.dQ(paramBankcard.qtL, 8) });
      return;
    }
    if (paramBankcard.bUS())
    {
      paramBankcard.field_desc = ae.getContext().getString(a.i.wallet_credit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      return;
    }
    if (paramBankcard.bUP())
    {
      paramBankcard.field_desc = ae.getContext().getString(a.i.wallet_wxcredit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      return;
    }
    paramBankcard.field_desc = ae.getContext().getString(a.i.wallet_deposit_card_desc, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
  }
  
  public Bankcard am(JSONObject paramJSONObject)
  {
    int j = 1;
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = "";
      y.i("MicroMsg.BankcardParser", "parseJson jsonBankcard %s", new Object[] { localObject1 });
      localObject1 = new Bankcard();
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        ((Bankcard)localObject1).field_bankName = paramJSONObject.getString("bank_name");
        ((Bankcard)localObject1).field_bankcardTypeName = paramJSONObject.optString("bankacc_type_name");
        ((Bankcard)localObject1).field_bankcardType = paramJSONObject.getString("bank_type");
        ((Bankcard)localObject1).field_bindSerial = paramJSONObject.optString("bind_serial");
        y.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { ((Bankcard)localObject1).field_bindSerial });
        ((Bankcard)localObject1).qtw = paramJSONObject.optString("h_bind_serialno");
        if (2 != paramJSONObject.optInt("bankacc_type", 0)) {
          break label1183;
        }
        i = 1;
        if (i != 0) {
          ((Bankcard)localObject1).field_cardType |= Bankcard.qtm;
        }
        if ("NORMAL".equals(paramJSONObject.optString("extra_bind_flag"))) {
          break label1188;
        }
        i = 1;
        if (i != 0) {
          ((Bankcard)localObject1).field_cardType |= Bankcard.qtn;
        }
        if ("QMF".equals(((Bankcard)localObject1).field_bankcardType))
        {
          ((Bankcard)localObject1).field_cardType |= Bankcard.qts;
          localObject2 = paramJSONObject.optJSONObject("qmfCardInfo");
          if (localObject2 != null)
          {
            ((Bankcard)localObject1).qtI = ((JSONObject)localObject2).optLong("total_credit_line", 0L);
            ((Bankcard)localObject1).qtJ = ((JSONObject)localObject2).optLong("use_credit_line", 0L);
            ((Bankcard)localObject1).qtK = ((JSONObject)localObject2).optLong("unuse_credit_line", 0L);
            ((Bankcard)localObject1).qtL = ((JSONObject)localObject2).optString("payer_username", "");
            ((Bankcard)localObject1).qtM = ((JSONObject)localObject2).optInt("hide_credit_line", 0);
            ((Bankcard)localObject1).qtN = ((JSONObject)localObject2).optInt("card_type", 0);
            ((Bankcard)localObject1).qtO = ((JSONObject)localObject2).optString("card_type_name", "");
            ((Bankcard)localObject1).qtP = ((JSONObject)localObject2).optString("icon_url", "");
          }
        }
        ((Bankcard)localObject1).field_mobile = URLDecoder.decode(paramJSONObject.optString("mobile").replaceAll("x", "%"), "utf-8");
        if (bk.bl(((Bankcard)localObject1).field_mobile)) {
          ((Bankcard)localObject1).field_mobile = paramJSONObject.optString("mobile_mask");
        }
        ((Bankcard)localObject1).field_onceQuotaKind = (paramJSONObject.optDouble("once_quota_3") / 100.0D);
        ((Bankcard)localObject1).field_onceQuotaVirtual = (paramJSONObject.optDouble("once_quota_1") / 100.0D);
        ((Bankcard)localObject1).field_dayQuotaKind = (paramJSONObject.optDouble("day_quota_3") / 100.0D);
        ((Bankcard)localObject1).field_dayQuotaVirtual = (paramJSONObject.optDouble("day_quota_1") / 100.0D);
        ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("bind_tail");
        if (bk.bl(((Bankcard)localObject1).field_bankcardTail)) {
          ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("card_tail");
        }
        ((Bankcard)localObject1).qtu = paramJSONObject.optString("card_mask");
        ((Bankcard)localObject1).field_forbidWord = paramJSONObject.optString("forbid_word");
        ((Bankcard)localObject1).field_repay_url = paramJSONObject.optString("repay_url");
        ((Bankcard)localObject1).field_wxcreditState = 2;
        if (bk.bl(((Bankcard)localObject1).field_forbidWord)) {
          continue;
        }
        ((Bankcard)localObject1).field_bankcardState = 8;
      }
      catch (JSONException paramJSONObject)
      {
        y.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + paramJSONObject.getMessage());
        y.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        return null;
        if (paramJSONObject.optInt("bank_flag", 1) != 0) {
          continue;
        }
        ((Bankcard)localObject1).field_bankcardState = 2;
        continue;
      }
      catch (UnsupportedEncodingException paramJSONObject)
      {
        y.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + paramJSONObject.getMessage());
        y.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        return null;
        ((Bankcard)localObject1).field_bankcardState = 0;
        continue;
      }
      catch (Exception paramJSONObject)
      {
        y.i("MicroMsg.BankcardParser", "parseJson() Exception:" + paramJSONObject.getMessage());
        y.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        return null;
      }
      ((Bankcard)localObject1).field_bankPhone = paramJSONObject.optString("bank_phone");
      ((Bankcard)localObject1).field_fetchArriveTime = (paramJSONObject.optLong("fetch_pre_arrive_time") * 1000L);
      ((Bankcard)localObject1).field_fetchArriveTimeWording = paramJSONObject.optString("fetch_pre_arrive_time_wording");
      ((Bankcard)localObject1).field_bankcardTag = paramJSONObject.optInt("bank_card_tag", 1);
      if (((Bankcard)localObject1).field_bankcardTag == 2)
      {
        i = j;
        if (i != 0) {
          ((Bankcard)localObject1).field_cardType |= Bankcard.qtl;
        }
        localObject2 = paramJSONObject.optString("support_micropay");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Bankcard)localObject1).field_support_micropay = true;
        }
        if (!"1".equals(localObject2)) {
          break label1157;
        }
        ((Bankcard)localObject1).field_support_micropay = true;
        ((Bankcard)localObject1).field_arrive_type = paramJSONObject.optString("arrive_type");
        ((Bankcard)localObject1).field_avail_save_wording = paramJSONObject.optString("avail_save_wording");
        y.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramJSONObject.optString("support_micropay"));
        i = paramJSONObject.optInt("fetch_charge_rate", 0);
        y.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
        ((Bankcard)localObject1).field_fetch_charge_rate = (i / 10000.0D);
        y.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + ((Bankcard)localObject1).field_fetch_charge_rate);
        i = paramJSONObject.optInt("full_fetch_charge_fee", 0);
        y.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + ((Bankcard)localObject1).field_full_fetch_charge_fee);
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
        ((Bankcard)localObject1).qtQ = paramJSONObject.optInt("support_foreign_mobile", 0);
        ((Bankcard)localObject1).field_card_state_name = paramJSONObject.optString("card_state_name");
        d((Bankcard)localObject1);
        return localObject1;
        if (1 == paramJSONObject.optInt("expired_flag", 0))
        {
          ((Bankcard)localObject1).field_bankcardState = 1;
          continue;
        }
      }
      int i = 0;
      continue;
      label1157:
      if ("0".equals(localObject2))
      {
        ((Bankcard)localObject1).field_support_micropay = false;
        continue;
        localObject1 = paramJSONObject;
        break;
        label1183:
        i = 0;
        continue;
        label1188:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.d
 * JD-Core Version:    0.7.0.1
 */