package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.lang.ref.WeakReference;

final class o$2
  implements ap.a
{
  o$2(o paramo) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(34711);
    this.Anv.Ann += 1;
    ab.v("MicroMsg.NetWarnView", "timer fired, percent:%d", new Object[] { Integer.valueOf(this.Anv.Ann) });
    if (this.Anv.Ann > 99)
    {
      AppMethodBeat.o(34711);
      return false;
    }
    if (this.Anv.tng == 1) {
      this.Anv.gpL.setText(((Context)this.Anv.vUD.get()).getResources().getString(2131301787, new Object[] { Integer.valueOf(this.Anv.Ann) }));
    }
    AppMethodBeat.o(34711);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o.2
 * JD-Core Version:    0.7.0.1
 */