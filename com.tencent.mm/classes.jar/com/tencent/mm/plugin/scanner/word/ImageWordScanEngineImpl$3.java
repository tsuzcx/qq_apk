package com.tencent.mm.plugin.scanner.word;

import android.arch.lifecycle.MutableLiveData;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageWordScanEngineImpl$3
  implements Runnable
{
  ImageWordScanEngineImpl$3(ImageWordScanEngineImpl paramImageWordScanEngineImpl, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(138720);
    ImageWordScanEngineImpl.b(this.qDU).setValue(new Pair(this.qDV, Integer.valueOf(this.fMh)));
    AppMethodBeat.o(138720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl.3
 * JD-Core Version:    0.7.0.1
 */