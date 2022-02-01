package com.tencent.mm.plugin.shake.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aam;
import com.tencent.mm.sdk.event.IListener;

public class TVOperationListener
  extends IListener<aam>
{
  public TVOperationListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161434);
    this.__eventId = aam.class.getName().hashCode();
    AppMethodBeat.o(161434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.model.TVOperationListener
 * JD-Core Version:    0.7.0.1
 */