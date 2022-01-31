package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

public final class b
{
  public volatile al uVg;
  as uVh;
  
  public b(as paramas)
  {
    AppMethodBeat.i(6569);
    this.uVg = new al("WebviewWorkerThread");
    this.uVh = paramas;
    AppMethodBeat.o(6569);
  }
  
  public final al aNS()
  {
    AppMethodBeat.i(6570);
    if (this.uVg == null) {
      this.uVg = new al("WebviewWorkerThread");
    }
    al localal = this.uVg;
    AppMethodBeat.o(6570);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.b
 * JD-Core Version:    0.7.0.1
 */