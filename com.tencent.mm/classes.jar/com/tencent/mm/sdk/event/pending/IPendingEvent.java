package com.tencent.mm.sdk.event.pending;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/event/pending/IPendingEvent;", "", "getKey", "", "mergeEvent", "newEvent", "wechat-sdk_release"})
public abstract interface IPendingEvent
{
  public abstract String getKey();
  
  public abstract IPendingEvent mergeEvent(IPendingEvent paramIPendingEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.event.pending.IPendingEvent
 * JD-Core Version:    0.7.0.1
 */