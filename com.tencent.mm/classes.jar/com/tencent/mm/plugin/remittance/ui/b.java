package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.qv;
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
  aos InO = null;
  qv InP;
  
  private static boolean a(List<aot> paramList, aos paramaos)
  {
    AppMethodBeat.i(67927);
    if (paramaos.RZg.size() == 0)
    {
      AppMethodBeat.o(67927);
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((aot)paramList.next()).SBt));
    }
    paramList = paramaos.RZg.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((aot)paramList.next()).SBt)))
      {
        AppMethodBeat.o(67927);
        return false;
      }
    }
    AppMethodBeat.o(67927);
    return true;
  }
  
  public final boolean a(List<aot> paramList, aot paramaot)
  {
    AppMethodBeat.i(67926);
    if (this.InP == null)
    {
      Log.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      AppMethodBeat.o(67926);
      return false;
    }
    if (paramaot != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramaot.SBt), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.InP.RZh.iterator();
      while (localIterator.hasNext())
      {
        aos localaos = (aos)localIterator.next();
        if ((paramaot == null) || ((!Util.isNullOrNil((String)localObject1)) && (localaos.SBk.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localaos);
        }
      }
      paramaot = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aos)((Iterator)localObject1).next();
        if (a(paramList, (aos)localObject2)) {
          paramaot.add(localObject2);
        }
      }
      if (paramaot.size() > 0)
      {
        Collections.sort(paramaot, new a());
        this.InO = ((aos)paramaot.get(0));
        AppMethodBeat.o(67926);
        return true;
      }
      this.InO = null;
      AppMethodBeat.o(67926);
      return false;
    }
  }
  
  public final void aWM(String paramString)
  {
    AppMethodBeat.i(67925);
    this.InO = null;
    if (paramString == null)
    {
      this.InO = null;
      AppMethodBeat.o(67925);
      return;
    }
    if (this.InP == null)
    {
      Log.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
      this.InO = null;
      AppMethodBeat.o(67925);
      return;
    }
    Iterator localIterator = this.InP.RZh.iterator();
    while (localIterator.hasNext())
    {
      aos localaos = (aos)localIterator.next();
      if (paramString.equals(localaos.SBk))
      {
        this.InO = localaos;
        AppMethodBeat.o(67925);
        return;
      }
    }
    AppMethodBeat.o(67925);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(67922);
    Log.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.InP = null;
    this.InO = null;
    AppMethodBeat.o(67922);
  }
  
  public final List<aot> fAt()
  {
    AppMethodBeat.i(67923);
    if (this.InP != null)
    {
      localLinkedList = this.InP.RZg;
      AppMethodBeat.o(67923);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(67923);
    return localLinkedList;
  }
  
  public final String fAu()
  {
    if (this.InP == null) {
      return "";
    }
    return this.InP.RZk;
  }
  
  public final boolean fAv()
  {
    return this.InP != null;
  }
  
  public final boolean fAw()
  {
    AppMethodBeat.i(67924);
    if ((this.InP != null) && (this.InP.RZg != null) && (this.InP.RZg.size() > 0))
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
      paramObject1 = (aos)paramObject1;
      paramObject2 = (aos)paramObject2;
      if (paramObject1.SBo - paramObject2.SBo > 0L) {
        return -1;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.b
 * JD-Core Version:    0.7.0.1
 */