package com.tencent.mm.plugin.scanner.word;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.worddetect.a;

final class ImageWordScanEngineImpl$2
  implements Runnable
{
  ImageWordScanEngineImpl$2(ImageWordScanEngineImpl paramImageWordScanEngineImpl, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(138719);
    int i = a.ch(ImageWordScanEngineImpl.a(this.qDU), this.qDV);
    ImageWordScanEngineImpl.a(this.qDU, this.qDV, i);
    AppMethodBeat.o(138719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl.2
 * JD-Core Version:    0.7.0.1
 */