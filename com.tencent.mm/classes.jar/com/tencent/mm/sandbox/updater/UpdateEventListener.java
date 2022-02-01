package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aby;
import com.tencent.mm.sdk.event.IListener;

public class UpdateEventListener
  extends IListener<aby>
{
  public UpdateEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161486);
    this.__eventId = aby.class.getName().hashCode();
    AppMethodBeat.o(161486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdateEventListener
 * JD-Core Version:    0.7.0.1
 */