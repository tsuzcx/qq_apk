package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class k$2
  implements j.a
{
  public k$2(k paramk) {}
  
  public final void onError()
  {
    AppMethodBeat.i(26665);
    ab.e("MicroMsg.WNNoteVoiceLogic", "SimpleVoiceRecorder,Record Failed");
    k.a(this.vwV).stopTimer();
    AppMethodBeat.o(26665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k.2
 * JD-Core Version:    0.7.0.1
 */