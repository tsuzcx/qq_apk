package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.on;
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
  ahe vCc = null;
  on vCd;
  
  private static boolean a(List<ahf> paramList, ahe paramahe)
  {
    AppMethodBeat.i(67927);
    if (paramahe.CMg.size() == 0)
    {
      AppMethodBeat.o(67927);
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((ahf)paramList.next()).Djv));
    }
    paramList = paramahe.CMg.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((ahf)paramList.next()).Djv)))
      {
        AppMethodBeat.o(67927);
        return false;
      }
    }
    AppMethodBeat.o(67927);
    return true;
  }
  
  public final boolean a(List<ahf> paramList, ahf paramahf)
  {
    AppMethodBeat.i(67926);
    if (this.vCd == null)
    {
      ad.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      AppMethodBeat.o(67926);
      return false;
    }
    if (paramahf != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramahf.Djv), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.vCd.CMh.iterator();
      while (localIterator.hasNext())
      {
        ahe localahe = (ahe)localIterator.next();
        if ((paramahf == null) || ((!bt.isNullOrNil((String)localObject1)) && (localahe.Djm.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localahe);
        }
      }
      paramahf = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ahe)((Iterator)localObject1).next();
        if (a(paramList, (ahe)localObject2)) {
          paramahf.add(localObject2);
        }
      }
      if (paramahf.size() > 0)
      {
        Collections.sort(paramahf, new a());
        this.vCc = ((ahe)paramahf.get(0));
        AppMethodBeat.o(67926);
        return true;
      }
      this.vCc = null;
      AppMethodBeat.o(67926);
      return false;
    }
  }
  
  public final void amm(String paramString)
  {
    AppMethodBeat.i(67925);
    this.vCc = null;
    if (paramString == null)
    {
      this.vCc = null;
      AppMethodBeat.o(67925);
      return;
    }
    if (this.vCd == null)
    {
      ad.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
      this.vCc = null;
      AppMethodBeat.o(67925);
      return;
    }
    Iterator localIterator = this.vCd.CMh.iterator();
    while (localIterator.hasNext())
    {
      ahe localahe = (ahe)localIterator.next();
      if (paramString.equals(localahe.Djm))
      {
        this.vCc = localahe;
        AppMethodBeat.o(67925);
        return;
      }
    }
    AppMethodBeat.o(67925);
  }
  
  public final void djQ()
  {
    AppMethodBeat.i(67922);
    ad.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.vCd = null;
    this.vCc = null;
    AppMethodBeat.o(67922);
  }
  
  public final List<ahf> djR()
  {
    AppMethodBeat.i(67923);
    if (this.vCd != null)
    {
      localLinkedList = this.vCd.CMg;
      AppMethodBeat.o(67923);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(67923);
    return localLinkedList;
  }
  
  public final String djS()
  {
    if (this.vCd == null) {
      return "";
    }
    return this.vCd.CMk;
  }
  
  public final boolean djT()
  {
    return this.vCd != null;
  }
  
  public final boolean djU()
  {
    AppMethodBeat.i(67924);
    if ((this.vCd != null) && (this.vCd.CMg != null) && (this.vCd.CMg.size() > 0))
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
      paramObject1 = (ahe)paramObject1;
      paramObject2 = (ahe)paramObject2;
      if (paramObject1.Djq - paramObject2.Djq > 0L) {
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