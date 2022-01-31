package com.tencent.xweb.extension.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class d$12
  implements c.a
{
  d$12(d paramd) {}
  
  public final void aFf()
  {
    AppMethodBeat.i(84586);
    this.BFR.dYI();
    this.BFR.dYJ();
    AppMethodBeat.o(84586);
  }
  
  public final void bE(float paramFloat)
  {
    AppMethodBeat.i(84587);
    double d = d.a(this.BFR) * paramFloat / 100.0D;
    this.BFR.f(d, false);
    d.b(this.BFR).evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[] { Double.valueOf(d) }), new d.12.1(this));
    this.BFR.dYH();
    AppMethodBeat.o(84587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.12
 * JD-Core Version:    0.7.0.1
 */