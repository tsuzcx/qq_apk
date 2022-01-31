package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class k$1
  implements j.a
{
  public k$1(k paramk) {}
  
  public final void onError()
  {
    AppMethodBeat.i(26664);
    ab.e("MicroMsg.WNNoteVoiceLogic", "SpeexRecorder,Record Failed");
    k.a(this.vwV).stopTimer();
    AppMethodBeat.o(26664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k.1
 * JD-Core Version:    0.7.0.1
 */