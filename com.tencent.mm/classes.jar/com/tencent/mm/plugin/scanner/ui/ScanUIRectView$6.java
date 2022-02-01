package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;

final class ScanUIRectView$6
  implements b.a
{
  ScanUIRectView$6(ScanUIRectView paramScanUIRectView)
  {
    AppMethodBeat.i(161023);
    AppMethodBeat.o(161023);
  }
  
  public final boolean onGetLocation(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(314542);
    Log.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      Log.i("MicroMsg.ScanUIRectView", "check permission not passed!");
      if ((!ScanUIRectView.y(this.Pcg)) && (!d.bJm()))
      {
        ScanUIRectView.z(this.Pcg);
        k.a(this.Pcg.getContext(), this.Pcg.getContext().getString(l.i.gps_disable_tip), this.Pcg.getContext().getString(l.i.app_tip), this.Pcg.getContext().getString(l.i.jump_to_settings), this.Pcg.getContext().getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(314968);
            d.dP(ScanUIRectView.6.this.Pcg.getContext());
            AppMethodBeat.o(314968);
          }
        }, null);
      }
      AppMethodBeat.o(314542);
      return true;
    }
    if (ScanUIRectView.A(this.Pcg))
    {
      Log.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
      AppMethodBeat.o(314542);
      return false;
    }
    this.Pcg.dSg();
    ScanUIRectView.B(this.Pcg);
    n.a(2012, paramFloat1, paramFloat2, (int)paramDouble2);
    if (ScanUIRectView.m(this.Pcg) != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putFloat("result_lbs_latitude", paramFloat2);
      localBundle.putFloat("result_lbs_longitude", paramFloat1);
      localBundle.putInt("result_lbs_accuracy", (int)paramDouble2);
      localBundle.putInt("result_lbs_source", paramInt);
      ScanUIRectView.m(this.Pcg).e(ScanUIRectView.l(this.Pcg), localBundle);
    }
    AppMethodBeat.o(314542);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.6
 * JD-Core Version:    0.7.0.1
 */