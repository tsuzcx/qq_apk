package com.tencent.mm.plugin.scanner.word;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.worddetect.WordDetectNative.WordDetectDetailResult;
import com.tencent.worddetect.a;
import java.util.concurrent.ConcurrentHashMap;

final class ImageWordScanDetailEngine$2
  implements Runnable
{
  ImageWordScanDetailEngine$2(ImageWordScanDetailEngine paramImageWordScanDetailEngine, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(194814);
    WordDetectNative.WordDetectDetailResult localWordDetectDetailResult;
    if (ImageWordScanDetailEngine.a(this.CVA).contains(this.CVB)) {
      localWordDetectDetailResult = (WordDetectNative.WordDetectDetailResult)ImageWordScanDetailEngine.a(this.CVA).get(this.CVB);
    }
    for (;;)
    {
      ImageWordScanDetailEngine.a(this.CVA, this.CVB, new b(localWordDetectDetailResult));
      AppMethodBeat.o(194814);
      return;
      localWordDetectDetailResult = a.da(ImageWordScanDetailEngine.b(this.CVA), this.CVB);
      ImageWordScanDetailEngine.a(this.CVA).put(this.CVB, localWordDetectDetailResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine.2
 * JD-Core Version:    0.7.0.1
 */