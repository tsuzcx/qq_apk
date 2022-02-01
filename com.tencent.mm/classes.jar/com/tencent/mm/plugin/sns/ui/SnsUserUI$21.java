package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;

final class SnsUserUI$21
  implements Runnable
{
  SnsUserUI$21(SnsUserUI paramSnsUserUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(99659);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int j = KeyBoardUtil.getStatusHeight(this.REI);
    if (KeyBoardUtil.isPortOrientation(this.REI)) {}
    for (int i = this.REI.getResources().getDimensionPixelSize(b.d.DefaultActionbarHeightPort);; i = this.REI.getResources().getDimensionPixelSize(b.d.DefaultActionbarHeightLand))
    {
      localLayoutParams.topMargin = (i + j);
      SnsUserUI.p(this.REI).setLayoutParams(localLayoutParams);
      AppMethodBeat.o(99659);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.21
 * JD-Core Version:    0.7.0.1
 */