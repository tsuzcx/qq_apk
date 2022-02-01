package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class b$4
  implements q.f
{
  b$4(b paramb) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(243052);
    paramo.d(0, b.d(this.OUY).getResources().getString(a.i.contact_info_wxpay_hk_notify_bottomsheet_content));
    AppMethodBeat.o(243052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b.4
 * JD-Core Version:    0.7.0.1
 */