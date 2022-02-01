package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.y;

final class SnsUserUI$19
  implements Runnable
{
  SnsUserUI$19(SnsUserUI paramSnsUserUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(200628);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int j = y.aU(this.yXT);
    if (y.iA(this.yXT)) {}
    for (int i = this.yXT.getResources().getDimensionPixelSize(2131165252);; i = this.yXT.getResources().getDimensionPixelSize(2131165251))
    {
      localLayoutParams.topMargin = (i + j);
      SnsUserUI.p(this.yXT).setLayoutParams(localLayoutParams);
      AppMethodBeat.o(200628);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.19
 * JD-Core Version:    0.7.0.1
 */