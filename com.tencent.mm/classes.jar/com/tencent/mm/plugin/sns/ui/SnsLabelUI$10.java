package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;

final class SnsLabelUI$10
  implements Runnable
{
  SnsLabelUI$10(SnsLabelUI paramSnsLabelUI, String paramString) {}
  
  public final void run()
  {
    SnsLabelUI.a(this.oZN, (ArrayList)a.bdA().bdv());
    if (SnsLabelUI.j(this.oZN) == null) {
      SnsLabelUI.a(this.oZN, new ArrayList());
    }
    if (!bk.bl(this.oZQ)) {
      if (!SnsLabelUI.j(this.oZN).contains(this.oZQ)) {
        SnsLabelUI.j(this.oZN).add(this.oZQ);
      }
    }
    for (int i = SnsLabelUI.j(this.oZN).indexOf(this.oZQ);; i = -1)
    {
      SnsLabelUI.a(this.oZN).Q(SnsLabelUI.j(this.oZN));
      SnsLabelUI.k(this.oZN);
      SnsLabelUI.a(this.oZN).oZT = SnsLabelUI.l(this.oZN);
      if ((!bk.bl(this.oZQ)) && (i != -1))
      {
        if (SnsLabelUI.l(this.oZN) != 2) {
          break label236;
        }
        SnsLabelUI.a(this.oZN).oZV.add(this.oZQ);
        SnsLabelUI.a(this.oZN).oZX.clear();
      }
      for (;;)
      {
        SnsLabelUI.a(this.oZN).notifyDataSetChanged();
        SnsLabelUI.g(this.oZN).expandGroup(SnsLabelUI.l(this.oZN));
        SnsLabelUI.m(this.oZN);
        return;
        label236:
        if (SnsLabelUI.l(this.oZN) == 3)
        {
          SnsLabelUI.a(this.oZN).oZW.add(this.oZQ);
          SnsLabelUI.a(this.oZN).oZY.clear();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.10
 * JD-Core Version:    0.7.0.1
 */