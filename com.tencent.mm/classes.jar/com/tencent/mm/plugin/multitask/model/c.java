package com.tencent.mm.plugin.multitask.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorageEventId;", "Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "name", "", "(Ljava/lang/String;)V", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends StorageEventId
{
  public static final a LDh;
  private static final c LDi;
  
  static
  {
    AppMethodBeat.i(303798);
    LDh = new a((byte)0);
    LDi = new c("MOVE");
    AppMethodBeat.o(303798);
  }
  
  private c(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(303784);
    AppMethodBeat.o(303784);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorageEventId$Companion;", "", "()V", "MOVE", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorageEventId;", "getMOVE$annotations", "getMOVE", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorageEventId;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.model.c
 * JD-Core Version:    0.7.0.1
 */