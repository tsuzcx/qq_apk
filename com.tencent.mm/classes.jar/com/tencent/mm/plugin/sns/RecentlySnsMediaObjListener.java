package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.tl;
import com.tencent.mm.sdk.event.IListener;

public class RecentlySnsMediaObjListener
  extends IListener<tl>
{
  public RecentlySnsMediaObjListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160637);
    this.__eventId = tl.class.getName().hashCode();
    AppMethodBeat.o(160637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.RecentlySnsMediaObjListener
 * JD-Core Version:    0.7.0.1
 */