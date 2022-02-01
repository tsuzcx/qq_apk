package com.tencent.mm.plugin.record.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.sdk.event.IListener;

public class RecordOperationListener
  extends IListener<tr>
{
  public RecordOperationListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160914);
    this.__eventId = tr.class.getName().hashCode();
    AppMethodBeat.o(160914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.RecordOperationListener
 * JD-Core Version:    0.7.0.1
 */