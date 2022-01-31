package com.tencent.mm.plugin.sns.ui;

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
    SnsLabelUI.a(this.oZN).oZT = SnsLabelUI.l(this.oZN);
    if (SnsLabelUI.j(this.oZN) == null) {
      SnsLabelUI.a(this.oZN, SnsLabelUI.b(this.oZN));
    }
    while (SnsLabelUI.b(this.oZN) != null)
    {
      localObject = SnsLabelUI.b(this.oZN).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SnsLabelUI.a(this.oZN);
        ap.Pm((String)((Iterator)localObject).next());
      }
      SnsLabelUI.j(this.oZN).addAll(SnsLabelUI.b(this.oZN));
    }
    Object localObject = new HashSet(SnsLabelUI.j(this.oZN));
    SnsLabelUI.j(this.oZN).clear();
    SnsLabelUI.j(this.oZN).addAll((Collection)localObject);
    SnsLabelUI.a(this.oZN).Q(SnsLabelUI.j(this.oZN));
    SnsLabelUI.k(this.oZN);
    SnsLabelUI.a(this.oZN).notifyDataSetChanged();
    SnsLabelUI.g(this.oZN).Iw(SnsLabelUI.a(this.oZN).oZT);
    if (SnsLabelUI.b(this.oZN) != null) {
      SnsLabelUI.b(this.oZN).clear();
    }
    SnsLabelUI.q(this.oZN);
    ((HashSet)localObject).clear();
    if ((SnsLabelUI.r(this.oZN) != null) && (SnsLabelUI.r(this.oZN).isShowing())) {
      SnsLabelUI.r(this.oZN).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.3
 * JD-Core Version:    0.7.0.1
 */