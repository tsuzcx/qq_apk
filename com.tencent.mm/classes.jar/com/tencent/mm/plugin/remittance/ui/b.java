package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  aid wMh = null;
  ou wMi;
  
  private static boolean a(List<aie> paramList, aid paramaid)
  {
    AppMethodBeat.i(67927);
    if (paramaid.EeI.size() == 0)
    {
      AppMethodBeat.o(67927);
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((aie)paramList.next()).ECB));
    }
    paramList = paramaid.EeI.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((aie)paramList.next()).ECB)))
      {
        AppMethodBeat.o(67927);
        return false;
      }
    }
    AppMethodBeat.o(67927);
    return true;
  }
  
  public final boolean a(List<aie> paramList, aie paramaie)
  {
    AppMethodBeat.i(67926);
    if (this.wMi == null)
    {
      ac.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      AppMethodBeat.o(67926);
      return false;
    }
    if (paramaie != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramaie.ECB), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.wMi.EeJ.iterator();
      while (localIterator.hasNext())
      {
        aid localaid = (aid)localIterator.next();
        if ((paramaie == null) || ((!bs.isNullOrNil((String)localObject1)) && (localaid.ECs.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localaid);
        }
      }
      paramaie = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aid)((Iterator)localObject1).next();
        if (a(paramList, (aid)localObject2)) {
          paramaie.add(localObject2);
        }
      }
      if (paramaie.size() > 0)
      {
        Collections.sort(paramaie, new a());
        this.wMh = ((aid)paramaie.get(0));
        AppMethodBeat.o(67926);
        return true;
      }
      this.wMh = null;
      AppMethodBeat.o(67926);
      return false;
    }
  }
  
  public final void art(String paramString)
  {
    AppMethodBeat.i(67925);
    this.wMh = null;
    if (paramString == null)
    {
      this.wMh = null;
      AppMethodBeat.o(67925);
      return;
    }
    if (this.wMi == null)
    {
      ac.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
      this.wMh = null;
      AppMethodBeat.o(67925);
      return;
    }
    Iterator localIterator = this.wMi.EeJ.iterator();
    while (localIterator.hasNext())
    {
      aid localaid = (aid)localIterator.next();
      if (paramString.equals(localaid.ECs))
      {
        this.wMh = localaid;
        AppMethodBeat.o(67925);
        return;
      }
    }
    AppMethodBeat.o(67925);
  }
  
  public final void dxS()
  {
    AppMethodBeat.i(67922);
    ac.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.wMi = null;
    this.wMh = null;
    AppMethodBeat.o(67922);
  }
  
  public final List<aie> dxT()
  {
    AppMethodBeat.i(67923);
    if (this.wMi != null)
    {
      localLinkedList = this.wMi.EeI;
      AppMethodBeat.o(67923);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(67923);
    return localLinkedList;
  }
  
  public final String dxU()
  {
    if (this.wMi == null) {
      return "";
    }
    return this.wMi.EeM;
  }
  
  public final boolean dxV()
  {
    return this.wMi != null;
  }
  
  public final boolean dxW()
  {
    AppMethodBeat.i(67924);
    if ((this.wMi != null) && (this.wMi.EeI != null) && (this.wMi.EeI.size() > 0))
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
      paramObject1 = (aid)paramObject1;
      paramObject2 = (aid)paramObject2;
      if (paramObject1.ECw - paramObject2.ECw > 0L) {
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