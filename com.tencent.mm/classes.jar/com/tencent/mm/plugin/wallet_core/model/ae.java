package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ae
{
  public static List<Bankcard> cTX()
  {
    AppMethodBeat.i(156739);
    ArrayList localArrayList = nG(false);
    AppMethodBeat.o(156739);
    return localArrayList;
  }
  
  public static ArrayList<Bankcard> nG(boolean paramBoolean)
  {
    AppMethodBeat.i(46914);
    ab.i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (ArrayList localArrayList1 = t.cTN().cUI();; localArrayList1 = t.cTN().nH(true))
    {
      localObject1 = t.cTN().cUG();
      if (localObject1 != null) {
        break;
      }
      ab.w("MicroMsg.WalletPayOrderMgr", "empty bankinfo list");
      AppMethodBeat.o(46914);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (e)((Iterator)localObject1).next();
      localObject2 = t.cTN().i(((e)localObject2).por, true, true);
      if (localObject2 != null)
      {
        localArrayList2.add(localObject2);
        localArrayList1.remove(localObject2);
      }
    }
    if (!localArrayList1.isEmpty())
    {
      ab.w("MicroMsg.WalletPayOrderMgr", "has unsort bankcard");
      localArrayList2.addAll(localArrayList1);
    }
    AppMethodBeat.o(46914);
    return localArrayList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ae
 * JD-Core Version:    0.7.0.1
 */