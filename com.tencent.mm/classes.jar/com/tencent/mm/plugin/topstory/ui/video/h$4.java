package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e.b;

final class h$4
  implements e.b
{
  h$4(h paramh) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(126075);
    if (h.a(this.MZf))
    {
      this.MZf.MZd.gqC().fLJ();
      h.b(this.MZf);
    }
    this.MZf.MZd.gqJ();
    AppMethodBeat.o(126075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.4
 * JD-Core Version:    0.7.0.1
 */