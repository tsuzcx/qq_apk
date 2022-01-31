package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class ActivityTestMultilineEllipse$1
  implements View.OnClickListener
{
  ActivityTestMultilineEllipse$1(ActivityTestMultilineEllipse paramActivityTestMultilineEllipse, QTextView paramQTextView) {}
  
  public final void onClick(View paramView)
  {
    if (this.oLY.getIsExpanded())
    {
      paramView = this.oLY;
      paramView.oSG = false;
      paramView.requestLayout();
      paramView.invalidate();
      return;
    }
    paramView = this.oLY;
    paramView.oSG = true;
    paramView.requestLayout();
    paramView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ActivityTestMultilineEllipse.1
 * JD-Core Version:    0.7.0.1
 */