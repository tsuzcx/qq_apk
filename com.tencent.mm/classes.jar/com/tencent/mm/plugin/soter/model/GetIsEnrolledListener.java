package com.tencent.mm.plugin.soter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ln;
import com.tencent.mm.sdk.event.IListener;

public class GetIsEnrolledListener
  extends IListener<ln>
{
  public GetIsEnrolledListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161754);
    this.__eventId = ln.class.getName().hashCode();
    AppMethodBeat.o(161754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.model.GetIsEnrolledListener
 * JD-Core Version:    0.7.0.1
 */