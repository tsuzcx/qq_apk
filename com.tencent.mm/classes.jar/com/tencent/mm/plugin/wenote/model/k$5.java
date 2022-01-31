package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class k$5
  implements ap.a
{
  k$5(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26668);
    if (k.f(this.vwV) == -1L) {
      k.a(this.vwV, bo.yB());
    }
    long l = bo.av(k.f(this.vwV));
    if ((l >= 3590000L) && (l <= 3600000L))
    {
      if (k.g(this.vwV) != null) {
        break label181;
      }
      k.a(this.vwV, Toast.makeText(ah.getContext(), ah.getContext().getString(2131299677, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
    }
    for (;;)
    {
      k.g(this.vwV).show();
      if (l < 3600000L) {
        break;
      }
      ab.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
      k.h(this.vwV);
      k.i(this.vwV);
      if (k.d(this.vwV) != null) {
        k.d(this.vwV).dhT();
      }
      AppMethodBeat.o(26668);
      return false;
      label181:
      k.g(this.vwV).setText(ah.getContext().getString(2131299677, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
    }
    AppMethodBeat.o(26668);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k.5
 * JD-Core Version:    0.7.0.1
 */