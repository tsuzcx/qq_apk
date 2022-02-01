package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.z;

final class SnsUserUI$18
  implements Runnable
{
  SnsUserUI$18(SnsUserUI paramSnsUserUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(198496);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int j = z.aU(this.ApE);
    if (z.iK(this.ApE)) {}
    for (int i = this.ApE.getResources().getDimensionPixelSize(2131165252);; i = this.ApE.getResources().getDimensionPixelSize(2131165251))
    {
      localLayoutParams.topMargin = (i + j);
      SnsUserUI.p(this.ApE).setLayoutParams(localLayoutParams);
      AppMethodBeat.o(198496);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.18
 * JD-Core Version:    0.7.0.1
 */