package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ag
{
  public static ArrayList<Bankcard> Cc(boolean paramBoolean)
  {
    AppMethodBeat.i(70433);
    Log.i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (ArrayList localArrayList1 = u.gJo().gKo();; localArrayList1 = u.gJo().Ce(true))
    {
      localObject = u.gJo().gKl();
      if (localObject != null) {
        break;
      }
      Log.w("MicroMsg.WalletPayOrderMgr", "empty bankinfo list");
      AppMethodBeat.o(70433);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label166;
      }
      c localc = (c)((Iterator)localObject).next();
      Iterator localIterator = localArrayList1.iterator();
      if (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.field_bindSerial.equals(localc.GGC)) {
          break;
        }
        localArrayList1.remove(localBankcard);
        localArrayList2.add(localBankcard);
      }
    }
    label166:
    if (!localArrayList1.isEmpty())
    {
      Log.w("MicroMsg.WalletPayOrderMgr", "has unsort bankcard");
      localArrayList2.addAll(localArrayList1);
    }
    AppMethodBeat.o(70433);
    return localArrayList2;
  }
  
  public static Bankcard Cd(boolean paramBoolean)
  {
    AppMethodBeat.i(270446);
    u.gJo();
    Object localObject = ao.gKw();
    Log.i("MicroMsg.WalletPayOrderMgr", " defaultLocalOfflineBankcard：%s，needJudgeDefaultCardState：%s", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = u.gJo().gKn();
    if (localArrayList == null) {
      localArrayList = u.gJo().Ce(true);
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
          bool = g(localBankcard);
          if (localBankcard.field_support_micropay) {
            if (paramBoolean)
            {
              if (bool)
              {
                Log.i("MicroMsg.WalletPayOrderMgr", " final get LastBankcard（needJudgeDefaultCardState）");
                AppMethodBeat.o(270446);
                return localBankcard;
              }
            }
            else
            {
              Log.i("MicroMsg.WalletPayOrderMgr", " final get LastBankcard");
              AppMethodBeat.o(270446);
              return localBankcard;
            }
          }
        }
        i += 1;
      }
      Log.i("MicroMsg.WalletPayOrderMgr", "clear default bindserial");
      u.gJo();
      ao.bgZ("");
      Log.i("MicroMsg.WalletPayOrderMgr", "way2：mainBankcard");
      u.gJo();
      localObject = ao.gKC();
      if ((localObject != null) && (Util.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
      {
        Log.i("MicroMsg.WalletPayOrderMgr", "mainBankcard bindSerial：%s, type：%s，defaultCardState：%s", new Object[] { ((Bankcard)localObject).field_bindSerial, ((Bankcard)localObject).field_bankcardType, Integer.valueOf(((Bankcard)localObject).field_defaultCardState) });
        bool = g((Bankcard)localObject);
        if (paramBoolean)
        {
          if (bool)
          {
            Log.i("MicroMsg.WalletPayOrderMgr", " final get mainBankcard（needJudgeDefaultCardState）");
            AppMethodBeat.o(270446);
            return localObject;
          }
        }
        else
        {
          Log.i("MicroMsg.WalletPayOrderMgr", "final get mainBankcard");
          AppMethodBeat.o(270446);
          return localObject;
        }
      }
      Log.i("MicroMsg.WalletPayOrderMgr", "way3：get balance");
      localObject = u.gJo().OnP;
      if ((localObject != null) && (((Bankcard)localObject).field_support_micropay))
      {
        Log.i("MicroMsg.WalletPayOrderMgr", "get balance：%s，type：%s，defaultCardState：%s", new Object[] { ((Bankcard)localObject).field_bindSerial, ((Bankcard)localObject).field_bankcardType, Integer.valueOf(((Bankcard)localObject).field_defaultCardState) });
        bool = g((Bankcard)localObject);
        if (paramBoolean)
        {
          if (bool)
          {
            Log.i("MicroMsg.WalletPayOrderMgr", " final get balance（needJudgeDefaultCardState）");
            AppMethodBeat.o(270446);
            return localObject;
          }
        }
        else
        {
          Log.i("MicroMsg.WalletPayOrderMgr", " final get balance");
          AppMethodBeat.o(270446);
          return localObject;
        }
      }
      Log.i("MicroMsg.WalletPayOrderMgr", "way4：get first card");
      i = 0;
      while ((localArrayList != null) && (i < localArrayList.size()))
      {
        localObject = (Bankcard)localArrayList.get(i);
        if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (!((Bankcard)localObject).gIH()))
        {
          Log.i("MicroMsg.WalletPayOrderMgr", "get first card:%s，type：%s，defaultCardState：%s", new Object[] { ((Bankcard)localObject).field_bindSerial, ((Bankcard)localObject).field_bankcardType, Integer.valueOf(((Bankcard)localObject).field_defaultCardState) });
          bool = g((Bankcard)localObject);
          if (paramBoolean)
          {
            if (bool)
            {
              Log.i("MicroMsg.WalletPayOrderMgr", " final get first card（needJudgeDefaultCardState）");
              AppMethodBeat.o(270446);
              return localObject;
            }
          }
          else
          {
            Log.i("MicroMsg.WalletPayOrderMgr", " final get first card");
            AppMethodBeat.o(270446);
            return localObject;
          }
        }
        i += 1;
      }
      Log.i("MicroMsg.WalletPayOrderMgr", "way5：get lqt ");
      localObject = u.gJo().OUc;
      if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (Util.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
      {
        Log.i("MicroMsg.WalletPayOrderMgr", " get lqt : %s，type：%s，defaultCardState：%s", new Object[] { Integer.valueOf(((Bankcard)localObject).field_defaultCardState), ((Bankcard)localObject).field_bankcardType, Integer.valueOf(((Bankcard)localObject).field_defaultCardState) });
        bool = g((Bankcard)localObject);
        if (paramBoolean)
        {
          if (bool)
          {
            Log.i("MicroMsg.WalletPayOrderMgr", " final get lqt（needJudgeDefaultCardState）");
            AppMethodBeat.o(270446);
            return localObject;
          }
        }
        else
        {
          Log.i("MicroMsg.WalletPayOrderMgr", " final get lqt");
          AppMethodBeat.o(270446);
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
            AppMethodBeat.o(270446);
            return localObject;
          }
          i += 1;
        }
      }
      Log.i("MicroMsg.WalletPayOrderMgr", " do not get any card");
      AppMethodBeat.o(270446);
      return null;
    }
  }
  
  public static boolean g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(270447);
    if (paramBankcard == null)
    {
      Log.i("MicroMsg.WalletPayOrderMgr", "canSetAsOfflinePayDefaultCard bankcard is null");
      AppMethodBeat.o(270447);
      return false;
    }
    int i = paramBankcard.field_defaultCardState;
    if (paramBankcard.gIM())
    {
      Log.i("MicroMsg.WalletPayOrderMgr", "canSetAsOfflinePayDefaultCard bankcard is fqf");
      if (i == 2)
      {
        AppMethodBeat.o(270447);
        return true;
      }
      AppMethodBeat.o(270447);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(270447);
      return false;
    }
    AppMethodBeat.o(270447);
    return true;
  }
  
  public static List<Bankcard> gJz()
  {
    AppMethodBeat.i(293280);
    ArrayList localArrayList = Cc(false);
    AppMethodBeat.o(293280);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag
 * JD-Core Version:    0.7.0.1
 */