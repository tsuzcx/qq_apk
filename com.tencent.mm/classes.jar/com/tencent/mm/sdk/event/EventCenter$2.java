package com.tencent.mm.sdk.event;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

class EventCenter$2
  implements h
{
  EventCenter$2(EventCenter paramEventCenter, IEvent paramIEvent) {}
  
  public String getKey()
  {
    AppMethodBeat.i(125180);
    String str = this.val$event.getClass().getName();
    AppMethodBeat.o(125180);
    return str;
  }
  
  public void run()
  {
    AppMethodBeat.i(125181);
    EventCenter.instance.publish(this.val$event);
    AppMethodBeat.o(125181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EventCenter.2
 * JD-Core Version:    0.7.0.1
 */