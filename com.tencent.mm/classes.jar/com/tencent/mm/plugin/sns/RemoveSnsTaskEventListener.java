package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ue;
import com.tencent.mm.sdk.event.IListener;

public class RemoveSnsTaskEventListener
  extends IListener<ue>
{
  public RemoveSnsTaskEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160638);
    this.__eventId = ue.class.getName().hashCode();
    AppMethodBeat.o(160638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.RemoveSnsTaskEventListener
 * JD-Core Version:    0.7.0.1
 */