package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;

final class SnsLabelUI$10
  implements Runnable
{
  SnsLabelUI$10(SnsLabelUI paramSnsLabelUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(39020);
    SnsLabelUI.a(this.rSh, (ArrayList)a.bKV().bKQ());
    if (SnsLabelUI.k(this.rSh) == null) {
      SnsLabelUI.a(this.rSh, new ArrayList());
    }
    if (!bo.isNullOrNil(this.rSk)) {
      if (!SnsLabelUI.k(this.rSh).contains(this.rSk)) {
        SnsLabelUI.k(this.rSh).add(this.rSk);
      }
    }
    for (int i = SnsLabelUI.k(this.rSh).indexOf(this.rSk);; i = -1)
    {
      SnsLabelUI.a(this.rSh).S(SnsLabelUI.k(this.rSh));
      SnsLabelUI.l(this.rSh);
      SnsLabelUI.a(this.rSh).rSq = SnsLabelUI.m(this.rSh);
      if ((!bo.isNullOrNil(this.rSk)) && (i != -1))
      {
        if (SnsLabelUI.m(this.rSh) != 2) {
          break label246;
        }
        SnsLabelUI.a(this.rSh).rSs.add(this.rSk);
        SnsLabelUI.a(this.rSh).rSu.clear();
      }
      for (;;)
      {
        SnsLabelUI.a(this.rSh).notifyDataSetChanged();
        SnsLabelUI.g(this.rSh).expandGroup(SnsLabelUI.m(this.rSh));
        SnsLabelUI.n(this.rSh);
        AppMethodBeat.o(39020);
        return;
        label246:
        if (SnsLabelUI.m(this.rSh) == 3)
        {
          SnsLabelUI.a(this.rSh).rSt.add(this.rSk);
          SnsLabelUI.a(this.rSh).rSv.clear();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.10
 * JD-Core Version:    0.7.0.1
 */