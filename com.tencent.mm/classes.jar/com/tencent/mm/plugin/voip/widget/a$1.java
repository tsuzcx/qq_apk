package com.tencent.mm.plugin.voip.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(5137);
    ab.i("MicroMsg.Voip.TalkingSmallView", "on mDismissLocalView");
    if (a.a(this.tJq).tHl)
    {
      a.b(this.tJq).nd(true);
      AppMethodBeat.o(5137);
      return;
    }
    a.a(this.tJq).setVisibility(4);
    AppMethodBeat.o(5137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a.1
 * JD-Core Version:    0.7.0.1
 */