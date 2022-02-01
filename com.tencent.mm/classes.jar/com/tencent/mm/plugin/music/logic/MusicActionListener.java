package com.tencent.mm.plugin.music.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ov;
import com.tencent.mm.sdk.event.IListener;

public class MusicActionListener
  extends IListener<ov>
{
  public MusicActionListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161224);
    this.__eventId = ov.class.getName().hashCode();
    AppMethodBeat.o(161224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.logic.MusicActionListener
 * JD-Core Version:    0.7.0.1
 */