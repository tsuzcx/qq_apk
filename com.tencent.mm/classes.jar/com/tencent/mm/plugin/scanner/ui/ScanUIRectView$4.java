package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;

final class ScanUIRectView$4
  implements b.a
{
  ScanUIRectView$4(ScanUIRectView paramScanUIRectView) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(161020);
    ac.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      ac.i("MicroMsg.ScanUIRectView", "check permission not passed!");
      if ((!ScanUIRectView.s(this.xfW)) && (!d.aEM()))
      {
        ScanUIRectView.t(this.xfW);
        h.a(this.xfW.getContext(), this.xfW.getContext().getString(2131760082), this.xfW.getContext().getString(2131755906), this.xfW.getContext().getString(2131760598), this.xfW.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(161019);
            d.cE(ScanUIRectView.4.this.xfW.getContext());
            AppMethodBeat.o(161019);
          }
        }, null);
      }
      AppMethodBeat.o(161020);
      return true;
    }
    if (ScanUIRectView.u(this.xfW))
    {
      ac.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
      AppMethodBeat.o(161020);
      return false;
    }
    this.xfW.cqU();
    ScanUIRectView.v(this.xfW);
    o.a(2012, paramFloat1, paramFloat2, (int)paramDouble2);
    if (ScanUIRectView.m(this.xfW) != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putFloat("result_lbs_latitude", paramFloat2);
      localBundle.putFloat("result_lbs_longitude", paramFloat1);
      localBundle.putInt("result_lbs_accuracy", (int)paramDouble2);
      localBundle.putInt("result_lbs_source", paramInt);
      ScanUIRectView.m(this.xfW).e(ScanUIRectView.l(this.xfW), localBundle);
    }
    AppMethodBeat.o(161020);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.4
 * JD-Core Version:    0.7.0.1
 */