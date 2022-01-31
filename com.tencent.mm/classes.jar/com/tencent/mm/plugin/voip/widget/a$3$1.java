package com.tencent.mm.plugin.voip.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(5139);
    if ((this.tJr.tJq.tCc != null) && (this.tJr.tJq.tCc.get() != null)) {
      ab.i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent ret[%b, %b, %b]", new Object[] { Boolean.valueOf(((c)this.tJr.tJq.tCc.get()).cMQ()), Boolean.valueOf(((c)this.tJr.tJq.tCc.get()).cMP()), Boolean.valueOf(((c)this.tJr.tJq.tCc.get()).cMI()) });
    }
    AppMethodBeat.o(5139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a.3.1
 * JD-Core Version:    0.7.0.1
 */