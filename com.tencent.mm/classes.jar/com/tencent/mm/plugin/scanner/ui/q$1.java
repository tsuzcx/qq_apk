package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class q$1
  implements b.a
{
  q$1(q paramq) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(81239);
    ab.i("MicroMsg.scanner.ScanModeStreetView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      ab.i("MicroMsg.scanner.ScanModeStreetView", "check permission not passed!");
      if ((!q.a(this.qAv)) && (!d.agR()) && (this.qAv.qzg != null))
      {
        q.b(this.qAv);
        h.a(this.qAv.qzg.getContext(), this.qAv.qzg.getContext().getString(2131300538), this.qAv.qzg.getContext().getString(2131297087), this.qAv.qzg.getContext().getString(2131300996), this.qAv.qzg.getContext().getString(2131296888), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(81238);
            d.cc(q.1.this.qAv.qzg.getContext());
            AppMethodBeat.o(81238);
          }
        }, null);
      }
      AppMethodBeat.o(81239);
      return true;
    }
    q.a(this.qAv, paramFloat2);
    q.b(this.qAv, paramFloat1);
    q.a(this.qAv, (int)paramDouble2);
    q.a(this.qAv, "");
    q.b(this.qAv, "");
    q.b(this.qAv, paramInt);
    q.c(this.qAv);
    q.d(this.qAv);
    if (!q.e(this.qAv))
    {
      q.f(this.qAv);
      o.a(2012, paramFloat1, paramFloat2, (int)paramDouble2);
    }
    AppMethodBeat.o(81239);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.q.1
 * JD-Core Version:    0.7.0.1
 */