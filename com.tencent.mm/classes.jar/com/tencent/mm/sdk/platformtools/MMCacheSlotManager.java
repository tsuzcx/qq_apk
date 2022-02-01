package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "()V", "caches", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "clearSlot", "slotId", "", "slot", "contains", "", "containsKey", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public final class MMCacheSlotManager
  extends BaseSlotManager<MMCacheSlot>
{
  private final HashMap<String, MMCacheSlot> caches;
  
  public MMCacheSlotManager()
  {
    super(60L, 0, 2, null);
    AppMethodBeat.i(156378);
    this.caches = new HashMap();
    AppMethodBeat.o(156378);
  }
  
  public final void add(String paramString)
  {
    AppMethodBeat.i(156376);
    p.h(paramString, "key");
    ((MMCacheSlot)getSlot()).getKeys$libcompatible_release().add(paramString);
    AppMethodBeat.o(156376);
  }
  
  protected final void clearSlot(long paramLong, MMCacheSlot paramMMCacheSlot)
  {
    AppMethodBeat.i(215481);
    p.h(paramMMCacheSlot, "slot");
    paramMMCacheSlot.getKeys$libcompatible_release().clear();
    AppMethodBeat.o(215481);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(156377);
    p.h(paramString, "key");
    if (findSlot(paramString) != null)
    {
      AppMethodBeat.o(156377);
      return true;
    }
    AppMethodBeat.o(156377);
    return false;
  }
  
  protected final boolean containsKey(MMCacheSlot paramMMCacheSlot, String paramString)
  {
    AppMethodBeat.i(215483);
    p.h(paramMMCacheSlot, "slot");
    p.h(paramString, "key");
    boolean bool = paramMMCacheSlot.getKeys$libcompatible_release().contains(paramString);
    AppMethodBeat.o(215483);
    return bool;
  }
  
  protected final MMCacheSlot getSlotByKey(String paramString, long paramLong)
  {
    AppMethodBeat.i(215482);
    p.h(paramString, "slotKey");
    if (!this.caches.containsKey(paramString)) {
      ((Map)this.caches).put(paramString, new MMCacheSlot());
    }
    paramString = this.caches.get(paramString);
    if (paramString == null) {
      p.hyc();
    }
    paramString = (MMCacheSlot)paramString;
    AppMethodBeat.o(215482);
    return paramString;
  }
  
  protected final void remarkSlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156373);
    p.h(paramString, "slotKey");
    paramString = (MMCacheSlot)this.caches.get(paramString);
    if (paramString != null)
    {
      paramString.setId$libcompatible_release(paramLong);
      AppMethodBeat.o(156373);
      return;
    }
    AppMethodBeat.o(156373);
  }
  
  protected final boolean verifySlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156374);
    p.h(paramString, "slotKey");
    paramString = (MMCacheSlot)this.caches.get(paramString);
    if ((paramString != null) && (paramString.getId$libcompatible_release() == paramLong))
    {
      AppMethodBeat.o(156374);
      return true;
    }
    AppMethodBeat.o(156374);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMCacheSlotManager
 * JD-Core Version:    0.7.0.1
 */