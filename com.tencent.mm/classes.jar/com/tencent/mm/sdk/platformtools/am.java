package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.HashSet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "()V", "caches", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "clearSlot", "slotId", "", "slot", "contains", "", "containsKey", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public final class am
  extends f<al>
{
  private final HashMap<String, al> IxP;
  
  public am()
  {
    super(60L, (byte)0);
    AppMethodBeat.i(156378);
    this.IxP = new HashMap();
    AppMethodBeat.o(156378);
  }
  
  public final void EL(String paramString)
  {
    AppMethodBeat.i(156376);
    p.h(paramString, "key");
    ((al)fnP()).IxO.add(paramString);
    AppMethodBeat.o(156376);
  }
  
  protected final void bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(156373);
    p.h(paramString, "slotKey");
    paramString = (al)this.IxP.get(paramString);
    if (paramString != null)
    {
      paramString.id = paramLong;
      AppMethodBeat.o(156373);
      return;
    }
    AppMethodBeat.o(156373);
  }
  
  protected final boolean bW(String paramString, long paramLong)
  {
    AppMethodBeat.i(156374);
    p.h(paramString, "slotKey");
    paramString = (al)this.IxP.get(paramString);
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
    if (aRy(paramString) != null)
    {
      AppMethodBeat.o(156377);
      return true;
    }
    AppMethodBeat.o(156377);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.am
 * JD-Core Version:    0.7.0.1
 */