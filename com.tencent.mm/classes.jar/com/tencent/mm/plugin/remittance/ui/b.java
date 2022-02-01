package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  ald ypG = null;
  qb ypH;
  
  private static boolean a(List<ale> paramList, ald paramald)
  {
    AppMethodBeat.i(67927);
    if (paramald.GdG.size() == 0)
    {
      AppMethodBeat.o(67927);
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((ale)paramList.next()).GCX));
    }
    paramList = paramald.GdG.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((ale)paramList.next()).GCX)))
      {
        AppMethodBeat.o(67927);
        return false;
      }
    }
    AppMethodBeat.o(67927);
    return true;
  }
  
  public final boolean a(List<ale> paramList, ale paramale)
  {
    AppMethodBeat.i(67926);
    if (this.ypH == null)
    {
      ae.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      AppMethodBeat.o(67926);
      return false;
    }
    if (paramale != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramale.GCX), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.ypH.GdH.iterator();
      while (localIterator.hasNext())
      {
        ald localald = (ald)localIterator.next();
        if ((paramale == null) || ((!bu.isNullOrNil((String)localObject1)) && (localald.GCO.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localald);
        }
      }
      paramale = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ald)((Iterator)localObject1).next();
        if (a(paramList, (ald)localObject2)) {
          paramale.add(localObject2);
        }
      }
      if (paramale.size() > 0)
      {
        Collections.sort(paramale, new a());
        this.ypG = ((ald)paramale.get(0));
        AppMethodBeat.o(67926);
        return true;
      }
      this.ypG = null;
      AppMethodBeat.o(67926);
      return false;
    }
  }
  
  public final void axI(String paramString)
  {
    AppMethodBeat.i(67925);
    this.ypG = null;
    if (paramString == null)
    {
      this.ypG = null;
      AppMethodBeat.o(67925);
      return;
    }
    if (this.ypH == null)
    {
      ae.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
      this.ypG = null;
      AppMethodBeat.o(67925);
      return;
    }
    Iterator localIterator = this.ypH.GdH.iterator();
    while (localIterator.hasNext())
    {
      ald localald = (ald)localIterator.next();
      if (paramString.equals(localald.GCO))
      {
        this.ypG = localald;
        AppMethodBeat.o(67925);
        return;
      }
    }
    AppMethodBeat.o(67925);
  }
  
  public final void dMC()
  {
    AppMethodBeat.i(67922);
    ae.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.ypH = null;
    this.ypG = null;
    AppMethodBeat.o(67922);
  }
  
  public final List<ale> dMD()
  {
    AppMethodBeat.i(67923);
    if (this.ypH != null)
    {
      localLinkedList = this.ypH.GdG;
      AppMethodBeat.o(67923);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(67923);
    return localLinkedList;
  }
  
  public final String dME()
  {
    if (this.ypH == null) {
      return "";
    }
    return this.ypH.GdK;
  }
  
  public final boolean dMF()
  {
    return this.ypH != null;
  }
  
  public final boolean dMG()
  {
    AppMethodBeat.i(67924);
    if ((this.ypH != null) && (this.ypH.GdG != null) && (this.ypH.GdG.size() > 0))
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
      paramObject1 = (ald)paramObject1;
      paramObject2 = (ald)paramObject2;
      if (paramObject1.GCS - paramObject2.GCS > 0L) {
        return -1;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.b
 * JD-Core Version:    0.7.0.1
 */