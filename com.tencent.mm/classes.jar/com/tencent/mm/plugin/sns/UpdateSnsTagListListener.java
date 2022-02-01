package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abx;
import com.tencent.mm.sdk.event.IListener;

public class UpdateSnsTagListListener
  extends IListener<abx>
{
  public UpdateSnsTagListListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160641);
    this.__eventId = abx.class.getName().hashCode();
    AppMethodBeat.o(160641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.UpdateSnsTagListListener
 * JD-Core Version:    0.7.0.1
 */