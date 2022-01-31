package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class p$1
  implements Runnable
{
  public p$1(p paramp, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(26419);
    p.a(this.uHR, new c(p.access$100(), this.euc, p.a(this.uHR)));
    aw.Rc().a(349, this.uHR);
    ab.i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
    AppMethodBeat.o(26419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.p.1
 * JD-Core Version:    0.7.0.1
 */