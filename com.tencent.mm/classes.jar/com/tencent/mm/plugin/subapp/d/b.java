package com.tencent.mm.plugin.subapp.d;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, result: %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    h.nFQ.f(14220, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2 + paramInt3), Integer.valueOf(paramInt4), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.b
 * JD-Core Version:    0.7.0.1
 */