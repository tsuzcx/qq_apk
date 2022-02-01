package com.tencent.mm.plugin.soter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.lp;
import com.tencent.mm.sdk.event.IListener;

public class GetSupportSoterEventListener
  extends IListener<lp>
{
  public GetSupportSoterEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161755);
    this.__eventId = lp.class.getName().hashCode();
    AppMethodBeat.o(161755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.model.GetSupportSoterEventListener
 * JD-Core Version:    0.7.0.1
 */