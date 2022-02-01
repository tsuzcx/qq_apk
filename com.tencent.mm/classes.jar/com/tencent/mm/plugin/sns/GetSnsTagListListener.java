package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ly;
import com.tencent.mm.sdk.event.IListener;

public class GetSnsTagListListener
  extends IListener<ly>
{
  public GetSnsTagListListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160633);
    this.__eventId = ly.class.getName().hashCode();
    AppMethodBeat.o(160633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.GetSnsTagListListener
 * JD-Core Version:    0.7.0.1
 */