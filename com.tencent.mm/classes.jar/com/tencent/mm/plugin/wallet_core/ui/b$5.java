package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.wallet_core.ui.g;

final class b$5
  implements q.g
{
  b$5(b paramb) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(275075);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "click bottomsheet ");
    h.aHH();
    paramMenuItem = (String)h.aHG().aHp().get(ar.a.VDd, null);
    if (!Util.isNullOrNil(paramMenuItem))
    {
      Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "jump to h5:%s ", new Object[] { paramMenuItem });
      g.a(b.d(this.OUY), paramMenuItem, false, 4);
      AppMethodBeat.o(275075);
      return;
    }
    b.e(this.OUY);
    AppMethodBeat.o(275075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b.5
 * JD-Core Version:    0.7.0.1
 */