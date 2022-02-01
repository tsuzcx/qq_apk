package com.tencent.mm.plugin.subapp.transformtext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.hb;
import com.tencent.mm.sdk.event.IListener;

public class VoiceTransformTextResultEventListener
  extends IListener<hb>
{
  public VoiceTransformTextResultEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161445);
    this.__eventId = hb.class.getName().hashCode();
    AppMethodBeat.o(161445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.transformtext.VoiceTransformTextResultEventListener
 * JD-Core Version:    0.7.0.1
 */