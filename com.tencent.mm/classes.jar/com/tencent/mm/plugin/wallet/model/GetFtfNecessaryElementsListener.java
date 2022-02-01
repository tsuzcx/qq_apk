package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.lj;
import com.tencent.mm.sdk.event.IListener;

public class GetFtfNecessaryElementsListener
  extends IListener<lj>
{
  public GetFtfNecessaryElementsListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160861);
    this.__eventId = lj.class.getName().hashCode();
    AppMethodBeat.o(160861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.GetFtfNecessaryElementsListener
 * JD-Core Version:    0.7.0.1
 */