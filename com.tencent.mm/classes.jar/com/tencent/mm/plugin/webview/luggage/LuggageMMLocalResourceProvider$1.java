package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import java.io.PipedOutputStream;

final class LuggageMMLocalResourceProvider$1
  implements Runnable
{
  LuggageMMLocalResourceProvider$1(LuggageMMLocalResourceProvider paramLuggageMMLocalResourceProvider, LuggageMMLocalResourceProvider.GetLocalResourceInfoTask paramGetLocalResourceInfoTask, PipedOutputStream paramPipedOutputStream) {}
  
  public final void run()
  {
    AppMethodBeat.i(5980);
    d.ysm.execute(new LuggageMMLocalResourceProvider.1.1(this));
    AppMethodBeat.o(5980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider.1
 * JD-Core Version:    0.7.0.1
 */