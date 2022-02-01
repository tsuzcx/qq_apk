package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  anr Cqx = null;
  rc Cqy;
  
  private static boolean a(List<ans> paramList, anr paramanr)
  {
    AppMethodBeat.i(67927);
    if (paramanr.KXX.size() == 0)
    {
      AppMethodBeat.o(67927);
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((ans)paramList.next()).LyS));
    }
    paramList = paramanr.KXX.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((ans)paramList.next()).LyS)))
      {
        AppMethodBeat.o(67927);
        return false;
      }
    }
    AppMethodBeat.o(67927);
    return true;
  }
  
  public final boolean a(List<ans> paramList, ans paramans)
  {
    AppMethodBeat.i(67926);
    if (this.Cqy == null)
    {
      Log.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      AppMethodBeat.o(67926);
      return false;
    }
    if (paramans != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramans.LyS), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.Cqy.KXY.iterator();
      while (localIterator.hasNext())
      {
        anr localanr = (anr)localIterator.next();
        if ((paramans == null) || ((!Util.isNullOrNil((String)localObject1)) && (localanr.LyJ.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localanr);
        }
      }
      paramans = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (anr)((Iterator)localObject1).next();
        if (a(paramList, (anr)localObject2)) {
          paramans.add(localObject2);
        }
      }
      if (paramans.size() > 0)
      {
        Collections.sort(paramans, new a());
        this.Cqx = ((anr)paramans.get(0));
        AppMethodBeat.o(67926);
        return true;
      }
      this.Cqx = null;
      AppMethodBeat.o(67926);
      return false;
    }
  }
  
  public final void aMi(String paramString)
  {
    AppMethodBeat.i(67925);
    this.Cqx = null;
    if (paramString == null)
    {
      this.Cqx = null;
      AppMethodBeat.o(67925);
      return;
    }
    if (this.Cqy == null)
    {
      Log.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
      this.Cqx = null;
      AppMethodBeat.o(67925);
      return;
    }
    Iterator localIterator = this.Cqy.KXY.iterator();
    while (localIterator.hasNext())
    {
      anr localanr = (anr)localIterator.next();
      if (paramString.equals(localanr.LyJ))
      {
        this.Cqx = localanr;
        AppMethodBeat.o(67925);
        return;
      }
    }
    AppMethodBeat.o(67925);
  }
  
  public final void eNC()
  {
    AppMethodBeat.i(67922);
    Log.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.Cqy = null;
    this.Cqx = null;
    AppMethodBeat.o(67922);
  }
  
  public final List<ans> eND()
  {
    AppMethodBeat.i(67923);
    if (this.Cqy != null)
    {
      localLinkedList = this.Cqy.KXX;
      AppMethodBeat.o(67923);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(67923);
    return localLinkedList;
  }
  
  public final String eNE()
  {
    if (this.Cqy == null) {
      return "";
    }
    return this.Cqy.KYb;
  }
  
  public final boolean eNF()
  {
    return this.Cqy != null;
  }
  
  public final boolean eNG()
  {
    AppMethodBeat.i(67924);
    if ((this.Cqy != null) && (this.Cqy.KXX != null) && (this.Cqy.KXX.size() > 0))
    {
      AppMethodBeat.o(67924);
      return true;
    }
    AppMethodBeat.o(67924);
    return false;
  }
  
  final class a
    implements Comparator
  {
    a() {}
    
    public final int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (anr)paramObject1;
      paramObject2 = (anr)paramObject2;
      if (paramObject1.LyN - paramObject2.LyN > 0L) {
        return -1;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.b
 * JD-Core Version:    0.7.0.1
 */