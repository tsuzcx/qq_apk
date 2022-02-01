package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.zn;
import com.tencent.mm.sdk.event.IListener;

public class SnsfillEventInfoListener
  extends IListener<zn>
{
  public SnsfillEventInfoListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160640);
    this.__eventId = zn.class.getName().hashCode();
    AppMethodBeat.o(160640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.SnsfillEventInfoListener
 * JD-Core Version:    0.7.0.1
 */