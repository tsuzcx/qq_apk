package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class as$a
{
  public long eaj;
  public String fjC;
  public long iHh;
  public long lastResumeTime;
  public int sbd;
  public int scene;
  public int uWM;
  
  public as$a()
  {
    AppMethodBeat.i(6759);
    this.lastResumeTime = -1L;
    this.eaj = System.currentTimeMillis();
    this.uWM = a.gx(ah.getContext());
    this.sbd = a.gx(ah.getContext());
    AppMethodBeat.o(6759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.as.a
 * JD-Core Version:    0.7.0.1
 */