package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aj
  implements ai
{
  public volatile boolean cyH;
  public volatile boolean ftW;
  public volatile boolean hyp;
  public volatile boolean hyq;
  aj.a vLQ;
  
  public aj(aj.a parama)
  {
    this.vLQ = parama;
  }
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(79395);
    this.ftW = true;
    this.hyp = paramBoolean;
    if ((this.hyq) && (this.vLQ != null)) {
      this.vLQ.r(this.cyH, paramBoolean);
    }
    AppMethodBeat.o(79395);
  }
  
  public final void ea(boolean paramBoolean)
  {
    AppMethodBeat.i(79396);
    this.cyH = paramBoolean;
    this.hyq = true;
    if ((this.ftW) && (this.vLQ != null)) {
      this.vLQ.r(paramBoolean, this.hyp);
    }
    AppMethodBeat.o(79396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */