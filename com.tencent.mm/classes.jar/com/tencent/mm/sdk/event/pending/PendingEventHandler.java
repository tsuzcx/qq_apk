package com.tencent.mm.sdk.event.pending;

import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/event/pending/PendingEventHandler;", "T", "Lcom/tencent/mm/sdk/event/pending/IPendingEvent;", "", "handleEvent", "", "eventList", "", "wechat-sdk_release"})
public abstract interface PendingEventHandler<T extends IPendingEvent>
{
  public abstract void handleEvent(List<? extends T> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.event.pending.PendingEventHandler
 * JD-Core Version:    0.7.0.1
 */