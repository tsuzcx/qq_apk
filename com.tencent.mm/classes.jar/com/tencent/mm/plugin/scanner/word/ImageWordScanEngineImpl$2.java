package com.tencent.mm.plugin.scanner.word;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.worddetect.a;

final class ImageWordScanEngineImpl$2
  implements Runnable
{
  ImageWordScanEngineImpl$2(ImageWordScanEngineImpl paramImageWordScanEngineImpl, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(91126);
    int i = a.cZ(ImageWordScanEngineImpl.a(this.CVD), this.CVB);
    ImageWordScanEngineImpl.a(this.CVD, this.CVB, i);
    AppMethodBeat.o(91126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl.2
 * JD-Core Version:    0.7.0.1
 */