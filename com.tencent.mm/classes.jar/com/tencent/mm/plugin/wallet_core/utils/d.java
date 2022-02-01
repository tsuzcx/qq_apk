package com.tencent.mm.plugin.wallet_core.utils;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BankcardScene;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean E(List<Bankcard> paramList, int paramInt)
  {
    AppMethodBeat.i(71636);
    if (paramList == null)
    {
      AppMethodBeat.o(71636);
      return false;
    }
    ArrayList localArrayList;
    BankcardScene localBankcardScene;
    if (paramInt == 8)
    {
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localBankcardScene = k((Bankcard)paramList.next());
        localBankcardScene.field_scene = 8;
        localArrayList.add(localBankcardScene);
      }
      t.fQG().ib(localArrayList);
    }
    for (;;)
    {
      AppMethodBeat.o(71636);
      return true;
      if (paramInt == 12)
      {
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localBankcardScene = k((Bankcard)paramList.next());
          localBankcardScene.field_scene = 12;
          localArrayList.add(localBankcardScene);
        }
        t.fQG().ib(localArrayList);
      }
      else
      {
        t.fQF().ib(paramList);
      }
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
    boolean bool;
    if (paramInt == 8)
    {
      paramBankcard = k(paramBankcard);
      paramBankcard.field_scene = 8;
      bool = t.fQG().a(paramBankcard);
    }
    for (;;)
    {
      AppMethodBeat.o(71637);
      return bool;
      if (paramInt == 12)
      {
        paramBankcard = k(paramBankcard);
        paramBankcard.field_scene = 12;
        bool = t.fQG().a(paramBankcard);
      }
      else
      {
        bool = t.fQF().g(paramBankcard);
      }
    }
  }
  
  public static boolean aeX(int paramInt)
  {
    AppMethodBeat.i(71638);
    if (paramInt == 8) {}
    for (boolean bool = t.fQG().aeN(paramInt);; bool = t.fQG().bnU())
    {
      AppMethodBeat.o(71638);
      return bool;
    }
  }
  
  public static ArrayList<Bankcard> aeY(int paramInt)
  {
    AppMethodBeat.i(214262);
    Object localObject1 = t.fQG();
    Object localObject2 = "select * from WalletBankcardScene where (cardType <= 7 OR cardType & " + BankcardScene.HVw + " != 0 OR cardType & " + BankcardScene.HVv + " != 0) and scene=" + paramInt;
    localObject2 = ((c)localObject1).db.rawQuery((String)localObject2, null, 2);
    if (localObject2 == null) {
      localObject1 = null;
    }
    BankcardScene localBankcardScene;
    while (localObject1 == null)
    {
      AppMethodBeat.o(214262);
      return null;
      localObject1 = null;
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new ArrayList();
        do
        {
          localBankcardScene = new BankcardScene();
          localBankcardScene.convertFrom((Cursor)localObject2);
          ((ArrayList)localObject1).add(localBankcardScene);
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
    }
    localObject2 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localBankcardScene = (BankcardScene)((Iterator)localObject1).next();
      Bankcard localBankcard = new Bankcard(localBankcardScene.HVx, localBankcardScene.HVy, localBankcardScene.HUS, localBankcardScene.HVz, localBankcardScene.HVA, localBankcardScene.HVB, localBankcardScene.HVC, localBankcardScene.HVD, localBankcardScene.HVE, localBankcardScene.HVF, localBankcardScene.HVG, localBankcardScene.HVH, localBankcardScene.HVI, localBankcardScene.HVJ, localBankcardScene.HVK, localBankcardScene.HUQ, localBankcardScene.HVL, localBankcardScene.dKO, localBankcardScene.HVM, localBankcardScene.HVN, localBankcardScene.HVO, localBankcardScene.HVP, localBankcardScene.HVQ, localBankcardScene.HVR, localBankcardScene.HVS, localBankcardScene.HVT, localBankcardScene.HVU, localBankcardScene.HVV, localBankcardScene.HVW, localBankcardScene.HVX, localBankcardScene.HVY, localBankcardScene.HVZ, localBankcardScene.HWa, localBankcardScene.Hwr, localBankcardScene.Hws);
      localBankcard.field_bindSerial = localBankcardScene.field_bindSerial;
      localBankcard.field_cardType = localBankcardScene.field_cardType;
      localBankcard.field_bankcardState = localBankcardScene.field_bankcardState;
      localBankcard.field_forbidWord = localBankcardScene.field_forbidWord;
      localBankcard.field_bankName = localBankcardScene.field_bankName;
      localBankcard.field_bankcardType = localBankcardScene.field_bankcardType;
      localBankcard.field_bankcardTypeName = localBankcardScene.field_bankcardTypeName;
      localBankcard.field_bankcardTag = localBankcardScene.field_bankcardTag;
      localBankcard.field_bankcardTail = localBankcardScene.field_bankcardTail;
      localBankcard.field_supportTag = localBankcardScene.field_supportTag;
      localBankcard.field_mobile = localBankcardScene.field_mobile;
      localBankcard.field_trueName = localBankcardScene.field_trueName;
      localBankcard.field_desc = localBankcardScene.field_desc;
      localBankcard.field_bankPhone = localBankcardScene.field_bankPhone;
      localBankcard.field_bizUsername = localBankcardScene.field_bizUsername;
      localBankcard.field_onceQuotaKind = localBankcardScene.field_onceQuotaKind;
      localBankcard.field_onceQuotaVirtual = localBankcardScene.field_onceQuotaVirtual;
      localBankcard.field_dayQuotaKind = localBankcardScene.field_dayQuotaKind;
      localBankcard.field_dayQuotaVirtual = localBankcardScene.field_dayQuotaVirtual;
      localBankcard.field_fetchArriveTime = localBankcardScene.field_fetchArriveTime;
      localBankcard.field_fetchArriveTimeWording = localBankcardScene.field_fetchArriveTimeWording;
      localBankcard.field_repay_url = localBankcardScene.field_repay_url;
      localBankcard.field_wxcreditState = localBankcardScene.field_wxcreditState;
      localBankcard.field_bankcardClientType = localBankcardScene.field_bankcardClientType;
      localBankcard.field_ext_msg = localBankcardScene.field_ext_msg;
      localBankcard.field_support_micropay = localBankcardScene.field_support_micropay;
      localBankcard.field_arrive_type = localBankcardScene.field_arrive_type;
      localBankcard.field_avail_save_wording = localBankcardScene.field_avail_save_wording;
      localBankcard.field_fetch_charge_rate = localBankcardScene.field_fetch_charge_rate;
      localBankcard.field_full_fetch_charge_fee = localBankcardScene.field_full_fetch_charge_fee;
      localBankcard.field_fetch_charge_info = localBankcardScene.field_fetch_charge_info;
      localBankcard.field_tips = localBankcardScene.field_tips;
      localBankcard.field_forbid_title = localBankcardScene.field_forbid_title;
      localBankcard.field_forbid_url = localBankcardScene.field_forbid_url;
      localBankcard.field_no_micro_word = localBankcardScene.field_no_micro_word;
      localBankcard.field_card_bottom_wording = localBankcardScene.field_card_bottom_wording;
      localBankcard.field_support_lqt_turn_in = localBankcardScene.field_support_lqt_turn_in;
      localBankcard.field_support_lqt_turn_out = localBankcardScene.field_support_lqt_turn_out;
      localBankcard.field_is_hightlight_pre_arrive_time_wording = localBankcardScene.field_is_hightlight_pre_arrive_time_wording;
      localBankcard.field_card_state_name = localBankcardScene.field_card_state_name;
      localBankcard.field_prompt_info_prompt_text = localBankcardScene.field_prompt_info_prompt_text;
      localBankcard.field_prompt_info_jump_text = localBankcardScene.field_prompt_info_jump_text;
      localBankcard.field_prompt_info_jump_url = localBankcardScene.field_prompt_info_jump_url;
      ((ArrayList)localObject2).add(localBankcard);
    }
    AppMethodBeat.o(214262);
    return localObject2;
  }
  
  private static BankcardScene k(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71640);
    BankcardScene localBankcardScene = new BankcardScene(paramBankcard.HVx, paramBankcard.HVy, paramBankcard.HUS, paramBankcard.HVz, paramBankcard.HVA, paramBankcard.HVB, paramBankcard.HVC, paramBankcard.HVD, paramBankcard.HVE, paramBankcard.HVF, paramBankcard.HVG, paramBankcard.HVH, paramBankcard.HVI, paramBankcard.HVJ, paramBankcard.HVK, paramBankcard.HUQ, paramBankcard.HVL, paramBankcard.dKO, paramBankcard.HVM, paramBankcard.HVN, paramBankcard.HVO, paramBankcard.HVP, paramBankcard.HVQ, paramBankcard.HVR, paramBankcard.HVS, paramBankcard.HVT, paramBankcard.HVU, paramBankcard.HVV, paramBankcard.HVW, paramBankcard.HVX, paramBankcard.HVY, paramBankcard.HVZ, paramBankcard.HWa, paramBankcard.Hwr, paramBankcard.Hws);
    localBankcardScene.field_bindSerial = paramBankcard.field_bindSerial;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.d
 * JD-Core Version:    0.7.0.1
 */