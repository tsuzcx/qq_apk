package com.tencent.mm.sdk.event.pending;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/event/pending/PendingEventHandler;", "T", "Lcom/tencent/mm/sdk/event/pending/IPendingEvent;", "", "handleEvent", "", "eventList", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface PendingEventHandler<T extends IPendingEvent>
{
  public abstract void handleEvent(List<? extends T> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.event.pending.PendingEventHandler
 * JD-Core Version:    0.7.0.1
 */