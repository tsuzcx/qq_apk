package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.HashSet;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "()V", "caches", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "clearSlot", "slotId", "", "slot", "contains", "", "containsKey", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public final class al
  extends d<ak>
{
  private final HashMap<String, ak> EUD;
  
  public al()
  {
    super(60L, (byte)0);
    AppMethodBeat.i(156378);
    this.EUD = new HashMap();
    AppMethodBeat.o(156378);
  }
  
  protected final void bO(String paramString, long paramLong)
  {
    AppMethodBeat.i(156373);
    k.h(paramString, "slotKey");
    paramString = (ak)this.EUD.get(paramString);
    if (paramString != null)
    {
      paramString.id = paramLong;
      AppMethodBeat.o(156373);
      return;
    }
    AppMethodBeat.o(156373);
  }
  
  protected final boolean bP(String paramString, long paramLong)
  {
    AppMethodBeat.i(156374);
    k.h(paramString, "slotKey");
    paramString = (ak)this.EUD.get(paramString);
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
    if (aFe(paramString) != null)
    {
      AppMethodBeat.o(156377);
      return true;
    }
    AppMethodBeat.o(156377);
    return false;
  }
  
  public final void xe(String paramString)
  {
    AppMethodBeat.i(156376);
    k.h(paramString, "key");
    ((ak)eEX()).EUC.add(paramString);
    AppMethodBeat.o(156376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.al
 * JD-Core Version:    0.7.0.1
 */