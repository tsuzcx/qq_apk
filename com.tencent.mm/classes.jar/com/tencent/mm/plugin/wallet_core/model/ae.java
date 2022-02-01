package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ae
{
  public static ArrayList<Bankcard> HH(boolean paramBoolean)
  {
    AppMethodBeat.i(70433);
    Log.i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (ArrayList localArrayList1 = u.iiC().ijF();; localArrayList1 = u.iiC().HJ(true))
    {
      localObject = u.iiC().ijC();
      if (localArrayList1 != null) {
        break;
      }
      Log.w("MicroMsg.WalletPayOrderMgr", "empty bankcard list");
      AppMethodBeat.o(70433);
      return null;
    }
    if (localObject == null)
    {
      Log.w("MicroMsg.WalletPayOrderMgr", "empty bankinfo list");
      AppMethodBeat.o(70433);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label184;
      }
      c localc = (c)((Iterator)localObject).next();
      Iterator localIterator = localArrayList1.iterator();
      if (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.field_bindSerial.equals(localc.MDt)) {
          break;
        }
        localArrayList1.remove(localBankcard);
        localArrayList2.add(localBankcard);
      }
    }
    label184:
    if (!localArrayList1.isEmpty())
    {
      Log.w("MicroMsg.WalletPayOrderMgr", "has unsort bankcard");
      localArrayList2.addAll(localArrayList1);
    }
    AppMethodBeat.o(70433);
    return localArrayList2;
  }
  
  public static Bankcard HI(boolean paramBoolean)
  {
    AppMethodBeat.i(301164);
    u.iiC();
    Object localObject = am.ijO();
    Log.i("MicroMsg.WalletPayOrderMgr", " defaultLocalOfflineBankcard：%s，needJudgeDefaultCardState：%s", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = u.iiC().ijE();
    if (localArrayList == null) {
      localArrayList = u.iiC().HJ(true);
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletPayOrderMgr", "way1：getLastBankcard");
      int i = 0;
      boolean bool;
      while ((!TextUtils.isEmpty((CharSequence)localObject)) && (localArrayList != null) && (i < localArrayList.size()))
      {
        Bankcard localBankcard = (Bankcard)localArrayList.get(i);
        if (localBankcard != null) {
          Log.i("MicroMsg.WalletPayOrderMgr", "compared bankcard: %s status：%s", new Object[] { localBankcard.field_bindSerial, Integer.valueOf(localBankcard.field_defaultCardState) });
        }
        if ((localBankcard != null) && (((String)localObject).equals(localBankcard.field_bindSerial)))
        {
          Log.i("MicroMsg.WalletPayOrderMgr", "find bindSerial:%s，micropay: %s, forbidword: %s，defaultCardState：%s", new Object[] { localBankcard.field_bindSerial, Boolean.valueOf(localBankcard.field_support_micropay), localBankcard.field_forbidWord, Integer.valueOf(localBankcard.field_defaultCardState) });
          bool = h(localBankcard);
          if (localBankcard.field_support_micropay) {
            if (paramBoolean)
            {
              if (bool)
              {
                Log.i("MicroMsg.WalletPayOrderMgr", " final get LastBankcard（needJudgeDefaultCardState）");
                AppMethodBeat.o(301164);
                return localBankcard;
              }
            }
            else
            {
              Log.i("MicroMsg.WalletPayOrderMgr", " final get LastBankcard");
              AppMethodBeat.o(301164);
              return localBankcard;
            }
          }
        }
        i += 1;
      }
      Log.i("MicroMsg.WalletPayOrderMgr", "clear default bindserial");
      u.iiC();
      am.bgI("");
      Log.i("MicroMsg.WalletPayOrderMgr", "way2：mainBankcard");
      u.iiC();
      localObject = am.ijU();
      if ((localObject != null) && (Util.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
      {
        Log.i("MicroMsg.WalletPayOrderMgr", "mainBankcard bindSerial：%s, type：%s，defaultCardState：%s", new Object[] { ((Bankcard)localObject).field_bindSerial, ((Bankcard)localObject).field_bankcardType, Integer.valueOf(((Bankcard)localObject).field_defaultCardState) });
        bool = h((Bankcard)localObject);
        if (paramBoolean)
        {
          if (bool)
          {
            Log.i("MicroMsg.WalletPayOrderMgr", " final get mainBankcard（needJudgeDefaultCardState）");
            AppMethodBeat.o(301164);
            return localObject;
          }
        }
        else
        {
          Log.i("MicroMsg.WalletPayOrderMgr", "final get mainBankcard");
          AppMethodBeat.o(301164);
          return localObject;
        }
      }
      Log.i("MicroMsg.WalletPayOrderMgr", "way3：get balance");
      localObject = u.iiC().VcF;
      if ((localObject != null) && (((Bankcard)localObject).field_support_micropay))
      {
        Log.i("MicroMsg.WalletPayOrderMgr", "get balance：%s，type：%s，defaultCardState：%s", new Object[] { ((Bankcard)localObject).field_bindSerial, ((Bankcard)localObject).field_bankcardType, Integer.valueOf(((Bankcard)localObject).field_defaultCardState) });
        bool = h((Bankcard)localObject);
        if (paramBoolean)
        {
          if (bool)
          {
            Log.i("MicroMsg.WalletPayOrderMgr", " final get balance（needJudgeDefaultCardState）");
            AppMethodBeat.o(301164);
            return localObject;
          }
        }
        else
        {
          Log.i("MicroMsg.WalletPayOrderMgr", " final get balance");
          AppMethodBeat.o(301164);
          return localObject;
        }
      }
      Log.i("MicroMsg.WalletPayOrderMgr", "way4：get first card");
      i = 0;
      while ((localArrayList != null) && (i < localArrayList.size()))
      {
        localObject = (Bankcard)localArrayList.get(i);
        if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (!((Bankcard)localObject).ihV()))
        {
          Log.i("MicroMsg.WalletPayOrderMgr", "get first card:%s，type：%s，defaultCardState：%s", new Object[] { ((Bankcard)localObject).field_bindSerial, ((Bankcard)localObject).field_bankcardType, Integer.valueOf(((Bankcard)localObject).field_defaultCardState) });
          bool = h((Bankcard)localObject);
          if (paramBoolean)
          {
            if (bool)
            {
              Log.i("MicroMsg.WalletPayOrderMgr", " final get first card（needJudgeDefaultCardState）");
              AppMethodBeat.o(301164);
              return localObject;
            }
          }
          else
          {
            Log.i("MicroMsg.WalletPayOrderMgr", " final get first card");
            AppMethodBeat.o(301164);
            return localObject;
          }
        }
        i += 1;
      }
      Log.i("MicroMsg.WalletPayOrderMgr", "way5：get lqt ");
      localObject = u.iiC().VKi;
      if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (Util.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
      {
        Log.i("MicroMsg.WalletPayOrderMgr", " get lqt : %s，type：%s，defaultCardState：%s", new Object[] { Integer.valueOf(((Bankcard)localObject).field_defaultCardState), ((Bankcard)localObject).field_bankcardType, Integer.valueOf(((Bankcard)localObject).field_defaultCardState) });
        bool = h((Bankcard)localObject);
        if (paramBoolean)
        {
          if (bool)
          {
            Log.i("MicroMsg.WalletPayOrderMgr", " final get lqt（needJudgeDefaultCardState）");
            AppMethodBeat.o(301164);
            return localObject;
          }
        }
        else
        {
          Log.i("MicroMsg.WalletPayOrderMgr", " final get lqt");
          AppMethodBeat.o(301164);
          return localObject;
        }
      }
      if (paramBoolean)
      {
        Log.i("MicroMsg.WalletPayOrderMgr", "final way");
        i = 0;
        while ((localArrayList != null) && (i < localArrayList.size()))
        {
          localObject = (Bankcard)localArrayList.get(i);
          if ((localObject != null) && (((Bankcard)localObject).field_support_micropay))
          {
            Log.i("MicroMsg.WalletPayOrderMgr", "final get card：%s，type：%s", new Object[] { ((Bankcard)localObject).field_bindSerial, ((Bankcard)localObject).field_bankcardType });
            AppMethodBeat.o(301164);
            return localObject;
          }
          i += 1;
        }
      }
      Log.i("MicroMsg.WalletPayOrderMgr", " do not get any card");
      AppMethodBeat.o(301164);
      return null;
    }
  }
  
  public static boolean h(Bankcard paramBankcard)
  {
    AppMethodBeat.i(301166);
    if (paramBankcard == null)
    {
      Log.i("MicroMsg.WalletPayOrderMgr", "canSetAsOfflinePayDefaultCard bankcard is null");
      AppMethodBeat.o(301166);
      return false;
    }
    int i = paramBankcard.field_defaultCardState;
    if (paramBankcard.iia())
    {
      Log.i("MicroMsg.WalletPayOrderMgr", "canSetAsOfflinePayDefaultCard bankcard is fqf");
      if (i == 2)
      {
        AppMethodBeat.o(301166);
        return true;
      }
      AppMethodBeat.o(301166);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(301166);
      return false;
    }
    AppMethodBeat.o(301166);
    return true;
  }
  
  public static List<Bankcard> iiN()
  {
    AppMethodBeat.i(369880);
    ArrayList localArrayList = HH(false);
    AppMethodBeat.o(369880);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ae
 * JD-Core Version:    0.7.0.1
 */