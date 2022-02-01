package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static d DmJ = null;
  
  public static Bankcard a(ud paramud)
  {
    boolean bool = true;
    AppMethodBeat.i(70229);
    ae.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[] { paramud });
    Bankcard localBankcard = new Bankcard();
    for (;;)
    {
      try
      {
        localBankcard.field_bankName = paramud.uVs;
        localBankcard.field_bankcardTypeName = paramud.FTL;
        localBankcard.field_bankcardType = paramud.dlT;
        localBankcard.field_bindSerial = paramud.wRt;
        ae.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { localBankcard.field_bindSerial });
        if (2 == bu.getInt(paramud.FTJ, 2))
        {
          i = 1;
          if (i != 0) {
            localBankcard.field_cardType |= Bankcard.DlW;
          }
          if (!"NORMAL".equals(paramud.Glq))
          {
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.DlX;
            }
            if (!bu.isNullOrNil(paramud.dAs)) {
              localBankcard.field_mobile = URLDecoder.decode(paramud.dAs.replaceAll("x", "%"), "utf-8");
            }
            localBankcard.field_onceQuotaKind = f.a(paramud.Glm, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_onceQuotaVirtual = f.a(paramud.Glk, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaKind = f.a(paramud.Gli, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_dayQuotaVirtual = f.a(paramud.Glg, "100", 2, RoundingMode.HALF_UP);
            localBankcard.field_bankcardTail = paramud.FTK;
            localBankcard.field_forbidWord = paramud.wRu;
            localBankcard.field_repay_url = paramud.EZc;
            localBankcard.field_wxcreditState = 2;
            if (bu.isNullOrNil(localBankcard.field_forbidWord)) {
              continue;
            }
            localBankcard.field_bankcardState = 8;
            localBankcard.field_bankPhone = paramud.DnW;
            localBankcard.field_fetchArriveTime = (bu.getLong(paramud.Glv, 0L) * 1000L);
            localBankcard.field_fetchArriveTimeWording = paramud.GlH;
            localBankcard.field_bankcardTag = bu.getInt(paramud.Gln, 1);
            if (localBankcard.field_bankcardTag != 2) {
              break label719;
            }
            i = 1;
            if (i != 0) {
              localBankcard.field_cardType |= Bankcard.DlV;
            }
            if (paramud.Gls != 1) {
              break label724;
            }
            localBankcard.field_support_micropay = bool;
            ae.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramud.Gls);
            localBankcard.field_arrive_type = paramud.GlB;
            localBankcard.field_avail_save_wording = paramud.GlD;
            i = paramud.GlI;
            ae.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            localBankcard.field_fetch_charge_rate = (i / 10000.0D);
            ae.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + localBankcard.field_fetch_charge_rate);
            i = paramud.GlJ;
            ae.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + localBankcard.field_full_fetch_charge_fee);
            localBankcard.field_full_fetch_charge_fee = (i / 100.0D);
            localBankcard.field_fetch_charge_info = paramud.GlK;
            localBankcard.field_tips = paramud.oIr;
            localBankcard.field_forbid_title = paramud.FTB;
            localBankcard.field_forbid_url = paramud.FTC;
            localBankcard.field_no_micro_word = paramud.GlC;
            localBankcard.field_card_bottom_wording = paramud.GlQ;
            localBankcard.field_support_lqt_turn_in = paramud.GlT;
            localBankcard.field_support_lqt_turn_out = paramud.GlU;
            localBankcard.field_is_hightlight_pre_arrive_time_wording = paramud.GlS;
            if (paramud.FTF != null)
            {
              localBankcard.field_prompt_info_prompt_text = paramud.FTF.Hzs;
              localBankcard.field_prompt_info_jump_text = paramud.FTF.Hzt;
              localBankcard.field_prompt_info_jump_url = paramud.FTF.oGf;
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
        if (1 == bu.getInt(paramud.Glj, 0))
        {
          localBankcard.field_bankcardState = 1;
          continue;
        }
        if (bu.getInt(paramud.DnV, 1) != 0) {
          break label711;
        }
      }
      catch (Exception paramud)
      {
        ae.printErrStackTrace("MicroMsg.BankcardParser", paramud, "parseFromBindQueryRecord() error:" + paramud.getMessage(), new Object[0]);
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
  
  public static void e(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70230);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eIy())
    {
      paramBankcard.field_desc = paramBankcard.field_bankName;
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eIC())
    {
      paramBankcard.field_desc = ak.getContext().getString(2131765290, new Object[] { paramBankcard.DmB, f.gY(paramBankcard.Dmy, 8) });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eIA())
    {
      paramBankcard.field_desc = ak.getContext().getString(2131765222, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eIx())
    {
      paramBankcard.field_desc = ak.getContext().getString(2131765998, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
      AppMethodBeat.o(70230);
      return;
    }
    if (paramBankcard.eID())
    {
      paramBankcard.field_desc = paramBankcard.DmH;
      AppMethodBeat.o(70230);
      return;
    }
    paramBankcard.field_desc = ak.getContext().getString(2131765242, new Object[] { paramBankcard.field_bankName, paramBankcard.field_bankcardTail });
    AppMethodBeat.o(70230);
  }
  
  public static d eIE()
  {
    AppMethodBeat.i(70226);
    if (DmJ == null) {
      DmJ = new d();
    }
    d locald = DmJ;
    AppMethodBeat.o(70226);
    return locald;
  }
  
  public static List<Bankcard> gR(List<ud> paramList)
  {
    AppMethodBeat.i(70228);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ae.i("MicroMsg.BankcardParser", "record size: %s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((ud)paramList.next()));
      }
    }
    AppMethodBeat.o(70228);
    return localArrayList;
  }
  
  public Bankcard ba(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(70227);
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = "";
      ae.i("MicroMsg.BankcardParser", "parseJson jsonBankcard %s", new Object[] { localObject1 });
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
      ae.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[] { ((Bankcard)localObject1).field_bindSerial });
      ((Bankcard)localObject1).Dmh = paramJSONObject.optString("h_bind_serialno");
      if (2 != paramJSONObject.optInt("bankacc_type", 0)) {
        break label1183;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.DlW;
      }
      if ("NORMAL".equals(paramJSONObject.optString("extra_bind_flag"))) {
        break label1188;
      }
      i = 1;
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.DlX;
      }
      if ("QMF".equals(((Bankcard)localObject1).field_bankcardType))
      {
        ((Bankcard)localObject1).field_cardType |= Bankcard.Dmc;
        localObject2 = paramJSONObject.optJSONObject("qmfCardInfo");
        if (localObject2 != null)
        {
          ((Bankcard)localObject1).Dmv = ((JSONObject)localObject2).optLong("total_credit_line", 0L);
          ((Bankcard)localObject1).Dmw = ((JSONObject)localObject2).optLong("use_credit_line", 0L);
          ((Bankcard)localObject1).Dmx = ((JSONObject)localObject2).optLong("unuse_credit_line", 0L);
          ((Bankcard)localObject1).Dmy = ((JSONObject)localObject2).optString("payer_username", "");
          ((Bankcard)localObject1).Dmz = ((JSONObject)localObject2).optInt("hide_credit_line", 0);
          ((Bankcard)localObject1).DmA = ((JSONObject)localObject2).optInt("card_type", 0);
          ((Bankcard)localObject1).DmB = ((JSONObject)localObject2).optString("card_type_name", "");
          ((Bankcard)localObject1).DmC = ((JSONObject)localObject2).optString("icon_url", "");
        }
      }
      ((Bankcard)localObject1).field_mobile = URLDecoder.decode(paramJSONObject.optString("mobile").replaceAll("x", "%"), "utf-8");
      if (bu.isNullOrNil(((Bankcard)localObject1).field_mobile)) {
        ((Bankcard)localObject1).field_mobile = paramJSONObject.optString("mobile_mask");
      }
      ((Bankcard)localObject1).field_onceQuotaKind = (paramJSONObject.optDouble("once_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_onceQuotaVirtual = (paramJSONObject.optDouble("once_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaKind = (paramJSONObject.optDouble("day_quota_3") / 100.0D);
      ((Bankcard)localObject1).field_dayQuotaVirtual = (paramJSONObject.optDouble("day_quota_1") / 100.0D);
      ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("bind_tail");
      if (bu.isNullOrNil(((Bankcard)localObject1).field_bankcardTail)) {
        ((Bankcard)localObject1).field_bankcardTail = paramJSONObject.optString("card_tail");
      }
      ((Bankcard)localObject1).Dmf = paramJSONObject.optString("card_mask");
      ((Bankcard)localObject1).field_forbidWord = paramJSONObject.optString("forbid_word");
      ((Bankcard)localObject1).field_repay_url = paramJSONObject.optString("repay_url");
      ((Bankcard)localObject1).field_wxcreditState = 2;
      if (bu.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) {
        break label1193;
      }
      ((Bankcard)localObject1).field_bankcardState = 8;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ae.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + paramJSONObject.getMessage());
        ae.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
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
        ae.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + paramJSONObject.getMessage());
        ae.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70227);
        return null;
        ((Bankcard)localObject1).field_bankcardState = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      label555:
      ae.i("MicroMsg.BankcardParser", "parseJson() Exception:" + paramJSONObject.getMessage());
      ae.printErrStackTrace("MicroMsg.BankcardParser", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(70227);
      return null;
    }
    if (bu.lX("FQF", ((Bankcard)localObject1).field_bankcardType))
    {
      ((Bankcard)localObject1).field_cardType |= Bankcard.Dmd;
      localObject2 = paramJSONObject.optJSONObject("fqf_info");
      if (localObject2 != null)
      {
        ((Bankcard)localObject1).DmG = ((JSONObject)localObject2).optString("fqf_pay_desk_title", "");
        ((Bankcard)localObject1).DmH = ((JSONObject)localObject2).optString("fqf_title", "");
        ((Bankcard)localObject1).DmI = ((JSONObject)localObject2).optString("fqf_sub_title", "");
      }
    }
    ((Bankcard)localObject1).CRv = paramJSONObject.optString("tinyapp_username", "");
    ((Bankcard)localObject1).CRw = paramJSONObject.optString("tinyapp_path", "");
    ((Bankcard)localObject1).field_bankPhone = paramJSONObject.optString("bank_phone");
    ((Bankcard)localObject1).field_fetchArriveTime = (paramJSONObject.optLong("fetch_pre_arrive_time") * 1000L);
    ((Bankcard)localObject1).field_fetchArriveTimeWording = paramJSONObject.optString("fetch_pre_arrive_time_wording");
    ((Bankcard)localObject1).field_bankcardTag = paramJSONObject.optInt("bank_card_tag", 1);
    if (((Bankcard)localObject1).field_bankcardTag == 2)
    {
      i = j;
      label739:
      if (i != 0) {
        ((Bankcard)localObject1).field_cardType |= Bankcard.DlV;
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
      ae.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + paramJSONObject.optString("support_micropay"));
      i = paramJSONObject.optInt("fetch_charge_rate", 0);
      ae.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
      ((Bankcard)localObject1).field_fetch_charge_rate = (i / 10000.0D);
      ae.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + ((Bankcard)localObject1).field_fetch_charge_rate);
      i = paramJSONObject.optInt("full_fetch_charge_fee", 0);
      ae.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + ((Bankcard)localObject1).field_full_fetch_charge_fee);
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
      ((Bankcard)localObject1).DmD = paramJSONObject.optInt("support_foreign_mobile", 0);
      ((Bankcard)localObject1).field_card_state_name = paramJSONObject.optString("card_state_name");
      ((Bankcard)localObject1).DmE = paramJSONObject.optString("card_fetch_wording");
      ((Bankcard)localObject1).DmF = paramJSONObject.optLong("card_min_charge_fee");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.d
 * JD-Core Version:    0.7.0.1
 */