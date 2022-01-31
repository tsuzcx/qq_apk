package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

final class SnsLabelUI$6
  implements ExpandableListView.OnChildClickListener
{
  SnsLabelUI$6(SnsLabelUI paramSnsLabelUI) {}
  
  public final boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt2 == SnsLabelUI.a(this.oZN).getChildrenCount(paramInt1) - 1)
    {
      SnsLabelUI.a(this.oZN, paramInt1);
      SnsLabelUI.f(this.oZN);
    }
    for (;;)
    {
      return false;
      paramExpandableListView = (String)SnsLabelUI.a(this.oZN).getChild(paramInt1, paramInt2);
      SnsLabelUI.a(this.oZN);
      ap.Pm(paramExpandableListView);
      if (paramInt1 == 2) {
        SnsLabelUI.a(this.oZN, 1, SnsLabelUI.a(this.oZN).oZV, paramExpandableListView, paramView);
      } else if (paramInt1 == 3) {
        SnsLabelUI.a(this.oZN, 2, SnsLabelUI.a(this.oZN).oZW, paramExpandableListView, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.6
 * JD-Core Version:    0.7.0.1
 */