package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  akt xZO = null;
  pz xZP;
  
  private static boolean a(List<aku> paramList, akt paramakt)
  {
    AppMethodBeat.i(67927);
    if (paramakt.FLh.size() == 0)
    {
      AppMethodBeat.o(67927);
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((aku)paramList.next()).Gkn));
    }
    paramList = paramakt.FLh.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((aku)paramList.next()).Gkn)))
      {
        AppMethodBeat.o(67927);
        return false;
      }
    }
    AppMethodBeat.o(67927);
    return true;
  }
  
  public final boolean a(List<aku> paramList, aku paramaku)
  {
    AppMethodBeat.i(67926);
    if (this.xZP == null)
    {
      ad.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      AppMethodBeat.o(67926);
      return false;
    }
    if (paramaku != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramaku.Gkn), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.xZP.FLi.iterator();
      while (localIterator.hasNext())
      {
        akt localakt = (akt)localIterator.next();
        if ((paramaku == null) || ((!bt.isNullOrNil((String)localObject1)) && (localakt.Gke.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localakt);
        }
      }
      paramaku = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (akt)((Iterator)localObject1).next();
        if (a(paramList, (akt)localObject2)) {
          paramaku.add(localObject2);
        }
      }
      if (paramaku.size() > 0)
      {
        Collections.sort(paramaku, new a());
        this.xZO = ((akt)paramaku.get(0));
        AppMethodBeat.o(67926);
        return true;
      }
      this.xZO = null;
      AppMethodBeat.o(67926);
      return false;
    }
  }
  
  public final void awt(String paramString)
  {
    AppMethodBeat.i(67925);
    this.xZO = null;
    if (paramString == null)
    {
      this.xZO = null;
      AppMethodBeat.o(67925);
      return;
    }
    if (this.xZP == null)
    {
      ad.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
      this.xZO = null;
      AppMethodBeat.o(67925);
      return;
    }
    Iterator localIterator = this.xZP.FLi.iterator();
    while (localIterator.hasNext())
    {
      akt localakt = (akt)localIterator.next();
      if (paramString.equals(localakt.Gke))
      {
        this.xZO = localakt;
        AppMethodBeat.o(67925);
        return;
      }
    }
    AppMethodBeat.o(67925);
  }
  
  public final void dJk()
  {
    AppMethodBeat.i(67922);
    ad.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.xZP = null;
    this.xZO = null;
    AppMethodBeat.o(67922);
  }
  
  public final List<aku> dJl()
  {
    AppMethodBeat.i(67923);
    if (this.xZP != null)
    {
      localLinkedList = this.xZP.FLh;
      AppMethodBeat.o(67923);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(67923);
    return localLinkedList;
  }
  
  public final String dJm()
  {
    if (this.xZP == null) {
      return "";
    }
    return this.xZP.FLl;
  }
  
  public final boolean dJn()
  {
    return this.xZP != null;
  }
  
  public final boolean dJo()
  {
    AppMethodBeat.i(67924);
    if ((this.xZP != null) && (this.xZP.FLh != null) && (this.xZP.FLh.size() > 0))
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
      paramObject1 = (akt)paramObject1;
      paramObject2 = (akt)paramObject2;
      if (paramObject1.Gki - paramObject2.Gki > 0L) {
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