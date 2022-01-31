package com.tencent.mm.plugin.voip.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(5138);
    ab.i("MicroMsg.Voip.TalkingSmallView", "on mShowLocalView");
    if (a.a(this.tJq).tHl) {
      a.b(this.tJq).nd(false);
    }
    a.a(this.tJq).setVisibility(0);
    AppMethodBeat.o(5138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a.2
 * JD-Core Version:    0.7.0.1
 */