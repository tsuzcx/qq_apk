package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.x;

final class SnsUserUI$16
  implements Runnable
{
  SnsUserUI$16(SnsUserUI paramSnsUserUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39806);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int j = x.at(this.sce);
    if (x.gN(this.sce)) {}
    for (int i = this.sce.getResources().getDimensionPixelSize(2131427559);; i = this.sce.getResources().getDimensionPixelSize(2131427558))
    {
      localLayoutParams.topMargin = (i + j);
      SnsUserUI.k(this.sce).setLayoutParams(localLayoutParams);
      AppMethodBeat.o(39806);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.16
 * JD-Core Version:    0.7.0.1
 */