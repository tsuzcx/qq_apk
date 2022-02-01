package com.tencent.mm.sdk.storage.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.observer.ILifecycleObserver;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "T", "Lcom/tencent/mm/sdk/observer/ILifecycleObserver;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "Companion", "wechat-sdk_release"})
public abstract interface IStorageObserver<T>
  extends ILifecycleObserver<StorageObserverEvent<T>>
{
  public static final Companion Companion = Companion.$$INSTANCE;
  public static final String MainThread = "%MainThread%";
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/observer/IStorageObserver$Companion;", "", "()V", "MainThread", "", "wechat-sdk_release"})
  public static final class Companion
  {
    public static final String MainThread = "%MainThread%";
    
    static
    {
      AppMethodBeat.i(190801);
      $$INSTANCE = new Companion();
      AppMethodBeat.o(190801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.observer.IStorageObserver
 * JD-Core Version:    0.7.0.1
 */