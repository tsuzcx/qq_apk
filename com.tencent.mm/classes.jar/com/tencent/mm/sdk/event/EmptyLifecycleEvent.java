package com.tencent.mm.sdk.event;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/event/EmptyLifecycleEvent;", "Lcom/tencent/mm/sdk/event/LifecycleEvent;", "", "()V", "publish", "", "wechat-sdk_release"})
public abstract class EmptyLifecycleEvent
  extends LifecycleEvent<Object>
{
  public final void publish()
  {
    publish(new Object());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EmptyLifecycleEvent
 * JD-Core Version:    0.7.0.1
 */