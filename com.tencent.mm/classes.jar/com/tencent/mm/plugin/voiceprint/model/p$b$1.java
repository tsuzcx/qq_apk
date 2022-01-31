package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class p$b$1
  extends ak
{
  p$b$1(p.b paramb, p paramp) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(26123);
    if (p.b(this.trJ.trH) <= 0)
    {
      AppMethodBeat.o(26123);
      return;
    }
    p.c(this.trJ.trH);
    AppMethodBeat.o(26123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p.b.1
 * JD-Core Version:    0.7.0.1
 */