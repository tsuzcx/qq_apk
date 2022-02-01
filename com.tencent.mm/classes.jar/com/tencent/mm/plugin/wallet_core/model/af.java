package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class af
{
  public static List<Bankcard> eFJ()
  {
    AppMethodBeat.i(221334);
    ArrayList localArrayList = um(false);
    AppMethodBeat.o(221334);
    return localArrayList;
  }
  
  public static ArrayList<Bankcard> um(boolean paramBoolean)
  {
    AppMethodBeat.i(70433);
    ad.i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (ArrayList localArrayList1 = t.eFy().eGx();; localArrayList1 = t.eFy().un(true))
    {
      localObject = t.eFy().eGv();
      if (localObject != null) {
        break;
      }
      ad.w("MicroMsg.WalletPayOrderMgr", "empty bankinfo list");
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
        if (!localBankcard.field_bindSerial.equals(localc.wBI)) {
          break;
        }
        localArrayList1.remove(localBankcard);
        localArrayList2.add(localBankcard);
      }
    }
    label166:
    if (!localArrayList1.isEmpty())
    {
      ad.w("MicroMsg.WalletPayOrderMgr", "has unsort bankcard");
      localArrayList2.addAll(localArrayList1);
    }
    AppMethodBeat.o(70433);
    return localArrayList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.af
 * JD-Core Version:    0.7.0.1
 */