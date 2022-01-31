package com.tencent.mm.pluginsdk.ui.tools;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

final class p$1$1
  implements Runnable
{
  p$1$1(p.1 param1, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(70412);
    int j = this.bTJ.getResources().getDisplayMetrics().heightPixels - this.bTJ.getHeight() >>> 1;
    int i = (int)(j / 1.618D - (this.wfN.wfM.getHeight() >>> 1));
    if (i >= 0)
    {
      if (p.access$000() < 0) {
        p.access$002(BackwardSupportUtil.b.b(this.bTJ.getContext(), 20.0F));
      }
      if (this.wfN.wfM.getHeight() + i + p.access$000() <= j) {
        break label192;
      }
      i -= this.wfN.wfM.getHeight() + i + p.access$000() - j;
    }
    label192:
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.wfN.wfM.getLayoutParams();
      if ((i > 0) && (i != localLayoutParams.bottomMargin))
      {
        ab.i("VideoSightHelper", "setting tip marginBottom ".concat(String.valueOf(i)));
        localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
        this.wfN.wfM.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(70412);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.p.1.1
 * JD-Core Version:    0.7.0.1
 */