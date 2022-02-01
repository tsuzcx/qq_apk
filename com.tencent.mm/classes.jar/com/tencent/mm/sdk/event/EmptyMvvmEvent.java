package com.tencent.mm.sdk.event;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/event/EmptyMvvmEvent;", "Lcom/tencent/mm/sdk/event/BaseMvvmEvent;", "", "()V", "publish", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class EmptyMvvmEvent
  extends BaseMvvmEvent<Object>
{
  public final void publish()
  {
    publish(new Object());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EmptyMvvmEvent
 * JD-Core Version:    0.7.0.1
 */