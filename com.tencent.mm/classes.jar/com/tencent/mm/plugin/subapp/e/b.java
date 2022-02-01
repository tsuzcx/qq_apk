package com.tencent.mm.plugin.subapp.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(29004);
    ac.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, result: %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    h.wUl.f(14220, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2 + paramInt3), Integer.valueOf(paramInt4), paramString });
    AppMethodBeat.o(29004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.e.b
 * JD-Core Version:    0.7.0.1
 */