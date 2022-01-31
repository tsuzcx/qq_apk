package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

final class AtContactWidget$2
  implements Runnable
{
  AtContactWidget$2(AtContactWidget paramAtContactWidget) {}
  
  public final void run()
  {
    AppMethodBeat.i(38151);
    int i = (int)(d.aow().density * 36.0F);
    if (i != 0)
    {
      i = (AtContactWidget.b(this.rFh).getWidth() - AtContactWidget.c(this.rFh).getWidth() - AtContactWidget.d(this.rFh).getWidth() - (int)(d.aow().density * 32.0F)) / i;
      if ((i > 0) && (i < 5))
      {
        AtContactWidget.e(this.rFh).setLineNum(i);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)AtContactWidget.e(this.rFh).getLayoutParams();
        localLayoutParams.alignWithParent = true;
        AtContactWidget.e(this.rFh).setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(38151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AtContactWidget.2
 * JD-Core Version:    0.7.0.1
 */