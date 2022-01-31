package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class NearbySayHiListUI$1
  implements View.OnClickListener
{
  NearbySayHiListUI$1(NearbySayHiListUI paramNearbySayHiListUI, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55493);
    NearbySayHiListUI.a(this.pdR, NearbySayHiListUI.a(this.pdR) + 8);
    ab.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(this.pdR));
    paramView = NearbySayHiListUI.b(this.pdR);
    int i = NearbySayHiListUI.a(this.pdR);
    paramView.bKb();
    paramView.limit = i;
    paramView.Ku();
    if (NearbySayHiListUI.c(this.pdR) <= NearbySayHiListUI.a(this.pdR))
    {
      NearbySayHiListUI.d(this.pdR).removeFooterView(this.pdQ);
      ab.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(this.pdR));
    }
    AppMethodBeat.o(55493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.1
 * JD-Core Version:    0.7.0.1
 */