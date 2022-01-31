package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ActivityTestMultilineEllipse$1
  implements View.OnClickListener
{
  ActivityTestMultilineEllipse$1(ActivityTestMultilineEllipse paramActivityTestMultilineEllipse, QTextView paramQTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38044);
    if (this.rDJ.getIsExpanded())
    {
      paramView = this.rDJ;
      paramView.kiY = false;
      paramView.requestLayout();
      paramView.invalidate();
      AppMethodBeat.o(38044);
      return;
    }
    paramView = this.rDJ;
    paramView.kiY = true;
    paramView.requestLayout();
    paramView.invalidate();
    AppMethodBeat.o(38044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ActivityTestMultilineEllipse.1
 * JD-Core Version:    0.7.0.1
 */