package com.tencent.mm.plugin.wallet_core.utils;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BankcardScene;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k
{
  public static boolean X(List<Bankcard> paramList, int paramInt)
  {
    AppMethodBeat.i(71636);
    if (paramList == null)
    {
      AppMethodBeat.o(71636);
      return false;
    }
    ArrayList localArrayList;
    if ((paramInt == 8) || (paramInt == 12) || (paramInt == 26))
    {
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BankcardScene localBankcardScene = m((Bankcard)paramList.next());
        localBankcardScene.field_scene = paramInt;
        localArrayList.add(localBankcardScene);
      }
    }
    for (boolean bool = u.iiA().lZ(localArrayList);; bool = u.iiz().lZ(paramList))
    {
      AppMethodBeat.o(71636);
      return bool;
    }
  }
  
  public static boolean a(Bankcard paramBankcard, int paramInt)
  {
    AppMethodBeat.i(71637);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(71637);
      return false;
    }
    if ((paramInt == 8) || (paramInt == 12) || (paramInt == 26))
    {
      paramBankcard = m(paramBankcard);
      paramBankcard.field_scene = paramInt;
    }
    for (boolean bool = u.iiA().a(paramBankcard);; bool = u.iiz().i(paramBankcard))
    {
      AppMethodBeat.o(71637);
      return bool;
    }
  }
  
  public static boolean asA(int paramInt)
  {
    AppMethodBeat.i(71638);
    if ((paramInt == 8) || (paramInt == 12) || (paramInt == 26)) {}
    for (boolean bool = u.iiA().asp(paramInt);; bool = u.iiz().bwy())
    {
      AppMethodBeat.o(71638);
      return bool;
    }
  }
  
  public static ArrayList<Bankcard> asB(int paramInt)
  {
    AppMethodBeat.i(301426);
    Object localObject1 = u.iiA();
    Object localObject2 = "select * from WalletBankcardScene where (cardType <= 7 OR cardType & " + BankcardScene.VDi + " != 0 OR cardType & " + BankcardScene.VDh + " != 0) and scene=" + paramInt;
    localObject2 = ((c)localObject1).db.rawQuery((String)localObject2, null, 2);
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        AppMethodBeat.o(301426);
        return null;
      }
    }
    else
    {
      if (!((Cursor)localObject2).moveToFirst()) {
        break label181;
      }
      localObject1 = new ArrayList();
      do
      {
        BankcardScene localBankcardScene = new BankcardScene();
        localBankcardScene.convertFrom((Cursor)localObject2);
        ((ArrayList)localObject1).add(localBankcardScene);
      } while (((Cursor)localObject2).moveToNext());
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      break;
      localObject2 = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ArrayList)localObject2).add(b((BankcardScene)((Iterator)localObject1).next()));
      }
      AppMethodBeat.o(301426);
      return localObject2;
      label181:
      localObject1 = null;
    }
  }
  
  public static ArrayList<Bankcard> asC(int paramInt)
  {
    AppMethodBeat.i(301431);
    Object localObject = u.iiA().aso(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(301431);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(b((BankcardScene)((Iterator)localObject).next()));
    }
    AppMethodBeat.o(301431);
    return localArrayList;
  }
  
  private static Bankcard b(BankcardScene paramBankcardScene)
  {
    AppMethodBeat.i(301438);
    Bankcard localBankcard = new Bankcard(paramBankcardScene.VDj, paramBankcardScene.VDk, paramBankcardScene.VCE, paramBankcardScene.VDl, paramBankcardScene.VDm, paramBankcardScene.VDn, paramBankcardScene.VDo, paramBankcardScene.VDp, paramBankcardScene.VDq, paramBankcardScene.VDr, paramBankcardScene.VDs, paramBankcardScene.VDt, paramBankcardScene.VDu, paramBankcardScene.VDv, paramBankcardScene.VDw, paramBankcardScene.VCC, paramBankcardScene.VDx, paramBankcardScene.hIt, paramBankcardScene.VDy, paramBankcardScene.VDz, paramBankcardScene.VDA, paramBankcardScene.VDB, paramBankcardScene.VDC, paramBankcardScene.VDD, paramBankcardScene.VDE, paramBankcardScene.VDF, paramBankcardScene.VDG, paramBankcardScene.VDH, paramBankcardScene.VDI, paramBankcardScene.VDJ, paramBankcardScene.VDK, paramBankcardScene.VDL, paramBankcardScene.VDM, paramBankcardScene.VcU, paramBankcardScene.VcV);
    localBankcard.field_bindSerial = paramBankcardScene.field_bindSerial;
    localBankcard.field_defaultCardState = paramBankcardScene.field_defaultCardState;
    localBankcard.field_cardType = paramBankcardScene.field_cardType;
    localBankcard.field_bankcardState = paramBankcardScene.field_bankcardState;
    localBankcard.field_forbidWord = paramBankcardScene.field_forbidWord;
    localBankcard.field_bankName = paramBankcardScene.field_bankName;
    localBankcard.field_bankcardType = paramBankcardScene.field_bankcardType;
    localBankcard.field_bankcardTypeName = paramBankcardScene.field_bankcardTypeName;
    localBankcard.field_bankcardTag = paramBankcardScene.field_bankcardTag;
    localBankcard.field_bankcardTail = paramBankcardScene.field_bankcardTail;
    localBankcard.field_supportTag = paramBankcardScene.field_supportTag;
    localBankcard.field_mobile = paramBankcardScene.field_mobile;
    localBankcard.field_trueName = paramBankcardScene.field_trueName;
    localBankcard.field_desc = paramBankcardScene.field_desc;
    localBankcard.field_bankPhone = paramBankcardScene.field_bankPhone;
    localBankcard.field_bizUsername = paramBankcardScene.field_bizUsername;
    localBankcard.field_onceQuotaKind = paramBankcardScene.field_onceQuotaKind;
    localBankcard.field_onceQuotaVirtual = paramBankcardScene.field_onceQuotaVirtual;
    localBankcard.field_dayQuotaKind = paramBankcardScene.field_dayQuotaKind;
    localBankcard.field_dayQuotaVirtual = paramBankcardScene.field_dayQuotaVirtual;
    localBankcard.field_fetchArriveTime = paramBankcardScene.field_fetchArriveTime;
    localBankcard.field_fetchArriveTimeWording = paramBankcardScene.field_fetchArriveTimeWording;
    localBankcard.field_repay_url = paramBankcardScene.field_repay_url;
    localBankcard.field_wxcreditState = paramBankcardScene.field_wxcreditState;
    localBankcard.field_bankcardClientType = paramBankcardScene.field_bankcardClientType;
    localBankcard.field_ext_msg = paramBankcardScene.field_ext_msg;
    localBankcard.field_support_micropay = paramBankcardScene.field_support_micropay;
    localBankcard.field_arrive_type = paramBankcardScene.field_arrive_type;
    localBankcard.field_avail_save_wording = paramBankcardScene.field_avail_save_wording;
    localBankcard.field_fetch_charge_rate = paramBankcardScene.field_fetch_charge_rate;
    localBankcard.field_full_fetch_charge_fee = paramBankcardScene.field_full_fetch_charge_fee;
    localBankcard.field_fetch_charge_info = paramBankcardScene.field_fetch_charge_info;
    localBankcard.field_tips = paramBankcardScene.field_tips;
    localBankcard.field_forbid_title = paramBankcardScene.field_forbid_title;
    localBankcard.field_forbid_url = paramBankcardScene.field_forbid_url;
    localBankcard.field_no_micro_word = paramBankcardScene.field_no_micro_word;
    localBankcard.field_card_bottom_wording = paramBankcardScene.field_card_bottom_wording;
    localBankcard.field_support_lqt_turn_in = paramBankcardScene.field_support_lqt_turn_in;
    localBankcard.field_support_lqt_turn_out = paramBankcardScene.field_support_lqt_turn_out;
    localBankcard.field_is_hightlight_pre_arrive_time_wording = paramBankcardScene.field_is_hightlight_pre_arrive_time_wording;
    localBankcard.field_card_state_name = paramBankcardScene.field_card_state_name;
    localBankcard.field_prompt_info_prompt_text = paramBankcardScene.field_prompt_info_prompt_text;
    localBankcard.field_prompt_info_jump_text = paramBankcardScene.field_prompt_info_jump_text;
    localBankcard.field_prompt_info_jump_url = paramBankcardScene.field_prompt_info_jump_url;
    AppMethodBeat.o(301438);
    return localBankcard;
  }
  
  private static BankcardScene m(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71640);
    BankcardScene localBankcardScene = new BankcardScene(paramBankcard.VDj, paramBankcard.VDk, paramBankcard.VCE, paramBankcard.VDl, paramBankcard.VDm, paramBankcard.VDn, paramBankcard.VDo, paramBankcard.VDp, paramBankcard.VDq, paramBankcard.VDr, paramBankcard.VDs, paramBankcard.VDt, paramBankcard.VDu, paramBankcard.VDv, paramBankcard.VDw, paramBankcard.VCC, paramBankcard.VDx, paramBankcard.hIt, paramBankcard.VDy, paramBankcard.VDz, paramBankcard.VDA, paramBankcard.VDB, paramBankcard.VDC, paramBankcard.VDD, paramBankcard.VDE, paramBankcard.VDF, paramBankcard.VDG, paramBankcard.VDH, paramBankcard.VDI, paramBankcard.VDJ, paramBankcard.VDK, paramBankcard.VDL, paramBankcard.VDM, paramBankcard.VcU, paramBankcard.VcV);
    localBankcardScene.field_bindSerial = paramBankcard.field_bindSerial;
    localBankcardScene.field_defaultCardState = paramBankcard.field_defaultCardState;
    localBankcardScene.field_cardType = paramBankcard.field_cardType;
    localBankcardScene.field_bankcardState = paramBankcard.field_bankcardState;
    localBankcardScene.field_forbidWord = paramBankcard.field_forbidWord;
    localBankcardScene.field_bankName = paramBankcard.field_bankName;
    localBankcardScene.field_bankcardType = paramBankcard.field_bankcardType;
    localBankcardScene.field_bankcardTypeName = paramBankcard.field_bankcardTypeName;
    localBankcardScene.field_bankcardTag = paramBankcard.field_bankcardTag;
    localBankcardScene.field_bankcardTail = paramBankcard.field_bankcardTail;
    localBankcardScene.field_supportTag = paramBankcard.field_supportTag;
    localBankcardScene.field_mobile = paramBankcard.field_mobile;
    localBankcardScene.field_trueName = paramBankcard.field_trueName;
    localBankcardScene.field_desc = paramBankcard.field_desc;
    localBankcardScene.field_bankPhone = paramBankcard.field_bankPhone;
    localBankcardScene.field_bizUsername = paramBankcard.field_bizUsername;
    localBankcardScene.field_onceQuotaKind = paramBankcard.field_onceQuotaKind;
    localBankcardScene.field_onceQuotaVirtual = paramBankcard.field_onceQuotaVirtual;
    localBankcardScene.field_dayQuotaKind = paramBankcard.field_dayQuotaKind;
    localBankcardScene.field_dayQuotaVirtual = paramBankcard.field_dayQuotaVirtual;
    localBankcardScene.field_fetchArriveTime = paramBankcard.field_fetchArriveTime;
    localBankcardScene.field_fetchArriveTimeWording = paramBankcard.field_fetchArriveTimeWording;
    localBankcardScene.field_repay_url = paramBankcard.field_repay_url;
    localBankcardScene.field_wxcreditState = paramBankcard.field_wxcreditState;
    localBankcardScene.field_bankcardClientType = paramBankcard.field_bankcardClientType;
    localBankcardScene.field_ext_msg = paramBankcard.field_ext_msg;
    localBankcardScene.field_support_micropay = paramBankcard.field_support_micropay;
    localBankcardScene.field_arrive_type = paramBankcard.field_arrive_type;
    localBankcardScene.field_avail_save_wording = paramBankcard.field_avail_save_wording;
    localBankcardScene.field_fetch_charge_rate = paramBankcard.field_fetch_charge_rate;
    localBankcardScene.field_full_fetch_charge_fee = paramBankcard.field_full_fetch_charge_fee;
    localBankcardScene.field_fetch_charge_info = paramBankcard.field_fetch_charge_info;
    localBankcardScene.field_tips = paramBankcard.field_tips;
    localBankcardScene.field_forbid_title = paramBankcard.field_forbid_title;
    localBankcardScene.field_forbid_url = paramBankcard.field_forbid_url;
    localBankcardScene.field_no_micro_word = paramBankcard.field_no_micro_word;
    localBankcardScene.field_card_bottom_wording = paramBankcard.field_card_bottom_wording;
    localBankcardScene.field_support_lqt_turn_in = paramBankcard.field_support_lqt_turn_in;
    localBankcardScene.field_support_lqt_turn_out = paramBankcard.field_support_lqt_turn_out;
    localBankcardScene.field_is_hightlight_pre_arrive_time_wording = paramBankcard.field_is_hightlight_pre_arrive_time_wording;
    localBankcardScene.field_card_state_name = paramBankcard.field_card_state_name;
    localBankcardScene.field_prompt_info_prompt_text = paramBankcard.field_prompt_info_prompt_text;
    localBankcardScene.field_prompt_info_jump_text = paramBankcard.field_prompt_info_jump_text;
    localBankcardScene.field_prompt_info_jump_url = paramBankcard.field_prompt_info_jump_url;
    AppMethodBeat.o(71640);
    return localBankcardScene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.k
 * JD-Core Version:    0.7.0.1
 */