package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements View.OnClickListener
{
  c$2(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49228);
    ab.d("MicroMsg.OfflinePopupWindow", "on click know");
    this.AYy.AYw.setVisibility(8);
    paramView = new cn();
    paramView.cqb.cqc = 1;
    a.ymk.l(paramView);
    AppMethodBeat.o(49228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.2
 * JD-Core Version:    0.7.0.1
 */