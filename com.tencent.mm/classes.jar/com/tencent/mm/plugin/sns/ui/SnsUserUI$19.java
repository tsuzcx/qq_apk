package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.z;

final class SnsUserUI$19
  implements Runnable
{
  SnsUserUI$19(SnsUserUI paramSnsUserUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(187759);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int j = z.aQ(this.xLe);
    if (z.ip(this.xLe)) {}
    for (int i = this.xLe.getResources().getDimensionPixelSize(2131165252);; i = this.xLe.getResources().getDimensionPixelSize(2131165251))
    {
      localLayoutParams.topMargin = (i + j);
      SnsUserUI.p(this.xLe).setLayoutParams(localLayoutParams);
      AppMethodBeat.o(187759);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.19
 * JD-Core Version:    0.7.0.1
 */