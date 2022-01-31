package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsLabelUI$6
  implements ExpandableListView.OnChildClickListener
{
  SnsLabelUI$6(SnsLabelUI paramSnsLabelUI) {}
  
  public final boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(39016);
    if (paramInt2 == ap.rSm)
    {
      SnsLabelUI.a(this.rSh, paramInt1);
      SnsLabelUI.f(this.rSh);
    }
    for (;;)
    {
      AppMethodBeat.o(39016);
      return false;
      if (paramInt2 == ap.rSl)
      {
        SnsLabelUI.a(this.rSh, paramInt1);
        SnsLabelUI.h(this.rSh);
      }
      else
      {
        paramExpandableListView = (String)SnsLabelUI.a(this.rSh).getChild(paramInt1, paramInt2 - ap.rSn);
        SnsLabelUI.a(this.rSh);
        ap.acg(paramExpandableListView);
        if (paramInt1 == 2) {
          SnsLabelUI.a(this.rSh, 1, SnsLabelUI.a(this.rSh).rSs, paramExpandableListView, paramView);
        } else if (paramInt1 == 3) {
          SnsLabelUI.a(this.rSh, 2, SnsLabelUI.a(this.rSh).rSt, paramExpandableListView, paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.6
 * JD-Core Version:    0.7.0.1
 */