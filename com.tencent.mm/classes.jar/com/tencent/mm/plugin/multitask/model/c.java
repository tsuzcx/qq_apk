package com.tencent.mm.plugin.multitask.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorageEventId;", "Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "name", "", "(Ljava/lang/String;)V", "Companion", "plugin-multitask_release"})
public final class c
  extends StorageEventId
{
  private static final c FHL;
  public static final a FHM;
  
  static
  {
    AppMethodBeat.i(248685);
    FHM = new a((byte)0);
    FHL = new c("MOVE");
    AppMethodBeat.o(248685);
  }
  
  private c(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(248683);
    AppMethodBeat.o(248683);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorageEventId$Companion;", "", "()V", "MOVE", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorageEventId;", "MOVE$annotations", "getMOVE", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorageEventId;", "plugin-multitask_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.model.c
 * JD-Core Version:    0.7.0.1
 */