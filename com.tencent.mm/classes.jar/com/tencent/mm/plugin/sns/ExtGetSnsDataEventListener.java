package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.gn;
import com.tencent.mm.sdk.event.IListener;

public class ExtGetSnsDataEventListener
  extends IListener<gn>
{
  public ExtGetSnsDataEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160630);
    this.__eventId = gn.class.getName().hashCode();
    AppMethodBeat.o(160630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ExtGetSnsDataEventListener
 * JD-Core Version:    0.7.0.1
 */