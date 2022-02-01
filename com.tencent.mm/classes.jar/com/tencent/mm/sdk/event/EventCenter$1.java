package com.tencent.mm.sdk.event;

import com.tencent.matrix.trace.core.AppMethodBeat;

class EventCenter$1
  implements Runnable
{
  EventCenter$1(EventCenter paramEventCenter, IEvent paramIEvent) {}
  
  public void run()
  {
    AppMethodBeat.i(125179);
    EventCenter.instance.publish(this.val$event);
    AppMethodBeat.o(125179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EventCenter.1
 * JD-Core Version:    0.7.0.1
 */