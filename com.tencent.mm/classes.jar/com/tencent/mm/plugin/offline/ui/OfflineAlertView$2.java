package com.tencent.mm.plugin.offline.ui;

import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

final class OfflineAlertView$2
  implements Runnable
{
  OfflineAlertView$2(OfflineAlertView paramOfflineAlertView, TextView paramTextView, CheckBox paramCheckBox) {}
  
  public final void run()
  {
    AppMethodBeat.i(217191);
    if (this.GDF.getLineCount() > 1)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.GDG.getLayoutParams();
      if (localLayoutParams != null)
      {
        int i = (this.GDF.getLineHeight() - a.fromDPToPix(this.GDE.getContext(), 15)) / 2;
        int j = a.fromDPToPix(this.GDE.getContext(), 2);
        localLayoutParams.gravity = 48;
        localLayoutParams.topMargin = (i + j);
        this.GDG.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(217191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.2
 * JD-Core Version:    0.7.0.1
 */