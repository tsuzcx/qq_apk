package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.HashSet;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "()V", "caches", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "clearSlot", "slotId", "", "slot", "contains", "", "containsKey", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public final class al
  extends e<ak>
{
  private final HashMap<String, ak> IdE;
  
  public al()
  {
    super(60L, (byte)0);
    AppMethodBeat.i(156378);
    this.IdE = new HashMap();
    AppMethodBeat.o(156378);
  }
  
  public final void Ej(String paramString)
  {
    AppMethodBeat.i(156376);
    p.h(paramString, "key");
    ((ak)fjV()).IdD.add(paramString);
    AppMethodBeat.o(156376);
  }
  
  protected final void bU(String paramString, long paramLong)
  {
    AppMethodBeat.i(156373);
    p.h(paramString, "slotKey");
    paramString = (ak)this.IdE.get(paramString);
    if (paramString != null)
    {
      paramString.id = paramLong;
      AppMethodBeat.o(156373);
      return;
    }
    AppMethodBeat.o(156373);
  }
  
  protected final boolean bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(156374);
    p.h(paramString, "slotKey");
    paramString = (ak)this.IdE.get(paramString);
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
    p.h(paramString, "key");
    if (aQb(paramString) != null)
    {
      AppMethodBeat.o(156377);
      return true;
    }
    AppMethodBeat.o(156377);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.al
 * JD-Core Version:    0.7.0.1
 */