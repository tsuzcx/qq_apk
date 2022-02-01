package com.tencent.mm.sdk.storage.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "", "name", "", "(Ljava/lang/String;)V", "toString", "Companion", "wechat-sdk_release"})
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
    AppMethodBeat.i(187452);
    Companion = new Companion(null);
    UNKNOWN = new StorageEventId("UNKNOWN");
    INSERT = new StorageEventId("INSERT");
    UPDATE = new StorageEventId("UPDATE");
    DELETE = new StorageEventId("DELETE");
    AppMethodBeat.o(187452);
  }
  
  protected StorageEventId(String paramString)
  {
    AppMethodBeat.i(187451);
    this.name = paramString;
    AppMethodBeat.o(187451);
  }
  
  public static final StorageEventId getDELETE()
  {
    return DELETE;
  }
  
  public static final StorageEventId getINSERT()
  {
    return INSERT;
  }
  
  public static final StorageEventId getUNKNOWN()
  {
    return UNKNOWN;
  }
  
  public static final StorageEventId getUPDATE()
  {
    return UPDATE;
  }
  
  public String toString()
  {
    return this.name;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/observer/StorageEventId$Companion;", "", "()V", "DELETE", "Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "DELETE$annotations", "getDELETE", "()Lcom/tencent/mm/sdk/storage/observer/StorageEventId;", "INSERT", "INSERT$annotations", "getINSERT", "UNKNOWN", "UNKNOWN$annotations", "getUNKNOWN", "UPDATE", "UPDATE$annotations", "getUPDATE", "wechat-sdk_release"})
  public static final class Companion
  {
    public final StorageEventId getDELETE()
    {
      AppMethodBeat.i(190500);
      StorageEventId localStorageEventId = StorageEventId.access$getDELETE$cp();
      AppMethodBeat.o(190500);
      return localStorageEventId;
    }
    
    public final StorageEventId getINSERT()
    {
      AppMethodBeat.i(190494);
      StorageEventId localStorageEventId = StorageEventId.access$getINSERT$cp();
      AppMethodBeat.o(190494);
      return localStorageEventId;
    }
    
    public final StorageEventId getUNKNOWN()
    {
      AppMethodBeat.i(190491);
      StorageEventId localStorageEventId = StorageEventId.access$getUNKNOWN$cp();
      AppMethodBeat.o(190491);
      return localStorageEventId;
    }
    
    public final StorageEventId getUPDATE()
    {
      AppMethodBeat.i(190496);
      StorageEventId localStorageEventId = StorageEventId.access$getUPDATE$cp();
      AppMethodBeat.o(190496);
      return localStorageEventId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.observer.StorageEventId
 * JD-Core Version:    0.7.0.1
 */