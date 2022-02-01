package com.tencent.mm.plugin.readerapp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.tc;
import com.tencent.mm.sdk.event.IListener;

public class ReaderAppOperationListener
  extends IListener<tc>
{
  public ReaderAppOperationListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161675);
    this.__eventId = tc.class.getName().hashCode();
    AppMethodBeat.o(161675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.model.ReaderAppOperationListener
 * JD-Core Version:    0.7.0.1
 */