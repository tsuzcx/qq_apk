package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static d Acu = null;
  
  public static Bankcard a(rx paramrx)
  {
    boolean bool = true;
    AppMethodBeat.i(70229);
    ad.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[] { paramrx });
    Bankcard localBankcard = new Bankcard();
    for (;;)
    {
      try
      {
        localBankcard.field_bankName = paramrx.szi;
        localBankcard.field_bankcardTypeName = paramrx.CDw;
        localBankcard.field_bankcardType = paramrx.dca;
        localBankcard.field_bindSerial = paramrx.uns;
        ad.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { localBankcard.field_bindSerial });
        if (2 == bt.getInt(paramrx.CDu, 2))
        {
          i = 1;
          if (i != 0) {
            localBankcard.field_cardType |= Bankcard.AbH;
          }
          if (!"NORMAL".equals(paramrx.CSY))
          {
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.AbI;
            }
            if (!bt.isNullOrNil(paramrx.dpO)) {
              localBankcard.field_mobile = URLDecoder.decode(paramrx.dpO.replaceAll("x", "%"), "utf-8");
            }
            localBankcard.field_onceQuotaKind = e.b(paramrx.CSU, "100", RoundingMode.HALF_UP);
            localBankcard.field_onceQuotaVirtual = e.b(paramrx.CSS, "100", RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaKind = e.b(paramrx.CSQ, "100", RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaVirtual = e.b(paramrx.CSO, "100", RoundingMode.HALF_UP);
            localBankcard.field_bankcardTail = paramrx.CDv;
            localBankcard.field_forbidWord = paramrx.unt;
            localBankcard.field_repay_url = paramrx.BKy;
            localBankcard.field_wxcreditState = 2;
            if (bt.isNullOrNil(localBankcard.field_forbidWord)) {
              continue;
            }
            localBankcard.field_bankcardState = 8;
            localBankcard.field_bankPhone = paramrx.AdH;
            localBankcard.field_fetchArriveTime = (bt.getLong(paramrx.CTd, 0L) * 1000L);
            localBankcard.field_fetchArriveTimeWording = paramrx.CTp;
            localBankcard.field_bankcardTag = bt.getInt(paramrx.CSV, 1);
            if (localBankcard.field_bankcardTag != 2) {
              break label675;
            }
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.AbG;
            }
            if (paramrx.CTa != 1) {
              break label680;
            }
            localBankcard.field_support_micropay = bool;
            ad.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramrx.CTa);
            localBankcard.field_arrive_type = paramrx.CTj;
            localBankcard.field_avail_save_wording = paramrx.CTl;
            i = paramrx.CTq;
            ad.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            localBankcard.field_fetch_charge_rate = (i / 10000.0D);
            ad.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + localBankcard.field_fetch_charge_rate);
            i = paramrx.CTr;
            ad.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + localBankcard.field_full_fetch_charge_fee);
            localBankcard.field_full_fetch_charge_fee = (i / 100.0D);
            localBankcard.field_fetch_charge_info = paramrx.CTs;
            localBankcard.field_tips = paramrx.nvv;
            localBankcard.field_forbid_title = paramrx.CDn;
            localBankcard.field_forbid_url = paramrx.CDo;
            localBankcard.field_no_micro_word = paramrx.CTk;
            localBankcard.field_card_bottom_wording = paramrx.CTy;
            localBankcard.field_support_lqt_turn_in = paramrx.CTB;
            localBankcard.field_support_lqt_turn_out = paramrx.CTC;
            localBankcard.field_is_hightlight_pre_arrive_time_wording = paramrx.CTA;
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
        if (1 == bt.getInt(paramrx.CSR, 0))
        {
          localBankcard.field_bankcardState = 1;
          continue;
        }
        if (bt.getInt(paramrx.AdG, 1) != 0) {
          break label667;
        }
      }
      catch (Exception paramrx)
      {
        ad.printErrStackTrace("MicroMsg.BankcardParser", paramrx, "parseFromBindQueryRecord() error:" + paramrx.getMessage(), new Object[0]);
        AppMethodBeat.o(70229);
        return null;
      }
      localBankcard.field_bankcardState = 2;
      continue;
      label667:
      localBankcard.field_bankcardState = 0;
      continue;
      label675:
      int i = 0;
      continue;
      label680:
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
    if (paramBankcard.ebv())
    {
      paramBankcard.field_desc = paramBankcard.field_bankName;
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.ebz())
    {
      paramBankcard.field_desc = aj.getContext().getString(2131765290, new Object[] { paramBankcard.Acm, e.go(paramBankcard.Acj, 8) });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.ebx())
    {
      paramBankcard.field_desc = aj.getContext().getString(2131765222, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.ebu())
    {
      paramBankcard.field_desc = aj.getContext().getString(2131765998, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.ebA())
    {
      paramBankcard.field_desc = paramBankcard.Acs;
      AppMethodBeat.o(70230);
      return;
    }
    paramBankcard.field_desc = aj.getContext().getString(2131765242, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
    AppMethodBeat.o(70230);
  }
  
  public static d ebB()
  {
    AppMethodBeat.i(70226);
    if (Acu == null) {
      Acu = new d();
    }
    d locald = Acu;
    AppMethodBeat.o(70226);
    return locald;
  }
  
  public static List<Bankcard> gk(List<rx> paramList)
  {
    AppMethodBeat.i(70228);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ad.i("MicroMsg.BankcardParser", "record size: %s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((rx)paramList.next()));
      }
    }
    AppMethodBeat.o(70228);
    return localArrayList;
  }
  
  public Bankcard aR(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(70227);
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = "";
      ad.i("MicroMsg.BankcardParser", "parseJson jsonBankcard %s", new Object[] { localObject1 });
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
      ad.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { ((Bankcard)localObject1).field_bindSerial });
      ((Bankcard)localObject1).AbS = paramJSONObject.optString("h_bind_serialno");
      if (2 != paramJSONObject.optInt("bankacc_type", 0)) {
        break label1135;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.AbH;
      }
      if ("NORMAL".equals(paramJSONObject.optString("extra_bind_flag"))) {
        break label1140;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.AbI;
      }
      if ("QMF".equals(((Bankcard)localObject1).field_bankcardType))
      {
        ((Bankcard)localObject1).field_cardType |= Bankcard.AbN;
        localObject2 = paramJSONObject.optJSONObject("qmfCardInfo");
        if (localObject2 != null)
        {
          ((Bankcard)localObject1).Acg = ((JSONObject)localObject2).optLong("total_credit_line", 0L);
          ((Bankcard)localObject1).Ach = ((JSONObject)localObject2).optLong("use_credit_line", 0L);
          ((Bankcard)localObject1).Aci = ((JSONObject)localObject2).optLong("unuse_credit_line", 0L);
          ((Bankcard)localObject1).Acj = ((JSONObject)localObject2).optString("payer_username", "");
          ((Bankcard)localObject1).Ack = ((JSONObject)localObject2).optInt("hide_credit_line", 0);
          ((Bankcard)localObject1).Acl = ((JSONObject)localObject2).optInt("card_type", 0);
          ((Bankcard)localObject1).Acm = ((JSONObject)localObject2).optString("card_type_name", "");
          ((Bankcard)localObject1).Acn = ((JSONObject)localObject2).optString("icon_url", "");
        }
      }
      ((Bankcard)localObject1).field_mobile = URLDecoder.decode(paramJSONObject.optString("mobile").replaceAll("x", "%"), "utf-8");
      if (bt.isNullOrNil(((Bankcard)localObject1).field_mobile)) {
        ((Bankcard)localObject1).field_mobile = paramJSONObject.optString("mobile_mask");
      }
      ((Bankcard)localObject1).field_onceQuotaKind = (paramJSONObject.optDouble("once_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_onceQuotaVirtual = (paramJSONObject.optDouble("once_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaKind = (paramJSONObject.optDouble("day_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaVirtual = (paramJSONObject.optDouble("day_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("bind_tail");
      if (bt.isNullOrNil(((Bankcard)localObject1).field_bankcardTail)) {
        ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("card_tail");
      }
      ((Bankcard)localObject1).AbQ = paramJSONObject.optString("card_mask");
      ((Bankcard)localObject1).field_forbidWord = paramJSONObject.optString("forbid_word");
      ((Bankcard)localObject1).field_repay_url = paramJSONObject.optString("repay_url");
      ((Bankcard)localObject1).field_wxcreditState = 2;
      if (bt.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) {
        break label1145;
      }
      ((Bankcard)localObject1).field_bankcardState = 8;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ad.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + paramJSONObject.getMessage());
        ad.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
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
        ad.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + paramJSONObject.getMessage());
        ad.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70227);
        return null;
        ((Bankcard)localObject1).field_bankcardState = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      label555:
      ad.i("MicroMsg.BankcardParser", "parseJson() Exception:" + paramJSONObject.getMessage());
      ad.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(70227);
      return null;
    }
    if (bt.kU("FQF", ((Bankcard)localObject1).field_bankcardType))
    {
      ((Bankcard)localObject1).field_cardType |= Bankcard.AbO;
      localObject2 = paramJSONObject.optJSONObject("fqf_info");
      if (localObject2 != null)
      {
        ((Bankcard)localObject1).Acr = ((JSONObject)localObject2).optString("fqf_pay_desk_title", "");
        ((Bankcard)localObject1).Acs = ((JSONObject)localObject2).optString("fqf_title", "");
        ((Bankcard)localObject1).Act = ((JSONObject)localObject2).optString("fqf_sub_title", "");
      }
    }
    ((Bankcard)localObject1).zHs = paramJSONObject.optString("tinyapp_username", "");
    ((Bankcard)localObject1).zHt = paramJSONObject.optString("tinyapp_path", "");
    ((Bankcard)localObject1).field_bankPhone = paramJSONObject.optString("bank_phone");
    ((Bankcard)localObject1).field_fetchArriveTime = (paramJSONObject.optLong("fetch_pre_arrive_time") * 1000L);
    ((Bankcard)localObject1).field_fetchArriveTimeWording = paramJSONObject.optString("fetch_pre_arrive_time_wording");
    ((Bankcard)localObject1).field_bankcardTag = paramJSONObject.optInt("bank_card_tag", 1);
    if (((Bankcard)localObject1).field_bankcardTag == 2)
    {
      i = j;
      label739:
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.AbG;
      }
      localObject2 = paramJSONObject.optString("support_micropay");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Bankcard)localObject1).field_support_micropay = true;
      }
      if (!"1".equals(localObject2)) {
        break label1341;
      }
      ((Bankcard)localObject1).field_support_micropay = true;
    }
    for (;;)
    {
      ((Bankcard)localObject1).field_arrive_type = paramJSONObject.optString("arrive_type");
      ((Bankcard)localObject1).field_avail_save_wording = paramJSONObject.optString("avail_save_wording");
      ad.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramJSONObject.optString("support_micropay"));
      i = paramJSONObject.optInt("fetch_charge_rate", 0);
      ad.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
      ((Bankcard)localObject1).field_fetch_charge_rate = (i / 10000.0D);
      ad.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + ((Bankcard)localObject1).field_fetch_charge_rate);
      i = paramJSONObject.optInt("full_fetch_charge_fee", 0);
      ad.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + ((Bankcard)localObject1).field_full_fetch_charge_fee);
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
      ((Bankcard)localObject1).Aco = paramJSONObject.optInt("support_foreign_mobile", 0);
      ((Bankcard)localObject1).field_card_state_name = paramJSONObject.optString("card_state_name");
      ((Bankcard)localObject1).Acp = paramJSONObject.optString("card_fetch_wording");
      ((Bankcard)localObject1).Acq = paramJSONObject.optLong("card_min_charge_fee");
      e((Bankcard)localObject1);
      AppMethodBeat.o(70227);
      return localObject1;
      localObject1 = paramJSONObject;
      break;
      label1135:
      i = 0;
      break label136;
      label1140:
      i = 0;
      break label171;
      label1145:
      if (1 == paramJSONObject.optInt("expired_flag", 0))
      {
        ((Bankcard)localObject1).field_bankcardState = 1;
        break label555;
      }
      i = 0;
      break label739;
      label1341:
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