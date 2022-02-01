package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.f.b;

final class h$4
  implements f.b
{
  h$4(h paramh) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(126075);
    if (h.a(this.TLO))
    {
      this.TLO.TLM.hNB().bcl();
      h.b(this.TLO);
    }
    this.TLO.TLM.hNI();
    AppMethodBeat.o(126075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.4
 * JD-Core Version:    0.7.0.1
 */