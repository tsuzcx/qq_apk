package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class k$5
  implements am.a
{
  k$5(k paramk) {}
  
  public final boolean tC()
  {
    if (k.f(this.rGm) == -1L) {
      k.a(this.rGm, bk.UZ());
    }
    long l = bk.cp(k.f(this.rGm));
    if ((l >= 3590000L) && (l <= 3600000L))
    {
      if (k.g(this.rGm) != null) {
        break label170;
      }
      k.a(this.rGm, Toast.makeText(ae.getContext(), ae.getContext().getString(R.l.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
    }
    for (;;)
    {
      k.g(this.rGm).show();
      if (l < 3600000L) {
        break;
      }
      y.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
      k.h(this.rGm);
      k.i(this.rGm);
      if (k.d(this.rGm) != null) {
        k.d(this.rGm).chD();
      }
      return false;
      label170:
      k.g(this.rGm).setText(ae.getContext().getString(R.l.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k.5
 * JD-Core Version:    0.7.0.1
 */