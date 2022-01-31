package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  adg qkU = null;
  mk qkV;
  
  private static boolean a(List<adh> paramList, adg paramadg)
  {
    AppMethodBeat.i(44813);
    if (paramadg.wAS.size() == 0)
    {
      AppMethodBeat.o(44813);
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((adh)paramList.next()).wVT));
    }
    paramList = paramadg.wAS.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((adh)paramList.next()).wVT)))
      {
        AppMethodBeat.o(44813);
        return false;
      }
    }
    AppMethodBeat.o(44813);
    return true;
  }
  
  public final void Yj(String paramString)
  {
    AppMethodBeat.i(44811);
    this.qkU = null;
    if (paramString == null)
    {
      this.qkU = null;
      AppMethodBeat.o(44811);
      return;
    }
    if (this.qkV == null)
    {
      ab.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
      this.qkU = null;
      AppMethodBeat.o(44811);
      return;
    }
    Iterator localIterator = this.qkV.wAT.iterator();
    while (localIterator.hasNext())
    {
      adg localadg = (adg)localIterator.next();
      if (paramString.equals(localadg.wVK))
      {
        this.qkU = localadg;
        AppMethodBeat.o(44811);
        return;
      }
    }
    AppMethodBeat.o(44811);
  }
  
  public final boolean a(List<adh> paramList, adh paramadh)
  {
    AppMethodBeat.i(44812);
    if (this.qkV == null)
    {
      ab.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      AppMethodBeat.o(44812);
      return false;
    }
    if (paramadh != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramadh.wVT), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.qkV.wAT.iterator();
      while (localIterator.hasNext())
      {
        adg localadg = (adg)localIterator.next();
        if ((paramadh == null) || ((!bo.isNullOrNil((String)localObject1)) && (localadg.wVK.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localadg);
        }
      }
      paramadh = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (adg)((Iterator)localObject1).next();
        if (a(paramList, (adg)localObject2)) {
          paramadh.add(localObject2);
        }
      }
      if (paramadh.size() > 0)
      {
        Collections.sort(paramadh, new b.a(this));
        this.qkU = ((adg)paramadh.get(0));
        AppMethodBeat.o(44812);
        return true;
      }
      this.qkU = null;
      AppMethodBeat.o(44812);
      return false;
    }
  }
  
  public final void cgZ()
  {
    AppMethodBeat.i(44808);
    ab.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.qkV = null;
    this.qkU = null;
    AppMethodBeat.o(44808);
  }
  
  public final List<adh> cha()
  {
    AppMethodBeat.i(44809);
    if (this.qkV != null)
    {
      localLinkedList = this.qkV.wAS;
      AppMethodBeat.o(44809);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(44809);
    return localLinkedList;
  }
  
  public final String chb()
  {
    if (this.qkV == null) {
      return "";
    }
    return this.qkV.wAW;
  }
  
  public final boolean chc()
  {
    return this.qkV != null;
  }
  
  public final boolean chd()
  {
    AppMethodBeat.i(44810);
    if ((this.qkV != null) && (this.qkV.wAS != null) && (this.qkV.wAS.size() > 0))
    {
      AppMethodBeat.o(44810);
      return true;
    }
    AppMethodBeat.o(44810);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.b
 * JD-Core Version:    0.7.0.1
 */