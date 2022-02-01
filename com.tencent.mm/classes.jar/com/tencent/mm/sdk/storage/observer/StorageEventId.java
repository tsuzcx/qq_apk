package com.tencent.mm.sdk.storage.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "", "name", "", "(Ljava/lang/String;)V", "toString", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class StorageEventId
{
  public static final Companion Companion;
  private static final StorageEventId DELETE;
  private static final StorageEventId INSERT;
  private static final StorageEventId UNKNOWN;
  private static final StorageEventId UPDATE;
  private final String name;
  
  static
  {
    AppMethodBeat.i(244288);
    Companion = new Companion(null);
    UNKNOWN = new StorageEventId("UNKNOWN");
    INSERT = new StorageEventId("INSERT");
    UPDATE = new StorageEventId("UPDATE");
    DELETE = new StorageEventId("DELETE");
    AppMethodBeat.o(244288);
  }
  
  protected StorageEventId(String paramString)
  {
    AppMethodBeat.i(244253);
    this.name = paramString;
    AppMethodBeat.o(244253);
  }
  
  public static final StorageEventId getDELETE()
  {
    AppMethodBeat.i(244265);
    StorageEventId localStorageEventId = Companion.getDELETE();
    AppMethodBeat.o(244265);
    return localStorageEventId;
  }
  
  public static final StorageEventId getINSERT()
  {
    AppMethodBeat.i(244257);
    StorageEventId localStorageEventId = Companion.getINSERT();
    AppMethodBeat.o(244257);
    return localStorageEventId;
  }
  
  public static final StorageEventId getUNKNOWN()
  {
    AppMethodBeat.i(244254);
    StorageEventId localStorageEventId = Companion.getUNKNOWN();
    AppMethodBeat.o(244254);
    return localStorageEventId;
  }
  
  public static final StorageEventId getUPDATE()
  {
    AppMethodBeat.i(244262);
    StorageEventId localStorageEventId = Companion.getUPDATE();
    AppMethodBeat.o(244262);
    return localStorageEventId;
  }
  
  public String toString()
  {
    return this.name;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/observer/StorageEventId$Companion;", "", "()V", "DELETE", "Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "getDELETE$annotations", "getDELETE", "()Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "INSERT", "getINSERT$annotations", "getINSERT", "UNKNOWN", "getUNKNOWN$annotations", "getUNKNOWN", "UPDATE", "getUPDATE$annotations", "getUPDATE", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion
  {
    public final StorageEventId getDELETE()
    {
      AppMethodBeat.i(244331);
      StorageEventId localStorageEventId = StorageEventId.access$getDELETE$cp();
      AppMethodBeat.o(244331);
      return localStorageEventId;
    }
    
    public final StorageEventId getINSERT()
    {
      AppMethodBeat.i(244316);
      StorageEventId localStorageEventId = StorageEventId.access$getINSERT$cp();
      AppMethodBeat.o(244316);
      return localStorageEventId;
    }
    
    public final StorageEventId getUNKNOWN()
    {
      AppMethodBeat.i(244304);
      StorageEventId localStorageEventId = StorageEventId.access$getUNKNOWN$cp();
      AppMethodBeat.o(244304);
      return localStorageEventId;
    }
    
    public final StorageEventId getUPDATE()
    {
      AppMethodBeat.i(244323);
      StorageEventId localStorageEventId = StorageEventId.access$getUPDATE$cp();
      AppMethodBeat.o(244323);
      return localStorageEventId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.observer.StorageEventId
 * JD-Core Version:    0.7.0.1
 */