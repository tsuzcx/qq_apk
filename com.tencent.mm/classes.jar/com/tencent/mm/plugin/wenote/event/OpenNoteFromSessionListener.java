package com.tencent.mm.plugin.wenote.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.rk;
import com.tencent.mm.sdk.event.IListener;

public class OpenNoteFromSessionListener
  extends IListener<rk>
{
  public OpenNoteFromSessionListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161477);
    this.__eventId = rk.class.getName().hashCode();
    AppMethodBeat.o(161477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.event.OpenNoteFromSessionListener
 * JD-Core Version:    0.7.0.1
 */