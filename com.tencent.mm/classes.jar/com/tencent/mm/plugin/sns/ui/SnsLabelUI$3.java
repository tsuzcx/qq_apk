package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

final class SnsLabelUI$3
  implements Runnable
{
  SnsLabelUI$3(SnsLabelUI paramSnsLabelUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39013);
    SnsLabelUI.a(this.rSh).rSq = SnsLabelUI.m(this.rSh);
    if (SnsLabelUI.b(this.rSh) != null)
    {
      if (SnsLabelUI.k(this.rSh) == null) {
        SnsLabelUI.a(this.rSh, SnsLabelUI.b(this.rSh));
      }
      for (;;)
      {
        localObject = SnsLabelUI.b(this.rSh).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SnsLabelUI.a(this.rSh);
          ap.acg((String)((Iterator)localObject).next());
        }
        SnsLabelUI.k(this.rSh).addAll(SnsLabelUI.b(this.rSh));
      }
      Object localObject = new HashSet(SnsLabelUI.k(this.rSh));
      SnsLabelUI.k(this.rSh).clear();
      SnsLabelUI.k(this.rSh).addAll((Collection)localObject);
      SnsLabelUI.b(this.rSh).clear();
      SnsLabelUI.s(this.rSh);
      ((HashSet)localObject).clear();
    }
    SnsLabelUI.a(this.rSh).S(SnsLabelUI.k(this.rSh));
    SnsLabelUI.l(this.rSh);
    SnsLabelUI.a(this.rSh).notifyDataSetChanged();
    SnsLabelUI.g(this.rSh).Ro(SnsLabelUI.a(this.rSh).rSq);
    if ((SnsLabelUI.t(this.rSh) != null) && (SnsLabelUI.t(this.rSh).isShowing())) {
      SnsLabelUI.t(this.rSh).dismiss();
    }
    AppMethodBeat.o(39013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.3
 * JD-Core Version:    0.7.0.1
 */