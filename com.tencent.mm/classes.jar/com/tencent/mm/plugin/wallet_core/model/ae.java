package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ae
{
  public static List<Bankcard> erJ()
  {
    AppMethodBeat.i(210294);
    ArrayList localArrayList = tC(false);
    AppMethodBeat.o(210294);
    return localArrayList;
  }
  
  public static ArrayList<Bankcard> tC(boolean paramBoolean)
  {
    AppMethodBeat.i(70433);
    ac.i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (ArrayList localArrayList1 = s.ery().esx();; localArrayList1 = s.ery().tD(true))
    {
      localObject = s.ery().esv();
      if (localObject != null) {
        break;
      }
      ac.w("MicroMsg.WalletPayOrderMgr", "empty bankinfo list");
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
        if (!localBankcard.field_bindSerial.equals(localc.vwo)) {
          break;
        }
        localArrayList1.remove(localBankcard);
        localArrayList2.add(localBankcard);
      }
    }
    label166:
    if (!localArrayList1.isEmpty())
    {
      ac.w("MicroMsg.WalletPayOrderMgr", "has unsort bankcard");
      localArrayList2.addAll(localArrayList1);
    }
    AppMethodBeat.o(70433);
    return localArrayList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ae
 * JD-Core Version:    0.7.0.1
 */