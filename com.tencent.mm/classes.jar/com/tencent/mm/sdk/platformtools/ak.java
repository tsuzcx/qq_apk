package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.HashSet;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "()V", "caches", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "clearSlot", "slotId", "", "slot", "contains", "", "containsKey", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public final class ak
  extends d<aj>
{
  private final HashMap<String, aj> GrP;
  
  public ak()
  {
    super(60L, (byte)0);
    AppMethodBeat.i(156378);
    this.GrP = new HashMap();
    AppMethodBeat.o(156378);
  }
  
  public final void Bk(String paramString)
  {
    AppMethodBeat.i(156376);
    k.h(paramString, "key");
    ((aj)eUr()).GrO.add(paramString);
    AppMethodBeat.o(156376);
  }
  
  protected final void bQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(156373);
    k.h(paramString, "slotKey");
    paramString = (aj)this.GrP.get(paramString);
    if (paramString != null)
    {
      paramString.id = paramLong;
      AppMethodBeat.o(156373);
      return;
    }
    AppMethodBeat.o(156373);
  }
  
  protected final boolean bR(String paramString, long paramLong)
  {
    AppMethodBeat.i(156374);
    k.h(paramString, "slotKey");
    paramString = (aj)this.GrP.get(paramString);
    if ((paramString != null) && (paramString.id == paramLong))
    {
      AppMethodBeat.o(156374);
      return true;
    }
    AppMethodBeat.o(156374);
    return false;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(156377);
    k.h(paramString, "key");
    if (aKv(paramString) != null)
    {
      AppMethodBeat.o(156377);
      return true;
    }
    AppMethodBeat.o(156377);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ak
 * JD-Core Version:    0.7.0.1
 */