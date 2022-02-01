package com.tencent.mm.sdk.event.pending;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/event/pending/IPendingEvent;", "", "getKey", "", "mergeEvent", "newEvent", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface IPendingEvent
{
  public abstract String getKey();
  
  public abstract IPendingEvent mergeEvent(IPendingEvent paramIPendingEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.event.pending.IPendingEvent
 * JD-Core Version:    0.7.0.1
 */