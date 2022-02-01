package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class af
{
  public static List<Bankcard> fQT()
  {
    AppMethodBeat.i(258349);
    ArrayList localArrayList = yh(false);
    AppMethodBeat.o(258349);
    return localArrayList;
  }
  
  public static ArrayList<Bankcard> yh(boolean paramBoolean)
  {
    AppMethodBeat.i(70433);
    Log.i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (ArrayList localArrayList1 = t.fQI().fRI();; localArrayList1 = t.fQI().yj(true))
    {
      localObject = t.fQI().fRF();
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
        if (!localBankcard.field_bindSerial.equals(localc.ANo)) {
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
  
  public static Bankcard yi(boolean paramBoolean)
  {
    AppMethodBeat.i(214197);
    Log.i("MicroMsg.WalletPayOrderMgr", "defaultLocalOfflineBankcard");
    g.aAi();
    if (((Integer)g.aAh().azQ().get(ar.a.NTC, Integer.valueOf(1))).intValue() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      t.fQI();
      Object localObject2 = an.fRR();
      Log.i("MicroMsg.WalletPayOrderMgr", " getSelectedDefault BindBankCard %s，isFqfCardSettingEnable： %s ，needJudeSwitchFQF ：%s", new Object[] { localObject2, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      Object localObject1 = t.fQI().fRH();
      if (localObject1 == null) {
        localObject1 = t.fQI().yj(true);
      }
      for (;;)
      {
        Log.i("MicroMsg.WalletPayOrderMgr", "way1：getLastBankcard");
        int i = 0;
        while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (localObject1 != null) && (i < ((List)localObject1).size()))
        {
          Bankcard localBankcard = (Bankcard)((List)localObject1).get(i);
          if (localBankcard != null) {
            Log.i("MicroMsg.WalletPayOrderMgr", "compared bankcard.field_bindSerial:%s", new Object[] { localBankcard.field_bindSerial });
          }
          if ((localBankcard != null) && (((String)localObject2).equals(localBankcard.field_bindSerial)))
          {
            Log.i("MicroMsg.WalletPayOrderMgr", "micropay: %s, forbidword: %s", new Object[] { Boolean.valueOf(localBankcard.field_support_micropay), localBankcard.field_forbidWord });
            if (localBankcard.field_support_micropay) {
              if ((paramBoolean) && (localBankcard.fQg()))
              {
                if (bool)
                {
                  Log.i("MicroMsg.WalletPayOrderMgr", " final getLastBankcard FQF");
                  AppMethodBeat.o(214197);
                  return localBankcard;
                }
              }
              else
              {
                Log.i("MicroMsg.WalletPayOrderMgr", " final getLastBankcard：%s ", new Object[] { localBankcard.field_bindSerial });
                AppMethodBeat.o(214197);
                return localBankcard;
              }
            }
          }
          i += 1;
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "clear default bindserial");
        t.fQI();
        an.aVq("");
        Log.i("MicroMsg.WalletPayOrderMgr", "way2：mainBankcard");
        t.fQI();
        localObject2 = an.fRX();
        if ((localObject2 != null) && (Util.isNullOrNil(((Bankcard)localObject2).field_forbidWord)))
        {
          Log.i("MicroMsg.WalletPayOrderMgr", "do change main card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
          if ((paramBoolean) && (((Bankcard)localObject2).fQg()))
          {
            if (bool)
            {
              Log.i("MicroMsg.WalletPayOrderMgr", " final mainBankcard FQF ");
              AppMethodBeat.o(214197);
              return localObject2;
            }
          }
          else
          {
            Log.i("MicroMsg.WalletPayOrderMgr", "final mainBankcard：%s ", new Object[] { ((Bankcard)localObject2).field_bindSerial });
            AppMethodBeat.o(214197);
            return localObject2;
          }
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "way3：do change first card");
        i = 0;
        while ((localObject1 != null) && (i < ((List)localObject1).size()))
        {
          localObject2 = (Bankcard)((List)localObject1).get(i);
          if ((localObject2 != null) && (((Bankcard)localObject2).field_support_micropay) && (!((Bankcard)localObject2).fQb()))
          {
            Log.i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
            if ((paramBoolean) && (((Bankcard)localObject2).fQg()))
            {
              if (bool)
              {
                Log.i("MicroMsg.WalletPayOrderMgr", " final do change first card FQF");
                AppMethodBeat.o(214197);
                return localObject2;
              }
            }
            else
            {
              Log.i("MicroMsg.WalletPayOrderMgr", " final do change first card:%s", new Object[] { ((Bankcard)localObject2).field_bindSerial });
              AppMethodBeat.o(214197);
              return localObject2;
            }
          }
          i += 1;
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "way4：do change balance");
        localObject1 = t.fQI().Hwc;
        if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay))
        {
          Log.i("MicroMsg.WalletPayOrderMgr", "final do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
          AppMethodBeat.o(214197);
          return localObject1;
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "way5：do change lqtbalance ");
        localObject1 = t.fQI().IbQ;
        if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay) && (Util.isNullOrNil(((Bankcard)localObject1).field_forbidWord)))
        {
          Log.i("MicroMsg.WalletPayOrderMgr", " final do change lqtbalance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
          AppMethodBeat.o(214197);
          return localObject1;
        }
        AppMethodBeat.o(214197);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.af
 * JD-Core Version:    0.7.0.1
 */