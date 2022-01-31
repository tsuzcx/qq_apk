package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ab;

final class a$7$1
  implements Runnable
{
  a$7$1(a.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(91398);
    if (this.uMg.uMe.equals(a.m(this.uMg.uLR)))
    {
      ab.i("FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { this.uMg.uMe });
      a.b(this.uMg.uLR, null);
      a.c(this.uMg.uLR).a(this.uMg.uMe, false, "timeout", this.uMg.hoG);
    }
    AppMethodBeat.o(91398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.7.1
 * JD-Core Version:    0.7.0.1
 */