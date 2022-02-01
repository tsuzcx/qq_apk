package com.tencent.mm.plugin.readerapp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.vp;
import com.tencent.mm.sdk.event.IListener;

class RollbackTencentNewsListener
  extends IListener<vp>
{
  public RollbackTencentNewsListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161676);
    this.__eventId = vp.class.getName().hashCode();
    AppMethodBeat.o(161676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.model.RollbackTencentNewsListener
 * JD-Core Version:    0.7.0.1
 */