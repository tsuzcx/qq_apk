package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  asl Olg = null;
  sg Olh;
  
  private static boolean a(List<asm> paramList, asl paramasl)
  {
    AppMethodBeat.i(67927);
    if (paramasl.YXg.size() == 0)
    {
      AppMethodBeat.o(67927);
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((asm)paramList.next()).ZCm));
    }
    paramList = paramasl.YXg.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((asm)paramList.next()).ZCm)))
      {
        AppMethodBeat.o(67927);
        return false;
      }
    }
    AppMethodBeat.o(67927);
    return true;
  }
  
  public final boolean a(List<asm> paramList, asm paramasm)
  {
    AppMethodBeat.i(67926);
    if (this.Olh == null)
    {
      Log.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      AppMethodBeat.o(67926);
      return false;
    }
    if (paramasm != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramasm.ZCm), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.Olh.YXh.iterator();
      while (localIterator.hasNext())
      {
        asl localasl = (asl)localIterator.next();
        if ((paramasm == null) || ((!Util.isNullOrNil((String)localObject1)) && (localasl.ZCd.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localasl);
        }
      }
      paramasm = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (asl)((Iterator)localObject1).next();
        if (a(paramList, (asl)localObject2)) {
          paramasm.add(localObject2);
        }
      }
      if (paramasm.size() > 0)
      {
        Collections.sort(paramasm, new a());
        this.Olg = ((asl)paramasm.get(0));
        AppMethodBeat.o(67926);
        return true;
      }
      this.Olg = null;
      AppMethodBeat.o(67926);
      return false;
    }
  }
  
  public final void aUa(String paramString)
  {
    AppMethodBeat.i(67925);
    this.Olg = null;
    if (paramString == null)
    {
      this.Olg = null;
      AppMethodBeat.o(67925);
      return;
    }
    if (this.Olh == null)
    {
      Log.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
      this.Olg = null;
      AppMethodBeat.o(67925);
      return;
    }
    Iterator localIterator = this.Olh.YXh.iterator();
    while (localIterator.hasNext())
    {
      asl localasl = (asl)localIterator.next();
      if (paramString.equals(localasl.ZCd))
      {
        this.Olg = localasl;
        AppMethodBeat.o(67925);
        return;
      }
    }
    AppMethodBeat.o(67925);
  }
  
  public final void gMn()
  {
    AppMethodBeat.i(67922);
    Log.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.Olh = null;
    this.Olg = null;
    AppMethodBeat.o(67922);
  }
  
  public final List<asm> gMo()
  {
    AppMethodBeat.i(67923);
    if (this.Olh != null)
    {
      localLinkedList = this.Olh.YXg;
      AppMethodBeat.o(67923);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(67923);
    return localLinkedList;
  }
  
  public final String gMp()
  {
    if (this.Olh == null) {
      return "";
    }
    return this.Olh.YXj;
  }
  
  public final boolean gMq()
  {
    return this.Olh != null;
  }
  
  public final boolean gMr()
  {
    AppMethodBeat.i(67924);
    if ((this.Olh != null) && (this.Olh.YXg != null) && (this.Olh.YXg.size() > 0))
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
      paramObject1 = (asl)paramObject1;
      paramObject2 = (asl)paramObject2;
      if (paramObject1.ZCh - paramObject2.ZCh > 0L) {
        return -1;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */