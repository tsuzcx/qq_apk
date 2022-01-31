package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static f ugm = null;
  
  public static Bankcard a(po parampo)
  {
    boolean bool = true;
    AppMethodBeat.i(46718);
    ab.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[] { parampo });
    Bankcard localBankcard = new Bankcard();
    for (;;)
    {
      try
      {
        localBankcard.field_bankName = parampo.nLq;
        localBankcard.field_bankcardTypeName = parampo.wtR;
        localBankcard.field_bankcardType = parampo.poq;
        localBankcard.field_bindSerial = parampo.por;
        ab.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { localBankcard.field_bindSerial });
        if (2 == bo.getInt(parampo.wtP, 2))
        {
          i = 1;
          if (i != 0) {
            localBankcard.field_cardType |= Bankcard.ufz;
          }
          if (!"NORMAL".equals(parampo.wHq))
          {
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.ufA;
            }
            if (!bo.isNullOrNil(parampo.czF)) {
              localBankcard.field_mobile = URLDecoder.decode(parampo.czF.replaceAll("x", "%"), "utf-8");
            }
            localBankcard.field_onceQuotaKind = e.b(parampo.wHm, "100", RoundingMode.HALF_UP);
            localBankcard.field_onceQuotaVirtual = e.b(parampo.wHk, "100", RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaKind = e.b(parampo.wHi, "100", RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaVirtual = e.b(parampo.wHg, "100", RoundingMode.HALF_UP);
            localBankcard.field_bankcardTail = parampo.wtQ;
            localBankcard.field_forbidWord = parampo.pot;
            localBankcard.field_repay_url = parampo.vHM;
            localBankcard.field_wxcreditState = 2;
            if (bo.isNullOrNil(localBankcard.field_forbidWord)) {
              continue;
            }
            localBankcard.field_bankcardState = 8;
            localBankcard.field_bankPhone = parampo.uhA;
            localBankcard.field_fetchArriveTime = (bo.getLong(parampo.wHv, 0L) * 1000L);
            localBankcard.field_fetchArriveTimeWording = parampo.wHH;
            localBankcard.field_bankcardTag = bo.getInt(parampo.wHn, 1);
            if (localBankcard.field_bankcardTag != 2) {
              break label675;
            }
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.ufy;
            }
            if (parampo.wHs != 1) {
              break label680;
            }
            localBankcard.field_support_micropay = bool;
            ab.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + parampo.wHs);
            localBankcard.field_arrive_type = parampo.wHB;
            localBankcard.field_avail_save_wording = parampo.wHD;
            i = parampo.wHI;
            ab.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            localBankcard.field_fetch_charge_rate = (i / 10000.0D);
            ab.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + localBankcard.field_fetch_charge_rate);
            i = parampo.wHJ;
            ab.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + localBankcard.field_full_fetch_charge_fee);
            localBankcard.field_full_fetch_charge_fee = (i / 100.0D);
            localBankcard.field_fetch_charge_info = parampo.wHK;
            localBankcard.field_tips = parampo.kqb;
            localBankcard.field_forbid_title = parampo.wtI;
            localBankcard.field_forbid_url = parampo.wtJ;
            localBankcard.field_no_micro_word = parampo.wHC;
            localBankcard.field_card_bottom_wording = parampo.wHQ;
            localBankcard.field_support_lqt_turn_in = parampo.wHT;
            localBankcard.field_support_lqt_turn_out = parampo.wHU;
            localBankcard.field_is_hightlight_pre_arrive_time_wording = parampo.wHS;
            e(localBankcard);
            AppMethodBeat.o(46718);
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
        if (1 == bo.getInt(parampo.wHj, 0))
        {
          localBankcard.field_bankcardState = 1;
          continue;
        }
        if (bo.getInt(parampo.uhz, 1) != 0) {
          break label667;
        }
      }
      catch (Exception parampo)
      {
        ab.printErrStackTrace("MicroMsg.BankcardParser", parampo, "parseFromBindQueryRecord() error:" + parampo.getMessage(), new Object[0]);
        AppMethodBeat.o(46718);
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
  
  public static f cTl()
  {
    AppMethodBeat.i(46715);
    if (ugm == null) {
      ugm = new f();
    }
    f localf = ugm;
    AppMethodBeat.o(46715);
    return localf;
  }
  
  public static List<Bankcard> dU(List<po> paramList)
  {
    AppMethodBeat.i(46717);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ab.i("MicroMsg.BankcardParser", "record size: %s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((po)paramList.next()));
      }
    }
    AppMethodBeat.o(46717);
    return localArrayList;
  }
  
  public static void e(Bankcard paramBankcard)
  {
    AppMethodBeat.i(46719);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(46719);
      return;
    }
    if (paramBankcard.cTf())
    {
      paramBankcard.field_desc = paramBankcard.field_bankName;
      AppMethodBeat.o(46719);
      return;
    }
    if (paramBankcard.cTj())
    {
      paramBankcard.field_desc = ah.getContext().getString(2131305098, new Object[] { paramBankcard.ugd, e.fa(paramBankcard.uga, 8) });
      AppMethodBeat.o(46719);
      return;
    }
    if (paramBankcard.cTh())
    {
      paramBankcard.field_desc = ah.getContext().getString(2131305030, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(46719);
      return;
    }
    if (paramBankcard.cTe())
    {
      paramBankcard.field_desc = ah.getContext().getString(2131305778, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(46719);
      return;
    }
    if (paramBankcard.cTk())
    {
      paramBankcard.field_desc = paramBankcard.ugj;
      AppMethodBeat.o(46719);
      return;
    }
    paramBankcard.field_desc = ah.getContext().getString(2131305050, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
    AppMethodBeat.o(46719);
  }
  
  public Bankcard aw(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(46716);
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = "";
      ab.i("MicroMsg.BankcardParser", "parseJson jsonBankcard %s", new Object[] { localObject1 });
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
      ab.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { ((Bankcard)localObject1).field_bindSerial });
      ((Bankcard)localObject1).ufK = paramJSONObject.optString("h_bind_serialno");
      if (2 != paramJSONObject.optInt("bankacc_type", 0)) {
        break label1135;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.ufz;
      }
      if ("NORMAL".equals(paramJSONObject.optString("extra_bind_flag"))) {
        break label1140;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.ufA;
      }
      if ("QMF".equals(((Bankcard)localObject1).field_bankcardType))
      {
        ((Bankcard)localObject1).field_cardType |= Bankcard.ufF;
        localObject2 = paramJSONObject.optJSONObject("qmfCardInfo");
        if (localObject2 != null)
        {
          ((Bankcard)localObject1).ufX = ((JSONObject)localObject2).optLong("total_credit_line", 0L);
          ((Bankcard)localObject1).ufY = ((JSONObject)localObject2).optLong("use_credit_line", 0L);
          ((Bankcard)localObject1).ufZ = ((JSONObject)localObject2).optLong("unuse_credit_line", 0L);
          ((Bankcard)localObject1).uga = ((JSONObject)localObject2).optString("payer_username", "");
          ((Bankcard)localObject1).ugb = ((JSONObject)localObject2).optInt("hide_credit_line", 0);
          ((Bankcard)localObject1).ugc = ((JSONObject)localObject2).optInt("card_type", 0);
          ((Bankcard)localObject1).ugd = ((JSONObject)localObject2).optString("card_type_name", "");
          ((Bankcard)localObject1).uge = ((JSONObject)localObject2).optString("icon_url", "");
        }
      }
      ((Bankcard)localObject1).field_mobile = URLDecoder.decode(paramJSONObject.optString("mobile").replaceAll("x", "%"), "utf-8");
      if (bo.isNullOrNil(((Bankcard)localObject1).field_mobile)) {
        ((Bankcard)localObject1).field_mobile = paramJSONObject.optString("mobile_mask");
      }
      ((Bankcard)localObject1).field_onceQuotaKind = (paramJSONObject.optDouble("once_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_onceQuotaVirtual = (paramJSONObject.optDouble("once_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaKind = (paramJSONObject.optDouble("day_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaVirtual = (paramJSONObject.optDouble("day_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("bind_tail");
      if (bo.isNullOrNil(((Bankcard)localObject1).field_bankcardTail)) {
        ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("card_tail");
      }
      ((Bankcard)localObject1).ufI = paramJSONObject.optString("card_mask");
      ((Bankcard)localObject1).field_forbidWord = paramJSONObject.optString("forbid_word");
      ((Bankcard)localObject1).field_repay_url = paramJSONObject.optString("repay_url");
      ((Bankcard)localObject1).field_wxcreditState = 2;
      if (bo.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) {
        break label1145;
      }
      ((Bankcard)localObject1).field_bankcardState = 8;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ab.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + paramJSONObject.getMessage());
        ab.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(46716);
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
        ab.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + paramJSONObject.getMessage());
        ab.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(46716);
        return null;
        ((Bankcard)localObject1).field_bankcardState = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      label555:
      ab.i("MicroMsg.BankcardParser", "parseJson() Exception:" + paramJSONObject.getMessage());
      ab.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(46716);
      return null;
    }
    if (bo.isEqual("FQF", ((Bankcard)localObject1).field_bankcardType))
    {
      ((Bankcard)localObject1).field_cardType |= Bankcard.ufG;
      localObject2 = paramJSONObject.optJSONObject("fqf_info");
      if (localObject2 != null)
      {
        ((Bankcard)localObject1).ugi = ((JSONObject)localObject2).optString("fqf_pay_desk_title", "");
        ((Bankcard)localObject1).ugj = ((JSONObject)localObject2).optString("fqf_title", "");
        ((Bankcard)localObject1).ugk = ((JSONObject)localObject2).optString("fqf_sub_title", "");
      }
    }
    ((Bankcard)localObject1).ugl = paramJSONObject.optString("tinyapp_username", "");
    ((Bankcard)localObject1).uaL = paramJSONObject.optString("tinyapp_path", "");
    ((Bankcard)localObject1).field_bankPhone = paramJSONObject.optString("bank_phone");
    ((Bankcard)localObject1).field_fetchArriveTime = (paramJSONObject.optLong("fetch_pre_arrive_time") * 1000L);
    ((Bankcard)localObject1).field_fetchArriveTimeWording = paramJSONObject.optString("fetch_pre_arrive_time_wording");
    ((Bankcard)localObject1).field_bankcardTag = paramJSONObject.optInt("bank_card_tag", 1);
    if (((Bankcard)localObject1).field_bankcardTag == 2)
    {
      i = j;
      label739:
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.ufy;
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
      ab.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramJSONObject.optString("support_micropay"));
      i = paramJSONObject.optInt("fetch_charge_rate", 0);
      ab.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
      ((Bankcard)localObject1).field_fetch_charge_rate = (i / 10000.0D);
      ab.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + ((Bankcard)localObject1).field_fetch_charge_rate);
      i = paramJSONObject.optInt("full_fetch_charge_fee", 0);
      ab.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + ((Bankcard)localObject1).field_full_fetch_charge_fee);
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
      ((Bankcard)localObject1).ugf = paramJSONObject.optInt("support_foreign_mobile", 0);
      ((Bankcard)localObject1).field_card_state_name = paramJSONObject.optString("card_state_name");
      ((Bankcard)localObject1).ugg = paramJSONObject.optString("card_fetch_wording");
      ((Bankcard)localObject1).ugh = paramJSONObject.optLong("card_min_charge_fee");
      e((Bankcard)localObject1);
      AppMethodBeat.o(46716);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.f
 * JD-Core Version:    0.7.0.1
 */