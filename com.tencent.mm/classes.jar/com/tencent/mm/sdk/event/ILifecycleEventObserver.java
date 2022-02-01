package com.tencent.mm.sdk.event;

import com.tencent.mm.sdk.observer.ILifecycleObserver;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/event/ILifecycleEventObserver;", "D", "Lcom/tencent/mm/sdk/observer/ILifecycleObserver;", "()V", "onChanged", "", "data", "(Ljava/lang/Object;)V", "onEventHappen", "wechat-sdk_release"})
public abstract class ILifecycleEventObserver<D>
  implements ILifecycleObserver<D>
{
  public void onChanged(D paramD)
  {
    onEventHappen(paramD);
  }
  
  public abstract void onEventHappen(D paramD);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.event.ILifecycleEventObserver
 * JD-Core Version:    0.7.0.1
 */