package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.zd;
import com.tencent.mm.sdk.event.IListener;

public class SnsSyncListener
  extends IListener<zd>
{
  public SnsSyncListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160639);
    this.__eventId = zd.class.getName().hashCode();
    AppMethodBeat.o(160639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.SnsSyncListener
 * JD-Core Version:    0.7.0.1
 */