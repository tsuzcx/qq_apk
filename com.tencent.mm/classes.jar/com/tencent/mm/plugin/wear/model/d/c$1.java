package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$1
  implements ap.a
{
  c$1(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26378);
    long l1 = e.cM(this.uHC.filename);
    long l2 = l1 - this.uHC.uHz;
    ab.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { this.uHC.filename, Long.valueOf(l1), Integer.valueOf(this.uHC.uHz), Boolean.valueOf(this.uHC.fZu), Long.valueOf(l2) });
    if ((l2 < 3300L) && (!this.uHC.fZu))
    {
      AppMethodBeat.o(26378);
      return true;
    }
    if ((this.uHC.fZu) && (l2 <= 0L))
    {
      AppMethodBeat.o(26378);
      return false;
    }
    if (this.uHC.doScene(this.uHC.dispatcher(), this.uHC.callback) == -1) {
      this.uHC.callback.onSceneEnd(3, -1, "doScene failed", this.uHC);
    }
    AppMethodBeat.o(26378);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.c.1
 * JD-Core Version:    0.7.0.1
 */