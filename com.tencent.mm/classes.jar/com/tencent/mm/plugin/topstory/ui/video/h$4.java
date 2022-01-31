package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d.a;

final class h$4
  implements d.a
{
  h$4(h paramh) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(1716);
    if (h.a(this.tio))
    {
      this.tio.tim.cJh().ctY();
      h.b(this.tio);
    }
    this.tio.tim.cJo();
    AppMethodBeat.o(1716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.4
 * JD-Core Version:    0.7.0.1
 */