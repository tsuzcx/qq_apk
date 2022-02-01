package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "()V", "caches", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "clearSlot", "slotId", "", "slot", "contains", "", "containsKey", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    s.u(paramString, "key");
    ((MMCacheSlot)getSlotForWrite()).getKeys$libcompatible_release().add(paramString);
    AppMethodBeat.o(156376);
  }
  
  protected final void clearSlot(long paramLong, MMCacheSlot paramMMCacheSlot)
  {
    AppMethodBeat.i(243641);
    s.u(paramMMCacheSlot, "slot");
    paramMMCacheSlot.getKeys$libcompatible_release().clear();
    AppMethodBeat.o(243641);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(156377);
    s.u(paramString, "key");
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
    AppMethodBeat.i(243658);
    s.u(paramMMCacheSlot, "slot");
    s.u(paramString, "key");
    boolean bool = paramMMCacheSlot.getKeys$libcompatible_release().contains(paramString);
    AppMethodBeat.o(243658);
    return bool;
  }
  
  /* Error */
  protected final MMCacheSlot getSlotByKey(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 109
    //   4: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 110
    //   10: invokestatic 68	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 55	com/tencent/mm/sdk/platformtools/MMCacheSlotManager:caches	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 114	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 74	com/tencent/mm/sdk/platformtools/MMCacheSlot
    //   24: astore 4
    //   26: aload 4
    //   28: ifnonnull +40 -> 68
    //   31: new 74	com/tencent/mm/sdk/platformtools/MMCacheSlot
    //   34: dup
    //   35: invokespecial 115	com/tencent/mm/sdk/platformtools/MMCacheSlot:<init>	()V
    //   38: astore 4
    //   40: aload_0
    //   41: getfield 55	com/tencent/mm/sdk/platformtools/MMCacheSlotManager:caches	Ljava/util/HashMap;
    //   44: checkcast 117	java/util/Map
    //   47: aload_1
    //   48: aload 4
    //   50: invokeinterface 121 3 0
    //   55: pop
    //   56: ldc 109
    //   58: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload 4
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: ldc 109
    //   70: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload 4
    //   75: astore_1
    //   76: goto -12 -> 64
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	MMCacheSlotManager
    //   0	84	1	paramString	String
    //   0	84	2	paramLong	long
    //   24	50	4	localMMCacheSlot	MMCacheSlot
    // Exception table:
    //   from	to	target	type
    //   2	26	79	finally
    //   31	61	79	finally
    //   68	73	79	finally
  }
  
  protected final void remarkSlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156373);
    s.u(paramString, "slotKey");
    paramString = (MMCacheSlot)this.caches.get(paramString);
    if (paramString != null) {
      paramString.setId$libcompatible_release(paramLong);
    }
    AppMethodBeat.o(156373);
  }
  
  protected final boolean verifySlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156374);
    s.u(paramString, "slotKey");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMCacheSlotManager
 * JD-Core Version:    0.7.0.1
 */