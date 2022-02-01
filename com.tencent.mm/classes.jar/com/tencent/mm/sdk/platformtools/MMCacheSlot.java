package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "", "()V", "id", "", "getId$libcompatible_release", "()J", "setId$libcompatible_release", "(J)V", "keys", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getKeys$libcompatible_release", "()Ljava/util/HashSet;", "libcompatible_release"})
public final class MMCacheSlot
{
  private long id;
  private final HashSet<String> keys;
  
  public MMCacheSlot()
  {
    AppMethodBeat.i(156370);
    this.keys = new HashSet();
    AppMethodBeat.o(156370);
  }
  
  public final long getId$libcompatible_release()
  {
    return this.id;
  }
  
  public final HashSet<String> getKeys$libcompatible_release()
  {
    return this.keys;
  }
  
  public final void setId$libcompatible_release(long paramLong)
  {
    this.id = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMCacheSlot
 * JD-Core Version:    0.7.0.1
 */