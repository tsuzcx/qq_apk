package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class ReadMailUI$11
  implements View.OnClickListener
{
  ReadMailUI$11(ReadMailUI paramReadMailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(123156);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    switch (ReadMailUI.j(this.xhG))
    {
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(123156);
      return;
      ReadMailUI.Np(2);
      if ((!bt.isNullOrNil(ReadMailUI.k(this.xhG))) && (!bt.isNullOrNil(ReadMailUI.l(this.xhG))))
      {
        ReadMailUI.m(this.xhG);
      }
      else
      {
        ReadMailUI.n(this.xhG);
        continue;
        ReadMailUI.Np(1);
        ad.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.o(this.xhG)) });
        continue;
        ReadMailUI.Np(3);
        ReadMailUI.r(this.xhG);
        continue;
        ReadMailUI.Np(4);
        ReadMailUI.s(this.xhG);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.11
 * JD-Core Version:    0.7.0.1
 */